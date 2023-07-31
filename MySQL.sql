/*
MySQL Backup
Database: webstore
Backup Time: 2023-06-22 16:09:28
*/

SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `webstore`.`attendance`;
DROP TABLE IF EXISTS `webstore`.`department`;
DROP TABLE IF EXISTS `webstore`.`person`;
DROP TABLE IF EXISTS `webstore`.`salary`;
DROP TABLE IF EXISTS `webstore`.`students`;
CREATE TABLE `attendance` (
  `Pno` int NOT NULL,
  `Need` int DEFAULT NULL,
  `Fact` int DEFAULT NULL,
  PRIMARY KEY (`Pno`),
  CONSTRAINT `AP` FOREIGN KEY (`Pno`) REFERENCES `person` (`Pno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `department` (
  `Dno` int NOT NULL,
  `Dname` varchar(255) DEFAULT NULL,
  `Dhead` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`Dno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `person` (
  `Pno` int NOT NULL,
  `Pname` varchar(255) DEFAULT NULL,
  `Dno` int DEFAULT NULL,
  `Ptel` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Pno`),
  KEY `PD` (`Dno`),
  CONSTRAINT `PD` FOREIGN KEY (`Dno`) REFERENCES `department` (`Dno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `salary` (
  `Pno` int NOT NULL,
  `BaseSal` double unsigned DEFAULT '0',
  `PostAllow` double unsigned DEFAULT '0',
  `LunchSub` double unsigned DEFAULT '0',
  `OvertimePay` double unsigned DEFAULT '0',
  `FullAttend` double unsigned DEFAULT '0',
  `SocialSec` double DEFAULT '0',
  `AccuFund` double DEFAULT '0',
  `Tax` double DEFAULT '0',
  `Punish` double DEFAULT '0',
  `Date` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`Pno`,`Date`) USING BTREE,
  CONSTRAINT `SP` FOREIGN KEY (`Pno`) REFERENCES `person` (`Pno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `students` (
  `id` int NOT NULL,
  `name` varchar(6) NOT NULL,
  `age` int NOT NULL,
  `profession` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
BEGIN;
LOCK TABLES `webstore`.`attendance` WRITE;
DELETE FROM `webstore`.`attendance`;
INSERT INTO `webstore`.`attendance` (`Pno`,`Need`,`Fact`) VALUES (1, 21, 21),(2, 21, 21),(3, 21, 21),(4, 21, 21),(5, 21, 21),(6, 21, 18),(7, 21, 20),(8, 21, 20);
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `webstore`.`department` WRITE;
DELETE FROM `webstore`.`department`;
INSERT INTO `webstore`.`department` (`Dno`,`Dname`,`Dhead`) VALUES (1, '总经办', '张三'),(2, '办公室', '王五'),(3, '开发部', '钱七'),(4, '测试部', '郑九');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `webstore`.`person` WRITE;
DELETE FROM `webstore`.`person`;
INSERT INTO `webstore`.`person` (`Pno`,`Pname`,`Dno`,`Ptel`) VALUES (1, '张三', 1, '12345'),(2, '李四', 1, '12345'),(3, '王五', 2, '12345'),(4, '陈六', 2, '12345'),(5, '钱七', 3, '12345'),(6, '孙八', 3, '12345'),(7, '郑九', 4, '12345'),(8, '潘十', 4, '12345');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `webstore`.`salary` WRITE;
DELETE FROM `webstore`.`salary`;
INSERT INTO `webstore`.`salary` (`Pno`,`BaseSal`,`PostAllow`,`LunchSub`,`OvertimePay`,`FullAttend`,`SocialSec`,`AccuFund`,`Tax`,`Punish`,`Date`) VALUES (1, 3500, 8000, 200, 0, 100, -920, -241, -353.05, -30, '201901'),(2, 3200, 7000, 200, 0, 0, -900, -241, -357.05, 0, '201901'),(3, 2200, 3000, 200, 0, 0, -683, -241, -346.2, 0, '201901'),(4, 2200, 3200, 200, 0, 0, -630, -241, -343.55, -200, '201901'),(5, 2500, 6000, 200, 1200, 100, -630, -241, -338.55, 0, '201901'),(6, 2800, 7000, 200, 0, 0, -630, -241, -343.55, 0, '201901'),(7, 2200, 3000, 200, 800, 100, -630, -241, -338.55, 0, '201901'),(8, 2200, 3800, 200, 0, 0, -504, -241, -337.25, 0, '201901');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `webstore`.`students` WRITE;
DELETE FROM `webstore`.`students`;
UNLOCK TABLES;
COMMIT;
