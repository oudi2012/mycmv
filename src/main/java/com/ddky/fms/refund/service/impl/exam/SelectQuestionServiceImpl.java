package com.ddky.fms.refund.service.impl.exam;

import com.ddky.fms.refund.mapper.ExamInfoMapper;
import com.ddky.fms.refund.mapper.exam.SelectQuestionMapper;
import com.ddky.fms.refund.model.exam.entry.SelectQuestion;
import com.ddky.fms.refund.service.exam.AbstractExamService;
import com.ddky.fms.refund.service.exam.SelectQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * SelectQuestionService
 * @author a
 */
@Service
public class SelectQuestionServiceImpl extends AbstractExamService<SelectQuestion> implements SelectQuestionService {

    @Autowired
    private SelectQuestionMapper selectQuestionMapper;

    @Override
    public ExamInfoMapper<SelectQuestion> getExamInfoMapper() {
        return selectQuestionMapper;
    }
}
