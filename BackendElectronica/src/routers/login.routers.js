import { Router } from "express";
import { methods as loginController} from "./../controller/login.controller";
const router=Router();

router.post("/", loginController.getLogin);

export default router;