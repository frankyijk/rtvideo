-- MySQL dump 10.13  Distrib 5.5.53, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: rtvideo
-- ------------------------------------------------------
-- Server version	5.5.53-0ubuntu0.14.04.1

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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT NULL,
  `name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `img` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,NULL,'游戏专区','https://i.h2.pdim.gs/81e217bfa2c3b80a5fdd6f6d9670d9aa.webp'),(2,NULL,'音乐','https://i.h2.pdim.gs/8f7abcf0c348ffd2ca8ff2c5fdb11646.webp'),(3,NULL,'科技教育','https://i.h2.pdim.gs/d06c76c072452340c1f26d0e367c0a30.webp'),(4,NULL,'轻松一刻','https://i.h2.pdim.gs/da64258614b5e848f5bda1613148aaf0.webp');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `record`
--

DROP TABLE IF EXISTS `record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `video_id` bigint(20) NOT NULL,
  `state` tinyint(1) NOT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `record`
--

LOCK TABLES `record` WRITE;
/*!40000 ALTER TABLE `record` DISABLE KEYS */;
INSERT INTO `record` VALUES (5,1,1,0,'2018-04-17 13:44:42','2018-04-17 13:44:42'),(6,2,1,0,'2018-04-17 16:29:03','2018-04-18 02:01:27'),(9,2,12,2,'2018-04-17 19:52:50','2018-04-18 01:28:07'),(10,2,11,2,'2018-04-17 19:56:19','2018-04-18 01:52:33'),(11,2,13,2,'2018-04-18 01:52:58','2018-04-18 02:01:20'),(12,11,1,0,'2018-04-18 02:43:07','2018-04-18 02:43:07'),(13,11,17,0,'2018-04-18 02:45:11','2018-04-18 02:45:11'),(14,11,18,0,'2018-04-18 07:25:06','2018-04-18 07:25:06'),(15,11,19,0,'2018-04-18 08:26:30','2018-04-18 08:26:30'),(16,2,18,0,'2018-04-18 09:11:02','2018-04-18 09:11:02'),(17,2,19,0,'2018-04-18 10:42:16','2018-04-18 10:42:16'),(18,2,17,0,'2018-04-18 13:26:20','2018-04-18 13:26:20'),(19,12,17,2,'2018-04-18 13:34:38','2018-04-18 13:37:51'),(20,12,20,2,'2018-04-18 13:35:40','2018-04-18 13:37:49'),(21,12,13,2,'2018-04-18 13:37:25','2018-04-18 13:37:51'),(22,14,18,2,'2018-04-18 16:47:07','2018-04-18 16:50:17'),(23,14,21,2,'2018-04-18 16:49:09','2018-04-18 16:50:16');
/*!40000 ALTER TABLE `record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_VIEWER'),(2,'ROLE_UPLOADER'),(3,'ROLE_ADMIN');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `server`
--

DROP TABLE IF EXISTS `server`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `server` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rtmpUrl` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `server`
--

LOCK TABLES `server` WRITE;
/*!40000 ALTER TABLE `server` DISABLE KEYS */;
INSERT INTO `server` VALUES (1,'rtmp://localhost/live/');
/*!40000 ALTER TABLE `server` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subscribe`
--

DROP TABLE IF EXISTS `subscribe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subscribe` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `viewer_id` bigint(20) NOT NULL,
  `owner_id` bigint(20) NOT NULL,
  `state` tinyint(1) NOT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subscribe`
--

LOCK TABLES `subscribe` WRITE;
/*!40000 ALTER TABLE `subscribe` DISABLE KEYS */;
INSERT INTO `subscribe` VALUES (1,2,1,3,'2018-04-15 21:49:35','2018-04-15 21:49:35'),(2,2,11,0,'2018-04-18 10:41:29','2018-04-18 10:41:29'),(3,12,12,0,'2018-04-18 13:36:57','2018-04-18 13:36:57'),(4,12,1,3,'2018-04-18 13:37:33','2018-04-18 13:37:33'),(5,14,14,0,'2018-04-18 16:50:10','2018-04-18 16:50:10');
/*!40000 ALTER TABLE `subscribe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` char(11) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nickname` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `gender` tinyint(1) DEFAULT NULL,
  `password` char(60) COLLATE utf8_unicode_ci DEFAULT NULL,
  `locked` tinyint(1) NOT NULL DEFAULT '0' COMMENT '禁用',
  `enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '未注销',
  `avatar` varchar(100) COLLATE utf8_unicode_ci DEFAULT 'https://i.h2.pdim.gs/dmfd/200_200_100/0257040380bd7d294a8017532c07e39b.jpg',
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_username_IDX` (`username`) USING HASH
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'_fansir','17816869790','石头',2,'$2a$10$1Uvp//98EqEPk7eWn01K.uBncf9woy.bKnbuUqmkprX5ORfQcFQ72',0,1,'https://i.h2.pdim.gs/dmfd/200_200_100/0257040380bd7d294a8017532c07e39b.jpg','2018-03-29 17:30:59','2018-04-15 20:43:36'),(2,'fanlinyu','18250831083','范林玉',2,'$2a$10$1Uvp//98EqEPk7eWn01K.uBncf9woy.bKnbuUqmkprX5ORfQcFQ72',0,1,'https://i.h2.pdim.gs/dmfd/200_200_100/0257040380bd7d294a8017532c07e39b.jpg','2018-03-31 17:30:59','2018-03-31 17:30:59'),(9,'baidu.com',NULL,'你好',NULL,'$2a$10$CTEwAb5T1kwOZolQRpgR9eN2uThvrulQ.kTRhsTFn.QidhOKcwm3O',0,1,'https://i.h2.pdim.gs/dmfd/200_200_100/0257040380bd7d294a8017532c07e39b.jpg','2018-04-16 16:18:15','2018-04-16 16:18:15'),(10,'测试帐号01',NULL,'昵称',NULL,'$2a$10$a.UOy0LSWrNGgg4VQgWoEu748inTug82DlqM2sd23a/fvNp1FBTNO',0,1,'https://i.h2.pdim.gs/dmfd/200_200_100/0257040380bd7d294a8017532c07e39b.jpg','2018-04-18 00:17:39','2018-04-18 00:17:39'),(11,'测试帐号02',NULL,'昵称',NULL,'$2a$10$c1ID0uHwc6D0Xbg4kZsHVeYmRQ4k.hNk7IXrAq2bczPuVU/6CTOr2',0,1,'https://i.h2.pdim.gs/dmfd/200_200_100/0257040380bd7d294a8017532c07e39b.jpg','2018-04-18 02:42:24','2018-04-18 02:42:24'),(12,'测试帐号03',NULL,'帐号03',NULL,'$2a$10$DTpBkdT6QA1erbDpVF1r3.TYqrKemVBdrVnb8NN7WM0EJUcb2HEuO',0,1,'https://i.h2.pdim.gs/dmfd/200_200_100/0257040380bd7d294a8017532c07e39b.jpg','2018-04-18 13:34:06','2018-04-18 13:34:06'),(13,'策划四',NULL,'测试',NULL,'$2a$10$Az0w6a4HIhoNYHnRGoLuHOdXt5.8q.jeS440m56ogg0AV2E3wgGF2',0,1,'https://i.h2.pdim.gs/dmfd/200_200_100/0257040380bd7d294a8017532c07e39b.jpg','2018-04-18 16:45:47','2018-04-18 16:45:47'),(14,'测试帐号04',NULL,'呢称',NULL,'$2a$10$VtDWIhdtFInxnBomZ1FJe.LOIi49k2YUN5FIZP8bkYSrthfxONiny',0,1,'https://i.h2.pdim.gs/dmfd/200_200_100/0257040380bd7d294a8017532c07e39b.jpg','2018-04-18 16:46:35','2018-04-18 16:46:35');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1),(1,2),(1,3),(2,1),(2,2),(9,1),(10,1),(10,2),(11,1),(11,2),(12,1),(12,2),(13,1),(14,1),(14,2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `video`
--

DROP TABLE IF EXISTS `video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `video` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `rtmp_url` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `flv_url` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `thumbnail` varchar(100) COLLATE utf8_unicode_ci DEFAULT 'https://i.h2.pdim.gs/90/c880b628d125fbd5650814303265f700/w338/h190.webp',
  `category_id` int(11) NOT NULL,
  `tags` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `owner_id` bigint(20) NOT NULL,
  `islive` tinyint(1) NOT NULL,
  `state` tinyint(2) NOT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  `uv` int(11) DEFAULT '0',
  `pv` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `video`
--

LOCK TABLES `video` WRITE;
/*!40000 ALTER TABLE `video` DISABLE KEYS */;
INSERT INTO `video` VALUES (1,'第一个直播','rtmp://localhost/live/12345678',NULL,'https://i.h2.pdim.gs/90/c880b628d125fbd5650814303265f700/w338/h190.webp',1,NULL,1,1,0,'2018-03-29 17:30:59','2018-03-29 17:30:59',0,9),(9,'测试03','rtmp://live.hkstv.hk.lxdns.com/live/hks',NULL,'https://i.h2.pdim.gs/90/c880b628d125fbd5650814303265f700/w338/h190.webp',4,NULL,1,1,0,'2018-04-17 11:44:49','2018-04-17 11:44:49',0,0),(10,'测试04','rtmp://live.hkstv.hk.lxdns.com/live/hks',NULL,'https://i.h2.pdim.gs/90/c880b628d125fbd5650814303265f700/w338/h190.webp',2,NULL,1,1,0,'2018-04-17 12:02:42','2018-04-17 12:02:42',0,0),(11,'测试05','rtmp://live.hkstv.hk.lxdns.com/live/hks',NULL,'https://i.h2.pdim.gs/90/c880b628d125fbd5650814303265f700/w338/h190.webp',1,NULL,1,1,0,'2018-04-17 12:09:37','2018-04-17 12:09:37',0,1),(12,'测试06','rtmp://live.hkstv.hk.lxdns.com/live/hks',NULL,'https://i.h2.pdim.gs/90/c880b628d125fbd5650814303265f700/w338/h190.webp',1,NULL,1,0,0,'2018-04-17 12:10:53','2018-04-17 12:25:02',0,0),(13,'直播设置','rtmp://localhost/live/2387911',NULL,'https://i.h2.pdim.gs/90/c880b628d125fbd5650814303265f700/w338/h190.webp',4,NULL,1,1,0,'2018-04-17 22:14:31','2018-04-17 22:16:55',0,4),(14,'停止测试','rtmp://localhost/live/2387911',NULL,'https://i.h2.pdim.gs/90/c880b628d125fbd5650814303265f700/w338/h190.webp',1,NULL,1,0,4,'2018-04-17 22:43:23','2018-04-17 22:43:31',0,0),(15,'保存测试','rtmp://localhost/live/2387911',NULL,'https://i.h2.pdim.gs/90/c880b628d125fbd5650814303265f700/w338/h190.webp',3,NULL,1,1,0,'2018-04-17 22:50:48','2018-04-17 22:51:08',0,0),(16,'测试权限','rtmp://localhost/live/23879110',NULL,'https://i.h2.pdim.gs/90/c880b628d125fbd5650814303265f700/w338/h190.webp',3,NULL,10,0,4,'2018-04-18 00:18:39','2018-04-18 00:18:50',0,0),(17,'演示','rtmp://localhost/live/23879111',NULL,'https://i.h2.pdim.gs/90/c880b628d125fbd5650814303265f700/w338/h190.webp',1,NULL,11,1,0,'2018-04-18 02:43:41','2018-04-18 02:44:13',0,6),(18,'直播设置','rtmp://localhost/live/23879111',NULL,'https://i.h2.pdim.gs/90/c880b628d125fbd5650814303265f700/w338/h190.webp',4,NULL,11,1,0,'2018-04-18 07:24:36','2018-04-18 07:24:51',0,11),(19,'推流前不显示','rtmp://localhost/live/23879111',NULL,'https://i.h2.pdim.gs/90/c880b628d125fbd5650814303265f700/w338/h190.webp',2,NULL,11,0,0,'2018-04-18 08:25:57','2018-04-18 08:27:29',0,3),(20,'测试','rtmp://localhost/live/23879112',NULL,'https://i.h2.pdim.gs/90/c880b628d125fbd5650814303265f700/w338/h190.webp',4,NULL,12,0,0,'2018-04-18 13:35:00','2018-04-18 13:38:03',0,2),(21,'直播名称','rtmp://localhost/live/23879114',NULL,'https://i.h2.pdim.gs/90/c880b628d125fbd5650814303265f700/w338/h190.webp',1,NULL,14,0,0,'2018-04-18 16:47:56','2018-04-18 16:50:34',0,1);
/*!40000 ALTER TABLE `video` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-22  8:25:23
