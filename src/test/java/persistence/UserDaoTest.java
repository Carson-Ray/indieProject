package persistence;

import entity.UserPokemon;
import entity.User;
import testUtils.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type User dao test.
 */
class UserDaoTest {

    GenericDao pokeDao;
    GenericDao userDao;

    /**
     * Creating the dao.
     */
    @BeforeEach
    void setUp() {
        userDao = new GenericDao(User.class);
        pokeDao = new GenericDao(UserPokemon.class);

        Database database = Database.getInstance();
        database.runSQL("dump.sql");

    }

    /**
     * Verifies gets all users successfully.
     */
    @Test
    void getAllUsersSuccess() {
        List<User> users = userDao.getAll();
        assertEquals(5, users.size());
    }

    /**
     * Verifies a user is returned correctly based on id search
     */
    @Test
    void getByIdSuccess() {
        User retrievedUser = (User) userDao.getById(1);
        assertNotNull(retrievedUser);
        assertEquals("Carson", retrievedUser.getFirstName());
    }

    /**
     * Verify successful insert of a user
     */
    @Test
    void insertSuccess() {

        User newUser = new User("Pablo", "Picasso", "ppicasso");
        int id = userDao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = (User) userDao.getById(id);
        assertEquals(newUser, insertedUser);
    }

    /**
     * Verify successful insert of a user
     */
    @Test
    void insertWithPokemonSuccess() {

        User newUser = new User("Pablo", "Picasso", "ppicasso");

        UserPokemon pokemon = new UserPokemon("Blastoise", "Defender", newUser);

        newUser.addPokemon(pokemon);

        int id = userDao.insert(newUser);

        assertNotEquals(0,id);
        User insertedUser = (User) userDao.getById(id);
        assertEquals("Pablo", insertedUser.getFirstName());
        assertEquals(1, insertedUser.getPokemon().size());
        assertTrue(newUser.equals(insertedUser));
    }

    /**
     * Verify successful delete of user
     */
    @Test
    void deleteSuccess() {
        userDao.delete(userDao.getById(3));

        assertNull(pokeDao.getById(3));
        assertNull(userDao.getById(3));
    }

    /**
     * Verify successful update of user
     */
    @Test
    void updateSuccess() {
        String newLastName = "Smith";
        User userToUpdate = (User) userDao.getById(3);
        userToUpdate.setLastName(newLastName);
        userDao.saveOrUpdate(userToUpdate);
        User retrievedUser = (User) userDao.getById(3);
        assertEquals(userToUpdate, retrievedUser);
    }

}