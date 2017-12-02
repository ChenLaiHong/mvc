package utils;

/**
 * Created by 赖红 on 2017/12/2.
 */
public class QueryInfo {
    private int currentpage = 1;
    private int pagesize = 5;
    private int startindex;

    public int getCurrentpage() {
        return currentpage;
    }

    public void setCurrentpage(int currentpage) {
        this.currentpage = currentpage;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public int getStartindex() {
        this.startindex=(this.currentpage-1)*this.pagesize;
        return startindex;
    }

    public void setStartindex(int startindex) {
        this.startindex = startindex;
    }
}
