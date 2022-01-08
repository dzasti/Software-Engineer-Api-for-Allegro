package pl.allegro.github.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {
    private static User user;

    @BeforeAll
    static void createUser() {
        user = new User();
        user.setLanguages(List.of(
                new Language("Python"), new Language("Python"), new Language("Java"), new Language(null)
        ));
    }

    @Test
    void userShouldHave2TotalLanguages() {
        assertEquals(2,user.getCountedLanguages().size());
    }

    @Test
    void userShouldHave2PythonAnd1JavaCountedLanguage() {
        assertEquals(2,user.getCountedLanguages().get("Python"));
        assertEquals(1,user.getCountedLanguages().get("Java"));
    }
}
