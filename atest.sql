/*
Navicat MySQL Data Transfer

Source Server         : 10.10.69.131_3306
Source Server Version : 50711
Source Host           : 10.10.69.131:3306
Source Database       : atest

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2017-10-23 08:57:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tf_admin
-- ----------------------------
DROP TABLE IF EXISTS `tf_admin`;
CREATE TABLE `tf_admin` (
  `adminId` int(64) NOT NULL,
  `adminName` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `adminPwd` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`adminId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tf_admin
-- ----------------------------
INSERT INTO `tf_admin` VALUES ('1', 'admin', 'admin');

-- ----------------------------
-- Table structure for tf_bbs
-- ----------------------------
DROP TABLE IF EXISTS `tf_bbs`;
CREATE TABLE `tf_bbs` (
  `bbsId` int(64) NOT NULL,
  `bbsUsername` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `bbsContent` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `bbsTitle` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `bbsTime` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `bbsIP` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `bbsRemark` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `bbsPic` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
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
  `commenttype` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `commentnewid` int(64) DEFAULT NULL,
  `commentname` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `commentcount` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
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
  `newId` int(11) NOT NULL AUTO_INCREMENT,
  `newTitle` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `newContent` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `newType` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `newTime` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`newId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tf_news
-- ----------------------------
INSERT INTO `tf_news` VALUES ('1', '留学生归国就业受挫，留学究竟值不值？', '日前再次出现有关“留学生归国就业受挫”的热议。据《春城晚报》报道，在采访多位留学生后发现，“他们普遍认为留学是宝贵的人生经历，但面对严峻的就业形势，不少受访者都表现出巨大的心理落差”。', '教育', '2017-10-23 08:37:24');
INSERT INTO `tf_news` VALUES ('2', '留学生万里回家帮父母卖葱，看到父母劳累身影黯然落泪', '留学德国的吴斌是个品学兼优的江南学子，父母在乡下种田，每天忙得没日没夜。前段时间，家里的几亩葱赶着要上市。心疼父母，本来要做毕业设计的吴斌跟导师请了一个月的假，用打工攒的钱买了机票，专程回国帮父母干农活。返程时，行李箱被母亲塞满了各种家乡味。', '社会', '2014-06-06 09:09:00');

-- ----------------------------
-- Table structure for tf_type
-- ----------------------------
DROP TABLE IF EXISTS `tf_type`;
CREATE TABLE `tf_type` (
  `typeId` int(40) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`typeId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tf_type
-- ----------------------------
INSERT INTO `tf_type` VALUES ('1', '教育');
INSERT INTO `tf_type` VALUES ('2', '财经');
INSERT INTO `tf_type` VALUES ('3', '娱乐');
INSERT INTO `tf_type` VALUES ('4', '科技');
INSERT INTO `tf_type` VALUES ('5', '体育');
INSERT INTO `tf_type` VALUES ('6', '医疗');
INSERT INTO `tf_type` VALUES ('7', '历史');
INSERT INTO `tf_type` VALUES ('8', '社会');

-- ----------------------------
-- Table structure for tf_user
-- ----------------------------
DROP TABLE IF EXISTS `tf_user`;
CREATE TABLE `tf_user` (
  `userId` int(64) NOT NULL,
  `userName` varchar(64) CHARACTER SET utf8 DEFAULT NULL,
  `userSex` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `userAge` int(40) DEFAULT NULL,
  `userPassword` varchar(40) CHARACTER SET utf8 DEFAULT NULL,
  `userEmail` varchar(40) CHARACTER SET utf8 DEFAULT NULL,
  `userLike` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `userAdd` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `userRemark` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `userState` int(10) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tf_user
-- ----------------------------
INSERT INTO `tf_user` VALUES ('1', '管理员', '男', '23', 'admin', 'admin@163.com', '羽毛球', '深圳福田', '超级管理员', '1');

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
