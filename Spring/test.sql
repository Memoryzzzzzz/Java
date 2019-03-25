/*
Navicat MySQL Data Transfer

Source Server         : LocahostTest
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2019-03-25 20:13:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `username` varchar(20) NOT NULL,
  `balance` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账户表';

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('AA', '60');

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `isbn` int(10) NOT NULL,
  `book_name` varchar(20) NOT NULL,
  `price` double(10,2) NOT NULL,
  PRIMARY KEY (`isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1001', 'Java', '100.00');
INSERT INTO `book` VALUES ('1002', 'Oracle', '70.00');

-- ----------------------------
-- Table structure for book_stock
-- ----------------------------
DROP TABLE IF EXISTS `book_stock`;
CREATE TABLE `book_stock` (
  `isbn` int(11) NOT NULL,
  `stock` int(11) NOT NULL,
  PRIMARY KEY (`isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='书-库存表';

-- ----------------------------
-- Records of book_stock
-- ----------------------------
INSERT INTO `book_stock` VALUES ('1001', '8');
INSERT INTO `book_stock` VALUES ('1002', '8');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `c` int(11) NOT NULL DEFAULT '0',
  `cname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `tid` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`c`),
  KEY `idx_cname` (`cname`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '语文', '1');
INSERT INTO `course` VALUES ('2', '数学', '2');
INSERT INTO `course` VALUES ('3', '英语', '3');
INSERT INTO `course` VALUES ('4', '物理', '4');

-- ----------------------------
-- Table structure for employees
-- ----------------------------
DROP TABLE IF EXISTS `employees`;
CREATE TABLE `employees` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '学生姓名',
  `age` int(11) NOT NULL DEFAULT '0' COMMENT '年龄',
  `email` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='学生表';

-- ----------------------------
-- Records of employees
-- ----------------------------
INSERT INTO `employees` VALUES ('1', '小明', '21', '111');
INSERT INTO `employees` VALUES ('2', '小红', '20', '222');
INSERT INTO `employees` VALUES ('3', '小兰', '22', '222');
INSERT INTO `employees` VALUES ('4', 'AA', '20', '3232');
INSERT INTO `employees` VALUES ('5', 'BB', '21', '323');
INSERT INTO `employees` VALUES ('6', 'CC', '22', '323');
INSERT INTO `employees` VALUES ('7', 'GG', '23', 'GG@test.com');
INSERT INTO `employees` VALUES ('8', 'ZZ', '22', 'zz@test.com');

-- ----------------------------
-- Table structure for score_course
-- ----------------------------
DROP TABLE IF EXISTS `score_course`;
CREATE TABLE `score_course` (
  `sid` int(11) NOT NULL DEFAULT '0',
  `cid` int(11) NOT NULL DEFAULT '0',
  `score` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of score_course
-- ----------------------------
INSERT INTO `score_course` VALUES ('1', '1', '56');
INSERT INTO `score_course` VALUES ('1', '2', '78');
INSERT INTO `score_course` VALUES ('1', '3', '67');
INSERT INTO `score_course` VALUES ('1', '4', '58');
INSERT INTO `score_course` VALUES ('2', '1', '79');
INSERT INTO `score_course` VALUES ('2', '2', '81');
INSERT INTO `score_course` VALUES ('2', '3', '92');
INSERT INTO `score_course` VALUES ('2', '4', '68');
INSERT INTO `score_course` VALUES ('3', '1', '91');
INSERT INTO `score_course` VALUES ('3', '2', '47');
INSERT INTO `score_course` VALUES ('3', '3', '88');
INSERT INTO `score_course` VALUES ('3', '4', '56');
INSERT INTO `score_course` VALUES ('4', '2', '88');
INSERT INTO `score_course` VALUES ('4', '3', '90');
INSERT INTO `score_course` VALUES ('4', '4', '93');
INSERT INTO `score_course` VALUES ('5', '1', '46');
INSERT INTO `score_course` VALUES ('5', '3', '78');
INSERT INTO `score_course` VALUES ('5', '4', '53');
INSERT INTO `score_course` VALUES ('6', '1', '35');
INSERT INTO `score_course` VALUES ('6', '2', '68');
INSERT INTO `score_course` VALUES ('6', '4', '71');
INSERT INTO `score_course` VALUES ('6', '3', '99');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `sid` int(11) NOT NULL DEFAULT '0' COMMENT '学号',
  `sname` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '学生姓名',
  `sage` int(11) NOT NULL DEFAULT '0' COMMENT '年龄',
  `ssex` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '性别',
  PRIMARY KEY (`sid`),
  KEY `idx_sname` (`sname`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生表';

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '刘一', '18', '男');
INSERT INTO `student` VALUES ('2', '钱二', '19', '女');
INSERT INTO `student` VALUES ('3', '张三', '17', '男');
INSERT INTO `student` VALUES ('4', '李四', '18', '女');
INSERT INTO `student` VALUES ('5', '王五', '17', '男');
INSERT INTO `student` VALUES ('6', '赵六', '19', '女');

-- ----------------------------
-- Table structure for tb_student
-- ----------------------------
DROP TABLE IF EXISTS `tb_student`;
CREATE TABLE `tb_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `snum` int(11) NOT NULL DEFAULT '0' COMMENT '学号',
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '学生姓名',
  `age` int(11) NOT NULL DEFAULT '0' COMMENT '年龄',
  `sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '性别',
  `class_id` int(11) NOT NULL DEFAULT '0' COMMENT '班级id',
  PRIMARY KEY (`id`),
  KEY `idx_sname` (`class_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='学生表';

-- ----------------------------
-- Records of tb_student
-- ----------------------------
INSERT INTO `tb_student` VALUES ('1', '2147483647', '小明', '21', '男', '1013');
INSERT INTO `tb_student` VALUES ('2', '2147483647', '小红', '20', '女', '1014');
INSERT INTO `tb_student` VALUES ('3', '2147483647', '小兰', '22', '男', '1014');
INSERT INTO `tb_student` VALUES ('13', '2147483647', 'AA', '20', '男', '1013');
INSERT INTO `tb_student` VALUES ('14', '2147483647', 'BB', '21', '女', '1014');
INSERT INTO `tb_student` VALUES ('15', '2147483647', 'CC', '22', '女', '1013');
INSERT INTO `tb_student` VALUES ('16', '2147483647', 'AA', '20', '男', '1013');
INSERT INTO `tb_student` VALUES ('17', '2147483647', 'BB', '21', '女', '1014');
INSERT INTO `tb_student` VALUES ('18', '2147483647', 'CC', '22', '女', '1013');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `t` int(11) NOT NULL DEFAULT '0',
  `tname` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`t`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '叶平');
INSERT INTO `teacher` VALUES ('2', '贺高');
INSERT INTO `teacher` VALUES ('3', '杨艳');
INSERT INTO `teacher` VALUES ('4', '周磊');
