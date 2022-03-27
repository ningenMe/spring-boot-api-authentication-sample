package ningenme.net.sample.domain.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.sample.domain.entity.WebUser;
import ningenme.net.sample.infrastructure.mysql.WebUserMysqlRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class WebUserService implements UserDetailsService {

    private final WebUserMysqlRepository webUserMysqlRepository;

    public void post(@NonNull final WebUser webUser) {
        webUserMysqlRepository.post(webUser);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info(username);
        WebUser webUser = webUserMysqlRepository.get(username);
        log.info(webUser.toString());
        return null;
    }
}
