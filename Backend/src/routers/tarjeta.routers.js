// tarjeta.routes.js
import { Router } from "express";
import { methods as tarjetaController } from "./../controller/tarjeta.controller";

const router = Router();

router.get("/", tarjetaController.getTarjetas);
router.get("/:id", tarjetaController.getTarjeta);
router.post("/", tarjetaController.addTarjeta);
router.put("/:id", tarjetaController.updateTarjeta);
router.delete("/:id", tarjetaController.deleteTarjeta);

export default router;
