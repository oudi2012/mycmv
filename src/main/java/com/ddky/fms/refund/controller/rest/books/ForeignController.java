package com.ddky.fms.refund.controller.rest.books;

import com.ddky.fms.refund.model.books.foreign.entry.ForeignBook;
import com.ddky.fms.refund.service.book.BookService;
import com.ddky.fms.refund.service.book.ForeignService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/***
 * ForeignBook
 * @author a
 */
@RestController
@RequestMapping("book/foreign")
public class ForeignController extends AbstractBookController<ForeignBook> {

    @Resource
    private ForeignService foreignService;

    @Override
    public BookService<ForeignBook> getBookService() {
        return foreignService;
    }
}
