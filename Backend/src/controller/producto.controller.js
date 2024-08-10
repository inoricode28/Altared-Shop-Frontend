import { getConnection } from "./../database/conexcion";
import path from "path";
import fs from "fs";
import config from "./../config";

// Función para obtener todos los productos
const getProductos = async (req, res) => {
    try {
        const connection = await getConnection();
        const [rows] = await connection.query("SELECT id, Nombre, Precio, Cantidad, Descripcion, Imagen FROM Productos");
        res.json(rows);
    } catch (error) {
        res.status(500).send(error.message);
    }
};

// Función para obtener un producto por su ID
const getProducto = async (req, res) => {
    try {
        const { id } = req.params;
        const connection = await getConnection();
        const [rows] = await connection.query("SELECT id, Nombre, Precio, Cantidad, Descripcion, Imagen FROM Productos WHERE id = ?", [id]);
        res.json(rows[0]);
    } catch (error) {
        res.status(500).send(error.message);
    }
};

// Función para agregar un producto con imagen
const addProducto = async (req, res) => {
    try {
        const { Nombre, Precio, Cantidad, Descripcion } = req.body;
        const Imagen = req.file ? `http://${config.host}:${config.port}/uploads/${req.file.filename}` : null;

        // Validar que todos los campos requeridos estén completos
        if (!Nombre || !Precio || !Cantidad || !Imagen) {
            return res.status(400).json({ message: "Por favor completa todos los campos requeridos." });
        }

        const producto = { Nombre, Precio, Cantidad, Descripcion, Imagen };
        const connection = await getConnection();
        await connection.query("INSERT INTO Productos SET ?", producto);
        res.json({ message: "Producto agregado con éxito" });
    } catch (error) {
        res.status(500).send(error.message);
    }
};

// Función para actualizar un producto con imagen
const updateProducto = async (req, res) => {
    try {
        const { id } = req.params;
        const { Nombre, Precio, Cantidad, Descripcion } = req.body;
        const connection = await getConnection();

        // Obtener la imagen actual del producto antes de actualizar
        const [rows] = await connection.query("SELECT Imagen FROM Productos WHERE id = ?", [id]);
        const currentImage = rows[0]?.Imagen;

        const Imagen = req.file ? `http://${config.host}:${config.port}/uploads/${req.file.filename}` : null;

        // Validar que todos los campos requeridos estén completos
        if (!Nombre || !Precio || !Cantidad) {
            return res.status(400).json({ message: "Por favor completa todos los campos requeridos." });
        }

        // Si hay una nueva imagen y existe una imagen anterior, eliminar la imagen anterior del servidor
        if (Imagen && currentImage) {
            const imageName = path.basename(currentImage);  // Extraer solo el nombre del archivo
            const imagePath = path.join(__dirname, '../../uploads', imageName);
            if (fs.existsSync(imagePath)) {
                fs.unlink(imagePath, (err) => {
                    if (err) console.error('Error al eliminar la imagen anterior:', err);
                });
            }
        }

        // Crear el objeto producto a actualizar
        const producto = Imagen ? { Nombre, Precio, Cantidad, Descripcion, Imagen } : { Nombre, Precio, Cantidad, Descripcion };
        await connection.query("UPDATE Productos SET ? WHERE id = ?", [producto, id]);

        res.json({ message: "Producto actualizado con éxito" });
    } catch (error) {
        res.status(500).send(error.message);
    }
};

// Función para eliminar una imagen de la carpeta uploads
const eliminarImagen = async (id) => {
    try {
        const connection = await getConnection();
        const [rows] = await connection.query("SELECT Imagen FROM Productos WHERE id = ?", [id]);
        const currentImage = rows[0]?.Imagen;

        if (currentImage) {
            const imageName = path.basename(currentImage);  // Extraer solo el nombre del archivo
            const imagePath = path.join(__dirname, '../../uploads', imageName);

            console.log(`Nombre de la imagen: ${imageName}`);
            //console.log(`Ruta completa de la imagen: ${imagePath}`);

            if (fs.existsSync(imagePath)) {
                fs.unlinkSync(imagePath);  // Eliminar la imagen de forma sincrónica
                console.log(`Imagen ${imageName} eliminada correctamente.`);
            } else {
                console.log(`La imagen ${imageName} no existe en la carpeta uploads.`);
            }
        } else {
            console.log("No se encontró la imagen asociada con el ID proporcionado.");
        }
    } catch (error) {
        console.error("Error al intentar eliminar la imagen:", error.message);
    }
};

// Función para eliminar un producto
const deleteProducto = async (req, res) => {
    try {
        const { id } = req.params;

        // Llamar a la función para eliminar la imagen asociada al producto
        await eliminarImagen(id);

        const connection = await getConnection();
        const result = await connection.query("DELETE FROM Productos WHERE id = ?", [id]);
        //console.log(result);
        res.json({ message: "Producto eliminado con éxito" });
        

    } catch (error) {
        res.status(500).send(error.message);
    }
};


// Exportar todas las funciones
export const methods = {
    getProductos,
    getProducto,
    addProducto,
    updateProducto,
    deleteProducto
};
