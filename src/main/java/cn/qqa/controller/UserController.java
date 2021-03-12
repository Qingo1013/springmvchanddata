package cn.qqa.controller;

import cn.qqa.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.crypto.interfaces.PBEKey;
import javax.validation.Valid;
import java.util.*;

/**
 * 实现数据验证的步骤：
 * 1.在pom中加入hibernate-validator依赖
 * 2.一定要注意将相应jar包加入到WEB-INF/lib文件夹中
 * 3.在需要验证的JavaBean中加入注解，写在JavaBean的属性上面，可以设置message属性定制更友好错误提示
 * 4.在需要验证的处理方法的对应JavaBean参数上加上@Valid注解
 * 5.为了提高用户体验，在需要验证的处理方法的参数中加入BindingResult，代表自己处理错误
 *    ·基于原生html form表单实现方式
 *           1.将错误信息循环，放入map，再通过model存入request域中
 *           2.在jsp通过${errors.xxx}获取对应的错误信息
 *    ·基于spring form标签库的实现方式
 *           1.添加一个显示jsp的处理方法，一定要传入一个空的User到model中
 *           2.在jsp中导入spring-form标签库
 *           3.一定要在form标签上加上modelAtrribute
 *           4.加上对应的form标签都要以<form:开头
 */
@Controller
public class UserController {
    @PostMapping("/user")
    public String add(@Valid User user, BindingResult result, Model model){
        /**
         *  将错误信息取出来，输出到jsp页面
         */
        //判断当前是否出现了错误
        if(result.hasErrors()){
            //获取所有错误信息,包含了出现错误的属性以及错误信息
            List<FieldError> fieldErrors = result.getFieldErrors();
            //存放错误信息：key=出现错误的属性名，value=错误信息
            //这样就可以在.jsp中分别地取出错误信息${errors.xxx}
            Map<String,String> errors = new HashMap<String, String>();
            //循环转移到map中
            for(FieldError fieldError:fieldErrors){
                //fieldError.getField()是验证失败的属性名
                //fieldError.getDefaultMessage()是验证失败的错误信息
                errors.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            model.addAttribute("errors",errors);
            //如果验证失败，要重新转发到add界面
            return "users/add";
        }
        System.out.println(user);
        return "show";
    }


    @PostMapping("/form/user")
    public String springFormAdd(@Valid User user, BindingResult result, Model model){
/*        List<String> list = Arrays.asList("唱歌", "跳舞", "打游戏", "听音乐");
        model.addAttribute("list",list);*/
        /**
         *  将错误信息取出来，输出到jsp页面
         */
        //判断当前是否出现了错误
        if(result.hasErrors()){

            return "users/add";
        }
        System.out.println(user);
        return "show";
    }

    @GetMapping("/user/add")
    //自动将user放入request域
    public String addView(User user, Model model){
        //正常业务下，首先初始化该页面的数据
/*        List<String> list = Arrays.asList("唱歌", "跳舞", "打游戏", "听音乐");
        model.addAttribute("list",list);*/
        //key，value不同
/*        Map<String, String> map = new HashMap<String, String>();
        map.put("1","唱歌");
        map.put("2", "跳舞");
        map.put("3,", "打游戏");
        map.put("4",, "听音乐"));
        model.addAttribute("map",map);*/
        return "users/add";
    }

    @ModelAttribute
    public void initData(Model model){
        Map<String, String> map = new HashMap<String, String>();
        map.put("1","唱歌");
        map.put("2", "跳舞");
        map.put("3,", "打游戏");
        map.put("4", "听音乐");
        model.addAttribute("map",map);
    }

}
