package com.ddky.fms.refund.service.impl.exam;

import com.ddky.fms.refund.mapper.ExamInfoMapper;
import com.ddky.fms.refund.mapper.exam.PageProctorMapper;
import com.ddky.fms.refund.model.exam.entry.PageProctor;
import com.ddky.fms.refund.service.exam.AbstractExamService;
import com.ddky.fms.refund.service.exam.PageProctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * PageProctorService
 * @author a
 */
@Service
public class PageProctorServiceImpl extends AbstractExamService<PageProctor> implements PageProctorService {

    @Autowired
    private PageProctorMapper pageProctorMapper;

    @Override
    public ExamInfoMapper<PageProctor> getExamInfoMapper() {
        return pageProctorMapper;
    }
}
