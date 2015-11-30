-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 19-06-2012 a las 18:43:04
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
('doce2_1', '31556453', 'Maria Sanchez', 'Lunes', '14:00', '17:00', 'si'),
('doce3_1', '112223456', 'Jose Martinez', 'Miercoles', '08:00', '03:00', 'si'),
('doce3_2', '112223456', 'Jose Martinez', 'Martes', '15:00', '18:00', 'si'),
('doce3_3', '112223456', 'Jose Martinez', 'Jueves', '07:00', '12:00', 'si');
