package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import utilities.Base;

import java.io.IOException;

public class LoginPageTest extends Base {
    WebDriver driver = initDriver();

    LandingPage landingPage = new LandingPage(driver);

    LoginPage loginPage = new LoginPage(driver);

    @BeforeTest
    public void setup() {
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        landingPage.getxButton().click();
        landingPage.getSignIn().click();
    }

    @Test(dataProvider = "userInfo", priority = 2)
    public void login(String user, String pass, String text) throws InterruptedException {

        loginPage.getEmail().sendKeys(user);

        loginPage.getPassWord().sendKeys(pass);

        loginPage.getLoginBtn().click();
        System.out.println(text);

    }

    @DataProvider(name = "userInfo")
    public static Object[][] getData() {
        Object[][] data = new Object[2][3];
        data[0][0] = "dere@b.c";
        data[0][1] = "32456";
        data[0][2] = "text 1 for printing";
        data[1][0] = "tepe@m.s";
        data[1][1] = "12345";
        data[1][2] = "Text 2 for printing";

        return data;
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
