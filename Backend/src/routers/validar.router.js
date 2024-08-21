import { Router } from "express";
import { methods as validarController} from "./../controller/validar.controller";
const router=Router();


router.post("/", validarController.validateCCV);
export default router;