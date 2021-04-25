package com.peihua.controller;

import com.peihua.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
//@RequestMapping("hello")
@SessionAttributes("name")
public class UserController {
/*    @RequestMapping("test1")
    public String test1(){
        System.out.println("请求处理");
        return "main";
    }*/
    /*@RequestMapping("test1")
    public ModelAndView modelAndView (User user){
        System.out.println(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("main");
        return modelAndView;
    }
*/
@RequestMapping("test1")
public ModelAndView modelAndView (HttpSession session,User user){
    System.out.println(user);
    session.setAttribute("user",user);
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("main");
    return modelAndView;
}



}
