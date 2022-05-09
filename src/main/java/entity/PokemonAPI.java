package entity;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;

import java.util.Map;

public class PokemonAPI {

    public PokemonAPI(String role, String pokemon, String attack, String defense, String hp, String spAttack, String spDefense) {
        this.role = role;
        this.pokemon = pokemon;
        this.attack = attack;
        this.defense = defense;
        this.hp = hp;
        this.spAttack = spAttack;
        this.spDefense = spDefense;
    }

    private String role;

    private String pokemon;

    private String attack;

    private String defense;

    private String hp;

    private String spAttack;

    private String spDefense;

    public PokemonAPI() {

    }

    public PokemonAPI(Map<String, AttributeValue> input) {
        this.role = input.get("Role").getS();
        this.pokemon = input.get("Pokemon").getS();
        this.attack = input.get("Attack").getS();
        this.defense = input.get("Defense").getS();
        this.hp = input.get("HP").getS();
        this.spAttack = input.get("SpAttack").getS();
        this.spDefense = input.get("SpDefense").getS();
    }

    public String getRole() {return role;}

    public void setRole() {this.role = role;}

    public String getPokemon() {
        return pokemon;
    }

    public void setPokemon(String pokemon) {
        this.pokemon = pokemon;
    }

    public String getAttack() {
        return attack;
    }

    public void setAttack(String attack) {
        this.attack = attack;
    }

    public String getDefense() {
        return defense;
    }

    public void setDefense(String defense) {
        this.defense = defense;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getSpAttack() {
        return spAttack;
    }

    public void setSpAttack(String spAttack) {
        this.spAttack = spAttack;
    }

    public String getSpDefense() {
        return spDefense;
    }

    public void setSpDefense(String spDefense) {
        this.spDefense = spDefense;
    }

    @Override
    public String toString() {
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
