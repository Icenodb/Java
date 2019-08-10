import javax.servlet.http.Cookie;
public class CookieUtil {
    public static Cookie findCookie(Cookie[] cookies, String name) {
        if (cookies != null) {
            for (Cookie c:cookies) {
                if(name.equals(c.getName())){
                    return c;
                }
            }
        }
        return null;
    }
}
