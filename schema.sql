/*
 Navicat Premium Data Transfer

 Source Server         : 01-人才码测试环境
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : 172.18.231.40:8066
 Source Schema         : talentcode

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 04/11/2021 19:34:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_sys_oper_log
-- ----------------------------
DROP TABLE IF EXISTS `tb_sys_oper_log`;
CREATE TABLE `tb_sys_oper_log` (
  `id` varchar(50) NOT NULL COMMENT 'ID',
  `title` varchar(32) DEFAULT NULL COMMENT '模块标题',
  `business_type` tinyint(4) DEFAULT NULL COMMENT '业务类型（1新增 2修改 3删除 4查询）',
  `method` varchar(128) DEFAULT NULL COMMENT '方法名',
  `request_method` varchar(32) DEFAULT NULL COMMENT '请求方式',
  `operator_type` tinyint(4) DEFAULT NULL COMMENT '操作类别（0其它 1后台用户 2手机端用户）',
  `oper_name` varchar(32) DEFAULT NULL COMMENT '操作人员',
  `oper_id` varchar(50) DEFAULT NULL COMMENT '操作人员ID',
  `dept_name` varchar(32) DEFAULT NULL COMMENT '部门名称',
  `dept_id` varchar(50) DEFAULT NULL COMMENT '部门id',
  `oper_url` varchar(50) DEFAULT NULL COMMENT '请求URL',
  `oper_ip` varchar(32) DEFAULT NULL COMMENT '主机地址',
  `oper_location` varchar(32) DEFAULT NULL COMMENT '操作地点',
  `oper_param` text COMMENT '请求参数',
  `json_result` text COMMENT '返回参数',
  `status` tinyint(4) DEFAULT NULL COMMENT '操作状态（0正常 1异常）',
  `error_msg` varchar(500) DEFAULT NULL COMMENT '错误消息',
  `oper_time` datetime DEFAULT NULL COMMENT '操作时间',
  `created_by` varchar(100) DEFAULT NULL COMMENT '创建人',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(100) DEFAULT NULL COMMENT '更新人',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统操作日志表';

SET FOREIGN_KEY_CHECKS = 1;
