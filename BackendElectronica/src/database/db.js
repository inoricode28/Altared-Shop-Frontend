import mysql from "mysql2/promise";
import config from "./../config";
import createUsuarioTableAndData from '../model/usuarioModel';
import createProductosTableAndData from '../model/productoModel';
import createClienteTableAndData from '../model/clienteModel';
import createTarjetaTableAndData from '../model/tarjetaModel';

const createDatabaseAndTableIfNotExists = async () => {
    try {        
        const connection = await mysql.createConnection({
            host: config.host,
            user: config.user,
            password: config.password
        });

        const databaseExists = await connection.execute(`SELECT SCHEMA_NAME FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME = ?`, [config.database]);

        if (databaseExists[0].length === 0) {
            await connection.execute(`CREATE DATABASE ${config.database}`);
            console.log(`Base de datos '${config.database}' creada exitosamente.`);
        } else {
            console.log(`La base de datos '${config.database}' ya existe.`);
        }

        await connection.end();

        await createUsuarioTableAndData(); // Llamada a la función en usuarioModel.js
        await createProductosTableAndData(); // Llamada a la función en productoModel.js
        await createClienteTableAndData(); // Llamada a la función en clienteModel.js
        await createTarjetaTableAndData(); // Llamada a la función en tarjetaModel.js
        
    } catch (error) {
        console.error('Error al crear o verificar la base de datos y la tabla:', error.message);
        throw error;
    }
};

createDatabaseAndTableIfNotExists();

