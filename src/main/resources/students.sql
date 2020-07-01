drop table if exists stu_student_info;
CREATE TABLE stu_student_info (
  id int(11) NOT NULL AUTO_INCREMENT,
  phone varchar(11) NOT NULL,
  userName varchar(100) NOT NULL,
  passWord varchar(100) NOT NULL,
  regType TINYINT(1) DEFAULT 1 COMMENT '1:注册2:手机,3:微信,4:weibo 5：qq',
  sex TINYINT(1) DEFAULT 0 COMMENT '0f,1m',
  birthDay int(10) DEFAULT NULL COMMENT '生日',
  areaId int(10) DEFAULT NULL comment '所属地区',
  headImage varchar(100) DEFAULT NULL comment '头像',
  realName varchar(100) DEFAULT NULL comment '真实姓名',
  schoolId int(10) DEFAULT NULL comment '所属学校',
  role tinyint(1) DEFAULT 3 comment '角色',
  state int(2) DEFAULT 0 comment '0nobody,1auth,2question,3freeze',
  regDate int(10) DEFAULT UNIX_TIMESTAMP(),
  updateTime int(10) DEFAULT UNIX_TIMESTAMP(),
  PRIMARY KEY (id)
) ENGINE=innodb AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '用户数据表';


drop table if exists stu_teacher_info;
CREATE TABLE stu_teacher_info (
  id int(11) NOT NULL AUTO_INCREMENT,
  phone varchar(11) NOT NULL,
  userName varchar(100) NOT NULL,
  passWord varchar(100) NOT NULL,
  regType TINYINT(1) DEFAULT 1 COMMENT '1:注册2:手机,3:微信,4:weibo 5：qq',
  sex TINYINT(1) DEFAULT 0 COMMENT '0f,1m',
  birthDay int(10) DEFAULT NULL COMMENT '生日',
  areaId int(10) DEFAULT NULL comment '所属地区',
  headImage varchar(100) DEFAULT NULL comment '头像',
  realName varchar(100) DEFAULT NULL comment '真实姓名',
  schoolId int(10) DEFAULT NULL comment '所属学校',
  role tinyint(1) DEFAULT 3 comment '角色',
  state int(2) DEFAULT 0 comment '0nobody,1auth,2question,3freeze',
  regDate int(10) DEFAULT UNIX_TIMESTAMP(),
  updateTime int(10) DEFAULT UNIX_TIMESTAMP(),
  PRIMARY KEY (id)
) ENGINE=innodb AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '用户数据表';


DROP TABLE IF EXISTS stu_area_info;
CREATE TABLE stu_area_info  (
  areaCode bigint(20) NOT NULL,
  areaName varchar(50)  DEFAULT NULL,
  parentCode int(11) NULL DEFAULT NULL,
  orderBy int(11) NULL DEFAULT NULL,
  PRIMARY KEY (areaId) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8;


drop table if exists stu_school_info;
CREATE TABLE stu_school_info (
  schoolId int(11) NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL comment '全称',
  shortName varchar(100) NOT NULL comment '简称',
  pinyin varchar(100) NOT NULL comment '拼音',
  address varchar(200) DEFAULT NULL comment '地址',
  country int(8) DEFAULT 0,
  province int(8) DEFAULT 0,
  city int(8) DEFAULT 0,
  town int(8) DEFAULT 0,
  createDate int(10) DEFAULT UNIX_TIMESTAMP(),
  PRIMARY KEY (schoolId)
) ENGINE=innodb AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '学校';

drop table if exists stu_grade_info;
CREATE TABLE stu_grade_info (
  gradeId int(10) NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL,
  state int(2) DEFAULT 0 comment '0unuse,1use',
  orderNo int(2) DEFAULT 0,
  createTime int(10) DEFAULT UNIX_TIMESTAMP(),
  PRIMARY KEY (gradeId)
) ENGINE=innodb AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '年级';

drop table if exists stu_class_info;
CREATE TABLE stu_class_info (
  classId int(10) NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL,
  type int(2) DEFAULT 0,
  createTime int(10) DEFAULT UNIX_TIMESTAMP(),
  PRIMARY KEY (classId)
) ENGINE=innodb AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '班级';

drop table if exists stu_subject_info;
CREATE TABLE stu_subject_info (
  subjectId int(10) NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL,
  orderNo int(2) DEFAULT 0,
  createTime int(10) DEFAULT UNIX_TIMESTAMP(),
  PRIMARY KEY (subjectId)
) ENGINE=innodb AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '科目';

drop table if exists stu_term_info;
CREATE TABLE stu_term_info (
  teamId int(10) NOT NULL AUTO_INCREMENT,
  theYear int(4) NOT NULL,
  name varchar(100) NOT NULL,
  type int(2) NOT NULL comment '1 第一学期2...',
  startTime datetime DEFAULT null,
  endTime datetime DEFAULT null,
  createTime datetime DEFAULT null,
  PRIMARY KEY (teamId)
) ENGINE=innodb AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '学生学期';

drop table if exists stu_term_books;
CREATE TABLE stu_term_books (
  id int(10) NOT NULL AUTO_INCREMENT,
  schoolId int(10) NOT NULL,
  teamId int(10) NOT NULL,
  gradeId int(10) NOT NULL,
  name varchar(100) NOT NULL,
  bookId int(10) NOT NULL comment '书籍编号',
  bookCate varchar(30) NOT NULL comment '书籍类别',
  createTime datetime DEFAULT UNIX_TIMESTAMP(),
  PRIMARY KEY (id)
) ENGINE=innodb AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '学生每学期的书籍';

drop table if exists stu_term_teachers;
CREATE TABLE stu_term_teachers (
  id int(10) NOT NULL AUTO_INCREMENT,
  teamId int(10) NOT NULL,
  schoolId int(10) NOT NULL,
  gradeId int(10) NOT NULL,
  classId int(10) NOT NULL,
  userId int(10) NOT NULL comment '老师编号',
  bookId int(10) NOT NULL comment '书籍编号',
  bookCate varchar(30) NOT NULL comment '书籍类别',
  state int(2) NOT NULL comment '10:正常',
  startTime datetime DEFAULT null,
  endTime datetime DEFAULT null,
  createTime datetime DEFAULT UNIX_TIMESTAMP(),
  PRIMARY KEY (id)
) ENGINE=innodb AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '学生每学期任课老师及对应的课程';

drop table if exists stu_term_students;
CREATE TABLE stu_term_students (
  id int(10) NOT NULL AUTO_INCREMENT,
  teamId int(10) NOT NULL,
  schoolId int(10) NOT NULL,
  gradeId int(10) NOT NULL,
  classId int(10) NOT NULL,
  state int(2) NOT NULL comment '10:正常',
  userId int(10) NOT NULL  comment '学生编号',
  startTime datetime DEFAULT null,
  endTime datetime DEFAULT null,
  createTime datetime DEFAULT UNIX_TIMESTAMP(),
  PRIMARY KEY (id)
) ENGINE=innodb AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '学生每学期状态';




