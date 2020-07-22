package com.ddky.fms.refund.model.exam.entry;

import lombok.Data;

/***
 * 选择题选项
 * @author a
 */
@Data
public class SelectQuestionOption {
    private Integer id;
    private String title;
    private Integer state;
    private Integer hardLevelId;
    private Integer createTime;
    private Integer updateTime;
}
