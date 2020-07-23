package com.ddky.fms.refund.service.impl.exam;

import com.ddky.fms.refund.mapper.ExamInfoMapper;
import com.ddky.fms.refund.mapper.exam.PageQuestionMapper;
import com.ddky.fms.refund.model.exam.entry.PageQuestion;
import com.ddky.fms.refund.service.exam.AbstractExamService;
import com.ddky.fms.refund.service.exam.PageQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/***
 * PageQuestionService
 * @author a
 */
@Service
public class PageQuestionServiceImpl extends AbstractExamService<PageQuestion> implements PageQuestionService {

    @Autowired
    private PageQuestionMapper pageQuestionMapper;

    @Override
    public ExamInfoMapper<PageQuestion> getExamInfoMapper() {
        return pageQuestionMapper;
    }
}
