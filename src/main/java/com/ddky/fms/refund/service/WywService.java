package com.ddky.fms.refund.service;

import com.ddky.fms.refund.mapper.userlogs.WywMapper;
import com.ddky.fms.refund.model.books.wyw.entry.ArticleInfo;
import com.ddky.fms.refund.model.books.wyw.entry.Category;
import com.ddky.fms.refund.model.books.wyw.entry.Dynasty;
import com.ddky.fms.refund.model.students.entry.GradeInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 * @author oudi
 */
@Service("wywService")
public class WywService {

    @Autowired
    private WywMapper wywMapper;

    public List<GradeInfo> listGrade() {
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

    public void batchInsertArticleInfo(List<ArticleInfo> articleInfoList) {
        wywMapper.batchInsertArticleInfo(articleInfoList);
    }

    public void insertGrade(GradeInfo gradeInfo) {
        wywMapper.insertGrade(gradeInfo);
    }

    public void insertDynasty(Dynasty dynasty) {
        wywMapper.insertDynasty(dynasty);
    }

    public void insertCategory(Category category) {
        wywMapper.insertCategory(category);
    }

    public PageInfo<ArticleInfo> listArticleInfo(int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<ArticleInfo> articleInfoList = wywMapper.listArticleInfo();
        return new PageInfo<>(articleInfoList);
    }

    public int updateArticleInfo(ArticleInfo articleInfo) {
        return wywMapper.updateArticleInfo(articleInfo);
    }

    public int batchUpdateArticleInfo(List<ArticleInfo> articleInfoList) {
        return wywMapper.batchUpdateArticleInfo(articleInfoList);
    }

}
