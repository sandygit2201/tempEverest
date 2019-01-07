package features.stepDefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import restAPI.apiReq.AuthorisationReq;
import restAPI.apiReq.ShiftsReq;
import restAPI.dataObjects.auth.AuthorisationResDTO;
import restAPI.dataObjects.shifts.ShiftsReqDTO;
import restAPI.dataObjects.shifts.ShiftsResDTO;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Shifts_Steps {

    private Response response;
    private List<ShiftsResDTO> userShifts;
    private ShiftsReq shiftsReqObj = new ShiftsReq();

    @Given("get shifts for user {string} from {string} to {string}")
    public void getShiftsForUserFromTo(String user, String startTime, String endTime) {

        AuthorisationResDTO authResponse = new AuthorisationReq().getValidAuthToken(user);
        ShiftsReqDTO shiftsReqDTO = new ShiftsReqDTO();
        shiftsReqDTO.setToken(authResponse.getToken());
        shiftsReqDTO.setStartTime(startTime);
        shiftsReqDTO.setEndTime(endTime);
        response = shiftsReqObj.getShiftsResponse(shiftsReqDTO);

    }

    @Then("shifts response status should be {int}")
    public void shiftsResponseStatusShouldBe(int expectedStatus) {

        assertThat(response.getStatusCode()).isEqualTo(expectedStatus);

    }

    @Then("print shifts details")
    public void printShiftsDetails() {
        userShifts = shiftsReqObj.getShiftsInfoFromResponse(response);
        shiftsReqObj.printShifts(userShifts);

    }
}
