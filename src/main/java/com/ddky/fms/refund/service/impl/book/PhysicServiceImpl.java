package com.ddky.fms.refund.service.impl.book;

import com.ddky.fms.refund.mapper.BookInfoMapper;
import com.ddky.fms.refund.mapper.books.PhysicBookMapper;
import com.ddky.fms.refund.model.books.physic.entry.PhysicBook;
import com.ddky.fms.refund.service.book.AbstractBookService;
import com.ddky.fms.refund.service.book.PhysicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/***
 * PhysicService
 * @author a
 */
@Service("physicService")
public class PhysicServiceImpl extends AbstractBookService<PhysicBook> implements PhysicService {

    @Resource
    private PhysicBookMapper physicBookMapper;

    @Override
    public BookInfoMapper<PhysicBook> getBookInfoMapper() {
        return physicBookMapper;
    }
}
