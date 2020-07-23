package com.ddky.fms.refund.controller.rest.exam;

import com.ddky.fms.refund.model.ResponseObject;
import com.ddky.fms.refund.model.exam.entry.FillQuestion;
import com.ddky.fms.refund.service.exam.FillQuestionService;
import com.ddky.fms.refund.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/***
 * FillQuestion
 * @author a
 */
@RestController
@RequestMapping("exam/fillQuestion/")
public class FillQuestionController {

    @Autowired
    private FillQuestionService examService;

    @ResponseBody
    @GetMapping("pageList")
    public ResponseObject list(FillQuestion item, int pageIndex, int pageSize) {
        ResponseObject resObj = new ResponseObject();
        CommonUtils.executeSuccess(resObj, examService.pageList(item, pageIndex, pageSize));
        return resObj;
    }

    @ResponseBody
    @PostMapping("create")
    public ResponseObject create(@RequestBody FillQuestion item) {
        ResponseObject resObj = new ResponseObject();
        examService.insert(item);
        CommonUtils.executeSuccess(resObj, item);
        return resObj;
    }

    @ResponseBody
    @GetMapping("findById")
    public ResponseObject findById(Integer id) {
        ResponseObject resObj = new ResponseObject();
        FillQuestion item = examService.findById(id);
        CommonUtils.executeSuccess(resObj, item);
        return resObj;
    }

}
