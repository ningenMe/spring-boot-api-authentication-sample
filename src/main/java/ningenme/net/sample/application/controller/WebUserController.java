package ningenme.net.sample.application.controller;

import lombok.RequiredArgsConstructor;
import ningenme.net.sample.application.request.WebUserPostRequestBody;
import ningenme.net.sample.domain.entity.WebUser;
import ningenme.net.sample.domain.service.WebUserService;
import ningenme.net.sample.domain.value.EncryptedPassword;
import ningenme.net.sample.domain.value.RawPassword;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WebUserController {

    private final WebUserService webUserService;

    @PostMapping("/web-users")
    public ResponseEntity<String> webUserPost(
            @RequestBody WebUserPostRequestBody webUserPostRequestBody
    ) {
        webUserService.post(
                new WebUser(
                        webUserPostRequestBody.getCode(),
                        webUserPostRequestBody.getId(),
                        webUserPostRequestBody.getMail(),
                        EncryptedPassword.of(RawPassword.of(webUserPostRequestBody.getPassword()))
                )
        );
        return ResponseEntity.ok("");
    }

}
