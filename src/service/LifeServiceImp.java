package service;

import bean.Life;
import dao.LifeDao;
import dao.LifeDaoImp;

import java.util.List;

/**
 * Created by 赖红 on 2018/1/4.
 */
public class LifeServiceImp implements LifeService {
    LifeDao lifeDao = new LifeDaoImp();
    @Override
    public List getAll() {
        return lifeDao.getAll();
    }

    @Override
    public void add(Life life) {
        lifeDao.add(life);
    }

    @Override
    public Life findLife(int lifeId) {
        return lifeDao.findLife(lifeId);
    }

    @Override
    public void updateLife(Life life) {
        lifeDao.updateLife(life);
    }

    @Override
    public void deleteLife(int lifeId) {
        lifeDao.deleteLife(lifeId);
    }
}
