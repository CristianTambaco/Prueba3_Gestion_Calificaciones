-- Estructura de la Base de Datos

-- Tabla usuarios:

CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

-- Tabla estudiante:

CREATE TABLE estudiantes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cedula VARCHAR(10) NOT NULL UNIQUE,
    nombre VARCHAR(100) NOT NULL,
    estudiante1 DOUBLE NOT NULL,
    estudiante2 DOUBLE NOT NULL,
    estudiante3 DOUBLE NOT NULL,
    estudiante4 DOUBLE NOT NULL,
    estudiante5 DOUBLE NOT NULL
);

