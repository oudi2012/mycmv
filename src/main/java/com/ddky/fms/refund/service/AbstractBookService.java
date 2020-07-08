package com.ddky.fms.refund.service;

import com.ddky.fms.refund.mapper.BookInfoMapper;
import com.ddky.fms.refund.model.books.BookInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.util.CollectionUtils;

import java.util.List;

/***
 * 课本服务接口
 * @author a
 * @param <T>
 */
public abstract class AbstractBookService<T extends BookInfo> implements BookService<T> {

    /***
     * 获取Mapper
     * @return BookInfoMapper
     */
    public abstract BookInfoMapper<T> getBookInfoMapper();

    @Override
    public List<T> list() {
        return getBookInfoMapper().list();
    }

    @Override
    public T findById(int bookId) {
        return getBookInfoMapper().findById(bookId);
    }

    @Override
    public void insert(T item) {
        getBookInfoMapper().insert(item);
    }

    @Override
    public void batchInsert(List<T> list) {
        getBookInfoMapper().batchInsert(list);
    }

    @Override
    public PageInfo<T> pageList(T t, int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<T> list = getBookInfoMapper().list();
        if (CollectionUtils.isEmpty(list)) {
            return new PageInfo<>();
        }
        return new PageInfo<>(list);
    }
}
