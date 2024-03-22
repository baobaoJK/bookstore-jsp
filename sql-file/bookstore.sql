/*
 Navicat Premium Data Transfer

 Source Server         : Localhost
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : bookstore

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 22/03/2024 15:13:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book_list
-- ----------------------------
DROP TABLE IF EXISTS `book_list`;
CREATE TABLE `book_list`  (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `book_class` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `author` varchar(25) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `publish` varchar(150) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `book_no` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `content` varchar(4000) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `price` float(8, 1) NULL DEFAULT NULL,
  `amount` int(25) NULL DEFAULT NULL,
  `surplus` int(25) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book_list
-- ----------------------------
INSERT INTO `book_list` VALUES (1, '房龙地理', '地理', '房龙', '文汇出版社', '9780000000001', '房龙地理', 29.0, 100, 100);
INSERT INTO `book_list` VALUES (2, '地理学与生活', '地理', '[美] 阿瑟·格蒂斯 ', '世界图书出版公司', '9780000000002', '地理学与生活', 49.0, 100, 100);
INSERT INTO `book_list` VALUES (3, '古老阳光的末日', '地理', 'Thom Hartmann', '上海远东出版社', '9780000000003', '古老阳光的末日', 20.0, 100, 100);
INSERT INTO `book_list` VALUES (4, '洞穴奇案', '法律', '[美] 萨伯', '生活.读书.新知三联书店', '9780000000004', '洞穴奇案', 18.0, 100, 100);
INSERT INTO `book_list` VALUES (5, '西窗法雨', '法律', '刘星', '法律出版社', '9780000000005', '西窗法雨', 24.0, 100, 100);
INSERT INTO `book_list` VALUES (6, '审判为什么不公正', '法律', '[英] 卡德里', '新星出版社', '9780000000006', '审判为什么不公正', 49.5, 100, 100);
INSERT INTO `book_list` VALUES (7, '亮剑（舒适阅读版）', '军事', '都梁', '北京联合出版公司', '9780000000007', '亮剑（舒适阅读版）', 45.0, 100, 100);
INSERT INTO `book_list` VALUES (8, '二战记忆 安妮日记', '军事', '[德] 安妮·弗兰克', '人民文学出版社', '9780000000008', '二战记忆 安妮日记', 23.0, 100, 100);
INSERT INTO `book_list` VALUES (9, '亮剑', '军事', '都梁', '解放军文艺出版社', '9780000000009', '亮剑', 25.0, 100, 100);
INSERT INTO `book_list` VALUES (10, '历史是什么？', '历史', '爱德华·霍列特·卡尔', '商务印书馆', '9780000000010', '历史是什么？', 19.0, 100, 100);
INSERT INTO `book_list` VALUES (11, '中国史学史', '历史', '金毓黻', '商务印书馆', '9780000000011', '中国史学史', 19.0, 100, 100);
INSERT INTO `book_list` VALUES (12, '史记选', '历史', '[清] 储欣', '商务印书馆', '9780000000012', '史记选', 48.0, 100, 100);
INSERT INTO `book_list` VALUES (13, 'Java从入门到精通 ', '计算机', '明日科技', '清华大学出版社', '9780000000013', 'Java从入门到精通 ', 69.0, 100, 100);
INSERT INTO `book_list` VALUES (14, 'C++从入门到精通', '计算机', '李伟明', '清华大学出版社', '9780000000014', 'C++从入门到精通', 49.0, 100, 100);
INSERT INTO `book_list` VALUES (15, 'PHP从入门到精通', '计算机', '千锋教育高教产品研发部', '清华大学出版社', '9780000000015', 'PHP从入门到精通', 59.0, 100, 100);

-- ----------------------------
-- Table structure for cart_list
-- ----------------------------
DROP TABLE IF EXISTS `cart_list`;
CREATE TABLE `cart_list`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NULL DEFAULT NULL,
  `book_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `author` varchar(40) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `book_class` varchar(40) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `price` float(10, 2) NULL DEFAULT NULL,
  `amount` int(10) NULL DEFAULT NULL,
  `book_id` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cart_list
-- ----------------------------

-- ----------------------------
-- Table structure for order_list
-- ----------------------------
DROP TABLE IF EXISTS `order_list`;
CREATE TABLE `order_list`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `indent_no` int(20) NULL DEFAULT NULL,
  `user_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `user_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `submit_time` datetime(0) NULL DEFAULT NULL,
  `consignment_time` datetime(0) NULL DEFAULT NULL,
  `total_price` float(8, 2) NULL DEFAULT NULL,
  `content` varchar(400) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `is_pay_off` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `is_sales` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `book_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_list
-- ----------------------------

-- ----------------------------
-- Table structure for user_list
-- ----------------------------
DROP TABLE IF EXISTS `user_list`;
CREATE TABLE `user_list`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `pass_word` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `names` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `phone` varchar(25) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `post` varchar(8) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `reg_time` datetime(0) NULL DEFAULT NULL,
  `reg_ip_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_list
-- ----------------------------
INSERT INTO `user_list` VALUES (1, 'admin', '123456', 'Admin', '1', '233', '13700000000', '530001', 'admin@qq.com', NULL, NULL);
INSERT INTO `user_list` VALUES (2, 'user01', '123456', '用户', '男', '成华大道 99 号', '12345678910', '530001', 'test@qq.com', '2024-03-22 14:48:56', '0:0:0:0:0:0:0:1');

SET FOREIGN_KEY_CHECKS = 1;
