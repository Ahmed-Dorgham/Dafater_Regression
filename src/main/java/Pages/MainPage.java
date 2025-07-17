package Pages;

import GeneralConstants.GeneralConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class MainPage extends GeneralConstants {
    public static WebDriver driver;
    public WebDriverWait wait;
    JavascriptExecutor js;
    Actions action ;
    public void waitUntilElementVisibility (By by,int duration)
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    public void waitUntilElementToBeClickable (By by,int duration)
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    public WebElement getWebElement(By by) {
       // System.out.println(driver.findElement(by).getText() + " >>>> element is displayed");
        return driver.findElement(by);
    }
    public void clickByActions(By by) {
        action = new Actions(driver);
        action.click(getWebElement(by)).build().perform();

    }
    public String readDataFromPropertiesFile(String filePath, String Key) throws IOException {
        File file = new File(filePath);
        FileInputStream inputStream = new FileInputStream(file);
        Properties prop = new Properties();
        prop.load(inputStream);
        return prop.getProperty(Key);
    }
    public void scrollDown ()
    {
        System.out.println("scroll down ");
         js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 300);");
        System.out.println("scroll down ");
    }
}
