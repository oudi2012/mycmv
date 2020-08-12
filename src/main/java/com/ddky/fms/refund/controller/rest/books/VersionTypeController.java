package com.ddky.fms.refund.controller.rest.books;

import com.ddky.fms.refund.model.ResponseObject;
import com.ddky.fms.refund.model.books.VersionType;
import com.ddky.fms.refund.service.VersionTypeService;
import com.ddky.fms.refund.utils.CommonUtils;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/***
 * 版本类型
 * @author a
 */
@RestController
@RequestMapping("version")
public class VersionTypeController {

    @Resource
    private VersionTypeService versionTypeService;

    @ResponseBody
    @GetMapping("list")
    public ResponseObject list() {
        ResponseObject resObj = new ResponseObject();
        CommonUtils.executeSuccess(resObj, versionTypeService.list());
        return resObj;
    }

    @ResponseBody
    @PostMapping("create")
    public ResponseObject create(@RequestBody VersionType item) {
        ResponseObject resObj = new ResponseObject();
        versionTypeService.insert(item);
        CommonUtils.executeSuccess(resObj, item);
        return resObj;
    }

    @ResponseBody
    @PostMapping("edit")
    public ResponseObject edit(@RequestBody VersionType item) {
        ResponseObject resObj = new ResponseObject();
        versionTypeService.update(item);
        CommonUtils.executeSuccess(resObj, item);
        return resObj;
    }
}
