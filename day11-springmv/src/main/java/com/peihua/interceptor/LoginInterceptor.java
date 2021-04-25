package com.peihua.interceptor;

import com.peihua.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    /*前置处理*/
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        /*拿到用户信息*/
        User user = (User) session.getAttribute("user");
        if(user == null){//为空： 不放行
            request.setAttribute("erroyy","还没有登录");
            request.setAttribute("loginerror","请先登录");
            request.getRequestDispatcher("index.jsp").forward(request,response);
            return false;
        }
        return true;
       /* if (user != null){
            return true;
        }else {
            request.getRequestDispatcher("index.jsp").forward(request,response);
            return false;
        }*/
    }
}
