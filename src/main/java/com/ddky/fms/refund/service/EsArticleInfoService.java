package com.ddky.fms.refund.service;


import com.ddky.fms.refund.model.index.entry.ArticleInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 接口关系
 * ElasticsearchRepository --> ElasticsearchCrudRepository --> PagingAndSortingRepository --> CrudRepository
 * @author a
 */
public interface EsArticleInfoService extends ElasticsearchRepository<ArticleInfo, String> {

    /***
     * 分页查询文章列表
     * @param author
     * @param pageable
     * @return
     */
    Page<ArticleInfo> pageByAuthor(String author, Pageable pageable);

    /***
     * 分页查询文章列表
     * @param title
     * @param pageable
     * @return
     */
    Page<ArticleInfo> pageByTitle(String title, Pageable pageable);

}
