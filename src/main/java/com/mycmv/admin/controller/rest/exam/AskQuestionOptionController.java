package com.mycmv.admin.controller.rest.exam;

import com.alibaba.fastjson.JSON;
import com.mycmv.server.constants.LogConstants;
import com.mycmv.server.model.AbstractUser;
import com.mycmv.server.model.ResponseObject;
import com.mycmv.server.model.base.vo.LongIdListVo;
import com.mycmv.server.model.exam.entry.AskQuestionOption;
import com.mycmv.server.service.exam.AskQuestionOptionService;
import com.mycmv.server.utils.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collections;

/***
 * AskQuestionOption
 * @author a
 */
@RestController
@RequestMapping("exam/askQuestionOption/")
public class AskQuestionOptionController {

    private static final Logger logger = LoggerFactory.getLogger(LogConstants.ADM_LOG);

    @Resource
    private AskQuestionOptionService examService;

    @ResponseBody
    @GetMapping("pageList")
    public ResponseObject list(AbstractUser user, AskQuestionOption item, int pageIndex, int pageSize) {
        logger.info("用户 {} ，访问 {} , 参数：{}，{}，{}", user.getUserName(), "exam/askQuestionOption/pageList", JSON.toJSON(item), pageIndex, pageSize);
        ResponseObject resObj = new ResponseObject();
        CommonUtils.executeSuccess(resObj, examService.pageList(item, pageIndex, pageSize));
        return resObj;
    }

    @ResponseBody
    @PostMapping("create")
    public ResponseObject create(AbstractUser user, @RequestBody AskQuestionOption item) {
        logger.info("用户 {} ，访问 {} , 参数：{}", user.getUserName(), "exam/askQuestionOption/create", JSON.toJSON(item));
        ResponseObject resObj = new ResponseObject();
        examService.insert(item);
        CommonUtils.executeSuccess(resObj, item);
        return resObj;
    }

    @ResponseBody
    @GetMapping("findById")
    public ResponseObject findById(AbstractUser user, Integer id) {
        logger.info("用户 {} ，访问 {} , 参数：{}", user.getUserName(), "exam/askQuestionOption/findById", id);
        ResponseObject resObj = new ResponseObject();
        AskQuestionOption item = examService.findById(id);
        CommonUtils.executeSuccess(resObj, item);
        return resObj;
    }

    @ResponseBody
    @PostMapping("edit")
    public ResponseObject edit(AbstractUser user, @RequestBody AskQuestionOption item) {
        logger.info("用户 {} ，访问 {} , 参数：{}", user.getUserName(), "exam/askQuestionOption/edit", JSON.toJSON(item));
        ResponseObject responseObject = new ResponseObject();
        examService.update(item);
        CommonUtils.executeSuccess(responseObject);
        return responseObject;
    }


    @ResponseBody
    @PostMapping("remove")
    public ResponseObject delete(AbstractUser user, @RequestBody LongIdListVo longIdListVo) {
        logger.info("用户 {} ，访问 {} , 参数：{}", user.getUserName(), "exam/askQuestionOption/remove", JSON.toJSON(longIdListVo));
        ResponseObject resObj = new ResponseObject();
        if (CollectionUtils.isEmpty(longIdListVo.getIds())) {
            longIdListVo.setIds(Collections.singletonList(longIdListVo.getId()));
        }
        CommonUtils.executeSuccess(resObj, examService.delete(longIdListVo.getIds()));
        return resObj;
    }

}
