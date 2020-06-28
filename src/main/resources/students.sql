drop table if exists userInfo;
CREATE TABLE userInfo (
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
  role tinyint(1) DEFAULT 3 comment '0student,1teacher,2parent,3nobody',
  state int(2) DEFAULT 0 comment '0nobody,1auth,2question,3freeze',
  regDate int(10) DEFAULT UNIX_TIMESTAMP(),
  updateTime int(10) DEFAULT UNIX_TIMESTAMP(),
  PRIMARY KEY (id)
) ENGINE=innodb AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '用户数据表';


DROP TABLE IF EXISTS areaInfo;
CREATE TABLE areaInfo  (
  areaId bigint(20) NOT NULL AUTO_INCREMENT,
  areaName varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  parent int(11) NULL DEFAULT NULL,
  code int(11) NULL DEFAULT NULL,
  orderBy int(11) NULL DEFAULT NULL,
  PRIMARY KEY (areaId) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8;


drop table if exists school;
CREATE TABLE school (
  schoolId int(11) NOT NULL AUTO_INCREMENT,
  shortName varchar(100) NOT NULL comment '简称',
  pinyin varchar(100) NOT NULL comment '拼音',
  fullName varchar(100) NOT NULL comment '全称',
  areaOf int(10) DEFAULT NULL comment '所属地区',
  state int(2) DEFAULT 0 comment '0unuse,1use',
  createTime int(10) DEFAULT UNIX_TIMESTAMP(),
  updateTime int(10) DEFAULT UNIX_TIMESTAMP(),
  PRIMARY KEY (schoolId)
) ENGINE=innodb AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '学校';

drop table if exists subject;
CREATE TABLE subject (
  subjectId int(11) NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL,
  state int(2) DEFAULT 0 comment '0unuse,1use',
  createTime int(10) DEFAULT UNIX_TIMESTAMP(),
  updateTime int(10) DEFAULT UNIX_TIMESTAMP(),
  PRIMARY KEY (subjectId)
) ENGINE=innodb AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '科目';


drop table if exists grade;
CREATE TABLE grade (
  gradeId int(11) NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL,
  state int(2) DEFAULT 0 comment '0unuse,1use',
  createTime int(10) DEFAULT UNIX_TIMESTAMP(),
  updateTime int(10) DEFAULT UNIX_TIMESTAMP(),
  PRIMARY KEY (gradeId)
) ENGINE=innodb AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '年级';


drop table if exists studentClass;
CREATE TABLE studentClass (
  classId int(11) NOT NULL AUTO_INCREMENT,
  schoolId int(11) NOT NULL,
  gradeId int(11) NOT NULL,
  name varchar(100) NOT NULL,
  state int(2) DEFAULT 0 comment '0unuse,1use',
  createTime int(10) DEFAULT UNIX_TIMESTAMP(),
  updateTime int(10) DEFAULT UNIX_TIMESTAMP(),
  PRIMARY KEY (classId)
) ENGINE=innodb AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '班级';

drop table if exists userSchoolInfo;
CREATE TABLE userSchoolInfo (
  schoolInfoId int(11) NOT NULL AUTO_INCREMENT,
  userId int(11) NOT NULL,
  schoolId int(11) NOT NULL,
  gradeId int(11) NOT NULL,
  classId int(11) NOT NULL,
  state int(2) DEFAULT 0 comment '0unuse,1use',
  createTime int(10) DEFAULT UNIX_TIMESTAMP(),
  updateTime int(10) DEFAULT UNIX_TIMESTAMP(),
  PRIMARY KEY (schoolInfoId)
) ENGINE=innodb AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '用户学校信息,年级，班级';


drop table if exists studentTeam;
CREATE TABLE studentTeam (
  teamId int(11) NOT NULL AUTO_INCREMENT,
  userId int(11) NOT NULL,
  schoolInfoId int(11) NOT NULL,
  name varchar(100) NOT NULL,
  state int(2) DEFAULT 0 comment '0unuse,1use',
  createTime int(10) DEFAULT UNIX_TIMESTAMP(),
  updateTime int(10) DEFAULT UNIX_TIMESTAMP(),
  PRIMARY KEY (teamId)
) ENGINE=innodb AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '学生学期';


drop table if exists userSubject;
CREATE TABLE userSubject (
  id int(11) NOT NULL AUTO_INCREMENT,
  userId int(11) NOT NULL,
  schoolInfoId int(11) NOT NULL,
  teamId int(11) NOT NULL,
  subjectId int(11) NOT NULL,
  state int(2) DEFAULT 0 comment '0unuse,1use',
  createTime int(10) DEFAULT UNIX_TIMESTAMP(),
  updateTime int(10) DEFAULT UNIX_TIMESTAMP(),
  PRIMARY KEY (id)
) ENGINE=innodb AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '学生老师学期课程';

drop table if exists hardLevel;
CREATE TABLE hardLevel (
  id int(10) NOT NULL AUTO_INCREMENT,
  title varchar(200) NOT NULL,
  state int(2) DEFAULT 0 comment '0unuse,1use',
  createTime int(10) DEFAULT UNIX_TIMESTAMP(),
  updateTime int(10) DEFAULT UNIX_TIMESTAMP(),
  PRIMARY KEY (id)
) ENGINE=innodb AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '难度系数';

drop table if exists questionType;
CREATE TABLE questionType (
  id int(10) NOT NULL AUTO_INCREMENT,
  title varchar(200) NOT NULL,
  state int(2) DEFAULT 0 comment '0unuse,1use',
  createTime int(10) DEFAULT UNIX_TIMESTAMP(),
  updateTime int(10) DEFAULT UNIX_TIMESTAMP(),
  PRIMARY KEY (id)
) ENGINE=innodb AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '试题类型';

drop table if exists selectQuestions;
CREATE TABLE selectQuestions (
  id int(11) NOT NULL AUTO_INCREMENT,
  subjectId int(11) NOT NULL,
  gradeId int(11) NOT NULL,
  title varchar(500) NOT NULL,
  qusType tinyint(2) NOT NULL comment '题型,10:单选 20:多选',
  examScope varchar(500) NOT NULL,
  creatorId int(11) NOT NULL comment '出题人',
  answers varchar(20) NOT NULL,
  createTime int(10) DEFAULT UNIX_TIMESTAMP(),
  updateTime int(10) DEFAULT UNIX_TIMESTAMP(),
  PRIMARY KEY (id)
) ENGINE=innodb AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '选择题';

drop table if exists selectQuestionOptions;
CREATE TABLE selectQuestionOptions (
  id int(11) NOT NULL AUTO_INCREMENT,
  title varchar(200) NOT NULL,
  state int(2) DEFAULT 0 comment '0unuse,1use',
  hardLevelId int(10) DEFAULT 0 comment '难度系数类别',
  createTime int(10) DEFAULT UNIX_TIMESTAMP(),
  updateTime int(10) DEFAULT UNIX_TIMESTAMP(),
  PRIMARY KEY (id)
) ENGINE=innodb AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '选择题选项';


drop table if exists fillQuestions;
CREATE TABLE fillQuestions (
  id int(11) NOT NULL AUTO_INCREMENT,
  subjectId int(11) NOT NULL,
  gradeId int(11) NOT NULL,
  title varchar(500) NOT NULL,
  examScope varchar(500) NOT NULL comment '知识点',
  creatorId int(11) NOT NULL comment '出题人',
  answers varchar(20) NOT NULL,
  createTime int(10) DEFAULT UNIX_TIMESTAMP(),
  updateTime int(10) DEFAULT UNIX_TIMESTAMP(),
  PRIMARY KEY (id)
) ENGINE=innodb AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '填空题';


drop table if exists fillQuestionOptions;
CREATE TABLE fillQuestionOptions (
  id int(11) NOT NULL AUTO_INCREMENT,
  title varchar(200) NOT NULL,
  state int(2) DEFAULT 0 comment '0unuse,1use',
  hardLevelId int(10) DEFAULT 0 comment '难度系数类别',
  createTime int(10) DEFAULT UNIX_TIMESTAMP(),
  updateTime int(10) DEFAULT UNIX_TIMESTAMP(),
  PRIMARY KEY (id)
) ENGINE=innodb AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '选择题选项';


drop table if exists askQuestions;
CREATE TABLE askQuestions (
  id int(11) NOT NULL AUTO_INCREMENT,
  subjectId int(11) NOT NULL,
  gradeId int(11) NOT NULL,
  title varchar(500) NOT NULL,
  examScope varchar(500) NOT NULL comment '知识点',
  creatorId int(11) NOT NULL comment '出题人',
  answers varchar(20) NOT NULL,
  createTime int(10) DEFAULT UNIX_TIMESTAMP(),
  updateTime int(10) DEFAULT UNIX_TIMESTAMP(),
  PRIMARY KEY (id)
) ENGINE=innodb AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '问答题';


drop table if exists askQuestionOptions;
CREATE TABLE askQuestionOptions (
  id int(11) NOT NULL AUTO_INCREMENT,
  title varchar(200) NOT NULL,
  answer varchar(300) NOT NULL,
  state int(2) DEFAULT 0 comment '0unuse,1use',
  creatorId int(11) NOT NULL comment '出题人',
  hardLevelId int(10) DEFAULT 0 comment '难度系数类别',
  createTime int(10) DEFAULT UNIX_TIMESTAMP(),
  updateTime int(10) DEFAULT UNIX_TIMESTAMP(),
  PRIMARY KEY (id)
) ENGINE=innodb AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '问答题项及答案';


drop table if exists examPages;
CREATE TABLE examPages (
  id int(11) NOT NULL AUTO_INCREMENT,
  subjectId int(11) NOT NULL,
  gradeId int(11) NOT NULL,
  title varchar(500) NOT NULL,
  creatorId int(11) NOT NULL comment '创建人',
  createTime int(10) DEFAULT UNIX_TIMESTAMP(),
  updateTime int(10) DEFAULT UNIX_TIMESTAMP(),
  examTime int(10) DEFAULT 0 comment '开考时间',
  examLong int(10) DEFAULT 0 comment '考试时长',
  expireLong int(10) DEFAULT 0 comment '过期时间',
  PRIMARY KEY (id)
) ENGINE=innodb AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '试卷';


drop table if exists examPageQuestionTypes;
CREATE TABLE examPageQuestionTypes (
  id int(11) NOT NULL AUTO_INCREMENT,
  examPageId int(11) NOT NULL,
  questionTypeId int(11) NOT NULL,
  createTime int(10) DEFAULT UNIX_TIMESTAMP(),
  updateTime int(10) DEFAULT UNIX_TIMESTAMP(),
  PRIMARY KEY (id)
) ENGINE=innodb AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '试卷题型';


drop table if exists examPageSelects;
CREATE TABLE examPageSelects (
  id int(11) NOT NULL AUTO_INCREMENT,
  examPageId int(11) NOT NULL,
  questionId int(11) NOT NULL,
  title varchar(500) NOT NULL,
  answers varchar(20) NOT NULL,
  hardLevelId int(10) DEFAULT 0 comment '难度系数类别',
  score int(10) DEFAULT 0 comment '分值',
  minTime int(10) DEFAULT 0 comment '最短时间',
  maxTime int(10) DEFAULT 0 comment '最长时间',
  accuracy int(10) DEFAULT 0 comment '正确率',
  createTime int(10) DEFAULT UNIX_TIMESTAMP(),
  updateTime int(10) DEFAULT UNIX_TIMESTAMP(),
  PRIMARY KEY (id)
) ENGINE=innodb AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '试卷选择题';


drop table if exists examPageSelectItems;
CREATE TABLE examPageSelectItems (
  id int(11) NOT NULL AUTO_INCREMENT,
  examPageId int(11) NOT NULL,
  questionId int(11) NOT NULL,
  title varchar(500) NOT NULL comment '选项内容',
  itemNo varchar(2) NOT NULL comment '选项编号',
  createTime int(10) DEFAULT UNIX_TIMESTAMP(),
  PRIMARY KEY (id)
) ENGINE=innodb AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '试卷选择题选项';


drop table if exists examPageQuestions;
CREATE TABLE examPageQuestions (
  id int(11) NOT NULL AUTO_INCREMENT,
  examPageId int(11) NOT NULL,
  questionId int(11) NOT NULL,
  title varchar(500) NOT NULL,
  answers varchar(20) NOT NULL,
  hardLevelId int(10) DEFAULT 0 comment '难度系数类别',
  score int(10) DEFAULT 0 comment '分值',
  minTime int(10) DEFAULT 0 comment '最短时间',
  maxTime int(10) DEFAULT 0 comment '最长时间',
  accuracy int(10) DEFAULT 0 comment '正确率',
  createTime int(10) DEFAULT UNIX_TIMESTAMP(),
  updateTime int(10) DEFAULT UNIX_TIMESTAMP(),
  PRIMARY KEY (id)
) ENGINE=innodb AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '试卷问答题';


drop table if exists examPageUsers;
CREATE TABLE examPageUsers (
  id int(11) NOT NULL AUTO_INCREMENT,
  examPageId int(11) NOT NULL,
  score int(10) DEFAULT 0 comment '分值',
  userId int(11) NOT NULL comment '用户',
  state tinyint(2) NOT NULL comment '状态',
  createTime int(10) DEFAULT UNIX_TIMESTAMP(),
  PRIMARY KEY (id)
) ENGINE=innodb AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '试卷考试人';


drop table if exists examPageProctor;
CREATE TABLE examPageProctor (
  id int(11) NOT NULL AUTO_INCREMENT,
  examPageId int(11) NOT NULL,
  userId int(11) NOT NULL comment '用户',
  state tinyint(2) NOT NULL comment '状态',
  createTime int(10) DEFAULT UNIX_TIMESTAMP(),
  PRIMARY KEY (id)
) ENGINE=innodb AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '试卷监考人';


drop table if exists examPageResultInfo;
CREATE TABLE examPageResultInfo (
  id int(11) NOT NULL AUTO_INCREMENT,
  examPageId int(11) NOT NULL,
  userId int(11) NOT NULL comment '用户',
  questionId int(11) NOT NULL,
  answers varchar(20) NOT NULL,
  isRight tinyint(2) NOT NULL comment '是否正确',
  score int(10) DEFAULT 0 comment '分值',
  state tinyint(2) NOT NULL comment '状态',
  createTime int(10) DEFAULT UNIX_TIMESTAMP(),
  PRIMARY KEY (id)
) ENGINE=innodb AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '试卷答题内容';



===
题库
选择题
编号，科目，年级，题目，题型，知识点，出题人，答案，2T
选择题选项
编号，选项内容，是否可用，难度系数类别，2T
填空题
编号，科目，年级，题目，知识点，出题人，答案，2T
填空题选项
编号，选项内容，是否可用，难度系数, 2T
问答题
编号，科目，年级，题干，知识点，答案，2T
问答题项及答案
编号，题目，答案，出题人，2T
试卷
编号，科目，年级，名称，创建人，2T，考试时间，开始时长，有效时间
试卷题型
编号，试卷编号，题型编号，2T
试卷选择题
编号，试卷编号，来源编号，题目，答案，难度系数，分值，2T，最长时间，最短时间，正确率
试卷选择题选项
编号，试卷编号，选项内容，选项编号，T
试卷问答题
编号，试卷编号，来源编号，题目，答案，难度系数，分值，2T，最长时间，最短时间，正确率
试卷考试人
编号，试卷编号，分数， 用户， T，状态
试卷监考人
编号，试卷编号， 用户， T，状态
试卷答题内容
编号，试卷编号， 用户， 试题编号，答案，是否正确，得分


































