package TestCases;

import GeneralConstants.GeneralConstants;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.PurchaseTaxesAndChargesTemplatesListPage;
import io.qameta.allure.Allure;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.Random;

public class ComparingPurchaseTaxesAndChargesTemplatesTest extends BaseTest {
    Random random;
    int randomNumber;
    String itemCode;
    SoftAssert softAssert;

    LoginPage loginPageObj;
    HomePage homePageObj;
    PurchaseTaxesAndChargesTemplatesListPage purchaseTaxesAndChargesTemplatesListPageObj;



    @Test(priority = 1, enabled = true)
    public void TC01_comparingNumberOfPurchaseTaxesAndChargesTemplatesTet() throws InterruptedException, IOException {

        homePageLink_4 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_4");
        websiteLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "websiteLink_5");
        homePageLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_5");
        random = new Random();
        randomNumber = random.nextInt(1000000000);
        itemCode = "item " + randomNumber;
        softAssert = new SoftAssert();
        homePageObj = new HomePage(driver);
        purchaseTaxesAndChargesTemplatesListPageObj = homePageObj.openPurchaseTaxesAndChargesTemplatesListPage();
        String numberOfPurchaseTaxesAndChargesTemplatesBeforeSyncing = purchaseTaxesAndChargesTemplatesListPageObj.getNumberOfPurchaseTaxesAndChargesTemplatesBeforeSyncing();
        loginPageObj = homePageObj.logOutFromDafater_4(homePageLink_4);
        loginPageObj.switchToDafater_5(websiteLink_5);
        homePageObj = loginPageObj.loginWithValidData(userName_5, password_5);
//        waitUntilElementVisibility(homePageObj.salesInvoicesTab,GeneralConstants.minTimeOut);
//        System.out.println("kjssdd" + getWebElement(homePageObj.bankBalanceErrorMsg).getText());
//        System.out.println("kjsds" + getWebElement(homePageObj.bankBalanceErrorMsg).getAttribute("textContent"));
//        if (tryToGetWebElementP(homePageObj.bankBalanceErrorMsg) == GeneralConstants.SUCCESS) {
//            System.out.println("kjhv");
//            homePageObj.closeBankBalanceErrorMsg();
//
//            companiesListPageObj = homePageObj.openCompaniesListPage_5();
//            companyPageObj = companiesListPageObj.openSpecificCompany(companyName);
////                String defaultCreditAccountAtCompanySettings = companyPageObj.getDefaultCreditAccount();
////                String defaultExpenseAccountAtCompanySettings = companyPageObj.getDefaultExpenseAccount();
//        }
        purchaseTaxesAndChargesTemplatesListPageObj = homePageObj.openPurchaseTaxesAndChargesTemplatesListPage();

        String numberOfPurchaseTaxesAndChargesTemplatesAfterSyncing = purchaseTaxesAndChargesTemplatesListPageObj.getNumberOfPurchaseTaxesAndChargesTemplatesAfterSyncing();
       Allure.step("verify that number of all purchase Taxes And Charges Templates which appear at dafater 5 is equal to number of all purchase Taxes And Charges Templates at dafater 4 ");

        softAssert.assertEquals(numberOfPurchaseTaxesAndChargesTemplatesAfterSyncing, numberOfPurchaseTaxesAndChargesTemplatesBeforeSyncing);
        softAssert.assertAll();
       Allure.step(" number of purchase Taxes And Charges Templates which appear at dafater 5 is " + numberOfPurchaseTaxesAndChargesTemplatesAfterSyncing + " and number of all purchase Taxes And Charges Templates at dafater 4 is " + numberOfPurchaseTaxesAndChargesTemplatesBeforeSyncing + " and this is correct ");

    }
}
