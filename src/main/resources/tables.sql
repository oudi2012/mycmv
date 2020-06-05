drop table if exists wy_grade;
CREATE TABLE `wy_grade` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `orderNo` int(4) NOT NULL DEFAULT 0 COMMENT '编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='年级';

insert into wy_grade(name) values ("小学");
insert into wy_grade(name) values ("初中");
insert into wy_grade(name) values ("高中");

drop table if exists wy_style;
CREATE TABLE `wy_style` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `orderNo` int(4) NOT NULL DEFAULT 0 COMMENT '编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='形式';

insert into wy_style(name) values ("诗");
insert into wy_style(name) values ("词");
insert into wy_style(name) values ("曲");
insert into wy_style(name) values ("文言文");

drop table if exists wy_author;
CREATE TABLE `wy_author` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `dynasty` int(10) NOT NULL DEFAULT 0 COMMENT '朝代',
  `tags` varchar(100) DEFAULT NULL COMMENT '标签',
  `detail` text DEFAULT NULL COMMENT '简介',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='人物';

drop table if exists wy_dynasty;
CREATE TABLE `wy_dynasty` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `orderNo` int(4) NOT NULL DEFAULT 0 COMMENT '编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='朝代';

insert into wy_dynasty(name) values ("先秦");
insert into wy_dynasty(name) values ("两汉");
insert into wy_dynasty(name) values ("魏晋");
insert into wy_dynasty(name) values ("南北朝");
insert into wy_dynasty(name) values ("隋代");
insert into wy_dynasty(name) values ("唐代");
insert into wy_dynasty(name) values ("五代");
insert into wy_dynasty(name) values ("宋代");
insert into wy_dynasty(name) values ("金朝");
insert into wy_dynasty(name) values ("元代");
insert into wy_dynasty(name) values ("明代");
insert into wy_dynasty(name) values ("清代");

drop table if exists wy_category;
CREATE TABLE `wy_category` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `orderNo` int(4) NOT NULL DEFAULT 0 COMMENT '编号',
  `href` varchar(100) DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='古文分类';

insert into wy_category(href,name) values ("gushi/xiaoxue.aspx","小学古诗");
insert into wy_category(href,name) values ("gushi/chuzhong.aspx","初中古诗");
insert into wy_category(href,name) values ("gushi/gaozhong.aspx","高中古诗");
insert into wy_category(href,name) values ("wenyan/xiaowen.aspx","小学文言");
insert into wy_category(href,name) values ("wenyan/chuwen.aspx","初中文言");
insert into wy_category(href,name) values ("wenyan/gaowen.aspx","高中文言");
insert into wy_category(href,name) values ("wenyan/guanzhi.aspx","古文观止");
insert into wy_category(href,name) values ("gushi/tangshi.aspx","唐诗三百");
insert into wy_category(href,name) values ("gushi/sanbai.aspx","古诗三百");
insert into wy_category(href,name) values ("gushi/songsan.aspx","宋词三百");
insert into wy_category(href,name) values ("gushi/songci.aspx","宋词精选");
insert into wy_category(href,name) values ("gushi/shijiu.aspx","古诗十九");
insert into wy_category(href,name) values ("gushi/shijing.aspx","诗经");
insert into wy_category(href,name) values ("gushi/chuci.aspx","楚辞");
insert into wy_category(href,name) values ("gushi/yuefu.aspx","乐府");
insert into wy_category(href,name) values ("gushi/xiejing.aspx","写景");
insert into wy_category(href,name) values ("gushi/yongwu.aspx","咏物");
insert into wy_category(href,name) values ("gushi/chuntian.aspx","春天");
insert into wy_category(href,name) values ("gushi/xiatian.aspx","夏天");
insert into wy_category(href,name) values ("gushi/qiutian.aspx","秋天");
insert into wy_category(href,name) values ("gushi/dongtian.aspx","冬天");
insert into wy_category(href,name) values ("gushi/yu.aspx","写雨");
insert into wy_category(href,name) values ("gushi/xue.aspx","写雪");
insert into wy_category(href,name) values ("gushi/feng.aspx","写风");
insert into wy_category(href,name) values ("gushi/hua.aspx","写花");
insert into wy_category(href,name) values ("gushi/meihua.aspx","梅花");
insert into wy_category(href,name) values ("gushi/hehua.aspx","荷花");
insert into wy_category(href,name) values ("gushi/juhua.aspx","菊花");
insert into wy_category(href,name) values ("gushi/liushu.aspx","柳树");
insert into wy_category(href,name) values ("gushi/yueliang.aspx","月亮");
insert into wy_category(href,name) values ("gushi/shanshui.aspx","山水");
insert into wy_category(href,name) values ("gushi/shan.aspx","写山");
insert into wy_category(href,name) values ("gushi/shui.aspx","写水");
insert into wy_category(href,name) values ("gushi/changjiang.aspx","长江");
insert into wy_category(href,name) values ("gushi/huanghe.aspx","黄河");
insert into wy_category(href,name) values ("gushi/ertong.aspx","儿童");
insert into wy_category(href,name) values ("gushi/niao.aspx","写鸟");
insert into wy_category(href,name) values ("gushi/ma.aspx","写马");
insert into wy_category(href,name) values ("gushi/tianyuan.aspx","田园");
insert into wy_category(href,name) values ("gushi/biansai.aspx","边塞");
insert into wy_category(href,name) values ("gushi/diming.aspx","地名");
insert into wy_category(href,name) values ("gushi/jieri.aspx","节日");
insert into wy_category(href,name) values ("gushi/chunjie.aspx","春节");
insert into wy_category(href,name) values ("gushi/yuanxiao.aspx","元宵");
insert into wy_category(href,name) values ("gushi/hanshi.aspx","寒食");
insert into wy_category(href,name) values ("gushi/qingming.aspx","清明");
insert into wy_category(href,name) values ("gushi/duanwu.aspx","端午");
insert into wy_category(href,name) values ("gushi/qixi.aspx","七夕");
insert into wy_category(href,name) values ("gushi/zhongqiu.aspx","中秋");
insert into wy_category(href,name) values ("gushi/chongyang.aspx","重阳");
insert into wy_category(href,name) values ("gushi/huaigu.aspx","怀古");
insert into wy_category(href,name) values ("gushi/shuqing.aspx","抒情");
insert into wy_category(href,name) values ("gushi/aiguo.aspx","爱国");
insert into wy_category(href,name) values ("gushi/libie.aspx","离别");
insert into wy_category(href,name) values ("gushi/songbie.aspx","送别");
insert into wy_category(href,name) values ("gushi/sixiang.aspx","思乡");
insert into wy_category(href,name) values ("gushi/sinian.aspx","思念");
insert into wy_category(href,name) values ("gushi/aiqing.aspx","爱情");
insert into wy_category(href,name) values ("gushi/lizhi.aspx","励志");
insert into wy_category(href,name) values ("gushi/zheli.aspx","哲理");
insert into wy_category(href,name) values ("gushi/guiyuan.aspx","闺怨");
insert into wy_category(href,name) values ("gushi/daowang.aspx","悼亡");
insert into wy_category(href,name) values ("gushi/xieren.aspx","写人");
insert into wy_category(href,name) values ("gushi/laoshi.aspx","老师");
insert into wy_category(href,name) values ("gushi/muqin.aspx","母亲");
insert into wy_category(href,name) values ("gushi/youqing.aspx","友情");
insert into wy_category(href,name) values ("gushi/zhanzheng.aspx","战争");
insert into wy_category(href,name) values ("gushi/dushu.aspx","读书");
insert into wy_category(href,name) values ("gushi/xishi.aspx","惜时");
insert into wy_category(href,name) values ("gushi/youguo.aspx","忧民");
insert into wy_category(href,name) values ("gushi/wanyue.aspx","婉约");
insert into wy_category(href,name) values ("gushi/haofang.aspx","豪放");
insert into wy_category(href,name) values ("gushi/minyao.aspx","民谣");

drop table if exists wy_articleInfo;
CREATE TABLE `wy_articleInfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `author` varchar(50) DEFAULT NULL COMMENT '作者',
  `grade` int(2) NOT NULL DEFAULT 0 COMMENT '年级',
  `dynasty` int(2) NOT NULL DEFAULT 0 COMMENT '朝代',
  `cateId` int(8) NOT NULL DEFAULT 0 COMMENT '分类编号',
  `styleId` int(8) NOT NULL DEFAULT 0 COMMENT '形式编号',
  `tags` varchar(100) DEFAULT NULL COMMENT '标签',
  `title` varchar(100) DEFAULT NULL,
  `cont` text DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `href` varchar(100) DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='古文内容';