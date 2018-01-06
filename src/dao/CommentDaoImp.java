package dao;

import bean.Article;
import bean.Comment;
import utils.JdbcUtils;
import utils.Time;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 赖红 on 2018/1/5.
 */
public class CommentDaoImp implements CommentDao {
    @Override
    public List findAll(int articleId) {
        List list = new ArrayList();
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet res = null;
        try{
            conn = JdbcUtils.getConnection();
            String sql = "select * from comment where articleId=?";
            pre = conn.prepareStatement(sql);
            pre.setInt(1,articleId);
            res=pre.executeQuery();
            while(res.next()){
                Comment comment = new Comment();
                comment.setContent(res.getString("content"));
                comment.setAuthor(res.getString("author"));
                comment.setCommentDate(res.getDate("commentDate"));
                list.add(comment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }

    @Override
    public void add(Comment comment) {
        Connection conn = null;
        PreparedStatement pre1 = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into comment (content,commentDate,author,articleId) values(?,?,?,?)";
            pre1 = conn.prepareStatement(sql);
            pre1.setString(1, comment.getContent());
            pre1.setString(2, Time.getTime());
            pre1.setString(3, comment.getAuthor());
            pre1.setInt(4,comment.getArticleId());
            pre1.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn,pre1);
        }
    }
}
