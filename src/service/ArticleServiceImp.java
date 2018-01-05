package service;

import bean.Article;
import dao.ArticleDao;
import dao.ArticleDaoImp;
import utils.PageBean;
import utils.QueryInfo;
import utils.QueryResult;

import java.util.List;

/**
 * Created by 赖红 on 2017/12/30.
 */
public class ArticleServiceImp implements ArticleService {
    ArticleDao articleDao = new ArticleDaoImp();
    @Override
    public void addArticle(Article article1) {
        articleDao.addArticle(article1);
    }

    @Override
    public List getAll() {
        return articleDao.getAll();
    }

    @Override
    public PageBean pageQuery(QueryInfo info) {
        QueryResult queryResult = articleDao.pageQuery(info.getStartindex(),info.getPagesize());
        PageBean pageBean = new PageBean();
        pageBean.setCurrentpage(info.getCurrentpage());
        pageBean.setList(queryResult.getList());
        pageBean.setPagesize(info.getPagesize());
        pageBean.setTotalrecord(queryResult.getTotalrecord());
        return pageBean;
    }
}
