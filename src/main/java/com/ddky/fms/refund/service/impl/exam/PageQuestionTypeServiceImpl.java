package com.ddky.fms.refund.service.impl.exam;

import com.ddky.fms.refund.mapper.ExamInfoMapper;
import com.ddky.fms.refund.mapper.exam.PageQuestionTypeMapper;
import com.ddky.fms.refund.model.exam.entry.PageQuestionType;
import com.ddky.fms.refund.service.exam.AbstractExamService;
import com.ddky.fms.refund.service.exam.PageQuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/***
 * PageQuestionTypeService
 * @author a
 */
@Service
public class PageQuestionTypeServiceImpl extends AbstractExamService<PageQuestionType> implements PageQuestionTypeService {

    @Autowired
    private PageQuestionTypeMapper pageQuestionTypeMapper;

    @Override
    public ExamInfoMapper<PageQuestionType> getExamInfoMapper() {
        return pageQuestionTypeMapper;
    }
}
