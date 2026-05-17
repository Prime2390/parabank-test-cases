package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountsOverviewPage extends BasePage {

    private final By welcomeMessage = By.className("smallText");

    public AccountsOverviewPage(WebDriver driver) {
        super(driver);
    }

    public String getWelcomeMessage() {
      return getText(welcomeMessage);
    }
}
