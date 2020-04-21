/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.16.47
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : 192.168.16.47:3306
 Source Schema         : forum

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 21/04/2020 19:03:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_at` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_at` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `user_id` int(0) NOT NULL COMMENT '创建人',
  `title` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '文章标题',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章内容',
  `status` tinyint(0) NOT NULL DEFAULT 0 COMMENT '文章状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for article_collect
-- ----------------------------
DROP TABLE IF EXISTS `article_collect`;
CREATE TABLE `article_collect`  (
  `id` int(0) NOT NULL COMMENT '主键',
  `create_at` datetime(0) NOT NULL COMMENT '创建时间',
  `update_at` datetime(0) NOT NULL COMMENT '更新时间',
  `article_id` int(0) NOT NULL COMMENT '文章 ID',
  `user_id` int(0) NOT NULL COMMENT '用户 ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for article_comment
-- ----------------------------
DROP TABLE IF EXISTS `article_comment`;
CREATE TABLE `article_comment`  (
  `id` int(0) NOT NULL COMMENT '主键',
  `create_at` datetime(0) NOT NULL COMMENT '创建时间',
  `update_at` datetime(0) NOT NULL COMMENT '更新时间',
  `article_id` int(0) NOT NULL COMMENT '文章 ID',
  `user_id` int(0) NOT NULL COMMENT '用户 ID',
  `parent_id` int(0) NOT NULL COMMENT '父评论 ID',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评论内容',
  `disagree` int(0) NOT NULL DEFAULT 0 COMMENT '不赞同数量',
  `agree` int(0) NOT NULL COMMENT '赞同数量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for article_like
-- ----------------------------
DROP TABLE IF EXISTS `article_like`;
CREATE TABLE `article_like`  (
  `id` int(0) NOT NULL COMMENT '主键',
  `create_at` datetime(0) NOT NULL COMMENT '创建时间',
  `update_at` datetime(0) NOT NULL COMMENT '更新时间',
  `article_id` int(0) NOT NULL COMMENT '文章 ID',
  `user_id` int(0) NOT NULL COMMENT '用户 ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for article_tag
-- ----------------------------
DROP TABLE IF EXISTS `article_tag`;
CREATE TABLE `article_tag`  (
  `id` int(0) NOT NULL COMMENT '主键',
  `create_at` datetime(0) NOT NULL COMMENT '创建时间',
  `update_at` datetime(0) NOT NULL COMMENT '更新时间',
  `type_id` int(0) NOT NULL COMMENT '所属类型 ID',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标签名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for article_type
-- ----------------------------
DROP TABLE IF EXISTS `article_type`;
CREATE TABLE `article_type`  (
  `id` int(0) NOT NULL COMMENT '主键',
  `create_at` datetime(0) NOT NULL COMMENT '创建时间',
  `update_at` datetime(0) NOT NULL COMMENT '更新时间',
  `article_id` int(0) NOT NULL COMMENT '文章 ID',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类型名称',
  `parent_id` int(0) NOT NULL COMMENT '父类型 ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for article_view
-- ----------------------------
DROP TABLE IF EXISTS `article_view`;
CREATE TABLE `article_view`  (
  `id` int(0) NOT NULL COMMENT '主键',
  `create_at` datetime(0) NOT NULL COMMENT '创建时间',
  `update_at` datetime(0) NOT NULL COMMENT '更新时间',
  `article_id` int(0) NOT NULL COMMENT '文章 ID',
  `user_id` int(0) NOT NULL COMMENT '用户 ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo`  (
  `id` int(0) NOT NULL COMMENT '主键',
  `create_at` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_at` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '用户名称',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '用户密码',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '用户邮箱',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
