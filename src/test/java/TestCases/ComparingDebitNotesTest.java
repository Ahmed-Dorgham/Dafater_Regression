package TestCases;

import Pages.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.Random;

public class ComparingDebitNotesTest extends BaseTest {
    Random random;
    int randomNumber;
    String itemCode;
    SoftAssert softAssert;
    LoginPage loginPageObj;
    HomePage homePageObj;
    DebitNotesListPage debitNotesListPageObj;

    ItemListPage itemListPageObj;
    @Test(priority = 1, enabled = true)
    public void TC01_comparingDebitNotesDataAtListView() throws InterruptedException, IOException {

        homePageLink_4 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_4");
        websiteLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "websiteLink_5");
        homePageLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_5");
        random = new Random();
        randomNumber = random.nextInt(1000000000);
        itemCode = "item " + randomNumber;
        softAssert = new SoftAssert();
        homePageObj = new HomePage(driver);
        debitNotesListPageObj = homePageObj.openDebitNotesListPage();
        String numberOfAllDebitNotesBeforeSyncing = debitNotesListPageObj.getNumberOfAllDebitNotesBeforeSyncing();

        loginPageObj = homePageObj.logOutFromDafater_4(homePageLink_4);
        loginPageObj.switchToDafater_5(websiteLink_5);
        homePageObj = loginPageObj.loginWithValidData(userName_5, password_5);
        debitNotesListPageObj = homePageObj.openDebitNotesListPage();
        String numberOfAllDebitNotesAfterSyncing = debitNotesListPageObj.getNumberOfAllDebitNotesAfterSyncing();

        System.out.println("verify that number of all debit notes which appear at dafater 5 is equal to number of all debit notes at dafater 4");
        softAssert.assertEquals(numberOfAllDebitNotesBeforeSyncing, numberOfAllDebitNotesAfterSyncing);
        softAssert.assertAll();

    }


}
