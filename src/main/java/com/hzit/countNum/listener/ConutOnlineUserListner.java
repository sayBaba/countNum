package com.hzit.countNum.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 统计在线人数监听器
 */
public class ConutOnlineUserListner implements HttpSessionListener {


    public static ConcurrentHashMap map = new ConcurrentHashMap();


    @Override
    public void sessionCreated(HttpSessionEvent se) {

        HttpSession session = se.getSession(); //获取sessoion

        String sessionId = session.getId();

        map.put(sessionId,session);

//     System.out.println("------session create-----");

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

        System.out.println("------session destroy-----");

        //退出登录的时候，从map中吧session移除
        HttpSession session = se.getSession(); //获取sessoion
        map.remove(session.getId());

    }
}
