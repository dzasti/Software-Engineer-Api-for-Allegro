package pl.allegro.github.model;

import org.springframework.web.client.RestTemplate;

public class GithubApi {
    private final static RestTemplate restTemplate = new RestTemplate();

    public static String getRepositoriesJson(String userName) {
        return restTemplate.getForObject("https://api.github.com/users/" +userName + "/repos",String.class);
    }
}
