import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
        import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

@WebServlet("/main")
public class main extends HttpServlet{
    private String message;
    @Override
    public void init() throws ServletException{
        message="Hello World!This message is from loginServlet";
    }
    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        out.println("<h1>"+message+"</h1>");
        //Cookie简单使用
        int expiry=60;
        Cookie cookie=new Cookie("username","zhangsan");
        cookie.setMaxAge(expiry);
        resp.addCookie(cookie);
//==========================
//        ServletContext context=getServletContext();//获取全局参数
//       String address= context.getInitParameter("address");
//        System.out.println("address="+address);
// =========================
//        Properties properties=new Properties();
//        InputStream ins =new FileInputStream("C:\\Users\\小翰翰\\Desktop\\Code\\HelloWeb\\src\\config.properties");
//        properties.load(ins);
//        String name=properties.getProperty("name");
//        System.out.println("name="+name);
// ==========================
    }
    @Override
    public void destroy(){
        super.destroy();
    }
}
