package com.ddky.fms.refund.controller.rest.books;


import com.ddky.fms.refund.model.books.chinese.entry.ChineseBook;
import com.ddky.fms.refund.service.book.BookService;
import com.ddky.fms.refund.service.book.ChineseBookService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/***
 * Chinese
 * @author a
 */
@RestController
@RequestMapping("book/chinese")
public class ChineseController extends AbstractBookController<ChineseBook> {

    @Resource
    private ChineseBookService chineseBookService;

    @Override
    public BookService<ChineseBook> getBookService() {
        return chineseBookService;
    }
}
