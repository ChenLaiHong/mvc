package dao;

import bean.Comment;

import java.util.List;

/**
 * Created by 赖红 on 2018/1/5.
 */
public interface CommentDao {
    List findAll(int articleId);

    void add(Comment comment);
}
