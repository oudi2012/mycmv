drop table if exists stu_image_cate;
#cateId, name, type
CREATE TABLE `stu_image_cate` (
  `cateId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(60) DEFAULT NULL COMMENT '名称',
  `type` int(2) DEFAULT NULL COMMENT '类型',
  PRIMARY KEY (`cateId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='stu_image_cate';


drop table if exists stu_image_cate;
#imageId, userId, imageCate, bussId, imageSrc, orderNo, createDate
CREATE TABLE `stu_image_cate` (
  `imageId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userId` bigint(20) DEFAULT NULL COMMENT '用户编号',
  `imageCate` bigint(20) DEFAULT NULL COMMENT '图片类型',
  `bussId` bigint(20) DEFAULT NULL COMMENT '业务编号',
  `imageSrc` varchar(300) DEFAULT NULL COMMENT '图片地址',
  `orderNo` int(2) DEFAULT 1 COMMENT '排序',
  `createDate` date DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`cateId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='stu_image_cate';