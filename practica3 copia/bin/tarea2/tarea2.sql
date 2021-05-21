DROP DATABASE IF EXISTS tarea2;
CREATE DATABASE IF NOT EXISTS tarea2;

USE tarea2;

--
-- Table structure for table `alumnos`
--

DROP TABLE IF EXISTS `alumnos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alumnos` (
  `ID_alumno` int NOT NULL,
  `Nombre` varchar(50) DEFAULT NULL,
  `Apellidos` varchar(50) DEFAULT NULL,
  `DNI` varchar(50) DEFAULT NULL,
  `Edad` int DEFAULT NULL,
  PRIMARY KEY (`ID_alumno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
--
-- Table structure for table `notas`
--

DROP TABLE IF EXISTS `notas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notas` (
  `ID_notas` int NOT NULL,
  `ID_alumno` int NOT NULL,
  `Nombre_asignatura` varchar(50) DEFAULT NULL,
  `Nota` int DEFAULT NULL,
  PRIMARY KEY (`ID_notas`),
  KEY `FK_alumnos_TO_notas` (`ID_alumno`),
  CONSTRAINT `FK_alumnos_TO_notas` FOREIGN KEY (`ID_alumno`) REFERENCES `alumnos` (`ID_alumno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
