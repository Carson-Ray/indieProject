package persistence;

import entity.UserPokemon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PokemonTest {

    @Test
    void getRole() {

        UserPokemon pokemon = new UserPokemon();

        pokemon.setRole("Speedster");

        String expectedRole = "Speedster";

        String actualRole = pokemon.getRole();

        assertEquals(expectedRole, actualRole);


    }

    @Test
    void getName() {

        UserPokemon pokemon = new UserPokemon();

        pokemon.setName("Hippowdon");

        String expectedName = "Hippowdon";

        String actualName = pokemon.getName();

        assertEquals(expectedName, actualName);

    }

}
