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
                Precio      VARCHAR(100)    NOT NULL,  -- Modificación de DECIMAL a VARCHAR(100)
                Cantidad    VARCHAR(100)    NOT NULL,  -- Modificación de INT a VARCHAR(100)
                Descripcion TEXT,
                Imagen      VARCHAR(255)    NOT NULL
            );
            `);
            console.log(`Tabla 'Productos' creada exitosamente.`);
            
            await dbConnection.execute(`
            INSERT INTO Productos (Nombre, Precio, Cantidad, Descripcion, Imagen) VALUES
            ('Dermatologico', '50.00', '20', 'Sabor frambuesa', 'http://${config.host}:${config.port}/uploads/default1.jpg'),
            ('Nutricional', '50.00', '20', 'Sabor neutro', 'http://${config.host}:${config.port}/uploads/default2.jpg'),
            ('Odontológico', '50.00', '20', 'Sabor fresa', 'http://${config.host}:${config.port}/uploads/default3.jpg'),
            ('Cosmetologico', '50.00', '20', 'Sabor fresa', 'http://${config.host}:${config.port}/uploads/default4.jpg'),
            ('Collagsure Flex 500g', '50.00', '20', 'Sabor fresa', 'http://${config.host}:${config.port}/uploads/default5.jpg'),
            ('Collagsure Puro 500g', '50.00', '20', 'Sabor fresa', 'http://${config.host}:${config.port}/uploads/default6.jpg'),
            ('Collagsure Q10 500g', '50.00', '20', 'Sabor fresa', 'http://${config.host}:${config.port}/uploads/default7.jpg');
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
