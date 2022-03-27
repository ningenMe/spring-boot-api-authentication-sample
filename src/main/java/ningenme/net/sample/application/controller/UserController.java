package ningenme.net.sample.application.controller;

import lombok.RequiredArgsConstructor;
import ningenme.net.sample.application.request.UserPostRequestDto;
import ningenme.net.sample.application.response.UserGetResponseDto;
import ningenme.net.sample.domain.entity.User;
import ningenme.net.sample.domain.service.UserService;
import ningenme.net.sample.domain.value.EncryptedPassword;
import ningenme.net.sample.domain.value.RawPassword;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/users")
    public ResponseEntity<String> userPost(
            @RequestBody UserPostRequestDto userPostRequestDto
    ) {
        userService.post(
                new User(
                        userPostRequestDto.getCode(),
                        userPostRequestDto.getId(),
                        userPostRequestDto.getMail(),
                        EncryptedPassword.of(passwordEncoder, RawPassword.of(userPostRequestDto.getPassword()))
                )
        );
        return ResponseEntity.ok("");
    }

    @GetMapping("/users/me")
    public ResponseEntity<UserGetResponseDto> userGet() {
        return ResponseEntity.ok(new UserGetResponseDto(userService.get()));
    }

}
