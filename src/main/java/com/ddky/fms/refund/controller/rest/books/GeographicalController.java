package com.ddky.fms.refund.controller.rest.books;

import com.ddky.fms.refund.model.books.geographical.entry.GeographicalBook;
import com.ddky.fms.refund.service.book.BookService;
import com.ddky.fms.refund.service.book.GeographicalService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/***
 * GeographicalBook
 * @author a
 */
@RestController
@RequestMapping("book/geographical")
public class GeographicalController extends AbstractController<GeographicalBook> {

    @Resource
    private GeographicalService geographicalService;

    @Override
    public BookService<GeographicalBook> getBookService() {
        return geographicalService;
    }
}
