CREATE DATABASE  IF NOT EXISTS `mydb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `mydb`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mydb
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `sprzet`
--

DROP TABLE IF EXISTS `sprzet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sprzet` (
  `id_sprzet` int(11) NOT NULL,
  `typ` varchar(45) NOT NULL,
  `marka` varchar(45) NOT NULL,
  `parametry` varchar(45) NOT NULL,
  `stan_sprzetu` varchar(45) NOT NULL DEFAULT 'SPRAWNY',
  `id_lokalizacji` int(11) NOT NULL,
  `id_osoby` int(11) NOT NULL,
  `model` varchar(45) NOT NULL,
  PRIMARY KEY (`id_sprzet`),
  KEY `id_uzytkownika_idx` (`id_osoby`),
  KEY `lokal_idx` (`id_lokalizacji`),
  CONSTRAINT `lokal` FOREIGN KEY (`id_lokalizacji`) REFERENCES `lokalizacja` (`id_lokalizacja`),
  CONSTRAINT `sprzet_ibfk_1` FOREIGN KEY (`id_osoby`) REFERENCES `osoby` (`id_osoby`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Tabela zawierajaca inforamcje o sprzecie';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sprzet`
--

LOCK TABLES `sprzet` WRITE;
/*!40000 ALTER TABLE `sprzet` DISABLE KEYS */;
INSERT INTO `sprzet` VALUES (0,'Mikrofon','Shure','Dynamiczny','SPRAWNY',0,0,'SH-01'),(1,'Gitara','Fender','Akustyk','SPRAWNY',3,1,'Cd-60'),(2,'Mikser','Yamaha','Cyfrowy','NIESPRAWNY',1,2,'01');
/*!40000 ALTER TABLE `sprzet` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-25 20:14:29
