package com.ddky.fms.refund.service.impl.exam;

import com.ddky.fms.refund.mapper.ExamInfoMapper;
import com.ddky.fms.refund.mapper.exam.PageUserMapper;
import com.ddky.fms.refund.model.exam.entry.PageUser;
import com.ddky.fms.refund.service.exam.AbstractExamService;
import com.ddky.fms.refund.service.exam.PageUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * PageUserService
 * @author a
 */
@Service
public class PageUserServiceImpl extends AbstractExamService<PageUser> implements PageUserService {

    @Autowired
    private PageUserMapper pageUserMapper;

    @Override
    public ExamInfoMapper<PageUser> getExamInfoMapper() {
        return pageUserMapper;
    }
}
