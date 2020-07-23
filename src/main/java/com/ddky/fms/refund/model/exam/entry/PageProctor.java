package com.ddky.fms.refund.model.exam.entry;


import lombok.Data;

/***
 * @author a
 * id, examPageId, userId, state, createTime
 */
@Data
public class PageProctor {
    private Integer id;
    private Integer examPageId;
    private Long userId;
    private Integer state;
    private Integer createTime;
}
