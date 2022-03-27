package ningenme.net.sample.application.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.sample.domain.value.Authority;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class TestController {

    @PreAuthorize("hasAuthority('"+ Authority.Value.COMIC +"')")
    @GetMapping("/comic")
    public ResponseEntity<String> comicGet() {
        return ResponseEntity.ok("comic");
    }

    @PreAuthorize("hasAuthority('"+ Authority.Value.ANIME +"')")
    @GetMapping("/anime")
    public ResponseEntity<String> animeGet() {
        return ResponseEntity.ok("anime");
    }

    @PreAuthorize("hasAuthority('"+ Authority.Value.GAME +"')")
    @GetMapping("/game")
    public ResponseEntity<String> gameGet() {
        return ResponseEntity.ok("game");
    }

    @GetMapping("/movie")
    public ResponseEntity<String> movieGet() {
        return ResponseEntity.ok("movie");
    }

}
