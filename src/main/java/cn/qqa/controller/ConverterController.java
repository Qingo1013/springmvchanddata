package cn.qqa.controller;

import cn.qqa.entity.User;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * springmvc底层已经做好了类型转换
 * request 将String（传入的都是String）转为需要的类型
 *
 */
@Controller
@RequestMapping("/converter")
public class ConverterController {

    @RequestMapping("/test")
    public String converter01(User user){
        System.out.println(user);
        System.out.println(user.getHobbies().length);
        return "show";
    }

}
