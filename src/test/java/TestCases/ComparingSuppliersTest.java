package TestCases;

import Pages.*;
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
        String suppliersDebitsValueBeforeSyncing = suppliersListPageObj.getNumberOfSuppliersDebitsBeforeSyncing();
        String prepaymentNotUsedValueBeforeSyncing = suppliersListPageObj.getNumberOfPrepaymentNotUsedBeforeSyncing();
        loginPageObj = homePageObj.logOutFromDafater_4(homePageLink_4);
        loginPageObj.switchToDafater_5(websiteLink_5);
        homePageObj = loginPageObj.loginWithValidData(userName_5, password_5);
        suppliersListPageObj = homePageObj.openSuppliersListPage();
        String numberOfAllSuppliersAfterSyncing = suppliersListPageObj.getNumberOfAllSuppliersAfterSyncing();
        String suppliersDebitsValueAfterSyncing = suppliersListPageObj.getNumberOfSuppliersDebitsAfterSyncing();
        String prepaymentNotUsedValueAfterSyncing = suppliersListPageObj.getNumberOfPrepaymentNotUsedAfterSyncing();
        System.out.println("verify that number of all suppliers which appear at dafater 5 is equal to number of all suppliers at dafater 4");

        softAssert.assertEquals(numberOfAllSuppliersBeforeSyncing, numberOfAllSuppliersAfterSyncing);

        System.out.println("verify that value of Suppliers Debits which appear at dafater 5 is equal to the value of Suppliers Debits at dafater 4");

        softAssert.assertEquals(suppliersDebitsValueBeforeSyncing, suppliersDebitsValueAfterSyncing);
        System.out.println("verify that prepayment Not Used value  which appear at dafater 5 is equal to prepayment Not Used value at dafater 4");
        softAssert.assertEquals(prepaymentNotUsedValueBeforeSyncing, prepaymentNotUsedValueAfterSyncing);
        softAssert.assertAll();

    }


}
