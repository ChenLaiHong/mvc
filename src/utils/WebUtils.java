package utils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by 赖红 on 2017/12/2.
 */
public class WebUtils {
    public static <T> T request2Bean(HttpServletRequest request, Class<T> beanClass){
        try {
            /**创建封装数据的bean**/
            T bean = beanClass.newInstance();

            Map map = request.getParameterMap();
            ConvertUtils.register(new Converter(){
                public Object convert(Class type, Object value) {//覆写接口中的方法。
                    if(value == null){ //判断传入的值是否为空。
                        return null;
                    }
                    String str = (String)value;
                    if(str.trim().equals("")){
                        return null;
                    }
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置储存时的日期格式
                    try {
                        return df.parse(str); //格式化时可能发生异常，不能抛出比父类更多的异常。
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                }
            }, Date.class);
            BeanUtils.populate(bean, map);
            return bean;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
