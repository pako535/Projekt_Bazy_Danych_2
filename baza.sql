lokalizacjaCREATE DATABASE  IF NOT EXISTS `mydb` /*!40100 DEFAULT CHARACTER SET utf8 */;
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
-- Table structure for table `lokalizacja`
--

DROP TABLE IF EXISTS `lokalizacja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lokalizacja` (
  `id_lokalizacja` int(11) NOT NULL,
  `miasto` varchar(45) NOT NULL,
  `kod_pocztowy` varchar(6) NOT NULL,
  PRIMARY KEY (`id_lokalizacja`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lokalizacja`
--

LOCK TABLES `lokalizacja` WRITE;
/*!40000 ALTER TABLE `lokalizacja` DISABLE KEYS */;
INSERT INTO `lokalizacja` VALUES (0,'Zielona Góra','65-012'),(1,'Wrocław','50-031'),(2,'Jelenia Góra','58-500'),(3,'Bestwina','43-512');
/*!40000 ALTER TABLE `lokalizacja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `niesprawne_sprzety`
--

DROP TABLE IF EXISTS `niesprawne_sprzety`;
/*!50001 DROP VIEW IF EXISTS `niesprawne_sprzety`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `niesprawne_sprzety` AS SELECT 
 1 AS `id_sprzet`,
 1 AS `typ`,
 1 AS `marka`,
 1 AS `parametry`,
 1 AS `stan_sprzetu`,
 1 AS `miasto`,
 1 AS `imie`,
 1 AS `nazwisko`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `osoby`
--

DROP TABLE IF EXISTS `osoby`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `osoby` (
  `id_osoby` int(11) NOT NULL,
  `id_lokalizacji` int(11) NOT NULL,
  `imie` varchar(45) NOT NULL,
  `nazwisko` varchar(45) NOT NULL,
  `nr_tel` int(9) NOT NULL,
  `adres` varchar(45) NOT NULL,
  `mail` varchar(45) DEFAULT NULL,
  `login` varchar(45) NOT NULL,
  `hasło` varchar(45) NOT NULL,
  PRIMARY KEY (`id_osoby`),
  KEY `for_idx` (`id_lokalizacji`),
  CONSTRAINT `lokal_os` FOREIGN KEY (`id_lokalizacji`) REFERENCES `lokalizacja` (`id_lokalizacja`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `osoby`
--

LOCK TABLES `osoby` WRITE;
/*!40000 ALTER TABLE `osoby` DISABLE KEYS */;
INSERT INTO `osoby` VALUES (0,0,'Paweł','Biel',535226885,'Wróblewskiego 8','pawel.biel.96@gmial.com','admin','admin'),(1,1,'Mateusz','Wójtowicz',791024199,'Kościelna 27','mateusz.eclipse@gmail.com','master','adminadmin'),(2,2,'Janusz','Biernat',880733654,'Wybrzeże Wyspiańskiego 27','janusz..biernat@pwr.edu.pl','sumator','ultrasumator');
/*!40000 ALTER TABLE `osoby` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Temporary view structure for view `stan_sprzetu`
--

DROP TABLE IF EXISTS `stan_sprzetu`;
/*!50001 DROP VIEW IF EXISTS `stan_sprzetu`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `stan_sprzetu` AS SELECT 
 1 AS `id_sprzet`,
 1 AS `typ`,
 1 AS `marka`,
 1 AS `parametry`,
 1 AS `stan_sprzetu`,
 1 AS `miasto`,
 1 AS `imie`,
 1 AS `nazwisko`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `niesprawne_sprzety`
--

/*!50001 DROP VIEW IF EXISTS `niesprawne_sprzety`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `niesprawne_sprzety` AS select `s`.`id_sprzet` AS `id_sprzet`,`s`.`typ` AS `typ`,`s`.`marka` AS `marka`,`s`.`parametry` AS `parametry`,`s`.`stan_sprzetu` AS `stan_sprzetu`,`l`.`miasto` AS `miasto`,`o`.`imie` AS `imie`,`o`.`nazwisko` AS `nazwisko` from ((`sprzet` `s` join `osoby` `o` on((`o`.`id_osoby` = `s`.`id_osoby`))) join `lokalizacja` `l` on((`l`.`id_lokalizacja` = `s`.`id_lokalizacji`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `stan_sprzetu`
--

/*!50001 DROP VIEW IF EXISTS `stan_sprzetu`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `stan_sprzetu` AS select `s`.`id_sprzet` AS `id_sprzet`,`s`.`typ` AS `typ`,`s`.`marka` AS `marka`,`s`.`parametry` AS `parametry`,`s`.`stan_sprzetu` AS `stan_sprzetu`,`l`.`miasto` AS `miasto`,`o`.`imie` AS `imie`,`o`.`nazwisko` AS `nazwisko` from ((`sprzet` `s` join `osoby` `o` on((`o`.`id_osoby` = `s`.`id_osoby`))) join `lokalizacja` `l` on((`l`.`id_lokalizacja` = `s`.`id_lokalizacji`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-25 20:13:11
