/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2016-06-21 15:40:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) NOT NULL auto_increment,
  `userid` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `content` text NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', '1', 'test_title', 'test_content');
INSERT INTO `article` VALUES ('2', '1', 'test_title_2', 'test_content_2');
INSERT INTO `article` VALUES ('3', '1', 'test_title_3', 'test_content_3');
INSERT INTO `article` VALUES ('4', '1', 'test_title_4', 'test_content_4');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL auto_increment,
  `userName` varchar(50) default NULL,
  `userAge` int(11) default NULL,
  `userAddress` varchar(200) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'summer', '100', 'shanghai,pudong');
INSERT INTO `user` VALUES ('2', 'yy', '80', 'xxxxx');
INSERT INTO `user` VALUES ('5', '??', '80', '????');
INSERT INTO `user` VALUES ('6', '??', '80', '????');
