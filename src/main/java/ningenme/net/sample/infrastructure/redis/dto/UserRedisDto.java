package ningenme.net.sample.infrastructure.redis.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import ningenme.net.sample.domain.entity.User;
import ningenme.net.sample.domain.value.Authority;

import java.util.List;

@Data
@NoArgsConstructor
public class UserRedisDto {
    private String code;
    private String id;
    private String mail;
    private List<String> authorityList;

    public UserRedisDto(@NonNull final User user) {
        code = user.getCode();
        id = user.getId();
        mail = user.getMail();
        authorityList = Authority.getValueList(user.getAuthorityList());
    }
}
