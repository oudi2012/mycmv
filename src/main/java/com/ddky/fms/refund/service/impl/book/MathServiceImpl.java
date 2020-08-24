package com.ddky.fms.refund.service.impl.book;

import com.ddky.fms.refund.mapper.BookInfoMapper;
import com.ddky.fms.refund.mapper.books.MathBookMapper;
import com.ddky.fms.refund.model.books.maths.entry.MathBook;
import com.ddky.fms.refund.service.book.AbstractBookService;
import com.ddky.fms.refund.service.book.MathService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/***
 * MathService
 * @author a
 */
@Service("mathService")
public class MathServiceImpl extends AbstractBookService<MathBook> implements MathService {

    @Resource
    private MathBookMapper mathBookMapper;

    @Override
    public BookInfoMapper<MathBook> getBookInfoMapper() {
        return mathBookMapper;
    }
}
