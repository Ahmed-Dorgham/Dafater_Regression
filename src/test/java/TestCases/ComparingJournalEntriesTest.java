package TestCases;

import Pages.HomePage;
import Pages.JournalEntrytListPage;
import Pages.LoginPage;
import io.qameta.allure.Allure;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.Random;

public class ComparingJournalEntriesTest extends BaseTest {
    Random random;
    int randomNumber;
    String itemCode;
    SoftAssert softAssert;

    LoginPage loginPageObj;
    HomePage homePageObj;
    JournalEntrytListPage journalEntryListPageObj;

    @Test(priority = 1, enabled = true)
    public void TC01_comparingNumberOfJournalEntries() throws InterruptedException, IOException {

        homePageLink_4 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_4");
        websiteLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "websiteLink_5");
        homePageLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_5");
        random = new Random();
        randomNumber = random.nextInt(1000000000);
        itemCode = "item " + randomNumber;
        softAssert = new SoftAssert();
        homePageObj = new HomePage(driver);
        journalEntryListPageObj = homePageObj.openJournalEntryListPage();
        String numberOfAllJournalEntryBeforeSyncing = journalEntryListPageObj.getNumberOfAllJournalEntriesBeforeSyncing();
        loginPageObj = homePageObj.logOutFromDafater_4(homePageLink_4);
        loginPageObj.switchToDafater_5(websiteLink_5);
        homePageObj = loginPageObj.loginWithValidData(userName_5, password_5);
        journalEntryListPageObj = homePageObj.openJournalEntryListPage();
        String numberOfAllPurchaseReceiptAfterSyncing = journalEntryListPageObj.getNumberOfAllJournalEntriesAfterSyncing();
        Allure.step("verify that number of all Journal entry which appear at dafater 5 is equal to number of all Journal entry at dafater 4 ");
        softAssert.assertEquals(numberOfAllJournalEntryBeforeSyncing, numberOfAllPurchaseReceiptAfterSyncing);
        softAssert.assertAll();
        Allure.step(" number of all Journal entry which appear at dafater 5 is " + numberOfAllPurchaseReceiptAfterSyncing + " and number of all Journal entry at dafater 4 is " + numberOfAllJournalEntryBeforeSyncing + " and this is correct ");

    }


}
