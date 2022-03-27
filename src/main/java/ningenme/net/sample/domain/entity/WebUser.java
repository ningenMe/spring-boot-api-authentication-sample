package ningenme.net.sample.domain.entity;

import lombok.Data;
import lombok.NonNull;
import ningenme.net.sample.domain.value.EncryptedPassword;

@Data
public class WebUser {

    @NonNull
    private final String code;
    @NonNull
    private final String id;
    @NonNull
    private final String mail;
    @NonNull
    private final EncryptedPassword encryptedPassword;
}
