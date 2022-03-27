package ningenme.net.sample.domain.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.sample.domain.entity.User;
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
public class UserService implements UserDetailsService {

    private final UserMysqlRepository userMysqlRepository;
    private final UserRedisRepository userRedisRepository;

    public void post(@NonNull final User user) {
        userMysqlRepository.post(user);
    }

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        return userMysqlRepository.get(mail);
    }

    public void sessionPost(
            @NonNull final SessionId sessionId,
            @NonNull final User user) {
        userRedisRepository.post(sessionId, user);
    }
}
