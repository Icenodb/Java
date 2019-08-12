package com.stu.filter;

import com.stu.dao.UserDao;
import com.stu.dao.com.dao.impl.UserDaoImpl;
import com.stu.model.User;
import com.stu.utils.CookieUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @author Icenodb
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;character=utf-8");
        String uuid = req.getParameter("uuid");
        String psw = req.getParameter("psw");
        User user = new User(uuid,psw);
        boolean isSuccess = UserDaoImpl.login(user);
        if (isSuccess) {
            Cookie[] cookies = req.getCookies();
            Cookie cookie = CookieUtil.findCookie(cookies, uuid);
            if (cookie == null) {
                Cookie c = new Cookie(uuid, System.currentTimeMillis() + "");
                c.setMaxAge(60 * 60 * 60 * 60);
                resp.addCookie(c);
                resp.setStatus(302);
                resp.setHeader("Location", "/index.html");
            } else {
                long lastTime = Long.parseLong(cookie.getValue());
                resp.getWriter().write("Welcome:" + uuid + "  The last time you visited:：" + new Date(lastTime));
                System.out.println("登陆成功，上次来访时间为：" + new Date(lastTime));
                cookie.setValue(System.currentTimeMillis() + "");
                resp.addCookie(cookie);
            }
        }else{
            resp.setStatus(302);
            resp.setHeader("Location","/index.html");
        }

    }
}
