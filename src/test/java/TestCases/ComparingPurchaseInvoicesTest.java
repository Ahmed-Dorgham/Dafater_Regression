package TestCases;

import Pages.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.Random;

public class ComparingPurchaseInvoicesTest extends BaseTest {
    Random random;
    int randomNumber;
    String itemCode;
    SoftAssert softAssert;

    LoginPage loginPageObj;
    HomePage homePageObj;
    SalesInvoicesListPage salesInvoicesListPageObj;
    SalesOrderListPage salesOrdersListPageObj;
    SalesOrderPage salesOrdersPageObj;
    SalesInvoicesPage salesInvoicesPageObj;
    ItemPage itemPageObj;
    ItemListPage itemListPageObj;
    SellingPriceListsPage sellingPriceListsPageObj;
    CreditNotePage creditNotePageObj;
    StandardSellingListPage standardSellingListPageObj;
    ItemsPricesTablePage itemsPricesTablePageObj;
    ItemPricePage itemPricePageObj;
    PurchaseInvoicesListPage purchaseInvoicesListPageObj;
    PurchaseInvoicesPage purchaseInvoicesPageObj;

    private final String duesDate = "15-07-2026";
    private final String secretKey = "kX7NY9yMSag3";
    private final String invalidSecretKey = "kX7NY9yMSag4";
    private final String successfulConnectionMsg = "Connected Successfully";
    private final String failureConnectionMsg = "Cannot Connect";
    private final String submittedStatus = "معتمد";
    private final String draftStatus = "مسودة";
    private final String invoiceName = "ACC-SINV";

    @Test(priority = 1, enabled = true)
    public void TC01_comparingNumberOfPurchaseInvoices() throws InterruptedException, IOException {

        homePageLink_4 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_4");
        websiteLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "websiteLink_5");
        homePageLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_5");
        random = new Random();
        randomNumber = random.nextInt(1000000000);
        itemCode = "item " + randomNumber;
        softAssert = new SoftAssert();
        homePageObj = new HomePage(driver);
        purchaseInvoicesListPageObj = homePageObj.openPurchaseInvoicesListPage();
        String numberOfDraftPurchaseInvoicesBeforeSyncing = purchaseInvoicesListPageObj.getNumberOfDraftInvoicesBeforeSyncing();
        String totalAmountOfPurchaseInvoicesBeforeSyncing = purchaseInvoicesListPageObj.getTotalAmountOfPurchaseInvoicesBeforeSyncing();
//
        loginPageObj = homePageObj.logOutFromDafater_4(homePageLink_4);
//
        loginPageObj.switchToDafater_5(websiteLink_5);
        homePageObj = loginPageObj.loginWithValidData(userName_5, password_5);
        purchaseInvoicesListPageObj = homePageObj.openPurchaseInvoicesListPage();
//        itemListPageObj = homePageObj.openItemListPage();
//
//
        String numberOfDraftPurchaseInvoicesAfterSyncing = purchaseInvoicesListPageObj.getNumberOfDraftInvoicesAfterSyncing();
        String totalAmountOfPurchaseInvoicesAfterSyncing = purchaseInvoicesListPageObj.getTotalAmountOfPurchaseInvoicesAfterSyncing();
//        String numberOfSalesItemsAfterSyncing = itemListPageObj.getNumberOfSalesItemsAfterSyncing();
//        String numberOfPurchaseItemsAfterSyncing = itemListPageObj.getNumberOfPurchaseItemsAfterSyncing();
        System.out.println("verify that number of all draft sales invoices  which appear at dafater 5 is equal to number of all draft sales invoices at dafater 4 ");
//
        softAssert.assertEquals(numberOfDraftPurchaseInvoicesAfterSyncing, numberOfDraftPurchaseInvoicesBeforeSyncing);
//
        System.out.println("verify that total amount of purchase invoices at dafater 5 is equal to  total amount of sales invoices at dafater 4 ");
        softAssert.assertEquals(totalAmountOfPurchaseInvoicesAfterSyncing, totalAmountOfPurchaseInvoicesBeforeSyncing);
        softAssert.assertAll();
    }


}
