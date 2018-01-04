package bean;

import java.util.Date;

/**
 * Created by 赖红 on 2018/1/4.
 */
public class Life {
    private int lifeId;
    private String lifeName;
    private String lifeContent;
    private int readNum;
    private Date releaseTime;

    public void setLifeId(int lifeId) {
        this.lifeId = lifeId;
    }

    public void setLifeName(String lifeName) {
        this.lifeName = lifeName;
    }

    public void setLifeContent(String lifeContent) {
        this.lifeContent = lifeContent;
    }

    public void setReadNum(int readNum) {
        this.readNum = readNum;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public int getLifeId() {
        return lifeId;
    }

    public String getLifeName() {
        return lifeName;
    }

    public String getLifeContent() {
        return lifeContent;
    }

    public int getReadNum() {
        return readNum;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }
}
