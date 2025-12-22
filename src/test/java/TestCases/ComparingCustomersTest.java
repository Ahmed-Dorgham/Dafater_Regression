package TestCases;

import GeneralConstants.GeneralConstants;
import Pages.*;
import io.qameta.allure.Allure;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.Random;

public class ComparingCustomersTest extends BaseTest {
    Random random;
    int randomNumber;
    String itemCode;
    SoftAssert softAssert;
    LoginPage loginPageObj;
    HomePage homePageObj;
    CustomersListPage customersListPageObj;
    SalesInvoicesListPage salesInvoicesListPageObj;
    ItemListPage itemListPageObj;

    @Test(priority = 1, enabled = true)
//    @Parameters({"Scope"})
    public void TC01_comparingCustomersDataAtListView() throws InterruptedException, IOException {

        homePageLink_4 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_4");
        websiteLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "websiteLink_5");
        homePageLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_5");
        random = new Random();
        randomNumber = random.nextInt(1000000000);
        itemCode = "item " + randomNumber;
        softAssert = new SoftAssert();
        homePageObj = new HomePage(driver);
        customersListPageObj = homePageObj.openCustomersListPage();
        String numberOfAllCustomersBeforeSyncing = customersListPageObj.getNumberOfAllCustomersBeforeSyncing();

        salesInvoicesListPageObj = homePageObj.openSalesInvoicesListPage();

        driver.navigate().refresh();
        waitUntilElementVisibility(salesInvoicesListPageObj.draftLabel, GeneralConstants.minTimeOut);
        if (tryToGetWebElementV(salesInvoicesListPageObj.emptyList)==GeneralConstants.FAILED)
        {
            salesInvoicesListPageObj.filterWithSubmittedStatus_2();

        }

        double totalPrepaymentNotUsedValueBeforeSyncingAsNumber = salesInvoicesListPageObj.getTotalOutstandingAmountOfSalesInvoicesBeforeSyncing();
        String totalPrepaymentNotUsedValueBeforeSyncing = salesInvoicesListPageObj.convertToStringFormat(totalPrepaymentNotUsedValueBeforeSyncingAsNumber);

//        String customersDebitsValueBeforeSyncing = customersListPageObj.getNumberOfCustomersDebitsBeforeSyncing();
        loginPageObj = homePageObj.logOutFromDafater_4(homePageLink_4);
        loginPageObj.switchToDafater_5(websiteLink_5);
        homePageObj = loginPageObj.loginWithValidData(userName_5, password_5);
        customersListPageObj = homePageObj.openCustomersListPage();
        String numberOfAllCustomerssAfterSyncing = customersListPageObj.getNumberOfAllCustomersAfterSyncing();
//        String customersDebitsValueAfterSyncing = customersListPageObj.getNumberOfCustomersDebitsAfterSyncing();
        String prepaymentNotUsedValueAfterSyncing = customersListPageObj.getNumberOfPrepaymentNotUsedAfterSyncing();
        Allure.step("verify that number of all customers which appear at dafater 5 is equal to number of all customers at dafater 4");

        softAssert.assertEquals(numberOfAllCustomersBeforeSyncing, numberOfAllCustomerssAfterSyncing);
//
//        Allure.step("verify that value of Customers Debits which appear at dafater 5 is equal to the value of customers Debits at dafater 4");
//        softAssert.assertEquals(customersDebitsValueBeforeSyncing, customersDebitsValueAfterSyncing);
        Allure.step("verify that prepayment Not Used value  which appear at dafater 5 is equal to prepayment Not Used value at dafater 4");
        softAssert.assertEquals(totalPrepaymentNotUsedValueBeforeSyncing, prepaymentNotUsedValueAfterSyncing);

        softAssert.assertAll();
    }

}
