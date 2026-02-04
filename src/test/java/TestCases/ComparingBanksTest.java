package TestCases;

import Pages.*;
import io.qameta.allure.Allure;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.Random;

public class ComparingBanksTest extends BaseTest {
    Random random;
    int randomNumber;
    String itemCode;
    SoftAssert softAssert;

    LoginPage loginPageObj;
    HomePage homePageObj;
    JournalEntrytListPage journalEntryListPageObj;
    BanksListPage banksListPageObj;

    SetupPage setupPageObj;
    PeriodClosingVoucherListPage periodClosingVoucherListPageObj;
    PeriodClosingVoucherPage periodClosingVoucherPageObj;

    @Test(priority = 1, enabled = true)
    public void TC01_comparingNumberOfBanks() throws InterruptedException, IOException {

        homePageLink_4 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_4");
        websiteLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "websiteLink_5");
        homePageLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_5");
        random = new Random();
        randomNumber = random.nextInt(1000000000);
        itemCode = "item " + randomNumber;
        softAssert = new SoftAssert();
        homePageObj = new HomePage(driver);
        banksListPageObj = homePageObj.openBanksListPage();

        String numberOfAllTotalBanksBeforeSyncing = banksListPageObj.getNumberOfAllBanksBeforeSyncing();

        loginPageObj = homePageObj.logOutFromDafater_4(homePageLink_4);
        loginPageObj.switchToDafater_5(websiteLink_5);
        homePageObj = loginPageObj.loginWithValidData(userName_5, password_5);
        banksListPageObj = homePageObj.openBanksListPage_5();


        String numberOfAllBanksAfterSyncing = banksListPageObj.getNumberOfAllBanksAfterSyncing();

        Allure.step("verify that number of all banks which appear at dafater 5 is equal to number of all banks at dafater 4 ");
        softAssert.assertEquals(numberOfAllTotalBanksBeforeSyncing,numberOfAllBanksAfterSyncing);
        Allure.step(" number of all banks which appear at dafater 5 is " + numberOfAllBanksAfterSyncing + " number of all banks which appear at dafater 4 is " + numberOfAllTotalBanksBeforeSyncing + " and this is correct ");


        softAssert.assertAll();
    }
}
