package TestCases;

import Pages.*;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class SalesInvoicesTest extends BaseTest {
    Random random;
    int randomNumber;
    String referenceNum;
    HomePage homePageObj;
    SalesInvoicesListPage salesInvoicesListPageObj;
    SalesOrderListPage salesOrdersListPageObj;
    DeliveryNoteListPage deliveryNoteListPageObj;
    DeliveryNotePage deliveryNotePageObj;
    SalesOrderPage salesOrdersPageObj;
    SalesInvoicesPage salesInvoicesPageObj;
    GrossProfitReportPage grossProfitReportPageObj;
    CreditNotePage creditNotePageObj;
    GeneralLedgerReportPage generalLedgerReportPageObj;
    PaymentPage paymentPageObj;
    CompaniesListPage companiesListPageObj;
    CompanyPage companyPageObj;
    ReportsListPage reportsListPageObj;

    public String itemCode;

    ItemPage itemPageObj;
    ItemListPage itemListPageObj;
    SellingPriceListsPage sellingPriceListsPageObj;
    StandardSellingListPage standardSellingListPageObj;
    ItemsPricesTablePage itemsPricesTablePageObj;
    ItemPricePage itemPricePageObj;
    private final String duesDate = "15-07-2026";
    private final String submittedStatus = "معتمد";
    private final String paidStatus = "مدفوع";
    private final String unpaidStatus = "غير مدفوع";
    private final String draftStatus = "مسودة";
    //    private final String invoiceName = "ACC-SINV";
    private final String salesInvoiceName = "INV";
    //    String companyName = "Company 1";
//    String companyName = "شركة مجموعة بسام مطشر عجمي السعدون للتجارة";
    String companyName = "BusinessClouds (Demo)";
//    String companyName = "شركة نماك الوطنية الزراعية";

    @Test(priority = 1, enabled = true, alwaysRun = true)
    public void TC01_createNewSalesInvoiceAndSaveOnly() throws InterruptedException {

        homePageObj = new HomePage(driver);
        random = new Random();
        randomNumber = random.nextInt(10000000);
        itemCode = "item 2" + randomNumber;

        itemListPageObj = homePageObj.openItemListPage();
        itemPageObj = itemListPageObj.clickOnNewItemBtn();
        itemPageObj.enterValidDataIntoItemPage(itemCode);
        Assert.assertTrue(itemPageObj.getItemName(itemCode).contains(itemCode));
        Allure.step("Verify the name of current created item is existed at item list view ");
        itemListPageObj = itemPageObj.openItemListPage();
        Assert.assertTrue(itemListPageObj.getItemNameAtViewList(itemCode).contains(itemCode));
        sellingPriceListsPageObj = itemListPageObj.openSellingPriceLists();
        standardSellingListPageObj = sellingPriceListsPageObj.openStandardSellingList();
        itemsPricesTablePageObj = standardSellingListPageObj.openItemsPricesTable();
        itemPricePageObj = itemsPricesTablePageObj.openItemPricePage();


        itemPricePageObj.addingPriceForItem(itemCode, itemPrice);
        driver.navigate().to(homePageLink_5);
        salesInvoicesListPageObj = homePageObj.openSalesInvoicesListPage();
        salesInvoicesListPageObj.filterDocTypes("مرتجع", "No");
        salesInvoicesListPageObj.filterDocTypesWithSecondFilter("مدين", "No");
        String numberOfDraftInvoicesBeforeCreatingNewOne = salesInvoicesListPageObj.getNumberOfAllDraftSalesInvoicesBeforeSyncing();
        String numberOfAllSalesInvoicesBeforeCreatingNewOne = salesInvoicesListPageObj.getListAccountBeforeCreatingNewSalesInvoices();
        salesInvoicesPageObj = salesInvoicesListPageObj.clickOnNewSalesInvoiceBtn();
        salesInvoicesPageObj.enterValidDataIntoSalesInvoicePageAndSave(duesDate, itemCode);
        salesInvoicesPageObj.clickOnSaveBtn();
        Assert.assertTrue(salesInvoicesPageObj.getInvoiceStatus(draftStatus).contains(draftStatus));
        String salesInvoiceName = salesInvoicesPageObj.getDraftInvoiceName(this.salesInvoiceName);
        Assert.assertTrue(salesInvoiceName.contains(this.salesInvoiceName));
        Allure.step("Verify the name of current created sales invoice is existed at sales invoice list view ");
        homePageObj.openSalesInvoicesListPage();
        salesInvoicesListPageObj.filterDocTypes("مرتجع", "No");
        salesInvoicesListPageObj.filterDocTypesWithSecondFilter("مدين", "No");
        Assert.assertTrue(salesInvoicesPageObj.getInvoiceNameAtViewList(salesInvoiceName).contains(salesInvoiceName));
        String numberOfAllSalesInvoicesAfterCreatingNewOne = salesInvoicesListPageObj.getListAccountAfterCreatingNewSalesInvoices();
        Allure.step("verify that number of sales invoices at list view will increase by one after creating new sales invoice ");
        Assert.assertFalse(numberOfAllSalesInvoicesBeforeCreatingNewOne.contains(numberOfAllSalesInvoicesAfterCreatingNewOne));
        Allure.step(" number of sales invoices at list view before creating new one is " + numberOfAllSalesInvoicesBeforeCreatingNewOne + " and after creating new one is  " + numberOfAllSalesInvoicesAfterCreatingNewOne + " and this is correct ");
        String numberOfDraftInvoicesAfterCreatingNewOne = salesInvoicesListPageObj.getNumberOfDraftInvoicesAfterCreatingNewDraftSalesInvoices();
        Allure.step("verify that number of draft sales invoices at list view will increase by one after creating new draft sales invoice ");
        Assert.assertFalse(numberOfDraftInvoicesBeforeCreatingNewOne.contains(numberOfDraftInvoicesAfterCreatingNewOne));
        Allure.step(" number of draft sales invoices at list view before creating new one is " + numberOfDraftInvoicesBeforeCreatingNewOne + " and after creating new one is  " + numberOfDraftInvoicesAfterCreatingNewOne + " and this is correct ");
    }

    @Test(priority = 2, enabled = true)
    public void TC02_createNewSalesInvoiceAndSubmit() throws InterruptedException {
        homePageObj = new HomePage(driver);
        salesInvoicesListPageObj = homePageObj.openSalesInvoicesListPage();

        salesInvoicesListPageObj.filterDocTypes("مرتجع", "No");
        salesInvoicesListPageObj.filterDocTypesWithSecondFilter("مدين", "No");


        String numberOfSalesInvoicesBeforeCreatingNewOne = salesInvoicesListPageObj.getListAccountBeforeCreatingNewSalesInvoices();
        salesInvoicesPageObj = salesInvoicesListPageObj.clickOnNewSalesInvoiceBtn();
        salesInvoicesPageObj.enterValidDataIntoSalesInvoicePageAndSumbit(duesDate, itemCode);

        Assert.assertTrue(salesInvoicesPageObj.getInvoiceStatus(submittedStatus).contains(submittedStatus));
//       Allure.step("verify that the current created sales invoice wil appear at list view with same name  ");
        String salesInvoiceName = salesInvoicesPageObj.getInvoiceName(this.salesInvoiceName);
        Assert.assertTrue(salesInvoiceName.contains(this.salesInvoiceName));

        homePageObj.openSalesInvoicesListPage();
        salesInvoicesListPageObj.filterDocTypes("مرتجع", "No");
        salesInvoicesListPageObj.filterDocTypesWithSecondFilter("مدين", "No");



        Allure.step("Verify the name of current created sales invoice is existed at sales invoice list view ");
        Assert.assertTrue(salesInvoicesPageObj.getInvoiceNameAtViewList(salesInvoiceName).contains(salesInvoiceName));
        String numberOfSalesInvoicesAfterCreatingNewOne = salesInvoicesListPageObj.getListAccountAfterCreatingNewSalesInvoices();
        Allure.step("verify that number of sales invoices at list view will increase by one after creating new sales invoice ");
        Assert.assertFalse(numberOfSalesInvoicesBeforeCreatingNewOne.contains(numberOfSalesInvoicesAfterCreatingNewOne));
        Allure.step(" number of sales invoices at list view before creating new one is " + numberOfSalesInvoicesBeforeCreatingNewOne + " and after creating new one is  " + numberOfSalesInvoicesAfterCreatingNewOne + " and this is correct ");

    }

    @Test(priority = 3, enabled = true)
    public void TC03_createNewSalesInvoiceFromSalesOrder() throws InterruptedException {
        homePageObj = new HomePage(driver);
        salesOrdersListPageObj = homePageObj.openSalesOrdersListPage();
        salesOrdersPageObj = salesOrdersListPageObj.clickOnNewSalesOrdersBtn();
        salesOrdersPageObj.enterValidDataIntoSalesOrderPage(duesDate, itemCode);
        String salesOrderStatusBeforeCreatingRelatedSalesInvoice = salesOrdersPageObj.getSalesOrderStatusBeforeCreatingRelatedSalesInvoice();
        salesInvoicesPageObj = salesOrdersPageObj.createNewSalesInvoiceFromSalesOrder();
        salesInvoicesPageObj.saveAndSubmitSalesInvoiceFromSalesOrder();
        String salesOrderStatusAfterCreatingRelatedSalesInvoice = salesOrdersPageObj.getSalesOrderStatusAfterCreatingRelatedSalesInvoice();
        Allure.step("verify the status of sales order will change after creating sales invoice from this  sales order ");
        Assert.assertFalse(salesOrderStatusBeforeCreatingRelatedSalesInvoice.contains(salesOrderStatusAfterCreatingRelatedSalesInvoice));
        Allure.step(" status of sales order  before creating related sales invoice is " + salesOrderStatusBeforeCreatingRelatedSalesInvoice + " and after creating related one is  " + salesOrderStatusAfterCreatingRelatedSalesInvoice + " and this is correct ");
    }

    @Test(priority = 4, enabled = true)
    public void TC04_createCreditNoteFromSalesInvoice() throws InterruptedException {
        homePageObj = new HomePage(driver);
        salesInvoicesListPageObj = homePageObj.openSalesInvoicesListPage();
        salesInvoicesPageObj = salesInvoicesListPageObj.clickOnNewSalesInvoiceBtn();
        salesInvoicesPageObj.enterValidDataIntoSalesInvoicePageAndSumbit(duesDate, itemCode);
        String salesInvoiceName = salesInvoicesPageObj.getInvoiceNameForCreditNote(this.salesInvoiceName);
        creditNotePageObj = salesInvoicesPageObj.createCreditNoteFromSalesInvoice();
        creditNotePageObj.saveAndSubmitCreditNoteFromSalesInvoice();
        Allure.step("verify that credit note will include the same name of it's related sales invoice  ");
        Assert.assertTrue(creditNotePageObj.getInvoiceNameInsideCreditNote(salesInvoiceName).contains(salesInvoiceName));

    }

    @Test(priority = 5, enabled = true)
    public void TC05_createNewSalesInvoiceAndCheckInGrossProfitReport() throws InterruptedException {
        homePageObj = new HomePage(driver);
        salesInvoicesListPageObj = homePageObj.openSalesInvoicesListPage();
        salesInvoicesPageObj = salesInvoicesListPageObj.clickOnNewSalesInvoiceBtn();
        salesInvoicesPageObj.enterValidDataIntoSalesInvoicePageAndSumbit(duesDate, itemCode);
        String totalAmountForSalesInvoice = salesInvoicesPageObj.getTotalAmountOfSalesInvoice();
        String salesInvoiceName = salesInvoicesPageObj.getInvoiceName();
        driver.navigate().to(homePageLink_5);
        reportsListPageObj = homePageObj.openReportsListPage();
        grossProfitReportPageObj = reportsListPageObj.openGrossProfitReport();
        grossProfitReportPageObj.applyFilters_5(companyName, salesInvoiceName);
        String sellingAmountValueAtGrossProfitReport = grossProfitReportPageObj.getSellingAmountValue_5();
        Allure.step("verify that selling amount value at gross profit report has the same value of total Amount For Sales Invoice");
        Assert.assertTrue(sellingAmountValueAtGrossProfitReport.contains(totalAmountForSalesInvoice));
        Allure.step(" selling amount value at gross profit report has " + sellingAmountValueAtGrossProfitReport + " and  value of  total Amount For Sales Invoice is  " + totalAmountForSalesInvoice + " and this is correct ");

    }

    @Test(priority = 6, enabled = true)
    public void TC06_createPaymentForSalesInvoice() throws InterruptedException {
        random = new Random();
        randomNumber = random.nextInt(1000000000);
//        referenceNum = "item " + randomNumber;
        homePageObj = new HomePage(driver);
        salesInvoicesListPageObj = homePageObj.openSalesInvoicesListPage();
        salesInvoicesPageObj = salesInvoicesListPageObj.clickOnNewSalesInvoiceBtn();
        salesInvoicesPageObj.enterValidDataIntoSalesInvoicePageAndSumbit(duesDate, itemCode);
        String salesInvoiceName = salesInvoicesPageObj.getInvoiceNameForPayment(this.salesInvoiceName);
        Allure.step("verify the payment status of created sales invoice will be unpaid");
        Assert.assertTrue(salesInvoicesPageObj.getSalesInvoicePaymentStatusBeforePayment(unpaidStatus).contains(unpaidStatus));
        paymentPageObj = salesInvoicesPageObj.createPaymentForSalesInvoice();
        String invoiceNameAtPaymentPage = paymentPageObj.getInvoiceNameFromPayment();
        Allure.step("verify that payment will include the same name of it's related sales invoice  ");
        Assert.assertTrue(invoiceNameAtPaymentPage.contains(salesInvoiceName));
        Allure.step("the payment page include sales invoice " + invoiceNameAtPaymentPage + " and this is the same name of sales invoice which created a while " + salesInvoiceName);
        paymentPageObj.saveAndSubmitPayment(randomNumber);
        Assert.assertTrue(paymentPageObj.getInvoiceStatus(submittedStatus).contains(submittedStatus));
        salesInvoicesPageObj = paymentPageObj.openPaidSalesInvoice();
        Allure.step("verify the payment status of related sales invoice will be changed to paid");
        Assert.assertTrue(salesInvoicesPageObj.getSalesInvoicePaymentStatus(paidStatus).contains(paidStatus));
    }

    @Test(priority = 7, enabled = false)
    public void TC07_createNewSalesInvoiceFromDeliveryNote() throws InterruptedException {
        homePageObj = new HomePage(driver);
        deliveryNoteListPageObj = homePageObj.openDeliveryNoteListPage();
        deliveryNotePageObj = deliveryNoteListPageObj.clickOnNewDeliveryNoteBtn();
        deliveryNotePageObj.enterValidDataIntoDeliveryNotePage(itemCode);
        String deliveryNoteStatusBeforeCreatingRelatedSalesInvoice = deliveryNotePageObj.getSalesOrderStatusBeforeCreatingRelatedSalesInvoice();
        salesInvoicesPageObj = deliveryNotePageObj.createNewSalesInvoiceFromDeliveryNote();
        salesInvoicesPageObj.saveAndSubmitSalesInvoiceFromDeliveryNoteWithOutUpdateStock();
        String deliveryNoteStatusAfterCreatingRelatedSalesInvoice = deliveryNotePageObj.getDeliveryNoteStatusAfterCreatingRelatedSalesInvoice();
        Allure.step("verify the status of delivery note will change after creating sales invoice from this  delivery note ");
        Assert.assertFalse(deliveryNoteStatusBeforeCreatingRelatedSalesInvoice.contains(deliveryNoteStatusAfterCreatingRelatedSalesInvoice));
        Allure.step(" status of delivery  note before creating related sales invoice is " + deliveryNoteStatusBeforeCreatingRelatedSalesInvoice + " and after creating related one is  " + deliveryNoteStatusAfterCreatingRelatedSalesInvoice + " and this is correct ");
    }

    @Test(priority = 8, enabled = true)
    public void TC08_createNewSalesInvoiceAndCheckInGeneralLedgerReport() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        homePageObj = new HomePage(driver);
//        salesInvoicesListPageObj = homePageObj.openSalesInvoicesListPage();
        companiesListPageObj = homePageObj.openCompaniesListPage();
        companyPageObj = companiesListPageObj.openSpecificCompany(companyName);
        String defaultDebitAccountAtCompanySettings = companyPageObj.getDefaultDebitAccount();
        String defaultIncomeAccountAtCompanySettings = companyPageObj.getDefaultIncomeAccount();
        driver.navigate().to(homePageLink_5);

        salesInvoicesListPageObj = homePageObj.openSalesInvoicesListPage();
        salesInvoicesPageObj = salesInvoicesListPageObj.clickOnNewSalesInvoiceBtn();
        salesInvoicesPageObj.enterValidDataIntoSalesInvoicePageAndSumbit(duesDate, itemCode);
        String grandTotalAmountForSalesInvoice = salesInvoicesPageObj.getGrandTotalAmountOfSalesInvoice();
        String totalAmountForSalesInvoice = salesInvoicesPageObj.getTotalAmountOfSalesInvoice();
        generalLedgerReportPageObj = salesInvoicesPageObj.openGeneralLedgerReport();
        String valueAtDefaultDebitAccountAtGL = generalLedgerReportPageObj.getValueAtDefaultDebitAccountFromGL(generalLedgerReportPageObj.getDefaultDebitAccountFromGL(defaultDebitAccountAtCompanySettings));

        Allure.step("verify that Default Debit Account At GL has the same value of grand total Amount For Sales Invoice");
        Assert.assertTrue(valueAtDefaultDebitAccountAtGL.trim().contains(grandTotalAmountForSalesInvoice.trim()));
        Allure.step(" Default Debit Account At GL report has " + valueAtDefaultDebitAccountAtGL + " and  value of grand total Amount For Sales Invoice is  " + grandTotalAmountForSalesInvoice + " and this is correct ");


//        generalLedgerReportPageObj.getDefaultIncomeAccountFromGL(defaultIncomeAccountAtCompanySettings);
        String valueAtDefaultIncomeAccountAtGL = generalLedgerReportPageObj.getValueAtDefaultIncomeAccountFromGL(generalLedgerReportPageObj.getDefaultIncomeAccountFromGL(defaultIncomeAccountAtCompanySettings));
        Allure.step("verify that Default income Account At GL has the same value of total Amount For Sales Invoice");

        Assert.assertTrue(valueAtDefaultIncomeAccountAtGL.trim().contains(totalAmountForSalesInvoice.trim()));
        Allure.step(" Default income Account At GL report has " + valueAtDefaultIncomeAccountAtGL + " and  value of  total Amount For Sales Invoice is  " + totalAmountForSalesInvoice + " and this is correct ");

        String closingDebitValueAtGl = generalLedgerReportPageObj.getClosingDebitValueForInvoiceAtGL();
        String closingCreditValueAtGl = generalLedgerReportPageObj.getClosingCreditValueForInvoiceAtGL();
        Allure.step("verify that closing values ( debit & credit )  at general ledger are equals to  grand total amount for sales invoice");
        Assert.assertTrue(closingDebitValueAtGl.trim().contains(grandTotalAmountForSalesInvoice.trim()));
        Assert.assertTrue(closingCreditValueAtGl.trim().contains(grandTotalAmountForSalesInvoice.trim()));
        Allure.step(" closing debit value at general ledger is " + closingDebitValueAtGl + "  and grand total amount for sales invoice is " + grandTotalAmountForSalesInvoice + " and this is correct ");
        Allure.step(" closing credit value at general ledger is " + closingCreditValueAtGl + "   and grand total amount for sales invoice is " + grandTotalAmountForSalesInvoice + " and this is correct ");

    }


}
