package TestCases;

import Pages.*;
import io.qameta.allure.Allure;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.Random;

public class ComparingCreditNotesTest extends BaseTest {
    Random random;
    int randomNumber;
    String itemCode;
    SoftAssert softAssert;
    LoginPage loginPageObj;
    HomePage homePageObj;
    CreditNotesListPage creditNotesListPageObj;

    ItemListPage itemListPageObj;
    @Test(priority = 1, enabled = true)
    public void TC01_comparingCreditNotesDataAtListView() throws InterruptedException, IOException {

        homePageLink_4 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_4");
        websiteLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "websiteLink_5");
        homePageLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_5");
        random = new Random();
        randomNumber = random.nextInt(1000000000);
        itemCode = "item " + randomNumber;
        softAssert = new SoftAssert();
        homePageObj = new HomePage(driver);
        creditNotesListPageObj = homePageObj.openCreditNotesListPage();
        String numberOfAllCreditNotesBeforeSyncing = creditNotesListPageObj.getNumberOfAllCreditNotesBeforeSyncing();
        String numberOfDraftCreditNotesBeforeSyncing = creditNotesListPageObj.getNumberOfDraftInvoicesBeforeSyncing();
        String valueOfTotalInvoicesAtCreditNotesListViewBeforeSyncing = creditNotesListPageObj.getValueOfTotalInvoicesBeforeSyncing();
        String valueOfOutstandingAmountAtCreditNotesListViewBeforeSyncing = creditNotesListPageObj.getValueOfOutstandingAmountBeforeSyncing();
        loginPageObj = homePageObj.logOutFromDafater_4(homePageLink_4);
        loginPageObj.switchToDafater_5(websiteLink_5);
        homePageObj = loginPageObj.loginWithValidData(userName_5, password_5);
        creditNotesListPageObj = homePageObj.openCreditNotesListPage();
        String numberOfAllCreditNotesAfterSyncing = creditNotesListPageObj.getNumberOfAllCreditNotesAfterSyncing();
        String numberOfDraftCreditNotesAfterSyncing = creditNotesListPageObj.getNumberOfDraftCreditNotesAfterSyncing();
        String valueOfTotalInvoicesAtCreditNotesListViewAfterSyncing = creditNotesListPageObj.getValueOfTotalInvoicesAfterSyncing();
        String valueOfOutstandingAmountAtCreditNotesListViewAfterSyncing = creditNotesListPageObj.getValueOfOutstandingAmountAfterSyncing();
        Allure.step("verify that number of all credit notes which appear at dafater 5 is equal to number of all credit notes at dafater 4");
        softAssert.assertEquals(numberOfAllCreditNotesBeforeSyncing, numberOfAllCreditNotesAfterSyncing);
        Allure.step("verify that number of draft credit notes which appear at dafater 5 is equal to number of draft credit notes at dafater 4");
        softAssert.assertEquals(numberOfDraftCreditNotesBeforeSyncing, numberOfDraftCreditNotesAfterSyncing);
        Allure.step("verify that value Of Total Invoices At Credit Notes List View which appear at dafater 5 is equal to value Of Total Invoices At Credit Notes List View at dafater 4");
        softAssert.assertEquals(valueOfTotalInvoicesAtCreditNotesListViewBeforeSyncing, valueOfTotalInvoicesAtCreditNotesListViewAfterSyncing);
        Allure.step("verify that value Of outstanding amount At Credit Notes List View which appear at dafater 5 is equal to value Of outstanding amount At Credit Notes List View at dafater 4");
        softAssert.assertEquals(valueOfOutstandingAmountAtCreditNotesListViewBeforeSyncing, valueOfOutstandingAmountAtCreditNotesListViewAfterSyncing);
        softAssert.assertAll();
    }
}
