-- MySQL dump 10.13  Distrib 8.0.44, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mydb
-- ------------------------------------------------------
-- Server version	8.0.44

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
-- Table structure for table `appointments`
--

DROP TABLE IF EXISTS `appointments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appointments` (
  `Appointment_ID` int NOT NULL AUTO_INCREMENT,
  `Patient_ID` varchar(13) DEFAULT NULL,
  `Appointment_Date` date DEFAULT NULL,
  `Appointment_Time` time DEFAULT NULL,
  `Status` varchar(20) DEFAULT 'Pending',
  PRIMARY KEY (`Appointment_ID`),
  KEY `Patient_ID` (`Patient_ID`),
  CONSTRAINT `appointments_ibfk_1` FOREIGN KEY (`Patient_ID`) REFERENCES `patients` (`Patient_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointments`
--

LOCK TABLES `appointments` WRITE;
/*!40000 ALTER TABLE `appointments` DISABLE KEYS */;
INSERT INTO `appointments` VALUES (1,'PAT-1002','2024-06-08','08:00:00','Confirmed'),(2,'PAT-1043','2024-06-08','09:00:00','Scheduled'),(3,'PAT-1602','2024-06-09','10:00:00','Confirmed'),(4,'PAT-2071','2024-06-09','11:00:00','Pending'),(5,'PAT-1103','2024-06-10','12:00:00','Scheduled'),(6,'PAT-1126','2024-06-10','14:00:00','Confirmed'),(7,'PAT-2201','2024-06-11','08:30:00','Scheduled'),(8,'PAT-6681','2024-06-11','09:30:00','Pending'),(9,'PAT-8831','2024-06-12','10:30:00','Confirmed'),(10,'PAT-4023','2024-06-12','11:30:00','Scheduled'),(11,'PAT-5927','2024-06-15','13:00:00','Confirmed'),(12,'PAT-2399','2024-06-15','14:30:00','Pending'),(13,'PAT-9783','2024-06-16','08:15:00','Scheduled'),(14,'PAT-4755','2024-06-16','09:45:00','Confirmed'),(15,'PAT-9631','2024-06-17','11:10:00','Scheduled'),(16,'PAT-1198','2024-06-17','12:45:00','Pending'),(17,'PAT-6139','2024-06-18','14:00:00','Confirmed'),(18,'PAT-1954','2024-06-18','15:00:00','Scheduled'),(19,'PAT-3001','2024-06-19','09:00:00','Confirmed'),(20,'PAT-9771','2024-06-19','10:35:00','Pending');
/*!40000 ALTER TABLE `appointments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patients`
--

DROP TABLE IF EXISTS `patients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patients` (
  `Patient_ID` varchar(20) NOT NULL,
  `First_Name` varchar(50) NOT NULL,
  `Last_Name` varchar(50) NOT NULL,
  `Category` varchar(20) DEFAULT NULL,
  `Priority_Level` varchar(20) DEFAULT NULL,
  `Date_Generated` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`Patient_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patients`
--

LOCK TABLES `patients` WRITE;
/*!40000 ALTER TABLE `patients` DISABLE KEYS */;
INSERT INTO `patients` VALUES ('PAT-1002','Amahle','Mathe','Regular','Low','2026-05-11 11:17:55'),('PAT-1043','Thando','Sithebe','Regular','Low','2026-05-11 11:17:55'),('PAT-1103','Blakely','Paracha','Pregnant','High','2026-05-11 11:17:55'),('PAT-1126','Lethabo','Dlamini','Regular','Low','2026-05-11 11:17:55'),('PAT-1198','Cord','Asante','Pregnant','High','2026-05-11 11:17:55'),('PAT-1602','Siya','Pholwane','Critical','Urgent','2026-05-11 11:17:55'),('PAT-1954','Kofi','Tau','Regular','Low','2026-05-11 11:17:55'),('PAT-2071','John','Loate','Elder','Urgent','2026-05-11 11:17:55'),('PAT-2201','Ayanda','Ndlovu','Critical','Urgent','2026-05-11 11:17:55'),('PAT-2399','Ava','Steven','Pregnant','High','2026-05-11 11:17:55'),('PAT-3001','Zuri','Jamela','Pregnant','High','2026-05-11 11:17:55'),('PAT-4023','Sipho','Zulu','Regular','Low','2026-05-11 11:17:55'),('PAT-4755','Oscar','Phiri','Regular','Low','2026-05-11 11:17:55'),('PAT-5927','Gabriel','Gumede','Critical','Urgent','2026-05-11 11:17:55'),('PAT-6139','Deja','Ture','Elder','Medium','2026-05-11 11:17:55'),('PAT-6681','Catherine','Diallo','Pregnant','High','2026-05-11 11:17:55'),('PAT-8831','Ousmane','Lysiak','Elder','Medium','2026-05-11 11:17:55'),('PAT-9631','Rachel','Philips','Critical','Urgent','2026-05-11 11:17:55'),('PAT-9771','Adelaide','Conor','Critical','Urgent','2026-05-11 11:17:55'),('PAT-9783','Fumani','Ngwenya','Elder','Medium','2026-05-11 11:17:55');
/*!40000 ALTER TABLE `patients` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-05-30  8:31:21
