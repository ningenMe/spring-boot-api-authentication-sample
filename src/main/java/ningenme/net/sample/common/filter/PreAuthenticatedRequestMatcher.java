package ningenme.net.sample.common.filter;

import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

public class PreAuthenticatedRequestMatcher implements RequestMatcher {
    @Override
    public boolean matches(HttpServletRequest request) {
        if (Objects.equals(request.getRequestURI(),"/login")) {
            return false;
        }
        return true;
    }
}
