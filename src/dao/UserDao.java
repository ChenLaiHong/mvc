package dao;

import bean.User;
import utils.QueryResult;

/**
 * Created by 赖红 on 2017/12/2.
 */
public interface UserDao {
    User find(String name, String password);
    QueryResult pageQuery(int startindex, int pagesize);

    void deleteUser(int uid);

    User findUser(int uid);
}
