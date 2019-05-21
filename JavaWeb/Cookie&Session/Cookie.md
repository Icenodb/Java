# Cookie&Session

## Cookie

### Cookie煎蛋介绍&使用&获取

> 保存数据，比如登陆信息什么，因为HTTP是无状态协议，要用Session机制来保存，Cookie用来识别特定用户和数据。

```java
//Cookie简单使用
Cookie cookie=new Cookie("username","zhangsan");
resp.addCookie(cookie);
```

```java
 //接受Cookie
 Cookie[] cookies=req.getCookies();
        if(cookies!=null) {
            for (Cookie c : cookies) {
                String name=c.getName();
                String value=c.getValue();
                System.out.println("name:"+name+"   value:"+value);
            }
        }
```

### Cookie有效期

> 默认关闭浏览器后，Cookie就没了
>
> 要设置有效期的话setMaxAge------正值表示保存多久，负值表示浏览器关闭就没了（Default:-1）
>
> 以秒为单位
>
> 先set再add

记录上次登录时间的小练习↓↓

[Cookie小练习](https://github.com/Icenodb/Java_Practice/tree/master/JavaWeb/Cookie&Session)
