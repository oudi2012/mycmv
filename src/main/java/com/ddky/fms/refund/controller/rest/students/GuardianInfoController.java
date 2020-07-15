package com.ddky.fms.refund.controller.rest.students;


import com.ddky.fms.refund.constants.LogConstants;
import com.ddky.fms.refund.model.ResponseObject;
import com.ddky.fms.refund.model.students.entry.GuardianInfo;
import com.ddky.fms.refund.service.GuardianInfoService;
import com.ddky.fms.refund.utils.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 * guardian
 * @author a
 */
@RestController
@RequestMapping("guardian")
public class GuardianInfoController {

    private static final Logger logger = LoggerFactory.getLogger(LogConstants.STU_LOG);

    @Autowired
    private GuardianInfoService guardianInfoService;

    @ResponseBody
    @GetMapping("list")
    public ResponseObject list(GuardianInfo guardianInfo, int pageIndex, int pageSize) {
        ResponseObject resObj = new ResponseObject();
        CommonUtils.executeSuccess(resObj, guardianInfoService.list(guardianInfo, pageIndex, pageSize));
        return resObj;
    }

    @ResponseBody
    @GetMapping("findById")
    public ResponseObject findById(Long id) {
        ResponseObject resObj = new ResponseObject();
        CommonUtils.executeSuccess(resObj, guardianInfoService.findById(id));
        return resObj;
    }

    @ResponseBody
    @PostMapping("add")
    public ResponseObject add(@RequestBody GuardianInfo guardianInfo) {
        ResponseObject resObj = new ResponseObject();
        guardianInfoService.insert(guardianInfo);
        CommonUtils.executeSuccess(resObj);
        return resObj;
    }

    @ResponseBody
    @PostMapping("edit")
    public ResponseObject edit(@RequestBody GuardianInfo guardianInfo) {
        ResponseObject resObj = new ResponseObject();
        CommonUtils.executeSuccess(resObj, guardianInfoService.edit(guardianInfo));
        return resObj;
    }

    @ResponseBody
    @PostMapping("remove")
    public ResponseObject remove(@RequestBody List<Long> ids) {
        ResponseObject resObj = new ResponseObject();
        CommonUtils.executeSuccess(resObj, guardianInfoService.delete(ids));
        return resObj;
    }

}
