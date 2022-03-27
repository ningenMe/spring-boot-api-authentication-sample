package ningenme.net.sample.domain.service;

import lombok.RequiredArgsConstructor;
import ningenme.net.sample.domain.value.SessionId;
import ningenme.net.sample.infrastructure.redis.UserRedisRepository;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorizationUserService implements AuthenticationUserDetailsService<PreAuthenticatedAuthenticationToken> {

    private final UserRedisRepository userRedisRepository;

    @Override
    public UserDetails loadUserDetails(PreAuthenticatedAuthenticationToken token) throws UsernameNotFoundException {
        final SessionId sessionId = (SessionId) token.getCredentials();
        try {
            return userRedisRepository.get(sessionId);
        } catch (Exception ex) {
            throw new UsernameNotFoundException(ex.getMessage());
        }
    }

}
