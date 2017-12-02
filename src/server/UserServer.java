package server;

import bean.User;

/**
 * Created by 赖红 on 2017/12/2.
 */
public interface UserServer {
    User find(String name,String password);
}
