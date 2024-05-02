-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: student_data
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `studentdatabase`
--

DROP TABLE IF EXISTS `studentdatabase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `studentdatabase` (
  `form_no` int NOT NULL,
  `stu_name` varchar(15) DEFAULT NULL,
  `fathers_name` varchar(15) DEFAULT NULL,
  `mothers_name` varchar(15) DEFAULT NULL,
  `mobile_number` mediumtext,
  `email_id` varchar(15) DEFAULT NULL,
  `gender` varchar(6) DEFAULT NULL,
  `caste` varchar(10) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `pincode` mediumtext,
  `addhar_no` mediumtext,
  `adm_class` int DEFAULT NULL,
  `bus_facility` varchar(4) DEFAULT NULL,
  `previous_class` int DEFAULT NULL,
  `pre_class_percentage` float DEFAULT NULL,
  `pre_school_name` varchar(55) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studentdatabase`
--

LOCK TABLES `studentdatabase` WRITE;
/*!40000 ALTER TABLE `studentdatabase` DISABLE KEYS */;
INSERT INTO `studentdatabase` VALUES (0,'rahul','babu','fuli','9602353233','abc2gmail.com','male','obc','bhankrota jaipur','302026','852145624',8,'yes',7,85.25,'indo kids acadmey'),(0,'rahul shram','ra','hul sh','9602353233','abc@gmail.com','male','general','bhankrota jaioput','302026','987650624844',8,'yes',7,45.75,'indo indo indo'),(1025,'sita','shuam','asdqwe wqe','7895463215','asd23@gamil.com','female','sc','dehli','302026','456789875542',8,'yes',7,85.12,'bhata public school'),(1026,'ram','asd','ass','9632587452','acd23@email.com','female','general','Bhankrota','302025','789654321501',6,'no',5,96.9,'rr rawat'),(1027,'54','54','51','24','42','42','42','2','42','42',42,'42',4,42,'');
/*!40000 ALTER TABLE `studentdatabase` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-26 18:34:42
