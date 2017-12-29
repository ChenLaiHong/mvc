package dao;

import bean.Type;

import java.util.List;

/**
 * Created by 赖红 on 2017/12/28.
 */
public interface TypeDao {
    void add_article(Type type);

    List getAll();

    Type findType(int typeId);

    void updateType(int typeId,String typeName);
}
