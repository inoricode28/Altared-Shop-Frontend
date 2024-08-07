import app from "./app"
import config from "./config";


const main = () => {
    const port = config.port;
    const host = config.host;
    app.listen(port, host, () => {
        console.log(`Servidor en ejecución en http://${host}:${port}/api/usuario`);
        console.log(`Servidor en ejecución en http://${host}:${port}/api/producto`);
        console.log(`Servidor en ejecución en http://${host}:${port}/api/cliente`);
        console.log(`Servidor en ejecución en http://${host}:${port}/api/tarjeta`);
        
    });
};  

main();