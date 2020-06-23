package com.ddky.fms.refund.model.books.chemistry.entry;

import com.ddky.fms.refund.model.books.BookInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/***
 * huaxue
 * @author oudi
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ChemistryBook extends BookInfo {
	
	private Integer   gradeId;
}
