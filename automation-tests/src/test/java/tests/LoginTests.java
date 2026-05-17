package tests;

import base.BaseTest;
import data.LoginData;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountsOverviewPage;
import pages.HomePage;

public class LoginTests extends BaseTest {
    @Test(description = "Poprawne logowanie")
    public void correctLogin() {
        HomePage homePage = new HomePage(driver);
        homePage.enterUsername(LoginData.VALID_USERNAME);
        homePage.enterPassword(LoginData.VALID_PASSWORD);
        homePage.clickLoginButton();

        AccountsOverviewPage accountsOverview = new AccountsOverviewPage(driver);

        Assert.assertEquals(accountsOverview.getWelcomeMessage(), LoginData.WELCOME_MESSAGE);

    }
    @Test(description = "Logowanie z pustymi polami")
    public void loginWithEmptyUsernameAndPassword() {
        HomePage homePage = new HomePage(driver);
        homePage.enterUsername(LoginData.EMPTY_USERNAME);
        homePage.enterPassword(LoginData.EMPTY_PASSWORD);
        homePage.clickLoginButton();


        Assert.assertEquals(homePage.getErrorMessage(), LoginData.ERROR_MESSAGE_EMPTY_DATA);
    }
    @Test(description = "Logowanie z nieprawidłowym hasłem")
    public void loginWithInvalidPassword() {
        HomePage homePage = new HomePage(driver);
        homePage.enterUsername(LoginData.VALID_USERNAME);
        homePage.enterPassword(LoginData.INVALID_PASSWORD);
        homePage.clickLoginButton();

        Assert.assertEquals(homePage.getErrorMessage(), LoginData.ERROR_MESSAGE_INVALID_DATA);
    }

    @Test(description = "Logowanie z nieprawidłowym loginem")
    public void loginWithInvalidLogin() {
        HomePage homePage = new HomePage(driver);
        homePage.enterUsername(LoginData.INVALID_USERNAME);
        homePage.enterPassword(LoginData.VALID_PASSWORD);
        homePage.clickLoginButton();

        Assert.assertEquals(homePage.getErrorMessage(), LoginData.ERROR_MESSAGE_INVALID_DATA);
    }
}
