package com.tallerbdd.test.steps;

import com.tallerbdd.test.pages.InBoxGmailPages;
import com.tallerbdd.test.pages.LogInGmailPages;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class ConsultaMailProcesoSuraSteps {

    LogInGmailPages logInGmailPages;
    InBoxGmailPages inBoxGmailPages;

    @Step
    public void isOnLoginPage() {
        logInGmailPages.maximize();
        logInGmailPages.open();
    }

    @Step
    public void enterInBox(String email, String pass) {
        logInGmailPages.enterToMail(email, pass);
    }

    @Step
    public void buscarCorreo(String remitente) {
        Assert.assertTrue("Nada que llega mensaje de correo "+remitente,
                inBoxGmailPages.buscarPorRemitente(remitente));
    }

    @Step
    public void abrirMail() {
        Assert.assertTrue("ocurrió un problema y mensaje no fué archivado ",
                inBoxGmailPages.abrirMail());
    }

    @Step
    public void logout() {
        inBoxGmailPages.logout();
    }

}
