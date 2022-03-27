package ningenme.net.sample.common.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.sample.domain.entity.SessionCookie;
import ningenme.net.sample.domain.entity.User;
import ningenme.net.sample.domain.service.AuthenticationUserService;
import ningenme.net.sample.domain.service.UserService;
import ningenme.net.sample.domain.value.SessionId;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final AuthenticationUserService authenticationUserService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        final SessionId sessionId = new SessionId();
        authenticationUserService.post(sessionId, (User) authentication.getPrincipal());
        response.addCookie(SessionCookie.getCookie(sessionId));
    }

}
