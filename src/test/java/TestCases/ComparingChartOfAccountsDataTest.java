package TestCases;

import Pages.*;
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
    ChartOfAccountsPage chartOfAccountsPage;
    SetupPage setupPageObj;
    PeriodClosingVoucherListPage periodClosingVoucherListPageObj;
    PeriodClosingVoucherPage periodClosingVoucherPageObj;
//test
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
        String assetsAccountValueBeforeSyncing = chartOfAccountsPage.getValueOfAssetsAccountBeforeSyncing().replace(",", "");
        String obligationsAccountValueBeforeSyncing = chartOfAccountsPage.getValueOfObligationsAccountBeforeSyncing().replace(",", "");
        String revenuesِAccountValueBeforeSyncing = chartOfAccountsPage.getValueOfRevenuesAccountBeforeSyncing().replace(",", "");
        String expensesِAccountValueBeforeSyncing = chartOfAccountsPage.getValueOfExpensesAccountBeforeSyncing().replace(",", "");
        loginPageObj = homePageObj.logOutFromDafater_4(homePageLink_4);
        loginPageObj.switchToDafater_5(websiteLink_5);
        homePageObj = loginPageObj.loginWithValidData(userName_5, password_5);
        chartOfAccountsPage = homePageObj.openChartOfAccountsPage();

        String assetsAccountValueAfterSyncing = chartOfAccountsPage.getValueOfAssetsAccountAfterSyncing().replace(",", "");
        String obligationsAccountValueAfterSyncing = chartOfAccountsPage.getValueOfObligationsAccountAfterSyncing().replace(",", "");

        setupPageObj = homePageObj.openSetupPage();
        fiscalYearListPageObj = setupPageObj.openFiscalYearListPage();
        int numberOfFiscalYears = Integer.parseInt(fiscalYearListPageObj.getNumberOfAllFiscalYearsAfterSyncing());
        periodClosingVoucherListPageObj = chartOfAccountsPage.openPeriodClosingVoucherListPage();

        for (int counter = 1; counter < numberOfFiscalYears; counter++) {

            if (periodClosingVoucherListPageObj.getPeriodClosingVoucherListCount() == numberOfFiscalYears-1) {
                break;
            }
            periodClosingVoucherPageObj = periodClosingVoucherListPageObj.openPeriodClosingVoucherPage();
            periodClosingVoucherPageObj.addPeriodClosingVoucher(counter);
        }

        chartOfAccountsPage = homePageObj.openChartOfAccountsPage();
        String revenuesِAccountValueAfterSyncing = chartOfAccountsPage.getValueOfRevenuesAccountAfterSyncing().replace(",", "");
        String expensesِAccountValueAfterSyncing = chartOfAccountsPage.getValueOfExpensesAccountAfterSyncing().replace(",", "");
        Allure.step("verify that value at assets account which appear at dafater 5 is equal to value at assets account at dafater 4 ");
        softAssert.assertEquals((long) Double.parseDouble(assetsAccountValueBeforeSyncing.trim()), (long) Double.parseDouble(assetsAccountValueAfterSyncing.trim()));
        Allure.step(" value at assets account which appear at dafater 5 is " + (long) Double.parseDouble(assetsAccountValueAfterSyncing) + " and value at assets account at dafater 4 is " + (long) Double.parseDouble(assetsAccountValueBeforeSyncing) + " and this is correct ");

        Allure.step("verify that value at obligations account which appear at dafater 5 is equal to value at obligations account at dafater 4 ");
        softAssert.assertEquals((long) Double.parseDouble(obligationsAccountValueBeforeSyncing.trim()), (long) Double.parseDouble(obligationsAccountValueAfterSyncing.trim()));
        Allure.step(" value at obligations account which appear at dafater 5 is " + (long) Double.parseDouble(obligationsAccountValueAfterSyncing) + " and value at obligations account at dafater 4 is " + (long) Double.parseDouble(obligationsAccountValueBeforeSyncing) + " and this is correct ");

        System.out.println("tefedf"+(long) Double.parseDouble(revenuesِAccountValueBeforeSyncing.trim()));
        System.out.println("teffffffffffffedf"+(long) Double.parseDouble(revenuesِAccountValueAfterSyncing.trim()));
        Allure.step("verify that value at revenue account which appear at dafater 5 is equal to value at revenue account at dafater 4 ");
        softAssert.assertEquals((long) Double.parseDouble(revenuesِAccountValueBeforeSyncing.trim()), (long) Double.parseDouble(revenuesِAccountValueAfterSyncing.trim()));
        Allure.step(" value at revenue account which appear at dafater 5 is " + (long) Double.parseDouble(revenuesِAccountValueAfterSyncing) + " and value at revenue account at dafater 4 is " + (long) Double.parseDouble(revenuesِAccountValueBeforeSyncing) + " and this is correct ");




        System.out.println("tefedf"+(long) Double.parseDouble(expensesِAccountValueBeforeSyncing.trim()));
        System.out.println("teffffffffffffedf"+(long) Double.parseDouble(expensesِAccountValueAfterSyncing.trim()));
        Allure.step("verify that value at expense account which appear at dafater 5 is equal to value at expense account at dafater 4 ");
        softAssert.assertEquals((long) Double.parseDouble(expensesِAccountValueBeforeSyncing.trim()), (long) Double.parseDouble(expensesِAccountValueAfterSyncing.trim()));
        Allure.step(" value at expense account which appear at dafater 5 is " + (long) Double.parseDouble(expensesِAccountValueAfterSyncing) + " and value at expense account at dafater 4 is " + (long) Double.parseDouble(expensesِAccountValueBeforeSyncing) + " and this is correct ");


        softAssert.assertAll();
    }
}
