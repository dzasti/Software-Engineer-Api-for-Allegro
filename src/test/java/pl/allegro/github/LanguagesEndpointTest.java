package pl.allegro.github;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import pl.allegro.github.service.GithubUserService;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = GithubApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LanguagesEndpointTest {

    private final TestRestTemplate restTemplate;
    private final GithubUserService githubUserService;
    private final static String PROPER_USER_NAME = "dzasti";
    private final static String NON_EXISTING_USER_NAME = "goy13tr82gfwdqi3648trf3u4";
    private final static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @LocalServerPort
    private int port;

    @Autowired
    LanguagesEndpointTest(TestRestTemplate aTestRestTemplate, GithubUserService aGithubUserService ) {
        restTemplate = aTestRestTemplate;
        githubUserService = aGithubUserService;
    }

    @Test
    void httpStatusShouldBe200WhenProperRequest() {
        ResponseEntity<String> responseEntity = this.restTemplate
                .getForEntity("http://localhost:" + port + "/" + PROPER_USER_NAME+ "/languages", String.class);

        assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    void jsonsShouldBeTheSameWhenProperRequest() {
        ResponseEntity<String> responseEntity = this.restTemplate
                .getForEntity("http://localhost:" + port + "/" + PROPER_USER_NAME + "/languages", String.class);

        assertEquals(responseEntity.getBody(),gson.toJson(githubUserService.getLanguages(PROPER_USER_NAME)));
    }

    @Test
    void httpStatusShouldBe500WhenRequestWithNonExistingUser() {
        ResponseEntity<String> responseEntity = this.restTemplate
                .getForEntity("http://localhost:" + port + "/" + NON_EXISTING_USER_NAME + "/languages", String.class);

        assertEquals(500, responseEntity.getStatusCodeValue());
    }

}
