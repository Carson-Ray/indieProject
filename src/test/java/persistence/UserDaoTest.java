package persistence;

import entity.Pokemon;
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

    UserDao dao;
    GenericDao genericDao;

    /**
     * Creating the dao.
     */
    @BeforeEach
    void setUp() {
        dao = new UserDao();
        genericDao = new GenericDao(User.class);

        Database database = Database.getInstance();
        database.runSQL("dump.sql");

    }

    /**
     * Verifies gets all users successfully.
     */
    @Test
    void getAllUsersSuccess() {
        List<User> users = genericDao.getAll();
        assertEquals(5, users.size());
    }

    /**
     * Verifies a user is returned correctly based on id search
     */
    @Test
    void getByIdSuccess() {
        User retrievedUser = (User)genericDao.getById(1);
        assertNotNull(retrievedUser);
        assertEquals("Carson", retrievedUser.getFirstName());
    }

    /**
     * Verify successful insert of a user
     */
    @Test
    void insertSuccess() {

        User newUser = new User("Pablo", "Picasso", "ppicasso", "testpass6");
        int id = genericDao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = (User)genericDao.getById(id);
        assertEquals(newUser, insertedUser);
    }

    /**
     * Verify successful insert of a user
     */
    @Test
    void insertWithPokemonSuccess() {

        User newUser = new User("Pablo", "Picasso", "ppicasso", "testpass6");

        Pokemon pokemon = new Pokemon("Blastoise", "Defender", newUser);

        newUser.addPokemon(pokemon);

        int id = genericDao.insert(newUser);

        assertNotEquals(0,id);
        User insertedUser = (User)genericDao.getById(id);
        assertEquals("Pablo", insertedUser.getFirstName());
        assertEquals(1, insertedUser.getPokemon().size());
        assertTrue(newUser.equals(insertedUser));
    }

    /**
     * Verify successful delete of user
     */
    @Test
    void deleteSuccess() {
        genericDao.delete(genericDao.getById(3));
        assertNull(genericDao.getById(3));
    }

    /**
     * Verify successful update of user
     */
    @Test
    void updateSuccess() {
        String newLastName = "Smith";
        User userToUpdate = (User)genericDao.getById(3);
        userToUpdate.setLastName(newLastName);
        genericDao.saveOrUpdate(userToUpdate);
        User retrievedUser = (User)genericDao.getById(3);
        assertEquals(userToUpdate, retrievedUser);
    }

}