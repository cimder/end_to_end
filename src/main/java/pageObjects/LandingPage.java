package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Base;



public class LandingPage {
    public WebDriver driver ;

    public LandingPage(WebDriver driver){
        this.driver = driver;
    }


    By xButton = By.cssSelector("div[style*='position: absolute; inset: 0px; box-']");
    By signIn = By.cssSelector("a[href*='sign_in']");
    By featuredCourses = By.cssSelector("section[id='content'] h2");
    By navigatingBar = By.cssSelector("ul[class='nav navbar-nav navbar-right']>li>a");

    public WebElement getxButton() {
        return driver.findElement(xButton);
    }

    public WebElement getSignIn() {
        return driver.findElement(signIn);
    }

    public WebElement getFeaturedCourses(){
        return driver.findElement(featuredCourses);
    }
    public WebElement getNavBar(){
        return driver.findElement(navigatingBar);
    }



//    @FindBy(xpath = "//button[text()='NO THANKS']")
//    public WebElement noThanksBtn;
//
//    @FindBy(css = "a[href*='sign_in']")
//    WebElement signIn;
//
//    public void getNoThanksBtn() {
//      noThanksBtn.click();
//    }
//
//    public void getSignIn() {
//        signIn.click();
//    }
}
