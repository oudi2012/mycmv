package com.ddky.fms.refund.model.exam.entry;

import lombok.Data;

/***
 * 填空题选项
 * @author a
 */
@Data
public class FillQuestionOption extends ExamBean {
    private Integer id;
    private String title;
    private Integer state;
    private Integer hardLevelId;
    private Integer createTime;
    private Integer updateTime;
}
