package com.ddky.fms.refund.model.exam.entry;

import lombok.Data;

/***
 * 试题类型
 * @author a
 */
@Data
public class QuestionType {
    private Integer id;
    private String title;
    private Integer state;
    private Integer orderNo;
    private Integer createTime;
    private Integer updateTime;
}
