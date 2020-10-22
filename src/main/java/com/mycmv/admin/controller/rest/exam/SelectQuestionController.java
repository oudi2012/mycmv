package com.mycmv.admin.controller.rest.exam;

import com.alibaba.fastjson.JSON;
import com.mycmv.server.constants.LogConstants;
import com.mycmv.server.model.AbstractUser;
import com.mycmv.server.model.ResponseObject;
import com.mycmv.server.model.base.vo.LongIdListVo;
import com.mycmv.server.model.exam.entry.SelectQuestion;
import com.mycmv.server.model.exam.vo.SelectQuestionVo;
import com.mycmv.server.service.exam.SelectQuestionOptionService;
import com.mycmv.server.service.exam.SelectQuestionService;
import com.mycmv.server.utils.CommonUtils;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collections;

/***
 * SelectQuestion
 * @author a
 */
@RestController
@RequestMapping("exam/selectQuestion/")
public class SelectQuestionController {

    private static final Logger logger = LoggerFactory.getLogger(LogConstants.ADM_LOG);

    @Resource
    private SelectQuestionService examService;
    @Resource
    private SelectQuestionOptionService questionOptionService;

    @ResponseBody
    @GetMapping("pageList")
    public ResponseObject list(AbstractUser user, SelectQuestion item, int pageIndex, int pageSize) {
        logger.info("用户 {} ，访问 {} , 参数：{}", user.getUserName(), "exam/selectQuestion/create", JSON.toJSON(item));
        ResponseObject resObj = new ResponseObject();
        PageInfo<SelectQuestion> selectQuestionPageInfo = examService.pageList(item, pageIndex, pageSize);
        if (!CollectionUtils.isEmpty(selectQuestionPageInfo.getList())) {
            PageInfo<SelectQuestionVo> selectQuestionVoPageInfo = new PageInfo<>();
            BeanUtils.copyProperties(selectQuestionPageInfo, selectQuestionVoPageInfo);
            selectQuestionVoPageInfo.setList(examService.listToVo(selectQuestionPageInfo.getList()));
            CommonUtils.executeSuccess(resObj, selectQuestionVoPageInfo);
        } else {
            CommonUtils.executeSuccess(resObj, selectQuestionPageInfo);
        }
        return resObj;
    }

    @ResponseBody
    @PostMapping("create")
    public ResponseObject create(AbstractUser user, @RequestBody SelectQuestionVo item) {
        logger.info("用户 {} ，访问 {} , 参数：{}", user.getUserName(), "exam/selectQuestion/create", JSON.toJSON(item));
        ResponseObject resObj = new ResponseObject();
        item.setCreatorId(user.getId());
        if (item.getMultiId() == null) {
            item.setMultiId(0L);
        }
        examService.insert(item);
        if (!CollectionUtils.isEmpty(item.getSelectQuestionOptionList())) {
            item.getSelectQuestionOptionList().forEach(optionItem -> {
                optionItem.setQuestionId(item.getId());
                optionItem.setState(1);
            });
            questionOptionService.batchInsert(item.getSelectQuestionOptionList());
        }
        CommonUtils.executeSuccess(resObj, item);
        return resObj;
    }

    @ResponseBody
    @GetMapping("findById")
    public ResponseObject findById(AbstractUser user, Integer examId) {
        logger.info("用户 {} ，访问 {} , 参数：{}", user.getUserName(), "exam/selectQuestion/findById", examId);
        ResponseObject resObj = new ResponseObject();
        SelectQuestion item = examService.findById(examId);
        if (!ObjectUtils.isEmpty(item)) {
            SelectQuestionVo selectQuestionVo = examService.itemToVo(item);
            CommonUtils.executeSuccess(resObj, selectQuestionVo);
        } else {
            CommonUtils.executeSuccess(resObj, item);
        }
        return resObj;
    }

    @ResponseBody
    @PostMapping("edit")
    public ResponseObject edit(AbstractUser user, @RequestBody SelectQuestionVo item) {
        logger.info("用户 {} ，访问 {} , 参数：{}", user.getUserName(), "exam/selectQuestion/edit", JSON.toJSON(item));
        ResponseObject responseObject = new ResponseObject();
        examService.update(item);
        questionOptionService.deleteByQuestionId(item.getId());
        if (!CollectionUtils.isEmpty(item.getSelectQuestionOptionList())) {
            item.getSelectQuestionOptionList().forEach(optionItem -> {
                optionItem.setQuestionId(item.getId());
                optionItem.setState(1);
            });
            questionOptionService.batchInsert(item.getSelectQuestionOptionList());
        }
        CommonUtils.executeSuccess(responseObject);
        return responseObject;
    }

    @ResponseBody
    @PostMapping("remove")
    public ResponseObject delete(AbstractUser user, @RequestBody LongIdListVo longIdListVo) {
        logger.info("用户 {} ，访问 {} , 参数：{}", user.getUserName(), "exam/selectQuestion/remove", JSON.toJSON(longIdListVo));
        ResponseObject resObj = new ResponseObject();
        if (CollectionUtils.isEmpty(longIdListVo.getIds())) {
            longIdListVo.setIds(Collections.singletonList(longIdListVo.getId()));
        }
        examService.delete(longIdListVo.getIds());
        longIdListVo.getIds().forEach(id -> {
            questionOptionService.deleteByQuestionId(id);
        });
        CommonUtils.executeSuccess(resObj);
        return resObj;
    }

}
