/*
 Navicat Premium Data Transfer

 Source Server         : aliyun
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : 47.102.120.60:3306
 Source Schema         : cloud

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 13/12/2019 19:30:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for QRTZ_BLOB_TRIGGERS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_BLOB_TRIGGERS`;
CREATE TABLE `QRTZ_BLOB_TRIGGERS` (
                                      `SCHED_NAME` varchar(120) COLLATE utf8mb4_bin NOT NULL,
                                      `TRIGGER_NAME` varchar(200) COLLATE utf8mb4_bin NOT NULL,
                                      `TRIGGER_GROUP` varchar(200) COLLATE utf8mb4_bin NOT NULL,
                                      `BLOB_DATA` blob,
                                      PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
                                      CONSTRAINT `QRTZ_BLOB_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `QRTZ_TRIGGERS` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for QRTZ_CALENDARS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_CALENDARS`;
CREATE TABLE `QRTZ_CALENDARS` (
                                  `SCHED_NAME` varchar(120) COLLATE utf8mb4_bin NOT NULL,
                                  `CALENDAR_NAME` varchar(200) COLLATE utf8mb4_bin NOT NULL,
                                  `CALENDAR` blob NOT NULL,
                                  PRIMARY KEY (`SCHED_NAME`,`CALENDAR_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for QRTZ_CRON_TRIGGERS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_CRON_TRIGGERS`;
CREATE TABLE `QRTZ_CRON_TRIGGERS` (
                                      `SCHED_NAME` varchar(120) COLLATE utf8mb4_bin NOT NULL,
                                      `TRIGGER_NAME` varchar(200) COLLATE utf8mb4_bin NOT NULL,
                                      `TRIGGER_GROUP` varchar(200) COLLATE utf8mb4_bin NOT NULL,
                                      `CRON_EXPRESSION` varchar(200) COLLATE utf8mb4_bin NOT NULL,
                                      `TIME_ZONE_ID` varchar(80) COLLATE utf8mb4_bin DEFAULT NULL,
                                      PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
                                      CONSTRAINT `QRTZ_CRON_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `QRTZ_TRIGGERS` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for QRTZ_FIRED_TRIGGERS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_FIRED_TRIGGERS`;
CREATE TABLE `QRTZ_FIRED_TRIGGERS` (
                                       `SCHED_NAME` varchar(120) COLLATE utf8mb4_bin NOT NULL,
                                       `ENTRY_ID` varchar(95) COLLATE utf8mb4_bin NOT NULL,
                                       `TRIGGER_NAME` varchar(200) COLLATE utf8mb4_bin NOT NULL,
                                       `TRIGGER_GROUP` varchar(200) COLLATE utf8mb4_bin NOT NULL,
                                       `INSTANCE_NAME` varchar(200) COLLATE utf8mb4_bin NOT NULL,
                                       `FIRED_TIME` bigint(13) NOT NULL,
                                       `SCHED_TIME` bigint(13) NOT NULL,
                                       `PRIORITY` int(11) NOT NULL,
                                       `STATE` varchar(16) COLLATE utf8mb4_bin NOT NULL,
                                       `JOB_NAME` varchar(200) COLLATE utf8mb4_bin DEFAULT NULL,
                                       `JOB_GROUP` varchar(200) COLLATE utf8mb4_bin DEFAULT NULL,
                                       `IS_NONCONCURRENT` varchar(1) COLLATE utf8mb4_bin DEFAULT NULL,
                                       `REQUESTS_RECOVERY` varchar(1) COLLATE utf8mb4_bin DEFAULT NULL,
                                       PRIMARY KEY (`SCHED_NAME`,`ENTRY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for QRTZ_JOB_DETAILS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_JOB_DETAILS`;
CREATE TABLE `QRTZ_JOB_DETAILS` (
                                    `SCHED_NAME` varchar(120) COLLATE utf8mb4_bin NOT NULL,
                                    `JOB_NAME` varchar(200) COLLATE utf8mb4_bin NOT NULL,
                                    `JOB_GROUP` varchar(200) COLLATE utf8mb4_bin NOT NULL,
                                    `DESCRIPTION` varchar(250) COLLATE utf8mb4_bin DEFAULT NULL,
                                    `JOB_CLASS_NAME` varchar(250) COLLATE utf8mb4_bin NOT NULL,
                                    `IS_DURABLE` varchar(1) COLLATE utf8mb4_bin NOT NULL,
                                    `IS_NONCONCURRENT` varchar(1) COLLATE utf8mb4_bin NOT NULL,
                                    `IS_UPDATE_DATA` varchar(1) COLLATE utf8mb4_bin NOT NULL,
                                    `REQUESTS_RECOVERY` varchar(1) COLLATE utf8mb4_bin NOT NULL,
                                    `JOB_DATA` blob,
                                    PRIMARY KEY (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for QRTZ_LOCKS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_LOCKS`;
CREATE TABLE `QRTZ_LOCKS` (
                              `SCHED_NAME` varchar(120) COLLATE utf8mb4_bin NOT NULL,
                              `LOCK_NAME` varchar(40) COLLATE utf8mb4_bin NOT NULL,
                              PRIMARY KEY (`SCHED_NAME`,`LOCK_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for QRTZ_PAUSED_TRIGGER_GRPS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_PAUSED_TRIGGER_GRPS`;
CREATE TABLE `QRTZ_PAUSED_TRIGGER_GRPS` (
                                            `SCHED_NAME` varchar(120) COLLATE utf8mb4_bin NOT NULL,
                                            `TRIGGER_GROUP` varchar(200) COLLATE utf8mb4_bin NOT NULL,
                                            PRIMARY KEY (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for QRTZ_SCHEDULER_STATE
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_SCHEDULER_STATE`;
CREATE TABLE `QRTZ_SCHEDULER_STATE` (
                                        `SCHED_NAME` varchar(120) COLLATE utf8mb4_bin NOT NULL,
                                        `INSTANCE_NAME` varchar(200) COLLATE utf8mb4_bin NOT NULL,
                                        `LAST_CHECKIN_TIME` bigint(13) NOT NULL,
                                        `CHECKIN_INTERVAL` bigint(13) NOT NULL,
                                        PRIMARY KEY (`SCHED_NAME`,`INSTANCE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for QRTZ_SIMPLE_TRIGGERS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_SIMPLE_TRIGGERS`;
CREATE TABLE `QRTZ_SIMPLE_TRIGGERS` (
                                        `SCHED_NAME` varchar(120) COLLATE utf8mb4_bin NOT NULL,
                                        `TRIGGER_NAME` varchar(200) COLLATE utf8mb4_bin NOT NULL,
                                        `TRIGGER_GROUP` varchar(200) COLLATE utf8mb4_bin NOT NULL,
                                        `REPEAT_COUNT` bigint(7) NOT NULL,
                                        `REPEAT_INTERVAL` bigint(12) NOT NULL,
                                        `TIMES_TRIGGERED` bigint(10) NOT NULL,
                                        PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
                                        CONSTRAINT `QRTZ_SIMPLE_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `QRTZ_TRIGGERS` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for QRTZ_SIMPROP_TRIGGERS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_SIMPROP_TRIGGERS`;
CREATE TABLE `QRTZ_SIMPROP_TRIGGERS` (
                                         `SCHED_NAME` varchar(120) COLLATE utf8mb4_bin NOT NULL,
                                         `TRIGGER_NAME` varchar(200) COLLATE utf8mb4_bin NOT NULL,
                                         `TRIGGER_GROUP` varchar(200) COLLATE utf8mb4_bin NOT NULL,
                                         `STR_PROP_1` varchar(512) COLLATE utf8mb4_bin DEFAULT NULL,
                                         `STR_PROP_2` varchar(512) COLLATE utf8mb4_bin DEFAULT NULL,
                                         `STR_PROP_3` varchar(512) COLLATE utf8mb4_bin DEFAULT NULL,
                                         `INT_PROP_1` int(11) DEFAULT NULL,
                                         `INT_PROP_2` int(11) DEFAULT NULL,
                                         `LONG_PROP_1` bigint(20) DEFAULT NULL,
                                         `LONG_PROP_2` bigint(20) DEFAULT NULL,
                                         `DEC_PROP_1` decimal(13,4) DEFAULT NULL,
                                         `DEC_PROP_2` decimal(13,4) DEFAULT NULL,
                                         `BOOL_PROP_1` varchar(1) COLLATE utf8mb4_bin DEFAULT NULL,
                                         `BOOL_PROP_2` varchar(1) COLLATE utf8mb4_bin DEFAULT NULL,
                                         PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
                                         CONSTRAINT `QRTZ_SIMPROP_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `QRTZ_TRIGGERS` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for QRTZ_TRIGGERS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_TRIGGERS`;
CREATE TABLE `QRTZ_TRIGGERS` (
                                 `SCHED_NAME` varchar(120) COLLATE utf8mb4_bin NOT NULL,
                                 `TRIGGER_NAME` varchar(200) COLLATE utf8mb4_bin NOT NULL,
                                 `TRIGGER_GROUP` varchar(200) COLLATE utf8mb4_bin NOT NULL,
                                 `JOB_NAME` varchar(200) COLLATE utf8mb4_bin NOT NULL,
                                 `JOB_GROUP` varchar(200) COLLATE utf8mb4_bin NOT NULL,
                                 `DESCRIPTION` varchar(250) COLLATE utf8mb4_bin DEFAULT NULL,
                                 `NEXT_FIRE_TIME` bigint(13) DEFAULT NULL,
                                 `PREV_FIRE_TIME` bigint(13) DEFAULT NULL,
                                 `PRIORITY` int(11) DEFAULT NULL,
                                 `TRIGGER_STATE` varchar(16) COLLATE utf8mb4_bin NOT NULL,
                                 `TRIGGER_TYPE` varchar(8) COLLATE utf8mb4_bin NOT NULL,
                                 `START_TIME` bigint(13) NOT NULL,
                                 `END_TIME` bigint(13) DEFAULT NULL,
                                 `CALENDAR_NAME` varchar(200) COLLATE utf8mb4_bin DEFAULT NULL,
                                 `MISFIRE_INSTR` smallint(2) DEFAULT NULL,
                                 `JOB_DATA` blob,
                                 PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
                                 KEY `SCHED_NAME` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
                                 CONSTRAINT `QRTZ_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) REFERENCES `QRTZ_JOB_DETAILS` (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

SET FOREIGN_KEY_CHECKS = 1;
