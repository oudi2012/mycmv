package com.ddky.fms.refund.model.base.vo;

import lombok.Data;

import java.util.List;

/***
 * 编号参数
 * @author a
 */
@Data
public class IdListVo {
    private Long id;
    private List<Long> ids;
}
