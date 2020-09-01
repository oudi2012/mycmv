package com.ddky.fms.refund.model.exam.entry;

import lombok.Data;
import lombok.EqualsAndHashCode;

/***
 * @author a
 * 选择题
 */
@EqualsAndHashCode(callSuper = true)
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
    private Integer hardLevelId;
    private Integer createTime;
    private Integer updateTime;
}
