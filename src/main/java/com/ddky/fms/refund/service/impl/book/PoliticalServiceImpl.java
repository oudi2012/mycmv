package com.ddky.fms.refund.service.impl.book;

import com.ddky.fms.refund.mapper.BookInfoMapper;
import com.ddky.fms.refund.mapper.books.PoliticalBookMapper;
import com.ddky.fms.refund.model.books.political.entry.PoliticalBook;
import com.ddky.fms.refund.service.book.AbstractBookService;
import com.ddky.fms.refund.service.book.PoliticalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/***
 * PoliticalService
 * @author a
 */
@Service("politicalService")
public class PoliticalServiceImpl extends AbstractBookService<PoliticalBook> implements PoliticalService {

    @Resource
    private PoliticalBookMapper politicalBookMapper;

    @Override
    public BookInfoMapper<PoliticalBook> getBookInfoMapper() {
        return politicalBookMapper;
    }
}
