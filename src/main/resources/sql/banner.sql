drop table if exists sys_banner_cate;
#id, cateCode, codeTitle, userId, orderNo, createDate
CREATE TABLE `sys_banner_cate` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `cateCode` varchar(60) DEFAULT NULL COMMENT '编号',
  `codeTitle` varchar(60) DEFAULT NULL COMMENT '标题',
  `userId` bigint(20) DEFAULT NULL COMMENT '用户编号',
  `orderNo` int(2) DEFAULT 1 COMMENT '排序',
  `createDate` date DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='banner_cate';

drop table if exists sys_banner_info;
#id, cateCode, userId, title, cntType, target, srcUrl, state, orderNo, createDate
CREATE TABLE `sys_banner_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `cateCode` varchar(60) DEFAULT NULL COMMENT '类别编码',
  `userId` varchar(60) DEFAULT NULL COMMENT '用户编号',
  `title` varchar(60) DEFAULT NULL COMMENT '名称',
  `cntType` varchar(10) DEFAULT NULL COMMENT '内容类型',
  `target` varchar(10) DEFAULT NULL COMMENT '目标',
  `href` varchar(300) DEFAULT NULL COMMENT '连接地址',
  `srcUrl` varchar(300) DEFAULT NULL COMMENT '地址源',
  `state` int(2) DEFAULT NULL COMMENT '状态',
  `orderNo` int(2) DEFAULT 1 COMMENT '排序',
  `createDate` date DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='banner_info';