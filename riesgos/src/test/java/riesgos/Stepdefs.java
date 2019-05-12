package riesgos;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.*;

class Riesgo {
    private String nombre;
    private double probabilidad, impacto, exposicion;
    private String exposicionCualitativa;

    public void setNombre(String n){nombre = n;}
    public void setProbabilidad(double p){probabilidad = p;}
    public void setImpacto(double i){impacto = i;}

    public String getNombre(){return nombre;}
    public double getProbabilidad(){return probabilidad;}
    public double getImpacto(){return impacto;}
    public double getExposicion(){return exposicion;}
    public String getExposicionCualitativa() {return exposicionCualitativa;}

    public void calcularExposicion(){
        exposicion = Math.round((probabilidad * impacto)*100.0)/100.0;
        if (exposicion <= 0.33) exposicionCualitativa = "Baja";
        else if (exposicion <= 0.66) exposicionCualitativa = "Media";
        else exposicionCualitativa = "Alta";
    }
}

public class Stepdefs {

    private Riesgo r;

    @Given("creo un riesgo nuevo")
    public void creo_un_riesgo_nuevo() {r = new Riesgo();}

    @When("ingreso un {string}, una {double} y un {double}")
    public void ingreso_un_una_y_un(String string, Double double1, Double double2) {
        r.setNombre(string);
        r.setProbabilidad(double1);
        r.setImpacto(double2);
        r.calcularExposicion();
    }

    @When("la probabilidad va entre {double} y {double}")
    public void la_probabilidad_va_entre_y(Double double1, Double double2) {
        assertTrue(r.getProbabilidad() >= double1);
        assertTrue(r.getProbabilidad() <= double2);
    }

    @When("el impacto va entre {double} y {double}")
    public void el_impacto_va_entre_y(Double double1, Double double2) {
        assertTrue(r.getImpacto() >= double1);
        assertTrue(r.getImpacto() <= double2);
    }

    @Then("ese riesgo pasa a tener ese {string}, esa {double} y ese {double}")
    public void ese_riesgo_pasa_a_tener_ese_esa_y_ese(String string, Double double1, Double double2) {
        assertEquals(r.getNombre(), string);
        assertTrue(r.getProbabilidad() == double1);
        assertTrue(r.getImpacto() == double2);
    }


    @Then("su {double} debe ser el producto de la probabilidad con el impacto y se denota {string}")
    public void su_debe_ser_el_producto_de_la_probabilidad_con_el_impacto_y_se_denota(Double double1, String string) {
        assertTrue(r.getExposicion() == double1);
        assertEquals(r.getExposicionCualitativa(), string);
    }

    @When("ingreso un {string}")
    public void ingreso_un(String string) {
        r.setNombre(string);
    }

    @Then("ese riesgo pasa a tener ese {string}")
    public void ese_riesgo_pasa_a_tener_ese(String string) {
        assertEquals(r.getNombre(), string);
    }

    @When("ingreso una probabilidad de {double}")
    public void ingreso_una_probabilidad_de(Double double1) {
        if ((double1 >= 0.0) && (double1 <= 1.0)) r.setProbabilidad(double1);
    }

    @Then("ese riesgo pasa a tener esa probabilidad de {double}")
    public void ese_riesgo_pasa_a_tener_esa_probabilidad_de(Double double1) {
        assertTrue(r.getProbabilidad() == double1);
    }

    @Then("ese riesgo no pasa a tener esa probabilidad de {double}")
    public void ese_riesgo_no_pasa_a_tener_esa_probabilidad_de(Double double1) {
        assertFalse(r.getProbabilidad() == double1);
    }

    @When("ingreso un impacto de {double}")
    public void ingreso_un_impacto_de(Double double1) {
        if ((double1 >= 0.0) && (double1 <= 1.0)) r.setImpacto(double1);
    }

    @Then("ese riesgo pasa a tener ese impacto de {double}")
    public void ese_riesgo_pasa_a_tener_ese_impacto_de(Double double1) {
        assertTrue(r.getImpacto() == double1);
    }

    @Then("ese riesgo no pasa a tener ese impacto de {double}")
    public void ese_riesgo_no_pasa_a_tener_ese_impacto_de(Double double1) {
        assertFalse(r.getImpacto() == double1);
    }

    @When("ingreso una probabilidad de {double} y un impacto de {double} y se calcula su exposicion")
    public void ingreso_una_probabilidad_de_y_un_impacto_de_y_se_calcula_su_exposicion(Double double1, Double double2) {
        if ((double1 >= 0.0) && (double1 <= 1.0)) r.setProbabilidad(double1);
        if ((double1 >= 0.0) && (double1 <= 1.0)) r.setImpacto(double2);
        r.calcularExposicion();
    }

    @Then("ese riesgo pasa a tener {double} de exposicion")
    public void ese_riesgo_pasa_a_tener_de_exposicion(Double double1) {
        assertTrue(r.getExposicion() == double1);
    }

}