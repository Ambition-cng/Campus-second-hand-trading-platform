/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : localhost:3306
 Source Schema         : trading_platform

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 12/05/2022 01:01:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for item
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item`  (
  `itemid` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键，用作内部标识',
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '外键，发布该商品的用户昵称',
  `itemname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '商品名称',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '商品描述',
  `price` decimal(10, 2) NOT NULL COMMENT '商品价格',
  `sort` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '商品类别',
  `count` int(0) NOT NULL COMMENT '商品数量',
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '商品的图片地址',
  PRIMARY KEY (`itemid`) USING BTREE,
  INDEX `username_item_fk`(`username`) USING BTREE,
  CONSTRAINT `username_item_fk` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of item
-- ----------------------------
INSERT INTO `item` VALUES (1, 'cccccf', '手机', '出一个备用机，用了大概3年，现在不用想出掉，十一成新，可小刀', 999.00, '电子产品', 1, 'www.baidu.com');

-- ----------------------------
-- Table structure for item_comment
-- ----------------------------
DROP TABLE IF EXISTS `item_comment`;
CREATE TABLE `item_comment`  (
  `commentid` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键，用作内部标识',
  `itemid` int(0) NOT NULL COMMENT '外键，绑定商品id',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '留言内容，json 字符串格式，包含有留言时间(time)、留言用户昵称(username)、留言内容(msg)',
  PRIMARY KEY (`commentid`) USING BTREE,
  INDEX `itemid_fk`(`itemid`) USING BTREE,
  CONSTRAINT `itemid_fk` FOREIGN KEY (`itemid`) REFERENCES `item` (`itemid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of item_comment
-- ----------------------------
INSERT INTO `item_comment` VALUES (1, 1, '{\r\n    \"time\":\"2022.5.12 01:01\",\r\n    \"username\":\"sbhly\",\r\n    \"msg\":\"我急需一部手机，但999似乎太贵了，我可以出20，意思是我想白嫖，怎么说\"\r\n}');
INSERT INTO `item_comment` VALUES (2, 1, '{\r\n    \"time\":\"2022.5.12 01:03\",\r\n    \"username\":\"cccccf\",\r\n    \"msg\":\"你说nm呢\"\r\n}');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uid` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键，用户名(账号)，用作登录时使用',
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户昵称',
  `password` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '登录密码',
  `phone` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户手机号码',
  `stuno` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户学号',
  `gender` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '性别(男/女)',
  PRIMARY KEY (`uid`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1539792251', 'cccccf', 'woshinimendedie', '15952128595', '19030500015', '男');
INSERT INTO `user` VALUES ('2878153350', 'sbhly', 'woshicfdehaodaer', 'xxxxxx', '19030500126', '女');

-- ----------------------------
-- Table structure for user_item
-- ----------------------------
DROP TABLE IF EXISTS `user_item`;
CREATE TABLE `user_item`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键，用作内部标识',
  `uid` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '外键，绑定用户名(账户)',
  `itemid` int(0) NOT NULL COMMENT '外键，绑定商品id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `bind_user_fk`(`uid`) USING BTREE,
  INDEX `bind_item_fk`(`itemid`) USING BTREE,
  CONSTRAINT `bind_item_fk` FOREIGN KEY (`itemid`) REFERENCES `item` (`itemid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `bind_user_fk` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_item
-- ----------------------------
INSERT INTO `user_item` VALUES (1, '1539792251', 1);

-- ----------------------------
-- Table structure for user_want_item
-- ----------------------------
DROP TABLE IF EXISTS `user_want_item`;
CREATE TABLE `user_want_item`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键，用作内部标识',
  `uid` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '外键，绑定用户名(账户)',
  `itemid` int(0) NOT NULL COMMENT '外键，绑定求购商品id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `bind_want_item_fk`(`itemid`) USING BTREE,
  INDEX `bind_want_user_fk`(`uid`) USING BTREE,
  CONSTRAINT `bind_want_user_fk` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `bind_want_item_fk` FOREIGN KEY (`itemid`) REFERENCES `want_item` (`itemid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_want_item
-- ----------------------------
INSERT INTO `user_want_item` VALUES (1, '2878153350', 1);

-- ----------------------------
-- Table structure for want_item
-- ----------------------------
DROP TABLE IF EXISTS `want_item`;
CREATE TABLE `want_item`  (
  `itemid` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键，用作内部标识',
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '外键，发表该求购商品的用户昵称',
  `itemname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '求购商品名称',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '求购商品描述',
  `price` decimal(10, 2) NOT NULL COMMENT '求购商品价格预期',
  `sort` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '求购商品类别',
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '求购商品的图片地址',
  PRIMARY KEY (`itemid`) USING BTREE,
  INDEX `username_want_item_fk`(`username`) USING BTREE,
  INDEX `itemid`(`itemid`, `price`) USING BTREE,
  INDEX `price`(`price`) USING BTREE,
  CONSTRAINT `username_want_item_fk` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of want_item
-- ----------------------------
INSERT INTO `want_item` VALUES (1, 'sbhly', '手机或ipad', '急需一部可以上网的设备！！！想要边玩元神边农边导，只有一部手机和一个ipad远不能满足！！！', 10.00, '电子产品', 'www.sbhly.com');

-- ----------------------------
-- Table structure for want_item_comment
-- ----------------------------
DROP TABLE IF EXISTS `want_item_comment`;
CREATE TABLE `want_item_comment`  (
  `commentid` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键，用作内部标识',
  `itemid` int(0) NOT NULL COMMENT '外键，绑定求购商品id',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '留言内容，json 字符串格式，包含有留言时间(time)、留言用户昵称(username)、留言内容(msg)',
  PRIMARY KEY (`commentid`) USING BTREE,
  INDEX `want_itemid_fk`(`itemid`) USING BTREE,
  CONSTRAINT `want_itemid_fk` FOREIGN KEY (`itemid`) REFERENCES `want_item` (`itemid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of want_item_comment
-- ----------------------------
INSERT INTO `want_item_comment` VALUES (1, 1, '{\r\n    \"time\":\"2022.5.12 00:57\",\r\n    \"username\":\"cccccf\",\r\n    \"msg\":\"shabi\"\r\n}');
INSERT INTO `want_item_comment` VALUES (2, 1, '{\r\n    \"time\":\"2022.5.12 01:00\",\r\n    \"username\":\"sbhly\",\r\n    \"msg\":\"啊对对对\"\r\n}');

SET FOREIGN_KEY_CHECKS = 1;
