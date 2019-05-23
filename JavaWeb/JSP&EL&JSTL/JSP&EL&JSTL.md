# JSP&EL&JSTL

## JSP(java server page)

- 什么是jsp

> 旧时代的产物，但是还是有些东西是这个写的，要了解。
>
> 从用户角度看待，就是一个网页，从程序员角度看，其实是已给java类，它继承了servlet，所以可直接说jsp就是一个servlet

- 为什么会有jsp？

> html多数情况下用来显示静态内容，一成不变的。但是有时候我们需要在网页上显示一些动态数据，比如：查询所有的学生信息，根据姓名去查询某个具体的学生。去查询数据库，然后在网页上显示。html不支持写java，jsp里面可以写java代码

### 怎么用jsp

#### 三大指令集

**page include taglib**

指令写法

<%@ 指令名字%>

page指令

- language

>表明页面中可以写java代码

- contentType

> 说这个文件是什么类型，告诉浏览器我是什么内容类型，以及使用什么编码

- extends

>用于指定JSP翻译成java文件后继承的父类是谁，一般不用改。

- session

> ture-false   用于指定这个jsp页面是否可以直接使用session
>
> ```jsp
> <%
> session.getAttibute(name);
> %>
> ```

- errorPage

> 指的是错误的页面，值要给错误页面的路径
>
> errorPage="errorPage.jsp"
>
> 错误页面要配合另外一个属性isErrorPage="true" 用于声明这是个错误页面

#### JSP动作标签

jsp:forword  jsp:include  jsp:param

- include

> 包含另外一个文件进来
>
> <%@ include file=".... .jsp" %>

- param

> 意思是在包含某个页面的时候或者在跳转某个页面的时候，加入这个参数
>
> ```jsp
> <jsp:forward page="other02.jsp">//跳转到这个页面
>     <jsp:param value="Chongqing" name="address"/>//同时带上这俩参数
> </jsp:forward>
> ```
>
> ```jsp
> //这里是other02.jsp里get参数
> <%=request.getParameter("address")%>
> ```

#### ⭐内置对象

> 就是直接在jsp页面中可以直接使用这些对象，不用创建
>
> pageContext**作用域仅限于当前的页面,还可以获取到其他八个内置对象**
>
> request**作用域仅限于一次请求，只要服务器对该请求做出了响应，这个域中存的值就没有了**
>
> session**作用域限定于一次会话**
>
> application**整个工程都可以访问，服务器关闭后就不能访问了**
>
> 👆以上是作用域对象，可以存值，取值范围有限定setAttribute(name,value),getAttribute(name,value)
>
> out【JspWriter】
>
> **用out的话会输出到response的缓冲区去，所以先显示response本身的内容，然后才输入out**
>
> response【HttpServletResponse】
>
> ---------------------------------------------------
>
> exception(isErrorPage)【Trowable】
>
> page【Object】这个jsp翻译成java类的实例对象
>
> config【ServletCofig】

## EL表达式

> 简化jsp里的java代码，做取值工作
>
> ${    }
>
> ```jsp
> <%
> //普通手段取值session.getAttribute("name").....
> pageContext.setAttribute("name","page");
> request.setAttribute("name","page");
> session.setAttribute("name","page");
> application.setAttribute("name","page");
> -----------------------------------------
> ${pageScope.name}
> ${requestScope.name}
> ${sessionScope.name}
> ${applicationScope.name}
> -----------------------------------------
>     pageContext.setAttribute("array(别名)",数组);
> ${array[下标]}
> List list=new ArrayList();//集合
> list.add("1");
> list.add("2");
> list.add("3");
> pageContext.setAttribute("lis(别名)",list);
> ${lis[下标]}
> ------------------------------------------
> Map map=new HashMap();
> map.put("name","zhangsan");
> map.put("age",18);
> map.put("adress.aa","Chongqing");//注意这种有个点号的
> pageContext.setAttribute("map",map);
> ${map.name},${map.age},${map["address.aa"]}
> %>
> ```

### EL表达式  隐式对象

**作用域相关**

pageScope

requestScope

sessionScope

applicationScope

**请求头**

header

headerValues

**请求参数**

param

params

**没规律的：**

cookie

initParam

pageContext

## JSTL

> JSP Standard Tag Library 
>
> 简化jsp的编写，替换<%%>写法，一般与EL表达式配合(1.0版本不支持EL表达式)
>
> 先导jar---->lib

- ```jsp
  <c:set var="age" value="18"></c:set>
  
  <c:if test="${age>16}" var="(存到一个变量去)" scope="域">年龄大于16岁</c:if>
  
  从1开始遍历到10，结果赋值给i，存到page域中，step增幅为2
  <c:forEach begin="1" end="10" var="i" step="2"></c:forEach>
  <c:forEach var="user" items="${list}"></c:forEach> 目标是items，要用EL表达式，存储到user里
  ```