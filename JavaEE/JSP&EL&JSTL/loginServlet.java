import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

//@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    public void init()
    {
        System.out.println("==============================");
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;character=utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("username=" + username + " ==password=" +password);
        UserDao dao=new User();
        boolean isSuccess=dao.login(username,password);
        if (!isSuccess) {
            Cookie[] cookies=req.getCookies();
            Cookie cookie=CookieUtil.findCookie(cookies,"last");
            if(cookie==null){
                Cookie c=new Cookie("last",System.currentTimeMillis()+"");
                c.setMaxAge(60*60*60);
                resp.addCookie(c);
                resp.getWriter().write("Welcome："+username);
                resp.setStatus(302);
                resp.setHeader("Location","/login_success.html");
            }else{
                long lastTime=Long.parseLong(cookie.getValue());
                resp.getWriter().write("Welcome:"+username+"  The last time you visited:："+new Date(lastTime));
                System.out.println("登陆成功，上次来访时间为："+new Date(lastTime));
                cookie.setValue(System.currentTimeMillis()+"");
                resp.addCookie(cookie);
            }
//            resp.setStatus(302);
//            resp.setHeader("Location", "/login_success.html");
        } else {
            resp.setStatus(302);
            resp.setHeader("Location", "/login_failed.html");
        }
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
