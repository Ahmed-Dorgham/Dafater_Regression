package TestCases;

import Pages.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.Random;

public class ComparingItemsTest extends BaseTest {
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
    private final String duesDate = "15-07-2026";
    private final String secretKey = "kX7NY9yMSag3";
    private final String invalidSecretKey = "kX7NY9yMSag4";
    private final String successfulConnectionMsg = "Connected Successfully";
    private final String failureConnectionMsg = "Cannot Connect";
    private final String submittedStatus = "معتمد";
    private final String draftStatus = "مسودة";
    private final String invoiceName = "ACC-SINV";

    @Test(priority = 1, enabled = true)
    public void TC01_comparingNumberOfItems() throws InterruptedException, IOException {

        homePageLink_4 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_4");
        websiteLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "websiteLink_5");
        homePageLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_5");
        random = new Random();
        randomNumber = random.nextInt(1000000000);
        itemCode = "item " + randomNumber;
        softAssert = new SoftAssert();
        homePageObj = new HomePage(driver);
        itemListPageObj = homePageObj.openItemListPage();
        String numberOfAllItemsBeforeSyncing = itemListPageObj.getNumberOfAllItemsBeforeSyncing();
        String numberOfSalesItemsBeforeSyncing = itemListPageObj.getNumberOfSalesItemsBeforeSyncing();
        String numberOfPurchaseItemsBeforeSyncing = itemListPageObj.getNumberOfPurchaseItemsBeforeSyncing();

        loginPageObj = homePageObj.logOutFromDafater_4(homePageLink_4);
        loginPageObj.switchToDafater_5(websiteLink_5);
        homePageObj = loginPageObj.loginWithValidData(userName_5, password_5);
        itemListPageObj = homePageObj.openItemListPage();
        String numberOfAllItemsAfterSyncing = itemListPageObj.getNumberOfAllItemsAfterSyncing();
        String numberOfSalesItemsAfterSyncing = itemListPageObj.getNumberOfSalesItemsAfterSyncing();
        String numberOfPurchaseItemsAfterSyncing = itemListPageObj.getNumberOfPurchaseItemsAfterSyncing();
        System.out.println("verify that number of all items which appear at dafater 5 is equal to number of all items at dafater 4 ");

        softAssert.assertEquals(numberOfAllItemsBeforeSyncing, numberOfAllItemsAfterSyncing);

        System.out.println("verify that number of sales items which appear at dafater 5 is equal to number of all items at dafater 4 ");

        softAssert.assertEquals(numberOfSalesItemsBeforeSyncing, numberOfSalesItemsAfterSyncing);
        System.out.println("verify that number of purchase items which appear at dafater 5 is equal to number of all items at dafater 4 ");
        softAssert.assertEquals(numberOfPurchaseItemsBeforeSyncing, numberOfPurchaseItemsAfterSyncing);
        softAssert.assertAll();

    }


}
