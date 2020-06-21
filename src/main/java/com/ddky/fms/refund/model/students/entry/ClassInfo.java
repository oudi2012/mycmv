package com.ddky.fms.refund.model.students.entry;


import lombok.Data;


/***
 * 班级
 * @author oudi
 *
 */
@Data
public class ClassInfo {
	
	private Integer id;
	private String name;
	private Integer type;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
	

}
