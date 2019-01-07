package features.stepDefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import dataStore.UserDTO;
import io.restassured.response.Response;
import restAPI.apiReq.AuthorisationReq;
import utils.UserDataReder;

import static org.assertj.core.api.Assertions.assertThat;

public class AuthorisationSteps {

    private Response response ;
    private AuthorisationReq authReq;
    private UserDTO userDTO;

    @Given("get Authorisation for user {string}")
    public void getAuthorisationForUser(String user) {

        userDTO = new UserDataReder().getUser(user);
        response = new AuthorisationReq().getAuthorisationResponse(userDTO);

    }

    @Then("Authorisation response status should be {int}")
    public void authorisationResponseStatusShouldBe(int expectedStatus) {

        assertThat(response.getStatusCode()).isEqualTo(expectedStatus);
    }
}
