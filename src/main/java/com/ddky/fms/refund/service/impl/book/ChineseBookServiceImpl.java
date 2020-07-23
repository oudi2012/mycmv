package com.ddky.fms.refund.service.impl.book;

import com.ddky.fms.refund.mapper.books.ChineseBookMapper;
import com.ddky.fms.refund.model.books.chinese.entry.ChineseBook;
import com.ddky.fms.refund.service.book.AbstractBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/***
 * 汉语
 * @author a
 */
@Service("chineseBookService")
public class ChineseBookServiceImpl extends AbstractBookService<ChineseBook> {

    @Autowired
    private ChineseBookMapper chineseBookMapper;

    @Override
    public ChineseBookMapper getBookInfoMapper() {
        return chineseBookMapper;
    }
}
