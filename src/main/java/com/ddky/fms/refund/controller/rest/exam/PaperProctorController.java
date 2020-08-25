package com.ddky.fms.refund.controller.rest.exam;

import com.ddky.fms.refund.model.ResponseObject;
import com.ddky.fms.refund.model.exam.entry.PaperProctor;
import com.ddky.fms.refund.service.exam.PaperProctorService;
import com.ddky.fms.refund.utils.CommonUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/***
 * PaperProctor
 * @author a
 */
@RestController
@RequestMapping("exam/paperProctor/")
public class PaperProctorController {

    @Resource
    private PaperProctorService examService;

    @ResponseBody
    @GetMapping("pageList")
    public ResponseObject list(PaperProctor item, int pageIndex, int pageSize) {
        ResponseObject resObj = new ResponseObject();
        CommonUtils.executeSuccess(resObj, examService.pageList(item, pageIndex, pageSize));
        return resObj;
    }

    @ResponseBody
    @PostMapping("create")
    public ResponseObject create(@RequestBody PaperProctor item) {
        ResponseObject resObj = new ResponseObject();
        examService.insert(item);
        CommonUtils.executeSuccess(resObj, item);
        return resObj;
    }

    @ResponseBody
    @GetMapping("findById")
    public ResponseObject findById(Integer id) {
        ResponseObject resObj = new ResponseObject();
        PaperProctor item = examService.findById(id);
        CommonUtils.executeSuccess(resObj, item);
        return resObj;
    }

}
