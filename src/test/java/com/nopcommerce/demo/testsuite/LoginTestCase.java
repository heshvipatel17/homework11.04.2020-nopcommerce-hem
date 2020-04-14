package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.loadproperty.LoadProperty;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.pages.MyAccountPage;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.annotations.Test;

public class LoginTestCase extends TestBase {

    //object creation
    LoadProperty loadProperty = new LoadProperty();
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    MyAccountPage myAccountPage = new MyAccountPage();

    String email = loadProperty.getProperty("email");
    String password = loadProperty.getProperty("password");
    String invalidemail = loadProperty.getProperty("invalidemail");

    /*
     * Test case 01
     *  User should navigate to log in page successfully
     */
    @Test(priority = 0, groups = {"Sanity", "Regression"})
    public void userShouldNavigateToLoginPageSuccessfully() {
        //click on Login link on HomePage
        homePage.clickOnLoginLink();
        //verify text on Login page
        loginPage.verifyTextWelcomePleaseSignIn("Welcome, Please Sign In!");
    }


    /*
     * Test case 02
     * User should log in successfully using valid credentials
     */
    @Test(priority = 1, groups = {"Smoke", "Regression"})
    public void userShouldLoginSuccessfully() throws InterruptedException {
        //click Login link on HomePage
        homePage.clickOnLoginLink();
        Thread.sleep(3000);
        //send text to email field on LoginPage same email as used for registration
        loginPage.sendTextToEmailField(email);
        Thread.sleep(3000);
        //send text to password field on LoginPage
        loginPage.sendTextToPasswordField(password);

        //click on login button on LoginPage
        loginPage.clickOnLoginButton();

        //Assert text on MyAccountPage
        myAccountPage.verifyTextMyAccount("My account");
    }

    @Test(priority = 2, groups = {"Regression"})
    public void userShouldNotLoginSuccessfullyWithInvalidCredintial() {
        //click Login link on HomePage
        homePage.clickOnLoginLink();
        //send text to email field on LoginPage same email as used for registration
        loginPage.sendTextToEmailField(invalidemail);
        //send text to password field on LoginPage
        loginPage.sendTextToPasswordField(password);
        //click on login button on LoginPage
        loginPage.clickOnLoginButton();

        //Assert text on Error Message
        loginPage.verifyLoginErrorMessage("Login was unsuccessful. Please correct the errors and try again.The credentials provided are incorrect");

    }
}
