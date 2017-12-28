package service;

import bean.Type;
import dao.TypeDao;
import dao.TypeDaoImp;

/**
 * Created by 赖红 on 2017/12/28.
 */
public class TypeServiceImp implements TypeService {
    private TypeDao typeDao= new TypeDaoImp();
    @Override
    public void add_article(Type type) {
        typeDao.add_article(type);
    }
}
