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
    List<APIPokemon> allPokemon;

    public static void main(String[] args) {
        GetPokemon test = new GetPokemon();
        test.requestAPI();
    }

    public void GetPokemon() {}

    public List<APIPokemon> requestAPI() {
        allPokemon = new ArrayList<>();
        callAPI();
        for(APIPokemon pokemon : allPokemon) {
            logger.info(pokemon);
        }
        return allPokemon;
    }

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
//                logger.info(newMon.getPokemon());
                APIPokemon pokemon = new APIPokemon(
                        newMon.getRole(),
                        newMon.getPokemon(),
                        newMon.getAttack(),
                        newMon.getDefense(),
                        newMon.getHP(),
                        newMon.getSpAttack(),
                        newMon.getSpDefense()
                );
                //logger.info(newMon);
                allPokemon.add(pokemon);
            }
            for(APIPokemon mon : allPokemon) {
//                logger.info(mon.getPokemon());
            }
            conn.disconnect();

        } catch (Exception e) {
            logger.error("Exception in NetClientGet:- " + e);
        }

    }

//        public void GetAllPokemon() {
//        loadProperties();
//        ApiGatewayClient apiGateway = ApiGatewayClient.builder()
//                .region(region)
//                .build();
//
//        try {
//            GetMethodRequest methodRequest = GetMethodRequest.builder()
//                    .httpMethod(properties.getProperty("http.method"))
//                    .restApiId(properties.getProperty("api.id"))
//                    .resourceId(properties.getProperty("resource.id"))
//                    .build();
//
//            GetMethodResponse response = apiGateway.getMethod(methodRequest);
//            Map<String, String> map = response.requestModels();
//            for (Map.Entry<String, String> mapping : map.entrySet()) {
//                logger.info(mapping.getValue());
//            }
//
//            Map<String, MethodResponse> details = response.methodResponses();
//            for (Map.Entry<String,MethodResponse> entry : details.entrySet()) {
//                logger.info("Key = " + entry.getKey() +
//                        ", Value = " + entry.getValue());
//                List<Object> list =  new ArrayList();
//                list.add(entry.getValue().responseModels().values().toArray());
//                for (Object item : list) {
//                    logger.info(item.toString());
//                }
//            }
//
//
//        } catch (ApiGatewayException e) {
//            logger.error(e.awsErrorDetails().errorMessage());
//            System.exit(1);
//        }
//        }

//    private void loadProperties() {
//        try {
//            properties = loadProperties("/cognito.properties");
//            API_ID = properties.getProperty("api.id");
//            RESOURCE_ID = properties.getProperty("resource.id");
//            HTTP_METHOD = properties.getProperty("http.method");
//        } catch (IOException ioException) {
//            logger.error("Cannot load properties..." + ioException.getMessage(), ioException);
//        } catch (Exception e) {
//            logger.error("Error loading properties" + e.getMessage(), e);
//        }
//    }


}
