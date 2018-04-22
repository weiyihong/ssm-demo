-- ----------------------------
-- Table structure for T_USER
-- ----------------------------
DROP TABLE IF EXISTS `T_USER`;
CREATE TABLE `T_USER` (
  `USER_ID` bigint(18) PRIMARY KEY AUTO_INCREMENT,
  `USER_NAME` varchar(11) DEFAULT NULL COMMENT '姓名',
  `SEX` varchar(1) DEFAULT '0' COMMENT '性别：0男，1女'
) COMMENT='用户表基础信息表';

INSERT INTO `T_USER` (`USER_ID`, `USER_NAME`, `SEX`) VALUES ('1', 'test1', '0');
INSERT INTO `T_USER` (`USER_ID`, `USER_NAME`, `SEX`) VALUES ('2', 'test2', '1');