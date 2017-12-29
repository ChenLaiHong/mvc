package utils;

import java.sql.*;
import java.util.Properties;

/**
 * Created by 赖红 on 2017/12/2.
 */
public class JdbcUtils {
    private static Properties config =new Properties();
    static {
        try {
            config.load(JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            Class.forName(config.getProperty("driver"));
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(config.getProperty("url"),config.getProperty("username"),config.getProperty("password"));
    }
    public  static void release(Connection conn, Statement st, ResultSet rs){
        if(rs!=null){
            try{
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            rs=null;
        }
        if(st!=null){
            try{
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            st=null;
        }
        if(conn !=null){
            try{
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public  static void release(Connection conn, Statement st){
        if(st!=null){
            try{
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            st=null;
        }
        if(conn !=null){
            try{
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
