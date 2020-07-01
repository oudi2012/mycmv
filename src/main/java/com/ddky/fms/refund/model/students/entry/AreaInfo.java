package com.ddky.fms.refund.model.students.entry;


import com.ddky.fms.refund.model.base.PageVo;
import lombok.Data;

/**
 * 地区
 * @author oudi
 *
 */
@Data
public class AreaInfo extends PageVo {
	
	private int		areaCode;
	private String	areaName;
	private int		parentCode;
	private int		orderBy;
}
