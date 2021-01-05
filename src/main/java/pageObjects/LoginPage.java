package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By email = By.id("user_email");
//    @FindBy(id = "user_email")
//    WebElement email;

    By passWord = By.id("user_password");
//    @FindBy(id = "user_password")
//    WebElement passWord;

    By loginBtn = By.name("commit");

    public WebElement getEmail() {
        return driver.findElement(email);
    }

    public WebElement getPassWord() {
        return driver.findElement(passWord);
    }
    public WebElement getLoginBtn() {
        return driver.findElement(loginBtn);
    }

}
