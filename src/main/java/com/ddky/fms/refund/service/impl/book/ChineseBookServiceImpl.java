package com.ddky.fms.refund.service.impl.book;

import com.ddky.fms.refund.mapper.books.ChineseBookMapper;
import com.ddky.fms.refund.model.books.chinese.entry.ChineseBook;
import com.ddky.fms.refund.service.book.AbstractBookService;
import com.ddky.fms.refund.service.book.ChineseBookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/***
 * 汉语
 * @author a
 */
@Service("chineseBookService")
public class ChineseBookServiceImpl extends AbstractBookService<ChineseBook> implements ChineseBookService {

    @Resource
    private ChineseBookMapper chineseBookMapper;

    @Override
    public ChineseBookMapper getBookInfoMapper() {
        return chineseBookMapper;
    }
}