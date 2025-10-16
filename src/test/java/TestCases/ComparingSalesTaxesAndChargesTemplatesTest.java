package TestCases;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.SalesTaxesAndChargesTemplatesListPage;
import io.qameta.allure.Allure;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.Random;

public class ComparingSalesTaxesAndChargesTemplatesTest extends BaseTest {
    Random random;
    int randomNumber;
    String itemCode;
    SoftAssert softAssert;

    LoginPage loginPageObj;
    HomePage homePageObj;
    SalesTaxesAndChargesTemplatesListPage salesTaxesAndChargesTemplatesListPageObj;



    @Test(priority = 1, enabled = true)
    public void TC01_comparingNumberOfSalesTaxesAndChargesTemplatesTet() throws InterruptedException, IOException {

        homePageLink_4 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_4");
        websiteLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "websiteLink_5");
        homePageLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_5");
        random = new Random();
        randomNumber = random.nextInt(1000000000);
        itemCode = "item " + randomNumber;
        softAssert = new SoftAssert();
        homePageObj = new HomePage(driver);
        salesTaxesAndChargesTemplatesListPageObj = homePageObj.openSalesTaxesAndChargesTemplatesListPage();
        String numberOfSalesTaxesAndChargesTemplatesBeforeSyncing = salesTaxesAndChargesTemplatesListPageObj.getNumberOfSalesTaxesAndChargesTemplatesBeforeSyncing();
        loginPageObj = homePageObj.logOutFromDafater_4(homePageLink_4);
        loginPageObj.switchToDafater_5(websiteLink_5);
        homePageObj = loginPageObj.loginWithValidData(userName_5, password_5);
        salesTaxesAndChargesTemplatesListPageObj = homePageObj.openSalesTaxesAndChargesTemplatesListPage();

        String numberOfSalesTaxesAndChargesTemplatesAfterSyncing = salesTaxesAndChargesTemplatesListPageObj.getNumberOfSalesTaxesAndChargesTemplatesAfterSyncing();
        Allure.step("verify that number of all Sales Taxes And Charges Templates which appear at dafater 5 is equal to number of all Sales Taxes And Charges Templates at dafater 4 ");

        softAssert.assertEquals(numberOfSalesTaxesAndChargesTemplatesAfterSyncing, numberOfSalesTaxesAndChargesTemplatesBeforeSyncing);
        softAssert.assertAll();
        Allure.step(" number of Sales Taxes And Charges Templates which appear at dafater 5 is " + numberOfSalesTaxesAndChargesTemplatesAfterSyncing + " and number of all Sales Taxes And Charges Templates at dafater 4 is " + numberOfSalesTaxesAndChargesTemplatesBeforeSyncing + " and this is correct ");

    }
}
