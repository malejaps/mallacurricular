-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 19-06-2012 a las 18:39:53
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
