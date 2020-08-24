package com.ddky.fms.refund.service.impl.book;

import com.ddky.fms.refund.mapper.BookInfoMapper;
import com.ddky.fms.refund.mapper.books.HistoryBookMapper;
import com.ddky.fms.refund.model.books.history.entry.HistoryBook;
import com.ddky.fms.refund.service.book.AbstractBookService;
import com.ddky.fms.refund.service.book.HistoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/***
 * HistoryService
 * @author a
 */
@Service("historyService")
public class HistoryServiceImpl extends AbstractBookService<HistoryBook> implements HistoryService {

    @Resource
    private HistoryBookMapper historyBookMapper;

    @Override
    public BookInfoMapper<HistoryBook> getBookInfoMapper() {
        return historyBookMapper;
    }
}
