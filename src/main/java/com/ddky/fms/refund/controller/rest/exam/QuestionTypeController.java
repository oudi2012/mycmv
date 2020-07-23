package com.ddky.fms.refund.controller.rest.exam;

import com.ddky.fms.refund.model.ResponseObject;
import com.ddky.fms.refund.model.exam.entry.QuestionType;
import com.ddky.fms.refund.service.exam.QuestionTypeService;
import com.ddky.fms.refund.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/***
 * QuestionType
 * @author a
 */
@RestController
@RequestMapping("exam/questionType/")
public class QuestionTypeController {

    @Autowired
    private QuestionTypeService examService;

    @ResponseBody
    @GetMapping("pageList")
    public ResponseObject list(QuestionType item, int pageIndex, int pageSize) {
        ResponseObject resObj = new ResponseObject();
        CommonUtils.executeSuccess(resObj, examService.pageList(item, pageIndex, pageSize));
        return resObj;
    }

    @ResponseBody
    @PostMapping("create")
    public ResponseObject create(@RequestBody QuestionType item) {
        ResponseObject resObj = new ResponseObject();
        examService.insert(item);
        CommonUtils.executeSuccess(resObj, item);
        return resObj;
    }

    @ResponseBody
    @GetMapping("findById")
    public ResponseObject findById(Integer id) {
        ResponseObject resObj = new ResponseObject();
        QuestionType item = examService.findById(id);
        CommonUtils.executeSuccess(resObj, item);
        return resObj;
    }

}
