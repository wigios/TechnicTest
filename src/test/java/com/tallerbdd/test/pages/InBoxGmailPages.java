package com.tallerbdd.test.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@DefaultUrl("https://mail.google.com")
public class InBoxGmailPages extends PageObject {

    @FindBy(partialLinkText = "Recibidos")
    private WebElementFacade btnRecibidos;
    @FindBy(xpath = "//div[2]/div/div[3]/div/div/div/div/div/div/div[2]/div[5]/div")
    private WebElementFacade txtBody;
    @FindBy(xpath = "//td[4]/span")
    private WebElementFacade btnEnviarImportantes;
    @FindBy(css = "span.bofITb")
    private WebElementFacade txtMensajeTranslado;
    @FindBy(css = "span.gb_ab.gbii")
    private WebElementFacade btnProfileUser;
    @FindBy(linkText = "Salir")
    private WebElementFacade btnExit;
    @FindBy(xpath = "//img")
    private WebElementFacade imagen;


    private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";


    public InBoxGmailPages(WebDriver driver) {
        super(driver);
    }

    public void espera() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean buscarPorRemitente(String remitente) {

        validateEmail(remitente);
        btnRecibidos.click();

        espera();
        By selEmail = By.xpath("(//span[@email='" + remitente + "'])[2]");

        WebElementFacade email = find(selEmail);

        if (getDriver().findElements(selEmail).size() > 0) {
            email.findElement(selEmail).click();
            return true;
        } else {
            logout();
            return false;
        }
    }

    public boolean abrirMail() {
        btnEnviarImportantes.click();
        String mensajeTranslado = txtMensajeTranslado.getText();
        System.out.println("------------------------------------------------------");
        System.out.println("Este es el cuerpo del mensaje: " + txtBody.getText());
        System.out.println("------------------------------------------------------");
        return mensajeTranslado.equalsIgnoreCase("Se ha archivado la conversación.");
    }

    public void logout() {
        btnProfileUser.click();
        btnExit.click();
    }

    public static boolean validateEmail(String email) {

        // Compiles the given regular expression into a pattern.
        Pattern pattern = Pattern.compile(PATTERN_EMAIL);

        // Match the given input against this pattern
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();

    }
}
