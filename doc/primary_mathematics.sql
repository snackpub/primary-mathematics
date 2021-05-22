/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50709
 Source Host           : localhost:3306
 Source Schema         : primary_mathematics

 Target Server Type    : MySQL
 Target Server Version : 50709
 File Encoding         : 65001

 Date: 22/05/2021 22:13:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for math_problems
-- ----------------------------
DROP TABLE IF EXISTS `math_problems`;
CREATE TABLE `math_problems`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `operand1` bigint(11) NULL DEFAULT NULL COMMENT '运算数1',
  `operand2` bigint(11) NULL DEFAULT NULL COMMENT '运算数2',
  `system_value` float(11, 2) NULL DEFAULT NULL COMMENT '系统值',
  `user_value` float(11, 2) NULL DEFAULT NULL COMMENT '输入值',
  `op` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作符',
  `pra_log_lsh` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '练习信息表主键ID',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `cur_flag` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `level` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 358 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of math_problems
-- ----------------------------
INSERT INTO `math_problems` VALUES (318, 27, 24, 51.00, 1.00, '+', '2d428760a8754c5697b50f2db4dd9001', '2021-05-16 23:32:16', '1', '123', '中级');
INSERT INTO `math_problems` VALUES (319, 10, 9, 90.00, 1.00, '*', '2d428760a8754c5697b50f2db4dd9001', '2021-05-16 23:32:16', '1', '123', '中级');
INSERT INTO `math_problems` VALUES (320, 7, 8, 56.00, 1.00, '*', '2d428760a8754c5697b50f2db4dd9001', '2021-05-16 23:32:16', '1', '123', '中级');
INSERT INTO `math_problems` VALUES (321, 22, 24, 46.00, 1.00, '+', '2d428760a8754c5697b50f2db4dd9001', '2021-05-16 23:32:16', '1', '123', '中级');
INSERT INTO `math_problems` VALUES (322, 6, 5, 30.00, 1.00, '*', '2d428760a8754c5697b50f2db4dd9001', '2021-05-16 23:32:16', '1', '123', '中级');
INSERT INTO `math_problems` VALUES (323, 25, 26, 51.00, 1.00, '+', '2d428760a8754c5697b50f2db4dd9001', '2021-05-16 23:32:16', '1', '123', '中级');
INSERT INTO `math_problems` VALUES (324, 15, 23, 38.00, 1.00, '+', '2d428760a8754c5697b50f2db4dd9001', '2021-05-16 23:32:16', '1', '123', '中级');
INSERT INTO `math_problems` VALUES (325, 7, 6, 42.00, 1.00, '*', '2d428760a8754c5697b50f2db4dd9001', '2021-05-16 23:32:16', '1', '123', '中级');
INSERT INTO `math_problems` VALUES (326, 26, 20, 46.00, 1.00, '+', '2d428760a8754c5697b50f2db4dd9001', '2021-05-16 23:32:16', '1', '123', '中级');
INSERT INTO `math_problems` VALUES (327, 3, 9, 27.00, 1.00, '*', '2d428760a8754c5697b50f2db4dd9001', '2021-05-16 23:32:16', '1', '123', '中级');
INSERT INTO `math_problems` VALUES (328, 26, 10, 16.00, 1.00, '-', 'ea6fbb079f4c4e1ea895a128c9d2bfa7', '2021-05-16 23:34:55', '1', '123', '中级');
INSERT INTO `math_problems` VALUES (329, 6, 9, 54.00, 1.00, '*', 'ea6fbb079f4c4e1ea895a128c9d2bfa7', '2021-05-16 23:34:55', '1', '123', '中级');
INSERT INTO `math_problems` VALUES (330, 8, 12, 20.00, 1.00, '+', 'ea6fbb079f4c4e1ea895a128c9d2bfa7', '2021-05-16 23:34:55', '1', '123', '中级');
INSERT INTO `math_problems` VALUES (331, 5, 5, 25.00, 1.00, '*', 'ea6fbb079f4c4e1ea895a128c9d2bfa7', '2021-05-16 23:34:55', '1', '123', '中级');
INSERT INTO `math_problems` VALUES (332, 1, 9, 9.00, 1.00, '*', 'ea6fbb079f4c4e1ea895a128c9d2bfa7', '2021-05-16 23:34:55', '1', '123', '中级');
INSERT INTO `math_problems` VALUES (333, 3, 26, 29.00, 1.00, '+', 'ea6fbb079f4c4e1ea895a128c9d2bfa7', '2021-05-16 23:34:55', '1', '123', '中级');
INSERT INTO `math_problems` VALUES (334, 24, 7, 31.00, 1.00, '+', 'ea6fbb079f4c4e1ea895a128c9d2bfa7', '2021-05-16 23:34:55', '1', '123', '中级');
INSERT INTO `math_problems` VALUES (335, 7, 28, 35.00, 35.00, '+', 'ea6fbb079f4c4e1ea895a128c9d2bfa7', '2021-05-16 23:34:55', '1', '123', '中级');
INSERT INTO `math_problems` VALUES (336, 5, 12, 17.00, 17.00, '+', 'ea6fbb079f4c4e1ea895a128c9d2bfa7', '2021-05-16 23:34:55', '1', '123', '中级');
INSERT INTO `math_problems` VALUES (337, 22, 23, 45.00, 45.00, '+', 'ea6fbb079f4c4e1ea895a128c9d2bfa7', '2021-05-16 23:34:55', '1', '123', '中级');
INSERT INTO `math_problems` VALUES (338, 8, 7, 56.00, 15.00, '*', '768b8b827bfb4e7cb05af06167536ce7', '2021-05-16 23:36:05', '1', '123', '中级');
INSERT INTO `math_problems` VALUES (339, 8, 13, -5.00, 21.00, '-', '768b8b827bfb4e7cb05af06167536ce7', '2021-05-16 23:36:05', '1', '123', '中级');
INSERT INTO `math_problems` VALUES (340, 23, 25, -2.00, 11.00, '-', '768b8b827bfb4e7cb05af06167536ce7', '2021-05-16 23:36:05', '1', '123', '中级');
INSERT INTO `math_problems` VALUES (341, 7, 20, -13.00, 13.00, '-', '768b8b827bfb4e7cb05af06167536ce7', '2021-05-16 23:36:05', '1', '123', '中级');
INSERT INTO `math_problems` VALUES (342, 30, 14, 16.00, 1.00, '-', '768b8b827bfb4e7cb05af06167536ce7', '2021-05-16 23:36:05', '1', '123', '中级');
INSERT INTO `math_problems` VALUES (343, 8, 21, 29.00, 1.00, '+', '768b8b827bfb4e7cb05af06167536ce7', '2021-05-16 23:36:05', '1', '123', '中级');
INSERT INTO `math_problems` VALUES (344, 21, 19, 40.00, 1.00, '+', '768b8b827bfb4e7cb05af06167536ce7', '2021-05-16 23:36:05', '1', '123', '中级');
INSERT INTO `math_problems` VALUES (345, 21, 12, 9.00, 1.00, '-', '768b8b827bfb4e7cb05af06167536ce7', '2021-05-16 23:36:05', '1', '123', '中级');
INSERT INTO `math_problems` VALUES (346, 8, 14, 22.00, 1.00, '+', '768b8b827bfb4e7cb05af06167536ce7', '2021-05-16 23:36:05', '1', '123', '中级');
INSERT INTO `math_problems` VALUES (347, 18, 23, -5.00, 1.00, '-', '768b8b827bfb4e7cb05af06167536ce7', '2021-05-16 23:36:05', '1', '123', '中级');
INSERT INTO `math_problems` VALUES (348, 4, 29, 33.00, 1.00, '+', 'c62daa935440485ead57282ced840097', '2021-05-16 23:37:25', '0', '123', '中级');
INSERT INTO `math_problems` VALUES (349, 8, 2, 10.00, 1.00, '+', 'c62daa935440485ead57282ced840097', '2021-05-16 23:37:25', '0', '123', '中级');
INSERT INTO `math_problems` VALUES (350, 4, 17, -13.00, 1.00, '-', 'c62daa935440485ead57282ced840097', '2021-05-16 23:37:25', '0', '123', '中级');
INSERT INTO `math_problems` VALUES (351, 18, 21, -3.00, 1.00, '-', 'c62daa935440485ead57282ced840097', '2021-05-16 23:37:25', '0', '123', '中级');
INSERT INTO `math_problems` VALUES (352, 10, 9, 90.00, 1.00, '*', 'c62daa935440485ead57282ced840097', '2021-05-16 23:37:25', '0', '123', '中级');
INSERT INTO `math_problems` VALUES (353, 27, 14, 13.00, 11.00, '-', 'c62daa935440485ead57282ced840097', '2021-05-16 23:37:25', '0', '123', '中级');
INSERT INTO `math_problems` VALUES (354, 25, 28, 53.00, 1.00, '+', 'c62daa935440485ead57282ced840097', '2021-05-16 23:37:25', '0', '123', '中级');
INSERT INTO `math_problems` VALUES (355, 3, 0, 3.00, 1.00, '+', 'c62daa935440485ead57282ced840097', '2021-05-16 23:37:25', '0', '123', '中级');
INSERT INTO `math_problems` VALUES (356, 24, 20, 4.00, 1.00, '-', 'c62daa935440485ead57282ced840097', '2021-05-16 23:37:25', '0', '123', '中级');
INSERT INTO `math_problems` VALUES (357, 20, 15, 35.00, 1.00, '+', 'c62daa935440485ead57282ced840097', '2021-05-16 23:37:25', '0', '123', '中级');

-- ----------------------------
-- Table structure for practice_log
-- ----------------------------
DROP TABLE IF EXISTS `practice_log`;
CREATE TABLE `practice_log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `level` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `count` int(11) NULL DEFAULT NULL,
  `user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `lsh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `cur_flag` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 43 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of practice_log
-- ----------------------------
INSERT INTO `practice_log` VALUES (39, '中级', 10, '1', '2021-05-16 23:32:16', '2d428760a8754c5697b50f2db4dd9001', NULL);
INSERT INTO `practice_log` VALUES (40, '中级', 10, '1', '2021-05-16 23:34:55', 'ea6fbb079f4c4e1ea895a128c9d2bfa7', NULL);
INSERT INTO `practice_log` VALUES (41, '中级', 10, '1', '2021-05-16 23:36:05', '768b8b827bfb4e7cb05af06167536ce7', NULL);
INSERT INTO `practice_log` VALUES (42, '中级', 10, '1', '2021-05-16 23:37:25', 'c62daa935440485ead57282ced840097', NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `lsh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `delflag` int(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'snackpub', '123', '123', 1);

SET FOREIGN_KEY_CHECKS = 1;
