-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: 10.0.0.1    Database: ortomedic
-- ------------------------------------------------------
-- Server version	5.1.73-1

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
  PRIMARY KEY (`idconsulta`),
  KEY `fk_consulta_tipo_consulta1_idx` (`idtipo_consulta`),
  KEY `fk_consulta_paciente1_idx` (`idpaciente`),
  CONSTRAINT `fk_consulta_paciente1` FOREIGN KEY (`idpaciente`) REFERENCES `paciente` (`idpaciente`) ON UPDATE NO ACTION,
  CONSTRAINT `fk_consulta_tipo_consulta1` FOREIGN KEY (`idtipo_consulta`) REFERENCES `tipo_consulta` (`idtipo_consulta`) ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consulta`
--

LOCK TABLES `consulta` WRITE;
/*!40000 ALTER TABLE `consulta` DISABLE KEYS */;
INSERT INTO `consulta` VALUES (15,'2014-11-01',NULL,NULL,1,2,'08:00:00',NULL,NULL,NULL,NULL,NULL),(16,'2014-11-11','teste','raio x da cabeça	',1,3,'12:00:00',1,'lexotan 3mg 2x dia ',NULL,NULL,NULL),(19,'2014-10-22',NULL,NULL,1,8,'10:15:00',NULL,NULL,NULL,NULL,NULL),(21,'2014-11-12',NULL,'radiografia\nmamografia',1,8,'08:00:00',1,'tilenol 500 mg',NULL,NULL,NULL),(22,'2014-11-12',NULL,'',1,8,'08:15:00',1,NULL,NULL,NULL,NULL),(23,'2014-11-05','teste consulta dia 5',NULL,1,3,'15:00:00',1,NULL,NULL,NULL,NULL),(24,'2014-11-12',NULL,'exames 12/11 verificando o valor para ver se cabe em mais de uma linha.\r\n2@ linha .... verificando teste de quebra de linha na segunda linha do exame, este é o final da 2@ linha.\r\n3@ linha... verificando teste de quebra de linha na segunda linha do exame, este é o final da 3@ linha.',1,2,'10:00:00',1,NULL,NULL,NULL,NULL),(25,'2014-11-12',NULL,NULL,1,1,'09:00:00',NULL,NULL,NULL,NULL,NULL),(26,'2014-11-22',NULL,'fdfd',1,8,'08:00:00',1,NULL,NULL,NULL,NULL),(32,'2014-10-22',NULL,NULL,1,8,'10:30:00',NULL,NULL,NULL,NULL,NULL),(33,'2014-11-22','','solicito radiografia do torax',1,8,'10:15:00',1,'tylenol 500 m',NULL,'teste atestado\naf\nsdf\nasf\nsaf\nsa\nf\nsadf\nsadf\nsa\nf\nsadf\nasd\nfsd\nfs final','laudo'),(34,'2015-03-26',NULL,'sdfasdfas',1,16,'08:00:00',1,NULL,NULL,NULL,NULL),(35,'2015-03-28',NULL,NULL,1,1,'08:33:00',1,NULL,NULL,NULL,NULL),(36,'2015-03-28',NULL,NULL,1,11,'08:00:00',0,NULL,NULL,NULL,NULL),(37,'2015-03-28',NULL,NULL,1,17,'08:01:00',0,NULL,NULL,NULL,NULL),(39,'2015-03-28',NULL,'teste',1,19,'08:04:00',1,NULL,NULL,NULL,NULL),(40,'2015-03-28','sintomas 	','teste exames paciente testando 28/03/2015 9:23',1,20,'09:23:00',1,'teste receita paciente testando 28/03/2015 9:23',NULL,'teste atestado paciente testando 28/03/2015 9:23','teste laudo paciente testando 28/03/2015 9:23'),(41,'2015-04-05',NULL,NULL,1,20,'08:00:00',NULL,NULL,NULL,NULL,NULL),(42,'2015-04-05',NULL,'teste exames',1,20,'09:00:00',1,NULL,NULL,NULL,NULL),(43,'2015-04-05','afsdfadssadlçf asl fasçld kflçsadk flçsadk fçlasdk fçlasdk fçalsdk fçlsadk flsaçdk f lçsadk flçsadk fçlsad kflçsda kfçld kfçlsdak fçlsdk flçasdk fçlsadk flçasd kflçadsk fdl fdsa fasdf sadf sadf dsa sadfsdaf sdaf sadf sda fsda fsda fsdaf as','teste 10:00',1,20,'10:00:00',1,'dfasdfsad lkdsf skdlf sldkf klsd fslkd jflkad jflksad flksad flksad lkds ',NULL,'Atesto para os devidos fins que o senhor nasser othman rahman deverá permanecer em repouso durante 7 dias a contar desta data\n','teste laudo'),(44,'2015-04-05',NULL,'fdgds',1,19,'08:15:00',1,NULL,NULL,NULL,NULL);
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
INSERT INTO `convenio` VALUES (1,'UNIMED','Descrição Unimed'),(2,'IPE','Descrição IPE'),(4,'Golden Cross','teste goldencross'),(5,'TESTE','TESTE OBSER');
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
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paciente`
--

LOCK TABLES `paciente` WRITE;
/*!40000 ALTER TABLE `paciente` DISABLE KEYS */;
INSERT INTO `paciente` VALUES (1,'JOSEF DA FONTOURA DORNELES SILVA','5532565236','5598563256','DUQUE DE CAXIAS 1929','josef@totaltech.inf.br','1994-01-28',1,'observacoes do josef',NULL),(2,'SAMER OTHMAN RAHMAN','5597028569','5534116960','duque de caxias 1929','samer@totaltech.inf.br','1984-10-10',1,'observaçoes do samer',NULL),(3,'EDIMAR DOS SANTOS','5487455698','5585478569','PRESIDENTE VARGAS','edimar@totaltech.inf.br','1982-10-05',2,'observações do edimar','1452145214'),(4,'RODRIGO DOS SANTOS','5534112356','5584523256','DUQUE DE CAXIAS','rodrigo@totaltech.inf.br','1980-11-01',1,'observaçoes',NULL),(8,'NASSER DOS SANTOS','465789','456789','','','1980-09-23',1,'','99'),(9,'RAWHI RAHMAN SALEM','5545678965','5513254866','DUQUE DE CAXIAS 1929 BAIRRO CENTRO','rawhi@bazardapraca.com','1960-07-01',1,'observacoes rawhi','987654'),(10,'NIJMA RAHMAN','5564569874','25874125','DUQUE','','1976-08-30',1,'teste	',NULL),(11,'ABDEL BISONHO','5648936547','25896325','DUQUE DE CAXIAS 1929','','1979-01-19',4,'mocorongo','111'),(14,'JOAO DOS SANTOS','',NULL,'','','1982-09-29',1,'','123'),(16,'FULANO DE TAL ','',NULL,'','','2015-03-27',1,'','852'),(17,'NOVO PACIENTE TESTE','123','321','','','1950-01-01',1,'','321'),(19,'TESTE NOVO REFRESH','',NULL,'','','2015-04-01',1,'','963'),(20,'TESTANDO DENOVO','',NULL,'','','2015-01-01',1,'observa','456');
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_usuario`
--

LOCK TABLES `tipo_usuario` WRITE;
/*!40000 ALTER TABLE `tipo_usuario` DISABLE KEYS */;
INSERT INTO `tipo_usuario` VALUES (1,'secretaria'),(2,'medico');
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'NASSER RAHMAN','','','e10adc3949ba59abbe56e057f20f883e','nasser',2);
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

-- Dump completed on 2015-06-27 14:51:05
