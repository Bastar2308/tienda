-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-08-2018 a las 19:02:26
-- Versión del servidor: 10.1.31-MariaDB
-- Versión de PHP: 7.2.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tienda_cbb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `idCategoria` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`idCategoria`, `nombre`) VALUES
(1, 'Bebida'),
(2, 'Lacteo'),
(3, 'Postre'),
(4, 'Congelados'),
(5, 'Snack'),
(6, 'Caramelo'),
(7, 'Alimento'),
(8, 'Desechable'),
(9, 'Dulce');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `saldo` double DEFAULT NULL,
  `Grupo_idGrupo` int(11) NOT NULL,
  `qr` varchar(255) DEFAULT NULL,
  `foto` longblob,
  `tutor` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `correo` varchar(255) DEFAULT NULL,
  `vigencia` date NOT NULL,
  `limite` int(11) NOT NULL DEFAULT '0',
  `observaciones` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`idCliente`, `nombre`, `saldo`, `Grupo_idGrupo`, `qr`, `foto`, `tutor`, `telefono`, `correo`, `vigencia`, `limite`, `observaciones`) VALUES
(1, 'PUBLICO EN GENERAL', 0, 30, NULL, NULL, NULL, NULL, NULL, '2018-12-31', 0, ''),
(11, 'MARIN PONCE DIEGO', -9, 5, 'BSTR_11_2018-12-31', NULL, NULL, NULL, NULL, '2018-12-31', 0, ''),
(111, 'ARJONA TRUJILLO PATRICIO', -192, 7, 'BSTR_111_2018-12-31', NULL, NULL, NULL, NULL, '2018-12-31', 0, ''),
(318, 'SEBASTIAN SALAZAR NAVAS', 9, 12, 'BSTR_318_2018-12-31', NULL, NULL, NULL, NULL, '2018-12-31', 0, ''),
(343, 'XIMENA ZARRABAL AQUINO', 9, 13, 'BSTR_343_2018-12-31', NULL, 'LIZETH AQUINO', '2291890810', 'lizaqui1@hotmail.com', '2018-12-31', -200, ''),
(527, 'ILEAN DENISSE QUINTANA MORALES', 62, 21, 'BSTR_527_2018-12-31', NULL, NULL, NULL, NULL, '2018-12-31', 0, ''),
(585, 'LOPEZ SALVADOR UZIEL', -27, 13, 'BSTR_585_2018-12-31', NULL, NULL, NULL, NULL, '2018-12-31', 0, ''),
(586, 'RAMIRO BASTAR GONZALEZ', -15, 30, 'BSTR_586_2019-06-30', NULL, 'no aplica ', '2299005004', 'profesorbastar@hotmail.com', '2018-03-10', -300, '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_venta`
--

CREATE TABLE `detalle_venta` (
  `Venta_idVenta` int(11) NOT NULL,
  `Producto_idProducto` int(11) DEFAULT NULL,
  `cantidad` double DEFAULT NULL,
  `subtotal` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `detalle_venta`
--

INSERT INTO `detalle_venta` (`Venta_idVenta`, `Producto_idProducto`, `cantidad`, `subtotal`) VALUES
(6, 92, 1, 12),
(6, 65, 1, 7),
(6, 93, 1, 10),
(7, 62, 1, 12),
(7, 63, 1, 7),
(7, 22, 1, 14),
(8, 62, 2, 24),
(8, 14, 1, 7),
(8, 4, 3, 45),
(8, 50, 1, 8),
(8, 11, 1, 15),
(8, 84, 1, 14),
(8, 28, 1, 13),
(8, 8, 1, 12),
(8, 58, 1, 9),
(8, 61, 1, 14),
(8, 66, 4, 48),
(9, 92, 1, 12),
(9, 33, 1, 15),
(10, 82, 1, 7),
(11, 10, 1, 12),
(12, 3, 1, 10),
(13, 81, 1, 10),
(14, 43, 1, 10),
(14, 50, 1, 8),
(15, 43, 1, 10),
(16, 10, 1, 12),
(17, 1, 1, 30),
(17, 83, 1, 11),
(17, 35, 1, 12),
(18, 67, 1, 6),
(18, 25, 2, 4),
(19, 43, 1, 10),
(19, 93, 2, 20),
(20, 67, 1, 6),
(20, 56, 3, 3),
(21, 4, 1, 15),
(22, 1, 1, 30),
(23, 83, 1, 11),
(24, 67, 1, 6),
(25, 67, 1, 6),
(26, 1, 1, 30),
(26, 3, 1, 10),
(27, 3, 1, 10),
(28, 73, 1, 12),
(28, 53, 1, 12),
(29, 93, 1, 10),
(30, 12, 1, 6),
(31, 93, 1, 10),
(31, 53, 1, 12),
(32, 33, 1, 15),
(33, 60, 1, 10),
(34, 25, 2, 4),
(34, 35, 1, 12),
(35, 39, 1, 10),
(36, 23, 1, 13),
(37, 12, 1, 6),
(38, 29, 3, 30),
(38, 50, 1, 8),
(39, 33, 1, 15),
(40, 1, 1, 40),
(40, 24, 1, 25),
(40, 49, 1, 9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `grupo`
--

CREATE TABLE `grupo` (
  `idGrupo` int(11) NOT NULL,
  `nivel` varchar(200) DEFAULT NULL,
  `grado` varchar(45) DEFAULT NULL,
  `grupo` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `grupo`
--

INSERT INTO `grupo` (`idGrupo`, `nivel`, `grado`, `grupo`) VALUES
(1, 'Kinder', '1', 'Green'),
(2, 'Kinder', '1', 'Yellow'),
(3, 'Kinder', '2', 'Yellow'),
(4, 'Nursery', '1', 'Green'),
(5, 'Nursery', '2', 'Yellow'),
(6, 'Nursery', '2', 'Green'),
(7, 'Kinder', '2', 'Green'),
(8, 'Kinder', '3', 'Yellow'),
(9, 'Kinder', '3', 'Green'),
(10, 'Prefirst', '1', 'Prefirst'),
(11, 'Nursery', '1', 'Yellow'),
(12, 'Primaria', '1', 'A'),
(13, 'Primaria', '1', 'B'),
(14, 'Primaria', '2', 'A'),
(15, 'Primaria', '2', 'B'),
(16, 'Primaria', '3', 'A'),
(17, 'Primaria', '3', 'B'),
(18, 'Primaria', '4', 'A'),
(19, 'Primaria', '4', 'B'),
(20, 'Primaria', '5', 'A'),
(21, 'Primaria', '5', 'B'),
(22, 'Primaria', '6', 'A'),
(23, 'Primaria', '6', 'B'),
(24, 'Secundaria', '7', 'A'),
(25, 'Secundaria', '7', 'B'),
(26, 'Secundaria', '8', 'A'),
(27, 'Secundaria', '8', 'B'),
(28, 'Secundaria', '9', 'A'),
(29, 'Secundaria', '9', 'B'),
(30, 'N/A', 'N/A', 'Sin grupo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `marca`
--

CREATE TABLE `marca` (
  `idMarca` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `marca`
--

INSERT INTO `marca` (`idMarca`, `nombre`) VALUES
(1, 'Members Mark'),
(2, 'Ciel'),
(3, 'Del Valle'),
(4, 'Ades'),
(5, 'Coca Cola'),
(6, 'Alpura'),
(7, 'Bimbo'),
(8, 'El original'),
(9, 'Propia'),
(10, 'Toyitos'),
(11, 'Holanda'),
(12, 'Marinela'),
(13, 'Tía'),
(14, 'Nabisco'),
(15, 'Gamesa'),
(16, 'Barcel'),
(17, 'Sanisimo'),
(18, 'Chef Mart'),
(19, 'Nipon'),
(20, 'Florentino'),
(21, 'Adams'),
(22, 'Alpino'),
(23, 'Diaz/Villita'),
(24, 'Panisimo'),
(25, 'Paris'),
(26, 'Tuni'),
(27, 'Chili Chon');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `idProducto` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `detalles` varchar(255) DEFAULT NULL,
  `Categoria_idCategoria` int(11) NOT NULL,
  `Marca_idMarca` int(11) NOT NULL,
  `codigo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`idProducto`, `nombre`, `precio`, `detalles`, `Categoria_idCategoria`, `Marca_idMarca`, `codigo`) VALUES
(1, 'Adicional del Dia', 35, 'Variado', 7, 9, 'BSTR_1'),
(2, 'Agua fresa 355', 9, '', 1, 9, 'BSTR_2'),
(3, 'Aguas Naturales ', 12, 'Fruta Natural ', 1, 9, 'BSTR_3'),
(4, 'Arroz con leche ', 15, 'Arroz con leche ', 3, 9, 'BSTR_4'),
(5, 'Baguette', 22, 'Jamon con Queso Choriqueso', 7, 9, 'BSTR_5'),
(6, 'Baguette Pastor', 30, 'Pastor con Queso', 7, 9, 'BSTR_6'),
(7, 'Barritas ', 14, 'Fresa o pin_a', 5, 9, 'BSTR_7'),
(8, 'Bigotes', 12, 'Bigotes', 5, 9, 'BSTR_8'),
(9, 'Bimbunuelos', 13, 'Bimbunuelos', 5, 9, 'BSTR_9'),
(10, 'Botella de Agua 1 Lt Natural', 14, 'Natural', 1, 9, 'BSTR_10'),
(11, 'Botella de Agua 1 Lt. Sabores', 16, 'Varios Sabores', 1, 9, 'BSTR_11'),
(12, 'Botella de Agua 500 ml', 6, 'Natural', 1, 9, 'BSTR_12'),
(13, 'Bran Frut ', 10, 'Fresa o pin_a', 5, 9, 'BSTR_13'),
(14, 'Cacahuate nipon', 8, 'Tostado', 5, 9, 'BSTR_14'),
(15, 'Cafe Colombiano', 15, 'Colombiano ', 1, 9, 'BSTR_15'),
(16, 'Cafe Capuccion', 18, 'Capucchino', 1, 9, 'BSTR_16'),
(17, 'Canelitas', 14, 'Canelitas', 5, 9, 'BSTR_17'),
(18, 'Charola de Fruta ', 23, 'de la temporada ', 7, 9, 'BSTR_18'),
(19, 'Charola de Verdura', 20, 'Zanahoria Jicama Pepino Betabel', 7, 9, 'BSTR_19'),
(20, 'Charola de Verdura con Cacahuate', 25, 'Zanahoria Jicama Pepino Betabel', 7, 9, 'BSTR_20'),
(21, 'Chilichon', 1, 'Sobre', 9, 9, 'BSTR_21'),
(22, 'Choco Crem', 15, 'Chocolate', 5, 9, 'BSTR_22'),
(23, 'Chocorroles', 15, 'Pina', 5, 9, 'BSTR_23'),
(24, 'Cuernito', 25, 'Jamon Queso ', 7, 9, 'BSTR_24'),
(25, 'Demint', 2, 'Variado', 9, 9, 'BSTR_25'),
(26, 'Desayuno Paquete kids', 30, 'Variado', 7, 9, 'BSTR_26'),
(27, 'Desechable', 1, 'Vaso Cuchara Tenedor', 8, 9, 'BSTR_27'),
(28, 'Donitas espolvoreadas', 14, 'Donitas espolvoreadas', 5, 9, 'BSTR_28'),
(29, 'Empanada', 10, 'Queso  ', 7, 9, 'BSTR_29'),
(30, 'Ensalada de atun', 40, 'Vegetales', 7, 9, 'BSTR_30'),
(31, 'Esquite', 18, 'de Maiz', 5, 9, 'BSTR_31'),
(32, 'Flan', 15, 'De leche ', 3, 9, 'BSTR_32'),
(33, 'Fuze tea ', 15, '', 1, 5, 'BSTR_33'),
(34, 'salmas', 3, 'tortilla de Maiz', 5, 9, 'BSTR_34'),
(35, 'Galletas marias', 13, 'Marias', 5, 9, 'BSTR_35'),
(36, 'Galletas sponch', 16, 'Sponch', 5, 12, 'BSTR_36'),
(37, 'Galletas triki trakes', 12, 'Triki Trakes', 5, 12, 'BSTR_37'),
(38, 'Gelatina ', 15, 'Mozaico', 3, 9, 'BSTR_38'),
(39, 'Helados', 10, 'Varios ', 3, 9, 'BSTR_39'),
(40, 'Hojaldra', 16, 'Jamon Queso azucarada', 7, 9, 'BSTR_40'),
(41, 'Hot dog con Papas', 20, 'Alpino Francesa', 7, 9, 'BSTR_41'),
(42, 'Hot dog preparado', 18, 'Jamon Queso', 7, 9, 'BSTR_42'),
(43, 'Hot dog sencillo', 10, 'Aderezos', 7, 9, 'BSTR_43'),
(44, 'Hot Nuts ', 12, 'Variado', 5, 9, 'BSTR_44'),
(45, 'Huevito kids', 15, 'Jamon /Salchicha', 7, 9, 'BSTR_45'),
(46, 'Huevo orden adulto', 40, 'Preparados', 7, 9, 'BSTR_46'),
(47, 'Jugo natural  medio litro Naranja', 15, 'Naranja', 1, 9, 'BSTR_47'),
(48, 'Jugo medio litro Verde', 18, 'Verde  Combinado ', 1, 9, 'BSTR_48'),
(49, 'Jugo 250 ml Saborizado', 9, 'Saborizado minibrick', 1, 3, 'BSTR_49'),
(50, 'Jugo 355 ml naranja', 9, 'naranja', 1, 3, 'BSTR_50'),
(51, 'Jugo 600 ml Sabores', 15, 'Saborizado', 1, 3, 'BSTR_51'),
(52, 'Jugo de Soya 200 ml naranja', 9, 'Saborizado', 1, 9, 'BSTR_52'),
(53, 'Lechita  gansito', 12, 'Saborizado', 1, 9, 'BSTR_53'),
(54, 'Malanga', 22, 'Varios', 5, 9, 'BSTR_54'),
(55, 'Mantecadas', 14, 'Mantecadas', 5, 9, 'BSTR_55'),
(56, 'Miguelito', 1, 'Sobre', 9, 9, 'BSTR_56'),
(57, 'Mordisco', 16, 'Galleta de chocolate ', 5, 11, 'BSTR_57'),
(58, 'multi grano', 10, '', 5, 7, 'BSTR_58'),
(59, 'Nachos', 15, 'Totopos de Maiz', 5, 9, 'BSTR_59'),
(60, 'Nito', 12, 'Chocolate', 5, 9, 'BSTR_60'),
(61, 'Oreo', 14, 'Oreo', 5, 9, 'BSTR_61'),
(62, 'Paleta bubbaloo', 14, 'Bubbaloo', 4, 11, 'BSTR_62'),
(63, 'paleta kolorix', 9, 'Kolorix', 4, 9, 'BSTR_63'),
(64, 'Paleta pelon', 12, 'Pelon', 4, 9, 'BSTR_64'),
(65, 'Paleta pinta lengua', 10, 'Pinta Lengua', 4, 9, 'BSTR_65'),
(66, 'Paleta solero', 12, 'Solero', 4, 9, 'BSTR_66'),
(67, 'Palomitas Chicas', 7, 'de Maiz', 5, 9, 'BSTR_67'),
(68, 'Palomitas Grandes', 12, 'de Maiz', 5, 9, 'BSTR_68'),
(69, 'Pambazo', 15, 'Frijol Chorizo Queso', 7, 9, 'BSTR_69'),
(70, 'Papas ', 15, 'Francesa', 5, 9, 'BSTR_70'),
(71, 'Picada preparada', 15, 'Preparada', 7, 9, 'BSTR_71'),
(72, 'Picada sencilla', 8, 'Sencilla', 7, 9, 'BSTR_72'),
(73, 'Pizza ', 12, 'Peperoni', 7, 9, 'BSTR_73'),
(74, 'Pizza con Papas', 20, 'Peperoni Francesa', 7, 9, 'BSTR_74'),
(75, 'Platanitos Dulces', 13, 'Dulces', 5, 9, 'BSTR_75'),
(76, 'Platanitos Salados', 13, 'Salados', 5, 9, 'BSTR_76'),
(77, 'Platanos Fritos', 20, 'Crema y Queso', 5, 9, 'BSTR_77'),
(78, 'Polvorones', 14, 'Polvorones', 5, 3, 'BSTR_78'),
(79, 'Powerade saborizado', 17, 'Saborizado  ', 1, 9, 'BSTR_79'),
(80, 'Principe', 12, 'Chocolate, blanco o limon', 5, 9, 'BSTR_80'),
(81, 'Quesadilla', 10, 'Queso de hebra  Manchego', 7, 9, 'BSTR_81'),
(82, 'Rebanadas', 8, 'Rebanadas', 5, 9, 'BSTR_82'),
(83, 'Refresco  bot 355 ml', 12, 'Normal ', 1, 9, 'BSTR_83'),
(84, 'Refresco lata ', 15, ' ', 1, 9, 'BSTR_84'),
(85, 'Salchicha Asada', 10, 'de pavo', 7, 9, 'BSTR_85'),
(86, 'Sandwich', 18, 'Jamon Queso', 7, 9, 'BSTR_86'),
(87, 'Santa Clara', 10, 'Saborizada', 1, 9, 'BSTR_87'),
(88, 'Sincronizada', 20, 'Jamon Queso Choriqueso', 7, 9, 'BSTR_88'),
(89, 'Sincronizada Pastor', 25, 'Pastor con Queso', 7, 9, 'BSTR_89'),
(90, 'Torta ', 22, 'Jamon Queso Choriqueso', 7, 9, 'BSTR_90'),
(91, 'Torta  Pastor', 30, 'Pastor con Queso', 7, 9, 'BSTR_91'),
(92, 'Toyitos  de leche', 12, 'De leche ', 4, 9, 'BSTR_92'),
(93, 'Toyitos de agua', 10, 'De Agua ', 4, 9, 'BSTR_93'),
(94, 'Vaso de Fruta', 15, 'de la Temporada', 7, 9, 'BSTR_94'),
(95, 'Vaso de Verdura ', 10, 'Zanahoria Jicama Pepino Betabel', 7, 9, 'BSTR_95'),
(96, 'Yogurht', 12, 'Saborizado', 1, 9, 'BSTR_96'),
(97, 'Ritz ', 9, '', 5, 14, 'BSTR_97'),
(98, 'Brownies ', 18, 'galleta con chocolate ', 1, 9, 'BSTR_98'),
(99, ' conchita ', 10, 'pan dulce ', 1, 24, 'BSTR_99'),
(100, 'waffles', 12, 'waffle', 1, 9, 'BSTR_100'),
(101, 'conchita preparada ', 18, '', 7, 24, 'BSTR_101'),
(102, 'pinguinos', 16, 'pastelito de chocolate ', 5, 7, 'BSTR_102'),
(103, 'enfrijoladas', 15, 'tortillas con frijol y queso sencillas', 7, 9, 'BSTR_103');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `usuario` varchar(25) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `nombre`, `usuario`, `password`) VALUES
(4, 'Abigail', 'abi123', 'abi123'),
(5, 'Bastar', 'bastar123', 'bastar123'),
(6, 'Aarón', 'aaron123', 'aaron123'),
(7, 'Davir', 'david123', 'david123'),
(8, 'Ele', 'l', 'l'),
(9, 'Raquel', 'raque', 'ra123');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `idVenta` int(11) NOT NULL,
  `nota` varchar(255) DEFAULT NULL,
  `fechahora` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `total` double DEFAULT NULL,
  `Cliente_idCliente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`idVenta`, `nota`, `fechahora`, `total`, `Cliente_idCliente`) VALUES
(6, '', '2018-05-07 16:07:09', 29, 1),
(7, '', '2018-05-07 16:07:27', 33, 1),
(8, '', '2018-05-07 16:36:58', 209, 1),
(9, '', '2018-05-07 20:07:58', 27, 1),
(10, '', '2018-05-07 20:09:16', 7, 1),
(11, '', '2018-05-23 13:54:29', 12, 1),
(12, '', '2018-05-23 14:01:02', 10, 1),
(13, '', '2018-05-23 14:08:10', 10, 1),
(14, '', '2018-05-23 14:09:50', 18, 1),
(15, '', '2018-05-23 14:11:30', 10, 1),
(16, '', '2018-05-23 14:12:53', 12, 1),
(17, '', '2018-05-23 14:19:13', 53, 1),
(18, '', '2018-05-23 14:22:57', 10, 1),
(19, '', '2018-05-23 14:27:28', 30, 1),
(20, '', '2018-05-23 14:38:32', 9, 1),
(21, '', '2018-05-23 17:11:55', 15, 1),
(22, '', '2018-05-23 17:32:51', 30, 1),
(23, '', '2018-05-23 17:33:54', 11, 1),
(24, '', '2018-05-30 18:40:33', 6, 1),
(25, '', '2018-05-30 18:40:45', 6, 1),
(26, '', '2018-06-26 18:09:32', 40, 343),
(27, '', '2018-06-26 18:10:50', 10, 343),
(28, '', '2018-06-27 14:05:39', 24, 343),
(29, '', '2018-06-27 16:49:52', 10, 343),
(30, '', '2018-06-27 16:52:42', 6, 318),
(31, '', '2018-06-28 15:13:24', 22, 343),
(32, '', '2018-06-28 18:03:39', 15, 343),
(33, '', '2018-06-28 18:32:52', 10, 343),
(34, '', '2018-06-28 19:21:58', 16, 318),
(35, '', '2018-06-28 19:38:05', 10, 343),
(36, '', '2018-07-02 16:50:28', 13, 318),
(37, '', '2018-07-02 16:54:44', 6, 318),
(38, '', '2018-07-11 17:41:47', 38, 527),
(39, '', '2018-08-02 15:57:10', 15, 586),
(40, '', '2018-08-08 13:44:12', 74, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`idCategoria`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idCliente`),
  ADD KEY `fk_Cliente_Grupo1_idx` (`Grupo_idGrupo`);

--
-- Indices de la tabla `detalle_venta`
--
ALTER TABLE `detalle_venta`
  ADD KEY `fk_Venta_has_Producto_Producto1_idx` (`Producto_idProducto`),
  ADD KEY `fk_Venta_has_Producto_Venta1_idx` (`Venta_idVenta`);

--
-- Indices de la tabla `grupo`
--
ALTER TABLE `grupo`
  ADD PRIMARY KEY (`idGrupo`);

--
-- Indices de la tabla `marca`
--
ALTER TABLE `marca`
  ADD PRIMARY KEY (`idMarca`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`idProducto`),
  ADD KEY `fk_Producto_Categoria_idx` (`Categoria_idCategoria`),
  ADD KEY `fk_Producto_Marca1_idx` (`Marca_idMarca`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuario`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`idVenta`),
  ADD KEY `fk_Venta_Cliente1_idx` (`Cliente_idCliente`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `idCategoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `idCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=587;

--
-- AUTO_INCREMENT de la tabla `grupo`
--
ALTER TABLE `grupo`
  MODIFY `idGrupo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT de la tabla `marca`
--
ALTER TABLE `marca`
  MODIFY `idMarca` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `idProducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=104;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `venta`
--
ALTER TABLE `venta`
  MODIFY `idVenta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `fk_Cliente_Grupo1` FOREIGN KEY (`Grupo_idGrupo`) REFERENCES `grupo` (`idGrupo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `detalle_venta`
--
ALTER TABLE `detalle_venta`
  ADD CONSTRAINT `fk_Venta_has_Producto_Producto1` FOREIGN KEY (`Producto_idProducto`) REFERENCES `producto` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Venta_has_Producto_Venta1` FOREIGN KEY (`Venta_idVenta`) REFERENCES `venta` (`idVenta`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `fk_Producto_Categoria` FOREIGN KEY (`Categoria_idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Producto_Marca1` FOREIGN KEY (`Marca_idMarca`) REFERENCES `marca` (`idMarca`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `fk_Venta_Cliente1` FOREIGN KEY (`Cliente_idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
