-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 19-06-2012 a las 18:37:32
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
