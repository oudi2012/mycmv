package com.ddky.fms.refund.controller.rest.register;


import com.ddky.fms.refund.constants.LogConstants;
import com.ddky.fms.refund.model.ResponseObject;
import com.ddky.fms.refund.model.students.entry.TeacherInfo;
import com.ddky.fms.refund.service.TeacherInfoService;
import com.ddky.fms.refund.utils.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/***
 * teacher
 * @author a
 */
@Controller
@RequestMapping("register/teacher")
public class TeacherInfoRegister {

    private static final Logger logger = LoggerFactory.getLogger(LogConstants.TEACH_LOG);

    @Autowired
    private TeacherInfoService teacherInfoService;

    @ResponseBody
    @PostMapping
    public ResponseObject add(@RequestBody TeacherInfo teacherInfo) {
        ResponseObject resObj = new ResponseObject();
        teacherInfoService.insert(teacherInfo);
        CommonUtils.executeSuccess(resObj);
        return resObj;
    }

}
