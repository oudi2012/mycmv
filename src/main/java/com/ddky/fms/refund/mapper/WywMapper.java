package com.ddky.fms.refund.mapper;

import com.ddky.fms.refund.model.entry.ArticleInfo;
import com.ddky.fms.refund.model.entry.Category;
import com.ddky.fms.refund.model.entry.Dynasty;
import com.ddky.fms.refund.model.entry.Grade;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WywMapper {

    List<Grade> listGrade();

    void insertGrade(Grade grade);

    List<Dynasty> listDynasty();

    void insertDynasty(Dynasty dynasty);

    List<Category> listCategory();

    void insertCategory(Category category);

    List<ArticleInfo> listArticleInfo();

    int updateArticleInfo(ArticleInfo articleInfo);

    int updateArticleInfoList(@Param("list")List<ArticleInfo> articleInfoList);

    void insertArticleInfo(ArticleInfo articleInfo);

    void insertArticleInfoList(@Param("list")List<ArticleInfo> articleInfoList);

}
