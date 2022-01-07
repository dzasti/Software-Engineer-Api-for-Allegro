package pl.allegro.github.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Repository {

    private String name;
    @SerializedName(value = "stars", alternate = "stargazers_count")
    private int stars;
}
