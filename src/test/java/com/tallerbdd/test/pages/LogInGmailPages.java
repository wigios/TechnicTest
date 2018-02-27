package com.tallerbdd.test.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://mail.google.com")
public class LogInGmailPages extends PageObject {

    @FindBy(id = "identifierId")
    private WebElementFacade txtSearchTerms;
    @FindBy(id = "identifierNext")
    private WebElementFacade btnUserNext;
    @FindBy(name = "password")
    private WebElementFacade txtPassword;
    @FindBy(id = "passwordNext")
    private WebElementFacade btnPassNext;

    public LogInGmailPages(WebDriver driver){
        super(driver);
    }

    public void maximize(){
        getDriver().manage().window().maximize();
    }

    public void enterToMail(String keyword, String pass) {
        txtSearchTerms.sendKeys(keyword);
        btnUserNext.click();
        txtPassword.sendKeys(pass);
        btnPassNext.click();
    }
}
