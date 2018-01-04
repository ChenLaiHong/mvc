package service;

import bean.Life;

import java.util.List;

/**
 * Created by 赖红 on 2018/1/4.
 */
public interface LifeService {
    List getAll();

    void add(Life life);

    Life findLife(int lifeId);

    void updateLife(Life life);

    void deleteLife(int lifeId);
}
