package com.mycmv.admin.controller.rest.books;

import com.alibaba.fastjson.JSON;
import com.mycmv.server.constants.LogConstants;
import com.mycmv.server.model.AbstractUser;
import com.mycmv.server.model.ResponseObject;
import com.mycmv.server.model.base.vo.LongIdListVo;
import com.mycmv.server.model.books.entry.VersionType;
import com.mycmv.server.service.VersionTypeService;
import com.mycmv.server.utils.CommonUtils;

import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collections;

/***
 * 版本类型
 * @author a
 */
@RestController
@RequestMapping("version")
public class VersionTypeController {

    private static final Logger logger = LoggerFactory.getLogger(LogConstants.ADM_LOG);

    @Resource
    private VersionTypeService versionTypeService;

    @ResponseBody
    @GetMapping("pageList")
    public ResponseObject pageList(AbstractUser user, int pageIndex, int pageSize) {
        logger.info("用户 {} ，访问 {} ", user.getUserName(), "version/pageList");
        ResponseObject responseObject = new ResponseObject();
        PageInfo<VersionType> pageInfo = versionTypeService.pageList(pageIndex, pageSize);
        logger.info("返回结果 list 条数：{}", pageInfo.getSize());
        CommonUtils.executeSuccess(responseObject, pageInfo);
        return responseObject;
    }

    @ResponseBody
    @GetMapping("list")
    public ResponseObject list(AbstractUser user) {
        logger.info("用户 {} ，访问 {} ", user.getUserName(), "version/list");
        ResponseObject resObj = new ResponseObject();
        CommonUtils.executeSuccess(resObj, versionTypeService.list());
        return resObj;
    }

    @ResponseBody
    @PostMapping("create")
    public ResponseObject create(AbstractUser user, @RequestBody VersionType item) {
        logger.info("用户 {} ，访问 {} ", user.getUserName(), "version/create");
        ResponseObject resObj = new ResponseObject();
        versionTypeService.insert(item);
        CommonUtils.executeSuccess(resObj, item);
        return resObj;
    }

    @ResponseBody
    @GetMapping("findById")
    public ResponseObject findById(AbstractUser user, int id) {
        logger.info("用户 {} ，访问 {} ", user.getUserName(), "version/findById");
        ResponseObject responseObject = new ResponseObject();
        VersionType tmp = versionTypeService.findById(id);
        if (ObjectUtils.isEmpty(tmp)) {
            logger.info("返回结果 null");
        } else {
            logger.info("返回结果 {}", JSON.toJSONString(tmp));
        }
        CommonUtils.executeSuccess(responseObject, tmp);
        return responseObject;
    }

    @ResponseBody
    @PostMapping("edit")
    public ResponseObject edit(AbstractUser user, @RequestBody VersionType item) {
        logger.info("用户 {} ，访问 {} ", user.getUserName(), "version/edit");
        ResponseObject resObj = new ResponseObject();
        versionTypeService.update(item);
        CommonUtils.executeSuccess(resObj, item);
        return resObj;
    }

    @ResponseBody
    @PostMapping("remove")
    public ResponseObject delete(AbstractUser user, @RequestBody LongIdListVo longIdListVo) {
        logger.info("用户 {} ，访问 {} ", user.getUserName(), "version/remove");
        Preconditions.checkArgument(!ObjectUtils.isEmpty(longIdListVo), "删除参数不能为空");
        ResponseObject resObj = new ResponseObject();
        if (CollectionUtils.isEmpty(longIdListVo.getIds())) {
            longIdListVo.setIds(Collections.singletonList(longIdListVo.getId()));
        }
        CommonUtils.executeSuccess(resObj, versionTypeService.delete(longIdListVo.getIds()));
        return resObj;
    }
}
