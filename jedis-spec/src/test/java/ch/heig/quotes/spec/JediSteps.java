package ch.heig.quotes.spec;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openapitools.client.ApiException;
import org.openapitools.client.ApiResponse;
//import org.openapitools.client.api.QuotesEndPointApi;
//import org.openapitools.client.model.Quote;
import org.openapitools.client.model.Jedi;
import org.openapitools.client.api.JedisEndPointApi;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JediSteps {

    private final JedisEndPointApi api = new JedisEndPointApi();
    private Jedi jedi;
    private int statusCode;

    @Given("I have a jedi payload")
    public void i_have_a_jedi_payload() throws Throwable {
        jedi = new Jedi();
        jedi.setName("Obi-Wan Kenobi");
        jedi.setRank("Jedi-Knight");
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

    @Then("I receive a {int} status code")
    public void i_receive_a_status_code(int arg1) throws Throwable {
        assertEquals(arg1, statusCode);
    }
}