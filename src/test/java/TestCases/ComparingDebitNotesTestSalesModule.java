package TestCases;

import GeneralConstants.GeneralConstants;
import Pages.DebitNotesListPage;
import Pages.HomePage;
import Pages.ItemListPage;
import Pages.LoginPage;
import io.qameta.allure.Allure;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.Random;

public class ComparingDebitNotesTestSalesModule extends BaseTest {
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
//        String numberOfDraftDebitNotesBeforeSyncing = debitNotesListPageObj.getNumberOfDraftNotesBeforeSyncing();

        if (tryToGetWebElementV(debitNotesListPageObj.emptyList)== GeneralConstants.FAILED)
        {
            debitNotesListPageObj.filterWithSubmittedStatus_2();
        }
        double totalAmountOfDebitNotesBeforeSyncingAsNumber = debitNotesListPageObj.getTotalAmountOfDebitNotesBeforeSyncing();
        String totalAmountOfDebitNotesBeforeSyncing = debitNotesListPageObj.convertToStringFormat(totalAmountOfDebitNotesBeforeSyncingAsNumber);
        driver.navigate().refresh();
        if (tryToGetWebElementV(debitNotesListPageObj.emptyList)==GeneralConstants.FAILED)
        {
            debitNotesListPageObj.filterWithSubmittedStatus_2();
        }
        double totalOutstandingAmountOfDebitNotesBeforeSyncingAsNumber = debitNotesListPageObj.getTotalOutstandingAmountOfDebitNotesBeforeSyncing();
        String totalOutstandingAmountOfDebitNotesBeforeSyncing = debitNotesListPageObj.convertToStringFormat(totalOutstandingAmountOfDebitNotesBeforeSyncingAsNumber);
        double totalPaidAmountOfDebitNotesBeforeSyncingAsNumber = totalAmountOfDebitNotesBeforeSyncingAsNumber - totalOutstandingAmountOfDebitNotesBeforeSyncingAsNumber;
        String totalPaidAmountOfDebitNotesBeforeSyncing = debitNotesListPageObj.convertToStringFormat(totalPaidAmountOfDebitNotesBeforeSyncingAsNumber);

        System.out.println("total paid amount Of debit notes Before Syncing is "+totalPaidAmountOfDebitNotesBeforeSyncingAsNumber);

        loginPageObj = homePageObj.logOutFromDafater_4(homePageLink_4);
        loginPageObj.switchToDafater_5(websiteLink_5);
        homePageObj = loginPageObj.loginWithValidData(userName_5, password_5);
        debitNotesListPageObj = homePageObj.openDebitNotesListPage();
        debitNotesListPageObj.filterDocTypesWithSecondFilter("حالة", "معتمد");
        String numberOfAllDebitNotesAfterSyncing = debitNotesListPageObj.getNumberOfAllDebitNotesAfterSyncing();
//        String numberOfDraftDebitNotesAfterSyncing = debitNotesListPageObj.getNumberOfDraftInvoicesAfterSyncing();
        String totalAmountOfDebitNotesAfterSyncing = debitNotesListPageObj.getTotalAmountOfDebitNotesAfterSyncing();
        String totalOutstandingAmountOfDebitNotesAfterSyncing = debitNotesListPageObj.getTotalOutstandingAmountOfDebitNotesAfterSyncing();
        String totalPaidAmountOfDebitNotesAfterSyncing = debitNotesListPageObj.getTotalPaidAmountOfDebitNotesAfterSyncing();
        Allure.step("verify that number of all debit notes which appear at dafater 5 is equal to number of all debit notes at dafater 4");
        softAssert.assertEquals(numberOfAllDebitNotesBeforeSyncing, numberOfAllDebitNotesAfterSyncing);
//        Allure.step("verify that number of all draft debit notes  which appear at dafater 5 is equal to number of all draft debit notes at dafater 4 ");
//        softAssert.assertEquals(numberOfDraftDebitNotesAfterSyncing, numberOfDraftDebitNotesBeforeSyncing);
        Allure.step("verify that total amount of all debit notes at dafater 5 is equal to total amount of all debit notes at dafater 4 ");
        softAssert.assertEquals(totalAmountOfDebitNotesAfterSyncing, totalAmountOfDebitNotesBeforeSyncing);
        Allure.step("verify that total outstanding amount of all debit notes at dafater 5 is equal to total outstanding amount of all debit notes at dafater 4 ");
        softAssert.assertEquals(totalOutstandingAmountOfDebitNotesAfterSyncing, totalOutstandingAmountOfDebitNotesBeforeSyncing);

        Allure.step("verify that total paid amount of debit notes value at dafater 5 is equal to total paid amount of debit notes values at dafater 4 ");
        softAssert.assertEquals(Double.parseDouble(totalPaidAmountOfDebitNotesAfterSyncing), totalPaidAmountOfDebitNotesBeforeSyncingAsNumber);

        softAssert.assertAll();

    }


}
