package com.ddky.fms.refund.controller.rest.exam;

import com.ddky.fms.refund.model.ResponseObject;
import com.ddky.fms.refund.model.exam.entry.HardLevel;
import com.ddky.fms.refund.service.exam.HardLevelService;
import com.ddky.fms.refund.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/***
 * 难度系数
 * @author a
 */
@RestController
@RequestMapping("exam/hardLevel/")
public class HardLevelController {

    @Autowired
    private HardLevelService examService;

    @ResponseBody
    @GetMapping("pageList")
    public ResponseObject list(HardLevel item, int pageIndex, int pageSize) {
        ResponseObject resObj = new ResponseObject();
        CommonUtils.executeSuccess(resObj, examService.pageList(item, pageIndex, pageSize));
        return resObj;
    }

    @ResponseBody
    @PostMapping("create")
    public ResponseObject create(@RequestBody HardLevel item) {
        ResponseObject resObj = new ResponseObject();
        examService.insert(item);
        CommonUtils.executeSuccess(resObj, item);
        return resObj;
    }

    @ResponseBody
    @GetMapping("findById")
    public ResponseObject findById(Integer id) {
        ResponseObject resObj = new ResponseObject();
        HardLevel item = examService.findById(id);
        CommonUtils.executeSuccess(resObj, item);
        return resObj;
    }

}