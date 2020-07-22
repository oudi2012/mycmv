package com.ddky.fms.refund.model.exam.entry;

import lombok.Data;

/***
 * 问答题项及答案
 * @author a
 */
@Data
public class AskQuestionOption {
    private Integer id;
    private String title;
    private Integer state;
    private Integer hardLevelId;
    private Integer createTime;
    private Integer updateTime;
}
