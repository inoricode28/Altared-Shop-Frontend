// productosModel.js

import mysql from "mysql2/promise";
import config from "./../config";

const createProductosTableAndData = async () => {
    try {
        const dbConnection = await mysql.createConnection({
            host: config.host,
            database: config.database,
            user: config.user,
            password: config.password
        });

        const [rows, fields] = await dbConnection.execute(`SHOW TABLES LIKE 'Productos'`);

        if (rows.length === 0) {
            await dbConnection.execute(`
            CREATE TABLE Productos (
                id          INT             AUTO_INCREMENT  PRIMARY KEY,
                Nombre      VARCHAR(100)    NOT NULL,
                Precio      DECIMAL(10, 2)  NOT NULL,
                Cantidad    INT             NOT NULL,
                Descripcion TEXT
            );
            `);
            console.log(`Tabla 'Productos' creada exitosamente.`);
            
            await dbConnection.execute(`
            INSERT INTO Productos (Nombre, Precio, Cantidad, Descripcion) VALUES
            ('Producto 1', 10.99, 100, 'Descripción del producto 1'),
            ('Producto 2', 20.50, 50, 'Descripción del producto 2'),
            ('Producto 3', 5.75, 200, 'Descripción del producto 3');
            `);
            console.log(`Datos insertados en la tabla 'Productos'.`);
        } else {
            console.log(`La tabla 'Productos' ya existe.`);
        }

        await dbConnection.end();
    } catch (error) {
        console.error('Error al crear o verificar la tabla Productos:', error.message);
        throw error;
    }
};

export default createProductosTableAndData;
