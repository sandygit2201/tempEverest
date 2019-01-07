package restAPI.apiReq;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import restAPI.dataObjects.shifts.ShiftsReqDTO;
import restAPI.dataObjects.shifts.ShiftsResDTO;

import java.util.List;

public class ShiftsReq extends BaseApiReq {

    private RequestSpecification httpRequest;

    public Response getShiftsResponse(ShiftsReqDTO shiftsReqDTO) {

        RestAssured.baseURI = strBaseURI;

        httpRequest = RestAssured.given();
        Response response = (Response) httpRequest.header("Authorization", shiftsReqDTO.getToken())
                .param("startTime", shiftsReqDTO.getStartTime())
                .param("endTime", shiftsReqDTO.getEndTime())
                .get("/shifts");

        return response;
    }

    public List<ShiftsResDTO> getShiftsInfoFromResponse(Response response) {

        List<ShiftsResDTO> userShifts = response.then().extract().jsonPath().getList("", ShiftsResDTO.class);
        return userShifts;

    }

    public void printShifts(List<ShiftsResDTO> shifts) {
        for (ShiftsResDTO shift : shifts) {
            System.out.println(shift.getShiftPosition().getName() + " at " + shift.getSubLocation().getName() );
            System.out.println(shift.getStartTime());
            System.out.println(shift.getEndTime());
            System.out.println("----------------------------------");
        }

        System.out.println("Total ShiftsReq for user:"+shifts.size());
    }


}
