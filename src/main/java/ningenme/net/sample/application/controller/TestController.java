package ningenme.net.sample.application.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.sample.domain.value.AuthorityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class TestController {

    @PreAuthorize("hasAuthority('"+ AuthorityModel.Value.COMIC +"')")
    @GetMapping("/comic")
    public ResponseEntity<String> comicGet() {
        return ResponseEntity.ok("comic");
    }

    @PreAuthorize("hasAuthority('"+ AuthorityModel.Value.ANIME +"')")
    @GetMapping("/anime")
    public ResponseEntity<String> animeGet() {
        return ResponseEntity.ok("anime");
    }

    @PreAuthorize("hasAuthority('"+ AuthorityModel.Value.GAME +"')")
    @GetMapping("/game")
    public ResponseEntity<String> gameGet() {
        return ResponseEntity.ok("game");
    }

    @GetMapping("/movie")
    public ResponseEntity<String> movieGet() {
        return ResponseEntity.ok("movie");
    }

}
