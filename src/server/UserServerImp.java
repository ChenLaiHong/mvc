package server;

import bean.User;
import dao.UserDao;
import dao.UserDaoImp;

/**
 * Created by 赖红 on 2017/12/2.
 */
public class UserServerImp implements UserServer {
    private UserDao userDao = new UserDaoImp();
    @Override
    public User find(String name, String password) {
        return userDao.find(name,password);
    }
}
