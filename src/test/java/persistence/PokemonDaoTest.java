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
    GenericDao userDao;
    GenericDao pokeDao;

    /**
     * Creating the dao.
     */
    @BeforeEach
    void setUp() {
        pokeDao = new GenericDao(Pokemon.class);
        userDao = new GenericDao(User.class);

        Database database = Database.getInstance();
        database.runSQL("dump.sql");

    }

    /**
     * Gets all pokemon success.
     */
    @Test
    void getAllPokemonSuccess() {
        List<Pokemon> pokemon = pokeDao.getAll();
        assertEquals(5, pokemon.size());
    }

    /**
     * Gets by id success.
     */
    @Test
    void getByIdSuccess() {
        Pokemon retrievedPokemon = (Pokemon) pokeDao.getById(1);
        assertNotNull(retrievedPokemon);
        assertEquals("Blissey", retrievedPokemon.getName());
    }

    /**
     * Insert success.
     */
    @Test
    void insertSuccess() {

        User user = (User)userDao.getById(1);
        Pokemon newPokemon = new Pokemon("Garchomp", "All-Rounder", user);
        user.addPokemon(newPokemon);

        int id = pokeDao.insert(newPokemon);

        assertNotEquals(0,id);
        Pokemon insertedPokemon = (Pokemon) pokeDao.getById(id);
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
        pokeDao.delete(pokeDao.getById(3));

        GenericDao userDao = new GenericDao(User.class);

        assertNull(pokeDao.getById(3));
        assertNotNull(userDao.getById(3));
    }

    /**
     * Update success.
     */
    @Test
    void updateSuccess() {
        String name = "Eldegoss";
        Pokemon pokemonToUpdate = (Pokemon) pokeDao.getById(1);
        pokemonToUpdate.setName(name);
        pokeDao.saveOrUpdate(pokemonToUpdate);
        Pokemon retrievedPokemon = (Pokemon) pokeDao.getById(1);
        assertEquals(name, retrievedPokemon.getName());
    }

}
