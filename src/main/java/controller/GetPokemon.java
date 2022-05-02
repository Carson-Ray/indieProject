package controller;

import com.amazonaws.Request;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import entity.*;
import java.util.HashMap;
import java.util.Map;

/**
 * This class gets definition entries from a DynamoDB database and returns them to the user as JSON objects.
 */
public class GetPokemon implements RequestHandler<Request,Object> {

    /**
     * The Client for accessing the database.
     */
    AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
            .withRegion("us-east-2")
            .build();

    /**
     * Message data to return in case of an error.
     */
    Map<String,String> error;

    /**
     * Receives a request object with the search terms for the API,
     * and returns a response with the requested data.
     * @param request The API Request.
     * @param context The context provided by Lambda.
     * @return The API Response.
     */
    @Override
    public Response handleRequest(Request request, Context context) {
        PokemonAPI entry;
        Response response = new Response();
        error = new HashMap<>();

        ScanRequest scanRequest = new ScanRequest()
                .withTableName("unite_battler");

        ScanResult result = client.scan(scanRequest);

        for (Map<String, AttributeValue> item : result.getItems()){
            entry = new PokemonAPI(item);
            response.insert(entry);
        }

        return response;
    }
}
