package com.ddky.fms.refund.controller.rest.books;

import com.ddky.fms.refund.model.books.chemistry.entry.ChemistryBook;
import com.ddky.fms.refund.service.book.BookService;
import com.ddky.fms.refund.service.book.ChemistryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/***
 * Chemistry
 * @author a
 */
@RestController
@RequestMapping("book/chemistry")
public class ChemistryController extends AbstractBookController<ChemistryBook> {

    @Resource
    private ChemistryService chemistryService;

    @Override
    public BookService<ChemistryBook> getBookService() {
        return chemistryService;
    }
}
