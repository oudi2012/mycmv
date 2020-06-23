package com.ddky.fms.refund.model.books.geographical.entry;

import com.ddky.fms.refund.model.books.BookInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 地理
 * @author oudi
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class GeographicalBook extends BookInfo {
	
	private Integer   gradeId;
}
