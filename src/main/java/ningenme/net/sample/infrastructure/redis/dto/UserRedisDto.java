package ningenme.net.sample.infrastructure.redis.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import ningenme.net.sample.domain.entity.User;
import ningenme.net.sample.domain.value.Authority;
import ningenme.net.sample.domain.value.EncryptedPassword;

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

    @JsonIgnore
    public User getUser() {
        return new User(
                code, id, mail,
                EncryptedPassword.of(""),
                Authority.getAuthorityList(authorityList)
        );
    }
}
