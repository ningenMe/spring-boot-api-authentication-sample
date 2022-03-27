package ningenme.net.sample.infrastructure.mysql;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.sample.domain.entity.User;
import ningenme.net.sample.infrastructure.mysql.dto.UserMysqlDto;
import ningenme.net.sample.infrastructure.mysql.mapper.UserMysqlMapper;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserMysqlRepository {

    private final UserMysqlMapper userMysqlMapper;

    public void post(@NonNull final User user) {
        userMysqlMapper.insert(new UserMysqlDto(user));
    }

}
