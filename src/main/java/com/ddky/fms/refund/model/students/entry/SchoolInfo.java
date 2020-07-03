package com.ddky.fms.refund.model.students.entry;

import lombok.Data;

import java.util.Date;

/***
 * 学校信息
 * @author a
 */
@Data
public class SchoolInfo {
    private Long        schoolId;
    private String      name;
    private String      shortName;
    private String      pinyin;
    private String      address;
    /** 是否是重点 */
    private String      weight;
    /** 国家 */
    private Integer     country;
    private Integer     province;
    private Integer     city;
    private Integer     town;
    private Date        createDate;
    /** 临时字段 */
    private String      href;
}
