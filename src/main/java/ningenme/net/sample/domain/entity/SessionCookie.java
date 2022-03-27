package ningenme.net.sample.domain.entity;

import lombok.NonNull;
import ningenme.net.sample.domain.value.SessionId;

import javax.servlet.http.Cookie;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class SessionCookie {

    private static final String COOKIE_NAME = "sessionId";

    public static Cookie getCookie(@NonNull final SessionId sessionId) {
        final Cookie cookie = new Cookie(COOKIE_NAME, sessionId.getValue());
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
//        cookie.setDomain("");
        return cookie;
    }

    public static String getSessionId(final Cookie[] cookieArray) {
        try {
            return Arrays.stream(cookieArray)
                    .filter(cookie -> Objects.equals(cookie.getName(), COOKIE_NAME))
                    .findFirst()
                    .get()
                    .getValue();
        } catch (Exception ex) {
            return "";
        }
    }
}
