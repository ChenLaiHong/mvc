package service;

import bean.User;
import dao.UserDao;
import dao.UserDaoImp;
import utils.PageBean;
import utils.QueryInfo;
import utils.QueryResult;

/**
 * Created by 赖红 on 2017/12/2.
 */
public class UserServiceImp implements UserService {
    private UserDao userDao = new UserDaoImp();
    @Override
    public User find(String name, String password) {
        return userDao.find(name,password);
    }

    @Override
    public PageBean pageQuery(QueryInfo queryInfo) {
        QueryResult queryResult = userDao.pageQuery(queryInfo.getStartindex(),queryInfo.getPagesize());
        PageBean pageBean = new PageBean();
        pageBean.setCurrentpage(queryInfo.getCurrentpage());
        pageBean.setList(queryResult.getList());
        pageBean.setPagesize(queryInfo.getPagesize());
        pageBean.setTotalrecord(queryResult.getTotalrecord());
        return pageBean;
    }

    @Override
    public void deleteUser(int uid) {
        userDao.deleteUser(uid);
    }

    @Override
    public User findUser(int uid) {
        return userDao.findUser(uid);
    }

    @Override
    public void updateUser(User user) {
        userDao.update(user);
    }

    @Override
    public PageBean pageQueryLike(QueryInfo info, String query) {
        QueryResult queryResult = userDao.pageQueryLike(info.getStartindex(),info.getPagesize(),query);
        PageBean pageBean = new PageBean();
        pageBean.setCurrentpage(info.getCurrentpage());
        pageBean.setList(queryResult.getList());
        pageBean.setPagesize(info.getPagesize());
        pageBean.setTotalrecord(queryResult.getTotalrecord());
        return pageBean;
    }

    @Override
    public User updateSelf(int id) {
        return userDao.updateSelf(id);
    }


}
