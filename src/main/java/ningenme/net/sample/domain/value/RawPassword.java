package ningenme.net.sample.domain.value;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class RawPassword {

    @NonNull
    private final String value;

    public static RawPassword of(@NonNull final String password) {
        return new RawPassword(password);
    }
}
