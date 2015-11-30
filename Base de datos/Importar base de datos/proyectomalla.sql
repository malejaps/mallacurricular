-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 19-06-2012 a las 18:53:31
-- Versión del servidor: 5.5.8
-- Versión de PHP: 5.3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `proyectomalla`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignaturas`
--

CREATE TABLE IF NOT EXISTS `asignaturas` (
  `cod_asig` varchar(11) NOT NULL,
  `nom_asig` varchar(30) NOT NULL,
  `creditos` int(11) NOT NULL,
  `intensidad_h` int(11) NOT NULL,
  PRIMARY KEY (`cod_asig`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `asignaturas`
--

INSERT INTO `asignaturas` (`cod_asig`, `nom_asig`, `creditos`, `intensidad_h`) VALUES
('111048M', 'Algebra Lineal', 3, 5),
('111050M', 'Calculo I', 4, 5),
('111051M', 'Calculo II', 3, 5),
('201011M', 'Constitucion Politica', 3, 3),
('204101M', 'Ingles I', 3, 5),
('204104M', 'Ingles II', 3, 5),
('204161M', 'Español', 3, 3),
('404001M', 'Deporte', 2, 2),
('710192M', 'Arquitectura I', 3, 3),
('710193M', 'Arquitectura II', 3, 3),
('730125M', 'Impacto Ambiental', 3, 3),
('750008M', 'Sistemas operativos', 3, 3),
('750030M', 'Base de Datos', 4, 4),
('750080M', 'Fundamentos de programacion', 4, 4),
('750081M', 'I.P.O.O', 4, 4),
('750082M', 'I.T.I', 2, 2),
('750083M', 'Matematicas Discretas I', 4, 4),
('750084M', 'Matematicas Discretas II', 4, 4),
('750085M', 'Programacion Interactiva', 4, 4),
('750091M', 'Desarrollo Software I', 3, 3),
('750093M', 'D.I.U', 3, 3),
('750099M', 'I.T.S.I', 2, 2),
('760081M', 'T.G.S', 3, 3),
('801208M', 'Org. Admon. Empresas', 3, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `docentes`
--

CREATE TABLE IF NOT EXISTS `docentes` (
  `cod_doc` varchar(20) NOT NULL,
  `cedula` varchar(20) NOT NULL,
  `docente` varchar(20) NOT NULL,
  `dia` varchar(10) NOT NULL,
  `hora_inicio` varchar(10) NOT NULL,
  `hora_fin` varchar(10) NOT NULL,
  `disponibilidad` varchar(5) NOT NULL,
  PRIMARY KEY (`cod_doc`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `docentes`
--

INSERT INTO `docentes` (`cod_doc`, `cedula`, `docente`, `dia`, `hora_inicio`, `hora_fin`, `disponibilidad`) VALUES
('doce1_1', '111768900', 'Carlos Osorio', 'Miercoles', '07:00', '10:00', 'si'),
('doce1_2', '111768900', 'Carlos Osorio', 'Viernes', '09:00', '12:00', 'si'),
('doce2_1', '31556453', 'Maria Sanchez', 'Lunes', '14:00', '17:00', 'no'),
('doce3_1', '112223456', 'Jose Martinez', 'Miercoles', '08:00', '03:00', 'si'),
('doce3_2', '112223456', 'Jose Martinez', 'Martes', '15:00', '18:00', 'si'),
('doce3_3', '112223456', 'Jose Martinez', 'Jueves', '07:00', '12:00', 'si');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `malla`
--

CREATE TABLE IF NOT EXISTS `malla` (
  `cod_malla` varchar(11) NOT NULL,
  `cod_resol` varchar(11) NOT NULL,
  `cod_asig` varchar(11) NOT NULL,
  `semestre` varchar(11) NOT NULL,
  PRIMARY KEY (`cod_malla`),
  KEY `cod_asig` (`cod_asig`),
  KEY `cod_resol` (`cod_resol`),
  KEY `semestre` (`semestre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `malla`
--

INSERT INTO `malla` (`cod_malla`, `cod_resol`, `cod_asig`, `semestre`) VALUES
('1', '003', '111050M', '1'),
('2', '003', '750083M', '2'),
('3', '003', '750080M', '1'),
('4', '003', '750099M', '1'),
('5', '003', '750082M', '1'),
('6', '003', '204101M', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `programacion`
--

CREATE TABLE IF NOT EXISTS `programacion` (
  `cod_programacion` varchar(10) NOT NULL,
  `cod_prog` varchar(11) NOT NULL,
  `cod_asig` varchar(11) NOT NULL,
  `cod_doc` varchar(20) NOT NULL,
  `dia` varchar(10) NOT NULL,
  `hora_inicio` varchar(10) NOT NULL,
  `hora_fin` varchar(10) NOT NULL,
  `periodo` varchar(20) NOT NULL,
  PRIMARY KEY (`cod_programacion`),
  KEY `cod_asig` (`cod_asig`),
  KEY `cod_doc` (`cod_doc`),
  KEY `cod_prog` (`cod_prog`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `programacion`
--

INSERT INTO `programacion` (`cod_programacion`, `cod_prog`, `cod_asig`, `cod_doc`, `dia`, `hora_inicio`, `hora_fin`, `periodo`) VALUES
('01', '2702', '111050M', 'doce3_3', 'Jueves', '07:00', '10:00', '2012-2'),
('02', '2702', '750083M', 'doce2_1', 'Lunes', '14:00', '17:00', '2012-2');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `programas`
--

CREATE TABLE IF NOT EXISTS `programas` (
  `cod_prog` varchar(11) NOT NULL,
  `nom_prog` varchar(30) NOT NULL,
  PRIMARY KEY (`cod_prog`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `programas`
--

INSERT INTO `programas` (`cod_prog`, `nom_prog`) VALUES
('2702', 'Tecnologia en Sistemas'),
('2703', 'Tecnologia de Alimentos'),
('2704', 'Tecnologia Electronica'),
('2716', 'Tecnologia Agro.'),
('3461', 'Psicologia'),
('3484', 'Lic. Educacion Física'),
('3751', 'Ingenieria Industrial'),
('3842', 'Contaduría Pública'),
('3846', 'Administracion de Empresas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `resoluciones`
--

CREATE TABLE IF NOT EXISTS `resoluciones` (
  `cod_resol` varchar(11) NOT NULL,
  `cod_prog` varchar(15) NOT NULL,
  `nom_resol` varchar(30) NOT NULL,
  `fecha_resol` date NOT NULL,
  PRIMARY KEY (`cod_resol`),
  KEY `cod_prog` (`cod_prog`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `resoluciones`
--

INSERT INTO `resoluciones` (`cod_resol`, `cod_prog`, `nom_resol`, `fecha_resol`) VALUES
('003', '2702', 'Resolucion 003', '2012-02-05'),
('004', '2702', 'Resolucion 004', '2012-02-05'),
('01', '2704', 'Resolucion 01', '2012-02-05'),
('02', '3484', 'Resolucion 02', '2012-02-05');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `semestres`
--

CREATE TABLE IF NOT EXISTS `semestres` (
  `semestre` varchar(11) NOT NULL,
  PRIMARY KEY (`semestre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `semestres`
--

INSERT INTO `semestres` (`semestre`) VALUES
('1'),
('10'),
('2'),
('3'),
('4'),
('5'),
('6'),
('7'),
('8'),
('9');

--
-- Filtros para las tablas descargadas (dump)
--

--
-- Filtros para la tabla `malla`
--
ALTER TABLE `malla`
  ADD CONSTRAINT `FK_malla_cod_asig` FOREIGN KEY (`cod_asig`) REFERENCES `asignaturas` (`cod_asig`),
  ADD CONSTRAINT `FK_malla_cod_resol` FOREIGN KEY (`cod_resol`) REFERENCES `resoluciones` (`cod_resol`),
  ADD CONSTRAINT `FK_malla_semestre` FOREIGN KEY (`semestre`) REFERENCES `semestres` (`semestre`),
  ADD CONSTRAINT `malla_ibfk_1` FOREIGN KEY (`cod_resol`) REFERENCES `resoluciones` (`cod_resol`),
  ADD CONSTRAINT `malla_ibfk_3` FOREIGN KEY (`cod_asig`) REFERENCES `asignaturas` (`cod_asig`),
  ADD CONSTRAINT `malla_ibfk_4` FOREIGN KEY (`semestre`) REFERENCES `semestres` (`semestre`);

--
-- Filtros para la tabla `programacion`
--
ALTER TABLE `programacion`
  ADD CONSTRAINT `programacion_ibfk_3` FOREIGN KEY (`cod_prog`) REFERENCES `programas` (`cod_prog`),
  ADD CONSTRAINT `programacion_ibfk_1` FOREIGN KEY (`cod_asig`) REFERENCES `asignaturas` (`cod_asig`),
  ADD CONSTRAINT `programacion_ibfk_2` FOREIGN KEY (`cod_doc`) REFERENCES `docentes` (`cod_doc`);

--
-- Filtros para la tabla `resoluciones`
--
ALTER TABLE `resoluciones`
  ADD CONSTRAINT `FK_resoluciones_cod_prog` FOREIGN KEY (`cod_prog`) REFERENCES `programas` (`cod_prog`),
  ADD CONSTRAINT `resoluciones_ibfk_1` FOREIGN KEY (`cod_prog`) REFERENCES `programas` (`cod_prog`);
