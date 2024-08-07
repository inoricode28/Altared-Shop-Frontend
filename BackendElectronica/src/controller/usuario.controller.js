// usuario.controller.js
import { getConnection } from "./../database/conexcion";

const getUsuarios = async (req, res) => {
    try {
        const connection = await getConnection();
        const [rows] = await connection.query("SELECT id, correo, user, pass FROM Usuario");
        console.log(rows); // Solo los datos de los usuarios
        res.json(rows); // Envía solo los datos de los usuarios al cliente
    } catch (error) {
        res.status(500).send(error.message);
    }
};



const getUsuario = async (req, res) => {
    try {
        const { id } = req.params;
        const connection = await getConnection();
        const [rows] = await connection.query("SELECT id, correo, user, pass FROM Usuario WHERE id = ?", id);
        console.log(rows); // Solo los datos del usuario solicitado
        res.json(rows); // Envía solo los datos del usuario solicitado al cliente
    } catch (error) {
        res.status(500).send(error.message);
    }
};

const addUsuario = async (req, res) => {
    try {
        const { correo, user, pass } = req.body;

        if (correo === undefined || user === undefined || pass === undefined) {
            res.status(400).json({ message: "Bad Request. Please fill all fields." });
            return;
        }

        const usuario = { correo, user, pass };
        const connection = await getConnection();
        await connection.query("INSERT INTO Usuario SET ?", usuario);
        res.json({ rpta: true, mensaje: "La persona fue registrada correctamente." });
    } catch (error) {
        res.status(500).send(error.message);
    }
};

const updateUsuario = async (req, res) => {
    try {
        const { id } = req.params;
        const { correo, user, pass } = req.body;

        if (correo === undefined || user === undefined || pass === undefined) {
            res.status(400).json({ message: "Bad Request. Please fill all fields." });
            return;
        }

        const usuario = { correo, user, pass };
        const connection = await getConnection();
        const result = await connection.query("UPDATE Usuario SET ? WHERE id = ?", [usuario, id]);
        console.log(result);
        res.json(result);
    } catch (error) {
        res.status(500).send(error.message);
    }
};

const deleteUsuario = async (req, res) => {
    try {
        const { id } = req.params;
        const connection = await getConnection();
        const result = await connection.query("DELETE FROM Usuario WHERE id = ?", id);
        console.log(result);
        res.json(result);
    } catch (error) {
        res.status(500).send(error.message);
    }
};

export const methods = {
    getUsuarios,
    getUsuario,
    addUsuario,
    updateUsuario,
    deleteUsuario
};
