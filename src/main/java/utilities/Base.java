package utilities;



import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public static Logger logger = LogManager.getLogger();
    public WebDriver driver;
    String browserName;
    public Properties prop;
    public WebDriver initDriver() {
        try {
            prop = new Properties();
            FileInputStream fileIn = new FileInputStream("src\\test\\resources\\configs.properties");
            prop.load(fileIn);
            browserName = prop.getProperty("browser");
        } catch (IOException e) {
            e.getMessage();
        }
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\erdem\\Selenium\\ChromeDriver\\chromedriver.exe");
            driver = new ChromeDriver();
        }
//            else if (browserName.equalsIgnoreCase("firefox")) {
//                System.setProperty("webdriver.chrome.driver", "C:\\Users\\erdem\\Selenium\\ChromeDriver\\chromedriver.exe");
//                driver = new FirefoxDriver();
//            } else if (browserName.equalsIgnoreCase("internetExplorer")) {
//                System.setProperty("webdriver.chrome.driver", "C:\\Users\\erdem\\Selenium\\ChromeDriver\\chromedriver.exe");
//                driver = new InternetExplorerDriver();
//            }


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
    public void getScreenshot(String testCaseName, WebDriver driver){
        try {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            String fileDestination = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
            FileUtils.copyFile(source,new File(fileDestination));
        }catch (IOException e){
            e.getMessage();
        }

    }
}
