package sample;

import restAPI.dataObjects.auth.AuthorisationResDTO;
import restAPI.dataObjects.shifts.ShiftsReqDTO;
import dataStore.UserDTO;
import restAPI.dataObjects.shifts.ShiftsResDTO;
import gherkin.deps.com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import utils.ConfigReader;
import utils.UserDataReder;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class APISample {


     String strBaseURI = new ConfigReader().url();


    public AuthorisationResDTO getAuthResponse(UserDTO user) {

        RestAssured.baseURI = strBaseURI;
        JsonObject userData = new JsonObject();
        userData.addProperty("emailAddress", user.getEmailAddress());
        userData.addProperty("password", user.getPassword());
        RequestSpecification httpRequest = RestAssured.given();
        Response response = (Response) httpRequest.header("Content-Type", "application/json")
                .body(userData.toString())
                .post("/AuthorisationReq/token");

        JsonPath jsonPathEvaluator = response.jsonPath();

         AuthorisationResDTO authResponse = response.then().extract().jsonPath().getObject("",AuthorisationResDTO.class);

         assertThat(response.statusCode()).isEqualTo(201);

         authResponse.setToken("Bearer "+authResponse.getToken());

        return  authResponse;
    }

      public List<ShiftsResDTO> getShifts(ShiftsReqDTO shiftsGetDTO){

//        "https://appapi.dev.ynvr.se/shifts?startTime=2018-10-01T00:00:00&endTime=2018-11-04T23:59:59";

         RestAssured.baseURI = strBaseURI;

          RequestSpecification httpRequest = RestAssured.given();
          Response response = (Response) httpRequest.header("Authorization", shiftsGetDTO.getToken())
                  .param("startTime",shiftsGetDTO.getStartTime())
                  .param("endTime",shiftsGetDTO.getEndTime())
                  .get("/shifts");

          assertThat(response.statusCode()).isEqualTo(200);

          ShiftsResDTO shiftsResDTO = new ShiftsResDTO();

          System.out.println(response.toString());

          List<ShiftsResDTO> userShifts = response.then().extract().jsonPath().getList("",ShiftsResDTO.class);

          return userShifts;
      }



      @Test
      public void getShiftsDetails(){

        String userName = "sally";

        ShiftsReqDTO shiftsReqDTO = new ShiftsReqDTO();

        UserDTO userDTO = new UserDataReder().getUser(userName);

        AuthorisationResDTO authorisationResDTO = getAuthResponse(userDTO);

        shiftsReqDTO.setToken(authorisationResDTO.getToken());

        shiftsReqDTO.setStartTime("2019-01-01T00:00:00");
        shiftsReqDTO.setEndTime("2019-11-04T23:59:59");
        shiftsReqDTO.setUserName(userName);

        List<ShiftsResDTO> userShifts= getShifts(shiftsReqDTO);

        for (ShiftsResDTO shiftDetails:userShifts) {

            String Location = shiftDetails.getSubLocation().getName();
            String shiftPositon = shiftDetails.getShiftPosition().getName();


            System.out.println(Location + " at " + shiftPositon);
            System.out.println(shiftDetails.getStartTime());
            System.out.println(shiftDetails.getEndTime());
            System.out.println("----------------------------------");


        }

      }

}
