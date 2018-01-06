package dao;

import bean.Article;
import bean.Life;
import bean.User;
import exception.DaoException;
import utils.JdbcUtils;
import utils.QueryResult;
import utils.Time;

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
            pre1.setString(3, Time.getTime());
            pre1.setString(4,article1.getAuthor());
            pre1.setInt(5,article1.getTypeId());
            pre1.setInt(6,0);
            pre1.setInt(7,0);
            pre1.executeUpdate();
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

    @Override
    public Article findById(int articleId) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtils.getConnection();
            String sql = "select * from article where articleId=?";
            st = conn.prepareStatement(sql);
            st.setInt(1,articleId);
            rs= st.executeQuery();
            if(rs.next()){
               Article article = new Article();
               article.setArticleId(rs.getInt("articleId"));
               article.setArticleName(rs.getString("articleName"));
               article.setArticle(rs.getString("article"));
               article.setArticleDate(rs.getDate("articleDate"));
               article.setAuthor(rs.getString("author"));
               article.setCommentCount(rs.getInt("commentCount"));
               article.setReadCount(rs.getInt("readCount"));
               article.setTypeId(rs.getInt("typeId"));
                return article;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.release(conn, st, rs);
        }
        return null;
    }

    @Override
    public void updateReadNum(int readCount,int articleId) {
        Connection conn=null;
        PreparedStatement pre=null;
        ResultSet rs=null;
        try{
            conn = JdbcUtils.getConnection();
            String sql="update article set readCount=? where articleId=?";
            pre=conn.prepareStatement(sql);
            pre.setInt(1,readCount+1);
            pre.setInt(2,articleId);
            pre.executeUpdate();
        } catch (Exception e) {
            throw new DaoException();
        }finally {
            JdbcUtils.release(conn,pre,rs);
        }
    }

    @Override
    public void updateCommNum(int articleId, int commentCount) {
        Connection conn=null;
        PreparedStatement pre=null;
        ResultSet rs=null;
        try{
            conn = JdbcUtils.getConnection();
            String sql="update article set commentCount=? where articleId=?";
            pre=conn.prepareStatement(sql);
            pre.setInt(1,commentCount+1);
            pre.setInt(2,articleId);
            pre.executeUpdate();
        } catch (Exception e) {
            throw new DaoException();
        }finally {
            JdbcUtils.release(conn,pre,rs);
        }
    }
}
