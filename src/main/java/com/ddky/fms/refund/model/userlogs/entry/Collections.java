package com.ddky.fms.refund.model.userlogs.entry;


import lombok.Data;

import java.util.Date;

/***
 * 收藏
 * @author a
 */
@Data
public class Collections {

    private Long        id;
    private Long        userId;
    private String      title;
    private Date        createDate;

}
