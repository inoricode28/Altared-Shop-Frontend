// usuarioModel.js

import mysql from "mysql2/promise";
import config from "./../config";

const createClienteTableAndData = async () => {
    try {
        const dbConnection = await mysql.createConnection({
            host: config.host,
            database: config.database,
            user: config.user,
            password: config.password
        });

        const [rows, fields] = await dbConnection.execute(`SHOW TABLES LIKE 'Cliente'`);

        if (rows.length === 0) {
            await dbConnection.execute(`
            CREATE TABLE Cliente (
                id          INT             AUTO_INCREMENT  PRIMARY KEY,
                Nombre      VARCHAR(100)    NOT NULL,
                Apellido    VARCHAR(100)    NOT NULL,
                DNI         VARCHAR(20)     NOT NULL,
                Celular     VARCHAR(20)     NOT NULL,
                Correo      VARCHAR(100)    NOT NULL
            );
            `);
            console.log(`Tabla 'Cliente' creada exitosamente.`);
            
            await dbConnection.execute(`
            INSERT INTO Cliente (Nombre, Apellido, DNI, Celular, Correo) VALUES
            ('Juan', 'Perez', '12345678', '987654321', 'juan@example.com'),
            ('María', 'González', '87654321', '123456789', 'maria@example.com'),
            ('Pedro', 'Lopez', '45678901', '654987321', 'pedro@example.com');
            `);
            console.log(`Datos insertados en la tabla 'Cliente'.`);
        } else {
            console.log(`La tabla 'Cliente' ya existe.`);
        }

        await dbConnection.end();
    } catch (error) {
        console.error('Error al crear o verificar la tabla Cliente:', error.message);
        throw error;
    }
};

export default createClienteTableAndData;
