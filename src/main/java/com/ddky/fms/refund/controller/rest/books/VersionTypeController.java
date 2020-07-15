package com.ddky.fms.refund.controller.rest.books;

import com.ddky.fms.refund.model.ResponseObject;
import com.ddky.fms.refund.service.VersionTypeService;
import com.ddky.fms.refund.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/***
 * 版本类型
 * @author a
 */
@RestController
@RequestMapping("version")
public class VersionTypeController {

    @Autowired
    private VersionTypeService versionTypeService;

    @ResponseBody
    @GetMapping("list")
    public ResponseObject list() {
        ResponseObject resObj = new ResponseObject();
        CommonUtils.executeSuccess(resObj, versionTypeService.list());
        return resObj;
    }
}
