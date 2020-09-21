drop table if exists bok_subject_info;
CREATE TABLE `bok_subject_info` (
  `subjectId` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `title` varchar(100) DEFAULT NULL COMMENT '标题',
  `orderNo` int(2) DEFAULT 1 COMMENT '排序',
  PRIMARY KEY (`subjectId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='科目';

insert into bok_subject_info(subjectId, name, title) values (1, 'chinese', '语文');
insert into bok_subject_info(subjectId, name, title) values (2, 'math', '数学');
insert into bok_subject_info(subjectId, name, title) values (3, 'foreign', '英语');
insert into bok_subject_info(subjectId, name, title) values (4, 'physic', '物理');
insert into bok_subject_info(subjectId, name, title) values (5, 'chemistry', '化学');
insert into bok_subject_info(subjectId, name, title) values (6, 'biology', '生物');
insert into bok_subject_info(subjectId, name, title) values (7, 'history', '历史');
insert into bok_subject_info(subjectId, name, title) values (8, 'political', '政治');
insert into bok_subject_info(subjectId, name, title) values (9, 'geographical', '地理');
insert into bok_subject_info(subjectId, name, title) values (10, 'other', '其他');

drop table if exists bok_version_type;
CREATE TABLE `bok_version_type` (
  `verId` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `orderNo` int(2) DEFAULT 1 COMMENT '排序',
  PRIMARY KEY (`verId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='科目版本';

insert into bok_version_type(name) values ("人教版");
insert into bok_version_type(name) values ("苏教版");
insert into bok_version_type(name) values ("北师大版");
insert into bok_version_type(name) values ("沪教版");
insert into bok_version_type(name) values ("鲁教版");
insert into bok_version_type(name) values ("冀教版");
insert into bok_version_type(name) values ("浙教版");
insert into bok_version_type(name) values ("部编版");
insert into bok_version_type(name) values ("沪科版");
insert into bok_version_type(name) values ("译林版");
insert into bok_version_type(name) values ("青岛版");
insert into bok_version_type(name) values ("仁爱版");
insert into bok_version_type(name) values ("外研版");
insert into bok_version_type(name) values ("教科版");
insert into bok_version_type(name) values ("语文版");
insert into bok_version_type(name) values ("中图版");
insert into bok_version_type(name) values ("科粤版");
insert into bok_version_type(name) values ("人民版");
insert into bok_version_type (name) values ("西师大版");
insert into bok_version_type (name) values ("北京版");
insert into bok_version_type (name) values ("鲁科版");
insert into bok_version_type (name) values ("鲁人版");
insert into bok_version_type (name) values ("浙科版");
insert into bok_version_type (name) values ("湘教版");
insert into bok_version_type (name) values ("粤教版");
insert into bok_version_type (name) values ("岳麓版");
insert into bok_version_type (name) values ("华师大版");
insert into bok_version_type (name) values ("鄂教版");
insert into bok_version_type (name) values ("苏科版");
insert into bok_version_type (name) values ("川教版");
insert into bok_version_type (name) values ("河大版");
insert into bok_version_type (name) values ("商务版");
insert into bok_version_type (name) values ("重大版");
insert into bok_version_type (name) values ("粤人版");
insert into bok_version_type (name) values ("湘少版");
insert into bok_version_type (name) values ("沪科教版");
insert into bok_version_type (name) values ("接力版");
insert into bok_version_type (name) values ("闽教版");

drop table if exists bok_book_info;
CREATE TABLE `bok_book_info` (
  `bookId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `bookName` varchar(100) DEFAULT NULL COMMENT '名称',
  `shortName` varchar(100) DEFAULT NULL COMMENT '简称',
  `pinYin` varchar(100) DEFAULT NULL COMMENT '简称',
  `publisher` int(2) DEFAULT NULL COMMENT '出版社',
  `version` int(2) DEFAULT NULL COMMENT '版本',
  `theYear` int(4) DEFAULT NULL COMMENT '年份',
  `coverImage` varchar(100) NOT NULL DEFAULT 0 COMMENT '封面',
  `cipImage` varchar(100) DEFAULT NULL COMMENT 'cip图片',
  `subjectId` int(2) DEFAULT NULL COMMENT '科目',
  `gradeId` int(2) DEFAULT NULL COMMENT '年级',
  `volume` int(2) DEFAULT NULL COMMENT '卷册',
  `elective` int(2) DEFAULT 1 COMMENT '选修0和必修1',
  `createDate` int(10) DEFAULT UNIX_TIMESTAMP(),
  PRIMARY KEY (`bookId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='课本';