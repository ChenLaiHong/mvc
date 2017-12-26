package bean;

import java.util.Date;

/**
 * Created by 赖红 on 2017/12/26.
 */
public class Comment {
    private int cid;
    private String content;
    private String author;
    private Date commentDate;
    private int articleId;

    public void setCid(int cid) {
        this.cid = cid;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getCid() {
        return cid;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public int getArticleId() {
        return articleId;
    }
}
