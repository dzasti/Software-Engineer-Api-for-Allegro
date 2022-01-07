package pl.allegro.github.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;

@Getter
@NoArgsConstructor
public class User {

    private List<Repository> repositories;
    private int totalStarsAmount;

    public void setRepositories(List<Repository> repositories) {
        this.repositories = repositories;

        for (Repository repository : repositories) {
            totalStarsAmount += repository.getStars();
        }
    }
}
