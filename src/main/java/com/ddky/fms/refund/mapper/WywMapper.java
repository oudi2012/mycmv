package com.ddky.fms.refund.mapper;

import com.ddky.fms.refund.model.entry.ArticleInfo;
import com.ddky.fms.refund.model.entry.Category;
import com.ddky.fms.refund.model.entry.Dynasty;
import com.ddky.fms.refund.model.entry.Grade;

import java.util.List;

public interface WywMapper {

    List<Grade> listGrade();

    void insertGrade(Grade grade);

    List<Dynasty> listDynasty();

    void insertDynasty(Dynasty dynasty);

    List<Category> listCategory();

    void insertCategory(Category category);

    void insertArticleInfo(ArticleInfo articleInfo);

}
