DROP SCHEMA local_suggestions_core;
-- Dump completed on 2017-05-06  0:43:07
CREATE DATABASE  IF NOT EXISTS `local_suggestions_core` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `local_suggestions_core`;
-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: local_suggestions_core
-- ------------------------------------------------------
-- Server version	5.7.18

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
-- Table structure for table `action`
--

DROP TABLE IF EXISTS `action`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `action` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `actionText` varchar(45) DEFAULT NULL COMMENT 'Action: STAR | BOOKMARK | UPVOTE',
  `version` int(11) NOT NULL,
  `updateTimestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `isDeleted` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `attachment`
--

DROP TABLE IF EXISTS `attachment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attachment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `attachmentType` varchar(45) DEFAULT NULL COMMENT 'Attachment Type: Image | Document | PDF | Excel',
  `attachmentName` varchar(100) DEFAULT NULL,
  `attachment` blob,
  `attachmentMetaData` json DEFAULT NULL COMMENT 'Meta Data: Json structure of meta data information',
  `version` int(11) NOT NULL,
  `updateTimestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `isDeleted` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `audit`
--

DROP TABLE IF EXISTS `audit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `audit` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `ip` varchar(45) DEFAULT NULL,
  `device` varchar(45) DEFAULT NULL,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `location` point DEFAULT NULL,
  `activity` varchar(45) DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_decoration_override`
--

DROP TABLE IF EXISTS `user_decoration_override`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_decoration_override` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `decorationId` int(11) NOT NULL COMMENT 'User access will be part of the decoration',
  `decorationName` varchar(45) DEFAULT NULL COMMENT 'User Decoration (e.g. BASIC)\nlocationUpdate: True \nsendSuggestions: 3/month\ndefaultSuggestionExpiration: 1week\npromotedSuggestions: 0/month',
  `defaultValue` varchar(45) DEFAULT NULL,
  `version` int(11) NOT NULL,
  `updateTimestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `isDeleted` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `user_decoration-user_decoration_override-user_idx` (`decorationName`,`decorationId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

--
-- Table structure for table `suggestion`
--

DROP TABLE IF EXISTS `suggestion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `suggestion` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `subject` varchar(100) NOT NULL,
  `content` text,
  `expirationTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `suggestionType` varchar(45) DEFAULT NULL COMMENT 'SuggestionType: QUESTION | POST',
  `category` varchar(45) DEFAULT NULL,
  `location` point NOT NULL,
  `displayLocation` point DEFAULT NULL COMMENT 'For user privacy i.e. Location on screen is different to the one actually posted',
  `version` int(11) NOT NULL,
  `updateTimestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `isDeleted` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `suggestionId` bigint(20) NOT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `content` text NOT NULL,
  `location` point DEFAULT NULL,
  `version` int(11) NOT NULL,
  `updateTimestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `isDeleted` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `suggestion-comment-id_idx` (`suggestionId`),
  CONSTRAINT `suggestion-comment-id` FOREIGN KEY (`suggestionId`) REFERENCES `suggestion` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `comment_attachment`
--

DROP TABLE IF EXISTS `comment_attachment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment_attachment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `commentId` bigint(20) NOT NULL,
  `userId` int(11) NOT NULL,
  `attachmentId` bigint(20) NOT NULL,
  `location` point DEFAULT NULL,
  `version` int(11) NOT NULL,
  `updateTimestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `isDeleted` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `comment-comment_attachment-id_idx` (`commentId`),
  KEY `attachment-comment_attachment-id_idx` (`attachmentId`),
  CONSTRAINT `attachment-comment_attachment-id` FOREIGN KEY (`attachmentId`) REFERENCES `attachment` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `comment-comment_attachment-id` FOREIGN KEY (`commentId`) REFERENCES `comment` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `comment_location`
--

DROP TABLE IF EXISTS `comment_location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment_location` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `commentId` bigint(20) NOT NULL,
  `location` point NOT NULL,
  `version` int(11) NOT NULL,
  `updateTimestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `isDeleted` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `comment-comment_location-id_idx` (`commentId`),
  CONSTRAINT `comment-comment_location-id` FOREIGN KEY (`commentId`) REFERENCES `comment` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `suggestion_action`
--

DROP TABLE IF EXISTS `suggestion_action`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `suggestion_action` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `suggestionId` bigint(20) NOT NULL,
  `userId` int(11) NOT NULL,
  `actionId` int(11) NOT NULL COMMENT 'Action: STAR | BOOKMARK | UPVOTE',
  `location` point DEFAULT NULL,
  `version` int(11) NOT NULL,
  `updateTimestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `isDeleted` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `suggestion-suggestion_action-id_idx` (`suggestionId`),
  KEY `action-suggestion_action-id_idx` (`actionId`),
  CONSTRAINT `action-suggestion_action-id` FOREIGN KEY (`actionId`) REFERENCES `action` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `suggestion-suggestion_action-id` FOREIGN KEY (`suggestionId`) REFERENCES `suggestion` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `suggestion_attachment`
--

DROP TABLE IF EXISTS `suggestion_attachment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `suggestion_attachment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `suggestionId` bigint(20) NOT NULL,
  `userId` int(11) NOT NULL,
  `attachmentId` bigint(20) NOT NULL,
  `location` point DEFAULT NULL,
  `version` int(11) NOT NULL,
  `updateTimestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `isDeleted` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `suggestion-suggestion_attachment-id_idx` (`suggestionId`),
  KEY `attachment-suggestion_attachment-id_idx` (`attachmentId`),
  CONSTRAINT `attachment-suggestion_attachment-id` FOREIGN KEY (`attachmentId`) REFERENCES `attachment` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `suggestion-suggestion_attachment-id` FOREIGN KEY (`suggestionId`) REFERENCES `suggestion` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `suggestion_tag`
--

DROP TABLE IF EXISTS `suggestion_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `suggestion_tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `suggestionId` bigint(20) NOT NULL,
  `tag` varchar(45) NOT NULL,
  `version` int(11) NOT NULL,
  `updateTimestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `isDeleted` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `suggestion-suggestion_tag-id_idx` (`suggestionId`),
  CONSTRAINT `suggestion-suggestion_tag-id` FOREIGN KEY (`suggestionId`) REFERENCES `suggestion` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-06  0:43:07
