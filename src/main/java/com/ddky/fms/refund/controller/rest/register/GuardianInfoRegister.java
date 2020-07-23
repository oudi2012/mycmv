package com.ddky.fms.refund.controller.rest.register;


import com.ddky.fms.refund.model.ResponseObject;
import com.ddky.fms.refund.model.students.entry.GuardianInfo;
import com.ddky.fms.refund.model.students.vo.GuardianInfoListVo;
import com.ddky.fms.refund.service.student.GuardianInfoService;
import com.ddky.fms.refund.utils.CommonUtils;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

/***
 * guardian
 * @author a
 */
@RestController
@RequestMapping("register/guardian")
public class GuardianInfoRegister {

    @Autowired
    private GuardianInfoService guardianInfoService;


    @ResponseBody
    @PostMapping
    public ResponseObject add(@RequestBody GuardianInfo guardianInfo) {
        ResponseObject resObj = new ResponseObject();
        Preconditions.checkNotNull(guardianInfo, "用户信息不能为空");
        guardianInfoService.insert(guardianInfo);
        CommonUtils.executeSuccess(resObj);
        return resObj;
    }


    @ResponseBody
    @PostMapping("list")
    public ResponseObject addList(@RequestBody GuardianInfoListVo guardianInfo) {
        ResponseObject resObj = new ResponseObject();
        Preconditions.checkNotNull(guardianInfo, "用户信息不能为空");
        guardianInfoService.batchInsert(guardianInfo.getGuardianInfoList());
        CommonUtils.executeSuccess(resObj);
        return resObj;
    }


}
