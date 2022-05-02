package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This class holds the data to be returned to the user when the API is called.
 */
public class Response {

    private Map<String,String> error;
    private List<PokemonAPI> pokemonList;

    /**
     * Instantiates a new Response.
     */
    public Response() {
        pokemonList = new ArrayList<>();
    }

    /**
     * Insert a new definition entry into the response.
     *
     * @param entry the entry
     */
    public void insert(PokemonAPI entry) {
        pokemonList.add(entry);
    }

    /**
     * Replaces the list of definition entries with an error message.
     *
     * @param error the error
     */
    public void error(Map<String, String> error) {
        this.error = error;
        pokemonList = null;
    }

    /**
     * Gets error.
     *
     * @return the error
     */
    public Map<String, String> getError() {
        return error;
    }

    /**
     * Sets error.
     *
     * @param error the error
     */
    public void setError(Map<String, String> error) {
        this.error = error;
    }

    /**
     * Gets definitions.
     *
     * @return the definitions
     */
    public List<PokemonAPI> getPokemonList() {
        return pokemonList;
    }

    /**
     * Sets definitions.
     *
     * @param definitions the definitions
     */
    public void setPokemonList(List<PokemonAPI> pokemonList) {
        this.pokemonList = pokemonList;
    }

    @Override
    public String toString() {
        return "Response{" +
                "error=" + error +
                ", pokemonList=" + pokemonList +
                '}';
    }
}
