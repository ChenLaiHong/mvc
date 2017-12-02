package utils;

import java.util.List;

/**
 * Created by 赖红 on 2017/12/2.
 */
public class PageBean {
    private List list;
    private int totalrecord;   //总记录
    private int pagesize;      //页数
    private int totalpage;    //总页数
    private int currentpage; //当前页
    private int previouspage;  //上一页
    private int nextpage;    //下一页
    private int[]pagebar;

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

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public int getTotalpage() {

        if(this.totalrecord%this.pagesize==0){
            this.totalpage = this.totalrecord/this.pagesize;
        }else{
            this.totalpage = this.totalrecord/this.pagesize+1;
        }
        return totalpage;
    }

    public void setTotalpage(int totalpage) {
        this.totalpage = totalpage;
    }

    public int getCurrentpage() {
        return currentpage;
    }

    public void setCurrentpage(int currentpage) {
        this.currentpage = currentpage;
    }

    public int getPreviouspage() {

        if(this.currentpage-1<1){
            this.previouspage = 1;
        }else{
            this.previouspage = this.currentpage-1;
        }
        return previouspage;
    }

    public void setPreviouspage(int previouspage) {
        this.previouspage = previouspage;
    }

    public int getNextpage() {
        if(this.currentpage+1>=this.totalpage){
            this.nextpage = this.totalpage;
        }else{
            this.nextpage = this.currentpage +1;
        }
        return nextpage;
    }

    public void setNextpage(int nextpage) {
        this.nextpage = nextpage;
    }
    public int[] getPagebar(){
        int startpage;
        int endpage;
        int pagebar[] = null;
        if(this.totalpage<=6){
            pagebar=new int[this.totalpage];
            startpage = 1;
            endpage = this.totalpage;
        }else {
            pagebar=new int[6];
            startpage=this.currentpage-2;
            endpage=this.currentpage+3;
            if(startpage<1){
                startpage=1;
                endpage=6;
            }if(endpage>this.totalpage){
                endpage=this.totalpage;
                startpage=this.totalpage-5;
            }
        }
        int index=0;
        for (int i=startpage;i<=endpage;i++){
            pagebar[index++] = i;
        }
        this.pagebar = pagebar;
        return this.pagebar;
    }
}
