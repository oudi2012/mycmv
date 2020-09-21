drop table if exists op_bookshelf_info;
#shelfId, userId, bookId, cateId, bookCover, readPercent, createDate
CREATE TABLE `op_bookshelf_info` (
  `shelfId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userId` bigint(20) DEFAULT NULL COMMENT '用户编号',
  `bookId` bigint(20) DEFAULT NULL COMMENT '图书编号',
  `cateId` int(10) DEFAULT NULL COMMENT '类别编号',
  `bookCover` varchar(100) DEFAULT NULL COMMENT '封面',
  `readPercent` int(2) NOT NULL DEFAULT 0 COMMENT '进度',
  `createDate` date DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`shelfId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='我的书架';

drop table if exists op_collect_info;
#coletId, userId, folderId, infoType, infoId, title, imageIndex, images, tags, createDate
CREATE TABLE `op_collect_info` (
  `coletId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userId` bigint(20) DEFAULT NULL COMMENT '用户编号',
  `folderId` bigint(20) DEFAULT NULL COMMENT '收藏文件夹',
  `infoType` int(10) DEFAULT NULL COMMENT '信息类型',
  `infoId` bigint(20) DEFAULT NULL COMMENT '信息编号',
  `title` varchar(100) DEFAULT NULL COMMENT '标题',
  `imageIndex` varchar(100) DEFAULT NULL COMMENT '封面',
  `images` varchar(300) DEFAULT NULL COMMENT '多图',
  `tags` varchar(100) DEFAULT NULL COMMENT '标签',
  `createDate` date DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`coletId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='我的收藏';

drop table if exists op_homework_info;
#homeWorkId, userId, schoolId, gradeId, classId, subjectId, workContent, indexImage, createDate, beginDate, endDate
CREATE TABLE `op_homework_info` (
  `homeWorkId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userId` bigint(20) DEFAULT NULL COMMENT '用户编号',
  `schoolId` bigint(20) DEFAULT NULL COMMENT '学校编号',
  `gradeId` int(4) DEFAULT NULL COMMENT '年级',
  `classId` int(4) DEFAULT NULL COMMENT '班级',
  `subjectId` int(4) DEFAULT NULL COMMENT '科目',
  `workContent` varchar(2000) DEFAULT NULL COMMENT '内容',
  `indexImage` varchar(100) DEFAULT NULL COMMENT '首图',
  `createDate` date DEFAULT NULL COMMENT '创建时间',
  `beginDate` bigint(20) DEFAULT NULL COMMENT '开始时间',
  `endDate` bigint(20) DEFAULT NULL COMMENT '结束时间',
  PRIMARY KEY (`homeWorkId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='家庭作业';

drop table if exists op_read_note;
#id, bookId, pageNo, lineNo, userId, type, content, createDate
CREATE TABLE `op_read_note` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `bookId` bigint(20) DEFAULT NULL COMMENT '图书编号',
  `pageNo` int(8) DEFAULT NULL COMMENT '图书页码',
  `lineNo` int(8) DEFAULT NULL COMMENT '页码行号',
  `userId` bigint(20) DEFAULT NULL COMMENT '用户编号',
  `type` int(4) DEFAULT NULL COMMENT '类型',
  `content` varchar(2000) DEFAULT NULL COMMENT '内容',
  `createDate` date DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='读书笔记';

drop table if exists op_student_work;
#workId, userId, schoolId, gradeId, classId, subjectId, teacherId, version, state, scoreCateId, score
#, scoreDesc, imageIndex, createDate
CREATE TABLE `op_student_work` (
  `workId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userId` bigint(20) DEFAULT NULL COMMENT '用户编号',
  `schoolId` bigint(20) DEFAULT NULL COMMENT '学校编号',
  `gradeId` int(4) DEFAULT NULL COMMENT '年级',
  `classId` int(4) DEFAULT NULL COMMENT '班级',
  `subjectId` int(4) DEFAULT NULL COMMENT '科目',
  `teacherId` bigint(20) DEFAULT NULL COMMENT '老师编号',
  `version` int(4) DEFAULT NULL COMMENT '版本号',
  `state` int(4) DEFAULT NULL COMMENT '状态',
  `scoreCateId` int(4) DEFAULT NULL COMMENT '成绩类别编号',
  `score` int(4) DEFAULT NULL COMMENT '成绩',
  `scoreDesc` varchar(100) DEFAULT NULL COMMENT '成绩描述',
  `indexImage` varchar(100) DEFAULT NULL COMMENT '首图',
  `createDate` date DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`workId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='作业完成信息';