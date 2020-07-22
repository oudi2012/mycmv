package com.ddky.fms.refund.model.exam.entry;

import lombok.Data;

/***
 * @author a
 * 问答题
 */
@Data
public class AskQuestion {
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
