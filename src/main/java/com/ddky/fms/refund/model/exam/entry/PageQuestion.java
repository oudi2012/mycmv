package com.ddky.fms.refund.model.exam.entry;


import lombok.Data;

/***
 * @author a
 * id, examPageId, questionId, title, answers, hardLevelId, score, minTime, maxTime, accuracy, createTime, updateTime
 */
@Data
public class PageQuestion extends ExamBean {
    private Integer id;
    private Integer examPageId;
    private Integer questionId;
    private String title;
    private String answers;
    private Integer hardLevelId;
    private Integer score;
    private Integer minTime;
    private Integer maxTime;
    private Integer accuracy;
    private Integer createTime;
    private Integer updateTime;
}
