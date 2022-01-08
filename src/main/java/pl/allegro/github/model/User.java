package pl.allegro.github.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@NoArgsConstructor
public class User {

    @Getter
    private List<Repository> repositories;
    @Getter
    @SerializedName(value = "amount", alternate = "amount")
    private int totalStarsAmount;
    private List<Language> languages;

    public void setRepositories(List<Repository> aRepositories) {
        repositories = aRepositories;

        for (Repository repository : repositories) {
            totalStarsAmount += repository.getStars();
        }
    }

    public void setLanguages(List<Language> aLanguages) {
        languages = new ArrayList<>();
        languages = aLanguages.stream()
                .filter(element -> element.getName().isPresent())
                .collect(Collectors.toList());
    }

    public Map<String,Long> getCountedLanguages() {
        return languages.stream().collect(Collectors.groupingBy(e -> e.getName().get(), Collectors.counting()));
    }
}
