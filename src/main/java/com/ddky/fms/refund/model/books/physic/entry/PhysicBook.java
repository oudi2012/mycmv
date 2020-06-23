package com.ddky.fms.refund.model.books.physic.entry;


import com.ddky.fms.refund.model.books.BookInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/***
 * 物理
 * @author oudi
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PhysicBook extends BookInfo {
	
	private Integer   gradeId;
}
