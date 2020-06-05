package com.ddky.fms.refund.utils;

import com.ddky.fms.refund.model.entry.ArticleInfo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HtmlUtils {

    /**
     * 格式化html
     */
    public static List<ArticleInfo> formatHtmlCont(String url) {
        List<ArticleInfo> articleInfoList = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url).get();
            Elements typeConts = document.getElementsByClass("typecont");
            for (Element typeCont: typeConts) {
                Elements spanList = typeCont.getElementsByTag("span");
                for (Element span: spanList) {
                    ArticleInfo articleInfo = new ArticleInfo();
                    Element aEl = span.child(0);
                    articleInfo.setHref(aEl.attr("href"));
                    articleInfo.setTitle(aEl.ownText());
                    if (!StringUtils.isEmpty(span.ownText())) {
                        articleInfo.setAuthor(span.ownText().replace("(","").replace(")",""));
                    }
                    articleInfoList.add(articleInfo);
                }
            }
        } catch (IOException io) {
            io.printStackTrace();
        }
        return articleInfoList;
    }

    //https://so.gushiwen.org/gushi/xishi.aspx
    //https://so.gushiwen.org/gushi/xiaoxue.aspx
    /*public static void main(String[] args)  {
        formatHtmlCont("https://so.gushiwen.org/gushi/xishi.aspx");
    }*/
}
