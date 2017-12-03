package service;

import bean.User;
import utils.PageBean;
import utils.QueryInfo;

/**
 * Created by 赖红 on 2017/12/2.
 */
public interface UserService {
    User find(String name,String password);
    PageBean pageQuery(QueryInfo queryInfo);

    void deleteUser(int uid);

    User findUser(int uid);
}
