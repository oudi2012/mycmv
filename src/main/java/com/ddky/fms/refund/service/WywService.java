package com.ddky.fms.refund.service;

import com.ddky.fms.refund.mapper.WywMapper;
import com.ddky.fms.refund.model.entry.ArticleInfo;
import com.ddky.fms.refund.model.entry.Category;
import com.ddky.fms.refund.model.entry.Dynasty;
import com.ddky.fms.refund.model.entry.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("wywService")
public class WywService {

    @Autowired
    private WywMapper wywMapper;

    public List<Grade> listGrade() {
        return wywMapper.listGrade();
    }

    public List<Dynasty> listDynasty() {
        return wywMapper.listDynasty();
    }

    public List<Category> listCategory() {
        return wywMapper.listCategory();
    }

    public void insertArticleInfo(ArticleInfo articleInfo) {
        wywMapper.insertArticleInfo(articleInfo);
    }

    public void insertArticleInfoList(List<ArticleInfo> articleInfoList) {
        wywMapper.insertArticleInfoList(articleInfoList);
    }

    public void insertGrade(Grade grade) {
        wywMapper.insertGrade(grade);
    }

    public void insertDynasty(Dynasty dynasty) {
        wywMapper.insertDynasty(dynasty);
    }

    public void insertCategory(Category category) {
        wywMapper.insertCategory(category);
    }

}
