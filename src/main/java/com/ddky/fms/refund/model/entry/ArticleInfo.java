package com.ddky.fms.refund.model.entry;

import lombok.Data;

import java.util.Date;

@Data
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
}
