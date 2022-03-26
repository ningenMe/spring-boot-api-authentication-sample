package ningenme.net.sample.infrastructure.mysql.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import ningenme.net.sample.domain.entity.User;

@Data
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
}
