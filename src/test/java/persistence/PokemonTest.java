package persistence;

import entity.Pokemon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PokemonTest {

    @Test
    void getRole() {

        Pokemon pokemon = new Pokemon();

        pokemon.setRole("Speedster");

        String expectedRole = "Speedster";

        String actualRole = pokemon.getRole();

        assertEquals(expectedRole, actualRole);


    }

    @Test
    void getName() {

        Pokemon pokemon = new Pokemon();

        pokemon.setName("Hippowdon");

        String expectedName = "Hippowdon";

        String actualName = pokemon.getName();

        assertEquals(expectedName, actualName);

    }

}
