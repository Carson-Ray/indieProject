package services;

import com.fasterxml.jackson.annotation.JsonProperty;

public class APIPokemonItem{

	@JsonProperty("SpDefense")
	private String spDefense;

	@JsonProperty("HP")
	private String hP;

	@JsonProperty("SpAttack")
	private String spAttack;

	@JsonProperty("Attack")
	private String attack;

	@JsonProperty("Pokemon")
	private String pokemon;

	@JsonProperty("Defense")
	private String defense;

	public void setSpDefense(String spDefense){
		this.spDefense = spDefense;
	}

	public String getSpDefense(){
		return spDefense;
	}

	public void setHP(String hP){
		this.hP = hP;
	}

	public String getHP(){
		return hP;
	}

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
		return 
			"APIPokemonItem{" + 
			"spDefense = '" + spDefense + '\'' + 
			",hP = '" + hP + '\'' + 
			",spAttack = '" + spAttack + '\'' + 
			",attack = '" + attack + '\'' + 
			",pokemon = '" + pokemon + '\'' + 
			",defense = '" + defense + '\'' + 
			"}";
		}
}