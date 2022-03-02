package persistence;

import entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * The type User dao.
 */
public class UserDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    /**
     * The Session factory.
     */
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    public User getById(int id) {
        Session session = sessionFactory.openSession();
        User User = session.get(User.class, id);
        session.close();
        return User;
    }

    /**
     * Save or update.
     *
     * @param User the user
     */
    public void saveOrUpdate(User User) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(User);
        transaction.commit();
        session.close();
    }

    /**
     * Insert new user.
     *
     * @param User the user
     * @return the int
     */
    public int insert(User User) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(User);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete.
     *
     * @param User the user
     */
    public void delete(User User) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(User);
        transaction.commit();
        session.close();
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    public List<User> getAll() {

        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery( User.class );
        Root<User> root = query.from( User.class );
        List<User> Users = session.createQuery( query ).getResultList();

        logger.debug("The list of Users " + Users);
        session.close();

        return Users;
    }
}
