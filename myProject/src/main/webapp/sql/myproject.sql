/*
Navicat MySQL Data Transfer

Source Server         : text
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : myproject

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-08-30 17:22:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for indexbanner
-- ----------------------------
DROP TABLE IF EXISTS `indexbanner`;
CREATE TABLE `indexbanner` (
  `USERID` varchar(255) NOT NULL,
  `BANNERIMG` varchar(255) NOT NULL,
  `IMGID` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of indexbanner
-- ----------------------------
INSERT INTO `indexbanner` VALUES ('4e0cab8b-8f68-444f-9608-5bd4abe1c7f1', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1535620875033&di=2d36a0a98a60f792c525704e2031b3c3&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2Fd%2F57bd528d47da5.jpg', '66b2ac2e-359c-4f99-9b12-6c9834368b88');
INSERT INTO `indexbanner` VALUES ('4e0cab8b-8f68-444f-9608-5bd4abe1c7f1', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1535620963180&di=92f33e8eb4d6611066dea592e4a33575&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F010f2a5944bc9ba8012193a3190f53.jpg%402o.jpg', '0c87ff74-521e-4cde-a260-ba86af6f6b75');
INSERT INTO `indexbanner` VALUES ('4e0cab8b-8f68-444f-9608-5bd4abe1c7f1', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1535621212150&di=2730b6e2e1d51ad9738702996a80291d&imgtype=0&src=http%3A%2F%2Fe.hiphotos.baidu.com%2Fzhidao%2Fpic%2Fitem%2F09fa513d269759ee499be2e8bafb43166c22dfce.jpg', 'a527ea38-1862-4fad-bb2a-fb217b23f989');
INSERT INTO `indexbanner` VALUES ('4e0cab8b-8f68-444f-9608-5bd4abe1c7f1', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1535621318785&di=8e3cf658aebbc311620002cebf63641d&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F1%2F56821f9024876.jpg', '430d1428-bfd9-416c-9563-22efc6e58996');

-- ----------------------------
-- Table structure for listimg
-- ----------------------------
DROP TABLE IF EXISTS `listimg`;
CREATE TABLE `listimg` (
  `USERID` varchar(255) NOT NULL,
  PRIMARY KEY (`USERID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of listimg
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `USERID` varchar(255) NOT NULL,
  `USERNAME` varchar(255) NOT NULL,
  `JOINDATE` datetime NOT NULL,
  `LOGOUT` tinytext,
  `PASSWORD` varchar(255) NOT NULL,
  PRIMARY KEY (`USERID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
