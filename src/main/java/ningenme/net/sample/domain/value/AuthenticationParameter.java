package ningenme.net.sample.domain.value;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Slf4j
public class AuthenticationParameter {
    private String code;
    private String id;
    private String mail;

    public static String getJson(final String code, final String id, final String mail) {
        AuthenticationParameter authenticationParameter = new AuthenticationParameter();
        {
            authenticationParameter.setCode(code);
            authenticationParameter.setId(id);
            authenticationParameter.setMail(mail);
        }
        try {
            return new ObjectMapper().writeValueAsString(authenticationParameter);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return "";
        }
    }

    public static AuthenticationParameter of(@NonNull final String json) {
        try {
            return new ObjectMapper().readValue(json, AuthenticationParameter.class);
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @JsonIgnore
    public Boolean isCodeIdLogin() {
        return Objects.nonNull(code) && Objects.nonNull(id);
    }
}
