package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;


import pageObjects.LandingPage;

import utilities.Base;

import java.io.IOException;

public class LandingPageTest extends Base {
    public static Logger logger = LogManager.getLogger();
    WebDriver driver = initDriver();
    LandingPage landingPage = new LandingPage(driver);


    @BeforeTest
    public void setup() {
        logger.info("Driver is initialized");
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        logger.info("Navigated to the homepage.");
//        driver.get("http://qaclickacademy.com");
    }

    @Test(priority = 1)
    public void navigateToLogin() throws IOException {

        landingPage.getxButton().click();
        landingPage.getSignIn().click();
        driver.navigate().back();
    }

    @Test(priority = 2)
    public void featuredCourses() {
        String actualText = landingPage.getFeaturedCourses().getText();
        String expectedText = "FEATURED COURSES123";
        Assert.assertEquals(actualText, expectedText);
        logger.info("Text message is successfully validated. ");
    }

    @AfterTest
    private void teardown() {
        driver.quit();
    }

}
