package com.ddky.fms.refund.controller.rest.students;


import com.ddky.fms.refund.constants.LogConstants;
import com.ddky.fms.refund.model.ResponseObject;
import com.ddky.fms.refund.model.base.vo.IdListVo;
import com.ddky.fms.refund.model.students.entry.TeacherInfo;
import com.ddky.fms.refund.service.student.TeacherInfoService;
import com.ddky.fms.refund.utils.CommonUtils;
import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collections;

/***
 * TeacherInfo
 * @author a
 */
@RestController
@RequestMapping("teacher")
public class TeacherInfoController {

    private static final Logger logger = LoggerFactory.getLogger(LogConstants.STU_LOG);
    private static final String MODEL_NAME = "teacher";

    @Resource
    private TeacherInfoService teacherInfoService;

    @ResponseBody
    @GetMapping("list")
    public ResponseObject list(TeacherInfo teacherInfo, int pageIndex, int pageSize) {
        logger.info("调用接口 {} => list", MODEL_NAME);
        ResponseObject resObj = new ResponseObject();
        CommonUtils.executeSuccess(resObj, teacherInfoService.list(teacherInfo, pageIndex, pageSize));
        return resObj;
    }

    @ResponseBody
    @GetMapping("findById")
    public ResponseObject findById(Long id) {
        logger.info("调用接口 {} => findById", MODEL_NAME);
        ResponseObject resObj = new ResponseObject();
        CommonUtils.executeSuccess(resObj, teacherInfoService.findById(id));
        return resObj;
    }

    @ResponseBody
    @PostMapping("create")
    public ResponseObject create(@RequestBody TeacherInfo teacherInfo) {
        logger.info("调用接口 {} => create", MODEL_NAME);
        ResponseObject resObj = new ResponseObject();
        teacherInfoService.insert(teacherInfo);
        CommonUtils.executeSuccess(resObj);
        return resObj;
    }

    @ResponseBody
    @PostMapping("edit")
    public ResponseObject edit(@RequestBody TeacherInfo teacherInfo) {
        logger.info("调用接口 {} => edit", MODEL_NAME);
        ResponseObject resObj = new ResponseObject();
        CommonUtils.executeSuccess(resObj, teacherInfoService.edit(teacherInfo));
        return resObj;
    }

    @ResponseBody
    @PostMapping("remove")
    public ResponseObject remove(@RequestBody IdListVo idListVo) {
        logger.info("调用接口 {} => remove", MODEL_NAME);
        Preconditions.checkArgument(!ObjectUtils.isEmpty(idListVo), "删除参数不能为空");
        ResponseObject resObj = new ResponseObject();
        if (CollectionUtils.isEmpty(idListVo.getIds())) {
            idListVo.setIds(Collections.singletonList(idListVo.getId()));
        }
        CommonUtils.executeSuccess(resObj, teacherInfoService.delete(idListVo.getIds()));
        return resObj;
    }

}
