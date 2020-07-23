package com.ddky.fms.refund.model.exam.entry;

import lombok.Data;

/***
 * @author a
 * 选择题
 */
@Data
public class SelectQuestion extends ExamBean {
    private Integer id;
    private String title;
    private Integer subjectId;
    private Integer gradeId;
    private Integer qusType;
    private String examScope;
    private Long creatorId;
    private String answers;
    private Integer createTime;
    private Integer updateTime;
}
