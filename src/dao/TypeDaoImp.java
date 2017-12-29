package dao;

import bean.Type;
import bean.User;
import exception.DaoException;
import utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 赖红 on 2017/12/28.
 */
public class TypeDaoImp implements TypeDao {
    @Override
    public void add_article(Type type) {

        Connection conn = null;
        PreparedStatement pre = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into type (typeName,articleCount) values(?,?)";
            pre = conn.prepareStatement(sql);
            pre.setString(1, type.getTypeName());
            pre.setInt(2, type.getArticleCount());
            pre.executeUpdate();
            System.out.print("进来了。。。。。");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn, pre);
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
            String sql = "select * from type";
            pre = conn.prepareStatement(sql);
            res=pre.executeQuery();
            while(res.next()){
                Type type = new Type();
                type.setTypeId(res.getInt("typeId"));
                type.setTypeName(res.getString("typeName"));
                type.setArticleCount(res.getInt("articleCount"));
                list.add(type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }

    @Override
    public Type findType(int typeId) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtils.getConnection();
            String sql = "select * from type where typeId=?";
            st = conn.prepareStatement(sql);
            st.setInt(1,typeId);
            rs= st.executeQuery();
            if(rs.next()){
                Type type = new Type();
                type.setTypeId(rs.getInt("typeId"));
                type.setTypeName(rs.getString("typeName"));
                type.setArticleCount(rs.getInt("articleCount"));
                return type;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.release(conn, st, rs);
        }
        return null;
    }

    @Override
    public void updateType(int typeId,String typeName) {
        Connection conn=null;
        PreparedStatement pre=null;
        ResultSet rs=null;
        try{
            conn = JdbcUtils.getConnection();
            String sql="update type set typeName=? where typeId=?";
            pre=conn.prepareStatement(sql);
            pre.setString(1,typeName);
            pre.setInt(2,typeId);
            pre.executeUpdate();
        } catch (Exception e) {
            throw new DaoException();
        }finally {
            JdbcUtils.release(conn,pre,rs);
        }
    }

}
