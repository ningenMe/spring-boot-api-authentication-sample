package ningenme.net.sample.domain.value;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.Objects;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum AuthorityModel implements GrantedAuthority {
    COMIC(Value.COMIC),
    ANIME(Value.ANIME),
    GAME(Value.GAME),
    ;
    public static class Value {
        public static final String COMIC = "comic";
        public static final String ANIME = "anime";
        public static final String GAME  = "game";
    }


    private final String value;

    @Override
    public String getAuthority() {
        return value;
    }

}