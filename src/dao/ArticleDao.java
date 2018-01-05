package dao;

import bean.Article;
import utils.QueryResult;

import java.util.List;

/**
 * Created by 赖红 on 2017/12/30.
 */
public interface ArticleDao {
    void addArticle(Article article1);

    List getAll();

    QueryResult pageQuery(int startindex, int pagesize);

    Article findById(int articleId);

    void updateReadNum(int readCount,int articleId);
}
