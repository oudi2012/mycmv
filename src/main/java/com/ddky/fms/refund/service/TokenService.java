package com.ddky.fms.refund.service;

import com.ddky.fms.refund.model.base.LoginVo;

/***
 * @author a
 */
public interface TokenService {

    /**
     * 获取token
     * @param loginVo loginVo
     * @return String
     */
    String getToken(LoginVo loginVo);
}
