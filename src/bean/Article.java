package bean;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 赖红 on 2017/12/26.
 */
public class Article {
    private int articleId;
    private String articleName;
    private String article;
    private String author;
    private Date articleDate;
    private int typeId;
    private int commentCount;
    private int readCount;
    private List<String> imagesList = new LinkedList<String>();

    public void setImagesList(List<String> imagesList) {
        this.imagesList = imagesList;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setArticleDate(Date articleDate) {
        this.articleDate = articleDate;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getArticleId() {
        return articleId;
    }

    public String getArticleName() {
        return articleName;
    }

    public String getArticle() {
        return article;
    }

    public String getAuthor() {
        return author;
    }

    public Date getArticleDate() {
        return articleDate;
    }

    public int getTypeId() {
        return typeId;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public int getReadCount() {
        return readCount;
    }

    public List<String> getImagesList() {
        return imagesList;
    }
}
