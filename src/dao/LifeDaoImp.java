package dao;

import bean.Life;
import bean.Type;
import utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 赖红 on 2018/1/4.
 */
public class LifeDaoImp implements LifeDao {
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
                life.setReleaseTime(res.getTime("releaseTime"));
                list.add(life);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }
}
