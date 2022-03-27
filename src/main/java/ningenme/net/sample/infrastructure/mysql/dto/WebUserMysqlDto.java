package ningenme.net.sample.infrastructure.mysql.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import ningenme.net.sample.domain.entity.WebUser;

@Data
@NoArgsConstructor
public class WebUserMysqlDto {
    private String code;
    private String id;
    private String mail;
    private String encryptedPassword;

    public WebUserMysqlDto(@NonNull final WebUser webUser) {
        code = webUser.getCode();
        id = webUser.getId();
        mail = webUser.getMail();
        encryptedPassword = webUser.getEncryptedPassword().getValue();
    }
}
