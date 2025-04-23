-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.32-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.10.0.7000
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Dumping data for table schedule_manager_db.accounts: ~4 rows (approximately)
INSERT INTO `accounts` (`uid`, `user_name`, `user_password`, `full_name`, `rank`, `permissions`) VALUES
	(1, 'Bien', '12345', 'Bien Niño Enric N. Iligan', 'Dean', 'user'),
	(2, 'Keegan', '12345', 'Keegan Jeoff G. Liboon', 'Professor', 'user'),
	(3, 'JB', '12345', 'John Benedict B. Bancruz', 'Teacher', 'user'),
	(15, 'tester', 'test', 'test update', 'tester1', 'Basic');

-- Dumping data for table schedule_manager_db.courses: ~8 rows (approximately)
INSERT INTO `courses` (`course_code`, `course_title`, `course_type`, `units`) VALUES
	('CC003.23', 'Computer Programming 2', 'Lab', 1),
	('CC005.23', 'Computer Systems Operation & Maintenance', 'Lab', 1),
	('CC004.23', 'Visual Design & Motion Graphics', 'Lab', 1),
	('CC003.23', 'Computer Programming 2', 'Lec', 2),
	('CC004.23', 'Visual Desgin & Motion Graphics', 'Lec', 2),
	('CC005.23', 'Computer Systems Operation & Maintenance', 'Lec', 2),
	('CS002.23', 'Discrete Structures 2', 'Lec', 3),
	('GEC001.23', 'Purposive Communication', 'Lec', 3);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
