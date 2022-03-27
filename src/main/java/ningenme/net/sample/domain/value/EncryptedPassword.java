package ningenme.net.sample.domain.value;

import lombok.*;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class EncryptedPassword {

    @NonNull
    private final String value;

    private final static PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    public static EncryptedPassword of(@NonNull final RawPassword rawPassword) {
        return new EncryptedPassword(passwordEncoder.encode(rawPassword.getValue()));
    }

    public static EncryptedPassword of(@NonNull final String encryptedPassword) {
        return new EncryptedPassword(encryptedPassword);
    }
}
