package ningenme.net.sample.domain.value;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum Authority implements GrantedAuthority {
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

    private static Authority getAuthority(@NonNull final String value) {
        return Arrays
                .stream(Authority.values())
                .filter(authority -> Objects.equals(authority.getAuthority(), value))
                .findFirst()
                .get();
    }

    @Override
    public String getAuthority() {
        return value;
    }

    public static List<String> getValueList(@NonNull final List<Authority> authorityList) {
        return authorityList.stream().map(Authority::getAuthority).collect(Collectors.toUnmodifiableList());
    }

    public static List<Authority> getAuthorityList(@NonNull final List<String> valueList) {
        return valueList
                .stream()
                .map(Authority::getAuthority)
                .collect(Collectors.toUnmodifiableList());
    }
}
