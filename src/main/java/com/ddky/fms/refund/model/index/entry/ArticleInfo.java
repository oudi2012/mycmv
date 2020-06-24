package com.ddky.fms.refund.model.index.entry;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

/**
 * @author whk
 */
@Data
@ToString
@NoArgsConstructor
@Document(indexName = "wyw", type = "doc")
public class ArticleInfo {
    @Id
    private String id;
    private String author;
    private int grade;
    private int dynasty;
    private int cateId;
    private int styleId;
    private String tags;
    private String title;
    private String cont;
    private Date createDate;
    private String href;
}
