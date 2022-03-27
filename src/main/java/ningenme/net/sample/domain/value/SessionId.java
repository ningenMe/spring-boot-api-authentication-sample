package ningenme.net.sample.domain.value;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class SessionId {

    private final String value;

    public SessionId() {
        this(UUID.randomUUID().toString());
    }
}
