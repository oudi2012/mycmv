## 考试作文
drop table if exists compo_exam_info;
CREATE TABLE `compo_exam_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(200) DEFAULT NULL COMMENT 'title',
  `subTitle` varchar(200) DEFAULT NULL COMMENT 'subTitle',
  `note` varchar(500) DEFAULT NULL COMMENT '备注',
  `detail` text DEFAULT NULL COMMENT '内容',
  `userId` bigint(20) DEFAULT NULL COMMENT '用户',
  `images` varchar(200) NOT NULL DEFAULT 0 COMMENT '配图',
  `gradeId` int(2) DEFAULT NULL COMMENT '年级',
  `createTime` int(10) DEFAULT UNIX_TIMESTAMP(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='考试作文';

## 满分作文
drop table if exists compo_exam_info;
CREATE TABLE `compo_exam_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(200) DEFAULT NULL COMMENT 'title',
  `subTitle` varchar(200) DEFAULT NULL COMMENT 'subTitle',
  `note` varchar(500) DEFAULT NULL COMMENT '备注',
  `detail` text DEFAULT NULL COMMENT '内容',
  `userId` bigint(20) DEFAULT NULL COMMENT '用户',
  `images` varchar(200) NOT NULL DEFAULT 0 COMMENT '配图',
  `gradeId` int(2) DEFAULT NULL COMMENT '年级',
  `theYear` int(4) DEFAULT NULL COMMENT '年份',
  `theMonth` int(2) DEFAULT NULL COMMENT '月份',
  `createTime` int(10) DEFAULT UNIX_TIMESTAMP(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='满分作文';


## 获奖作文
drop table if exists compo_exam_info;
CREATE TABLE `compo_exam_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(200) DEFAULT NULL COMMENT 'title',
  `subTitle` varchar(200) DEFAULT NULL COMMENT 'subTitle',
  `note` varchar(500) DEFAULT NULL COMMENT '备注',
  `detail` text DEFAULT NULL COMMENT '内容',
  `userId` bigint(20) DEFAULT NULL COMMENT '用户',
  `images` varchar(200) NOT NULL DEFAULT 0 COMMENT '配图',
  `gradeId` int(2) DEFAULT NULL COMMENT '年级',
  `theYear` int(4) DEFAULT NULL COMMENT '年份',
  `theMonth` int(2) DEFAULT NULL COMMENT '月份',
  `createTime` int(10) DEFAULT UNIX_TIMESTAMP(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='获奖作文';













































