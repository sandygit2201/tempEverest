package api;

import dataObjects.shifts.ShiftsReqDTO;
import dataObjects.shifts.ShiftsResDTO;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Shifts extends BaseApiReq {

    private Response getShifts(ShiftsReqDTO shiftsReqDTO){

        RestAssured.baseURI = strBaseURI;

        RequestSpecification httpRequest = RestAssured.given();
        Response response = (Response) httpRequest.header("Authorization", shiftsReqDTO.getToken())
                .param("startTime",shiftsReqDTO.getStartTime())
                .param("endTime",shiftsReqDTO.getEndTime())
                .get("/shifts");

        return response;
    }

    public List<ShiftsResDTO> getValidShifts(ShiftsReqDTO shiftsReqDTO){

        Response response = getShifts(shiftsReqDTO);
        assertThat(response.getStatusCode()).isEqualTo(200);
        List<ShiftsResDTO> userShifts = response.then().extract().jsonPath().getList("",ShiftsResDTO.class);
        return userShifts;

    }


}
