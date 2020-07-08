package com.ddky.fms.refund.model.books.chinese.entry;

import com.ddky.fms.refund.model.books.BookInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/***
 * 语文
 * @author oudi
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ChineseBook extends BookInfo {

	/** 年级 */
	private Integer  gradeId;
}
