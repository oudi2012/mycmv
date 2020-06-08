package com.ddky.fms.refund.controller.rest;


import com.ddky.fms.refund.model.wyw.entry.ArticleInfo;
import com.ddky.fms.refund.model.wyw.entry.Category;
import com.ddky.fms.refund.service.WywService;
import com.ddky.fms.refund.utils.HtmlUtils;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/***
 * wyw
 * @author a
 */
@Controller
@RequestMapping("wyw")
public class WywController {

    private static final Logger logger = LoggerFactory.getLogger(WywController.class);

    private static final String preHref = "https://so.gushiwen.org/";
    private static final String preHref2 = "https://so.gushiwen.org";

    @Autowired
    private WywService wywService;

    /**
     * 根据分类获取古文列表
     * @return
     */
    @GetMapping("loadArticleInfoList")
    @ResponseBody
    public String loadArticleInfoList() {
        logger.info("获取古文标题列表开始");
        List<Category> categoryList = wywService.listCategory();
        categoryList.parallelStream().forEach(category -> {
            logger.info(preHref + category.getHref());
            List<ArticleInfo> articleInfoList = HtmlUtils.formatHtmlList(preHref + category.getHref());
            logger.info("articleInfoList size = {}", articleInfoList.size());
            wywService.insertArticleInfoList(articleInfoList);
            logger.info("articleInfoList insert size = {}", articleInfoList.size());
        });
        return "success";
    }

    /**
     * 获取古文详细
     * @return
     */
    @GetMapping("loadArticleInfoDetail")
    @ResponseBody
    public String loadArticleInfoDetail() {
        logger.info("获取古文详细开始");
        PageInfo<ArticleInfo> articleInfoPageInfo = wywService.listArticleInfo(1, 100);
        int pageTotal = articleInfoPageInfo.getPages();
        for (int pageIndex = 1; pageIndex <= pageTotal; pageIndex++) {
            articleInfoPageInfo = wywService.listArticleInfo(pageIndex, 100);
            logger.info("获取古文详细 执行第 {} 页", pageIndex);
            articleInfoPageInfo.getList().parallelStream().forEach(articleInfo -> {
                if (!articleInfo.getHref().contains("http")) {
                    articleInfo.setHref(preHref2 + articleInfo.getHref());
                }
                logger.info("获取古文详细 地址：{}", articleInfo.getHref());
                HtmlUtils.formatHtmlCont(articleInfo);
                wywService.updateArticleInfo(articleInfo);
            });
        }
        return "success";
    }



}
