-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.32-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.8.0.6908
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for schedule_manager_db
CREATE DATABASE IF NOT EXISTS `schedule_manager_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `schedule_manager_db`;

-- Dumping structure for table schedule_manager_db.accounts
CREATE TABLE IF NOT EXISTS `accounts` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` longtext DEFAULT NULL,
  `user_password` longtext DEFAULT NULL,
  `full_name` longtext DEFAULT NULL,
  `rank` longtext DEFAULT NULL,
  `permissions` longtext DEFAULT 'user',
  PRIMARY KEY (`uid`),
  KEY `uid` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table schedule_manager_db.accounts: ~4 rows (approximately)
INSERT INTO `accounts` (`uid`, `user_name`, `user_password`, `full_name`, `rank`, `permissions`) VALUES
	(1, 'Bien', '12345', 'Bien Niño Enric N. Iligan', 'Dean', 'user'),
	(2, 'Keegan', '12345', 'Keegan Jeoff G. Liboon', 'Professor', 'user'),
	(3, 'JB', '12345', 'John Benedict B. Bancruz', 'Teacher', 'user'),
	(15, 'tester', 'test', 'test update', 'tester1', 'Basic');

-- Dumping structure for table schedule_manager_db.courses
CREATE TABLE IF NOT EXISTS `courses` (
  `incharge` int(11) DEFAULT NULL,
  `section` longtext DEFAULT NULL,
  `course_code` longtext DEFAULT NULL,
  `course_title` longtext DEFAULT NULL,
  `course_type` longtext DEFAULT NULL,
  `units` double NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table schedule_manager_db.courses: ~9 rows (approximately)
INSERT INTO `courses` (`incharge`, `section`, `course_code`, `course_title`, `course_type`, `units`) VALUES
	(1, 'BSCS - 1A', 'CC003.23', 'Computer Programming 2', 'Lab', 1),
	(NULL, 'BSIT - 1A', 'CC005.23', 'Computer Systems Operation & Maintenance', 'Lab', 1),
	(NULL, NULL, 'CC004.23', 'Visual Design & Motion Graphics', 'Lab', 1),
	(NULL, NULL, 'CC003.23', 'Computer Programming 2', 'Lec', 2),
	(NULL, NULL, 'CC004.23', 'Visual Desgin & Motion Graphics', 'Lec', 2),
	(NULL, NULL, 'CC005.23', 'Computer Systems Operation & Maintenance', 'Lec', 2),
	(NULL, NULL, 'CS002.23', 'Discrete Structures 2', 'Lec', 3),
	(NULL, NULL, 'GEC001.23', 'Purposive Communication', 'Lec', 3),
	(1, 'BSIT - 1A', 'CC003.23', 'Computer Programming 2', 'Lab', 0);

-- Dumping structure for table schedule_manager_db.schedule
CREATE TABLE IF NOT EXISTS `schedule` (
  `courseCode` longtext DEFAULT NULL,
  `section` longtext DEFAULT NULL,
  `room_id` longtext DEFAULT NULL,
  `time` longtext DEFAULT NULL,
  `employee_id` longtext DEFAULT NULL,
  `day` longtext DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table schedule_manager_db.schedule: ~3 rows (approximately)
INSERT INTO `schedule` (`courseCode`, `section`, `room_id`, `time`, `employee_id`, `day`) VALUES
	('CC003.23', 'BSCS - 1A', '101', '07:30 - 10:00', '1', 'Monday'),
	('CC005.23', 'BSCS - 1A', '102', '10:00 -  12:00', '2', 'Monday'),
	('CC005.23', 'BSCS - 1A', '102', '10:00 -  12:00', '2', 'Monday');

-- Dumping structure for table schedule_manager_db.sections
CREATE TABLE IF NOT EXISTS `sections` (
  `section_name` longtext DEFAULT NULL,
  `program_name` longtext DEFAULT NULL,
  `program` longtext DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table schedule_manager_db.sections: ~6 rows (approximately)
INSERT INTO `sections` (`section_name`, `program_name`, `program`) VALUES
	('BSCS - 1A', 'Bachelor Of Science in Computer Science', 'Computer Science'),
	('BSIT - 1A', 'Bachelor Of Science in Information Technology', 'Information Technology'),
	('BSIT - 1B', 'Bachelor Of Science in Information Technology', 'Information Technology'),
	('BSIS - 1A', 'Bachelor Of Science in Information Systems', 'Information Systems'),
	('BSCS - 2A', 'Bachelor Of Science in Computer Science', 'Computer Science'),
	('BSCS - 3A', 'Bachelor Of Science in Computer Science', 'Computer Science');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
