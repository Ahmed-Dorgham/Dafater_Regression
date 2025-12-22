package TestCases;

import GeneralConstants.GeneralConstants;
import Pages.*;
import io.qameta.allure.Allure;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.Random;

public class ComparingSuppliersTest extends BaseTest {
    Random random;
    int randomNumber;
    String itemCode;
    SoftAssert softAssert;
    LoginPage loginPageObj;
    HomePage homePageObj;
    SuppliersListPage suppliersListPageObj;
    PurchaseInvoicesListPage purchaseInvoicesListPageObj;
    ItemListPage itemListPageObj;
    @Test(priority = 1, enabled = true)
    public void TC01_comparingSuppliersDataAtListView() throws InterruptedException, IOException {

        homePageLink_4 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_4");
        websiteLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "websiteLink_5");
        homePageLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_5");
        random = new Random();
        randomNumber = random.nextInt(1000000000);
        itemCode = "item " + randomNumber;
        softAssert = new SoftAssert();
        homePageObj = new HomePage(driver);
        suppliersListPageObj = homePageObj.openSuppliersListPage();
        String numberOfAllSuppliersBeforeSyncing = suppliersListPageObj.getNumberOfAllSuppliersBeforeSyncing();

        purchaseInvoicesListPageObj = homePageObj.openPurchaseInvoicesListPage();
        driver.navigate().refresh();
        waitUntilElementVisibility(purchaseInvoicesListPageObj.draftLabel, GeneralConstants.minTimeOut);
        if (tryToGetWebElementV(purchaseInvoicesListPageObj.emptyList)==GeneralConstants.FAILED)
        {
            purchaseInvoicesListPageObj.filterWithSubmittedStatus_2();
        }

        double totalPrepaymentNotUsedValueBeforeSyncingAsNumber = purchaseInvoicesListPageObj.getTotalOutstandingAmountOfPurchaseInvoicesBeforeSyncing();
        String totalPrepaymentNotUsedValueBeforeSyncing = purchaseInvoicesListPageObj.convertToStringFormat(totalPrepaymentNotUsedValueBeforeSyncingAsNumber);

//        String suppliersDebitsValueBeforeSyncing = suppliersListPageObj.getNumberOfSuppliersDebitsBeforeSyncing();
//        String prepaymentNotUsedValueBeforeSyncing = suppliersListPageObj.getNumberOfPrepaymentNotUsedBeforeSyncing();

        loginPageObj = homePageObj.logOutFromDafater_4(homePageLink_4);
        loginPageObj.switchToDafater_5(websiteLink_5);
        homePageObj = loginPageObj.loginWithValidData(userName_5, password_5);
        suppliersListPageObj = homePageObj.openSuppliersListPage();
//        String suppliersDebitsValueAfterSyncing = suppliersListPageObj.getNumberOfSuppliersDebitsAfterSyncing();
        String prepaymentNotUsedValueAfterSyncing = suppliersListPageObj.getNumberOfPrepaymentNotUsedAfterSyncing();
        String numberOfAllSuppliersAfterSyncing = suppliersListPageObj.getNumberOfAllSuppliersAfterSyncing();

      Allure.step("verify that number of all suppliers which appear at dafater 5 is equal to number of all suppliers at dafater 4");

        softAssert.assertEquals(numberOfAllSuppliersBeforeSyncing, numberOfAllSuppliersAfterSyncing);
//
//      Allure.step("verify that value of Suppliers Debits which appear at dafater 5 is equal to the value of Suppliers Debits at dafater 4");
//
//        softAssert.assertEquals(suppliersDebitsValueBeforeSyncing, suppliersDebitsValueAfterSyncing);
      Allure.step("verify that prepayment Not Used value  which appear at dafater 5 is equal to prepayment Not Used value at dafater 4");
        softAssert.assertEquals(totalPrepaymentNotUsedValueBeforeSyncing, prepaymentNotUsedValueAfterSyncing);
        softAssert.assertAll();
    }
}
