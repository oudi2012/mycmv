package com.ddky.fms.refund.model.books.political.entry;


import com.ddky.fms.refund.model.books.BookInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/***
 * 政治
 * @author oudi
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PoliticalBook extends BookInfo {
	
	
	private Integer   gradeId;
}
