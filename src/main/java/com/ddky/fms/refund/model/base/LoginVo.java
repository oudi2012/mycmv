package com.ddky.fms.refund.model.base;

import lombok.Data;

/**
 * @author a
 */
@Data
public class LoginVo {
    private Long id;
    private String phone;
    private String userName;
    private String passWord;
    private String token;
}
