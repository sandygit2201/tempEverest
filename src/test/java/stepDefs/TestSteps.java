package stepDefs;

import cucumber.api.java.en.Given;

public class TestSteps {
    @Given("print text {string}")
    public void printText(String strToPrint) {
        System.out.println("given string is "+strToPrint);

    }
}
