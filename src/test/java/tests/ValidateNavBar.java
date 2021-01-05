package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import utilities.Base;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidateNavBar extends Base {
    WebDriver driver = initDriver();
    LandingPage landingPage = new LandingPage(driver);

    @BeforeClass
    public void setup() {
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        landingPage.getxButton().click();
//        landingPage.getSignIn().click();
//        driver.navigate().back();
    }

    @Test
    public void validate()  {
    boolean navBarAssert = landingPage.getNavBar().isDisplayed();
        Assert.assertTrue(navBarAssert);

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
