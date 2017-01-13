-- phpMyAdmin SQL Dump
-- version 4.0.9
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-01-2017 a las 13:44:46
-- Versión del servidor: 5.6.14
-- Versión de PHP: 5.5.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `rutinas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `brazos`
--

CREATE TABLE IF NOT EXISTS `brazos` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `serie` int(50) NOT NULL,
  `repeticion` int(50) NOT NULL,
  `nombre` text COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `brazos`
--

INSERT INTO `brazos` (`ID`, `serie`, `repeticion`, `nombre`) VALUES
(1, 3, 10, 'Extensión triceps');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `espalda`
--

CREATE TABLE IF NOT EXISTS `espalda` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `serie` int(50) NOT NULL,
  `repeticion` int(50) NOT NULL,
  `nombre` text COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `espalda`
--

INSERT INTO `espalda` (`ID`, `serie`, `repeticion`, `nombre`) VALUES
(1, 3, 10, 'Jalon');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hombro`
--

CREATE TABLE IF NOT EXISTS `hombro` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `serie` int(50) DEFAULT NULL,
  `repeticion` int(50) DEFAULT NULL,
  `nombre` text COLLATE utf8_spanish_ci,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `hombro`
--

INSERT INTO `hombro` (`ID`, `serie`, `repeticion`, `nombre`) VALUES
(1, 3, 10, 'Press militar');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pectoral`
--

CREATE TABLE IF NOT EXISTS `pectoral` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `serie` int(50) NOT NULL,
  `repeticion` int(50) NOT NULL,
  `nombre` text COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `pectoral`
--

INSERT INTO `pectoral` (`ID`, `serie`, `repeticion`, `nombre`) VALUES
(1, 3, 10, 'Press declinado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `piernas`
--

CREATE TABLE IF NOT EXISTS `piernas` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `serie` int(50) DEFAULT NULL,
  `repeticion` int(50) DEFAULT NULL,
  `nombre` text COLLATE utf8_spanish_ci,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `piernas`
--

INSERT INTO `piernas` (`ID`, `serie`, `repeticion`, `nombre`) VALUES
(1, 3, 10, 'Sentadillas');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
