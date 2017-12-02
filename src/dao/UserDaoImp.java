package dao;

import bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by 赖红 on 2017/12/2.
 */
public class UserDaoImp implements UserDao {

    @Override
    public User find(String name, String password) {
        Connection conn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        return null;
    }
}
