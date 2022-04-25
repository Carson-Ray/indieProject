package persistence;

import entity.Pokemon;
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

}
