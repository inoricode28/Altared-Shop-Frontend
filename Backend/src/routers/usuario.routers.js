// usuario.routes.js
import { Router } from "express";
import { methods as usuarioController} from "./../controller/usuario.controller";
const router=Router();

router.get("/", usuarioController.getUsuarios);
router.get("/:id", usuarioController.getUsuario);
router.post("/", usuarioController.addUsuario);
router.put("/:id", usuarioController.updateUsuario);
router.delete("/:id", usuarioController.deleteUsuario);

export default router;