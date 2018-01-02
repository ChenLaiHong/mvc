package dao;

import bean.User;
import exception.DaoException;
import utils.JdbcUtils;
import utils.QueryResult;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 赖红 on 2017/12/2.
 */
public class UserDaoImp implements UserDao {

    @Override
    public User find(String name, String password) {
        Connection conn=null;
        PreparedStatement st=null;
        ResultSet rs=null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from user where uname = ? AND password=?";
            st = conn.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, password);
            rs = st.executeQuery();
            if (rs.next()) {
                User u = new User();
                u.setUname(rs.getString("uname"));
                u.setPassword(rs.getString("password"));
                u.setUid(rs.getInt("uid"));
                u.setMajor(rs.getString("major"));
                u.setSex(rs.getString("sex"));
                u.setPreferences(rs.getString("preferences"));
                return u;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn, st, rs);
        }
        return null;
    }

    @Override
    public QueryResult pageQuery(int startindex, int pagesize) {
        Connection conn= null;
        PreparedStatement st = null;
        ResultSet rs = null;
        QueryResult queryResult = new QueryResult();
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from user limit ?,?";
            st= conn.prepareStatement(sql);
            st.setInt(1,startindex);
            st.setInt(2,pagesize);
            rs=st.executeQuery();
            List list = new ArrayList();
            while (rs.next()){
                User user=new User();
                user.setUid(rs.getInt("uid"));
                user.setUname(rs.getString("uname"));
                user.setMajor(rs.getString("major"));
                user.setEmail(rs.getString("email"));
                user.setSex(rs.getString("sex"));
                user.setPreferences(rs.getString("preferences"));
                user.setOthers(rs.getString("others"));
                list.add(user);
            }
            queryResult.setList(list);
            sql = "SELECT COUNT(*) FROM USER ";
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
    public void deleteUser(int uid) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtils.getConnection();
            //根据id删除
            String sql = "delete from USER where uid = ?";
            st = conn.prepareStatement(sql);
            st.setInt(1, uid);
            st.executeUpdate();
        }catch(Exception e){
            throw new DaoException();
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
    }

    @Override
    public User findUser(int uid) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtils.getConnection();
            String sql = "select * from user where uid=?";
            st = conn.prepareStatement(sql);
            st.setInt(1,uid);
           rs= st.executeQuery();
            if(rs.next()){
                User user = new User();
                user.setUid(rs.getInt("uid"));
                user.setMajor(rs.getString("major"));
                user.setEmail(rs.getString("email"));
                user.setOthers(rs.getString("others"));
                user.setPreferences(rs.getString("preferences"));
                user.setUname(rs.getString("uname"));
                user.setSex(rs.getString("sex"));
                user.setPassword(rs.getString("password"));
                user.setPassword2(rs.getString("password2"));
                return user;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.release(conn, st, rs);
        }
        return null;
    }

    @Override
    public void update(User user) {
        Connection conn=null;
        PreparedStatement pre=null;
        ResultSet rs=null;
        try{
            conn = JdbcUtils.getConnection();
          //  String sql="update user set email=?,sex=?,major=?,preferences=?,others=? where uid=?";
            String sql="update user set email=?,sex=?,preferences=?,others=?,password=?,password2=?,uname=? where uid=?";
            pre=conn.prepareStatement(sql);
            pre.setString(1,user.getEmail());
            pre.setString(2,user.getSex());
            pre.setString(3,user.getPreferences());
            pre.setString(4,user.getOthers());
            pre.setString(5,user.getPassword());
            pre.setString(6,user.getPassword2());
            pre.setString(7,user.getUname());
            pre.setInt(8,user.getUid());
            pre.executeUpdate();

        } catch (Exception e) {
            throw new DaoException();
        }finally {
            JdbcUtils.release(conn,pre,rs);
        }
    }

    @Override
    public QueryResult pageQueryLike(int startindex, int pagesize, String query) {
        Connection conn= null;
        PreparedStatement st = null;
        ResultSet rs = null;
        QueryResult queryResult = new QueryResult();
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from user WHERE major LIKE "+"'%"+query+"%' limit ?,? ";
            st= conn.prepareStatement(sql);
            st.setInt(1,startindex);
            st.setInt(2,pagesize);
            rs=st.executeQuery();
            List list = new ArrayList();
            while (rs.next()){
                User user=new User();
                user.setUid(rs.getInt("uid"));
                user.setUname(rs.getString("uname"));
                user.setMajor(rs.getString("major"));
                user.setEmail(rs.getString("email"));
                user.setSex(rs.getString("sex"));
                user.setPreferences(rs.getString("preferences"));
                user.setOthers(rs.getString("others"));
                list.add(user);
            }
            queryResult.setList(list);
            // "select * from student where name like" + "'%" + name
          //  + "%'" + "or address like " + "'%" + name + "%'"
            sql = "SELECT COUNT(*) FROM USER WHERE major LIKE "+"'%"+query+"%'";
            st = conn.prepareStatement(sql);
         //   st.setString(1,"%"+query+"%");
            rs = st.executeQuery();
            if(rs.next()){
                queryResult.setTotalrecord(rs.getInt(1));
                System.out.print("总记录数："+queryResult.getTotalrecord());
            }
            return queryResult;
        } catch (Exception e) {
            throw new DaoException(e);
        }finally {
            JdbcUtils.release(conn,st,rs);
        }
    }

    @Override
    public User updateSelf(int id) {
        return null;
    }

}
