package com.ddky.fms.refund.controller.rest.admin;


import com.ddky.fms.refund.constants.LogConstants;
import com.ddky.fms.refund.exception.BusinessException;
import com.ddky.fms.refund.model.ResponseObject;
import com.ddky.fms.refund.model.admin.entry.AdminInfo;
import com.ddky.fms.refund.model.base.LoginVo;
import com.ddky.fms.refund.service.admin.AdminInfoService;
import com.ddky.fms.refund.utils.CmvDesUtils;
import com.ddky.fms.refund.utils.CommonUtils;
import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/***
 * @author a
 */
@RestController
@RequestMapping("admin")
public class AdminInfoController {

    private static final Logger logger = LoggerFactory.getLogger(LogConstants.ADM_LOG);

    @Autowired
    private AdminInfoService adminInfoService;

    @ResponseBody
    @PostMapping("userInfo")
    public ResponseObject userInfo(@RequestBody LoginVo loginVo) {
        ResponseObject resObj = new ResponseObject();
        Preconditions.checkNotNull(loginVo, "管理员信息不能为空");
        Preconditions.checkNotNull(loginVo.getId(), "管理员编号不能为空");
        if (!StringUtils.isEmpty(loginVo.getUserName())) {
            AdminInfo tmpItem = adminInfoService.findByUserName(loginVo.getUserName());
            if (ObjectUtils.isEmpty(tmpItem)) {
                throw new BusinessException(501, "该用户名还没有注册");
            }
            String pwd = CmvDesUtils.encrypt(loginVo.getPassWord());
            if (pwd != null && !pwd.equals(tmpItem.getPassWord())) {
                throw new BusinessException(501, "用户名和密码不对");
            }
            CommonUtils.executeSuccess(resObj, tmpItem);
        }
        CommonUtils.executeFailure(resObj, "登录信息不能为空");
        return resObj;
    }

}
