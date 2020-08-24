package com.ddky.fms.refund.controller.rest.books;

import com.ddky.fms.refund.model.books.maths.entry.MathBook;
import com.ddky.fms.refund.service.book.BookService;
import com.ddky.fms.refund.service.book.MathService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/***
 * MathBook
 * @author a
 */
@RestController
@RequestMapping("book/math")
public class MathController extends AbstractController<MathBook>{

    @Resource
    private MathService mathService;

    @Override
    public BookService<MathBook> getBookService() {
        return mathService;
    }
}
