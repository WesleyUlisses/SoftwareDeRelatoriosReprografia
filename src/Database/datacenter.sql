-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: datacenter
-- ------------------------------------------------------
-- Server version	5.6.51-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cotas`
--

DROP TABLE IF EXISTS `cotas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cotas` (
  `idcotas` int(11) NOT NULL,
  `cotasIndividuais` int(11) DEFAULT NULL,
  `cotasUsadas` int(11) DEFAULT NULL,
  `cotasRestantes` int(11) DEFAULT NULL,
  `ifbaiano_idifbaiano` int(11) NOT NULL,
  PRIMARY KEY (`idcotas`),
  KEY `fk_cotas_ifbaiano2_idx` (`ifbaiano_idifbaiano`),
  CONSTRAINT `fk_cotas_ifbaiano2` FOREIGN KEY (`ifbaiano_idifbaiano`) REFERENCES `ifbaiano` (`idifbaiano`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cotas`
--

LOCK TABLES `cotas` WRITE;
/*!40000 ALTER TABLE `cotas` DISABLE KEYS */;
/*!40000 ALTER TABLE `cotas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ifbaiano`
--

DROP TABLE IF EXISTS `ifbaiano`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ifbaiano` (
  `idifbaiano` int(11) NOT NULL,
  `cotasTotais` int(11) DEFAULT NULL,
  PRIMARY KEY (`idifbaiano`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ifbaiano`
--

LOCK TABLES `ifbaiano` WRITE;
/*!40000 ALTER TABLE `ifbaiano` DISABLE KEYS */;
/*!40000 ALTER TABLE `ifbaiano` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pessoa`
--

DROP TABLE IF EXISTS `pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pessoa` (
  `idpessoa` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `matricula` varchar(45) NOT NULL,
  `ocupacao` varchar(45) NOT NULL,
  `cotas_idcotas` int(11) NOT NULL,
  PRIMARY KEY (`idpessoa`,`nome`,`matricula`,`ocupacao`),
  KEY `fk_pessoa_cotas1_idx` (`cotas_idcotas`),
  CONSTRAINT `fk_pessoa_cotas1` FOREIGN KEY (`cotas_idcotas`) REFERENCES `cotas` (`idcotas`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoa`
--

LOCK TABLES `pessoa` WRITE;
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `idusuario` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  `tentativasLogin` int(11) DEFAULT NULL,
  `bloqueado` tinyint(4) NOT NULL,
  `usuarioAdm` tinyint(1) NOT NULL,
  PRIMARY KEY (`idusuario`,`login`,`senha`,`bloqueado`,`usuarioAdm`)
) ENGINE=InnoDB AUTO_INCREMENT=567 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (5,'marcio','2002',0,1,0),(155,'lucas2000','2000lucas',NULL,1,0),(555,'wesley2002','2002wesley',NULL,0,0),(556,'Cleber','1234',0,1,0),(557,'pedrinho','matador',0,0,0),(563,'Ayrton','1999',0,1,0),(564,'helio2023','12345678',0,0,0),(565,'pepê','sol',0,0,0),(566,'helio','12345678',0,0,0);
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

-- Dump completed on 2023-03-27 15:53:20
