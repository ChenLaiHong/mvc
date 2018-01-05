package service;

import bean.Article;
import utils.PageBean;
import utils.QueryInfo;

import java.util.List;

/**
 * Created by 赖红 on 2017/12/30.
 */
public interface ArticleService {
    void addArticle(Article article1);

    List getAll();

    PageBean pageQuery(QueryInfo info);

    Article findById(int articleId);

    void updateReadNum(int readCount,int articleId);
}
