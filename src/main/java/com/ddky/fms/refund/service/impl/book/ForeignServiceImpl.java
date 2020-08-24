package com.ddky.fms.refund.service.impl.book;

import com.ddky.fms.refund.mapper.BookInfoMapper;
import com.ddky.fms.refund.mapper.books.ForeignBookMapper;
import com.ddky.fms.refund.model.books.foreign.entry.ForeignBook;
import com.ddky.fms.refund.service.book.AbstractBookService;
import com.ddky.fms.refund.service.book.ForeignService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/***
 * ForeignService
 * @author a
 */
@Service("foreignService")
public class ForeignServiceImpl extends AbstractBookService<ForeignBook> implements ForeignService {

    @Resource
    private ForeignBookMapper foreignBookMapper;

    @Override
    public BookInfoMapper<ForeignBook> getBookInfoMapper() {
        return foreignBookMapper;
    }
}
