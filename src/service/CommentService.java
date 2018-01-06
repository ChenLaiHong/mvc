package service;

import bean.Comment;

import java.util.List;

/**
 * Created by 赖红 on 2018/1/5.
 */
public interface CommentService {
    List findAll(int articleId);

    void add(Comment comment);
}
