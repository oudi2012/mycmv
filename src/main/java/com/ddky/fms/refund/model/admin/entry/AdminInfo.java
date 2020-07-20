package com.ddky.fms.refund.model.admin.entry;


import lombok.Data;

/***
 * @author a
 * id, userName, passWord, areaId, headImage, realName, role
 */
@Data
public class AdminInfo {
    private Long    id;
    private String  userName;
    private String  passWord;
    /** 注册日期 */
    private Long    regDate;
    /** 头像 */
    private String  headImage;
    /** 所属地区 */
    private Integer areaId;
    /** 真实姓名 */
    private String  realName;
    private Long    updateTime;
}
