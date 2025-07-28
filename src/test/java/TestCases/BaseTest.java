package TestCases;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class BaseTest extends MainPage {

    //  public static WebDriver driver;
    MainPage mainPageObj;
    LoginPage loginPageObj;
    HomePage homePageObj;
    private String websiteLink;
    private String homePageLink;

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
    public void launch_website() throws IOException {
        mainPageObj = new MainPage();
        websiteLink = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "websiteLink");
        homePageLink = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink");
        driver.navigate().to(websiteLink);
    }

    @BeforeClass(dependsOnMethods = "launch_website")
    public void loginWithValidData() {

        loginPageObj = new LoginPage(driver);
        homePageObj = loginPageObj.loginWithValidData(userName, password);
    }

    @AfterMethod
    public void tearDownTestCase() {

        driver.navigate().to(homePageLink);
        driver.manage().deleteAllCookies();

        WebDriverManager.chromedriver().clearDriverCache().setup();
    }

    @AfterClass
    public void closeSuite() {
        driver.quit();
    }
}
