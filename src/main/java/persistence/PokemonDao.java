package persistence;

import entity.Pokemon;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * The type Pokemon dao.
 */
public class PokemonDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    /**
     * The Session factory.
     */
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Gets all Pokemon.
     *
     * @return the all Pokemon
     */
    public List<Pokemon> getAllPokemon() {

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Pokemon> query = builder.createQuery(Pokemon.class);
        Root<Pokemon> root = query.from(Pokemon.class);
        List<Pokemon> pokemonList = session.createQuery(query).getResultList();
        session.close();
        return pokemonList;
    }

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    public Pokemon getById(int id) {
        Session session = sessionFactory.openSession();
        Pokemon pokemon = session.get(Pokemon.class, id);
        session.close();
        return pokemon;
    }

    /**
     * Save or update.
     *
     * @param pokemon the pokemon
     */
    public void saveOrUpdate(Pokemon pokemon) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(pokemon);
        transaction.commit();
        session.close();
    }

    /**
     * Insert int.
     *
     * @param pokemon the pokemon
     * @return the int
     */
    public int insert(Pokemon pokemon) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(pokemon);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete.
     *
     * @param pokemon the pokemon
     */
    public void delete(Pokemon pokemon) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(pokemon);
        transaction.commit();
        session.close();
    }

}

