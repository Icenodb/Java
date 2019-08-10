# Session

## Session介绍

> **基于Cookie的一种会话机制**

> **创建于服务器端，保存于服务器，维护于服务器端,每创建一个新的Session,服务器端都会分配一个唯一的ID，并且把这个ID保存到客户端的Cookie中，保存形式是以JSESSIONID来保存的。**

> 通过HttpServletRequest.getSession 进行获得HttpSession对象，通过setAttribute()给会话赋值，可以通过invalidate()将其失效。
>
> 每一个HttpSession有一个唯一的标识SessionID，只要同一次打开的浏览器通过request获取到session都是同一个。
>
> WEB容器默认的是用Cookie机制保存SessionID到客户端，并将此Cookie设置为关闭浏览器失效，Cookie名称为：JSESSIONID
>
> 每次请求通过读取Cookie中的SessionID获取相对应的Session会话
>
> HttpSession的数据保存在服务器端，所以不要保存数据量耗资源很大的数据资源，必要时可以将属性移除或者设置为失效
>
> HttpSession可以通过setMaxInactiveInterval()设置失效时间(秒)或者在web.xml中配置
>
> *摘自：[简书](https://www.jianshu.com/p/25802021be63)*

## Session常用API

```java
HttpSession session=request.getSession();//得到会话id
session.setAttribute(name,value);//存值
session.getAttribute(name);//取值
session.removeAttribute(name);//移除值
session.invalidate();//强制干掉会话，里面的数据都没了
```

## Session何时创建，何时销毁？

### 创建

在servlet里面调用了request.getSession();

### 销毁

1. 关闭服务器
2. session会话时间过期。Default:30mins（不同服务器有可能不同）

> session是存放在服务器内存中的一份数据。可以持久化。Like Redis。即使关了服务器，session也不会销毁

