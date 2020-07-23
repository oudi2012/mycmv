package com.ddky.fms.refund.service.impl.exam;

import com.ddky.fms.refund.mapper.ExamInfoMapper;
import com.ddky.fms.refund.mapper.exam.PageSelectMapper;
import com.ddky.fms.refund.model.exam.entry.PageSelect;
import com.ddky.fms.refund.service.exam.AbstractExamService;
import com.ddky.fms.refund.service.exam.PageSelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * PageSelectService
 * @author a
 */
@Service
public class PageSelectServiceImpl extends AbstractExamService<PageSelect> implements PageSelectService {

    @Autowired
    private PageSelectMapper pageSelectMapper;

    @Override
    public ExamInfoMapper<PageSelect> getExamInfoMapper() {
        return pageSelectMapper;
    }
}
