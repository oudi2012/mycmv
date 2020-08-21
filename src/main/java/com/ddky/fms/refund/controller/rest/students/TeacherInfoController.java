package com.ddky.fms.refund.controller.rest.students;


import com.ddky.fms.refund.model.ResponseObject;
import com.ddky.fms.refund.model.students.entry.TeacherInfo;
import com.ddky.fms.refund.service.student.TeacherInfoService;
import com.ddky.fms.refund.utils.CommonUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/***
 * TeacherInfo
 * @author a
 */
@RestController
@RequestMapping("teacher")
public class TeacherInfoController {

    @Resource
    private TeacherInfoService teacherInfoService;

    @ResponseBody
    @GetMapping("list")
    public ResponseObject list(TeacherInfo teacherInfo, int pageIndex, int pageSize) {
        ResponseObject resObj = new ResponseObject();
        CommonUtils.executeSuccess(resObj, teacherInfoService.list(teacherInfo, pageIndex, pageSize));
        return resObj;
    }

    @ResponseBody
    @GetMapping("findById")
    public ResponseObject findById(Long id) {
        ResponseObject resObj = new ResponseObject();
        CommonUtils.executeSuccess(resObj, teacherInfoService.findById(id));
        return resObj;
    }

    @ResponseBody
    @PostMapping("add")
    public ResponseObject add(@RequestBody TeacherInfo teacherInfo) {
        ResponseObject resObj = new ResponseObject();
        teacherInfoService.insert(teacherInfo);
        CommonUtils.executeSuccess(resObj);
        return resObj;
    }

    @ResponseBody
    @PostMapping("edit")
    public ResponseObject edit(@RequestBody TeacherInfo teacherInfo) {
        ResponseObject resObj = new ResponseObject();
        CommonUtils.executeSuccess(resObj, teacherInfoService.edit(teacherInfo));
        return resObj;
    }

    @ResponseBody
    @PostMapping("remove")
    public ResponseObject remove(@RequestBody List<Long> ids) {
        ResponseObject resObj = new ResponseObject();
        CommonUtils.executeSuccess(resObj, teacherInfoService.delete(ids));
        return resObj;
    }

}
