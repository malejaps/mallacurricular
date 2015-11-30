-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 19-06-2012 a las 18:39:44
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
