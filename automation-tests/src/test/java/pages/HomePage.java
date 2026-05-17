package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    private final By registerButton = By.xpath("//*[@id=\"loginPanel\"]/p[2]/a");
    private final By usernameField = By.name("username");
    private final By passwordField = By.name("password");
    private final By loginButton = By.cssSelector("input[value='Log In']");
    private final By errorMessage = By.className("error");



    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickRegisterButton() {
        click(registerButton);
    }

    public void enterUsername (String username) {
        type(usernameField, username);
    }

    public void enterPassword (String password) {
        type(passwordField, password);
    }
    public void clickLoginButton() {
        click(loginButton);
    }

    public String getErrorMessage() {

       return getText(errorMessage);
    }

}
