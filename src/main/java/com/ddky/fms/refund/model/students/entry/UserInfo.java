package com.ddky.fms.refund.model.students.entry;


import lombok.Data;

/**
 * 用户基本信息
 * @author oudi
 *
 */
@Data
public class UserInfo {
	private Long    id;
	private String  phone;
	private String  userName;
	private String  passWord;
	/** 注册类型 */
	private String  regType;
	/** 注册日期 */
	private Long    regDate;
	/** 头像 */
	private String  headImage;
	/** 所属地区 */
	private Integer areaId;
	/** 性别 */
	private Integer sex;
	private String  birthDay;
	/** 真实姓名 */
	private String  realName;
	/** 所属学校 */
	private Integer schoolId;
	private Long    updateTime;
}
