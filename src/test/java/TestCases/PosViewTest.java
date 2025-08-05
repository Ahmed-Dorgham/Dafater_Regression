package TestCases;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PosViewTest extends BaseTest {
    LoginPage loginPageObj;
    HomePage homePageObj;
    double discountValue = 10;
    double discountEquation =((100 - discountValue) / 100);
    SalesInvoicesListPage salesInvoicesListPageObj;
    SalesOrderListPage salesOrdersListPageObj;
    SalesOrderPage salesOrdersPageObj;
    SalesInvoicesPage salesInvoicesPageObj;
    CreditNotePage creditNotePageObj;
    PosViewPage posViewPageObj;
    DataMigrationToolPage dataMigrationToolPageObj;
    private final String vmUrl = "temp-wi28927.dafater.biz";
    private final String duesDate = "15-07-2026";
    private final String secretKey = "kX7NY9yMSag3";
    private final String invalidSecretKey = "kX7NY9yMSag4";
    private final String successfulConnectionMsg = "Connected Successfully";
    private final String failureConnectionMsg = "Cannot Connect";
    private final String submittedStatus = "معتمد";
    private final String invoiceName = "ACC-SINV";

    @Test(priority = 1, enabled = false)
    public void TC01_createNewSalesInvoiceUsingPosView() throws InterruptedException {
        homePageObj = new HomePage(driver);
        salesInvoicesListPageObj = homePageObj.openSalesInvoicesListPage();

        salesInvoicesPageObj = salesInvoicesListPageObj.clickOnNewSalesInvoiceBtn();
        posViewPageObj = salesInvoicesPageObj.openPosView();

        posViewPageObj.createNewSalesInvoiceFromPosView();
        String salesInvoiceName = posViewPageObj.getInvoiceName(invoiceName);
        Assert.assertTrue(posViewPageObj.getInvoiceName(invoiceName).contains(invoiceName));
        salesInvoicesListPageObj = posViewPageObj.backToSystem();
        System.out.println("Verify the name of current created sales invoice from pos view  is existed at sales invoice list view ");
        Assert.assertTrue(salesInvoicesListPageObj.getInvoiceNameAtViewList(salesInvoiceName).contains(salesInvoiceName));

        Assert.assertTrue(salesInvoicesPageObj.getPosInvoiceStatus(submittedStatus).contains(submittedStatus));
//        String salesInvoiceName = salesInvoicesPageObj.getInvoiceName(invoiceName);
//        Assert.assertTrue(salesInvoiceName.contains(invoiceName));
//
//        Assert.assertTrue(salesInvoicesPageObj.getInvoiceNameAtViewList(salesInvoiceName).contains(salesInvoiceName));
//        String numberOfSalesInvoicesAfterCreatingNewOne = salesInvoicesListPageObj.getListAccountAfterCreatingNewSalesInvoices();
//        System.out.println("verify that number of sales invoices at list view will increase by one after creating new sales invoice ");
//        Assert.assertFalse(numberOfSalesInvoicesBeforeCreatingNewOne.contains(numberOfSalesInvoicesAfterCreatingNewOne));
//        System.out.println(" number of sales invoices at list view before creating new one is " + numberOfSalesInvoicesBeforeCreatingNewOne+" and after creating new one is  "+ numberOfSalesInvoicesAfterCreatingNewOne+" and this is correct ");

    }

    @Test(priority = 2, enabled = true)
    public void TC02_applyDiscountOnSalesInvoiceUsingPosView() throws InterruptedException {
        double netTotalAfterApplyDiscount;
        homePageObj = new HomePage(driver);
        salesInvoicesListPageObj = homePageObj.openSalesInvoicesListPage();

        salesInvoicesPageObj = salesInvoicesListPageObj.clickOnNewSalesInvoiceBtn();
        posViewPageObj = salesInvoicesPageObj.openPosView();

        posViewPageObj.applyDiscountForOneItem(discountValue);
        System.out.println("total amount before applying discount for one item is " + posViewPageObj.getTotalAmountBeforeApplyingDiscount());

        System.out.println("total amount after applying discount for one item is " + posViewPageObj.getTotalAmountAfterApplyingDiscount());

        netTotalAfterApplyDiscount = posViewPageObj.getTotalAmountBeforeApplyingDiscount() * discountEquation;
        Assert.assertTrue(posViewPageObj.getTotalAmountAfterApplyingDiscount() == netTotalAfterApplyDiscount);
        System.out.println("net total amount after applying discount for one item should be " + netTotalAfterApplyDiscount + " and this is correct ");

        posViewPageObj.increaseQuantity();
        System.out.println("total amount before applying discount for 2  items is " + posViewPageObj.getTotalAmountBeforeApplyingDiscount());

        System.out.println("total amount after applying discount for 2 items is " + posViewPageObj.getTotalAmountAfterApplyingDiscount());

        netTotalAfterApplyDiscount = posViewPageObj.getTotalAmountBeforeApplyingDiscount() * ((100 - discountValue) / 100);
        Assert.assertTrue(posViewPageObj.getTotalAmountAfterApplyingDiscount() == netTotalAfterApplyDiscount);
        System.out.println("net total amount after applying discount for one item should be " + netTotalAfterApplyDiscount + " and this is correct ");



        posViewPageObj.completePaymentProcess();
        posViewPageObj.backToSystem();

//        String salesInvoiceName = salesInvoicesPageObj.getInvoiceName(invoiceName);
//        Assert.assertTrue(salesInvoiceName.contains(invoiceName));
//
//        Assert.assertTrue(salesInvoicesPageObj.getInvoiceNameAtViewList(salesInvoiceName).contains(salesInvoiceName));
//        String numberOfSalesInvoicesAfterCreatingNewOne = salesInvoicesListPageObj.getListAccountAfterCreatingNewSalesInvoices();
//        System.out.println("verify that number of sales invoices at list view will increase by one after creating new sales invoice ");
//        Assert.assertFalse(numberOfSalesInvoicesBeforeCreatingNewOne.contains(numberOfSalesInvoicesAfterCreatingNewOne));
//        System.out.println(" number of sales invoices at list view before creating new one is " + numberOfSalesInvoicesBeforeCreatingNewOne+" and after creating new one is  "+ numberOfSalesInvoicesAfterCreatingNewOne+" and this is correct ");

    }

    @Test(priority = 3, enabled = false)
    public void TC03_createCreditNoteFromSalesInvoice() throws InterruptedException {
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
