package TestCases;

import Pages.*;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.Random;

public class ComparingWareHousesTest extends BaseTest {
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
    WareHouseListPage wareHouseListPageObj;

    private final String duesDate = "15-07-2026";
    private final String secretKey = "kX7NY9yMSag3";
    private final String invalidSecretKey = "kX7NY9yMSag4";
    private final String successfulConnectionMsg = "Connected Successfully";
    private final String failureConnectionMsg = "Cannot Connect";
    private final String submittedStatus = "معتمد";
    private final String draftStatus = "مسودة";
    private final String invoiceName = "ACC-SINV";

    @Test(priority = 1, enabled = true)
    public void TC01_comparingNumberOfWareHouses() throws InterruptedException, IOException {

        homePageLink_4 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_4");
        websiteLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "websiteLink_5");
        homePageLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_5");
        random = new Random();
        randomNumber = random.nextInt(1000000000);
        itemCode = "item " + randomNumber;
        softAssert = new SoftAssert();
        homePageObj = new HomePage(driver);
        wareHouseListPageObj = homePageObj.openWareHouseListPage();
        String numberOfAllTotalWareHousesBeforeSyncing = wareHouseListPageObj.getNumberOfAllWareHousesBeforeSyncing();
        loginPageObj = homePageObj.logOutFromDafater_4(homePageLink_4);
        loginPageObj.switchToDafater_5(websiteLink_5);
        homePageObj = loginPageObj.loginWithValidData(userName_5, password_5);
        wareHouseListPageObj = homePageObj.openWareHouseListPage();

        String numberOfAllWareHousesAfterSyncing = wareHouseListPageObj.getNumberOfAllWareHousesAfterSyncing();

       Allure.step("verify that number of all warehouses which appear at dafater 5 is equal to number of all warehouses at dafater 4 ");
        System.out.println(" number of warehouses which appear at dafater 5 is " + numberOfAllWareHousesAfterSyncing+" and number of all warehouses at dafater 4 is "+ numberOfAllTotalWareHousesBeforeSyncing +" and this is correct ");

        Assert.assertEquals(numberOfAllTotalWareHousesBeforeSyncing, numberOfAllWareHousesAfterSyncing);

       Allure.step(" number of warehouses which appear at dafater 5 is " + numberOfAllWareHousesAfterSyncing+" and number of all warehouses at dafater 4 is "+ numberOfAllTotalWareHousesBeforeSyncing +" and this is correct ");



    }


}
