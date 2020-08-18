package com.ddky.fms.refund.controller.rest.students;


import com.ddky.fms.refund.constants.LogConstants;
import com.ddky.fms.refund.model.ResponseObject;
import com.ddky.fms.refund.model.students.entry.StudentInfo;
import com.ddky.fms.refund.service.student.StudentInfoService;
import com.ddky.fms.refund.utils.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/***
 * student
 * @author a
 */
@RestController
@RequestMapping("student")
public class StudentInfoController {

    private static final Logger logger = LoggerFactory.getLogger(LogConstants.STU_LOG);

    @Resource
    private StudentInfoService studentInfoService;

    @ResponseBody
    @GetMapping("list")
    public ResponseObject list(StudentInfo studentInfo, int pageIndex, int pageSize) {
        logger.info("分页获取学生列表");
        ResponseObject resObj = new ResponseObject();
        CommonUtils.executeSuccess(resObj, studentInfoService.list(studentInfo, pageIndex, pageSize));
        return resObj;
    }

    @ResponseBody
    @GetMapping("findById")
    public ResponseObject findById(Long id) {
        ResponseObject resObj = new ResponseObject();
        CommonUtils.executeSuccess(resObj, studentInfoService.findById(id));
        return resObj;
    }

    @ResponseBody
    @PostMapping("add")
    public ResponseObject add(@RequestBody StudentInfo studentInfo) {
        ResponseObject resObj = new ResponseObject();
        studentInfoService.insert(studentInfo);
        CommonUtils.executeSuccess(resObj);
        return resObj;
    }

    @ResponseBody
    @PostMapping("edit")
    public ResponseObject edit(@RequestBody StudentInfo studentInfo) {
        ResponseObject resObj = new ResponseObject();
        CommonUtils.executeSuccess(resObj, studentInfoService.edit(studentInfo));
        return resObj;
    }

    @ResponseBody
    @PostMapping("remove")
    public ResponseObject remove(@RequestBody List<Long> ids) {
        ResponseObject resObj = new ResponseObject();
        CommonUtils.executeSuccess(resObj, studentInfoService.delete(ids));
        return resObj;
    }
}
