package ningenme.net.sample.application.request;

import lombok.Data;

@Data
public class UserPostRequestDto {
    private String code;
    private String id;
    private String mail;
    private String password;
}
