package services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.PropertiesLoader;
import entity.*;

/**
 * This class gets definition entries from a DynamoDB database and returns them to the user as JSON objects.
 */
public class GetPokemon implements PropertiesLoader {

    private final Logger logger = LogManager.getLogger(this.getClass());
    /**
     * All pokemon.
     */
    List<APIPokemon> allPokemon;

    /**
     * Get pokemon.
     */
    public void GetPokemon() {}

    /**
     * Request api list.
     *
     * @return the list
     */
    public List<APIPokemon> requestAPI() {
        allPokemon = new ArrayList<>();
        callAPI();
        for(APIPokemon pokemon : allPokemon) {
            logger.info(pokemon);
        }
        return allPokemon;
    }

    /**
     * Call api.
     */
    public void callAPI() {
        try {
            URL url = new URL("https://z7nskb75ye.execute-api.us-east-2.amazonaws.com/getAll/pokemon");//your url i.e fetch data from .
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            JSONTokener tokener = new JSONTokener(br);
            JSONObject json = new JSONObject(tokener);
            JSONArray array = json.getJSONArray("APIPokemon");
            for (int i = 0; i < array.length(); i++) {
                String object = array.getJSONObject(i).toString();
                ObjectMapper mapper = new ObjectMapper();
                APIPokemon newMon = mapper.readValue(object, APIPokemon.class);
                logger.info(newMon.getPokemon());
                APIPokemon pokemon = new APIPokemon(
                        newMon.getRole(),
                        newMon.getPokemon(),
                        newMon.getAttack(),
                        newMon.getDefense(),
                        newMon.getHP(),
                        newMon.getSpAttack(),
                        newMon.getSpDefense()
                );
                logger.info(newMon);
                allPokemon.add(pokemon);
            }
            for(APIPokemon mon : allPokemon) {
                logger.info(mon.getPokemon());
            }
            conn.disconnect();

        } catch (Exception e) {
            logger.error("Exception in NetClientGet:- " + e);
        }

    }
}
