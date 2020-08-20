package com.ddky.fms.refund.controller.rest.students;


import com.ddky.fms.refund.constants.LogConstants;
import com.ddky.fms.refund.exception.BusinessException;
import com.ddky.fms.refund.model.ResponseObject;
import com.ddky.fms.refund.model.base.vo.IdListVo;
import com.ddky.fms.refund.model.students.entry.AreaInfo;
import com.ddky.fms.refund.model.students.entry.StudentInfo;
import com.ddky.fms.refund.model.students.vo.StudentInfoVo;
import com.ddky.fms.refund.service.student.AreaInfoService;
import com.ddky.fms.refund.service.student.StudentInfoService;
import com.ddky.fms.refund.utils.CommonUtils;
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

import static com.ddky.fms.refund.constants.CmvConstants.*;

/***
 * student
 * @author a
 */
@RestController
@RequestMapping("student")
public class StudentInfoController {

    private static final Logger logger = LoggerFactory.getLogger(LogConstants.STU_LOG);

    @Resource
    private StudentInfoService studentInfoService;
    @Resource
    private AreaInfoService areaInfoService;

    @ResponseBody
    @GetMapping("list")
    public ResponseObject list(StudentInfo studentInfo, int pageIndex, int pageSize) {
        logger.info("分页获取学生列表");
        ResponseObject resObj = new ResponseObject();
        CommonUtils.executeSuccess(resObj, studentInfoService.list(studentInfo, pageIndex, pageSize));
        return resObj;
    }

    @ResponseBody
    @GetMapping("findById")
    public ResponseObject findById(Long id) {
        ResponseObject resObj = new ResponseObject();
        StudentInfo studentInfo = studentInfoService.findById(id);
        if (ObjectUtils.isEmpty(studentInfo)) {
            throw new BusinessException(501, "编号 " + id + " 对应的学生信息不存在");
        }
        StudentInfoVo studentInfoVo = new StudentInfoVo();
        BeanUtils.copyProperties(studentInfo, studentInfoVo);
        List<AreaInfo> areaInfoList = areaInfoService.pathListByCode(studentInfo.getAreaId());
        if (!ObjectUtils.isEmpty(areaInfoList.get(ZERO))) {
            studentInfoVo.setProvince(areaInfoList.get(ZERO).getAreaCode());
        }
        if (!ObjectUtils.isEmpty(areaInfoList.get(ONE))) {
            studentInfoVo.setCity(areaInfoList.get(ONE).getAreaCode());
        }
        if (!ObjectUtils.isEmpty(areaInfoList.get(TWO))) {
            studentInfoVo.setTown(areaInfoList.get(TWO).getAreaCode());
        }
        CommonUtils.executeSuccess(resObj, studentInfoVo);
        return resObj;
    }

    @ResponseBody
    @PostMapping("create")
    public ResponseObject add(@RequestBody StudentInfo studentInfo) {
        ResponseObject resObj = new ResponseObject();
        studentInfo.setPassWord(DEFAULT_PWD);
        studentInfoService.insert(studentInfo);
        CommonUtils.executeSuccess(resObj);
        return resObj;
    }

    @ResponseBody
    @PostMapping("edit")
    public ResponseObject edit(@RequestBody StudentInfo studentInfo) {
        ResponseObject resObj = new ResponseObject();
        CommonUtils.executeSuccess(resObj, studentInfoService.edit(studentInfo));
        return resObj;
    }

    @ResponseBody
    @PostMapping("remove")
    public ResponseObject remove(@RequestBody IdListVo idListVo) {
        Preconditions.checkArgument(!ObjectUtils.isEmpty(idListVo), "删除参数不能为空");
        ResponseObject resObj = new ResponseObject();
        if (CollectionUtils.isEmpty(idListVo.getIds())) {
            idListVo.setIds(Collections.singletonList(idListVo.getId()));
        }
        CommonUtils.executeSuccess(resObj, studentInfoService.delete(idListVo.getIds()));
        return resObj;
    }
}
