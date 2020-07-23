package com.ddky.fms.refund.model.exam.entry;


import lombok.Data;

/***
 * @author a
 * id, examPageId, questionId, title, itemNo, createTime
 */
@Data
public class PageSelectItem extends ExamBean {
    private Integer id;
    private Integer examPageId;
    private Integer questionId;
    private String title;
    private String itemNo;
    private Integer createTime;
}
