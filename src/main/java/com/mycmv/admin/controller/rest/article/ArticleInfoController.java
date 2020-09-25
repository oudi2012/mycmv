package com.mycmv.admin.controller.rest.article;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.mycmv.server.configuration.CurrentUser;
import com.mycmv.server.configuration.UserLoginToken;
import com.mycmv.server.constants.LogConstants;
import com.mycmv.server.model.AbstractUser;
import com.mycmv.server.model.ResponseObject;
import com.mycmv.server.model.article.entry.ArticleInfo;
import com.mycmv.server.model.article.vo.ArticleListVo;
import com.mycmv.server.model.base.vo.LongIdListVo;
import com.mycmv.server.service.article.ArticleInfoService;
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
 * 文章
 * @author a
 */
@RestController
@RequestMapping("article")
public class ArticleInfoController {

    private static final Logger logger = LoggerFactory.getLogger(LogConstants.ADM_LOG);

    @Resource
    private ArticleInfoService articleInfoService;

    @UserLoginToken
    @ResponseBody
    @GetMapping("pageList")
    public ResponseObject pageList(@CurrentUser AbstractUser user, ArticleInfo item, int pageIndex, int pageSize) {
        String url = "book/pageList";
        logger.info("用户 {} ，访问 {} , 参数：{}，{}，{}", user.getUserName(), url, JSON.toJSON(item), pageIndex, pageSize);
        ResponseObject responseObject = new ResponseObject();
        PageInfo<ArticleInfo> pageInfo = articleInfoService.pageList(item, pageIndex, pageSize);
        logger.info("返回结果 list 条数：{}", pageInfo.getSize());
        CommonUtils.executeSuccess(responseObject, pageInfo);
        return responseObject;
    }


    @UserLoginToken
    @ResponseBody
    @GetMapping("list")
    public ResponseObject list(@CurrentUser AbstractUser user, ArticleInfo item) {
        String url = "book/list";
        logger.info("用户 {} ，访问 {} , 参数：{}", user.getUserName(), url, JSON.toJSON(item));
        ResponseObject responseObject = new ResponseObject();
        List<ArticleInfo> list = articleInfoService.list(item);
        if (CollectionUtils.isEmpty(list)) {
            logger.info("返回结果 list 条数：0");
        } else {
            logger.info("返回结果 list 条数：{}", list.size());
        }
        CommonUtils.executeSuccess(responseObject, list);
        return responseObject;
    }


    @UserLoginToken
    @ResponseBody
    @GetMapping("findById")
    public ResponseObject findById(@CurrentUser AbstractUser user, int bookId) {
        String url = "book/findById";
        logger.info("用户 {} ，访问 {} , 参数：{}", user.getUserName(), url, bookId);
        ResponseObject responseObject = new ResponseObject();
        ArticleInfo tmp = articleInfoService.findById(bookId);
        if (ObjectUtils.isEmpty(tmp)) {
            logger.info("返回结果 null");
        } else {
            logger.info("返回结果 {}", JSON.toJSONString(tmp));
        }
        CommonUtils.executeSuccess(responseObject, tmp);
        return responseObject;
    }


    @UserLoginToken
    @ResponseBody
    @PostMapping("create")
    public ResponseObject create(@CurrentUser AbstractUser user, @RequestBody ArticleInfo item) {
        String url = "book/create";
        logger.info("用户 {} ，访问 {} , 参数：{}", user.getUserName(), url, JSON.toJSON(item));
        ResponseObject responseObject = new ResponseObject();
        articleInfoService.insert(item);
        CommonUtils.executeSuccess(responseObject);
        return responseObject;
    }


    @UserLoginToken
    @ResponseBody
    @PostMapping("edit")
    public ResponseObject edit(@CurrentUser AbstractUser user, @RequestBody  ArticleInfo item) {
        String url = "book/create";
        logger.info("用户 {} ，访问 {} , 参数：{}", user.getUserName(), url, JSON.toJSON(item));
        ResponseObject responseObject = new ResponseObject();
        articleInfoService.insert(item);
        CommonUtils.executeSuccess(responseObject);
        return responseObject;
    }


    @UserLoginToken
    @ResponseBody
    @PostMapping("batchCreate")
    public ResponseObject batchCreate(@CurrentUser AbstractUser user, @RequestBody ArticleListVo esArticleListVo) {
        String url = "book/batchCreate";
        logger.info("用户 {} ，访问 {} , 数量：{}", user.getUserName(), url, esArticleListVo.getArticleInfoList().size());
        ResponseObject responseObject = new ResponseObject();
        articleInfoService.batchInsert(esArticleListVo.getArticleInfoList());
        CommonUtils.executeSuccess(responseObject);
        return responseObject;
    }


    @UserLoginToken
    @ResponseBody
    @PostMapping("remove")
    public ResponseObject delete(@CurrentUser AbstractUser user, @RequestBody LongIdListVo longIdListVo) {
        logger.info("用户 {} ，访问 {} , 数量：{}", user.getUserName(), "book/remove", JSON.toJSON(longIdListVo));
        ResponseObject resObj = new ResponseObject();
        if (CollectionUtils.isEmpty(longIdListVo.getIds())) {
            longIdListVo.setIds(Collections.singletonList(longIdListVo.getId()));
        }
        CommonUtils.executeSuccess(resObj, articleInfoService.delete(longIdListVo.getIds()));
        return resObj;
    }
}
