package com.ddky.fms.refund.model.books.foreign.entry;


import com.ddky.fms.refund.model.books.BookInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/***
 * 英语
 * @author oudi
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class EnglishBook extends BookInfo {
	private Integer   gradeId;
}
