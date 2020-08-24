package com.ddky.fms.refund.service.impl.book;

import com.ddky.fms.refund.mapper.BookInfoMapper;
import com.ddky.fms.refund.mapper.books.GeographicalBookMapper;
import com.ddky.fms.refund.model.books.geographical.entry.GeographicalBook;
import com.ddky.fms.refund.service.book.AbstractBookService;
import com.ddky.fms.refund.service.book.GeographicalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/***
 * GeographicalService
 * @author a
 */
@Service("geographicalService")
public class GeographicalServiceImpl extends AbstractBookService<GeographicalBook> implements GeographicalService {

    @Resource
    private GeographicalBookMapper geographicalBookMapper;

    @Override
    public BookInfoMapper<GeographicalBook> getBookInfoMapper() {
        return geographicalBookMapper;
    }
}
