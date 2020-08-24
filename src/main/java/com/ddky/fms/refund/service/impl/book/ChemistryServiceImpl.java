package com.ddky.fms.refund.service.impl.book;

import com.ddky.fms.refund.mapper.BookInfoMapper;
import com.ddky.fms.refund.mapper.books.ChemistryBookMapper;
import com.ddky.fms.refund.model.books.chemistry.entry.ChemistryBook;
import com.ddky.fms.refund.service.book.AbstractBookService;
import com.ddky.fms.refund.service.book.ChemistryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 化学
 * @author a
 */
@Service("chemistryService")
public class ChemistryServiceImpl extends AbstractBookService<ChemistryBook> implements ChemistryService {

    @Resource
    private ChemistryBookMapper chemistryBookMapper;

    @Override
    public BookInfoMapper<ChemistryBook> getBookInfoMapper() {
        return chemistryBookMapper;
    }
}
