package com.ddky.fms.refund.controller.rest.students;

import com.ddky.fms.refund.constants.LogConstants;
import com.ddky.fms.refund.model.ResponseObject;
import com.ddky.fms.refund.model.students.entry.SchoolInfo;
import com.ddky.fms.refund.service.SchoolInfoService;
import com.ddky.fms.refund.utils.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/***
 * 学校
 * @author a
 */
@RestController
@RequestMapping("school")
public class SchoolInfoController {

    private static final Logger logger = LoggerFactory.getLogger(LogConstants.STU_LOG);

    @Autowired
    private SchoolInfoService schoolInfoService;

    @ResponseBody
    @GetMapping("list")
    public ResponseObject list(SchoolInfo schoolInfo, int pageIndex, int pageSize) {
        ResponseObject resObj = new ResponseObject();
        CommonUtils.executeSuccess(resObj, schoolInfoService.list(schoolInfo, pageIndex, pageSize));
        return resObj;
    }

    @ResponseBody
    @PostMapping("create")
    public ResponseObject create(@RequestBody SchoolInfo schoolInfo) {
        ResponseObject resObj = new ResponseObject();
        schoolInfoService.insert(schoolInfo);
        CommonUtils.executeSuccess(resObj, schoolInfo);
        return resObj;
    }

    @ResponseBody
    @GetMapping("findById")
    public ResponseObject findById(Integer id) {
        ResponseObject resObj = new ResponseObject();
        SchoolInfo schoolInfo = schoolInfoService.findById(id);
        CommonUtils.executeSuccess(resObj, schoolInfo);
        return resObj;
    }


}
