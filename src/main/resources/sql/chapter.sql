###### 章节 => 临时数据表
drop table if exists bok_books_chapter;
CREATE TABLE `bok_chinese_chapter` (
  `chapterId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `bookId` bigint(20) NOT NULL,
  `bookType` varchar(100) NOT NULL,
  `chapterName` varchar(100) DEFAULT NULL COMMENT '章节名称',
  `elective` int(2) DEFAULT 1 COMMENT '选修0和必修1',
  `content` varchar(5000) DEFAULT NULL COMMENT '内容',
  `images` varchar(500) DEFAULT NULL COMMENT '章节图片',
  `createTime` int(10) DEFAULT UNIX_TIMESTAMP(),
  PRIMARY KEY (`chapterId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='章节临时数据表';

drop table if exists bok_chinese_chapter;
CREATE TABLE `bok_chinese_chapter` (
  `chapterId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `bookId` bigint(20) NOT NULL,
  `chapterName` varchar(100) DEFAULT NULL COMMENT '章节名称',
  `elective` int(2) DEFAULT 1 COMMENT '选修0和必修1',
  `content` varchar(5000) DEFAULT NULL COMMENT '内容',
  `images` varchar(500) DEFAULT NULL COMMENT '章节图片',
  `createTime` int(10) DEFAULT UNIX_TIMESTAMP(),
  PRIMARY KEY (`chapterId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='语文章节';

drop table if exists bok_biology_chapter;
CREATE TABLE `bok_biology_chapter` (
  `chapterId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `bookId` bigint(20) NOT NULL,
  `chapterName` varchar(100) DEFAULT NULL COMMENT '章节名称',
  `elective` int(2) DEFAULT 1 COMMENT '选修0和必修1',
  `content` varchar(5000) DEFAULT NULL COMMENT '内容',
  `images` varchar(500) DEFAULT NULL COMMENT '章节图片',
  `createTime` int(10) DEFAULT UNIX_TIMESTAMP(),
  PRIMARY KEY (`chapterId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='生物章节';

drop table if exists bok_chemistry_chapter;
CREATE TABLE `bok_chemistry_chapter` (
 `chapterId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `bookId` bigint(20) NOT NULL,
  `chapterName` varchar(100) DEFAULT NULL COMMENT '章节名称',
   `elective` int(2) DEFAULT 1 COMMENT '选修0和必修1',
  `content` varchar(5000) DEFAULT NULL COMMENT '内容',
  `images` varchar(500) DEFAULT NULL COMMENT '章节图片',
  `createTime` int(10) DEFAULT UNIX_TIMESTAMP(),
  PRIMARY KEY (`chapterId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='化学章节';

drop table if exists bok_foreign_chapter;
CREATE TABLE `bok_foreign_chapter` (
 `chapterId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `bookId` bigint(20) NOT NULL,
  `chapterName` varchar(100) DEFAULT NULL COMMENT '章节名称',
   `elective` int(2) DEFAULT 1 COMMENT '选修0和必修1',
  `content` varchar(5000) DEFAULT NULL COMMENT '内容',
  `images` varchar(500) DEFAULT NULL COMMENT '章节图片',
  `createTime` int(10) DEFAULT UNIX_TIMESTAMP(),
  PRIMARY KEY (`chapterId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='外语章节';

drop table if exists bok_geographical_chapter;
CREATE TABLE `bok_geographical_chapter` (
 `chapterId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `bookId` bigint(20) NOT NULL,
  `chapterName` varchar(100) DEFAULT NULL COMMENT '章节名称',
   `elective` int(2) DEFAULT 1 COMMENT '选修0和必修1',
  `content` varchar(5000) DEFAULT NULL COMMENT '内容',
  `images` varchar(500) DEFAULT NULL COMMENT '章节图片',
  `createTime` int(10) DEFAULT UNIX_TIMESTAMP(),
  PRIMARY KEY (`chapterId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='地理章节';

drop table if exists bok_history_chapter;
CREATE TABLE `bok_history_chapter` (
 `chapterId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `bookId` bigint(20) NOT NULL,
  `chapterName` varchar(100) DEFAULT NULL COMMENT '章节名称',
   `elective` int(2) DEFAULT 1 COMMENT '选修0和必修1',
  `content` varchar(5000) DEFAULT NULL COMMENT '内容',
  `images` varchar(500) DEFAULT NULL COMMENT '章节图片',
  `createTime` int(10) DEFAULT UNIX_TIMESTAMP(),
  PRIMARY KEY (`chapterId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='历史章节';

drop table if exists bok_math_chapter;
CREATE TABLE `bok_math_chapter` (
 `chapterId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `bookId` bigint(20) NOT NULL,
  `chapterName` varchar(100) DEFAULT NULL COMMENT '章节名称',
   `elective` int(2) DEFAULT 1 COMMENT '选修0和必修1',
  `content` varchar(5000) DEFAULT NULL COMMENT '内容',
  `images` varchar(500) DEFAULT NULL COMMENT '章节图片',
  `createTime` int(10) DEFAULT UNIX_TIMESTAMP(),
  PRIMARY KEY (`chapterId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='数学章节';

drop table if exists bok_physic_chapter;
CREATE TABLE `bok_physic_chapter` (
 `chapterId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `bookId` bigint(20) NOT NULL,
  `chapterName` varchar(100) DEFAULT NULL COMMENT '章节名称',
   `elective` int(2) DEFAULT 1 COMMENT '选修0和必修1',
  `content` varchar(5000) DEFAULT NULL COMMENT '内容',
  `images` varchar(500) DEFAULT NULL COMMENT '章节图片',
  `createTime` int(10) DEFAULT UNIX_TIMESTAMP(),
  PRIMARY KEY (`chapterId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='物理章节';

drop table if exists bok_political_chapter;
CREATE TABLE `bok_political_chapter` (
 `chapterId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `bookId` bigint(20) NOT NULL,
  `chapterName` varchar(100) DEFAULT NULL COMMENT '章节名称',
   `elective` int(2) DEFAULT 1 COMMENT '选修0和必修1',
  `content` varchar(5000) DEFAULT NULL COMMENT '内容',
  `images` varchar(500) DEFAULT NULL COMMENT '章节图片',
  `createTime` int(10) DEFAULT UNIX_TIMESTAMP(),
  PRIMARY KEY (`chapterId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='政治章节';