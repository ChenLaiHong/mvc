package service;

import bean.Article;
import dao.ArticleDao;
import dao.ArticleDaoImp;

/**
 * Created by 赖红 on 2017/12/30.
 */
public class ArticleServiceImp implements ArticleService {
    ArticleDao articleDao = new ArticleDaoImp();
    @Override
    public void addArticle(Article article1) {
        articleDao.addArticle(article1);
    }
}
