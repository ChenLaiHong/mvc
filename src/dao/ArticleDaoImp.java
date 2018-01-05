package dao;

import bean.Article;
import bean.Life;
import bean.User;
import exception.DaoException;
import utils.JdbcUtils;
import utils.QueryResult;

import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 赖红 on 2017/12/30.
 */
public class ArticleDaoImp implements ArticleDao {
    Date date = new Date();		//获取日期对象
    SimpleDateFormat textData = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	//设置日期对象的格式
    String today = (String)textData.format(date);	//格式化日期对象

    @Override
    public void addArticle(Article article1) {
        Connection conn = null;
        PreparedStatement pre1 = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into article (articleName,article,articleDate,author,typeId,commentCount,readCount) values(?,?,?,?,?,?,?)";
            pre1 = conn.prepareStatement(sql);
            pre1.setString(1, article1.getArticleName());
            pre1.setString(2, article1.getArticle());
            pre1.setString(3,today);
            pre1.setString(4,article1.getAuthor());
            pre1.setInt(5,article1.getTypeId());
            pre1.setInt(6,0);
            pre1.setInt(7,0);
            pre1.executeUpdate();

            System.out.print("进来了。。。。。");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn,pre1);
        }
    }

    @Override
    public List getAll() {
        List list = new ArrayList();
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet res = null;
        try{
            conn = JdbcUtils.getConnection();
            String sql = "select * from article";
            pre = conn.prepareStatement(sql);
            res=pre.executeQuery();
            while(res.next()){
                Article article = new Article();
                article.setArticleId(res.getInt("articleId"));
                article.setArticleName(res.getString("articleName"));
                article.setArticle(res.getString("article"));
                article.setAuthor(res.getString("author"));
                article.setCommentCount(res.getInt("commentCount"));
                article.setReadCount(res.getInt("readCount"));
                article.setArticleDate(res.getDate("articleDate"));
                list.add(article);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }

    @Override
    public QueryResult pageQuery(int startindex, int pagesize) {
        Connection conn= null;
        PreparedStatement st = null;
        ResultSet rs = null;
        QueryResult queryResult = new QueryResult();
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from article limit ?,?";
            st= conn.prepareStatement(sql);
            st.setInt(1,startindex);
            st.setInt(2,pagesize);
            rs=st.executeQuery();
            List list = new ArrayList();
            while (rs.next()){
                Article article = new Article();
                article.setArticleId(rs.getInt("articleId"));
                article.setArticleName(rs.getString("articleName"));
                article.setArticle(rs.getString("article"));
                article.setAuthor(rs.getString("author"));
                article.setCommentCount(rs.getInt("commentCount"));
                article.setReadCount(rs.getInt("readCount"));
                article.setArticleDate(rs.getDate("articleDate"));
                list.add(article);
            }
            queryResult.setList(list);
            sql = "SELECT COUNT(*) FROM ARTICLE ";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()){
                queryResult.setTotalrecord(rs.getInt(1));
            }
            return queryResult;
        } catch (Exception e) {
            throw new DaoException(e);
        }finally {
            JdbcUtils.release(conn,st,rs);
        }
    }
}
