package com.mycmv.admin.controller.rest.banner;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.mycmv.server.constants.LogConstants;
import com.mycmv.server.model.AbstractUser;
import com.mycmv.server.model.ResponseObject;
import com.mycmv.server.model.banner.entry.BannerCate;
import com.mycmv.server.model.banner.vo.BannerCateVo;
import com.mycmv.server.model.base.vo.LongIdListVo;
import com.mycmv.server.service.banner.BannerCateService;
import com.mycmv.server.utils.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/***
 * 书籍管理
 * @author a
 */
@RestController
@RequestMapping("bannerCate")
public class BannerCateController {

    private static final Logger logger = LoggerFactory.getLogger(LogConstants.ADM_LOG);

    @Resource
    private BannerCateService bannerCateService;

    @ResponseBody
    @GetMapping("pageList")
    public ResponseObject pageList(AbstractUser user, BannerCate item, int pageIndex, int pageSize) {
        String url = "bannerCate/pageList";
        logger.info("用户 {} ，访问 {} , 参数：{}，{}，{}", user.getUserName(), url, JSON.toJSON(item), pageIndex, pageSize);
        ResponseObject responseObject = new ResponseObject();
        PageInfo<BannerCateVo> pageInfo = bannerCateService.pageListVo(item, pageIndex, pageSize);
        logger.info("返回结果 list 条数：{}", pageInfo.getSize());
        CommonUtils.executeSuccess(responseObject, pageInfo);
        return responseObject;
    }


    @ResponseBody
    @GetMapping("list")
    public ResponseObject list(AbstractUser user, BannerCate bookItem) {
        String url = "bannerCate/list";
        logger.info("用户 {} ，访问 {} , 参数：{}", user.getUserName(), url, JSON.toJSON(bookItem));
        ResponseObject responseObject = new ResponseObject();
        List<BannerCate> list = bannerCateService.list(bookItem);
        if (CollectionUtils.isEmpty(list)) {
            logger.info("返回结果 list 条数：0");
        } else {
            logger.info("返回结果 list 条数：{}", list.size());
        }
        CommonUtils.executeSuccess(responseObject, list);
        return responseObject;
    }


    @ResponseBody
    @GetMapping("findById")
    public ResponseObject findById(AbstractUser user, int id) {
        String url = "bannerCate/findById";
        logger.info("用户 {} ，访问 {} , 参数：{}", user.getUserName(), url, id);
        ResponseObject responseObject = new ResponseObject();
        BannerCate tmp = bannerCateService.findById(id);
        if (ObjectUtils.isEmpty(tmp)) {
            logger.info("返回结果 null");
        } else {
            logger.info("返回结果 {}", JSON.toJSONString(tmp));
        }
        CommonUtils.executeSuccess(responseObject, tmp);
        return responseObject;
    }


    @ResponseBody
    @PostMapping("create")
    public ResponseObject create(AbstractUser user, @RequestBody BannerCate item) {
        String url = "bannerCate/create";
        logger.info("用户 {} ，访问 {} , 参数：{}", user.getUserName(), url, JSON.toJSON(item));
        ResponseObject responseObject = new ResponseObject();
        item.setUserId(user.getId());
        item.setOrderNo(0);
        bannerCateService.insert(item);
        CommonUtils.executeSuccess(responseObject);
        return responseObject;
    }


    @ResponseBody
    @PostMapping("edit")
    public ResponseObject edit(AbstractUser user, @RequestBody  BannerCate item) {
        String url = "bannerCate/create";
        logger.info("用户 {} ，访问 {} , 参数：{}", user.getUserName(), url, JSON.toJSON(item));
        ResponseObject responseObject = new ResponseObject();
        bannerCateService.update(item);
        CommonUtils.executeSuccess(responseObject);
        return responseObject;
    }


    @ResponseBody
    @PostMapping("remove")
    public ResponseObject delete(AbstractUser user, @RequestBody LongIdListVo longIdListVo) {
        logger.info("用户 {} ，访问 {} , 数量：{}", user.getUserName(), "bannerCate/remove", JSON.toJSON(longIdListVo));
        ResponseObject resObj = new ResponseObject();
        if (CollectionUtils.isEmpty(longIdListVo.getIds())) {
            longIdListVo.setIds(Collections.singletonList(longIdListVo.getId()));
        }
        CommonUtils.executeSuccess(resObj, bannerCateService.delete(longIdListVo.getIds()));
        return resObj;
    }
}
