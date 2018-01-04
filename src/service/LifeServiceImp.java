package service;

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
}
