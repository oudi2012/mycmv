package com.ddky.fms.refund.model.students.entry;


import com.ddky.fms.refund.model.base.PageVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 地区
 * @author oudi
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AreaInfo extends PageVo {
	
	private int		areaCode;
	private String	areaName;
	private int		parentCode;
	private int		orderBy;
}
