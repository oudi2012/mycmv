package com.ddky.fms.refund.controller.rest.books;

import com.ddky.fms.refund.model.books.physic.entry.PhysicBook;
import com.ddky.fms.refund.service.book.BookService;
import com.ddky.fms.refund.service.book.PhysicService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/***
 * PhysicBook
 * @author a
 */
@RestController
@RequestMapping("book/physic")
public class PhysicController extends AbstractController<PhysicBook>{

    @Resource
    private PhysicService physicService;

    @Override
    public BookService<PhysicBook> getBookService() {
        return physicService;
    }
}
