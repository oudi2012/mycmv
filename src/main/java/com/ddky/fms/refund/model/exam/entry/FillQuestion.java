package com.ddky.fms.refund.model.exam.entry;

import lombok.Data;

/***
 * @author a
 * 填空题
 */
@Data
public class FillQuestion extends ExamBean {
    private Integer id;
    private String title;
    private Integer subjectId;
    private Integer gradeId;
    private String examScope;
    private Long creatorId;
    private String answers;
    private Integer createTime;
    private Integer updateTime;
}
