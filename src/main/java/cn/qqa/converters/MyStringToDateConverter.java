package cn.qqa.converters;


import javafx.scene.input.DataFormat;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 1.定义明确源类型与目标类型
 * 2.在Convert方法中自定义类型转换的实现
 * 3.在springmvc中配置自定义类型转换器
 *     <!--配置自定义类型转换器-->
 *     <bean class="org.springframework.context.support.ConversionServiceFactoryBean" id="conversionService">
 *         <property name="converters">
 *             <set>
 *                 <bean class="cn.qqa.converters.MyStringToDateConverter"></bean>
 *             </set>
 *         </property>
 *     </bean>
 * 4.
 *  <!--注解驱动底层会用最新的实现类处理 -->
 *  <mvc:annotation-driven conversion-service="conversionService"/>
 */
public class MyStringToDateConverter implements Converter<String, Date> {
    public Date convert(String s) {
        if (!StringUtils.isEmpty(s)){
            try {
                if(s.split("-").length==3){
                    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                    return df.parse(s);
                }
                else if(s.split("/").length==3){
                    DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
                    return df.parse(s);
                }else{
                    throw new RuntimeException("日期转换错误"+s);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
