package com.ddky.fms.refund.model.exam.entry;

import lombok.Data;

/***
 * 难度系数
 * @author a
 */
@Data
public class HardLevel extends ExamBean {
    private Integer id;
    private String title;
    private Integer state;
    private Integer orderNo;
    private Integer createTime;
    private Integer updateTime;
}
