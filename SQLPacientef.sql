USE [paciente]
GO
CREATE DATABASE [paciente]
GO
USE [paciente]
GO

CREATE TABLE LugarResidencia  (
    IdLugar INT PRIMARY KEY IDENTITY(1,1),
    Nombre VARCHAR(150) NOT NULL,
    CodigoPostal VARCHAR(10),
    Zona VARCHAR(100)
);
GO

CREATE TABLE Pacientes (
    DNI CHAR(8) PRIMARY KEY,
    Nombres VARCHAR(100) NOT NULL,
    Apellidos VARCHAR(100) NOT NULL,
    FechaNacimiento VARCHAR(100) NOT NULL,
    IdLugar INT NOT NULL,
    FOREIGN KEY (IdLugar) REFERENCES LugarResidencia(IdLugar)
);
GO

CREATE TABLE Vacunas_Catalogo (
    IdVacuna INT PRIMARY KEY IDENTITY(1,1),
    Nombre VARCHAR(100) NOT NULL,
    Fabricante VARCHAR(100),
    Dosis VARCHAR(50)
);
GO

CREATE TABLE Vacunas (
    IdVacunaAplicada INT PRIMARY KEY IDENTITY(1,1),
    DNIPaciente CHAR(8) NOT NULL,
    IdVacuna INT NOT NULL, 
    FechaAplicacion VARCHAR(100) NOT NULL,
    Lote VARCHAR(50),
    PersonalQueAplico VARCHAR(100),
    FOREIGN KEY (DNIPaciente) REFERENCES Pacientes(DNI),
    FOREIGN KEY (IdVacuna) REFERENCES Vacunas_Catalogo(IdVacuna)
);
CREATE TABLE Constancias (
    IdConstancia INT PRIMARY KEY IDENTITY(1,1),
    DNIPaciente CHAR(8) NOT NULL,
    FechaEmision VARCHAR(100) NOT NULL,
    Observaciones VARCHAR(MAX),
    FOREIGN KEY (DNIPaciente) REFERENCES Pacientes(DNI)
);
GO
INSERT INTO LugarResidencia (Nombre, CodigoPostal, Zona) VALUES
('Comas', '15311', 'Lima Norte'),
('Los Olivos', '15314', 'Lima Norte'),
('Independencia', '15315', 'Lima Norte'),
('San Martín de Porres', '15107', 'Lima Norte'),
('Carabayllo', '15316', 'Lima Norte'),
('Puente Piedra', '15434', 'Lima Norte'),
('Ventanilla', '07001', 'Lima Norte');

INSERT INTO Pacientes(DNI, Nombres, Apellidos, FechaNacimiento, IdLugar)
VALUES
('10000001', 'Carlos', 'Ramírez', '1980-01-15', 1), 
('10000002', 'Ana', 'Torres', '1992-03-22', 2),   
('10000003', 'Luis', 'Fernández', '1975-07-08', 3),
('10000004', 'Sofía', 'Mendoza', '1988-11-30', 4), 
('10000005', 'Jorge', 'Salazar',  '1995-05-05', 5),  
('10000006', 'Marina', 'Vargas', '1983-09-17', 6), 
('10000007', 'Diego', 'Castillo', '1990-12-12', 7);  

INSERT INTO Vacunas_Catalogo (Nombre, Fabricante, Dosis) VALUES
('Vacuna COVID-19', 'Pfizer', '2 dosis'),
('Vacuna Influenza', 'Sanofi', '1 dosis'),
('Vacuna Hepatitis B', 'GSK', '3 dosis');
GO

INSERT INTO Vacunas(DNIPaciente, IdVacuna, FechaAplicacion, Lote, PersonalQueAplico)
VALUES
('10000001', 1, '2021-05-10', 'L1234', 'Dr. López'),
('10000001', 3, '2021-07-15', 'H5678', 'Enfermera Ruiz'),
('10000002', 2, '2022-03-15', 'I9012', 'Dr. Pérez'),
('10000003', 1, '2021-06-22', 'L4321', 'Dr. Gómez'),
('10000004', 3, '2021-09-05', 'H3456', 'Enfermera Flores'),
('10000005', 1, '2022-01-20', 'L7890', 'Dr. Jiménez'),
('10000006', 2, '2022-04-10', 'I3456', 'Enfermera Sánchez'),
('10000007', 1, '2021-12-12', 'L6789', 'Dr. Castillo');
GO


GO
DECLARE @dni CHAR(8) = '12345678';

SELECT 
    p.Nombres + ' ' + p.Apellidos AS NombreCompleto,
    p.FechaNacimiento,
    lr.Nombre AS LugarResidencia,
    v.Nombre AS Vacuna,
    vcat.Fabricante,
    vcat.Dosis,
    v.FechaAplicacion,
    v.Lote,
    v.PersonalQueAplico
FROM Pacientes p
INNER JOIN LugarResidencia lr ON p.IdLugar = lr.IdLugar
INNER JOIN Vacunas v ON p.DNI = v.DNIPaciente
INNER JOIN Vacunas_Catalogo vcat ON v.IdVacuna = vcat.IdVacuna
WHERE p.DNI = @dni
ORDER BY v.FechaAplicacion;

SELECT*FROM Pacientes;
DELETE FROM Pacientes
WHERE IdLugar = '7';

SELECT*FROM Vacunas;

DELETE FROM Vacunas
WHERE IdVacunaAplicada = '62';

SELECT*FROM Constancias;
DELETE FROM Constancias
WHERE DNIPaciente = '70779010';

SELECT * FROM Pacientes WHERE FechaNacimiento > '1990-01-01';
SELECT *FROM Pacientes WHERE Nombres LIKE '%a%';
SELECT 
    p.DNI,
    p.Nombres AS Nombre_Paciente,
    p.Apellidos,
    p.FechaNacimiento,
    lr.Nombre AS Lugar_Residencia,
    lr.CodigoPostal,
    lr.Zona
FROM Pacientes p
INNER JOIN LugarResidencia lr ON p.IdLugar = lr.IdLugar;


SELECT*FROM Pacientes;


SELECT*FROM Vacunas;



SELECT*FROM Constancias;
