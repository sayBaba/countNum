package com.hzit.countNum.controller;

import com.hzit.countNum.listener.ConutOnlineUserListner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 登录接口
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            //判断用户名密码是否正确
//          null
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html charset=utf-8");
        String userName = req.getParameter("userName");
         String password = req.getParameter("password");

        if(("qwe".equals(userName)) && "123".equals(password)){
            //创建session
           HttpSession session = req.getSession();

           //获取到所有的session
            ConcurrentHashMap map =  ConutOnlineUserListner.map;

            int count  = map.size();

            resp.getWriter().println("在线用户数量：" + count);


//            Set set = map.entrySet();





        }else{

            resp.getWriter().println("用户名或者密码不正确");
        }


    }
}
