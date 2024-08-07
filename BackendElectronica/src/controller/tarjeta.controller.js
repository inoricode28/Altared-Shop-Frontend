// tarjeta.controller.js
import { getConnection } from "./../database/conexcion"; // Corregí el nombre 'conexion'

const getTarjetas = async (req, res) => {
    try {
        const connection = await getConnection();
        const [rows] = await connection.query("SELECT id, nombre, numeroTarjeta, fecha, anio, CCV FROM Tarjeta");
        console.log(rows); // Solo los datos de las tarjetas
        res.json(rows); // Envía solo los datos de las tarjetas al cliente
    } catch (error) {
        res.status(500).send(error.message);
    }
};

const getTarjeta = async (req, res) => {
    try {
        const { id } = req.params;
        const connection = await getConnection();
        const [rows] = await connection.query("SELECT id, nombre, numeroTarjeta, fecha, anio, CCV FROM Tarjeta WHERE id = ?", [id]);
        console.log(rows); // Solo los datos de la tarjeta solicitada
        res.json(rows); // Envía solo los datos de la tarjeta solicitada al cliente
    } catch (error) {
        res.status(500).send(error.message);
    }
};

const addTarjeta = async (req, res) => {
    try {
        const { nombre, numeroTarjeta, fecha, anio, CCV } = req.body;

        if (!nombre || !numeroTarjeta || !fecha || !anio || !CCV) {
            res.status(400).json({ message: "Bad Request. Please fill all fields." });
            return;
        }

        const tarjeta = { nombre, numeroTarjeta, fecha, anio, CCV };
        const connection = await getConnection();
        await connection.query("INSERT INTO Tarjeta SET ?", tarjeta);
        res.json({ rpta: true, mensaje: "Tarjeta Registrada Correctamente." });
    } catch (error) {
        res.status(500).send(error.message);
    }
};

const updateTarjeta = async (req, res) => {
    try {
        const { id } = req.params;
        const { nombre, numeroTarjeta, fecha, anio, CCV } = req.body;

        if (!nombre || !numeroTarjeta || !fecha || !anio || !CCV) {
            res.status(400).json({ message: "Bad Request. Please fill all fields." });
            return;
        }

        const tarjeta = { nombre, numeroTarjeta, fecha, anio, CCV };
        const connection = await getConnection();
        const [result] = await connection.query("UPDATE Tarjeta SET ? WHERE id = ?", [tarjeta, id]);
        console.log(result);
        res.json({ message: "Tarjeta actualizada", affectedRows: result.affectedRows });
    } catch (error) {
        res.status(500).send(error.message);
    }
};

const deleteTarjeta = async (req, res) => {
    try {
        const { id } = req.params;
        const connection = await getConnection();
        const [result] = await connection.query("DELETE FROM Tarjeta WHERE id = ?", [id]);
        console.log(result);
        res.json({ message: "Tarjeta eliminada", affectedRows: result.affectedRows });
    } catch (error) {
        res.status(500).send(error.message);
    }
};

export const methods = {
    getTarjetas,
    getTarjeta,
    addTarjeta,
    updateTarjeta,
    deleteTarjeta
};