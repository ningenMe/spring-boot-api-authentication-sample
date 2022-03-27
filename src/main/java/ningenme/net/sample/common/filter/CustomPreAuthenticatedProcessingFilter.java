package ningenme.net.sample.common.filter;

import lombok.extern.slf4j.Slf4j;
import ningenme.net.sample.domain.entity.SessionCookie;
import ningenme.net.sample.domain.value.SessionId;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

import javax.servlet.http.HttpServletRequest;

@Slf4j
public class CustomPreAuthenticatedProcessingFilter extends AbstractPreAuthenticatedProcessingFilter {

    @Override
    protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
        return "";
    }

    @Override
    protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
        return new SessionId(SessionCookie.getSessionId(request.getCookies()));
    }



}
