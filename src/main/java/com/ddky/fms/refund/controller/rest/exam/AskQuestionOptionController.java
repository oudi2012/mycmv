package com.ddky.fms.refund.controller.rest.exam;

import com.ddky.fms.refund.model.ResponseObject;
import com.ddky.fms.refund.model.exam.entry.AskQuestionOption;
import com.ddky.fms.refund.service.exam.AskQuestionOptionService;
import com.ddky.fms.refund.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/***
 * AskQuestionOption
 * @author a
 */
@RestController
@RequestMapping("exam/askQuestionOption/")
public class AskQuestionOptionController {

    @Autowired
    private AskQuestionOptionService examService;

    @ResponseBody
    @GetMapping("pageList")
    public ResponseObject list(AskQuestionOption item, int pageIndex, int pageSize) {
        ResponseObject resObj = new ResponseObject();
        CommonUtils.executeSuccess(resObj, examService.pageList(item, pageIndex, pageSize));
        return resObj;
    }

    @ResponseBody
    @PostMapping("create")
    public ResponseObject create(@RequestBody AskQuestionOption item) {
        ResponseObject resObj = new ResponseObject();
        examService.insert(item);
        CommonUtils.executeSuccess(resObj, item);
        return resObj;
    }

    @ResponseBody
    @GetMapping("findById")
    public ResponseObject findById(Integer id) {
        ResponseObject resObj = new ResponseObject();
        AskQuestionOption item = examService.findById(id);
        CommonUtils.executeSuccess(resObj, item);
        return resObj;
    }

}
