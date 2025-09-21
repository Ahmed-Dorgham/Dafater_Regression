package TestCases;

import Pages.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.Random;

public class ComparingSalesInvoicesTest extends BaseTest {
    Random random;
    int randomNumber;
    String itemCode;
    SoftAssert softAssert;

    LoginPage loginPageObj;
    HomePage homePageObj;
    SalesInvoicesListPage salesInvoicesListPageObj;

    private final String duesDate = "15-07-2026";
    private final String secretKey = "kX7NY9yMSag3";
    private final String invalidSecretKey = "kX7NY9yMSag4";
    private final String successfulConnectionMsg = "Connected Successfully";
    private final String failureConnectionMsg = "Cannot Connect";
    private final String submittedStatus = "معتمد";
    private final String draftStatus = "مسودة";
    private final String invoiceName = "ACC-SINV";

    @Test(priority = 1, enabled = true)
    public void TC01_comparingNumberOfSalesInvoices() throws InterruptedException, IOException {

        homePageLink_4 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_4");
        websiteLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "websiteLink_5");
        homePageLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_5");
        random = new Random();
        randomNumber = random.nextInt(1000000000);
        itemCode = "item " + randomNumber;
        softAssert = new SoftAssert();
        homePageObj = new HomePage(driver);
        salesInvoicesListPageObj = homePageObj.openSalesInvoicesListPage();
        String numberOfDraftSalesInvoicesBeforeSyncing = salesInvoicesListPageObj.getNumberOfDraftInvoicesBeforeSyncing();
        String totalAmountOfSalesInvoicesBeforeSyncing = salesInvoicesListPageObj.getTotalAmountOfSalesInvoicesBeforeSyncing();
        loginPageObj = homePageObj.logOutFromDafater_4(homePageLink_4);
        loginPageObj.switchToDafater_5(websiteLink_5);
        homePageObj = loginPageObj.loginWithValidData(userName_5, password_5);
        salesInvoicesListPageObj = homePageObj.openSalesInvoicesListPage();

        String numberOfDraftSalesInvoicesAfterSyncing = salesInvoicesListPageObj.getNumberOfDraftInvoicesAfterSyncing();
        String totalAmountOfSalesInvoicesAfterSyncing = salesInvoicesListPageObj.getTotalAmountOfSalesInvoicesAfterSyncing();
        System.out.println("verify that number of all draft sales invoices  which appear at dafater 5 is equal to number of all draft sales invoices at dafater 4 ");

        softAssert.assertEquals(numberOfDraftSalesInvoicesAfterSyncing, numberOfDraftSalesInvoicesBeforeSyncing);
        System.out.println("verify that total amount of sales invoices at dafater 5 is equal to  total amount of sales invoices at dafater 4 ");

        softAssert.assertEquals(totalAmountOfSalesInvoicesAfterSyncing, totalAmountOfSalesInvoicesBeforeSyncing);
        softAssert.assertAll();
    }
}
