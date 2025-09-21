package TestCases;

import Pages.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.Random;

public class ComparingStockEntryTest extends BaseTest {
    Random random;
    int randomNumber;
    String itemCode;
    SoftAssert softAssert;

    LoginPage loginPageObj;
    HomePage homePageObj;

    StockEntryListPage stockEntryListPageObj;

    @Test(priority = 1, enabled = true)
    public void TC01_comparingNumberOfStockEntries() throws InterruptedException, IOException {

        homePageLink_4 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_4");
        websiteLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "websiteLink_5");
        homePageLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_5");
        random = new Random();
        randomNumber = random.nextInt(1000000000);
        itemCode = "item " + randomNumber;
        softAssert = new SoftAssert();
        homePageObj = new HomePage(driver);
        stockEntryListPageObj = homePageObj.openStockEntryListPage();
        String numberOfAllStockEntryBeforeSyncing = stockEntryListPageObj.getNumberOfAllStockEntriesBeforeSyncing();
        loginPageObj = homePageObj.logOutFromDafater_4(homePageLink_4);
        loginPageObj.switchToDafater_5(websiteLink_5);
        homePageObj = loginPageObj.loginWithValidData(userName_5, password_5);
        stockEntryListPageObj = homePageObj.openStockEntryListPage();
        String numberOfAllStockEntryAfterSyncing = stockEntryListPageObj.getNumberOfAllStockEntriesAfterSyncing();
        System.out.println("verify that number of all stock entries which appear at dafater 5 is equal to number of all stock entries at dafater 4 ");

        softAssert.assertEquals(numberOfAllStockEntryBeforeSyncing, numberOfAllStockEntryAfterSyncing);
        softAssert.assertAll();
        System.out.println(" number of stock entries which appear at dafater 5 is " + numberOfAllStockEntryAfterSyncing + " and number of all stock entries at dafater 4 is " + numberOfAllStockEntryBeforeSyncing + " and this is correct ");


    }


}
