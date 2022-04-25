package persistence;

import entity.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    void getFirstAndLastName() {

        User user = new User();

        user.setFirstName("Wilson");
        user.setLastName("Wilsonson");

        String expectedFirstName = "Wilson";
        String expectedLastName = "Wilsonson";

        String actualFirstName = user.getFirstName();
        String actualLastName = user.getLastName();

        assertEquals(expectedFirstName, actualFirstName);
        assertEquals(expectedLastName, actualLastName);

    }

    @Test
    void getUsername() {

        User user = new User();

        user.setUserName("MrWorldwide");

        String expectedUsername = "MrWorldwide";

        String actualUsername = user.getUserName();

        assertEquals(expectedUsername, actualUsername);

    }

}
