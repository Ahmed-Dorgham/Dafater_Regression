package TestCases;

import GeneralConstants.GeneralConstants;
import Pages.*;
import io.qameta.allure.Allure;
import org.testng.Assert;
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
    ReportsListPage reportsListPageObj;
    SalesInvoicesPage salesInvoicesPageObj;
    GeneralLedgerReportPage generalLedgerReportPageObj;

    private final String submittedStatus = "تم الارسال الي هيئة الزكاة والدخل بنجاح";
    private final String draftStatus = "مسودة";


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
        Allure.step("verify that number of all draft sales invoices  which appear at dafater 5 is equal to number of all draft sales invoices at dafater 4 ");

        softAssert.assertEquals(numberOfDraftSalesInvoicesAfterSyncing, numberOfDraftSalesInvoicesBeforeSyncing);
        Allure.step("verify that total amount of sales invoices at dafater 5 is equal to  total amount of sales invoices at dafater 4 ");

        softAssert.assertEquals(totalAmountOfSalesInvoicesAfterSyncing, totalAmountOfSalesInvoicesBeforeSyncing);
        softAssert.assertAll();
    }

    @Test(priority = 2, enabled = true)
    public void TC02_comparingSalesInvoiceData() throws InterruptedException, IOException {
        String salesInvoiceStatusBeforeSyncing = null;
        String salesInvoiceStatusAfterSyncing = null;
        String salesInvoicePaidStatusBeforeSyncing = null;
        String salesInvoicePaidStatusAfterSyncing = null;
        String salesInvoiceIssueDateAfterSyncing = null;
        String salesInvoiceIssueDateBeforeSyncing = null;
        String customerNameAtSalesInvoiceBeforeSyncing = null;
        String customerNameAtSalesInvoiceAfterSyncing = null;
        String netTotalValueBeforeSyncing = null;
        String grandTotalValueBeforeSyncing = null;
        String netTotalValueAfterSyncing = null;
        String grandTotalValueAfterSyncing = null;
        homePageLink_4 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_4");
        websiteLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "websiteLink_5");
        homePageLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_5");
        random = new Random();
        randomNumber = random.nextInt(1000000000);
        itemCode = "item " + randomNumber;
        softAssert = new SoftAssert();
        homePageObj = new HomePage(driver);
        salesInvoicesListPageObj = homePageObj.openSalesInvoicesListPage();
        String nameOfSelectedSalesInvoiceAtDafater_4 = salesInvoicesListPageObj.getNameOfFirstSalesInvoiceBeforeSyncing();
        salesInvoicesPageObj = salesInvoicesListPageObj.openFirstSalesInvoiceAtDafater_4();

        if (salesInvoicesPageObj.getSalesInvoiceStatus().contains(submittedStatus)) {
            Allure.step("status of sales invoice  is  " + submittedStatus);
            salesInvoiceStatusBeforeSyncing = salesInvoicesPageObj.getSalesInvoiceStatus();

            salesInvoicePaidStatusBeforeSyncing = salesInvoicesPageObj.getSalesInvoicePaidStatus();
            salesInvoiceIssueDateBeforeSyncing = salesInvoicesPageObj.getSalesInvoiceIssueDate();
            customerNameAtSalesInvoiceBeforeSyncing = salesInvoicesPageObj.getCustomerNameAtSalesInvoice();
            netTotalValueBeforeSyncing = salesInvoicesPageObj.getNetTotalValueAtSalesInvoice();
            grandTotalValueBeforeSyncing = salesInvoicesPageObj.getGrandTotalValueAtSalesInvoice();
        }
        if (salesInvoicesPageObj.getSalesInvoiceStatus().contains(draftStatus)) {
            Allure.step("status of sales invoice  is  " + draftStatus);
            salesInvoiceStatusBeforeSyncing = salesInvoicesPageObj.getSalesInvoiceStatus();
            salesInvoicePaidStatusBeforeSyncing = salesInvoicesPageObj.getSalesInvoicePaidStatus();
            netTotalValueBeforeSyncing = salesInvoicesPageObj.getNetTotalValueAtSalesInvoice();
            grandTotalValueBeforeSyncing = salesInvoicesPageObj.getGrandTotalValueAtSalesInvoice();
        }
        loginPageObj = homePageObj.logOutFromDafater_4(homePageLink_4);
        loginPageObj.switchToDafater_5(websiteLink_5);
        homePageObj = loginPageObj.loginWithValidData(userName_5, password_5);
        salesInvoicesListPageObj = homePageObj.openSalesInvoicesListPage();
        Assert.assertTrue(salesInvoicesListPageObj.searchAboutSpecificSalesInvoice(nameOfSelectedSalesInvoiceAtDafater_4).equals(GeneralConstants.SUCCESS));
//        salesInvoicesPageObj = salesInvoicesListPageObj.openSalesInvoiceAtDafater_5();


        if (salesInvoicesPageObj.getSalesInvoiceStatus().contains("معتمد")) {
            Allure.step("status of sales invoice  is  " + submittedStatus);
            salesInvoiceStatusAfterSyncing = salesInvoicesPageObj.getSalesInvoiceStatusAtDafater_5();
            salesInvoicePaidStatusAfterSyncing = salesInvoicesPageObj.getSalesInvoicePaidStatus();
            salesInvoiceIssueDateAfterSyncing = salesInvoicesPageObj.getSalesInvoiceIssueDate();
            customerNameAtSalesInvoiceAfterSyncing = salesInvoicesPageObj.getCustomerNameAtSalesInvoiceAtDafater_5();
            netTotalValueAfterSyncing = salesInvoicesPageObj.getNetTotalValueAtSalesInvoice();
            grandTotalValueAfterSyncing = salesInvoicesPageObj.getGrandTotalValueAtSalesInvoice();
        }
        if (salesInvoicesPageObj.getSalesInvoiceStatusAtDafater_5().contains(draftStatus)) {
            Allure.step("status of sales invoice  is  " + draftStatus);
            salesInvoiceStatusAfterSyncing = salesInvoicesPageObj.getSalesInvoiceStatusAtDafater_5();
            salesInvoicePaidStatusAfterSyncing = salesInvoicesPageObj.getSalesInvoicePaidStatus();

            netTotalValueAfterSyncing = salesInvoicesPageObj.getNetTotalValueAtSalesInvoice();
            grandTotalValueAfterSyncing = salesInvoicesPageObj.getGrandTotalValueAtSalesInvoice();
        }
        if (salesInvoicesPageObj.getSalesInvoiceStatus().contains("معتمد")) {

            Allure.step("verify that the status of sales invoice at dafater 5 is same as exist at dafater 4 ");
            softAssert.assertEquals(salesInvoiceStatusBeforeSyncing.trim(), salesInvoiceStatusAfterSyncing.trim());
            Allure.step(" status of sales invoice at dafater 5 is " + salesInvoiceStatusAfterSyncing + " and at dafater 4 is " + salesInvoiceStatusBeforeSyncing);
            Allure.step("                   ***********************************************************            ");

            Allure.step("verify that the paid status of sales invoice " + nameOfSelectedSalesInvoiceAtDafater_4 + " at dafater 5 is same as exist at dafater 4 ");
            softAssert.assertEquals(salesInvoicePaidStatusBeforeSyncing.trim(), salesInvoicePaidStatusAfterSyncing.trim());
            Allure.step(" paid status of sales invoice at dafater 5 is " + salesInvoicePaidStatusAfterSyncing + " and at dafater 4 is " + salesInvoicePaidStatusBeforeSyncing);
            Allure.step("                   ***********************************************************            ");

            Allure.step("verify that the issue date of sales invoice " + nameOfSelectedSalesInvoiceAtDafater_4 + " at dafater 5 is same as exist at dafater 4 ");
            softAssert.assertEquals(salesInvoiceIssueDateBeforeSyncing.trim(), salesInvoiceIssueDateAfterSyncing.trim());
            Allure.step(" issue date of sales invoice at dafater 5 is " + salesInvoiceIssueDateAfterSyncing + " and at dafater 4 is " + salesInvoiceIssueDateBeforeSyncing);
            Allure.step("                   ***********************************************************            ");

            Allure.step("verify that the customer name of sales invoice " + nameOfSelectedSalesInvoiceAtDafater_4 + " at dafater 5 is same as exist at dafater 4 ");
            softAssert.assertEquals(customerNameAtSalesInvoiceBeforeSyncing.trim(), customerNameAtSalesInvoiceAfterSyncing.trim());
            Allure.step(" customer name of sales invoice at dafater 5 is " + customerNameAtSalesInvoiceAfterSyncing + " and at dafater 4 is " + customerNameAtSalesInvoiceBeforeSyncing);
            Allure.step("                   ***********************************************************            ");

            Allure.step("verify that the net total value of sales invoice " + nameOfSelectedSalesInvoiceAtDafater_4 + " at dafater 5 is same as exist at dafater 4 ");
            softAssert.assertEquals(netTotalValueBeforeSyncing.trim(), netTotalValueAfterSyncing.trim());
            Allure.step(" net total of sales value invoice at dafater 5 is " + netTotalValueAfterSyncing + " and at dafater 4 is " + netTotalValueBeforeSyncing);
            Allure.step("                   ***********************************************************            ");

            Allure.step("verify that the grand total value of sales invoice " + nameOfSelectedSalesInvoiceAtDafater_4 + " at dafater 5 is same as exist at dafater 4 ");
            softAssert.assertEquals(grandTotalValueAfterSyncing.trim(), grandTotalValueBeforeSyncing.trim());
            Allure.step("  grand total value of sales invoice at dafater 5 is " + grandTotalValueAfterSyncing + " and at dafater 4 is " + grandTotalValueBeforeSyncing);
            Allure.step("                   ***********************************************************            ");

            softAssert.assertAll();
        }

        if (salesInvoicesPageObj.getSalesInvoiceStatus().contains(draftStatus)) {

            Allure.step("verify that the status of sales invoice at dafater 5 is same as exist at dafater 4 ");
            softAssert.assertEquals(salesInvoiceStatusBeforeSyncing.trim(), salesInvoiceStatusAfterSyncing.trim());
            Allure.step(" status of sales invoice at dafater 5 is " + salesInvoiceStatusAfterSyncing + " and at dafater 4 is " + salesInvoiceStatusBeforeSyncing);
            Allure.step("                   ***********************************************************            ");

            Allure.step("verify that the paid status of sales invoice " + nameOfSelectedSalesInvoiceAtDafater_4 + " at dafater 5 is same as exist at dafater 4 ");
            softAssert.assertEquals(salesInvoicePaidStatusBeforeSyncing.trim(), salesInvoicePaidStatusAfterSyncing.trim());
            Allure.step(" paid status of sales invoice at dafater 5 is " + salesInvoicePaidStatusAfterSyncing + " and at dafater 4 is " + salesInvoicePaidStatusBeforeSyncing);

            Allure.step("                   ***********************************************************            ");

            Allure.step("verify that the net total value of sales invoice " + nameOfSelectedSalesInvoiceAtDafater_4 + " at dafater 5 is same as exist at dafater 4 ");
            softAssert.assertEquals(netTotalValueBeforeSyncing.trim(), netTotalValueAfterSyncing.trim());
            Allure.step(" net total of sales value invoice at dafater 5 is " + netTotalValueAfterSyncing + " and at dafater 4 is " + netTotalValueBeforeSyncing);
            Allure.step("                   ***********************************************************            ");

            Allure.step("verify that the grand total value of sales invoice " + nameOfSelectedSalesInvoiceAtDafater_4 + " at dafater 5 is same as exist at dafater 4 ");
            softAssert.assertEquals(grandTotalValueBeforeSyncing.trim(), grandTotalValueAfterSyncing.trim());
            Allure.step("  grand total value of sales invoice at dafater 5 is " + grandTotalValueAfterSyncing + " and at dafater 4 is " + grandTotalValueBeforeSyncing);
            Allure.step("                   ***********************************************************            ");

            softAssert.assertAll();
        }

    }

    @Test(priority = 3, enabled = true)
    public void TC03_comparingSalesInvoiceDataAtGL() throws InterruptedException, IOException {
        homePageLink_4 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_4");
        websiteLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "websiteLink_5");
        homePageLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_5");
        random = new Random();
        randomNumber = random.nextInt(1000000000);
        itemCode = "item " + randomNumber;
        softAssert = new SoftAssert();
        homePageObj = new HomePage(driver);
        salesInvoicesListPageObj = homePageObj.openSalesInvoicesListPage();
        String nameOfSelectedSalesInvoiceAtDafater_4 = salesInvoicesListPageObj.getNameOfFirstSalesInvoiceBeforeSyncing();
        reportsListPageObj = salesInvoicesListPageObj.openReportsListPage();
        generalLedgerReportPageObj = reportsListPageObj.openGeneralLedgerReport();
        companyName = generalLedgerReportPageObj.chooseCompany();
        generalLedgerReportPageObj.searchAboutSpecificVoucher(nameOfSelectedSalesInvoiceAtDafater_4);
        generalLedgerReportPageObj.clickOnLoadDataBtn();
        Allure.step("debit value for this sales invoice" + nameOfSelectedSalesInvoiceAtDafater_4 + "  before syncing  ");
        String debitValueOfSpecificVoucherBeforeSyncing = generalLedgerReportPageObj.getDebitValue();
        Allure.step("credit  value for this sales invoice" + nameOfSelectedSalesInvoiceAtDafater_4 + "  before syncing  ");
        String creditValueOfSpecificVoucherBeforeSyncing = generalLedgerReportPageObj.getCreditValue();
        loginPageObj = homePageObj.logOutFromDafater_4(homePageLink_4);
        loginPageObj.switchToDafater_5(websiteLink_5);
        homePageObj = loginPageObj.loginWithValidData(userName_5, password_5);
        reportsListPageObj = homePageObj.openReportsListPage();
        generalLedgerReportPageObj = reportsListPageObj.openGeneralLedgerReport();
        generalLedgerReportPageObj.applyFiltersWithCompanyAndVoucherName_5(companyName, nameOfSelectedSalesInvoiceAtDafater_4);
        String debitValueOfSpecificAccountAfterSyncing = generalLedgerReportPageObj.getDebitValue_5();
        String creditValueOfSpecificAccountAfterSyncing = generalLedgerReportPageObj.getCreditValue_5();
        Allure.step("verify that debit value of this voucher " + nameOfSelectedSalesInvoiceAtDafater_4 + " which exist at dafater 5 is equal to debit value for the same voucher at dafater 4 ");
        softAssert.assertEquals(debitValueOfSpecificVoucherBeforeSyncing, debitValueOfSpecificAccountAfterSyncing);
        Allure.step("debit value at dafater 4  before syncing is " + debitValueOfSpecificVoucherBeforeSyncing + " and after syncing at dafater 5 is " + debitValueOfSpecificAccountAfterSyncing);
        Allure.step("verify that credit value of this voucher " + nameOfSelectedSalesInvoiceAtDafater_4 + " which exist at dafater 5 is equal to credit value for the same voucher at dafater 4 ");
        softAssert.assertEquals(creditValueOfSpecificVoucherBeforeSyncing, creditValueOfSpecificAccountAfterSyncing);
        Allure.step("credit value at dafater 4  before syncing is " + creditValueOfSpecificVoucherBeforeSyncing + " and after syncing at dafater 5 is " + creditValueOfSpecificAccountAfterSyncing);
        softAssert.assertAll();

    }
}
