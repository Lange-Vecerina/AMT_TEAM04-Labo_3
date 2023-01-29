package ch.heig.quotes.spec;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openapitools.client.ApiException;
import org.openapitools.client.ApiResponse;
//import org.openapitools.client.api.QuotesEndPointApi;
//import org.openapitools.client.model.Quote;
import org.openapitools.client.model.Lightsaber;
import org.openapitools.client.api.LightsabersEndPointApi;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LigthsaberSteps {
    private final LightsabersEndPointApi api = new LightsabersEndPointApi();
    private Lightsaber lightsaber;
    private int statusCode;

    @Given("I have a lightsaber payload")
    public void i_have_a_lightsaber_payload() throws Throwable {
        lightsaber = new Lightsaber();
        lightsaber.setColor("purple");
    }

    @When("I POST it to the \\/lightsabers endpoint")
    public void i_POST_it_to_the_lightsabers_endpoint() throws Throwable {
        try {
            ApiResponse response = api.addLightsaberWithHttpInfo(lightsaber);
            statusCode = response.getStatusCode();
        } catch (ApiException e) {
            statusCode = e.getCode();
            System.out.println("=======================");
            System.out.println("===== Error: " + e.getMessage());
            System.out.println("=======================");
        }
        /*ApiResponse response = api.addLightsaberWithHttpInfo(lightsaber);
        statusCode = response.getStatusCode();*/
    }
    @Then("I receive a {int} status code for the lightsaber")
    public void i_receive_a_status_code_for_the_lightsaber(int arg1) throws Throwable {
        assertEquals(arg1, statusCode);
    }
}
