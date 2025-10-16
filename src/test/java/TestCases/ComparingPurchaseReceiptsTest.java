package TestCases;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.PurchaseReceiptListPage;
import io.qameta.allure.Allure;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.Random;

public class ComparingPurchaseReceiptsTest extends BaseTest {
    Random random;
    int randomNumber;
    String itemCode;
    SoftAssert softAssert;

    LoginPage loginPageObj;
    HomePage homePageObj;
    PurchaseReceiptListPage purchaseReceiptListPageObj;

    @Test(priority = 1, enabled = true)
    public void TC01_comparingNumberOfPurchaseReceipt() throws InterruptedException, IOException {

        homePageLink_4 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_4");
        websiteLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "websiteLink_5");
        homePageLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_5");
        random = new Random();
        randomNumber = random.nextInt(1000000000);
        itemCode = "item " + randomNumber;
        softAssert = new SoftAssert();
        homePageObj = new HomePage(driver);
        purchaseReceiptListPageObj = homePageObj.openPurchaseReceiptListPage();
        String numberOfAllPurchaseReceiptBeforeSyncing = purchaseReceiptListPageObj.getNumberOfAllPurchaseReceiptsBeforeSyncing();
        loginPageObj = homePageObj.logOutFromDafater_4(homePageLink_4);
        loginPageObj.switchToDafater_5(websiteLink_5);
        homePageObj = loginPageObj.loginWithValidData(userName_5, password_5);
        purchaseReceiptListPageObj = homePageObj.openPurchaseReceiptListPage();
        String numberOfAllPurchaseReceiptAfterSyncing = purchaseReceiptListPageObj.getNumberOfAllPurchaseReceiptsAfterSyncing();
        Allure.step("verify that number of all purchase receipt which appear at dafater 5 is equal to number of all items at dafater 4 ");
        softAssert.assertEquals(numberOfAllPurchaseReceiptBeforeSyncing, numberOfAllPurchaseReceiptAfterSyncing);
        softAssert.assertAll();
        Allure.step(" number of purchase receipt which appear at dafater 5 is " + numberOfAllPurchaseReceiptAfterSyncing + " and number of all purchase receipt at dafater 4 is " + numberOfAllPurchaseReceiptBeforeSyncing + " and this is correct ");

    }


}
