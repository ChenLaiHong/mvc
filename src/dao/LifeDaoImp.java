package dao;

import bean.Life;
import bean.Type;
import exception.DaoException;
import utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 赖红 on 2018/1/4.
 */
public class LifeDaoImp implements LifeDao {
    Date date = new Date();		//获取日期对象
    SimpleDateFormat textData = new SimpleDateFormat("yyyy-MM-dd");	//设置日期对象的格式
    String today = (String)textData.format(date);	//格式化日期对象
    @Override
    public List getAll() {
        List list = new ArrayList();
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet res = null;
        try{
            conn = JdbcUtils.getConnection();
            String sql = "select * from life";
            pre = conn.prepareStatement(sql);
            res=pre.executeQuery();
            while(res.next()){
                Life life = new Life();
                life.setLifeId(res.getInt("lifeId"));
                life.setLifeName(res.getString("lifeName"));
                life.setLifeContent(res.getString("lifeContent"));
                life.setReadNum(res.getInt("readNum"));
                life.setReleaseTime(res.getDate("releaseTime"));
                list.add(life);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }

    @Override
    public void add(Life life) {
        Connection conn = null;
        PreparedStatement pre = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into life (lifeName,lifeContent,readNum,releaseTime) values(?,?,?,?)";
            pre = conn.prepareStatement(sql);
            pre.setString(1, life.getLifeName());
            pre.setString(2, life.getLifeContent());
            pre.setInt(3,0);
            pre.setString(4,today);
            pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn, pre);
        }
    }

    @Override
    public Life findLife(int lifeId) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtils.getConnection();
            String sql = "select * from life where lifeId=?";
            st = conn.prepareStatement(sql);
            st.setInt(1,lifeId);
            rs= st.executeQuery();
            if(rs.next()){
                Life life = new Life();
                life.setLifeId(rs.getInt("lifeId"));
                life.setLifeName(rs.getString("lifeName"));
                life.setLifeContent(rs.getString("lifeContent"));
                return life;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.release(conn, st, rs);
        }
        return null;
    }

    @Override
    public void updateLife(Life life) {
        Connection conn=null;
        PreparedStatement pre=null;
        ResultSet rs=null;
        try{
            conn = JdbcUtils.getConnection();
            String sql="update life set lifeName=?,lifeContent=?,releaseTime=? where lifeId=?";
            pre=conn.prepareStatement(sql);
            pre.setString(1,life.getLifeName());
            pre.setString(2,life.getLifeContent());
            pre.setString(3,today);
            pre.setInt(4,life.getLifeId());
            pre.executeUpdate();

        } catch (Exception e) {
            throw new DaoException();
        }finally {
            JdbcUtils.release(conn,pre,rs);
        }
    }

    @Override
    public void deleteLife(int lifeId) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtils.getConnection();
            //根据id删除
            String sql = "delete from life where lifeId = ?";
            st = conn.prepareStatement(sql);
            st.setInt(1,lifeId);
            st.executeUpdate();
        }catch(Exception e){
            throw new DaoException();
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
    }
}
