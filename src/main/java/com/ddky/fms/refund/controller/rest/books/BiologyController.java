package com.ddky.fms.refund.controller.rest.books;


import com.ddky.fms.refund.model.books.biology.entry.BiologyBook;
import com.ddky.fms.refund.service.book.BiologyService;
import com.ddky.fms.refund.service.book.BookService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/***
 * BiologyBook
 * @author a
 */
@RestController
@RequestMapping("book/biology")
public class BiologyController extends AbstractController<BiologyBook> {

    @Resource
    private BiologyService biologyService;

    @Override
    public BookService<BiologyBook> getBookService() {
        return biologyService;
    }
}
