package com.ddky.fms.refund.controller.rest.students;

import com.ddky.fms.refund.model.ResponseObject;
import com.ddky.fms.refund.service.AreaInfoService;
import com.ddky.fms.refund.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/***
 * 区域管理
 * @author a
 */
@Controller
@RequestMapping("area")
public class AreaInfoController {

    @Autowired
    private AreaInfoService areaInfoService;

    @ResponseBody
    @GetMapping("provinces")
    public ResponseObject provinces() {
        ResponseObject resObj = new ResponseObject();
        CommonUtils.executeSuccess(resObj, areaInfoService.listProvince());
        return resObj;
    }

    @ResponseBody
    @GetMapping("cities")
    public ResponseObject cities(int provinceId) {
        ResponseObject resObj = new ResponseObject();
        CommonUtils.executeSuccess(resObj, areaInfoService.listCities(provinceId));
        return resObj;
    }

    @ResponseBody
    @GetMapping("towns")
    public ResponseObject towns(int cityId) {
        ResponseObject resObj = new ResponseObject();
        CommonUtils.executeSuccess(resObj, areaInfoService.listTown(cityId));
        return resObj;
    }
}
