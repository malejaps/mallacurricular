-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 19-06-2012 a las 18:39:59
-- Versión del servidor: 5.5.8
-- Versión de PHP: 5.3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `proyectomalla2`
--

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

--
-- Filtros para las tablas descargadas (dump)
--

--
-- Filtros para la tabla `resoluciones`
--
ALTER TABLE `resoluciones`
  ADD CONSTRAINT `FK_resoluciones_cod_prog` FOREIGN KEY (`cod_prog`) REFERENCES `programas` (`cod_prog`),
  ADD CONSTRAINT `resoluciones_ibfk_1` FOREIGN KEY (`cod_prog`) REFERENCES `programas` (`cod_prog`);
