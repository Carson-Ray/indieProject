package persistence;

import entity.Pokemon;
import entity.User;
import testUtils.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


/**
 * The type Pokemon dao test.
 */
class PokemonDaoTest {

    /**
     * The Dao.
     */
    PokemonDao dao;

    /**
     * Creating the dao.
     */
    @BeforeEach
    void setUp() {
        dao = new PokemonDao();

        Database database = Database.getInstance();
        database.runSQL("dump.sql");

    }

    /**
     * Gets all pokemon success.
     */
    @Test
    void getAllPokemonSuccess() {
        List<Pokemon> orders = dao.getAllPokemon();
        assertEquals(5, orders.size());
    }

    /**
     * Gets by id success.
     */
    @Test
    void getByIdSuccess() {
        Pokemon retrievedPokemon = dao.getById(1);
        assertNotNull(retrievedPokemon);
        assertEquals("Blissey", retrievedPokemon.getName());
    }

    /**
     * Insert success.
     */
    @Test
    void insertSuccess() {

        UserDao userDao = new UserDao();
        User user = userDao.getById(1);
        Pokemon newPokemon = new Pokemon("Garchomp", "All-Rounder", user);
        user.addPokemon(newPokemon);

        int id = dao.insert(newPokemon);

        assertNotEquals(0,id);
        Pokemon insertedPokemon = dao.getById(id);
        assertEquals("Garchomp", insertedPokemon.getName());
        assertNotNull(insertedPokemon.getUser());
        assertEquals("Carson", insertedPokemon.getUser().getFirstName());
        assertTrue(newPokemon.equals(insertedPokemon));
    }

    /**
     * Delete success.
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(3));
        assertNull(dao.getById(3));
    }

    /**
     * Update success.
     */
    @Test
    void updateSuccess() {
        String name = "Eldegoss";
        Pokemon pokemonToUpdate = dao.getById(1);
        pokemonToUpdate.setName(name);
        dao.saveOrUpdate(pokemonToUpdate);
        Pokemon retrievedPokemon = dao.getById(1);
        assertEquals(name, retrievedPokemon.getName());
    }

}
