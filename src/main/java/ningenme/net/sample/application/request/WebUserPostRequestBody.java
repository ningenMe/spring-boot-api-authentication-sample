package ningenme.net.sample.application.request;

import lombok.Data;

@Data
public class WebUserPostRequestBody {
    private String code;
    private String id;
    private String mail;
    private String password;
}
