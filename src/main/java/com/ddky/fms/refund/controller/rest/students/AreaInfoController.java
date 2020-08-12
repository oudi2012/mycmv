package com.ddky.fms.refund.controller.rest.students;

import com.ddky.fms.refund.model.ResponseObject;
import com.ddky.fms.refund.model.students.entry.AreaInfo;
import com.ddky.fms.refund.service.student.AreaInfoService;
import com.ddky.fms.refund.utils.CommonUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/***
 * 区域管理
 * @author a
 */
@RestController
@RequestMapping("area")
public class AreaInfoController {

    @Resource
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

    @ResponseBody
    @PostMapping("areaEdit")
    public ResponseObject areaEdit(@RequestBody AreaInfo areaInfo) {
        ResponseObject resObj = new ResponseObject();
        CommonUtils.executeSuccess(resObj, areaInfoService.editByCode(areaInfo));
        return resObj;
    }

    @ResponseBody
    @GetMapping("areaDel")
    public ResponseObject areaDel(Integer areaCode) {
        ResponseObject resObj = new ResponseObject();
        areaInfoService.removeByCode(areaCode);
        CommonUtils.executeSuccess(resObj);
        return resObj;
    }
}
