package ningenme.net.sample.application.response;

import lombok.Data;
import lombok.NonNull;
import ningenme.net.sample.domain.entity.User;
import ningenme.net.sample.domain.value.Authority;

import java.util.List;

@Data
public class UserGetResponseDto {

    private final List<String> authorityList;

    public UserGetResponseDto(@NonNull final User user) {
        authorityList = Authority.getValueList(user.getAuthorityList());
    }

}
