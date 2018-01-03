package dao;

import bean.Article;
import utils.JdbcUtils;

import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
}
