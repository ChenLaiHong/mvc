package dao;

import bean.Type;
import utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by 赖红 on 2017/12/28.
 */
public class TypeDaoImp implements TypeDao {
    @Override
    public void add_article(Type type) {
        Connection conn=null;
        PreparedStatement pre=null;
        ResultSet rs=null;
        try {
            conn = JdbcUtils.getConnection();
            String sql= "insert into type (typeName,articleCount) values(?,?)";
            pre=conn.prepareStatement(sql);
            pre.setString(1,type.getTypeName());
            pre.setInt(2,0);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.release(conn,pre,rs);
        }
    }
}
