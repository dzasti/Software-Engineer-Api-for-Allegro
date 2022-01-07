package pl.allegro.github.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Setter;
import java.util.Optional;

@Setter
@AllArgsConstructor
public class Language {

    @SerializedName(value = "name", alternate = "language")
    private String name;

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }
}
