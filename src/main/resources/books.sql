drop table if exists bok_biology_info;
CREATE TABLE `bok_biology_info` (
  `bookId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `bookName` varchar(100) DEFAULT NULL COMMENT '名称',
  `shortName` varchar(100) DEFAULT NULL COMMENT '简称',
  `publisher` varchar(100) DEFAULT NULL COMMENT '出版社',
  `theYear` int(4) DEFAULT NULL COMMENT '年份',
  `coverImage` varchar(100) NOT NULL DEFAULT 0 COMMENT '封面',
  `cipImage` varchar(100) DEFAULT NULL COMMENT 'cip图片',
  `gradeId` int(2) DEFAULT NULL COMMENT '年级',
  PRIMARY KEY (`bookId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='生物';

drop table if exists bok_chemistry_info;
CREATE TABLE `bok_chemistry_info` (
  `bookId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `bookName` varchar(100) DEFAULT NULL COMMENT '名称',
  `shortName` varchar(100) DEFAULT NULL COMMENT '简称',
  `publisher` varchar(100) DEFAULT NULL COMMENT '出版社',
  `theYear` int(4) DEFAULT NULL COMMENT '年份',
  `coverImage` varchar(100) NOT NULL DEFAULT 0 COMMENT '封面',
  `cipImage` varchar(100) DEFAULT NULL COMMENT 'cip图片',
  `gradeId` int(2) DEFAULT NULL COMMENT '年级',
  PRIMARY KEY (`bookId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='化学';

drop table if exists bok_foreign_info;
CREATE TABLE `bok_foreign_info` (
  `bookId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `bookName` varchar(100) DEFAULT NULL COMMENT '名称',
  `shortName` varchar(100) DEFAULT NULL COMMENT '简称',
  `publisher` varchar(100) DEFAULT NULL COMMENT '出版社',
  `theYear` int(4) DEFAULT NULL COMMENT '年份',
  `coverImage` varchar(100) NOT NULL DEFAULT 0 COMMENT '封面',
  `cipImage` varchar(100) DEFAULT NULL COMMENT 'cip图片',
  `gradeId` int(2) DEFAULT NULL COMMENT '年级',
  PRIMARY KEY (`bookId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='外语';

drop table if exists bok_geographical_info;
CREATE TABLE `bok_geographical_info` (
  `bookId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `bookName` varchar(100) DEFAULT NULL COMMENT '名称',
  `shortName` varchar(100) DEFAULT NULL COMMENT '简称',
  `publisher` varchar(100) DEFAULT NULL COMMENT '出版社',
  `theYear` int(4) DEFAULT NULL COMMENT '年份',
  `coverImage` varchar(100) NOT NULL DEFAULT 0 COMMENT '封面',
  `cipImage` varchar(100) DEFAULT NULL COMMENT 'cip图片',
  `gradeId` int(2) DEFAULT NULL COMMENT '年级',
  PRIMARY KEY (`bookId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='地理';

drop table if exists bok_history_info;
CREATE TABLE `bok_history_info` (
  `bookId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `bookName` varchar(100) DEFAULT NULL COMMENT '名称',
  `shortName` varchar(100) DEFAULT NULL COMMENT '简称',
  `publisher` varchar(100) DEFAULT NULL COMMENT '出版社',
  `theYear` int(4) DEFAULT NULL COMMENT '年份',
  `coverImage` varchar(100) NOT NULL DEFAULT 0 COMMENT '封面',
  `cipImage` varchar(100) DEFAULT NULL COMMENT 'cip图片',
  `gradeId` int(2) DEFAULT NULL COMMENT '年级',
  PRIMARY KEY (`bookId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='历史';

drop table if exists bok_math_info;
CREATE TABLE `bok_math_info` (
  `bookId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `bookName` varchar(100) DEFAULT NULL COMMENT '名称',
  `shortName` varchar(100) DEFAULT NULL COMMENT '简称',
  `publisher` varchar(100) DEFAULT NULL COMMENT '出版社',
  `theYear` int(4) DEFAULT NULL COMMENT '年份',
  `coverImage` varchar(100) NOT NULL DEFAULT 0 COMMENT '封面',
  `cipImage` varchar(100) DEFAULT NULL COMMENT 'cip图片',
  `gradeId` int(2) DEFAULT NULL COMMENT '年级',
  PRIMARY KEY (`bookId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='数学';

drop table if exists bok_physic_info;
CREATE TABLE `bok_physic_info` (
  `bookId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `bookName` varchar(100) DEFAULT NULL COMMENT '名称',
  `shortName` varchar(100) DEFAULT NULL COMMENT '简称',
  `publisher` varchar(100) DEFAULT NULL COMMENT '出版社',
  `theYear` int(4) DEFAULT NULL COMMENT '年份',
  `coverImage` varchar(100) NOT NULL DEFAULT 0 COMMENT '封面',
  `cipImage` varchar(100) DEFAULT NULL COMMENT 'cip图片',
  `gradeId` int(2) DEFAULT NULL COMMENT '年级',
  PRIMARY KEY (`bookId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='物理';

drop table if exists bok_political_info;
CREATE TABLE `bok_political_info` (
  `bookId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `bookName` varchar(100) DEFAULT NULL COMMENT '名称',
  `shortName` varchar(100) DEFAULT NULL COMMENT '简称',
  `publisher` varchar(100) DEFAULT NULL COMMENT '出版社',
  `theYear` int(4) DEFAULT NULL COMMENT '年份',
  `coverImage` varchar(100) NOT NULL DEFAULT 0 COMMENT '封面',
  `cipImage` varchar(100) DEFAULT NULL COMMENT 'cip图片',
  `gradeId` int(2) DEFAULT NULL COMMENT '年级',
  PRIMARY KEY (`bookId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='政治';