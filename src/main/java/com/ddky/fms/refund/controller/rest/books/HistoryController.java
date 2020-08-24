package com.ddky.fms.refund.controller.rest.books;

import com.ddky.fms.refund.model.books.history.entry.HistoryBook;
import com.ddky.fms.refund.service.book.BookService;
import com.ddky.fms.refund.service.book.HistoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/***
 * HistoryBook
 * @author a
 */
@RestController
@RequestMapping("book/history")
public class HistoryController extends AbstractController<HistoryBook>{

    @Resource
    private HistoryService historyService;

    @Override
    public BookService<HistoryBook> getBookService() {
        return historyService;
    }
}
