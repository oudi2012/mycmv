package com.ddky.fms.refund.model.exam.entry;


import lombok.Data;

/***
 * @author a
 * id, examPageId, userId, questionId, answers, isRight, score, state, createTime
 */
@Data
public class PageResultInfo extends ExamBean {
    private Integer id;
    private Integer examPageId;
    private Long userId;
    private Integer questionId;
    private String answers;
    private Integer isRight;
    private Integer score;
    private Integer state;
    private Integer createTime;
}
