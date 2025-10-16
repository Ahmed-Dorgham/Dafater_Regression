package TestCases;

import Pages.FiscalYearListPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.SetupPage;
import io.qameta.allure.Allure;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.Random;

public class ComparingFiscalYearsTest extends BaseTest {
    Random random;
    int randomNumber;
    String itemCode;
    SoftAssert softAssert;

    LoginPage loginPageObj;
    HomePage homePageObj;

    SetupPage setupPageObj;
    FiscalYearListPage fiscalYearListPageObj;

    @Test(priority = 1, enabled = true)
    public void TC01_comparingNumberOfFiscalYears() throws InterruptedException, IOException {
        SoftAssert softAssert = new SoftAssert();
        homePageLink_4 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_4");
        websiteLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "websiteLink_5");
        homePageLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_5");
        random = new Random();
        randomNumber = random.nextInt(1000000000);
        itemCode = "item " + randomNumber;
        softAssert = new SoftAssert();
        homePageObj = new HomePage(driver);
        setupPageObj = homePageObj.openSetupPage();
        fiscalYearListPageObj = setupPageObj.openFiscalYearListPage();
        String numberOfAllFiscalYearsBeforeSyncing = fiscalYearListPageObj.getNumberOfAllFiscalYearsBeforeSyncing();
        loginPageObj = homePageObj.logOutFromDafater_4(homePageLink_4);
        loginPageObj.switchToDafater_5(websiteLink_5);
        homePageObj = loginPageObj.loginWithValidData(userName_5, password_5);
        setupPageObj = homePageObj.openSetupPage();
        fiscalYearListPageObj = setupPageObj.openFiscalYearListPage();

        String numberOfAllFiscalYearsAfterSyncing = fiscalYearListPageObj.getNumberOfAllFiscalYearsAfterSyncing();

        Allure.step("verify that number of all fiscal years which appear at dafater 5 is equal to number of all fiscal years at dafater 4 ");

        softAssert.assertEquals(numberOfAllFiscalYearsBeforeSyncing, numberOfAllFiscalYearsAfterSyncing);
        softAssert.assertAll();
        Allure.step(" number of fiscal years which appear at dafater 5 is " + numberOfAllFiscalYearsAfterSyncing + " and number of all  fiscal years at dafater 4 is " + numberOfAllFiscalYearsBeforeSyncing + " and this is correct ");

    }


}
