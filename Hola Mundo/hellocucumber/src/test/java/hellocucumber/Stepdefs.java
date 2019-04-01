package hellocucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.*;

class Saludador {
    static String saludar(String saludo, String persona) {
        return saludo + persona;
    }
}

public class Stepdefs {

    private String persona;
    private String saludo;

    @Given("quiero {string}")
    public void quiero(String string) {
        this.saludo = string;
    }

    @When("diga a {string} quiero saludar")
    public void diga_a_quiero_saludar(String string) {
        this.persona = string;
    }

    @Then("deberia ver {string}")
    public void deberia_ver(String string) {
        assertEquals(Saludador.saludar(saludo,persona),string);
    }
}
