package service;

import bean.Comment;
import dao.CommentDao;
import dao.CommentDaoImp;

import java.util.List;

/**
 * Created by 赖红 on 2018/1/5.
 */
public class CommentServiceImp implements CommentService {
    CommentDao commentDao = new CommentDaoImp();
    @Override
    public List findAll(int articleId) {
        return commentDao.findAll(articleId);
    }
}
