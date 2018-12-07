/*
SQLyog Ultimate v12.5.0 (64 bit)
MySQL - 5.5.60 : Database - dlxj
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`dlxj` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `dlxj`;

/*Table structure for table `bugtype` */

DROP TABLE IF EXISTS `bugtype`;

CREATE TABLE `bugtype` (
  `id` int(6) NOT NULL,
  `name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `state` int(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `circuitry` */

DROP TABLE IF EXISTS `circuitry`;

CREATE TABLE `circuitry` (
  `id` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `length` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `arroundlength` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `towercount` int(6) NOT NULL,
  `voltage` int(6) NOT NULL,
  `startpoleNo` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `endpoleNo` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `state` int(6) NOT NULL,
  `remark` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_circuitry` (`endpoleNo`),
  KEY `FK_circuitry1` (`startpoleNo`),
  CONSTRAINT `FK_circuitry` FOREIGN KEY (`endpoleNo`) REFERENCES `pole` (`id`),
  CONSTRAINT `FK_circuitry1` FOREIGN KEY (`startpoleNo`) REFERENCES `pole` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `circuitry_pole` */

DROP TABLE IF EXISTS `circuitry_pole`;

CREATE TABLE `circuitry_pole` (
  `id` int(6) NOT NULL,
  `pid` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `cid` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `position` int(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `debugtask` */

DROP TABLE IF EXISTS `debugtask`;

CREATE TABLE `debugtask` (
  `id` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `type` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `principal` int(6) NOT NULL,
  `createUser` int(6) NOT NULL,
  `time` date NOT NULL,
  `description` varchar(300) COLLATE utf8_unicode_ci NOT NULL,
  `remark` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL,
  `endTime` date DEFAULT NULL,
  `state` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `debugtask_pole` */

DROP TABLE IF EXISTS `debugtask_pole`;

CREATE TABLE `debugtask_pole` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `did` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `pid` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `ptid` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `debugtask_user` */

DROP TABLE IF EXISTS `debugtask_user`;

CREATE TABLE `debugtask_user` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `did` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `uid` int(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `group` */

DROP TABLE IF EXISTS `group`;

CREATE TABLE `group` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `createUserId` int(6) DEFAULT NULL,
  `state` int(6) NOT NULL,
  `createTime` date NOT NULL,
  `purviewId` int(6) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_group` (`createUserId`),
  KEY `FK_group_role` (`purviewId`),
  CONSTRAINT `FK_group_purview` FOREIGN KEY (`purviewId`) REFERENCES `purview` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `login_log` */

DROP TABLE IF EXISTS `login_log`;

CREATE TABLE `login_log` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `uid` int(6) NOT NULL,
  `time` datetime NOT NULL,
  `ip` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=164 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `model` */

DROP TABLE IF EXISTS `model`;

CREATE TABLE `model` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `pid` int(6) NOT NULL,
  `url` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `state` int(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `patroltask` */

DROP TABLE IF EXISTS `patroltask`;

CREATE TABLE `patroltask` (
  `id` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '任务编码',
  `name` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '任务名称',
  `cid` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `startPoleNo` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `endPoleNo` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `uid` int(6) NOT NULL,
  `time` date NOT NULL,
  `state` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '任务状态',
  `cancel` int(6) NOT NULL COMMENT '0:取消 1:正常',
  `endTime` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `patroltask_user` */

DROP TABLE IF EXISTS `patroltask_user`;

CREATE TABLE `patroltask_user` (
  `id` int(6) NOT NULL,
  `pid` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `uid` int(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `pole` */

DROP TABLE IF EXISTS `pole`;

CREATE TABLE `pole` (
  `id` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `lng` double NOT NULL,
  `lat` double NOT NULL,
  `state` int(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `purview` */

DROP TABLE IF EXISTS `purview`;

CREATE TABLE `purview` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `mid` varchar(200) COLLATE utf8_unicode_ci NOT NULL COMMENT '1,10,30',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `receiptdebug` */

DROP TABLE IF EXISTS `receiptdebug`;

CREATE TABLE `receiptdebug` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `did` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `idea` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `state` int(6) NOT NULL,
  `defer` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `bulletin` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `time` date NOT NULL,
  `uid` int(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `receiptpatrol` */

DROP TABLE IF EXISTS `receiptpatrol`;

CREATE TABLE `receiptpatrol` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `ptid` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `pid` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `bid` int(6) NOT NULL,
  `level` int(6) NOT NULL,
  `intact` int(6) NOT NULL,
  `uid` int(6) NOT NULL,
  `time` date NOT NULL,
  `description` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `sys_log` */

DROP TABLE IF EXISTS `sys_log`;

CREATE TABLE `sys_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` varchar(20) DEFAULT NULL COMMENT '请求类型',
  `request_uri` varchar(200) DEFAULT NULL COMMENT '请求URI',
  `http_method` varchar(10) DEFAULT NULL COMMENT '请求方法POST/GET/PUT/DELETE',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `username` varchar(100) DEFAULT NULL COMMENT '用户名',
  `operation` varchar(100) DEFAULT NULL COMMENT '用户操作',
  `time` int(11) DEFAULT NULL COMMENT '响应时间',
  `method` varchar(200) DEFAULT NULL COMMENT '请求方法',
  `params` varchar(500) DEFAULT NULL COMMENT '请求参数',
  `ip` varchar(64) DEFAULT NULL COMMENT 'IP地址',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COMMENT='系统日志';

/*Table structure for table `sys_menu` */

DROP TABLE IF EXISTS `sys_menu`;

CREATE TABLE `sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL COMMENT '菜单名称',
  `url` varchar(100) DEFAULT NULL COMMENT 'URL',
  `icon` varchar(30) DEFAULT NULL COMMENT '图标',
  `pid` int(11) NOT NULL COMMENT '父级菜单ID：一级菜单为0',
  `p_ids` varchar(100) NOT NULL COMMENT '父级菜单列表',
  `perms` varchar(50) DEFAULT NULL COMMENT ' 授权(多个用逗号分隔，如：user:list,user:create)',
  `mtype` int(11) NOT NULL COMMENT '类型 0：目录 1：菜单 2：按钮',
  `available` tinyint(2) NOT NULL COMMENT '是否可用',
  `level` int(5) NOT NULL COMMENT '菜单层级',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL COMMENT '角色名',
  `desc` varchar(100) DEFAULT NULL COMMENT '角色描述',
  `available` tinyint(2) NOT NULL COMMENT '是否可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Table structure for table `sys_role_menu` */

DROP TABLE IF EXISTS `sys_role_menu`;

CREATE TABLE `sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='用户与角色对应关系';

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `sex` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `age` int(6) DEFAULT NULL,
  `joindate` date NOT NULL,
  `leavedate` date DEFAULT NULL,
  `phone` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `state` int(6) NOT NULL,
  `groupid` int(6) DEFAULT NULL,
  `purviewid` int(6) DEFAULT NULL,
  `remark` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `salt` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `icon` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nick_name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_user` (`groupid`),
  KEY `FK_user_role` (`purviewid`),
  CONSTRAINT `FK_user_purview` FOREIGN KEY (`purviewid`) REFERENCES `purview` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
