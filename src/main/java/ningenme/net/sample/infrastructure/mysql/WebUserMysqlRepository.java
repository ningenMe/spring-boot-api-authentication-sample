package ningenme.net.sample.infrastructure.mysql;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.sample.domain.entity.WebUser;
import ningenme.net.sample.domain.value.EncryptedPassword;
import ningenme.net.sample.infrastructure.mysql.dto.WebUserMysqlDto;
import ningenme.net.sample.infrastructure.mysql.mapper.WebUserMysqlMapper;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class WebUserMysqlRepository {

    private final WebUserMysqlMapper userMysqlMapper;

    public void post(@NonNull final WebUser webUser) {
        userMysqlMapper.insert(new WebUserMysqlDto(webUser));
    }

    public WebUser get(@NonNull final String mail) {
        WebUserMysqlDto userMysqlDto = userMysqlMapper.select(mail);
        return new WebUser(
                userMysqlDto.getCode(),
                userMysqlDto.getId(),
                userMysqlDto.getMail(),
                EncryptedPassword.of(userMysqlDto.getEncryptedPassword())
        );
    }

}
