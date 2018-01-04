package utils;

/**
 * Created by 赖红 on 2017/12/2.
 */
public class MyEL {
    public static String sub(String str){
        //当信息字符数大于15时就只显示1到10的其他用省略号标示
        if(str.length()>25){
            return str.substring(0, 25) + "......";
        }
        //如果字符数小于15则一一列出来
        return str;
    }
}
