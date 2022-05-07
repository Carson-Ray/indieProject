package services;

import org.json.JSONObject;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.apigateway.ApiGatewayClient;
import software.amazon.awssdk.services.apigateway.model.ApiGatewayException;
import software.amazon.awssdk.services.apigateway.model.GetMethodRequest;
import software.amazon.awssdk.services.apigateway.model.GetMethodResponse;
import software.amazon.awssdk.services.apigateway.model.MethodResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.PropertiesLoader;
import services.*;
import java.io.IOException;
import java.util.Properties;

/**
 * This class gets definition entries from a DynamoDB database and returns them to the user as JSON objects.
 */
public class GetPokemon implements PropertiesLoader {

    private final Logger logger = LogManager.getLogger(this.getClass());
    Properties properties;
    String API_ID;
    String RESOURCE_ID;
    String HTTP_METHOD;
    Region region = Region.US_EAST_2;

    public void GetAllPokemon() {

        ApiGatewayClient apiGateway = ApiGatewayClient.builder()
                .region(region)
                .build();

        try {
            GetMethodRequest methodRequest = GetMethodRequest.builder()
                    .httpMethod(HTTP_METHOD)
                    .restApiId(API_ID)
                    .resourceId(RESOURCE_ID)
                    .build();

            GetMethodResponse response = apiGateway.getMethod(methodRequest);

            Map<String, MethodResponse> details = response.methodResponses();
            List<APIPokemonItem> allPokemon = new ArrayList<>();
            for (Map.Entry<String,MethodResponse> entry : details.entrySet()) {
                System.out.println("Key = " + entry.getKey() +
                        ", Value = " + entry.getValue());
            }


        } catch (ApiGatewayException e) {
            System.err.println(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
        }

    private void loadProperties() {
        try {
            properties = loadProperties("/cognito.properties");
            API_ID = properties.getProperty("api.id");
            RESOURCE_ID = properties.getProperty("resource.id");
            HTTP_METHOD = properties.getProperty("http.method");
        } catch (IOException ioException) {
            logger.error("Cannot load properties..." + ioException.getMessage(), ioException);
        } catch (Exception e) {
            logger.error("Error loading properties" + e.getMessage(), e);
        }
    }


}
