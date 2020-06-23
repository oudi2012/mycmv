package com.ddky.fms.refund.model.books.biology.entry;

import com.ddky.fms.refund.model.books.BookInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/***
 * 生物
 * @author oudi
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BiologyBook extends BookInfo {

	/** 年级 */
	private Integer  gradeId;
}
