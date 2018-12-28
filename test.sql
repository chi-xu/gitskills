-- MySQL dump 10.10
--
-- Host: localhost    Database: test
-- ------------------------------------------------------
-- Server version	5.1.6-alpha-nt-max

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
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `id` int(10) NOT NULL auto_increment,
  `cname` varchar(30) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `company`
--


/*!40000 ALTER TABLE `company` DISABLE KEYS */;
LOCK TABLES `company` WRITE;
INSERT INTO `company` VALUES (1,'苏州博纳讯动软件有限公司'),(2,'上海柏赟软件科技有限公司'),(3,'北京博纳讯动科技有限公司');
UNLOCK TABLES;
/*!40000 ALTER TABLE `company` ENABLE KEYS */;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(10) NOT NULL auto_increment,
  `dname` varchar(30) default NULL,
  `pid` int(10) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `department`
--


/*!40000 ALTER TABLE `department` DISABLE KEYS */;
LOCK TABLES `department` WRITE;
INSERT INTO `department` VALUES (1,'大数据销售部',6),(2,'运营管理部',6),(3,'总裁办',6),(4,'服务部',6),(5,'研发部',6),(6,'博云',NULL);
UNLOCK TABLES;
/*!40000 ALTER TABLE `department` ENABLE KEYS */;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `id` int(10) NOT NULL auto_increment,
  `pname` varchar(30) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `post`
--


/*!40000 ALTER TABLE `post` DISABLE KEYS */;
LOCK TABLES `post` WRITE;
INSERT INTO `post` VALUES (1,'项目经理'),(2,'JAVA开发'),(3,'系统架构'),(4,'系统运维'),(5,'UI设计');
UNLOCK TABLES;
/*!40000 ALTER TABLE `post` ENABLE KEYS */;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(10) NOT NULL auto_increment,
  `rname` varchar(30) default NULL,
  `pid` int(10) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `role`
--


/*!40000 ALTER TABLE `role` DISABLE KEYS */;
LOCK TABLES `role` WRITE;
INSERT INTO `role` VALUES (1,'超级管理员',NULL),(2,'部门主管',1),(3,'销售总监',1),(4,'运营主管',1),(5,'普通用户',2),(6,'项目经理',2),(7,'产品经理',3),(8,'策划总监',4);
UNLOCK TABLES;
/*!40000 ALTER TABLE `role` ENABLE KEYS */;

--
-- Table structure for table `t_categorys`
--

DROP TABLE IF EXISTS `t_categorys`;
CREATE TABLE `t_categorys` (
  `c_id` int(11) NOT NULL auto_increment,
  `c_name` varchar(255) NOT NULL,
  PRIMARY KEY  (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `t_categorys`
--


/*!40000 ALTER TABLE `t_categorys` DISABLE KEYS */;
LOCK TABLES `t_categorys` WRITE;
INSERT INTO `t_categorys` VALUES (1,'structs'),(2,'spring'),(3,'ibatis'),(4,'Hibernate');
UNLOCK TABLES;
/*!40000 ALTER TABLE `t_categorys` ENABLE KEYS */;

--
-- Table structure for table `t_topic`
--

DROP TABLE IF EXISTS `t_topic`;
CREATE TABLE `t_topic` (
  `t_id` int(11) NOT NULL auto_increment,
  `t_name` varchar(255) NOT NULL,
  `t_categorys` varchar(128) NOT NULL,
  PRIMARY KEY  (`t_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `t_topic`
--


/*!40000 ALTER TABLE `t_topic` DISABLE KEYS */;
LOCK TABLES `t_topic` WRITE;
INSERT INTO `t_topic` VALUES (1,'SSI整合示例','1,2,3'),(2,'SSH整合示例','1,2,4');
UNLOCK TABLES;
/*!40000 ALTER TABLE `t_topic` ENABLE KEYS */;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL auto_increment,
  `userId` varchar(20) default NULL,
  `username` varchar(20) default NULL,
  `phone` varchar(11) default NULL,
  `address` varchar(50) default '博云',
  `password` varchar(20) default '123456',
  `email` varchar(30) default NULL,
  `gender` varchar(8) default NULL,
  `birthday` date default NULL,
  `employ_date` date default NULL,
  `status` int(20) default '0',
  `departmentId` int(10) default NULL,
  `roleId` int(10) default NULL,
  `postId` int(10) default NULL,
  `companyId` int(10) default NULL,
  `level` varchar(20) default NULL,
  `salary` double(10,0) default NULL,
  `parentId` varchar(20) default NULL,
  PRIMARY KEY  (`id`),
  KEY `department` (`departmentId`),
  KEY `role` (`roleId`),
  KEY `post` (`postId`),
  KEY `company` (`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='InnoDB free: 10240 kB; (`post_id`) REFER `test/post`(`id`); ';

--
-- Dumping data for table `users`
--


/*!40000 ALTER TABLE `users` DISABLE KEYS */;
LOCK TABLES `users` WRITE;
INSERT INTO `users` VALUES (63,'BN50045','徐易','43234234232',NULL,NULL,'daDasdsS@qq.com','男','2018-12-13','2018-12-03',NULL,4,8,2,3,'中级',435433,'BN00360'),(64,'BN34578','李威','23213213233','博云','123456','dsad@qq.com','男','2018-12-10','2018-12-09',0,5,8,3,2,'中级',23131,'BN00369'),(65,'BN00001','马俊宇','32123432433','博云','123456','dssad@qq.com','男','2018-12-04','2018-12-12',0,3,6,3,2,'中级',234324,'BN00360'),(66,'BN00002','小雷','32123432433','博云','123456','SASdssad@qq.com','男','2018-12-11','2018-12-19',0,5,7,2,1,'初级',43434,'BN00393'),(67,'BN00003','俊儒','32123432433','博云','123456','SASdssad@qq.com','男','2018-12-04','2018-12-19',0,1,7,2,3,'初级',43434,'BN54645'),(69,'BN00005','周文涛','32123432326','博云','123456','ZWRdssad@qq.com','男','2018-11-25','2018-11-28',0,1,6,1,1,'高级',4343432,'BN00136'),(70,'BN00004','康康','32423423422','博云','123456','sad@qq.com','男','2018-12-11','2018-12-10',0,1,6,3,2,'初级',324234,'BN00360'),(71,'BN02343','徐驰','23123243433','博云','123456','sada@qq.com','男','2018-12-25','2018-12-10',0,3,8,3,1,'高级',342342423,'BN54645'),(72,'BN02342','岳勉','23123243433','博云','123456','sada@qq.com','男','2018-12-25','2018-12-10',0,3,7,2,2,'中级',3423213123,'BN00360'),(73,'BN34365','徐高杰','21312312321','博云','123456','asda@qq.com','男','2018-12-11','2018-12-19',0,3,6,1,3,'高级',32432342,'BN00393'),(76,'BN43435','葛飞扬','32434545444','博云','123456','sada@qq.com','男','2018-12-11','2018-12-11',0,4,NULL,3,2,'中级',4543434,'BN00393'),(81,'BN00033','陈新浪','43535343444','博云','123456','adsa@qq.com','男','2018-12-04','2018-12-18',0,2,NULL,1,3,'中级',3242342,'BN00001'),(82,'BN35009','小虎','32435345433','博云','123456','sadas@qq.com','男','2018-12-10','2018-12-12',0,3,NULL,3,3,'中级',2132131,'BN00001'),(83,'BN30079','郑海','23213213233','博云','123456','dsad@qq.com','男','2018-12-10','2018-12-09',0,5,NULL,3,2,'中级',23131,'BN00369'),(84,'BN50945','马蒂','43234234232','博云','123456','daDasdsS@qq.com','男','2018-12-13','2018-12-03',0,4,7,2,3,'中级',435433,'BN00360'),(85,'BN50040','徐易伟','43234234232','博云','123456','dsadasdsS@qq.com','男','2018-12-13','2018-12-03',0,4,NULL,2,3,'中级',435433,'BN00360');
UNLOCK TABLES;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

