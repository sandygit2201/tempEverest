package restAPI.apiReq;

/**
 * @author sandeep
 */

import dataStore.UserDTO;
import restAPI.dataObjects.auth.AuthorisationResDTO;
import gherkin.deps.com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.UserDataReder;

import static org.assertj.core.api.Assertions.assertThat;


public class AuthorisationReq extends BaseApiReq {


    public Response getAuthorisationResponse(UserDTO user) {

        RestAssured.baseURI = strBaseURI;
        JsonObject userData = new JsonObject();
        userData.addProperty("emailAddress", user.getEmailAddress().trim());
        userData.addProperty("password", user.getPassword().trim());
        RequestSpecification httpRequest = RestAssured.given();
        Response response = (Response) httpRequest.
                header("Content-Type", "application/json")
                .body(userData.toString())
                .post("/Authorisation/token");

        return response;
    }

    public AuthorisationResDTO getValidAuthToken(String userName) {

        UserDTO userData = new UserDataReder().getUser(userName);
        Response response = getAuthorisationResponse(userData);
        assertThat(response.getStatusCode()).isEqualTo(201);
        JsonPath jsonPathEvaluator = response.jsonPath();
        AuthorisationResDTO authResponse = response.then().extract().jsonPath().getObject("", AuthorisationResDTO.class);
        authResponse.setToken("Bearer " + authResponse.getToken());

        return authResponse;
    }


}
