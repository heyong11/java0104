package com.peihua.controller;

import com.peihua.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @RequestMapping("login")
    public String login(User user, Model model, HttpSession session){
        //模拟登录
        if ("admin".equals(user.getUsername()) && "admin".equals(user.getPassword())){
            System.out.println(user.getUsername()+"---"+user.getPassword());
            session.setAttribute("user",user);
            return "succes";
            ///WEB-INF/pages/
        }else {
            System.out.println(user.getUsername()+"---"+user.getPassword());
            model.addAttribute("erroy","用户名或者密码错误");
                return "forward:index.jsp";
        }

    }

}
