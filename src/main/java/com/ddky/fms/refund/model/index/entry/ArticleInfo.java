package com.ddky.fms.refund.model.index.entry;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @author whk
 */
@Data
@ToString
@NoArgsConstructor
public class ArticleInfo {
    private Long id;
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
