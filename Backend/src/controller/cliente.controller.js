// cliente.controller.js
import { getConnection } from "./../database/conexcion";

const getClientes = async (req, res) => {
    try {
        const connection = await getConnection();
        const [rows] = await connection.query({ 
            sql: "SELECT id, Nombre, Apellido, DNI, Celular, Correo FROM Cliente",
            rowsAsArray: false // Indica que los resultados se devuelvan como un objeto
        });
        console.log(rows); // Solo los datos de los clientes
        res.json(rows); // Envía solo los datos de los clientes al cliente
    } catch (error) {
        res.status(500).send(error.message);
    }
};


const getCliente = async (req, res) => {
    try {
        console.log(req.params);
        const { id } = req.params;
        const connection = await getConnection();
        const [rows] = await connection.query({ 
            sql: "SELECT id, Nombre, Apellido, DNI, Celular, Correo FROM Cliente WHERE id = ?", 
            values: [id],
            rowsAsArray: false // Indica que los resultados se devuelvan como un objeto
        });
        console.log(rows);
        res.json(rows);
    } catch (error) {
        res.status(500).send(error.message);
    }
};

const addCliente = async (req, res) => {
    try {
        const { Nombre, Apellido, DNI, Celular, Correo } = req.body;

        if (Nombre === undefined || Apellido === undefined || DNI === undefined || Celular === undefined || Correo === undefined) {
            res.status(400).json({ message: "Bad Request. Please fill all required fields." });
            return;
        }

        const cliente = { Nombre, Apellido, DNI, Celular, Correo };
        const connection = await getConnection();
        await connection.query("INSERT INTO Cliente SET ?", cliente);
        res.json({ message: "Cliente agregado" });
    } catch (error) {
        res.status(500).send(error.message);
    }
};

const updateCliente = async (req, res) => {
    try {
        console.log(req.params);
        const { id } = req.params;
        const { Nombre, Apellido, DNI, Celular, Correo } = req.body;

        if (Nombre === undefined || Apellido === undefined || DNI === undefined || Celular === undefined || Correo === undefined) {
            res.status(400).json({ message: "Bad Request. Please fill all required fields." });
            return;
        }

        const cliente = { Nombre, Apellido, DNI, Celular, Correo };

        const connection = await getConnection();
        const result = await connection.query("UPDATE Cliente SET ? WHERE id = ?", [cliente, id]);
        console.log(result);
        res.json(result);
    } catch (error) {
        res.status(500).send(error.message);
    }
};

const deleteCliente = async (req, res) => {
    try {
        console.log(req.params);
        const { id } = req.params;
        const connection = await getConnection();
        const result = await connection.query("DELETE FROM Cliente WHERE id = ?", id);
        console.log(result);
        res.json(result);
    } catch (error) {
        res.status(500).send(error.message);
    }
};

export const methods = {
    getClientes,
    getCliente,
    addCliente,
    updateCliente,
    deleteCliente
};