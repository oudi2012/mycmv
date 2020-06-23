package com.ddky.fms.refund.model.books.maths.entry;

import com.ddky.fms.refund.model.books.BookInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/***
 * 数学
 * @author audi
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MathBook extends BookInfo {
	
	private Integer   gradeId;
}