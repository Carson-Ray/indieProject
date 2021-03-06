package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * A class to represent a user.
 *
 * @author pwaite
 */
@Entity(name = "Pokemon")
@Table(name = "pokemon")
public class UserPokemon {
    @Column(name = "name")
    private String name;

    @Column(name = "role")
    private String role;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id")
    private int id;

    @ManyToOne
    private User user;

    /**
     * Instantiates a new UserPokemon.
     */
    public UserPokemon() {
    }

    /**
     * Instantiates a new User pokemon.
     *
     * @param name the name
     * @param role the role
     * @param user the user
     */
    public UserPokemon(String name, String role, User user) {
        this.name = name;
        this.role = role;
        this.user = user;
    }

    /**
     * Get name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the first name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets role
     *
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets role
     *
     * @param role the role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Gets user
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserPokemon{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", user='" + user + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPokemon pokemon = (UserPokemon) o;
        return id == pokemon.id &&
                Objects.equals(name, pokemon.name) &&
                Objects.equals(role, pokemon.role) &&
                Objects.equals(user, pokemon.user);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, role, user, id);
    }
}
