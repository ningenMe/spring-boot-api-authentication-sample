package ningenme.net.sample.infrastructure.mysql.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import ningenme.net.sample.domain.entity.User;
import ningenme.net.sample.domain.value.Authority;
import ningenme.net.sample.domain.value.EncryptedPassword;

import java.util.List;

@Data
@NoArgsConstructor
public class UserMysqlDto {
    private String code;
    private String id;
    private String mail;
    private String encryptedPassword;

    public UserMysqlDto(@NonNull final User user) {
        code = user.getCode();
        id = user.getId();
        mail = user.getMail();
        encryptedPassword = user.getEncryptedPassword().getValue();
    }

    public User getUser() {
        return new User(
                code,
                id,
                mail,
                EncryptedPassword.of(encryptedPassword),
                List.of(Authority.COMIC,Authority.GAME) //FIXME 面倒なので認可はハードコーディング
        );
    }
}
