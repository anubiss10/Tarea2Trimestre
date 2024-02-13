-- SQLBook: Code


-- Crear la tabla clientes
CREATE TABLE clientes (
    id_Cliente INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(30),
    apellidos VARCHAR(30),
    telefono VARCHAR(30),
    email VARCHAR(30)
);

-- Crear la tabla seguros
CREATE TABLE seguros (
    idSeguro INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(30)
);

-- Crear la tabla aseguradoras
CREATE TABLE aseguradoras (
    id_aseguradora INT PRIMARY KEY AUTO_INCREMENT,
    cif VARCHAR(30),
    nombre VARCHAR(30),
    localizacion VARCHAR(30)
);

-- Crear la tabla clientesSeguros
CREATE TABLE clientesSeguros (
    idCliente INT,
    idSeguro INT,
    PRIMARY KEY (idCliente, idSeguro),
    FOREIGN KEY (idCliente) REFERENCES clientes(idCliente),
    FOREIGN KEY (idSeguro) REFERENCES seguros(idSeguro)
);

-- Crear la tabla segurosAseguradora
CREATE TABLE segurosAseguradora (
    idAseguradora INT,
    idSeguro INT,
    PRIMARY KEY (idAseguradora, idSeguro),
    FOREIGN KEY (idAseguradora) REFERENCES aseguradoras(idAseguradora),
    FOREIGN KEY (idSeguro) REFERENCES seguros(idSeguro)
);

