package com.tallerbdd.test.definitions;

import com.tallerbdd.test.steps.ConsultaMailProcesoSuraSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class ConsultaMailProcesoSuraDefinitions {

    @Steps
    ConsultaMailProcesoSuraSteps consultaMailProcesoSuraSteps;

    @Given("el usuario ingresa a login de Gmail con cuenta con usuario '$email' y pass '$pass'")
    public void elusuarioingresaalogindeGmailconcuentaconusuarioypass(String email, String pass){
        consultaMailProcesoSuraSteps.isOnLoginPage();
        consultaMailProcesoSuraSteps.enterInBox(email, pass);
    }

    @When("el usuario esta en la bandeja de entrada busco que exista correo con remitente '$remitente'")
    public void Whenelusuarioestaenlabandejadeentradabuscoqueexistacorreoconremitente(String remitente){
        consultaMailProcesoSuraSteps.buscarCorreo(remitente);
    }

    @Then("se abre el correo entrante y se visualiza el texto con el paso a seguir en el proceso")
    public void seabreelcorreoentranteysevisualizaeltextoconelpasoaseguirenelproceso(){
        consultaMailProcesoSuraSteps.abrirMail();
        consultaMailProcesoSuraSteps.logout();
    }
}
