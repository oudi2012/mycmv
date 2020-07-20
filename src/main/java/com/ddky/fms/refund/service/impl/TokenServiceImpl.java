package com.ddky.fms.refund.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.ddky.fms.refund.model.base.LoginVo;
import com.ddky.fms.refund.service.TokenService;
import org.springframework.stereotype.Service;

/***
 * @author a
 */
@Service
public class TokenServiceImpl implements TokenService {

    @Override
    public String getToken(LoginVo loginVo) {
        return JWT.create().withAudience(String.valueOf(loginVo.getId()))
                .sign(Algorithm.HMAC256(loginVo.getPassWord()));
    }
}
