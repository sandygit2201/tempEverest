package features.stepDefs;

import apiReq.AuthorisationReq;
import apiReq.ShiftsReq;
import cucumber.api.java.en.Given;
import dataObjects.auth.AuthorisationResDTO;
import dataObjects.shifts.ShiftsReqDTO;
import dataObjects.shifts.ShiftsResDTO;

import java.util.List;

public class Shifts_Steps {

    @Given("get shifts for user {string} from {string} to {string}")
    public void getShiftsForUserFromTo(String user, String startTime, String endTime) {

        ShiftsReq shiftsObj = new ShiftsReq();
        AuthorisationResDTO authResponse = new AuthorisationReq().getValidAuthToken(user);
        ShiftsReqDTO shiftsReqDTO = new ShiftsReqDTO();
        shiftsReqDTO.setToken(authResponse.getToken());
        shiftsReqDTO.setStartTime(startTime);
        shiftsReqDTO.setEndTime(endTime);

        List<ShiftsResDTO> userShifts = shiftsObj.getValidShifts(shiftsReqDTO);
        shiftsObj.printShifts(userShifts);


    }
}
