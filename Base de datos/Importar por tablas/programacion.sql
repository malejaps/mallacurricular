-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 19-06-2012 a las 18:53:12
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
('01', '2702', '111050M', 'd3_3', 'Jueves', '07:00', '10:00', '2012-2'),
('02', '2702', '750083M', 'd2_1', 'Lunes', '14:00', '17:00', '2012-2');

--
-- Filtros para las tablas descargadas (dump)
--

--
-- Filtros para la tabla `programacion`
--
ALTER TABLE `programacion`
  ADD CONSTRAINT `programacion_ibfk_3` FOREIGN KEY (`cod_prog`) REFERENCES `programas` (`cod_prog`),
  ADD CONSTRAINT `programacion_ibfk_1` FOREIGN KEY (`cod_asig`) REFERENCES `asignaturas` (`cod_asig`),
  ADD CONSTRAINT `programacion_ibfk_2` FOREIGN KEY (`cod_doc`) REFERENCES `docentes` (`cod_doc`);
