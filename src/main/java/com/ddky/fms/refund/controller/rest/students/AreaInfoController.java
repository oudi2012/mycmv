package com.ddky.fms.refund.controller.rest.students;

import com.ddky.fms.refund.model.ResponseObject;
import com.ddky.fms.refund.model.students.entry.AreaInfo;
import com.ddky.fms.refund.service.AreaInfoService;
import com.ddky.fms.refund.utils.CommonUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
    @RequestMapping("list")
    public ResponseObject list(@RequestBody AreaInfo areaInfo) {
        ResponseObject resObj = new ResponseObject();
        PageInfo<AreaInfo> pageInfo = areaInfoService.list(areaInfo);
        CommonUtils.executeSuccess(resObj, pageInfo);
        return resObj;
    }
}
