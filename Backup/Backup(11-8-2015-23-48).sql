-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: ortomedic
-- ------------------------------------------------------
-- Server version	5.6.24

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `consulta`
--

DROP TABLE IF EXISTS `consulta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `consulta` (
  `idconsulta` int(11) NOT NULL AUTO_INCREMENT,
  `data_consulta` date DEFAULT NULL,
  `sintomas` text,
  `exames` text,
  `idtipo_consulta` int(11) NOT NULL,
  `idpaciente` int(11) NOT NULL,
  `hora_consulta` time DEFAULT NULL,
  `compareceu` tinyint(1) DEFAULT NULL,
  `receita` text,
  `medicacao` text,
  `atestado` text,
  `laudo` text,
  `medico` int(11) NOT NULL,
  PRIMARY KEY (`idconsulta`),
  KEY `fk_consulta_tipo_consulta1_idx` (`idtipo_consulta`),
  KEY `fk_consulta_paciente1_idx` (`idpaciente`),
  KEY `fk_consulta_usuario1_idx` (`medico`),
  CONSTRAINT `fk_consulta_paciente1` FOREIGN KEY (`idpaciente`) REFERENCES `paciente` (`idpaciente`) ON UPDATE NO ACTION,
  CONSTRAINT `fk_consulta_tipo_consulta1` FOREIGN KEY (`idtipo_consulta`) REFERENCES `tipo_consulta` (`idtipo_consulta`) ON UPDATE NO ACTION,
  CONSTRAINT `fk_consulta_usuario1` FOREIGN KEY (`medico`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consulta`
--

LOCK TABLES `consulta` WRITE;
/*!40000 ALTER TABLE `consulta` DISABLE KEYS */;
/*!40000 ALTER TABLE `consulta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `convenio`
--

DROP TABLE IF EXISTS `convenio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `convenio` (
  `idconvenio` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) DEFAULT NULL,
  `observacoes` text,
  PRIMARY KEY (`idconvenio`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `convenio`
--

LOCK TABLES `convenio` WRITE;
/*!40000 ALTER TABLE `convenio` DISABLE KEYS */;
INSERT INTO `convenio` VALUES (1,'UNIMED',''),(2,'IPE','');
/*!40000 ALTER TABLE `convenio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paciente`
--

DROP TABLE IF EXISTS `paciente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paciente` (
  `idpaciente` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `telefone1` varchar(10) DEFAULT NULL,
  `telefone2` varchar(10) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `data_nasc` date DEFAULT NULL,
  `idconvenio` int(11) NOT NULL,
  `observacoes` text,
  `cpf` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`idpaciente`),
  KEY `fk_paciente_convenio_idx` (`idconvenio`),
  CONSTRAINT `fk_paciente_convenio` FOREIGN KEY (`idconvenio`) REFERENCES `convenio` (`idconvenio`) ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paciente`
--

LOCK TABLES `paciente` WRITE;
/*!40000 ALTER TABLE `paciente` DISABLE KEYS */;
/*!40000 ALTER TABLE `paciente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_consulta`
--

DROP TABLE IF EXISTS `tipo_consulta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_consulta` (
  `idtipo_consulta` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idtipo_consulta`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_consulta`
--

LOCK TABLES `tipo_consulta` WRITE;
/*!40000 ALTER TABLE `tipo_consulta` DISABLE KEYS */;
INSERT INTO `tipo_consulta` VALUES (1,'consulta'),(2,'reconsulta');
/*!40000 ALTER TABLE `tipo_consulta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_usuario`
--

DROP TABLE IF EXISTS `tipo_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_usuario` (
  `idtipo_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idtipo_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_usuario`
--

LOCK TABLES `tipo_usuario` WRITE;
/*!40000 ALTER TABLE `tipo_usuario` DISABLE KEYS */;
INSERT INTO `tipo_usuario` VALUES (1,'secretaria'),(2,'medico'),(3,'administrador');
/*!40000 ALTER TABLE `tipo_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `idusuario` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `telefone` varchar(10) DEFAULT NULL,
  `celular` varchar(10) DEFAULT NULL,
  `senha` varchar(45) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `idtipousuario` int(11) NOT NULL,
  PRIMARY KEY (`idusuario`),
  KEY `fk_usuario_tipousuario1_idx` (`idtipousuario`),
  CONSTRAINT `fk_usuario_tipousuario1` FOREIGN KEY (`idtipousuario`) REFERENCES `tipo_usuario` (`idtipo_usuario`) ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'USUARIO','','','e10adc3949ba59abbe56e057f20f883e','usuario',1),(2,'MEDICO 01 DE TESTE','123456','12345','502c633827f8a7a5890e07d57ba4be02','medico01',2),(3,'MEDICO 02 TESTE','949491','303030','b68df3ab370ddb9da205464598027abe','medico02',2);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-08-11 23:48:50
