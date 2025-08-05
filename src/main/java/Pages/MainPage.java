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
import java.util.Random;

public class MainPage extends GeneralConstants {
    public static WebDriver driver;
    public WebDriverWait wait;
//    JavascriptExecutor js;
   public Actions actions;
   public JavascriptExecutor js;
//    Random random = new Random();
//    public int randomNumber = random.nextInt(1000000000);

    public String itemPrice = "100";
    public void waitUntilElementVisibility(By by, int duration) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    public void waitUntilElementToBePresent(By by, int duration) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
    public void waitUntilElementNotToBeVisible(By by, int duration) {

        wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void waitUntilElementToBeClickable(By by, int duration) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public WebElement getWebElement(By by) {
        // System.out.println(driver.findElement(by).getText() + " >>>> element is displayed");
        return driver.findElement(by);
    }
    public String tryToGetWebElement(By by) {
        // System.out.println(driver.findElement(by).getText() + " >>>> element is displayed");
        try {
            waitUntilElementToBePresent(by,GeneralConstants.tryTimeOut);
            return GeneralConstants.SUCCESS ;
        }
        catch (Exception e)

        {
            return GeneralConstants.FAILED;
        }

    }
    public void clickByActions(By by) {
        actions = new Actions(driver);
        actions.click(getWebElement(by)).build().perform();

    }
    public void clickByJs(WebElement element) {
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }
    public void waitUntilOverlayDisappear(By by, int duration) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        try
        {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        }
        catch (Exception e)
        {

        }

    }
    public void waitUntilElementNotContainText (By by ,String value )
    {

            while (getWebElement(by).getText().contains(value))
            {
              System.out.println("******************     ***********************");
            }

    }
    public String readDataFromPropertiesFile(String filePath, String Key) throws IOException {
        File file = new File(filePath);
        FileInputStream inputStream = new FileInputStream(file);
        Properties prop = new Properties();
        prop.load(inputStream);
        return prop.getProperty(Key);
    }

    public void scrollToSpeceficElement(By by) {
        actions = new Actions(driver);
        actions.moveToElement(getWebElement(by)).perform();
        waitUntilElementVisibility(by,GeneralConstants.minTimeOut);
    }
    public String verifyTextContains (By by ,String expected)
    {
        if (getWebElement(by).getText().contains(expected))
        {
            System.out.println("actual text is " + getWebElement(by).getText() + "and expected test is " + expected );
            return GeneralConstants.SUCCESS;
        }
        else
            return GeneralConstants.FAILED;
    }
}
