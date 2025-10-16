package TestCases;

import GeneralConstants.GeneralConstants;
import Pages.*;
import io.qameta.allure.Allure;
import org.testng.Assert;
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
        Assert.assertFalse(numberOfDraftPurchaseInvoicesBeforeSyncing.equals(GeneralConstants.FAILED));
        String totalAmountOfPurchaseInvoicesBeforeSyncing = purchaseInvoicesListPageObj.getTotalAmountOfPurchaseInvoicesBeforeSyncing();
        String numberOfPurchaseInvoicesBeforeCreatingNewOne = purchaseInvoicesListPageObj.getListAccountBeforeSyncing();
        loginPageObj = homePageObj.logOutFromDafater_4(homePageLink_4);
        loginPageObj.switchToDafater_5(websiteLink_5);
        homePageObj = loginPageObj.loginWithValidData(userName_5, password_5);
        purchaseInvoicesListPageObj = homePageObj.openPurchaseInvoicesListPage();
        String numberOfDraftPurchaseInvoicesAfterSyncing = purchaseInvoicesListPageObj.getNumberOfDraftInvoicesAfterSyncing();
        String totalAmountOfPurchaseInvoicesAfterSyncing = purchaseInvoicesListPageObj.getTotalAmountOfPurchaseInvoicesAfterSyncing();
        Allure.step("verify that number of all draft purchase invoices  which appear at dafater 5 is equal to number of all draft purchase invoices at dafater 4 ");
        softAssert.assertEquals(numberOfDraftPurchaseInvoicesAfterSyncing, numberOfDraftPurchaseInvoicesBeforeSyncing);
        Allure.step("verify that total amount of purchase invoices at dafater 5 is equal to  total amount of purchase invoices at dafater 4 ");
        softAssert.assertEquals(totalAmountOfPurchaseInvoicesAfterSyncing, totalAmountOfPurchaseInvoicesBeforeSyncing);


        Allure.step(" verify that there is purchase invoice at dafater 4 to be compared");
        Assert.assertFalse(numberOfPurchaseInvoicesBeforeCreatingNewOne.equals("0"));
        softAssert.assertAll();
    }


    @Test(priority = 2, enabled = true, dependsOnMethods = "TC01_comparingNumberOfPurchaseInvoices")
    public void TC02_comparingPurchaseInvoiceDatas() throws InterruptedException, IOException {
        String purchaseInvoiceStatusBeforeSyncing = null;
        String purchaseInvoiceIssueDateBeforeSyncing = null;
        String supplierNameAtPurchaseInvoiceBeforeSyncing = null;
        String netTotalValueBeforeSyncing = null;
        String grandTotalValueBeforeSyncing = null;
        String purchaseInvoiceStatusAfterSyncing = null;
        String purchaseInvoiceIssueDateAfterSyncing = null;
        String supplierNameAtPurchaseInvoiceAfterSyncing = null;
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
        purchaseInvoicesListPageObj = homePageObj.openPurchaseInvoicesListPage();

        String nameOfSelectedPurchaseInvoiceAtDafater_4 = purchaseInvoicesListPageObj.getNameOfFirstPurchaseInvoiceBeforeSyncing();
        purchaseInvoicesPageObj = purchaseInvoicesListPageObj.openFirstPurchaseInvoiceAtDafater_4();
        if (purchaseInvoicesPageObj.getPurchaseInvoiceStatus().contains(submittedStatus)) {
            Allure.step("status of purchase invoice  is  " + submittedStatus);
            purchaseInvoiceStatusBeforeSyncing = purchaseInvoicesPageObj.getPurchaseInvoiceStatus();
            purchaseInvoiceIssueDateBeforeSyncing = purchaseInvoicesPageObj.getPurchaseInvoiceIssueDate();
            supplierNameAtPurchaseInvoiceBeforeSyncing = purchaseInvoicesPageObj.getSupplierNameAtSalesInvoice();
            netTotalValueBeforeSyncing = purchaseInvoicesPageObj.getNetTotalValueAtPurchaseInvoice();
            grandTotalValueBeforeSyncing = purchaseInvoicesPageObj.getGrandTotalValueAtPurchaseInvoice();
        }
        if (purchaseInvoicesPageObj.getPurchaseInvoiceStatus().contains(draftStatus)) {
            Allure.step("status of purchase invoice  is  " + draftStatus);
            purchaseInvoiceStatusBeforeSyncing = purchaseInvoicesPageObj.getPurchaseInvoiceStatus();
            netTotalValueBeforeSyncing = purchaseInvoicesPageObj.getNetTotalValueAtPurchaseInvoice();
            grandTotalValueBeforeSyncing = purchaseInvoicesPageObj.getGrandTotalValueAtPurchaseInvoice();
        }

        loginPageObj = homePageObj.logOutFromDafater_4(homePageLink_4);
        loginPageObj.switchToDafater_5(websiteLink_5);
        homePageObj = loginPageObj.loginWithValidData(userName_5, password_5);
        purchaseInvoicesListPageObj = homePageObj.openPurchaseInvoicesListPage();
        Assert.assertTrue(purchaseInvoicesListPageObj.searchAboutSpecificPurchaseInvoice(nameOfSelectedPurchaseInvoiceAtDafater_4).equals(GeneralConstants.SUCCESS));
//        purchaseInvoicesPageObj = purchaseInvoicesListPageObj.openPurchaseInvoiceAtDafater_5();

        if (purchaseInvoicesPageObj.getPurchaseInvoiceStatus().contains(submittedStatus)) {
            Allure.step("status of purchase invoice  is  " + submittedStatus);
            purchaseInvoiceStatusAfterSyncing = purchaseInvoicesPageObj.getPurchaseInvoiceStatus();
            purchaseInvoiceIssueDateAfterSyncing = purchaseInvoicesPageObj.getPurchaseInvoiceIssueDate();
            supplierNameAtPurchaseInvoiceAfterSyncing = purchaseInvoicesPageObj.getSupplierNameAtSalesInvoice();
            netTotalValueAfterSyncing = purchaseInvoicesPageObj.getNetTotalValueAtPurchaseInvoice();
            grandTotalValueAfterSyncing = purchaseInvoicesPageObj.getGrandTotalValueAtPurchaseInvoice();
        }
        if (purchaseInvoicesPageObj.getPurchaseInvoiceStatus().contains(draftStatus)) {
            Allure.step("status of purchase invoice  is  " + draftStatus);
            purchaseInvoiceStatusBeforeSyncing = purchaseInvoicesPageObj.getPurchaseInvoiceStatus();
            netTotalValueBeforeSyncing = purchaseInvoicesPageObj.getNetTotalValueAtPurchaseInvoice();
            grandTotalValueBeforeSyncing = purchaseInvoicesPageObj.getGrandTotalValueAtPurchaseInvoice();
        }


        if (purchaseInvoicesPageObj.getPurchaseInvoiceStatus().contains(submittedStatus)) {

            Allure.step("verify that the status of purchase invoice " + nameOfSelectedPurchaseInvoiceAtDafater_4 + " at dafater 5 is same as exist at dafater 4 ");
            softAssert.assertEquals(purchaseInvoiceStatusAfterSyncing.trim(), purchaseInvoiceStatusAfterSyncing.trim());
            Allure.step(" status of purchase invoice at dafater 5 is " + purchaseInvoiceStatusAfterSyncing + " and at dafater 4 is " + purchaseInvoiceStatusBeforeSyncing);
            Allure.step("                   ***********************************************************            ");
            Allure.step("verify that the issue date of purchase invoice " + nameOfSelectedPurchaseInvoiceAtDafater_4 + " at dafater 5 is same as exist at dafater 4 ");
            softAssert.assertEquals(purchaseInvoiceIssueDateBeforeSyncing.trim(), purchaseInvoiceIssueDateAfterSyncing.trim());
            Allure.step(" issue date of sales invoice at dafater 5 is " + purchaseInvoiceIssueDateAfterSyncing + " and at dafater 4 is " + purchaseInvoiceIssueDateBeforeSyncing);
            Allure.step("                   ***********************************************************            ");

            Allure.step("verify that the supplier name of purchase invoice " + nameOfSelectedPurchaseInvoiceAtDafater_4 + " at dafater 5 is same as exist at dafater 4 ");
            softAssert.assertEquals(supplierNameAtPurchaseInvoiceBeforeSyncing.trim(), supplierNameAtPurchaseInvoiceAfterSyncing.trim());
            Allure.step(" supplier name of purchase invoice at dafater 5 is " + supplierNameAtPurchaseInvoiceAfterSyncing + " and at dafater 4 is " + supplierNameAtPurchaseInvoiceBeforeSyncing);
            Allure.step("                   ***********************************************************            ");

            Allure.step("verify that the net total value of purchase invoice " + nameOfSelectedPurchaseInvoiceAtDafater_4 + " at dafater 5 is same as exist at dafater 4 ");
            softAssert.assertEquals(netTotalValueBeforeSyncing.trim(), netTotalValueAfterSyncing.trim());
            Allure.step(" net total of purchase value invoice at dafater 5 is " + netTotalValueAfterSyncing + " and at dafater 4 is " + netTotalValueBeforeSyncing);
            Allure.step("                   ***********************************************************            ");

            Allure.step("verify that the grand total value of sales invoice " + nameOfSelectedPurchaseInvoiceAtDafater_4 + " at dafater 5 is same as exist at dafater 4 ");
            softAssert.assertEquals(grandTotalValueAfterSyncing.trim(), grandTotalValueBeforeSyncing.trim());
            Allure.step("  grand total value of sales invoice at dafater 5 is " + grandTotalValueAfterSyncing + " and at dafater 4 is " + grandTotalValueBeforeSyncing);
            Allure.step("                   ***********************************************************            ");

            softAssert.assertAll();
        }

        if (purchaseInvoicesPageObj.getPurchaseInvoiceStatus().contains(draftStatus)) {

            Allure.step("verify that the status of purchase invoice " + nameOfSelectedPurchaseInvoiceAtDafater_4 + " at dafater 5 is same as exist at dafater 4 ");
            softAssert.assertEquals(purchaseInvoiceStatusBeforeSyncing.trim(), purchaseInvoiceStatusAfterSyncing.trim());
            Allure.step(" status of purchase invoice at dafater 5 is " + purchaseInvoiceStatusAfterSyncing + " and at dafater 4 is " + purchaseInvoiceStatusBeforeSyncing);
            Allure.step("                   ***********************************************************            ");

            Allure.step("verify that the net total value of purchase invoice " + nameOfSelectedPurchaseInvoiceAtDafater_4 + " at dafater 5 is same as exist at dafater 4 ");
            softAssert.assertEquals(netTotalValueBeforeSyncing.trim(), netTotalValueAfterSyncing.trim());
            Allure.step(" net total of purchase value invoice at dafater 5 is " + netTotalValueAfterSyncing + " and at dafater 4 is " + netTotalValueBeforeSyncing);
            Allure.step("                   ***********************************************************            ");

            Allure.step("verify that the grand total value of purchase invoice " + nameOfSelectedPurchaseInvoiceAtDafater_4 + " at dafater 5 is same as exist at dafater 4 ");
            softAssert.assertEquals(grandTotalValueAfterSyncing.trim(), grandTotalValueBeforeSyncing.trim());
            Allure.step("  grand total value of purchase invoice at dafater 5 is " + grandTotalValueAfterSyncing + " and at dafater 4 is " + grandTotalValueBeforeSyncing);
            Allure.step("                   ***********************************************************            ");

            softAssert.assertAll();
        }


    }
}
