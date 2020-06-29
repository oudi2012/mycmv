package com.ddky.fms.refund.model.students.entry;


import lombok.Data;

/**
 * 地区
 * @author oudi
 *
 */
@Data
public class AreaInfo {
	
	private int		areaCode;
	private String	areaName;
	private int		parentCode;
	private int		orderBy;
}
