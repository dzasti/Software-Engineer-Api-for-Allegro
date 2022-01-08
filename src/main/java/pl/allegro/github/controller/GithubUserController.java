package pl.allegro.github.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.allegro.github.service.GithubUserService;
import javax.validation.constraints.NotBlank;


@RestController
@RequestMapping("/{user}")
@Validated
public class GithubUserController {
    private final GithubUserService githubUserService;

    @Autowired
    public GithubUserController(GithubUserService aGithubUserService) {
        this.githubUserService = aGithubUserService;
    }

    @GetMapping(value = "repositories",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getRepositoriesWithStars(@PathVariable @NotBlank String user) {
        return new ResponseEntity(githubUserService.getRepositoriesWithStars(user), HttpStatus.OK);
    }

    @GetMapping(value = "stars",produces = MediaType.APPLICATION_JSON_VALUE)
    public String getTotalStarsAmount(@PathVariable @NotBlank String user) {
        return githubUserService.getTotalStarsAmount(user);
    }

    @GetMapping(value = "languages",produces = MediaType.APPLICATION_JSON_VALUE)
    public String getLanguages(@PathVariable @NotBlank String user) {
        return githubUserService.getLanguages(user);
    }
}
