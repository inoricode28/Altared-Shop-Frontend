// Importar la función de conexión a la base de datos
import { getConnection } from "../database/conexcion";

// Función para obtener una tarjeta por CCV
const getTarjetaByCCV = async (CCV) => {
    try {
        const connection = await getConnection();
        const [rows] = await connection.query("SELECT * FROM Tarjeta WHERE CCV = ?", [CCV]);
        return rows.length > 0 ? rows[0] : null; // Retorna la tarjeta si el CCV es encontrado
    } catch (error) {
        console.error('Error al obtener la tarjeta:', error.message);
        throw error;
    }
};

// Controlador para validar el CCV de la tarjeta
const validateCCV = async (req, res) => {
    try {
        const { CCV } = req.body;

        if (!CCV) {
            res.status(400).json({ rpta: false, mensaje: "Por favor, proporcione el CCV." });
            return;
        }

        const tarjeta = await getTarjetaByCCV(CCV);

        if (tarjeta) {
            res.json({
                id: tarjeta.id,
                nombre: tarjeta.nombre,
                numeroTarjeta: tarjeta.numeroTarjeta,
                fecha: tarjeta.fecha,
                anio: tarjeta.anio,
                CCV: tarjeta.CCV,
                rpta: true,
                mensaje: "Compra autenticada"
            });
        } else {
            res.json({ rpta: false, mensaje: "CCV no válido." });
        }
    } catch (error) {
        res.status(500).send(error.message);
    }
};


export const methods = {   
    validateCCV    
};