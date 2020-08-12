package com.ddky.fms.refund.controller.handle;

import com.ddky.fms.refund.configuration.CurrentUser;
import com.ddky.fms.refund.exception.BusinessException;
import com.ddky.fms.refund.model.admin.entry.AdminInfo;
import com.ddky.fms.refund.service.TokenService;
import com.ddky.fms.refund.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.annotation.Resource;

import static com.ddky.fms.refund.constants.CmvConstants.TOKEN;

/***
 * @author a
 */
@Component
public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {

    private static final Logger logger = LoggerFactory.getLogger(CurrentUserMethodArgumentResolver.class);

    @Resource
    private TokenService tokenService;

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        //如果参数类型是User并且有CurrentUser注解则支持
        return methodParameter.getParameterType().isAssignableFrom(AdminInfo.class) &&
                methodParameter.hasParameterAnnotation(CurrentUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest nativeWebRequest, WebDataBinderFactory binderFactory) throws Exception {
        String tokenInfo = nativeWebRequest.getHeader(TOKEN);
        logger.info("获取当前用户的登录token:{}", tokenInfo);
        if (!StringUtils.isEmpty(tokenInfo)) {
            //从数据库中查询并返回
            return tokenService.getUserByToken(tokenInfo);
        }
        throw new BusinessException(501, "token 不存在");
    }
}
