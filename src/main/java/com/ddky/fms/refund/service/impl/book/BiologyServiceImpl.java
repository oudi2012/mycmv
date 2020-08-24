package com.ddky.fms.refund.service.impl.book;

import com.ddky.fms.refund.mapper.BookInfoMapper;
import com.ddky.fms.refund.mapper.books.BiologyBookMapper;
import com.ddky.fms.refund.model.books.biology.entry.BiologyBook;
import com.ddky.fms.refund.service.book.AbstractBookService;
import com.ddky.fms.refund.service.book.BiologyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author a
 */
@Service("biologyService")
public class BiologyServiceImpl extends AbstractBookService<BiologyBook> implements BiologyService {

    @Resource
    private BiologyBookMapper biologyBookMapper;

    @Override
    public BookInfoMapper<BiologyBook> getBookInfoMapper() {
        return biologyBookMapper;
    }
}
