package com.ddky.fms.refund.controller.rest.html;

import com.ddky.fms.refund.model.ResponseObject;
import com.ddky.fms.refund.model.books.BookInfo;
import com.ddky.fms.refund.model.students.entry.SchoolInfo;
import com.ddky.fms.refund.service.HtmlSubjectService;
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
public class SubjectController {

    private static final Logger logger = LoggerFactory.getLogger(SubjectController.class);

    @Autowired
    private HtmlSubjectService htmlSubjectService;

    @ResponseBody
    @GetMapping("yuWen")
    public ResponseObject yuWen(String verType, String subType) {
        ResponseObject resObj = new ResponseObject();
        while (true) {
            logger.info("开始执行抓取科目信息,{},{}", verType, subType);
            List<? extends BookInfo> schoolInfoList = htmlSubjectService.listSubjectInfo(verType, subType);
            if (CollectionUtils.isEmpty(schoolInfoList)) {
                logger.info("抓取科目信息完成,0条");
                break;
            }
            logger.info("抓取科目信息完成, {}条", schoolInfoList.size());
        }
        CommonUtils.executeSuccess(resObj);
        return resObj;
    }

}
