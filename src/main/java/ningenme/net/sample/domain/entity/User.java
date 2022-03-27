package ningenme.net.sample.domain.entity;

import lombok.*;
import ningenme.net.sample.domain.value.Authority;
import ningenme.net.sample.domain.value.EncryptedPassword;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class User implements UserDetails {

    @NonNull
    private final String code;
    @NonNull
    private final String id;
    @NonNull
    private final String mail;
    @NonNull
    private final EncryptedPassword encryptedPassword;
    @NonNull
    private final List<Authority> authorityList;

    public User(@NonNull final String code,
                @NonNull final String id,
                @NonNull final String mail,
                @NonNull final EncryptedPassword encryptedPassword) {
        this(code,id,mail,encryptedPassword,List.of());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorityList;
    }

    @Override
    public String getPassword() {
        return encryptedPassword.getValue();
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
