package ningenme.net.sample.common.filter;

import lombok.extern.slf4j.Slf4j;
import ningenme.net.sample.domain.value.AuthenticationParameter;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }

        final String code = request.getParameter("code");
        final String id   = request.getParameter("id");
        final String mail = request.getParameter("mail");
        final String password = request.getParameter("password");

        UsernamePasswordAuthenticationToken authRequest
                = new UsernamePasswordAuthenticationToken(AuthenticationParameter.getJson(code,id,mail), password);
        // Allow subclasses to set the "details" property
        setDetails(request, authRequest);
        return this.getAuthenticationManager().authenticate(authRequest);
    }

}
