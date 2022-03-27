package ningenme.net.sample.domain.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.sample.domain.entity.User;
import ningenme.net.sample.domain.value.AuthenticationParameter;
import ningenme.net.sample.domain.value.SessionId;
import ningenme.net.sample.infrastructure.mysql.UserMysqlRepository;
import ningenme.net.sample.infrastructure.redis.UserRedisRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthenticationUserService implements UserDetailsService {

    private final UserMysqlRepository userMysqlRepository;
    private final UserRedisRepository userRedisRepository;

    @Override
    public UserDetails loadUserByUsername(String json) throws UsernameNotFoundException {
        final AuthenticationParameter authenticationParameter = AuthenticationParameter.of(json);

        if(authenticationParameter.isCodeIdLogin()) {
            return userMysqlRepository.getByCodeAndId(authenticationParameter.getCode(),authenticationParameter.getId());
        }
        else {
            return userMysqlRepository.getByMail(authenticationParameter.getMail());
        }
    }

    public void post(
            @NonNull final SessionId sessionId,
            @NonNull final User user) {
        userRedisRepository.post(sessionId, user);
    }

}
