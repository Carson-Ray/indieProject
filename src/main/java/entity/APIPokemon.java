package entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

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

	public APIPokemon() {}

	public APIPokemon(String role, String pokemon, String attack, String defense, String hp, String spAttack, String spDefense) {
		this.role = role;
		this.pokemon = pokemon;
		this.attack = attack;
		this.defense = defense;
		this.hp = hp;
		this.spAttack = spAttack;
		this.spDefense = spDefense;
	}

	public void setRole(String role) {this.role = role;}

	public String getRole() {return role;}

	public void setAPIPokemon(List<APIPokemon> aPIPokemon){
		this.aPIPokemon = aPIPokemon;
	}

	public List<APIPokemon> getAPIPokemon(){
		return aPIPokemon;
	}

	public void setSpDefense(String spDefense){
		this.spDefense = spDefense;
	}

	public String getSpDefense(){
		return spDefense;
	}

	public void setHP(String hp){
		this.hp = hp;
	}

	public String getHP() { return hp;}

	public void setSpAttack(String spAttack){
		this.spAttack = spAttack;
	}

	public String getSpAttack(){
		return spAttack;
	}

	public void setAttack(String attack){
		this.attack = attack;
	}

	public String getAttack(){
		return attack;
	}

	public void setPokemon(String pokemon){
		this.pokemon = pokemon;
	}

	public String getPokemon(){
		return pokemon;
	}

	public void setDefense(String defense){
		this.defense = defense;
	}

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