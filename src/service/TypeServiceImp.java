package service;

import bean.Type;
import dao.TypeDao;
import dao.TypeDaoImp;
import utils.PageBean;
import utils.QueryInfo;
import utils.QueryResult;

import java.util.List;

/**
 * Created by 赖红 on 2017/12/28.
 */
public class TypeServiceImp implements TypeService {
    private TypeDao typeDao= new TypeDaoImp();
    @Override
    public void add_article(Type type) {
        typeDao.add_article(type);
    }


    @Override
    public List getAll() {
       return typeDao.getAll();
    }

    @Override
    public Type findType(int typeId) {
        return typeDao.findType(typeId);
    }

    @Override
    public void updateType(int typeId,String typeName) {
        typeDao.updateType(typeId,typeName);
    }

    @Override
    public void deleteType(int typeId) {
        typeDao.deleteType(typeId);
    }
}
