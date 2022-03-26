package ningenme.net.sample.domain.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.sample.domain.entity.User;
import ningenme.net.sample.infrastructure.mysql.UserMysqlRepository;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserMysqlRepository userMysqlRepository;

    public void post(@NonNull final User user) {
        userMysqlRepository.post(user);
    }
}
