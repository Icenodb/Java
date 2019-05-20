import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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

//        PrintWriter pw = resp.getWriter();
//        "admin".equals(username) && "admin".equals(userpassword)
        if (username.equals("admin")&&password.equals("123")) {
//            Object obj=getServletContext().getAttribute("count");
//            int totalCount=0;
//            if(obj==null){
//                totalCount=(int)obj;
//            }
//            getServletContext().setAttribute("count",totalCount++);
//            System.out.println("登陆成功的次数是："+totalCount);
            resp.setStatus(302);
            resp.setHeader("Location", "/login_success.html");
        } else {
            resp.setStatus(302);
            resp.setHeader("Location", "/login_failed.html");
        }
    }
}
