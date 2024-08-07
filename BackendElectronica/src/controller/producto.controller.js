// producto.controller.js
import { getConnection } from "./../database/conexcion";

const getProductos = async (req, res) => {
    try {
        const connection = await getConnection();
        const [rows] = await connection.query({ 
            sql: "SELECT id, Nombre, Precio, Cantidad, Descripcion FROM Productos",
            rowsAsArray: false // Indica que los resultados se devuelvan como un objeto
        });
        console.log(rows); // Solo los datos de los productos
        res.json(rows); // Envía solo los datos de los productos al cliente
    } catch (error) {
        res.status(500).send(error.message);
    }
};

const getProducto = async (req, res) => {
    try {
        console.log(req.params);
        const { id } = req.params;
        const connection = await getConnection();
        const [rows] = await connection.query("SELECT id, Nombre, Precio, Cantidad, Descripcion FROM Productos WHERE id = ?", id);
        console.log(rows); // Solo los datos del producto solicitado
        res.json(rows); // Envía solo los datos del producto solicitado al cliente
    } catch (error) {
        res.status(500).send(error.message);
    }
};


const addProducto = async (req, res) => {
    try {
        const { Nombre, Precio, Cantidad, Descripcion } = req.body;

        if (Nombre === undefined || Precio === undefined || Cantidad === undefined) {
            res.status(400).json({ message: "Bad Request. Please fill all required fields." });
        }

        const producto = { Nombre, Precio, Cantidad, Descripcion };
        const connection = await getConnection();
        await connection.query("INSERT INTO Productos SET ?", producto);
        res.json({ message: "Producto agregado" });
    } catch (error) {
        res.status(500).send(error.message);
    }
};

const updateProducto = async (req, res) => {
    try {
        console.log(req.params);
        const { id } = req.params;
        const { Nombre, Precio, Cantidad, Descripcion } = req.body;

        if (Nombre === undefined || Precio === undefined || Cantidad === undefined) {
            res.status(400).json({ message: "Bad Request. Please fill all required fields." });
        }

        const producto = { Nombre, Precio, Cantidad, Descripcion };

        const connection = await getConnection();
        const result = await connection.query("UPDATE Productos SET ? WHERE id = ?", [producto, id]);
        console.log(result);
        res.json(result);
    } catch (error) {
        res.status(500).send(error.message);
    }
};

const deleteProducto = async (req, res) => {
    try {
        console.log(req.params);
        const { id } = req.params;
        const connection = await getConnection();
        const result = await connection.query("DELETE FROM Productos WHERE id = ?", id);
        console.log(result);
        res.json(result);
    } catch (error) {
        res.status(500).send(error.message);
    }
};

export const methods = {
    getProductos,
    getProducto,
    addProducto,
    updateProducto,
    deleteProducto
};
