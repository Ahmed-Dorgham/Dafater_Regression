package TestCases;

import Pages.ChartOfAccountsPage;
import Pages.HomePage;
import Pages.JournalEntrytListPage;
import Pages.LoginPage;
import io.qameta.allure.Allure;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.Random;

public class ComparingChartOfAccountsDataTest extends BaseTest {
    Random random;
    int randomNumber;
    String itemCode;
    SoftAssert softAssert;

    LoginPage loginPageObj;
    HomePage homePageObj;
    JournalEntrytListPage journalEntryListPageObj;
    ChartOfAccountsPage chartOfAccountsPage ;

    @Test(priority = 1, enabled = true)
    public void TC01_comparingChartOfAccountsDataTest() throws InterruptedException, IOException {

        homePageLink_4 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_4");
        websiteLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "websiteLink_5");
        homePageLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_5");
        random = new Random();
        randomNumber = random.nextInt(1000000000);
        itemCode = "item " + randomNumber;
        softAssert = new SoftAssert();
        homePageObj = new HomePage(driver);
        chartOfAccountsPage = homePageObj.openChartOfAccountsPage();
        String assetsAccountValueBeforeSyncing = chartOfAccountsPage.getValueOfAssetsAccountBeforeSyncing();
        String obligationsAccountValueBeforeSyncing = chartOfAccountsPage.getValueOfObligationsAccountBeforeSyncing();
//        String revenuesِAccountValueBeforeSyncing = chartOfAccountsPage.getValueOfRevenuesAccountBeforeSyncing();
//        String expensesِAccountValueBeforeSyncing = chartOfAccountsPage.getValueOfExpensesAccountBeforeSyncing();
        loginPageObj = homePageObj.logOutFromDafater_4(homePageLink_4);
        loginPageObj.switchToDafater_5(websiteLink_5);
        homePageObj = loginPageObj.loginWithValidData(userName_5, password_5);
        chartOfAccountsPage = homePageObj.openChartOfAccountsPage();

        String assetsAccountValueAfterSyncing = chartOfAccountsPage.getValueOfAssetsAccountAfterSyncing();
        String obligationsAccountValueAfterSyncing = chartOfAccountsPage.getValueOfObligationsAccountAfterSyncing();
        String revenuesِAccountValueAfterSyncing = chartOfAccountsPage.getValueOfRevenuesAccountAfterSyncing();
        String expensesِAccountValueAfterSyncing = chartOfAccountsPage.getValueOfExpensesAccountAfterSyncing();
        Allure.step("verify that value at assets account which appear at dafater 5 is equal to value at assets account at dafater 4 ");
        softAssert.assertEquals(assetsAccountValueBeforeSyncing.trim(), assetsAccountValueAfterSyncing.trim());
        Allure.step(" value at assets account which appear at dafater 5 is " + assetsAccountValueAfterSyncing + " and value at assets account at dafater 4 is " + assetsAccountValueBeforeSyncing + " and this is correct ");

        Allure.step("verify that value at obligations account which appear at dafater 5 is equal to value at obligations account at dafater 4 ");
        softAssert.assertEquals(obligationsAccountValueBeforeSyncing.trim(), obligationsAccountValueAfterSyncing.trim());
        Allure.step(" value at obligations account which appear at dafater 5 is " + obligationsAccountValueAfterSyncing + " and value at obligations account at dafater 4 is " + obligationsAccountValueBeforeSyncing + " and this is correct ");




        softAssert.assertAll();
    }
}
