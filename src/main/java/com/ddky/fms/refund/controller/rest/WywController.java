package com.ddky.fms.refund.controller.rest;


import com.ddky.fms.refund.service.WywService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/***
 * wyw
 * @author a
 */
@Controller
@RequestMapping("wyw")
public class WywController {

    @Autowired
    private WywService wywService;

    public String loadGrade() {
        return "";
    }

}
