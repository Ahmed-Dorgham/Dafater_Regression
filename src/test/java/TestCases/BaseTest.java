package TestCases;

import GeneralConstants.GeneralConstants;
import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.io.IOException;

public class BaseTest extends MainPage {

      public static WebDriver driver;
    MainPage mainPageObj;
    LoginPage loginPageObj;
    HomePage homePageObj;
    public String websiteLink_4;
    public String homePageLink_4;
    public String websiteLink_5;
    public String homePageLink_5;

    public String companyName = "شركة مجموعة بسام مطشر عجمي السعدون للتجارة" ;
    public String companyIdValue = "123456789";
    public String taxIdValue = "123456789";
    public String cityName = "city";
    public String addressName = "address";
    public String phoneValue = "564123987";

    @BeforeClass
    public void setup_driver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("disable-infobars");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-javascript");
        options.addArguments("--disable-ads");
        //options.addArguments("--headless");
        options.addArguments("---disable-extensions");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(caps);
        WebDriverManager.chromedriver().clearDriverCache().setup();
        driver = new ChromeDriver(options);

    }

    @BeforeClass(dependsOnMethods = "setup_driver")
    @Parameters({"Scope"})
    public void launch_website(String Scope) throws IOException {
        mainPageObj = new MainPage();
        websiteLink_4 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "websiteLink_4");
        homePageLink_4 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_4");
        websiteLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "websiteLink_5");
        homePageLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_5");
        if (Scope.equals("Regression")) {
            driver.navigate().to(websiteLink_5);
        } else if (Scope.equals("Comparing")) {
            driver.navigate().to(websiteLink_4);
        }
    }

    @BeforeMethod()
    @Parameters({"Scope"})
    public void loginWithValidData(String Scope) throws InterruptedException {

        loginPageObj = new LoginPage(driver);
        if (Scope.equals("Regression")) {
            homePageObj = loginPageObj.loginWithValidData(userName_5, password_5);
            WebDriverManager.chromedriver().clearDriverCache().setup();
//            waitUntilElementToBePresent(homePageObj.salesInvoicesTab, GeneralConstants.globalTimeOut);

        } else if (Scope.equals("Comparing")) {
            homePageObj = loginPageObj.loginWithValidData(userName_4, password_4);
            WebDriverManager.chromedriver().clearDriverCache().setup();
            waitUntilElementToBePresent(homePageObj.salesInvoicesTab, GeneralConstants.globalTimeOut);
            if (tryToGetWebElement(homePageObj.closeIcon) == GeneralConstants.SUCCESS) {
                homePageObj.closeWelcomeMsg();
            }
        } else {
            System.out.println(" there is an error happen");
        }
    }

    @AfterMethod
    @Parameters({"Scope"})
    public void tearDownTestCase(String Scope) throws InterruptedException {
        driver.navigate().to(homePageLink_5);
//        driver.manage().deleteAllCookies();
        WebDriverManager.chromedriver().clearDriverCache().setup();
        homePageObj.logOutFromDafater_5();
        driver.manage().deleteAllCookies();
        if (Scope.equals("Regression")) {
            driver.navigate().to(websiteLink_5);
        } else if (Scope.equals("Comparing")) {
            driver.navigate().to(websiteLink_4);
        }
    }

    @AfterClass
    public void tearDown() {
        System.out.println("Running tearDown...");
        if (driver != null) {
            driver.quit();
            System.out.println("Driver quit executed");
        }
    }

}
