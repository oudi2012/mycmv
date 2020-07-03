package com.ddky.fms.refund.controller.rest.html;

import com.ddky.fms.refund.model.ResponseObject;
import com.ddky.fms.refund.model.students.entry.SchoolInfo;
import com.ddky.fms.refund.service.HtmlSchoolService;
import com.ddky.fms.refund.utils.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/***
 * @author a
 */
@Controller
@RequestMapping("html")
public class SchoolController {

    private static final Logger logger = LoggerFactory.getLogger(SchoolController.class);

    @Autowired
    private HtmlSchoolService htmlSchoolService;

    @ResponseBody
    @GetMapping("schools")
    public ResponseObject schools() {
        ResponseObject resObj = new ResponseObject();
        int pageIndex = 1;
        while (true) {
            logger.info("开始执行抓取学校信息,第{}页", pageIndex);
            List<SchoolInfo> schoolInfoList = htmlSchoolService.listSchoolInfo(pageIndex);
            if (CollectionUtils.isEmpty(schoolInfoList)) {
                logger.info("抓取学校信息完成,第{}页 0条", pageIndex);
                break;
            }
            logger.info("抓取学校信息完成,第{}页 {}条", pageIndex, schoolInfoList.size());
        }
        CommonUtils.executeSuccess(resObj);
        return resObj;
    }

}