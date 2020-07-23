package com.ddky.fms.refund.model.exam.entry;


import lombok.Data;

/***
 * @author a
 */
@Data
public class PageQuestionType {
    private Integer id;
    private Integer examPageId;
    private Integer questionTypeId;
    private Integer createTime;
    private Integer updateTime;
}
