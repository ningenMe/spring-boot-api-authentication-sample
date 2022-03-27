package ningenme.net.sample.domain.entity;

import lombok.NonNull;
import ningenme.net.sample.domain.value.SessionId;

import javax.servlet.http.Cookie;

public class SessionCookie {

    public static Cookie getCookie(@NonNull final SessionId sessionId) {
        Cookie cookie = new Cookie("sessionId", sessionId.getValue().toString());
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
//        cookie.setDomain("");
        return cookie;
    }
}
