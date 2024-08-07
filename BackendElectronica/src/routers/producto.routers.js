// producto.routes.js
import { Router } from "express";
import { methods as productoController } from "./../controller/producto.controller";

const router = Router();

router.get("/", productoController.getProductos);
router.get("/:id", productoController.getProducto);
router.post("/", productoController.addProducto);
router.put("/:id", productoController.updateProducto);
router.delete("/:id", productoController.deleteProducto);

export default router;
