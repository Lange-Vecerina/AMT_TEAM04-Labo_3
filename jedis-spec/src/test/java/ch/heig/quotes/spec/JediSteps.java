package ch.heig.quotes.spec;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openapitools.client.ApiException;
import org.openapitools.client.ApiResponse;
import org.openapitools.client.model.Jedi;
import org.openapitools.client.api.JedisEndPointApi;
import org.openapitools.client.model.Lightsaber;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JediSteps {

    private final JedisEndPointApi api = new JedisEndPointApi();
    private Jedi jedi;
    private Lightsaber lightsaber;
    private int statusCode;

    @Given("I have a jedi payload")
    public void i_have_a_jedi_payload() throws Throwable {
        jedi = new Jedi();
        jedi.setName("Mace Windu");
        jedi.setRank("jedi-master");
    }

    @Given("I have a lightsaber payload for the jedi")
    public void i_have_a_lightsaber_payload_for_the_jedi() throws Throwable {
        lightsaber = new Lightsaber();
        lightsaber.setColor("purple");
    }

    @When("I POST it to the \\/jedis endpoint")
    public void i_POST_it_to_the_jedis_endpoint() throws Throwable {
        try {
            ApiResponse response = api.addJediWithHttpInfo(jedi);
            statusCode = response.getStatusCode();
        } catch (ApiException e) {
            statusCode = e.getCode();
        }
    }

    @When("I PUT the lightsaber payload to the \\/jedis\\/ {int} \\/lightsabers endpoint")
    public void i_PUT_the_lightsaber_payload_to_the_jedis_lightsabers_endpoint(int arg1) throws Throwable {
        try {
            ApiResponse response = api.addLightsaberToJediWithHttpInfo(arg1, lightsaber);
            statusCode = response.getStatusCode();
        } catch (ApiException e) {
            statusCode = e.getCode();
        }
    }

    @When("I GET the jedi payload from the \\/jedis\\/ {int} endpoint")
    public void iGETTheJediPayloadFromTheJedisEndpoint(int arg0) {
        try {
            ApiResponse response = api.getJediWithHttpInfo(arg0);
            statusCode = response.getStatusCode();
        } catch (ApiException e) {
            statusCode = e.getCode();
        }
    }

    @When("I GET the lightsaber payload from the \\/jedis\\/ {int} \\/lightsabers endpoint")
    public void iGETTheLightsaberPayloadFromTheJedisLightsabersEndpoint(int arg0) {
        try {
            ApiResponse response = api.getLightsabersOfJediWithHttpInfo(arg0);
            statusCode = response.getStatusCode();
        } catch (ApiException e) {
            statusCode = e.getCode();
        }
    }

    @Then("I receive a {int} status code")
    public void i_receive_a_status_code(int arg1) throws Throwable {
        assertEquals(arg1, statusCode);
    }


}