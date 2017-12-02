package utils;

import java.util.List;

/**
 * Created by 赖红 on 2017/12/2.
 */
public class QueryResult {
    private List list;
    private int totalrecord;

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public int getTotalrecord() {
        return totalrecord;
    }

    public void setTotalrecord(int totalrecord) {
        this.totalrecord = totalrecord;
    }
}
