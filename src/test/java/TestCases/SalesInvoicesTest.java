package TestCases;

import Pages.*;
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

    @Test(priority = 1, enabled = true)
    public void createNewSalesInvoiceAndSubmit() throws InterruptedException {
        homePageObj = new HomePage(driver);
        salesInvoicesListPageObj = homePageObj.openSalesInvoicesListPage();
        salesInvoicesPageObj = salesInvoicesListPageObj.clickOnNewSalesInvoiceBtn();
        salesInvoicesPageObj.enterValidDataIntoSalesInvoicePage(duesDate);
//        Assert.assertTrue(dataMigrationToolPageObj.checkVmConnectionMsg().getText().contains(successfulConnectionMsg));

    }

    @Test(priority = 2, enabled = true)
    public void createNewSalesInvoiceFromSalesOrder() throws InterruptedException {
     ///   homePageObj = new HomePage(driver);
        salesOrdersListPageObj = homePageObj.openSalesOrdersListPage();
        salesOrdersPageObj = salesOrdersListPageObj.clickOnNewSalesOrdersBtn();
        salesOrdersPageObj.enterValidDataIntoSalesOrderPage(duesDate);
        salesInvoicesPageObj = salesOrdersPageObj.createNewSalesInvoiceFromSalesOrder();
        salesInvoicesPageObj.saveAndSubmitSalesInvoiceFromSalesOrder();


//        Assert.assertTrue(dataMigrationToolPageObj.checkVmConnectionMsg().getText().contains(successfulConnectionMsg));

    }

    @Test(priority = 3, enabled = true)
    public void createCreditNoteFromSalesInvoice() throws InterruptedException {
        ///homePageObj = new HomePage(driver);
        salesInvoicesListPageObj = homePageObj.openSalesInvoicesListPage();
        salesInvoicesPageObj = salesInvoicesListPageObj.clickOnNewSalesInvoiceBtn();
        salesInvoicesPageObj.enterValidDataIntoSalesInvoicePage(duesDate);
        creditNotePageObj = salesInvoicesPageObj.createCreditNoteFromSalesInvoice();
        creditNotePageObj.saveAndSubmitCreditNoteFromSalesInvoice();
//        Assert.assertTrue(dataMigrationToolPageObj.checkVmConnectionMsg().getText().contains(successfulConnectionMsg));

    }

}
