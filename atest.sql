/*
Navicat MySQL Data Transfer


Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2017-10-22 21:32:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tf_admin
-- ----------------------------
DROP TABLE IF EXISTS `tf_admin`;
CREATE TABLE `tf_admin` (
  `adminId` int(64) NOT NULL,
  `adminName` varchar(50) DEFAULT NULL,
  `adminPwd` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`adminId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tf_admin
-- ----------------------------

-- ----------------------------
-- Table structure for tf_bbs
-- ----------------------------
DROP TABLE IF EXISTS `tf_bbs`;
CREATE TABLE `tf_bbs` (
  `bbsId` int(64) NOT NULL,
  `bbsUsername` varchar(100) DEFAULT NULL,
  `bbsContent` varchar(100) DEFAULT NULL,
  `bbsTitle` varchar(100) DEFAULT NULL,
  `bbsTime` varchar(100) DEFAULT NULL,
  `bbsIP` varchar(100) DEFAULT NULL,
  `bbsRemark` varchar(100) DEFAULT NULL,
  `bbsPic` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`bbsId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tf_bbs
-- ----------------------------
INSERT INTO `tf_bbs` VALUES ('2', '2', '2', '2', '2', '2', '2', '2');

-- ----------------------------
-- Table structure for tf_comment
-- ----------------------------
DROP TABLE IF EXISTS `tf_comment`;
CREATE TABLE `tf_comment` (
  `commentid` int(64) NOT NULL,
  `commenttype` varchar(100) DEFAULT NULL,
  `commentnewid` int(64) DEFAULT NULL,
  `commentname` varchar(100) DEFAULT NULL,
  `commentcount` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`commentid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tf_comment
-- ----------------------------

-- ----------------------------
-- Table structure for tf_news
-- ----------------------------
DROP TABLE IF EXISTS `tf_news`;
CREATE TABLE `tf_news` (
  `newId` int(11) NOT NULL,
  `newTitle` varchar(255) DEFAULT NULL,
  `newContent` varchar(255) DEFAULT NULL,
  `newType` varchar(255) DEFAULT NULL,
  `newTime` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`newId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tf_news
-- ----------------------------
INSERT INTO `tf_news` VALUES ('1111', '1', '1', '1', '11');

-- ----------------------------
-- Table structure for tf_type
-- ----------------------------
DROP TABLE IF EXISTS `tf_type`;
CREATE TABLE `tf_type` (
  `typeId` int(40) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`typeId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tf_type
-- ----------------------------
INSERT INTO `tf_type` VALUES ('1', 'education');

-- ----------------------------
-- Table structure for tf_user
-- ----------------------------
DROP TABLE IF EXISTS `tf_user`;
CREATE TABLE `tf_user` (
  `userId` int(64) NOT NULL,
  `userName` varchar(64) DEFAULT NULL,
  `userSex` varchar(100) DEFAULT NULL,
  `userAge` int(40) DEFAULT NULL,
  `userPassword` varchar(40) DEFAULT NULL,
  `userEmail` varchar(40) DEFAULT NULL,
  `userLike` varchar(100) DEFAULT NULL,
  `userAdd` varchar(100) DEFAULT NULL,
  `userRemark` varchar(100) DEFAULT NULL,
  `userState` int(10) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tf_user
-- ----------------------------
INSERT INTO `tf_user` VALUES ('3', '3', '3', '3', '3', '3', '3', '3', '3', '3');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `password_salt` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_users_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'zhang', '123', null);
