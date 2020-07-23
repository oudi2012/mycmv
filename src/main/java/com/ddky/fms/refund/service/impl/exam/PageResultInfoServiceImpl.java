package com.ddky.fms.refund.service.impl.exam;

import com.ddky.fms.refund.mapper.ExamInfoMapper;
import com.ddky.fms.refund.mapper.exam.PageResultInfoMapper;
import com.ddky.fms.refund.model.exam.entry.PageResultInfo;
import com.ddky.fms.refund.service.exam.AbstractExamService;
import com.ddky.fms.refund.service.exam.PageResultInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * PageResultInfoService
 * @author a
 */
@Service
public class PageResultInfoServiceImpl extends AbstractExamService<PageResultInfo> implements PageResultInfoService {

    @Autowired
    private PageResultInfoMapper pageResultInfoMapper;

    @Override
    public ExamInfoMapper<PageResultInfo> getExamInfoMapper() {
        return pageResultInfoMapper;
    }
}
