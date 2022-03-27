package ningenme.net.sample.domain.value;

import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class SessionId {

    private final UUID value;

    public SessionId() {
        this(UUID.randomUUID());
    }
}
