package com.ddky.fms.refund.model.books;

import lombok.Data;

/***
 * 书籍基类
 * @author oudi
 *
 */
@Data
public class BookInfo {
	 Long bookId;
	/** 书名 */
	 String bookName;
	/** 简称 */
	 String shortName;
	/** 出版社 */
	 Long   publisher;
	/** 年份 */
	 int    theYear;
	/** 封面 */
	 String coverImage;
	/** cip图片 */
	 String cipImage;
}
