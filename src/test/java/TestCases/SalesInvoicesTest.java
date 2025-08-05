package TestCases;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SalesInvoicesTest extends BaseTest {
    LoginPage loginPageObj;
    HomePage homePageObj;
    SalesInvoicesListPage salesInvoicesListPageObj;
    SalesOrderListPage salesOrdersListPageObj;
    SalesOrderPage salesOrdersPageObj;
    SalesInvoicesPage salesInvoicesPageObj;
    CreditNotePage creditNotePageObj;
    DataMigrationToolPage dataMigrationToolPageObj;
    private final String vmUrl = "temp-wi28927.dafater.biz";
    private final String duesDate = "15-07-2026";
    private final String secretKey = "kX7NY9yMSag3";
    private final String invalidSecretKey = "kX7NY9yMSag4";
    private final String successfulConnectionMsg = "Connected Successfully";
    private final String failureConnectionMsg = "Cannot Connect";
    private final String submittedStatus = "معتمد";
    private final String draftStatus = "مسودة";
    private final String invoiceName = "ACC-SINV";
    @Test(priority = 1, enabled = true)
    public void TC01_createNewSalesInvoiceAndSaveOnly() throws InterruptedException {
        homePageObj = new HomePage(driver);
        salesInvoicesListPageObj = homePageObj.openSalesInvoicesListPage();
        String numberOfDraftInvoicesBeforeCreatingNewOne = salesInvoicesListPageObj.getNumberOfDraftInvoicesBeforeCreatingNewSalesInvoices();
        String numberOfSalesInvoicesBeforeCreatingNewOne = salesInvoicesListPageObj.getListAccountBeforeCreatingNewSalesInvoices();


        salesInvoicesPageObj = salesInvoicesListPageObj.clickOnNewSalesInvoiceBtn();
        salesInvoicesPageObj.enterValidDataIntoSalesInvoicePageAndSave(duesDate);
        Assert.assertTrue(salesInvoicesPageObj.getInvoiceStatus(draftStatus).contains(draftStatus));

        String salesInvoiceName = salesInvoicesPageObj.getDraftInvoiceName(invoiceName);
        Assert.assertTrue(salesInvoiceName.contains(invoiceName));
        System.out.println("Verify the name of current created sales invoice is existed at sales invoice list view ");
        Assert.assertTrue(salesInvoicesPageObj.getInvoiceNameAtViewList(salesInvoiceName).contains(salesInvoiceName));

        String numberOfSalesInvoicesAfterCreatingNewOne = salesInvoicesListPageObj.getListAccountAfterCreatingNewSalesInvoices();
        System.out.println("verify that number of sales invoices at list view will increase by one after creating new sales invoice ");
        Assert.assertFalse(numberOfSalesInvoicesBeforeCreatingNewOne.contains(numberOfSalesInvoicesAfterCreatingNewOne));
        System.out.println(" number of sales invoices at list view before creating new one is " + numberOfSalesInvoicesBeforeCreatingNewOne+" and after creating new one is  "+ numberOfSalesInvoicesAfterCreatingNewOne+" and this is correct ");





        String numberOfDraftInvoicesAfterCreatingNewOne = salesInvoicesListPageObj.getNumberOfDraftInvoicesAfterCreatingNewDraftSalesInvoices();
        System.out.println("verify that number of draft sales invoices at list view will increase by one after creating new draft sales invoice ");
        Assert.assertFalse(numberOfDraftInvoicesBeforeCreatingNewOne.contains(numberOfDraftInvoicesAfterCreatingNewOne));
        System.out.println(" number of draft sales invoices at list view before creating new one is " + numberOfDraftInvoicesBeforeCreatingNewOne+" and after creating new one is  "+ numberOfDraftInvoicesAfterCreatingNewOne+" and this is correct ");

    }

    @Test(priority = 2, enabled = true)
    public void TC02_createNewSalesInvoiceAndSubmit() throws InterruptedException {
        homePageObj = new HomePage(driver);
        salesInvoicesListPageObj = homePageObj.openSalesInvoicesListPage();
        String numberOfSalesInvoicesBeforeCreatingNewOne = salesInvoicesListPageObj.getListAccountBeforeCreatingNewSalesInvoices();
        salesInvoicesPageObj = salesInvoicesListPageObj.clickOnNewSalesInvoiceBtn();
        salesInvoicesPageObj.enterValidDataIntoSalesInvoicePageAndSumbit(duesDate);

        Assert.assertTrue(salesInvoicesPageObj.getInvoiceStatus(submittedStatus).contains(submittedStatus));
//        System.out.println("verify that the current created sales invoice wil appear at list view with same name  ");
        String salesInvoiceName = salesInvoicesPageObj.getInvoiceName(invoiceName);
        Assert.assertTrue(salesInvoiceName.contains(invoiceName));


        System.out.println("Verify the name of current created sales invoice is existed at sales invoice list view ");
        Assert.assertTrue(salesInvoicesPageObj.getInvoiceNameAtViewList(salesInvoiceName).contains(salesInvoiceName));


        String numberOfSalesInvoicesAfterCreatingNewOne = salesInvoicesListPageObj.getListAccountAfterCreatingNewSalesInvoices();
        System.out.println("verify that number of sales invoices at list view will increase by one after creating new sales invoice ");
        Assert.assertFalse(numberOfSalesInvoicesBeforeCreatingNewOne.contains(numberOfSalesInvoicesAfterCreatingNewOne));
        System.out.println(" number of sales invoices at list view before creating new one is " + numberOfSalesInvoicesBeforeCreatingNewOne+" and after creating new one is  "+ numberOfSalesInvoicesAfterCreatingNewOne+" and this is correct ");



    }

    @Test(priority = 3, enabled = false)
    public void TC03_createNewSalesInvoiceFromSalesOrder() throws InterruptedException {
//         homePageObj = new HomePage(driver);
        salesOrdersListPageObj = homePageObj.openSalesOrdersListPage();
        salesOrdersPageObj = salesOrdersListPageObj.clickOnNewSalesOrdersBtn();
        salesOrdersPageObj.enterValidDataIntoSalesOrderPage(duesDate);
        String salesOrderStatusBeforeCreatingRelatedSalesInvoice = salesOrdersPageObj.getSalesOrderStatusBeforeCreatingRelatedSalesInvoice();
        salesInvoicesPageObj = salesOrdersPageObj.createNewSalesInvoiceFromSalesOrder();
        salesInvoicesPageObj.saveAndSubmitSalesInvoiceFromSalesOrder();

        String salesOrderStatusAfterCreatingRelatedSalesInvoice = salesOrdersPageObj.getSalesOrderStatusAfterCreatingRelatedSalesInvoice();
        System.out.println("verify the status of sales order will change after creating sales invoice from this  sales order ");
        Assert.assertFalse(salesOrderStatusBeforeCreatingRelatedSalesInvoice.contains(salesOrderStatusAfterCreatingRelatedSalesInvoice));
        System.out.println(" status of sales order  before creating related sales invoice is " + salesOrderStatusBeforeCreatingRelatedSalesInvoice+" and after creating related one is  "+ salesOrderStatusAfterCreatingRelatedSalesInvoice+" and this is correct ");

    }

    @Test(priority = 4, enabled = false)
    public void TC04_createCreditNoteFromSalesInvoice() throws InterruptedException {
//        homePageObj = new HomePage(driver);
        salesInvoicesListPageObj = homePageObj.openSalesInvoicesListPage();
        salesInvoicesPageObj = salesInvoicesListPageObj.clickOnNewSalesInvoiceBtn();
        salesInvoicesPageObj.enterValidDataIntoSalesInvoicePageAndSumbit(duesDate);


        String salesInvoiceName = salesInvoicesPageObj.getInvoiceNameForCreditNote(invoiceName);
        creditNotePageObj = salesInvoicesPageObj.createCreditNoteFromSalesInvoice();
        creditNotePageObj.saveAndSubmitCreditNoteFromSalesInvoice();
        System.out.println("verify that credit note will include the same name of it's related sales invoice  ");

        Assert.assertTrue(creditNotePageObj.getInvoiceNameInsideCreditNote(salesInvoiceName).contains(salesInvoiceName));


//        Assert.assertTrue(dataMigrationToolPageObj.checkVmConnectionMsg().getText().contains(successfulConnectionMsg));

    }

}
