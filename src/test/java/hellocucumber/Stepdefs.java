package hellocucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import static org.junit.Assert.*;


public class Stepdefs {
    private String saludo;
    private String actualAnswer;

    @Given("^i say \"([^\"]*)\"$")
    public void today_is(String saludo) {
        this.saludo = saludo;
    }

    @When("^I ask what answer i get$")
    public void i_ask_whether_it_s_Friday_yet() {
        actualAnswer = "Hola mundo!";
    }

    @Then("^I should be told \"([^\"]*)\"$")
    public void i_should_be_told(String expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswer);
    }

}