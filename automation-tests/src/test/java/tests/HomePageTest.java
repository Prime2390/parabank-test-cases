package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    @Test

    public void shouldOpenHomePage() {

        String currentUrl = driver.getCurrentUrl();

        Assert.assertTrue(currentUrl.contains("parabank"));

    }

}
