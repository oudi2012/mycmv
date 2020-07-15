package com.ddky.fms.refund.controller.rest.register;


import com.ddky.fms.refund.model.ResponseObject;
import com.ddky.fms.refund.model.students.entry.GuardianInfo;
import com.ddky.fms.refund.service.GuardianInfoService;
import com.ddky.fms.refund.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/***
 * guardian
 * @author a
 */
@Controller
@RequestMapping("register/guardian")
public class GuardianInfoRegister {

    @Autowired
    private GuardianInfoService guardianInfoService;


    @ResponseBody
    @PostMapping
    public ResponseObject add(@RequestBody GuardianInfo guardianInfo) {
        ResponseObject resObj = new ResponseObject();
        guardianInfoService.insert(guardianInfo);
        CommonUtils.executeSuccess(resObj);
        return resObj;
    }


}
