import api.Authorisation;
import api.Shifts;
import cucumber.api.java.en.Given;
import dataObjects.auth.AuthorisationResDTO;
import dataObjects.shifts.ShiftsReqDTO;
import dataObjects.shifts.ShiftsResDTO;


import java.util.List;

public class Shifts_Steps {
    @Given("get shifts for user {string}")
    public void getShiftsForUser(String user) {



    }

    @Given("get shifts for user {string} from {string} to {string}")
    public void getShiftsForUserFromTo(String user, String startTime, String endTime) {

        AuthorisationResDTO authResponse = new Authorisation().getValidAuthToken(user);
        ShiftsReqDTO shiftsReqDTO = new ShiftsReqDTO();
        shiftsReqDTO.setToken(authResponse.getToken());
        shiftsReqDTO.setStartTime(startTime);
        shiftsReqDTO.setEndTime(endTime);

        List<ShiftsResDTO> userShifts = new Shifts().getValidShifts(shiftsReqDTO);

    }
}
