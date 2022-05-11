package entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * The type Api pokemon.
 */
public class APIPokemon {

	@JsonProperty("SpDefense")
	private String spDefense;

	@JsonProperty("HP")
	private String hp;

	@JsonProperty("SpAttack")
	private String spAttack;

	@JsonProperty("Attack")
	private String attack;

	@JsonProperty("Pokemon")
	private String pokemon;

	@JsonProperty("Defense")
	private String defense;

	@JsonProperty("Role")
	private String role;

	@JsonProperty("APIPokemon")
	private List<APIPokemon> aPIPokemon;

	/**
	 * Instantiates a new Api pokemon.
	 */
	public APIPokemon() {}

	/**
	 * Instantiates a new Api pokemon.
	 *
	 * @param role      the role
	 * @param pokemon   the pokemon
	 * @param attack    the attack
	 * @param defense   the defense
	 * @param hp        the hp
	 * @param spAttack  the sp attack
	 * @param spDefense the sp defense
	 */
	public APIPokemon(String role, String pokemon, String attack, String defense, String hp, String spAttack, String spDefense) {
		this.role = role;
		this.pokemon = pokemon;
		this.attack = attack;
		this.defense = defense;
		this.hp = hp;
		this.spAttack = spAttack;
		this.spDefense = spDefense;
	}

	/**
	 * Sets role.
	 *
	 * @param role the role
	 */
	public void setRole(String role) {this.role = role;}

	/**
	 * Gets role.
	 *
	 * @return the role
	 */
	public String getRole() {return role;}

	/**
	 * Set api pokemon.
	 *
	 * @param aPIPokemon the a pi pokemon
	 */
	public void setAPIPokemon(List<APIPokemon> aPIPokemon){
		this.aPIPokemon = aPIPokemon;
	}

	/**
	 * Get api pokemon list.
	 *
	 * @return the list
	 */
	public List<APIPokemon> getAPIPokemon(){
		return aPIPokemon;
	}

	/**
	 * Set sp defense.
	 *
	 * @param spDefense the sp defense
	 */
	public void setSpDefense(String spDefense){
		this.spDefense = spDefense;
	}

	/**
	 * Get sp defense string.
	 *
	 * @return the string
	 */
	public String getSpDefense(){
		return spDefense;
	}

	/**
	 * Set hp.
	 *
	 * @param hp the hp
	 */
	public void setHP(String hp){
		this.hp = hp;
	}

	/**
	 * Gets hp.
	 *
	 * @return the hp
	 */
	public String getHP() { return hp;}

	/**
	 * Set sp attack.
	 *
	 * @param spAttack the sp attack
	 */
	public void setSpAttack(String spAttack){
		this.spAttack = spAttack;
	}

	/**
	 * Get sp attack string.
	 *
	 * @return the string
	 */
	public String getSpAttack(){
		return spAttack;
	}

	/**
	 * Set attack.
	 *
	 * @param attack the attack
	 */
	public void setAttack(String attack){
		this.attack = attack;
	}

	/**
	 * Get attack string.
	 *
	 * @return the string
	 */
	public String getAttack(){
		return attack;
	}

	/**
	 * Set pokemon.
	 *
	 * @param pokemon the pokemon
	 */
	public void setPokemon(String pokemon){
		this.pokemon = pokemon;
	}

	/**
	 * Get pokemon string.
	 *
	 * @return the string
	 */
	public String getPokemon(){
		return pokemon;
	}

	/**
	 * Set defense.
	 *
	 * @param defense the defense
	 */
	public void setDefense(String defense){
		this.defense = defense;
	}

	/**
	 * Get defense string.
	 *
	 * @return the string
	 */
	public String getDefense(){
		return defense;
	}

	@Override
 	public String toString(){
		return "{" +
				"\'role\'='" + role + '\'' +
				", \'pokemon\'='" + pokemon + '\'' +
				", \'attack\'='" + attack + '\'' +
				", \'defense\'='" + defense + '\'' +
				", \'hp\'='" + hp + '\'' +
				", \'spAttack\'='" + spAttack + '\'' +
				", \'spDefense\'='" + spDefense + '\'' +
				'}';
		}
}