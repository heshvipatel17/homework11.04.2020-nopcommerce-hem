package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;

public class LoginPage extends Utility {

    //list of elements and their locations
    By welcomeTxt = By.cssSelector("div.page-title");
    By emailField = By.xpath("//input[@id='Email']");
    By passwordField = By.xpath("//input[@id='Password']");
    By loginBtn = By.cssSelector("input.button-1.login-button");
    By loginErrorTxt = By.cssSelector("div.message-error");

    //methods performing actions on elements
    public void verifyTextWelcomePleaseSignIn(String str) {
        verifyTextAssertMethod(welcomeTxt, str);
    }

    public void sendTextToEmailField(String str) {
        //explicit wait
        waitUntilElementToBeClickable(emailField, 20);
        sendTextToElement(emailField, str);
    }

    public void sendTextToPasswordField(String str) {
        waitUntilElementToBeClickable(passwordField, 20);
        sendTextToElement(passwordField, str);
    }

    public void clickOnLoginButton() {
        clickOnElement(loginBtn);
    }

    public void verifyLoginErrorMessage(String str) {
        verifyTextAssertMethod(loginErrorTxt, str);
    }

}
