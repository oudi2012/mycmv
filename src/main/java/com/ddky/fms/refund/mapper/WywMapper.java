package com.ddky.fms.refund.mapper;

import com.ddky.fms.refund.model.books.wyw.entry.ArticleInfo;
import com.ddky.fms.refund.model.books.wyw.entry.Category;
import com.ddky.fms.refund.model.books.wyw.entry.Dynasty;
import com.ddky.fms.refund.model.students.entry.GradeInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/***
 * @author oudi
 */
public interface WywMapper {

    /***
     * 获取年级列表
     * @return List
     */
    List<GradeInfo> listGrade();

    /***
     * 添加年级
     * @param gradeInfo
     */
    void insertGrade(GradeInfo gradeInfo);

    /***
     * 朝代列表
     * @return
     */
    List<Dynasty> listDynasty();

    /***
     * 添加朝代
     * @param dynasty
     */
    void insertDynasty(Dynasty dynasty);

    /***
     * 文言类别
     * @return
     */
    List<Category> listCategory();

    /***
     * 添加文言类型
     * @param category
     */
    void insertCategory(Category category);

    /***
     * 文言文列表
     * @return
     */
    List<ArticleInfo> listArticleInfo();

    /***
     * 文言文更新
     * @param articleInfo
     * @return
     */
    int updateArticleInfo(ArticleInfo articleInfo);

    /***
     * 批量更新文言文
     * @param articleInfoList
     * @return
     */
    int batchUpdateArticleInfo(@Param("list")List<ArticleInfo> articleInfoList);

    /***
     * 添加文言文
     * @param articleInfo
     */
    void insertArticleInfo(ArticleInfo articleInfo);

    /**
     * 批量添加文言文
     * @param articleInfoList
     */
    void batchInsertArticleInfo(@Param("list")List<ArticleInfo> articleInfoList);

}
