package TestCases;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class PurchaseInvoicesTest extends BaseTest {
    LoginPage loginPageObj;
    HomePage homePageObj;
    PurchaseInvoicesListPage purchaseInvoicesListPageObj;
    PurchaseOrderListPage purchaseOrdersListPageObj;
    PurchaseReceiptPage purchaseReceiptPageObj;
    PurchaseReceiptListPage purchaseReceiptListPageObj;
    PurchaseOrderPage purchaseOrdersPageObj;
    PurchaseInvoicesPage purchaseInvoicesPageObj;
    DebitNotePage debitNotePageObj;
    PaymentPage paymentPageObj;
    CompanyPage companyPageObj;
    CompaniesListPage companiesListPageObj;
    GeneralLedgerReportPage generalLedgerReportPageObj;
    ItemPage itemPageObj;
    ItemListPage itemListPageObj;
    SellingPriceListsPage sellingPriceListsPageObj;
    StandardSellingListPage standardSellingListPageObj;
    ItemsPricesTablePage itemsPricesTablePageObj;
    ItemPricePage itemPricePageObj;
    Random random;
    int randomNumber;
    private final String vmUrl = "temp-wi28927.dafater.biz";
    private final String duesDate = "15-07-2026";
    private final String secretKey = "kX7NY9yMSag3";
    private final String invalidSecretKey = "kX7NY9yMSag4";
    private final String successfulConnectionMsg = "Connected Successfully";
    private final String failureConnectionMsg = "Cannot Connect";
    private final String submittedStatus = "معتمد";
    private final String invoiceName = "ACC-PINV";
    private final String paidStatus = "مدفوع";
    private final String unpaidStatus = "غير مدفوع";
//    String companyName = "Company 1";
    String companyName = "شركة نماك الوطنية الزراعية";
    public String itemCode;

    @Test(priority = 1, enabled = true)
    public void TC01_createNewPurchaseInvoiceAndSubmit() throws InterruptedException {

        homePageObj = new HomePage(driver);
        random = new Random();
        randomNumber = random.nextInt(10000000);
        itemCode = "item 2" + randomNumber;

        itemListPageObj = homePageObj.openItemListPage();
//        String numberOfAllItemsBeforeCreatingNewOne = itemListPageObj.getNumberOfAllItemsBeforeCreatingNewItem();
        itemPageObj = itemListPageObj.clickOnNewItemBtn();
        itemPageObj.enterValidDataIntoItemPage(itemCode);
        Assert.assertTrue(itemPageObj.getItemName(itemCode).contains(itemCode));
        System.out.println("Verify the name of current created item is existed at item list view ");
        itemListPageObj = itemPageObj.openItemListPage();
        Assert.assertTrue(itemListPageObj.getItemNameAtViewList(itemCode).contains(itemCode));
//        String numberOfItemsAfterCreatingNewOne = itemListPageObj.getNumberOfAllItemsAfterCreatingNewItem();
//        System.out.println("verify that number of all items at list view will increase by one after creating new item");
//        Assert.assertFalse(numberOfAllItemsBeforeCreatingNewOne.contains(numberOfItemsAfterCreatingNewOne));
//        System.out.println(" number of all items at list view before creating new one is " + numberOfAllItemsBeforeCreatingNewOne + " and after creating new one is  " + numberOfItemsAfterCreatingNewOne + " and this is correct ");
        sellingPriceListsPageObj = itemListPageObj.openSellingPriceLists();
        standardSellingListPageObj = sellingPriceListsPageObj.openStandardSellingList();
        itemsPricesTablePageObj = standardSellingListPageObj.openItemsPricesTable();
        itemPricePageObj = itemsPricesTablePageObj.openItemPricePage();
        itemPricePageObj.addingPriceForItem(itemCode, itemPrice);
        driver.navigate().to(homePageLink_5);
        purchaseInvoicesListPageObj = homePageObj.openPurchaseInvoicesListPage();
        String numberOfPurchaseInvoicesBeforeCreatingNewOne = purchaseInvoicesListPageObj.getListAccountBeforeCreatingNewPurchaseInvoices();
        purchaseInvoicesPageObj = purchaseInvoicesListPageObj.clickOnNewPurchaseInvoiceBtn();
        purchaseInvoicesPageObj.enterValidDataIntoPurchaseInvoicePage(itemCode);
        Assert.assertTrue(purchaseInvoicesPageObj.getInvoiceStatus(submittedStatus).contains(submittedStatus));
        String purchaseInvoiceName = purchaseInvoicesPageObj.getInvoiceName(invoiceName);
        Assert.assertTrue(purchaseInvoiceName.contains(invoiceName));
        purchaseInvoicesListPageObj = purchaseInvoicesPageObj.goToPurchaseListView();
        System.out.println("Verify the name of current created purchase invoice is existed at purchase  invoice list view ");
        Assert.assertTrue(purchaseInvoicesListPageObj.getInvoiceNameAtViewList(purchaseInvoiceName).contains(purchaseInvoiceName));
        String numberOfPurchaseInvoicesAfterCreatingNewOne = purchaseInvoicesListPageObj.getListAccountAfterCreatingNewSalesInvoices();
        System.out.println("verify that number of purchase invoices at list view will increase by one after creating new purchase invoice ");
        Assert.assertFalse(numberOfPurchaseInvoicesBeforeCreatingNewOne.contains(numberOfPurchaseInvoicesAfterCreatingNewOne));
        System.out.println("number of purchase invoices at list view before creating new one is " + numberOfPurchaseInvoicesBeforeCreatingNewOne + " and after creating new one is  " + numberOfPurchaseInvoicesAfterCreatingNewOne + " and this is correct ");
    }

    @Test(priority = 2, enabled = true)
    public void TC02_createNewPurchaseInvoiceFromPurchaseOrder() throws InterruptedException {
        homePageObj = new HomePage(driver);
        purchaseOrdersListPageObj = homePageObj.openPurchaseOrdersListPage();
        purchaseOrdersPageObj = purchaseOrdersListPageObj.clickOnNewPurchaseOrdersBtn();
        purchaseOrdersPageObj.enterValidDataIntoPurchaseOrderPage();
        String purchaseOrderStatusBeforeCreatingRelatedSalesInvoice = purchaseOrdersPageObj.getPurchaseOrderStatusBeforeCreatingRelatedPurchaseInvoice();
        purchaseInvoicesPageObj = purchaseOrdersPageObj.createNewPurchaseInvoiceFromSalesOrder();
        purchaseInvoicesPageObj.saveAndSubmitPurchaseInvoiceFromPurchaseOrder();
        String purchaseOrderStatusAfterCreatingRelatedPurchaseInvoice = purchaseOrdersPageObj.getPurchaseOrderStatusAfterCreatingRelatedPurchaseInvoice();
        System.out.println("verify the status of purchase order will change after creating purchase invoice from this purchase order ");
        Assert.assertFalse(purchaseOrderStatusBeforeCreatingRelatedSalesInvoice.contains(purchaseOrderStatusAfterCreatingRelatedPurchaseInvoice));

        System.out.println(" status of purchase order  before creating related purchase invoice is " + purchaseOrderStatusBeforeCreatingRelatedSalesInvoice + " and after creating related one is  " + purchaseOrderStatusAfterCreatingRelatedPurchaseInvoice + " and this is correct ");
    }

    @Test(priority = 3, enabled = true)
    public void TC03_createDebitNoteFromPurchaseInvoice() throws InterruptedException {
        homePageObj = new HomePage(driver);
        purchaseInvoicesListPageObj = homePageObj.openPurchaseInvoicesListPage();
        purchaseInvoicesPageObj = purchaseInvoicesListPageObj.clickOnNewPurchaseInvoiceBtn();
        purchaseInvoicesPageObj.enterValidDataIntoPurchaseInvoicePage(itemCode);
        debitNotePageObj = purchaseInvoicesPageObj.createDebitNoteFromPurchaseInvoice();
        debitNotePageObj.saveAndSubmitDebitNoteFromPurchaseInvoice();
    }

    @Test(priority = 4, enabled = true)
    public void TC04_createPaymentForPurchaseInvoice() throws InterruptedException {
        random = new Random();
        randomNumber = random.nextInt(1000000000);
//        referenceNum = "item " + randomNumber;
        homePageObj = new HomePage(driver);
        purchaseInvoicesListPageObj = homePageObj.openPurchaseInvoicesListPage();
        purchaseInvoicesPageObj = purchaseInvoicesListPageObj.clickOnNewPurchaseInvoiceBtn();
        purchaseInvoicesPageObj.enterValidDataIntoPurchaseInvoicePage(itemCode);
        String purchaseInvoiceName = purchaseInvoicesPageObj.getInvoiceNameForPayment(invoiceName);
     paymentPageObj = purchaseInvoicesPageObj.createPaymentForPurchaseInvoice();
        String invoiceNameAtPaymentPage = paymentPageObj.getInvoiceNameFromPayment();
        System.out.println("verify that payment will include the same name of it's related purchase invoice  ");
        Assert.assertTrue(invoiceNameAtPaymentPage.contains(purchaseInvoiceName));
        System.out.println("the payment page include purchase invoice " + invoiceNameAtPaymentPage + " and this is the same name of sales invoice which created a while " + purchaseInvoiceName);
        paymentPageObj.saveAndSubmitPayment(randomNumber);
        Assert.assertTrue(paymentPageObj.getInvoiceStatus(submittedStatus).contains(submittedStatus));
        purchaseInvoicesPageObj = paymentPageObj.openPaidPurchaseInvoice();
        System.out.println("verify the payment status of related purchase invoice will be changed to paid");
        Assert.assertTrue(purchaseInvoicesPageObj.getPurchaseInvoicePaymentStatus(paidStatus).contains(paidStatus));
    }

    @Test(priority = 5, enabled = true)
    public void TC05_createNewPurchaseInvoiceFromPurchaseReceipt() throws InterruptedException {
        homePageObj = new HomePage(driver);
        purchaseReceiptListPageObj = homePageObj.openPurchaseReceiptListPage();
        purchaseReceiptPageObj = purchaseReceiptListPageObj.clickOnNewPurchaseReceiptBtn();
        purchaseReceiptPageObj.enterValidDataIntoPurchaseReceiptPage();
        String purchaseReceiptStatusBeforeCreatingRelatedSalesInvoice = purchaseReceiptPageObj.getPurchaseReceiptStatusBeforeCreatingRelatedPurchaseInvoice();
        purchaseInvoicesPageObj = purchaseReceiptPageObj.createNewPurchaseInvoiceFromPurchaseReceipt();
        purchaseInvoicesPageObj.saveAndSubmitPurchaseInvoiceFromPurchaseReceipt();
        String purchaseReceiptStatusAfterCreatingRelatedPurchaseInvoice = purchaseReceiptPageObj.getPurchaseReceiptStatusAfterCreatingRelatedPurchaseInvoice();
        System.out.println("verify the status of purchase receipt will change after creating purchase invoice from this purchase receipt ");
        Assert.assertFalse(purchaseReceiptStatusBeforeCreatingRelatedSalesInvoice.contains(purchaseReceiptStatusAfterCreatingRelatedPurchaseInvoice));
        System.out.println(" status of purchase receipt  before creating related purchase invoice is " + purchaseReceiptStatusBeforeCreatingRelatedSalesInvoice + " and after creating related one is  " + purchaseReceiptStatusAfterCreatingRelatedPurchaseInvoice + " and this is correct ");

    }

    @Test(priority = 6, enabled = true)
    public void TC06_createNewPurchaseInvoiceAndCheckInGeneralLedgerReport() throws InterruptedException {
        homePageObj = new HomePage(driver);
//        salesInvoicesListPageObj = homePageObj.openSalesInvoicesListPage();
        companiesListPageObj = homePageObj.openCompaniesListPage();
        companyPageObj = companiesListPageObj.openSpecificCompany(companyName);
        String defaultCreditAccountAtCompanySettings = companyPageObj.getDefaultCreditAccount();
        String defaultExpenseAccountAtCompanySettings = companyPageObj.getDefaultExpenseAccount();
        driver.navigate().to(homePageLink_5);
        purchaseInvoicesListPageObj = homePageObj.openPurchaseInvoicesListPage();
        purchaseInvoicesPageObj = purchaseInvoicesListPageObj.clickOnNewPurchaseInvoiceBtn();
        purchaseInvoicesPageObj.enterValidDataIntoPurchaseInvoicePage(itemCode);
        String grandTotalAmountForPurchaseInvoice = purchaseInvoicesPageObj.getGrandTotalAmountOfPurchaseInvoice();
        String totalAmountForPurchaseInvoice = purchaseInvoicesPageObj.getTotalAmountOfPurchaseInvoice();
        generalLedgerReportPageObj = purchaseInvoicesPageObj.openGeneralLedgerReport();
        String valueAtDefaultCreditAccountAtGL = generalLedgerReportPageObj.getValueAtDefaultCreditAccountFromGL(generalLedgerReportPageObj.getDefaultCreditAccountFromGL(defaultCreditAccountAtCompanySettings));
        System.out.println("verify that Default Credit Account At GL has the same value of total Amount For purchase Invoice");
        Assert.assertTrue(valueAtDefaultCreditAccountAtGL.contains(grandTotalAmountForPurchaseInvoice));
        System.out.println(" Default Credit Account At GL report has " + valueAtDefaultCreditAccountAtGL + " and  value of total Amount For Purchase Invoice is  " + grandTotalAmountForPurchaseInvoice + " and this is correct ");
        String valueAtDefaultExpenseAccountAtGL = generalLedgerReportPageObj.getValueAtDefaultExpenseAccountFromGL(generalLedgerReportPageObj.getDefaultExpenseAccountFromGL(defaultExpenseAccountAtCompanySettings));
        System.out.println("verify that Default expense Account At GL has the same value of total Amount For purchase Invoice");
        Assert.assertTrue(valueAtDefaultExpenseAccountAtGL.contains(totalAmountForPurchaseInvoice));
        System.out.println(" Default expense Account At GL report has " + valueAtDefaultExpenseAccountAtGL + " and  value of  total Amount For purchase Invoice is  " + totalAmountForPurchaseInvoice + " and this is correct ");
        String closingDebitValueAtGl =  generalLedgerReportPageObj.getClosingDebitValueForInvoiceAtGL();
        String closingCreditValueAtGl =  generalLedgerReportPageObj.getClosingCreditValueForInvoiceAtGL();
        System.out.println("verify that closing values ( debit & credit )  at general ledger are equals to  grand total amount for purchase invoice" );
        Assert.assertTrue(closingDebitValueAtGl.contains(grandTotalAmountForPurchaseInvoice));
        Assert.assertTrue(closingCreditValueAtGl.contains(grandTotalAmountForPurchaseInvoice));
        System.out.println(" closing debit value at general ledger is "+closingDebitValueAtGl+"  and grand total amount for purchase invoice is " + grandTotalAmountForPurchaseInvoice +" and this is correct " );
        System.out.println(" closing credit value at general ledger is "+closingCreditValueAtGl+"   and grand total amount for purchase invoice is " + grandTotalAmountForPurchaseInvoice +" and this is correct " );



    }

}
