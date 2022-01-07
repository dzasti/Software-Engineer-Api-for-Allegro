package pl.allegro.github.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;
import pl.allegro.github.model.GithubApi;
import pl.allegro.github.model.Repository;
import pl.allegro.github.model.User;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class GithubUserService {

    public String getTotalStarsAmount(String userName) {
        User user = createUser(userName);

        return new Gson().toJson(user.getTotalStarsAmount());
    }

    public String getRepos(String userName) {
        User user = createUser(userName);

        return new Gson().toJson(user.getRepositories());
    }

    private User createUser(String userName) {
        Type listType = new TypeToken<ArrayList<Repository>>(){}.getType();
        List<Repository> yourClassList = new Gson().fromJson(
                GithubApi.getRepositoriesJson(userName), listType);
        User user = new User();
        user.setRepositories(yourClassList);

        return user;
    }
}
