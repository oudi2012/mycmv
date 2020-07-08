package com.ddky.fms.refund.controller.rest.students;

import com.ddky.fms.refund.model.ResponseObject;
import com.ddky.fms.refund.service.GradeService;
import com.ddky.fms.refund.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/***
 * 年级
 * @author a
 */
@Controller
@RequestMapping("grade")
public class GradeInfoController {

    @Autowired
    private GradeService gradeService;

    @ResponseBody
    @GetMapping("list")
    public ResponseObject list() {
        ResponseObject resObj = new ResponseObject();
        CommonUtils.executeSuccess(resObj, gradeService.list());
        return resObj;
    }

}
