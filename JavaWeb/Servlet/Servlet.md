# Servelt

## Servlet的生命周期

1. 装载Servlet
2. Server创建一个Servlet实例
3. Servlet得init()
4. 客户端请求到达Server
5. Server创建一个请求对象
6. Server创建一个响应对象
7. Server激活Servlet的service方法，传递请求和响应对象作为参数例如HttpServletRequest,HttpServletResponse
8. 获得关于请求对象得信息，处理请求，访问其他资源。
9. 使用Response将响应传回Server，最终到达客户端
10. 对于更多的客户端请求，Server创建新的请求和响应对象，仍然激活此servlet的service方法，但是init()一般只初始化一次
11. 不再需要时，或者Server要关闭时，调用Servlet的destroy()。

## Servlet的工作过程

1. 在客户端对web服务器发出请求
2. web服务器收到请求后将其发送给Servlet
3. Servlet容器为此产生一个实例对象并调用ServletAPI中相应的方法来对客户端HTTP请求进行处理，然后返回给WEB服务器
4. WEB服务器将从Servlet实例对象中收到的相应结构发送给客户端

## Servlet与JSP的区别

> 这个摘自网络

1、JSP在本质上就是SERVLET,但是两者的创建方式不一样.

2、Servlet完全是JAVA程序代码构成，擅长于流程控制和事务处理，通过Servlet来生成动态网页很不直观.

3、SP由HTML代码和JSP标签构成，可以方便地编写动态网页.

​     **Servlet来控制业务流程，采用JSP来生成动态网页**

1. JSP是Servlet技术的扩展，本质上就是Servlet的简易方式
2. JSP编译后是“类servlet”。
3. Servlet和JSP最主要的不同点在于，Servlet的应用逻辑是在Java文件中，并且完全从表示层中的HTML里分离开来。而JSP是Java和HTML组合成一个扩展名为.jsp的文件。
4. JSP侧重于视图，Servlet主要用于控制逻辑。

## ServletContext

每个web工程只有一个ServletContext，意思是在同一个web工程里面获取到的ServletContext都是同一个(全局)

**用处：**

1. 获取全局参数，比如

   ```
   <!--用于配置全局参数-->
   <context-param>
       <param-name>address</param-name>
       <param-value>重庆</param-value>
   </context-param>
   ```

2. 获取web应用中的资源,比如config.properties里面的

3. 存取数据，Servlet间共享数据 域对象

   **用于登陆的loginServlet：**

   ```
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
   ```
