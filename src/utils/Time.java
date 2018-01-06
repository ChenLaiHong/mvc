package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 赖红 on 2018/1/6.
 */
public class Time {
    public static String getTime(){
        Date date = new Date();		//获取日期对象
        SimpleDateFormat textData = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	//设置日期对象的格式
        String today = (String)textData.format(date);	//格式化日期对象
        return today;
    }
}
