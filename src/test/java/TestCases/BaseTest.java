package TestCases;

import GeneralConstants.GeneralConstants;
import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseTest extends MainPage {

    public static WebDriver driver;
    MainPage mainPageObj;
    LoginPage loginPageObj;
    HomePage homePageObj;
    FiscalYearListPage fiscalYearListPageObj;
    ChartOfAccountsPage chartOfAccountsPageObj;
    CompaniesListPage companiesListPageObj;
    CompanyPage companyPageObj;
    public String websiteLink_4;
    public String homePageLink_4;
    public String websiteLink_5;
    public String fiscalYearListPageLink;
    public String homePageLink_5;
    public static TakesScreenshot takesScreenshot;
    String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
    String dateTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
    //    public String companyName = "مؤسسة محمد سليمان صلبي الحربي للتجارة";
//    public String companyName = "شركة سابر للتقييم العقاري";
    public String companyName = "مؤسسة روعة النخبة للمقاولات";
    //    public String companyName = "شركة مجموعة بسام مطشر عجمي السعدون للتجارة";
    public String companyIdValue = "123456789";
    public String taxIdValue = "123456789";
    public String cityName = "city";
    public String addressName = "address";
    public String phoneValue = "564123987";
//    @BeforeSuite
//    @Parameters({"Scope"})
    public void checkFiscalYearErrorMsg (@Optional("Comparing") String Scope) throws InterruptedException, IOException {
        mainPageObj = new MainPage();
        chartOfAccountsPageObj = new ChartOfAccountsPage(driver);
        fiscalYearListPageObj = new FiscalYearListPage(driver);

        websiteLink_4 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "websiteLink_4");
        homePageLink_4 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_4");
        websiteLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "websiteLink_5");
        homePageLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_5");
        fiscalYearListPageLink = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "fiscalYearListPageLink");
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
        if (Scope.equals("Regression")) {
            driver.navigate().to(websiteLink_5);
        } else if (Scope.equals("Comparing")) {
            driver.navigate().to(websiteLink_4);
        }
        loginPageObj = new LoginPage(driver);
        if (Scope.equals("Regression")) {
            homePageObj = loginPageObj.loginWithValidData(userName_5, password_5);
            WebDriverManager.chromedriver().clearDriverCache().setup();
//            waitUntilElementToBePresent(homePageObj.salesInvoicesTab, GeneralConstants.globalTimeOut);

        } else if (Scope.equals("Comparing")) {
            homePageObj = loginPageObj.loginWithValidData(userName_4, password_4);
            WebDriverManager.chromedriver().clearDriverCache().setup();
            waitUntilElementToBePresent(homePageObj.salesInvoicesTab, GeneralConstants.globalTimeOut);
            if (tryToGetWebElementV(homePageObj.closeIconWelcome) == GeneralConstants.SUCCESS) {
                homePageObj.closeWelcomeMsg();
            }
            homePageObj.openChartOfAccountsPage();

            if (tryToGetWebElementV(chartOfAccountsPageObj.fiscalYearErrorMsg) == GeneralConstants.SUCCESS) {
                String startDate = chartOfAccountsPageObj.extractDate();
                String yearName = chartOfAccountsPageObj.extractYear();
                driver.navigate().to(websiteLink_5);
                homePageObj = loginPageObj.loginWithValidData(userName_5, password_5);
                waitUntilElementVisibility(homePageObj.purchaseInvoicesTab, GeneralConstants.minTimeOut);
                driver.navigate().to(fiscalYearListPageLink);
                fiscalYearListPageObj.createNewFiscalYearToAvoidFiscalErrorMsg(yearName, startDate);
//            driver.navigate().to(websiteLink_4);
//            homePageObj = loginPageObj.loginWithValidData(userName_4, password_4);
//            waitUntilElementVisibility(homePageObj.purchaseInvoicesTab, GeneralConstants.minTimeOut);
//            if (tryToGetWebElementV(homePageObj.closeIconWelcome) == GeneralConstants.SUCCESS) {
//                homePageObj.closeWelcomeMsg();
//            }
            }}
    }
    @BeforeClass
    @Parameters({"Scope"})
    public void setup_driver(String Scope) throws IOException {
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
        mainPageObj = new MainPage();
        websiteLink_4 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "websiteLink_4");
        homePageLink_4 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_4");
        websiteLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "websiteLink_5");
        homePageLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_5");
        fiscalYearListPageLink = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "fiscalYearListPageLink");
        if (Scope.equals("Regression")) {
            driver.navigate().to(websiteLink_5);
        } else if (Scope.equals("Comparing")) {
            driver.navigate().to(websiteLink_4);
        }

    }

    @BeforeClass(dependsOnMethods = "setup_driver")
    @Parameters({"Scope"})
    public void launch_website(@Optional("Comparing")String Scope) throws IOException {
        mainPageObj = new MainPage();
        websiteLink_4 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "websiteLink_4");
        homePageLink_4 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_4");
        websiteLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "websiteLink_5");
        homePageLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_5");
        fiscalYearListPageLink = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "fiscalYearListPageLink");
        if (Scope.equals("Regression")) {
            driver.navigate().to(websiteLink_5);
        } else if (Scope.equals("Comparing")) {
            driver.navigate().to(websiteLink_4);
        }
    }

    @BeforeMethod()
    @Parameters({"Scope"})
    public void loginWithValidData(String Scope) throws InterruptedException {
        chartOfAccountsPageObj = new ChartOfAccountsPage(driver);
        fiscalYearListPageObj = new FiscalYearListPage(driver);

        loginPageObj = new LoginPage(driver);
        if (Scope.equals("Regression")) {
            homePageObj = loginPageObj.loginWithValidData(userName_5, password_5);
            WebDriverManager.chromedriver().clearDriverCache().setup();
//            waitUntilElementToBePresent(homePageObj.salesInvoicesTab, GeneralConstants.globalTimeOut);

        } else if (Scope.equals("Comparing")) {
            homePageObj = loginPageObj.loginWithValidData(userName_4, password_4);
            WebDriverManager.chromedriver().clearDriverCache().setup();
            waitUntilElementToBePresent(homePageObj.salesInvoicesTab, GeneralConstants.globalTimeOut);
            if (tryToGetWebElementV(homePageObj.closeIconWelcome) == GeneralConstants.SUCCESS) {
                homePageObj.closeWelcomeMsg();
            }


        } else {
            System.out.println(" there is an error happen");
        }
    }
//
//
    @AfterMethod
    @Parameters({"Scope"})
    public void tearDownTestCase(String Scope) throws InterruptedException {
        driver.navigate().to(homePageLink_5);
        WebDriverManager.chromedriver().clearDriverCache().setup();
        if (tryToGetWebElementV(homePageObj.loginBtn) == GeneralConstants.SUCCESS) {
            Allure.step("go to login page");
            getWebElement(homePageObj.loginBtn).click();
            waitUntilElementVisibility(loginPageObj.userNameField, GeneralConstants.minTimeOut);
        } else {
            homePageObj.logOutFromDafater_5();
        }

        driver.manage().deleteAllCookies();
        if (Scope.equals("Regression")) {
            driver.navigate().to(websiteLink_5);
        } else if (Scope.equals("Comparing")) {
            driver.navigate().to(websiteLink_4);
        }
    }

    @AfterClass
    public void tearDown() {
        Allure.step("Running tearDown...");
        if (driver != null) {
            driver.quit();
            Allure.step("Driver quit executed");
        }
    }

    public static File takeScreenshot(WebDriver driver, String testName) throws IOException {
        Allure.step("capture ScreenShot...........");
        String screenShotPath = System.getProperty("user.dir") + "\\ScreenShots\\" + testName + "_screenshot.png";
        takesScreenshot = (TakesScreenshot) driver;
        File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File(screenShotPath));
        return src;
    }

    @Step("After Method")
    @AfterMethod
    public void onTestFailure(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            File screenshot = takeScreenshot(driver, result.getName());
            Allure.addAttachment("screenshot", FileUtils.openInputStream(screenshot));
        }
    }


}
