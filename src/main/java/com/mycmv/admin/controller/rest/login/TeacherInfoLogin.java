package com.mycmv.admin.controller.rest.login;

import com.mycmv.server.constants.LogConstants;
import com.mycmv.server.exception.BusinessException;
import com.mycmv.server.model.ResponseObject;
import com.mycmv.server.model.base.vo.LoginVo;
import com.mycmv.server.model.students.entry.TeacherInfo;
import com.mycmv.server.service.student.TeacherInfoService;
import com.mycmv.server.utils.CmvDesUtils;
import com.mycmv.server.utils.CommonUtils;
import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/***
 * @author a
 */
@RestController
@RequestMapping("login/teacher")
public class TeacherInfoLogin {

    private static final Logger logger = LoggerFactory.getLogger(LogConstants.STU_LOG);

    @Resource
    private TeacherInfoService teacherInfoService;

    @ResponseBody
    @PostMapping
    public ResponseObject login(@RequestBody LoginVo loginVo) {
        ResponseObject resObj = new ResponseObject();
        Preconditions.checkNotNull(loginVo, "登录信息不能为空");
        Preconditions.checkNotNull(loginVo.getPassWord(), "密码不能为空");
        if (!StringUtils.isEmpty(loginVo.getPhone())) {
            TeacherInfo tmpItem = teacherInfoService.findByPhone(loginVo.getPhone());
            if (ObjectUtils.isEmpty(tmpItem)) {
                throw new BusinessException(501, "该手机号还没有注册");
            }
            String pwd = CmvDesUtils.encrypt(loginVo.getPassWord());
            if (pwd != null && !pwd.equals(tmpItem.getPassWord())) {
                throw new BusinessException(501, "用户名和密码不对");
            }
        }
        CommonUtils.executeSuccess(resObj);
        return resObj;
    }

}
