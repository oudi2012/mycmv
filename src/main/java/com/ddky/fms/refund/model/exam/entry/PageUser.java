package com.ddky.fms.refund.model.exam.entry;


import lombok.Data;

/***
 * @author a
 * id, examPageId, score, userId, state, createTime
 */
@Data
public class PageUser extends ExamBean {
    private Integer id;
    private Integer examPageId;
    private Long userId;
    private Integer score;
    private Integer state;
    private Integer createTime;
}
