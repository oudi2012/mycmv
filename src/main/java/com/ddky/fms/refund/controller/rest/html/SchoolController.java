package com.ddky.fms.refund.controller.rest.html;

import com.ddky.fms.refund.model.ResponseObject;
import com.ddky.fms.refund.service.HtmlSchoolService;
import com.ddky.fms.refund.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/***
 * @author a
 */
@Controller
@RequestMapping("html")
public class SchoolController {

    @Autowired
    private HtmlSchoolService htmlSchoolService;

    @ResponseBody
    @GetMapping("schools")
    public ResponseObject schools() {
        ResponseObject resObj = new ResponseObject();
        htmlSchoolService.listSchoolInfo(1);
        CommonUtils.executeSuccess(resObj);
        return resObj;
    }

}
