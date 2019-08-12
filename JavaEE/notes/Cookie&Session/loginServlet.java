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
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("username=" + username + " ==password=" +password);
        if (username.equals("admin")&&password.equals("123")) {
            Cookie[] cookies=req.getCookies();
            Cookie cookie=CookieUtil.findCookie(cookies,"last");
            if(cookie==null){
                Cookie c=new Cookie("last",System.currentTimeMillis()+"");
                c.setMaxAge(60*60*60);
                resp.addCookie(c);
                resp.getWriter().write("Welcome："+username);
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
}
