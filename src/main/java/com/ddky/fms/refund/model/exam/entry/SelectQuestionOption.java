package com.ddky.fms.refund.model.exam.entry;

import lombok.Data;
import lombok.EqualsAndHashCode;

/***
 * 选择题选项
 * @author a
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SelectQuestionOption extends ExamBean {
    private Integer id;
    private String title;
    private Integer state;
    private Integer hardLevelId;
    private Integer createTime;
    private Integer updateTime;
}
