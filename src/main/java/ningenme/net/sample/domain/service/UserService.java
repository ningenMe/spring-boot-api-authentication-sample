package ningenme.net.sample.domain.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.sample.domain.entity.User;
import ningenme.net.sample.domain.value.SessionId;
import ningenme.net.sample.infrastructure.mysql.UserMysqlRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserMysqlRepository userMysqlRepository;

    public void post(@NonNull final User user) {
        userMysqlRepository.post(user);
    }

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        log.info(mail);
        User user = userMysqlRepository.get(mail);
        log.info(user.toString());
        return user;
    }

    public void sessionPost(
            @NonNull final SessionId sessionId,
            @NonNull final User user) {
        //TODO redisへの永続化
        return ;
    }
}
