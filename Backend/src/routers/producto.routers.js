import { Router } from "express";
import { methods as productoController } from "./../controller/producto.controller";
import multer from "multer";
import path from "path";

// Configuración de multer para guardar las imágenes en la carpeta 'uploads'
const storage = multer.diskStorage({
    destination: (req, file, cb) => {
        cb(null, 'uploads/'); // Carpeta donde se guardarán las imágenes
    },
    filename: (req, file, cb) => {
        const ext = path.extname(file.originalname);
        cb(null, `${Date.now()}${ext}`); // Renombrar el archivo para evitar duplicados
    }
});

// Filtro para permitir solo archivos de imagen
const fileFilter = (req, file, cb) => {
    const filetypes = /jpeg|jpg|png|gif/;
    const extname = filetypes.test(path.extname(file.originalname).toLowerCase());
    const mimetype = filetypes.test(file.mimetype);

    if (mimetype && extname) {
        return cb(null, true);
    } else {
        cb(new Error("Solo se permiten imágenes"));
    }
};

const upload = multer({
    storage,
    fileFilter,
    limits: { fileSize: 5 * 1024 * 1024 } // Limite de 5MB por archivo
});

const router = Router();

router.get("/", productoController.getProductos);
router.get("/:id", productoController.getProducto);
router.post("/", upload.single('Imagen'), productoController.addProducto); // Ruta para añadir un producto con imagen
router.put("/:id", upload.single('Imagen'), productoController.updateProducto); // Ruta para actualizar un producto con imagen
router.delete("/:id", productoController.deleteProducto);

export default router;
