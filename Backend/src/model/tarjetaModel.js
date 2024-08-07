// tarjetaModel.js

import mysql from "mysql2/promise";
import config from "./../config";

const createTarjetaTableAndData = async () => {
    try {
        const dbConnection = await mysql.createConnection({
            host: config.host,
            database: config.database,
            user: config.user,
            password: config.password
        });

        const [rows] = await dbConnection.execute(`SHOW TABLES LIKE 'Tarjeta'`);

        if (rows.length === 0) {
            await dbConnection.execute(`
            CREATE TABLE Tarjeta (
                id                      INT AUTO_INCREMENT  PRIMARY KEY,
                nombre                  VARCHAR(100)        NOT NULL,
                numeroTarjeta           VARCHAR(20)         NOT NULL,
                fecha                   VARCHAR(50)         NOT NULL,
                anio                    VARCHAR(50)         NOT NULL,
                CCV                     VARCHAR(5)          NOT NULL
            );
            `);
            console.log(`Tabla 'Tarjeta' creada exitosamente.`);
            
            await dbConnection.execute(`
            INSERT INTO Tarjeta (nombre, numeroTarjeta, fecha, anio, CCV) VALUES
            ('Tarjeta Principal', '1234567890123456', '03/24', '2024', '123'),
            ('Tarjeta Secundaria', '9876543210987654', '12/25', '2025', '456');
            `);
            console.log(`Datos insertados en la tabla 'Tarjeta'.`);
        } else {
            console.log(`La tabla 'Tarjeta' ya existe.`);
        }

        await dbConnection.end();
    } catch (error) {
        console.error('Error al crear o verificar la tabla Tarjeta:', error.message);
        throw error;
    }
};

export default createTarjetaTableAndData;
