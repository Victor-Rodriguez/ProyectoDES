-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Nov 20, 2018 at 02:41 PM
-- Server version: 5.7.23
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `delfossystems`
--

-- --------------------------------------------------------

--
-- Table structure for table `articulos`
--

DROP TABLE IF EXISTS `articulos`;
CREATE TABLE IF NOT EXISTS `articulos` (
  `id_articulo` varchar(10) NOT NULL,
  `articulo` varchar(100) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `estilo` varchar(50) NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `descripcion` varchar(400) NOT NULL,
  `id_rubro` int(11) NOT NULL,
  `id_subcategoria` int(11) NOT NULL,
  `id_marca` int(11) NOT NULL,
  `id_talla` int(11) NOT NULL,
  `img1` varchar(50) NOT NULL,
  `img2` varchar(50) NOT NULL,
  `img3` varchar(50) NOT NULL,
  `img4` varchar(50) NOT NULL,
  `img5` varchar(50) NOT NULL,
  PRIMARY KEY (`id_articulo`),
  KEY `id_rubro` (`id_rubro`),
  KEY `id_subcategoria` (`id_subcategoria`),
  KEY `id_marca` (`id_marca`),
  KEY `id_talla` (`id_talla`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `articulos`
--

INSERT INTO `articulos` (`id_articulo`, `articulo`, `cantidad`, `estilo`, `precio`, `descripcion`, `id_rubro`, `id_subcategoria`, `id_marca`, `id_talla`, `img1`, `img2`, `img3`, `img4`, `img5`) VALUES
('ART001', 'Bermuda AZ', 60, 'Casual', '30.00', 'Bermuda con rayas blancas', 1, 1, 1, 1, 'Bermudas1.jpg', 'Bermudas1A.jpg', 'Bermudas1B.jpg', 'Bermudas1C.jpg', 'Bermudas1D.jpg'),
('ART002', 'Bermuda NG', 60, 'Casual', '30.00', 'Bermuda de lona desteñida', 1, 1, 2, 1, 'Bermudas2.jpg', 'Bermudas2A.jpg', 'Bermudas2B.jpg', 'Bermudas2C.jpg', 'Bermudas2D.jpg'),
('ART003', 'Bermuda AC', 60, 'Casual', '30.00', 'Bermuda de lona azul', 2, 1, 1, 1, 'Bermudas3.jpg', 'Bermudas3A.jpg', 'Bermudas3B.jpg', 'Bermudas3C.jpg', 'Bermudas3D.jpg'),
('ART004', 'Bermuda LZ', 60, 'Casual', '30.00', 'Bermuda lisa negra', 1, 1, 1, 1, 'Bermudas4.jpg', 'Bermudas4A.jpg', 'Bermudas4B.jpg', 'Bermudas4C.jpg', 'Bermudas4D.jpg'),
('ART005', 'Chaqueta Tie', 20, 'Casual', '90.00', 'Caqueta negra de cuero ', 1, 1, 1, 1, 'Chaqueta1.jpg', 'Chaqueta1.1.jpg', 'Chaqueta1.2.jpg', 'Chaqueta1.3.jpg', 'Chaqueta1.4.jpg'),
('ART006', 'Chaqueta lisa', 20, 'Casual', '90.00', 'Caqueta cafÃ© de cuero ', 1, 1, 1, 1, 'Chaqueta2.jpg', 'Chaqueta2.1.jpg', 'Chaqueta2.2.jpg', 'Chaqueta2.3.jpg', 'Chaqueta2.4.jpg'),
('ART007', 'Caqueta LA', 20, 'Casual', '90.00', 'Caqueta negra de cuero ', 1, 1, 1, 1, 'Chaqueta3.jpg', 'Chaqueta3.1.jpg', 'Chaqueta3.2.jpg', 'Chaqueta3.3.jpg', 'Chaqueta3.4.jpg'),
('ART008', 'Caqueta Casual', 20, 'Casual', '50.00', 'Caqueta sin mangas', 1, 1, 1, 1, 'Chaqueta4.jpg', 'Chaqueta4.1.jpg', 'Chaqueta4.2.jpg', 'Chaqueta4.3.jpg', 'Chaqueta4.4.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `carrito`
--

DROP TABLE IF EXISTS `carrito`;
CREATE TABLE IF NOT EXISTS `carrito` (
  `id_carrito` int(11) NOT NULL AUTO_INCREMENT,
  `correo` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `id_producto` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `articulo` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `precio` double NOT NULL,
  `img` varchar(200) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id_carrito`)
) ENGINE=MyISAM AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `carrito`
--

INSERT INTO `carrito` (`id_carrito`, `correo`, `id_producto`, `articulo`, `precio`, `img`) VALUES
(34, 'chesnogamer@gmail.com', 'ART005', 'Arsenal', 79, 'a4.jpg'),
(33, 'chesnogamer@gmail.com', 'ART005', 'Arsenal', 79, 'a4.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
CREATE TABLE IF NOT EXISTS `categorias` (
  `id_categoria` int(11) NOT NULL AUTO_INCREMENT,
  `categoria` varchar(50) NOT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `categorias`
--

INSERT INTO `categorias` (`id_categoria`, `categoria`, `descripcion`) VALUES
(1, 'Pantalon', 'Hecho de tela de algodon'),
(3, 'Camiseta', 'Hecha de tela de algodon'),
(4, 'Camisa', 'Hecha de tela de algodon');

-- --------------------------------------------------------

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
CREATE TABLE IF NOT EXISTS `clientes` (
  `id_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(100) NOT NULL,
  `apellidos` varchar(100) NOT NULL,
  `telefono` varchar(9) NOT NULL,
  `direccion` varchar(200) NOT NULL,
  `dui` varchar(10) NOT NULL,
  `confirmar` tinyint(1) NOT NULL,
  `id_confirmar` varchar(50) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id_cliente`),
  KEY `id_usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `deseo`
--

DROP TABLE IF EXISTS `deseo`;
CREATE TABLE IF NOT EXISTS `deseo` (
  `id_deseo` int(11) NOT NULL AUTO_INCREMENT,
  `correo` varchar(200) COLLATE utf8_spanish_ci NOT NULL,
  `id_producto` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `articulo` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `precio` double NOT NULL,
  `img` varchar(200) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id_deseo`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
CREATE TABLE IF NOT EXISTS `empleados` (
  `id_empleado` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(100) NOT NULL,
  `apellidos` varchar(100) NOT NULL,
  `dui` varchar(10) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id_empleado`),
  UNIQUE KEY `dui` (`dui`),
  KEY `id_usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `empleados`
--

INSERT INTO `empleados` (`id_empleado`, `nombres`, `apellidos`, `dui`, `id_usuario`) VALUES
(1, 'Victor Rene', 'Rodriguez Martinez', '05808580-0', 1),
(2, 'hola', 'hola', '12345678-9', 12),
(3, 'hola', 'hola', '11234567-9', 16),
(4, 'hola', 'hola', '11234568-9', 19),
(5, 'hola', 'hola', '11234566-9', 21),
(7, 'Victor Rene', 'Wiler Rodriguez ', '12345699-8', 23),
(8, 'Erick Alan', 'Mejia Olmedo', '12345622-9', 24);

-- --------------------------------------------------------

--
-- Table structure for table `factura`
--

DROP TABLE IF EXISTS `factura`;
CREATE TABLE IF NOT EXISTS `factura` (
  `id_factura` varchar(5) NOT NULL,
  `fecha_compra` date NOT NULL,
  `id_cliente` int(11) NOT NULL,
  PRIMARY KEY (`id_factura`),
  KEY `id_cliente` (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `imagenes`
--

DROP TABLE IF EXISTS `imagenes`;
CREATE TABLE IF NOT EXISTS `imagenes` (
  `id_imagen` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(200) NOT NULL,
  `id_articulo` varchar(10) NOT NULL,
  PRIMARY KEY (`id_imagen`),
  KEY `id_articulo` (`id_articulo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `marca`
--

DROP TABLE IF EXISTS `marca`;
CREATE TABLE IF NOT EXISTS `marca` (
  `id_marca` int(11) NOT NULL AUTO_INCREMENT,
  `marca` varchar(100) NOT NULL,
  `id_proveedor` varchar(5) NOT NULL,
  PRIMARY KEY (`id_marca`),
  KEY `id_proveedor` (`id_proveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `marca`
--

INSERT INTO `marca` (`id_marca`, `marca`, `id_proveedor`) VALUES
(1, 'SDASDASD', 'PD001'),
(2, 'sadasda', 'PD001'),
(3, 'ghjh', 'PD001');

-- --------------------------------------------------------

--
-- Table structure for table `promocion`
--

DROP TABLE IF EXISTS `promocion`;
CREATE TABLE IF NOT EXISTS `promocion` (
  `id_promocion` varchar(5) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `fecha_inico` date NOT NULL,
  `fecha_fin` date NOT NULL,
  `precio_oferta` decimal(10,2) NOT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  `id_articulo` varchar(10) NOT NULL,
  PRIMARY KEY (`id_promocion`),
  KEY `id_articulo` (`id_articulo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
CREATE TABLE IF NOT EXISTS `proveedor` (
  `id_proveedor` varchar(5) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `direccion` varchar(200) NOT NULL,
  `estado` tinyint(1) NOT NULL COMMENT 'Si sigue activo o no',
  PRIMARY KEY (`id_proveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `proveedor`
--

INSERT INTO `proveedor` (`id_proveedor`, `nombre`, `correo`, `direccion`, `estado`) VALUES
('PD001', 'vectorCompany', 'vectorC@gmail.com', 'El Escalon', 1),
('PD002', 'TelasDel', 'telasdel@gmail.com', 'Soyapango', 1);

-- --------------------------------------------------------

--
-- Table structure for table `rubros`
--

DROP TABLE IF EXISTS `rubros`;
CREATE TABLE IF NOT EXISTS `rubros` (
  `id_rubro` int(11) NOT NULL AUTO_INCREMENT,
  `rubro` varchar(50) NOT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_rubro`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rubros`
--

INSERT INTO `rubros` (`id_rubro`, `rubro`, `descripcion`) VALUES
(1, 'Textil', 'Telas de buena calidad'),
(2, 'Artesanal', 'Hechuras de buena calidad');

-- --------------------------------------------------------

--
-- Table structure for table `sub_categoria`
--

DROP TABLE IF EXISTS `sub_categoria`;
CREATE TABLE IF NOT EXISTS `sub_categoria` (
  `id_subcategoria` int(11) NOT NULL AUTO_INCREMENT,
  `subcategoria` varchar(50) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `id_categoria` int(11) NOT NULL,
  PRIMARY KEY (`id_subcategoria`),
  KEY `id_categoria` (`id_categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sub_categoria`
--

INSERT INTO `sub_categoria` (`id_subcategoria`, `subcategoria`, `descripcion`, `id_categoria`) VALUES
(1, 'Hombre', 'Prendas de vestir para hombres', 1),
(4, 'Mujer', 'Prendas de vestir para mujer', 3);

-- --------------------------------------------------------

--
-- Table structure for table `talla`
--

DROP TABLE IF EXISTS `talla`;
CREATE TABLE IF NOT EXISTS `talla` (
  `id_talla` int(11) NOT NULL AUTO_INCREMENT,
  `talla` varchar(10) NOT NULL,
  PRIMARY KEY (`id_talla`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `talla`
--

INSERT INTO `talla` (`id_talla`, `talla`) VALUES
(1, 'M');

-- --------------------------------------------------------

--
-- Table structure for table `tarjeta_credito`
--

DROP TABLE IF EXISTS `tarjeta_credito`;
CREATE TABLE IF NOT EXISTS `tarjeta_credito` (
  `CC` int(11) NOT NULL AUTO_INCREMENT,
  `CC_num` varchar(16) NOT NULL,
  `nombre_titular` varchar(100) NOT NULL,
  `fecha_exp` date NOT NULL,
  `id_cliente` int(11) NOT NULL,
  PRIMARY KEY (`CC`),
  KEY `id_cliente` (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tipo_usuario`
--

DROP TABLE IF EXISTS `tipo_usuario`;
CREATE TABLE IF NOT EXISTS `tipo_usuario` (
  `id_tipo` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(50) NOT NULL,
  PRIMARY KEY (`id_tipo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tipo_usuario`
--

INSERT INTO `tipo_usuario` (`id_tipo`, `tipo`) VALUES
(1, 'Administrador'),
(2, 'Empleado'),
(3, 'cliente');

-- --------------------------------------------------------

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_usuario` varchar(100) NOT NULL,
  `correo` varchar(500) NOT NULL,
  `clave` varchar(64) NOT NULL,
  `id_tipo` int(11) NOT NULL,
  `total` double DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `correo` (`correo`),
  KEY `id_tipo` (`id_tipo`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usuarios`
--

INSERT INTO `usuarios` (`id_usuario`, `nombre_usuario`, `correo`, `clave`, `id_tipo`, `total`) VALUES
(1, 'VictorRodriguez', 'viictor1275@gmail.com', '1234', 2, 0),
(4, 'edwin', 'edwin@hotmail.com', 'holhal', 3, 0),
(6, 'edwinsadasd', 'edwin10@hotmail.com', '112323', 3, 0),
(7, 'hola', 'tecnojuego@outlook.com', 'e93d8edc210af1d3628e9d56e3a412f62b9dbdcbefff3a7e2470fe9cd5685776', 1, 0),
(12, 'vector777xD', 'vector777@hotmail.com', '123456', 2, 0),
(15, 'edwijhg', 'edwin123@hot.com', '123456', 2, 0),
(16, 'hola hola', 'tecnojuego@outl12ook.com', '01212314', 2, 0),
(19, 'henry', 'tecnojuego@ohok.com', '138ca5ed94c2f410ec3a44107dd5435771ca339add81676494baab50767c78ed', 2, 0),
(21, 'fsdh', 'tecnojuego@ohok123.com', 'd2a8d32edc8a5d578b136fe42644f631703f4f51d834ca80009e576a9095e4e5', 2, 0),
(23, 'VectorElConquistador', 'vector2617@hotmail.com', 'efeaf100c36ea8a92e65a243dc525b1d660bd4ca7ced7ff4990fa3e10371aae3', 2, 0),
(24, 'Erick1995', 'edwin_adonay123@hotmail.com', 'fad5ebee99321184076aa9a6f90c0ffbd5e893d13f4060713959431b430a4e45', 2, 0),
(25, 'Xander', 'chesnogamer@gmail.com', 'e93d8edc210af1d3628e9d56e3a412f62b9dbdcbefff3a7e2470fe9cd5685776', 3, 0),
(26, 'Xander2', 'chesnogamer2@gmail.com', 'e93d8edc210af1d3628e9d56e3a412f62b9dbdcbefff3a7e2470fe9cd5685776', 3, 0);

-- --------------------------------------------------------

--
-- Table structure for table `ventas`
--

DROP TABLE IF EXISTS `ventas`;
CREATE TABLE IF NOT EXISTS `ventas` (
  `id_venta` varchar(10) NOT NULL,
  `fecha_compra` date NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `id_factura` varchar(5) NOT NULL,
  `id_empleado` int(11) NOT NULL,
  `id_articulo` varchar(10) NOT NULL,
  PRIMARY KEY (`id_venta`),
  KEY `id_empleado` (`id_empleado`),
  KEY `id_articulo` (`id_articulo`),
  KEY `id_factura` (`id_factura`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `articulos`
--
ALTER TABLE `articulos`
  ADD CONSTRAINT `articulos_ibfk_1` FOREIGN KEY (`id_rubro`) REFERENCES `rubros` (`id_rubro`),
  ADD CONSTRAINT `articulos_ibfk_2` FOREIGN KEY (`id_subcategoria`) REFERENCES `sub_categoria` (`id_subcategoria`),
  ADD CONSTRAINT `articulos_ibfk_3` FOREIGN KEY (`id_marca`) REFERENCES `marca` (`id_marca`),
  ADD CONSTRAINT `articulos_ibfk_4` FOREIGN KEY (`id_talla`) REFERENCES `talla` (`id_talla`);

--
-- Constraints for table `clientes`
--
ALTER TABLE `clientes`
  ADD CONSTRAINT `clientes_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`);

--
-- Constraints for table `empleados`
--
ALTER TABLE `empleados`
  ADD CONSTRAINT `empleados_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`);

--
-- Constraints for table `factura`
--
ALTER TABLE `factura`
  ADD CONSTRAINT `factura_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id_cliente`);

--
-- Constraints for table `imagenes`
--
ALTER TABLE `imagenes`
  ADD CONSTRAINT `imagenes_ibfk_1` FOREIGN KEY (`id_articulo`) REFERENCES `articulos` (`id_articulo`);

--
-- Constraints for table `marca`
--
ALTER TABLE `marca`
  ADD CONSTRAINT `marca_ibfk_1` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedor` (`id_proveedor`);

--
-- Constraints for table `promocion`
--
ALTER TABLE `promocion`
  ADD CONSTRAINT `promocion_ibfk_1` FOREIGN KEY (`id_articulo`) REFERENCES `articulos` (`id_articulo`);

--
-- Constraints for table `sub_categoria`
--
ALTER TABLE `sub_categoria`
  ADD CONSTRAINT `sub_categoria_ibfk_1` FOREIGN KEY (`id_categoria`) REFERENCES `categorias` (`id_categoria`);

--
-- Constraints for table `tarjeta_credito`
--
ALTER TABLE `tarjeta_credito`
  ADD CONSTRAINT `tarjeta_credito_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id_cliente`);

--
-- Constraints for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`id_tipo`) REFERENCES `tipo_usuario` (`id_tipo`);

--
-- Constraints for table `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `ventas_ibfk_2` FOREIGN KEY (`id_empleado`) REFERENCES `empleados` (`id_empleado`),
  ADD CONSTRAINT `ventas_ibfk_3` FOREIGN KEY (`id_articulo`) REFERENCES `articulos` (`id_articulo`),
  ADD CONSTRAINT `ventas_ibfk_4` FOREIGN KEY (`id_factura`) REFERENCES `factura` (`id_factura`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
