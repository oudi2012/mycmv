package com.ddky.fms.refund.controller.rest;


import com.ddky.fms.refund.model.entry.ArticleInfo;
import com.ddky.fms.refund.model.entry.Category;
import com.ddky.fms.refund.service.WywService;
import com.ddky.fms.refund.utils.HtmlUtils;
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

    @Autowired
    private WywService wywService;

    @GetMapping("loadArticleInfoList")
    @ResponseBody
    public String loadArticleInfoList() {
        logger.info("获取古文标题列表开始");
        List<Category> categoryList = wywService.listCategory();
        categoryList.parallelStream().forEach(category -> {
            logger.info(preHref + category.getHref());
            List<ArticleInfo> articleInfoList = HtmlUtils.formatHtmlCont(preHref + category.getHref());
            logger.info("articleInfoList size = {}", articleInfoList.size());
            wywService.insertArticleInfoList(articleInfoList);
            logger.info("articleInfoList insert size = {}", articleInfoList.size());
        });
        return "success";
    }

}
