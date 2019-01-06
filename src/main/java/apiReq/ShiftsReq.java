package apiReq;

import dataObjects.shifts.ShiftsReqDTO;
import dataObjects.shifts.ShiftsResDTO;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ShiftsReq extends BaseApiReq {

    private RequestSpecification httpRequest;
    private Response response;

    private Response getShifts(ShiftsReqDTO shiftsReqDTO) {

        RestAssured.baseURI = strBaseURI;

        httpRequest = RestAssured.given();
        response = (Response) httpRequest.header("Authorization", shiftsReqDTO.getToken())
                .param("startTime", shiftsReqDTO.getStartTime())
                .param("endTime", shiftsReqDTO.getEndTime())
                .get("/shifts");

        return response;
    }

    public List<ShiftsResDTO> getValidShifts(ShiftsReqDTO shiftsReqDTO) {

        response = getShifts(shiftsReqDTO);
        assertThat(response.getStatusCode()).isEqualTo(200);
        List<ShiftsResDTO> userShifts = response.then().extract().jsonPath().getList("", ShiftsResDTO.class);
        return userShifts;

    }

    public void printShifts(List<ShiftsResDTO> shifts) {
        for (ShiftsResDTO shift : shifts) {
            System.out.println(shift.getSubLocation().getName() + " at " + shift.getShiftPosition().getName());
            System.out.println(shift.getStartTime());
            System.out.println(shift.getEndTime());
            System.out.println("----------------------------------");
        }

        System.out.println("Total ShiftsReq for user:"+shifts.size());
    }


}
