package com.ddky.fms.refund.controller.rest.students;

import com.ddky.fms.refund.constants.LogConstants;
import com.ddky.fms.refund.model.ResponseObject;
import com.ddky.fms.refund.model.base.vo.IdListVo;
import com.ddky.fms.refund.model.students.entry.SchoolInfo;
import com.ddky.fms.refund.model.students.entry.StudentInfo;
import com.ddky.fms.refund.model.students.vo.SchoolInfoVo;
import com.ddky.fms.refund.service.student.AreaInfoService;
import com.ddky.fms.refund.service.student.SchoolInfoService;
import com.ddky.fms.refund.utils.CommonUtils;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;


/***
 * 学校
 * @author a
 */
@RestController
@RequestMapping("school")
public class SchoolInfoController {

    private static final Logger logger = LoggerFactory.getLogger(LogConstants.STU_LOG);
    private static final String MODEL_NAME = "school";

    @Resource
    private SchoolInfoService schoolInfoService;

    @ResponseBody
    @GetMapping("list")
    public ResponseObject list(SchoolInfo schoolInfo, int pageIndex, int pageSize) {
        logger.info("调用接口 {} => list", MODEL_NAME);
        ResponseObject resObj = new ResponseObject();
        PageInfo<SchoolInfo> schoolInfoPageInfo = schoolInfoService.list(schoolInfo, pageIndex, pageSize);
        if (!CollectionUtils.isEmpty(schoolInfoPageInfo.getList())) {
            PageInfo<SchoolInfoVo> schoolInfoVoPageInfo = new PageInfo<>();
            BeanUtils.copyProperties(schoolInfoPageInfo, schoolInfoVoPageInfo);
            schoolInfoVoPageInfo.setList(schoolInfoService.listToVo(schoolInfoPageInfo.getList()));
            CommonUtils.executeSuccess(resObj, schoolInfoVoPageInfo);
        } else {
            CommonUtils.executeSuccess(resObj, schoolInfoPageInfo);
        }
        return resObj;
    }

    @ResponseBody
    @GetMapping("listByParam")
    public ResponseObject listByParam(SchoolInfo schoolInfo) {
        logger.info("调用接口 {} => list", MODEL_NAME);
        Preconditions.checkArgument(!ObjectUtils.isEmpty(schoolInfo), "删除参数不能为空");
        ResponseObject resObj = new ResponseObject();
        List<SchoolInfo> schoolInfoList = schoolInfoService.listByParam(schoolInfo);
        if (!CollectionUtils.isEmpty(schoolInfoList)) {
            CommonUtils.executeSuccess(resObj, schoolInfoService.listToVo(schoolInfoList));
        } else {
            CommonUtils.executeSuccess(resObj);
        }
        return resObj;
    }

    @ResponseBody
    @PostMapping("create")
    public ResponseObject create(@RequestBody SchoolInfo schoolInfo) {
        logger.info("调用接口 {} => create", MODEL_NAME);
        ResponseObject resObj = new ResponseObject();
        schoolInfoService.insert(schoolInfo);
        CommonUtils.executeSuccess(resObj, schoolInfo);
        return resObj;
    }

    @ResponseBody
    @GetMapping("findById")
    public ResponseObject findById(Integer id) {
        logger.info("调用接口 {} => findById", MODEL_NAME);
        ResponseObject resObj = new ResponseObject();
        SchoolInfoVo schoolInfoVo = schoolInfoService.findVoById(id);
        CommonUtils.executeSuccess(resObj, schoolInfoVo);
        return resObj;
    }

    @ResponseBody
    @PostMapping("edit")
    public ResponseObject edit(@RequestBody SchoolInfo schoolInfo) {
        logger.info("调用接口 {} => edit", MODEL_NAME);
        ResponseObject resObj = new ResponseObject();
        schoolInfoService.update(schoolInfo);
        CommonUtils.executeSuccess(resObj);
        return resObj;
    }

    @ResponseBody
    @PostMapping("remove")
    public ResponseObject remove(@RequestBody IdListVo idListVo) {
        Preconditions.checkArgument(!ObjectUtils.isEmpty(idListVo), "删除参数不能为空");
        logger.info("调用接口 {} => remove", MODEL_NAME);
        ResponseObject resObj = new ResponseObject();
        if (CollectionUtils.isEmpty(idListVo.getIds())) {
            idListVo.setIds(Collections.singletonList(idListVo.getId()));
        }
        CommonUtils.executeSuccess(resObj, schoolInfoService.delete(idListVo.getIds()));
        return resObj;
    }


}
