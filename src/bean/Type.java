package bean;

/**
 * Created by 赖红 on 2017/12/26.
 */
public class Type {
    private int typeId;
    private String typeName;
    private int articleCount;

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public void setArticleCount(int articleCount) {
        this.articleCount = articleCount;
    }

    public int getTypeId() {
        return typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public int getArticleCount() {
        return articleCount;
    }
}
