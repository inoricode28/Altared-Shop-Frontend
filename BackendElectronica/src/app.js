import express from "express";
import morgan from "morgan";

import loginRouters from "./routers/login.routers"
import usuarioRouters from "./routers/usuario.routers"
import productoRouters from "./routers/producto.routers"
import clienteRouters from "./routers/cliente.routers"
import tarjetaRouters from "./routers/tarjeta.routers"
import validarRouters from "./routers/validar.router"


const app=express();

//Middlewares
app.use(morgan("dev"));
app.use(express.json());

//Routes

app.use("/api/login",loginRouters);
app.use("/api/usuario",usuarioRouters);
app.use("/api/producto",productoRouters);
app.use("/api/cliente",clienteRouters);
app.use("/api/tarjeta",tarjetaRouters);
app.use("/api/ccv",validarRouters);

export default app;