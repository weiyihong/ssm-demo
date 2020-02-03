DROP TABLE IF EXISTS `BaseEntity`;
CREATE TABLE `BaseEntity` (
  `id` BIGINT(19) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `deleted` TINYINT(2) DEFAULT 1 COMMENT '是否有效0无效,1有效',
  `createdBy` BIGINT(19) DEFAULT NULL COMMENT '创建人',
  `lastModifiedBy` BIGINT(19) DEFAULT NULL COMMENT '修改人',
  `createdDate` datetime DEFAULT NULL COMMENT '创建时间',
  `lastModifiedDate` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) COMMENT='基础表';

DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` BIGINT(19) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
	`defaultRoleId` BIGINT(19) DEFAULT NULL COMMENT '默认角色ID',
	`userCode` VARCHAR(32) DEFAULT NULL COMMENT '用户编码',
	`userName` VARCHAR(32) DEFAULT NULL COMMENT '用户名',
	`userPwd` VARCHAR(64) DEFAULT NULL COMMENT '密码',
	`sex` TINYINT(2) DEFAULT NULL COMMENT '性别,0男,1女',
  `deleted` TINYINT(2) DEFAULT 1 COMMENT '是否有效0无效,1有效',
  `createdBy` BIGINT(19) DEFAULT NULL COMMENT '创建人',
  `lastModifiedBy` BIGINT(19) DEFAULT NULL COMMENT '修改人',
  `createdDate` datetime DEFAULT NULL COMMENT '创建时间',
  `lastModifiedDate` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) COMMENT='用户表';

DROP TABLE IF EXISTS `sys_dic`;
CREATE TABLE `sys_dic` (
  `id` BIGINT(19) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
	`sysId` BIGINT(19) DEFAULT NULL COMMENT '系统ID',
	`dicCode` VARCHAR(32) DEFAULT NULL COMMENT '字典编码',
	`parentCode` VARCHAR(32) DEFAULT NULL COMMENT '父级编码',
	`dicKey` VARCHAR(32) DEFAULT NULL COMMENT 'key',
	`dicValue` VARCHAR(32) DEFAULT NULL COMMENT 'value',
	`dicSort` INT DEFAULT NULL COMMENT '排序',
	`dicType` TINYINT(2) DEFAULT NULL COMMENT '类型',
	`remark` VARCHAR(64) DEFAULT NULL COMMENT '备注',
  `deleted` TINYINT(2) DEFAULT 1 COMMENT '是否有效0无效,1有效',
  `createdBy` BIGINT(19) DEFAULT NULL COMMENT '创建人',
  `lastModifiedBy` BIGINT(19) DEFAULT NULL COMMENT '修改人',
  `createdDate` datetime DEFAULT NULL COMMENT '创建时间',
  `lastModifiedDate` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) COMMENT='字典表';

DROP TABLE IF EXISTS `sys_system`;
CREATE TABLE `sys_system` (
  `id` BIGINT(19) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
	`sysCode` VARCHAR(32) DEFAULT NULL COMMENT '系统编码',
	`sysName` VARCHAR(32) DEFAULT NULL COMMENT '系统名称',
	`remark` VARCHAR(64) DEFAULT NULL COMMENT '备注',
  `deleted` TINYINT(2) DEFAULT 1 COMMENT '是否有效0无效,1有效',
  `createdBy` BIGINT(19) DEFAULT NULL COMMENT '创建人',
  `lastModifiedBy` BIGINT(19) DEFAULT NULL COMMENT '修改人',
  `createdDate` datetime DEFAULT NULL COMMENT '创建时间',
  `lastModifiedDate` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) COMMENT='系统表';

DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` BIGINT(19) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
	`userId` BIGINT(19) DEFAULT NULL COMMENT '用户ID',
	`roleId` BIGINT(19) DEFAULT NULL COMMENT '角色ID',
  `deleted` TINYINT(2) DEFAULT 1 COMMENT '是否有效0无效,1有效',
  `createdBy` BIGINT(19) DEFAULT NULL COMMENT '创建人',
  `lastModifiedBy` BIGINT(19) DEFAULT NULL COMMENT '修改人',
  `createdDate` datetime DEFAULT NULL COMMENT '创建时间',
  `lastModifiedDate` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) COMMENT='用户角色信息表';

DROP TABLE IF EXISTS `sys_system_menu`;
CREATE TABLE `sys_system_menu` (
  `id` BIGINT(19) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
	`sysId` BIGINT(19) DEFAULT NULL COMMENT '系统ID',
	`menuId` BIGINT(19) DEFAULT NULL COMMENT '菜单ID',
  `deleted` TINYINT(2) DEFAULT 1 COMMENT '是否有效0无效,1有效',
  `createdBy` BIGINT(19) DEFAULT NULL COMMENT '创建人',
  `lastModifiedBy` BIGINT(19) DEFAULT NULL COMMENT '修改人',
  `createdDate` datetime DEFAULT NULL COMMENT '创建时间',
  `lastModifiedDate` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) COMMENT='系统菜单信息表';

DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` BIGINT(19) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
	`roleId` BIGINT(19) DEFAULT NULL COMMENT '角色ID',
	`menuId` BIGINT(19) DEFAULT NULL COMMENT '菜单ID',
  `deleted` TINYINT(2) DEFAULT 1 COMMENT '是否有效0无效,1有效',
  `createdBy` BIGINT(19) DEFAULT NULL COMMENT '创建人',
  `lastModifiedBy` BIGINT(19) DEFAULT NULL COMMENT '修改人',
  `createdDate` datetime DEFAULT NULL COMMENT '创建时间',
  `lastModifiedDate` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) COMMENT='角色菜单信息表';

DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` BIGINT(19) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
	`sysId` BIGINT(19) DEFAULT NULL COMMENT '系统ID',
	`roleCode` VARCHAR(32) DEFAULT NULL COMMENT '角色编码',
	`roleName` VARCHAR(32) DEFAULT NULL COMMENT '角色名称',
	`roleType` TINYINT(2) DEFAULT NULL COMMENT '角色类型0超级管理员1系统管理员2普通角色',
	`remark` VARCHAR(64) DEFAULT NULL COMMENT '备注',
  `deleted` TINYINT(2) DEFAULT 1 COMMENT '是否有效0无效,1有效',
  `createdBy` BIGINT(19) DEFAULT NULL COMMENT '创建人',
  `lastModifiedBy` BIGINT(19) DEFAULT NULL COMMENT '修改人',
  `createdDate` datetime DEFAULT NULL COMMENT '创建时间',
  `lastModifiedDate` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) COMMENT='角色信息表';

DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` BIGINT(19) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
	`parentId` BIGINT(19) DEFAULT NULL COMMENT '父级ID',
	`menuCode` VARCHAR(32) DEFAULT NULL COMMENT '菜单编码',
	`menuName` VARCHAR(32) DEFAULT NULL COMMENT '菜单名称',
	`menuType` TINYINT(2) DEFAULT NULL COMMENT '菜单类型0根菜单,1节点菜单2叶子菜单3权限菜单',
	`menuSort` INT DEFAULT NULL COMMENT '排序',
	`menuIcon` VARCHAR(32) DEFAULT NULL COMMENT 'icon',
	`remark` VARCHAR(64) DEFAULT NULL COMMENT '备注',
	`menuUrl` VARCHAR(255) DEFAULT NULL COMMENT '路由',
	`helUrl` VARCHAR(255) DEFAULT NULL COMMENT '路由',
  `deleted` TINYINT(2) DEFAULT 1 COMMENT '是否有效0无效,1有效',
  `createdBy` BIGINT(19) DEFAULT NULL COMMENT '创建人',
  `lastModifiedBy` BIGINT(19) DEFAULT NULL COMMENT '修改人',
  `createdDate` datetime DEFAULT NULL COMMENT '创建时间',
  `lastModifiedDate` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) COMMENT='菜单信息表';