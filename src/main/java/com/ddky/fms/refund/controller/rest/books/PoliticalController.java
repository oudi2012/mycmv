package com.ddky.fms.refund.controller.rest.books;

import com.ddky.fms.refund.model.books.political.entry.PoliticalBook;
import com.ddky.fms.refund.service.book.BookService;
import com.ddky.fms.refund.service.book.PoliticalService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/***
 * PoliticalBook
 * @author a
 */
@RestController
@RequestMapping("book/political")
public class PoliticalController extends AbstractController<PoliticalBook>{

    @Resource
    private PoliticalService politicalService;

    @Override
    public BookService<PoliticalBook> getBookService() {
        return politicalService;
    }
}
