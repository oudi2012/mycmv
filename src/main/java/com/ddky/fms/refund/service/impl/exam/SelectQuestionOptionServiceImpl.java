package com.ddky.fms.refund.service.impl.exam;

import com.ddky.fms.refund.mapper.ExamInfoMapper;
import com.ddky.fms.refund.mapper.exam.SelectQuestionOptionMapper;
import com.ddky.fms.refund.model.exam.entry.SelectQuestionOption;
import com.ddky.fms.refund.service.exam.AbstractExamService;
import com.ddky.fms.refund.service.exam.SelectQuestionOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * SelectQuestionOptionService
 * @author a
 */
@Service
public class SelectQuestionOptionServiceImpl extends AbstractExamService<SelectQuestionOption> implements SelectQuestionOptionService {

    @Autowired
    private SelectQuestionOptionMapper questionOptionMapper;

    @Override
    public ExamInfoMapper<SelectQuestionOption> getExamInfoMapper() {
        return questionOptionMapper;
    }
}
