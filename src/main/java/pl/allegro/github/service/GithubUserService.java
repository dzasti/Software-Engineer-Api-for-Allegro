package pl.allegro.github.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;
import pl.allegro.github.model.GithubApi;
import pl.allegro.github.model.Language;
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

    public String getRepositoriesWithStars(String userName) {
        User user = createUser(userName);

        return new Gson().toJson(user.getRepositories());
    }

    public String getLanguages(String userName) {
        User user = createUser(userName);
        System.out.println(user.getLanguages());
        return new Gson().toJson(user.getCountedLanguages());
    }

    private User createUser(String userName) {
        Type repositoriesType = new TypeToken<ArrayList<Repository>>(){}.getType();
        List<Repository> repositories = new Gson().fromJson(
                GithubApi.getRepositoriesJson(userName), repositoriesType);

        Type languagesType = new TypeToken<ArrayList<Language>>(){}.getType();
        List<Language> languages = new Gson().fromJson(
                GithubApi.getRepositoriesJson(userName), languagesType);

        User user = new User();
        user.setRepositories(repositories);
        user.setLanguages(languages);

        return user;
    }
}
