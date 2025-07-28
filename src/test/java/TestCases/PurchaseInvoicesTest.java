package TestCases;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PurchaseInvoicesTest extends BaseTest {
    LoginPage loginPageObj;
    HomePage homePageObj;
    PurchaseInvoicesListPage purchaseInvoicesListPageObj;
    PurchaseOrderListPage purchaseOrdersListPageObj;
    PurchaseOrderPage purchaseOrdersPageObj;
    PurchaseInvoicesPage purchaseInvoicesPageObj;
    DebitNotePage debitNotePageObj;

    private final String vmUrl = "temp-wi28927.dafater.biz";
    private final String duesDate = "15-07-2026";
    private final String secretKey = "kX7NY9yMSag3";
    private final String invalidSecretKey = "kX7NY9yMSag4";
    private final String successfulConnectionMsg = "Connected Successfully";
    private final String failureConnectionMsg = "Cannot Connect";
    private final String submittedStatus = "معتمد";
    private final String invoiceName = "ACC-PINV";

    @Test(priority = 1, enabled = true)
    public void createNewPurchaseInvoiceAndSubmit() throws InterruptedException {
        homePageObj = new HomePage(driver);
        purchaseInvoicesListPageObj = homePageObj.openPurchaseInvoicesListPage();
        String numberOfPurchaseInvoicesBeforeCreatingNewOne = purchaseInvoicesListPageObj.getListAccountBeforeCreatingNewPurchaseInvoices();
        purchaseInvoicesPageObj = purchaseInvoicesListPageObj.clickOnNewPurchaseInvoiceBtn();
        purchaseInvoicesPageObj.enterValidDataIntoPurchaseInvoicePage();
        Assert.assertTrue(purchaseInvoicesPageObj.getInvoiceStatus(submittedStatus).contains(submittedStatus));
        String purchaseInvoiceName = purchaseInvoicesPageObj.getInvoiceName(invoiceName);
        Assert.assertTrue(purchaseInvoiceName.contains(invoiceName));
        purchaseInvoicesListPageObj = purchaseInvoicesPageObj.goToPurchaseListView();
        System.out.println("Verify the name of current created purchase invoice is existed at purchase  invoice list view ");
        Assert.assertTrue(purchaseInvoicesListPageObj.getInvoiceNameAtViewList(purchaseInvoiceName).contains(purchaseInvoiceName));
        String numberOfPurchaseInvoicesAfterCreatingNewOne = purchaseInvoicesListPageObj.getListAccountAfterCreatingNewSalesInvoices();
        System.out.println("verify that number of purchase invoices at list view will increase by one after creating new purchase invoice ");
        Assert.assertFalse(numberOfPurchaseInvoicesBeforeCreatingNewOne.contains(numberOfPurchaseInvoicesAfterCreatingNewOne));
        System.out.println("number of purchase invoices at list view before creating new one is " + numberOfPurchaseInvoicesBeforeCreatingNewOne+" and after creating new one is  "+ numberOfPurchaseInvoicesAfterCreatingNewOne+" and this is correct ");


    }

    @Test(priority = 2, enabled = true)
    public void createNewPurchaseInvoiceFromPurchaseOrder() throws InterruptedException {
//        homePageObj = new HomePage(driver);
        purchaseOrdersListPageObj = homePageObj.openPurchaseOrdersListPage();
        purchaseOrdersPageObj = purchaseOrdersListPageObj.clickOnNewPurchaseOrdersBtn();
        purchaseOrdersPageObj.enterValidDataIntoPurchaseOrderPage();
        String purchaseOrderStatusBeforeCreatingRelatedSalesInvoice = purchaseOrdersPageObj.getPurchaseOrderStatusBeforeCreatingRelatedPurchaseInvoice();
        purchaseInvoicesPageObj = purchaseOrdersPageObj.createNewPurchaseInvoiceFromSalesOrder();
        purchaseInvoicesPageObj.saveAndSubmitPurchaseInvoiceFromPurchaseOrder();

        String purchaseOrderStatusAfterCreatingRelatedPurchaseInvoice = purchaseOrdersPageObj.getPurchaseOrderStatusAfterCreatingRelatedPurchaseInvoice();
        System.out.println("verify the status of purchase order will change after creating purchase invoice from this purchase order ");
        Assert.assertFalse(purchaseOrderStatusBeforeCreatingRelatedSalesInvoice.contains(purchaseOrderStatusAfterCreatingRelatedPurchaseInvoice));

        System.out.println(" status of purchase order  before creating related purchase invoice is " + purchaseOrderStatusBeforeCreatingRelatedSalesInvoice+" and after creating related one is  "+ purchaseOrderStatusAfterCreatingRelatedPurchaseInvoice+" and this is correct ");

//        Assert.assertTrue(dataMigrationToolPageObj.checkVmConnectionMsg().getText().contains(successfulConnectionMsg));

    }

    @Test(priority = 3, enabled = true)
    public void createDebitNoteFromPurchaseInvoice() throws InterruptedException {
//        homePageObj = new HomePage(driver);
        purchaseInvoicesListPageObj = homePageObj.openPurchaseInvoicesListPage();
        purchaseInvoicesPageObj = purchaseInvoicesListPageObj.clickOnNewPurchaseInvoiceBtn();
        purchaseInvoicesPageObj.enterValidDataIntoPurchaseInvoicePage();
        debitNotePageObj = purchaseInvoicesPageObj.createDebitNoteFromPurchaseInvoice();
        debitNotePageObj.saveAndSubmitDebitNoteFromPurchaseInvoice();
//        System.out.println("verify that debit note will include the same name of it's related purchase invoice  ");
//
//        Assert.assertTrue(creditNotePageObj.getInvoiceNameInsideCreditNote(salesInvoiceName).contains(salesInvoiceName));

    }
}
