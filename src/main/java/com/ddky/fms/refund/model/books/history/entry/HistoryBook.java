package com.ddky.fms.refund.model.books.history.entry;


import com.ddky.fms.refund.model.books.BookInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/***
 * 历史
 * @author oudi
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class HistoryBook extends BookInfo {
	
	private Integer   gradeId;
}
