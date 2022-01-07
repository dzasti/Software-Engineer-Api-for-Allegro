package pl.allegro.github.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.allegro.github.service.GithubUserService;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@RestController
@RequestMapping("/")
@Validated
public class GithubUserController {
    private final GithubUserService githubUserService;

    @Autowired
    public GithubUserController(GithubUserService aGithubUserService) {
        this.githubUserService = aGithubUserService;
    }

    @GetMapping(value = "repositories",produces = MediaType.APPLICATION_JSON_VALUE)
    public String getRepositoriesWithStars(@RequestParam @NotBlank @Size(min = 1) String name) {
        return githubUserService.getRepos(name);
    }

    @GetMapping(value = "stars",produces = MediaType.APPLICATION_JSON_VALUE)
    public String getTotalStarsAmount(@RequestParam @NotBlank @Size(min = 1)  String name) {
        return githubUserService.getTotalStarsAmount(name);
    }
}
