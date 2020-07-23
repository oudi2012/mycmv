package com.ddky.fms.refund.service.impl.exam;

import com.ddky.fms.refund.mapper.ExamInfoMapper;
import com.ddky.fms.refund.mapper.exam.PageSelectItemMapper;
import com.ddky.fms.refund.model.exam.entry.PageSelectItem;
import com.ddky.fms.refund.service.exam.AbstractExamService;
import com.ddky.fms.refund.service.exam.PageSelectItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * PageSelectItemService
 * @author a
 */
@Service
public class PageSelectItemServiceImpl extends AbstractExamService<PageSelectItem> implements PageSelectItemService {

    @Autowired
    private PageSelectItemMapper pageSelectItemMapper;

    @Override
    public ExamInfoMapper<PageSelectItem> getExamInfoMapper() {
        return pageSelectItemMapper;
    }
}
