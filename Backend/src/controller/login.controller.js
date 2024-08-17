// login.controller.js
import { getConnection } from "./../database/conexcion";

// Función para autenticar un usuario
const authenticateUsuario = async (user, pass) => {
    try {
        const connection = await getConnection(); // Obtener la conexión
        const [rows] = await connection.query("SELECT id, correo, celular, nombre, apellido ,user, pass FROM Usuario WHERE user = ? AND pass = ?", [user, pass]);
        return rows.length === 1 ? rows[0] : null;
    } catch (error) {
        console.error('Error al autenticar usuario:', error.message);
        throw error;
    }
};

// Controlador para obtener un usuario
const getLogin = async (req, res) => {
    try {
        const { user, pass } = req.body;

        if (!user || !pass) {
            res.status(400).json({ rpta: false, mensaje: "Por favor, proporcione el usuario y la contraseña." });
            return;
        }

        const usuario = await authenticateUsuario(user, pass);

        if (usuario) {
            res.json({ id: usuario.id, correo: usuario.correo, celular: usuario.celular, nombre: usuario.nombre, apellido: usuario.apellido, user: usuario.user, pass: usuario.pass, rpta: true, mensaje: "Usuario autenticado." });
        } else {
            res.json({ rpta: false, mensaje: "El usuario o la contraseña es incorrecto." });
        }
    } catch (error) {
        res.status(500).send(error.message);
    }
};



export const methods = {   
    getLogin,
    
};
