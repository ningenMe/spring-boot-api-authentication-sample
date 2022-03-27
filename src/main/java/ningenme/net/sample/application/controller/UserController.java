package ningenme.net.sample.application.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.sample.application.request.UserPostRequestBody;
import ningenme.net.sample.domain.entity.User;
import ningenme.net.sample.domain.service.UserService;
import ningenme.net.sample.domain.value.EncryptedPassword;
import ningenme.net.sample.domain.value.RawPassword;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<String> userPost(
            @RequestBody UserPostRequestBody userPostRequestBody
    ) {
        userService.post(
                new User(
                        userPostRequestBody.getCode(),
                        userPostRequestBody.getId(),
                        userPostRequestBody.getMail(),
                        EncryptedPassword.of(RawPassword.of(userPostRequestBody.getPassword()))
                )
        );
        return ResponseEntity.ok("");
    }

}
