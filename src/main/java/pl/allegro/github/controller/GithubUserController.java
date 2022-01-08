package pl.allegro.github.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.allegro.github.service.GithubUserService;

import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/{user}")
@Validated
public class GithubUserController {
    private final GithubUserService githubUserService;
    private final static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Autowired
    public GithubUserController(GithubUserService aGithubUserService) {
        this.githubUserService = aGithubUserService;
    }

    @GetMapping(value = "repositories",produces = MediaType.APPLICATION_JSON_VALUE)
    public String getRepositoriesWithStars(@PathVariable @NotBlank String user) {
        return gson.toJson(githubUserService.getRepositoriesWithStars(user));
    }

    @GetMapping(value = "stars",produces = MediaType.APPLICATION_JSON_VALUE)
    public String getTotalStarsAmount(@PathVariable @NotBlank String user) {
        return gson.toJson(githubUserService.getTotalStarsAmount(user));
    }

    @GetMapping(value = "languages",produces = MediaType.APPLICATION_JSON_VALUE)
    public String getLanguages(@PathVariable @NotBlank String user) {
        return gson.toJson(githubUserService.getLanguages(user));
    }
}
