package TestCases;

import Pages.*;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class WriteOffSalesInvoicesTest extends BaseTest {
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
    ReceiptVouchersListPage receiptVouchersListPageObj;
    ReceiptVoucherPage receiptVoucherPageObj;

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
    private final String invoiceName = "ACC-SINV";
    //    String companyName = "Company 1";
    String companyName = "شركة مجموعة بسام مطشر عجمي السعدون للتجارة";
//    String companyName = "شركة نماك الوطنية الزراعية";


    //
    @Test(priority = 1, enabled = true, alwaysRun = true) // done
    public void TC01_createNewSalesInvoiceAndSaveAfterApplyCompleteWriteOff() throws InterruptedException {

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
        String numberOfDraftInvoicesBeforeCreatingNewOne = salesInvoicesListPageObj.getNumberOfAllDraftSalesInvoicesBeforeSyncing();
        String numberOfSalesInvoicesBeforeCreatingNewOne = salesInvoicesListPageObj.getListAccountBeforeCreatingNewSalesInvoices();
        salesInvoicesPageObj = salesInvoicesListPageObj.clickOnNewSalesInvoiceBtn();
        salesInvoicesPageObj.enterValidDataIntoSalesInvoicePageAndSave(duesDate, itemCode);
        String totalAmountValueBeforeApplyWriteOff = salesInvoicesPageObj.getTotalAmountValue();
        String totalOutstandingAmountValueBeforeApplyWriteOff = totalAmountValueBeforeApplyWriteOff;
//        String totalOutstandingAmountValueBeforeApplyWriteOff = salesInvoicesPageObj.getTotalOutstandingAmountValue();
        System.out.println("total outstanding amount value  before apply complete write off is " + totalOutstandingAmountValueBeforeApplyWriteOff);
        salesInvoicesPageObj.applyWriteOff(Double.parseDouble(totalAmountValueBeforeApplyWriteOff));
        salesInvoicesPageObj.clickOnSaveBtn();
        String totalOutstandingAmountValueAfterApplyWriteOff = salesInvoicesPageObj.getTotalOutstandingAmountValue();
        System.out.println("total outstanding amount value  after apply complete write off is " + totalOutstandingAmountValueAfterApplyWriteOff);
        Assert.assertFalse(totalOutstandingAmountValueAfterApplyWriteOff.trim().contains(totalOutstandingAmountValueBeforeApplyWriteOff.trim()));
    }

    @Test(priority = 2, enabled = false)// done
    public void TC02_createNewSalesInvoiceWhenApplyWriteOffAndPayAdvanceAmountWithValueEqualToGrandTotalAmount() throws InterruptedException {
        homePageObj = new HomePage(driver);
        receiptVouchersListPageObj = homePageObj.openReceiptVouchersListPage();
        receiptVoucherPageObj = receiptVouchersListPageObj.clickOnNewReceiptVoucherBtn();
        receiptVoucherPageObj.enterValidDataIntoReceiptVoucherPage();
        receiptVoucherPageObj.clickOnSaveAndSubmitBtn();
        salesInvoicesListPageObj = homePageObj.openSalesInvoicesListPage();
        driver.navigate().refresh();
        salesInvoicesPageObj = salesInvoicesListPageObj.clickOnNewSalesInvoiceBtn();
        salesInvoicesPageObj.enterValidDataIntoSalesInvoicePageAndSave(duesDate, itemCode);
        String totalAmountValueBeforeApplyWriteOff = salesInvoicesPageObj.getTotalAmountValue();
        String totalOutstandingAmountValueBeforeApplyWriteOff = totalAmountValueBeforeApplyWriteOff;
        System.out.println("total outstanding amount value  before apply write off is " + totalOutstandingAmountValueBeforeApplyWriteOff);
        salesInvoicesPageObj.payWithAdvances(Double.parseDouble(totalAmountValueBeforeApplyWriteOff) / 2);
        salesInvoicesPageObj.applyWriteOff(Double.parseDouble(totalAmountValueBeforeApplyWriteOff) / 2);
        salesInvoicesPageObj.clickOnSaveBtn();
        String totalOutstandingAmountValueAfterApplyWriteOff = salesInvoicesPageObj.getTotalOutstandingAmountValue();
        System.out.println("total outstanding amount value  after Apply Write Off And PayAdvance Amount With Value Equal To Grand Total Amount is " + totalOutstandingAmountValueAfterApplyWriteOff);
        Assert.assertFalse(totalOutstandingAmountValueAfterApplyWriteOff.trim().contains(totalOutstandingAmountValueBeforeApplyWriteOff.trim()));

    }
    @Test(priority = 3, enabled = false) // not completed
    public void TC03_verifyValidationWhenPayAdvanceAmountFirstAndApplyWriteOffWithValueGreaterThanGrandTotalAmount() throws InterruptedException {
        homePageObj = new HomePage(driver);
        receiptVouchersListPageObj = homePageObj.openReceiptVouchersListPage();
        receiptVoucherPageObj = receiptVouchersListPageObj.clickOnNewReceiptVoucherBtn();
        receiptVoucherPageObj.enterValidDataIntoReceiptVoucherPage();
        receiptVoucherPageObj.clickOnSaveAndSubmitBtn();
        salesInvoicesListPageObj = homePageObj.openSalesInvoicesListPage();
        driver.navigate().refresh();
        salesInvoicesPageObj = salesInvoicesListPageObj.clickOnNewSalesInvoiceBtn();
//        salesInvoicesPageObj.enterValidDataIntoSalesInvoicePageAndSave(duesDate, "item 2311707");
        salesInvoicesPageObj.enterValidDataIntoSalesInvoicePageAndSave(duesDate, itemCode);
        String totalAmountValueBeforeApplyWriteOff = salesInvoicesPageObj.getTotalAmountValue();
        String totalOutstandingAmountValueBeforeApplyWriteOff = totalAmountValueBeforeApplyWriteOff;
        System.out.println("total outstanding amount value  before apply complete write off is " + totalOutstandingAmountValueBeforeApplyWriteOff);
        salesInvoicesPageObj.payWithAdvances(Double.parseDouble(totalAmountValueBeforeApplyWriteOff));
        salesInvoicesPageObj.applyWriteOff(Double.parseDouble(totalAmountValueBeforeApplyWriteOff) / 2);
        salesInvoicesPageObj.clickOnSaveBtnForValidation();
        Assert.assertTrue(salesInvoicesPageObj.getValidationMsg().contains(String.valueOf(Double.parseDouble(totalAmountValueBeforeApplyWriteOff) / 2)));
        Assert.assertTrue(salesInvoicesPageObj.getValidationMsg().contains("الدفعة المقدمة"));
        System.out.println(" Validation Msg after Pay Advance Amount First And Apply Write Off Greater Than Grand Total Amount is " + salesInvoicesPageObj.getValidationMsg());
    }

//    @Test(priority = 4, enabled = true)
//    public void TC04_verifyValidationWhenApplyWriteOffFirstAndPayAdvanceAmountWithValueGreaterThanGrandTotalAmount() throws InterruptedException {
//        homePageObj = new HomePage(driver);
//        receiptVouchersListPageObj = homePageObj.openReceiptVouchersListPage();
//        receiptVoucherPageObj = receiptVouchersListPageObj.clickOnNewReceiptVoucherBtn();
//        receiptVoucherPageObj.enterValidDataIntoReceiptVoucherPage();
//        receiptVoucherPageObj.clickOnSaveAndSubmitBtn();
//        salesInvoicesListPageObj = homePageObj.openSalesInvoicesListPage();
//        driver.navigate().refresh();
//        salesInvoicesPageObj = salesInvoicesListPageObj.clickOnNewSalesInvoiceBtn();
//        salesInvoicesPageObj.enterValidDataIntoSalesInvoicePageAndSave(duesDate, "item 2311707");
////        salesInvoicesPageObj.enterValidDataIntoSalesInvoicePageAndSave(duesDate, itemCode);
//        String totalAmountValueBeforeApplyWriteOff = salesInvoicesPageObj.getTotalAmountValue();
//        String totalOutstandingAmountValueBeforeApplyWriteOff = totalAmountValueBeforeApplyWriteOff;
//        System.out.println("total outstanding amount value  before apply complete write off is " + totalOutstandingAmountValueBeforeApplyWriteOff);
//        salesInvoicesPageObj.payWithAdvances(Double.parseDouble(totalAmountValueBeforeApplyWriteOff));
//        salesInvoicesPageObj.applyWriteOff(Double.parseDouble(totalAmountValueBeforeApplyWriteOff) / 2);
//
//        Assert.assertTrue(salesInvoicesPageObj.getValidationMsg().contains("0.00"));
//        Assert.assertTrue(salesInvoicesPageObj.getValidationMsg().contains("مبلغ الشطب "));
//        System.out.println(" Validation Msg after Apply Write Off First And Pay Advance Amount With Value Greater Than Grand Total Amount is " + salesInvoicesPageObj.getValidationMsg());
//    }

    @Test(priority = 5, enabled = false) //done
    public void TC05_verifyValidationWhenApplyDiscountAndApplyWriteOffWithValueGreaterThanGrandTotalAmount() throws InterruptedException {
        homePageObj = new HomePage(driver);
        salesInvoicesListPageObj = homePageObj.openSalesInvoicesListPage();
        salesInvoicesPageObj = salesInvoicesListPageObj.clickOnNewSalesInvoiceBtn();
//        salesInvoicesPageObj.enterValidDataIntoSalesInvoicePageAndSave(duesDate, "item 2311707");
        salesInvoicesPageObj.enterValidDataIntoSalesInvoicePageAndSave(duesDate, itemCode);
        String totalAmountValueBeforeApplyWriteOff = salesInvoicesPageObj.getTotalAmountValue();
        String totalOutstandingAmountValueBeforeApplyWriteOff = totalAmountValueBeforeApplyWriteOff;

        salesInvoicesPageObj.applyDiscount(Double.parseDouble(totalAmountValueBeforeApplyWriteOff) / 2);
        salesInvoicesPageObj.applyWriteOff(Double.parseDouble(totalAmountValueBeforeApplyWriteOff));
        Assert.assertTrue(salesInvoicesPageObj.getValidationMsg().contains(String.valueOf(Double.parseDouble(totalAmountValueBeforeApplyWriteOff) / 2)));
        Assert.assertTrue(salesInvoicesPageObj.getValidationMsg().contains("مبلغ الشطب "));
        System.out.println(" Validation Msg after Apply discount And Apply Write off With Value Greater Than Grand Total Amount is " + salesInvoicesPageObj.getValidationMsg());
    }

    @Test(priority = 6, enabled = false)//done
    public void TC06_verifyValidationWhenApplyWriteOffWithNegative() throws InterruptedException {
        homePageObj = new HomePage(driver);
        salesInvoicesListPageObj = homePageObj.openSalesInvoicesListPage();
        salesInvoicesPageObj = salesInvoicesListPageObj.clickOnNewSalesInvoiceBtn();
//        salesInvoicesPageObj.enterValidDataIntoSalesInvoicePageAndSave(duesDate, "item 2311707");
        salesInvoicesPageObj.enterValidDataIntoSalesInvoicePageAndSave(duesDate, itemCode);
        String totalAmountValueBeforeApplyWriteOff = salesInvoicesPageObj.getTotalAmountValue();
        String totalOutstandingAmountValueBeforeApplyWriteOff = totalAmountValueBeforeApplyWriteOff;
        salesInvoicesPageObj.applyWriteOff(-Math.abs(Double.parseDouble(totalAmountValueBeforeApplyWriteOff)));
        Assert.assertTrue(salesInvoicesPageObj.getValidationMsg().contains("لا يمكن أن يكون مبلغ الشطب سالبًا"));
        System.out.println(" Validation Msg after Apply  Apply Write off With negative Value is " + salesInvoicesPageObj.getValidationMsg());
//
    }

    @Test(priority = 7, enabled = false) // done
    public void TC07_verifyValidationWhenApplyCompleteWriteOffThenRemoveTaxes() throws InterruptedException {
        homePageObj = new HomePage(driver);
        salesInvoicesListPageObj = homePageObj.openSalesInvoicesListPage();
        salesInvoicesPageObj = salesInvoicesListPageObj.clickOnNewSalesInvoiceBtn();
//        salesInvoicesPageObj.enterValidDataIntoSalesInvoicePageAndSave(duesDate, "item 2311707");
        salesInvoicesPageObj.enterValidDataIntoSalesInvoicePageAndSave(duesDate, itemCode);
        String totalAmountValueBeforeApplyWriteOff = salesInvoicesPageObj.getTotalAmountValue();
        System.out.println("total amount value before removing taxes is " + totalAmountValueBeforeApplyWriteOff);
        String totalOutstandingAmountValueBeforeApplyWriteOff = totalAmountValueBeforeApplyWriteOff;
        salesInvoicesPageObj.applyWriteOff(Double.parseDouble(totalAmountValueBeforeApplyWriteOff));
        salesInvoicesPageObj.removeTaxes();
        salesInvoicesPageObj.clickOnSaveBtnForValidation();
        Assert.assertTrue(salesInvoicesPageObj.getValidationMsg().contains("-15.0"));
        Assert.assertTrue(salesInvoicesPageObj.getValidationMsg().contains("لا يمكن أن يكون المبلغ المستحق سالبًا."));
        System.out.println(" Validation Msg after Apply complete  Write then remove taxes is " + salesInvoicesPageObj.getValidationMsg());
//
//
    }

    @Test(priority = 8, enabled = false) //done
    public void TC08_verifyValidationWhenApplyCompleteWriteOffAndDiscountThenRemoveTaxes() throws InterruptedException {
        homePageObj = new HomePage(driver);
        salesInvoicesListPageObj = homePageObj.openSalesInvoicesListPage();
        salesInvoicesPageObj = salesInvoicesListPageObj.clickOnNewSalesInvoiceBtn();
//        salesInvoicesPageObj.enterValidDataIntoSalesInvoicePageAndSave(duesDate, "item 2311707");
        salesInvoicesPageObj.enterValidDataIntoSalesInvoicePageAndSave(duesDate, itemCode);
        String totalAmountValueBeforeApplyWriteOff = salesInvoicesPageObj.getTotalAmountValue();
        String totalOutstandingAmountValueBeforeApplyWriteOff = totalAmountValueBeforeApplyWriteOff;
        System.out.println("total amount value before removing taxes is " + totalAmountValueBeforeApplyWriteOff);
        salesInvoicesPageObj.applyDiscount(Double.parseDouble(totalAmountValueBeforeApplyWriteOff) / 2);
        salesInvoicesPageObj.applyWriteOff(Double.parseDouble(totalAmountValueBeforeApplyWriteOff) / 2);
        salesInvoicesPageObj.removeTaxes();
        salesInvoicesPageObj.clickOnSaveBtnForValidation();
        Assert.assertTrue(salesInvoicesPageObj.getValidationMsg().contains("-7.5"));
        Assert.assertTrue(salesInvoicesPageObj.getValidationMsg().contains("لا يمكن أن يكون المبلغ المستحق سالبًا."));
        System.out.println(" Validation Msg after Apply complete  Write then remove taxes is " + salesInvoicesPageObj.getValidationMsg());
    }
    @Test(priority = 9, enabled = false)
    public void TC09_verifyWhenCreateCreditNoteAfterApplyWriteOffAndRemoveTaxesOnSalesInvoice() throws InterruptedException {
        homePageObj = new HomePage(driver);
        salesInvoicesListPageObj = homePageObj.openSalesInvoicesListPage();
        salesInvoicesPageObj = salesInvoicesListPageObj.clickOnNewSalesInvoiceBtn();
//        salesInvoicesPageObj.enterValidDataIntoSalesInvoicePageAndSave(duesDate, "item 2311707");
        salesInvoicesPageObj.enterValidDataIntoSalesInvoicePageAndSave(duesDate, itemCode);
        String totalAmountValueBeforeApplyWriteOff = salesInvoicesPageObj.getTotalAmountValue();
        String totalOutstandingAmountValueBeforeApplyWriteOff = totalAmountValueBeforeApplyWriteOff;
        salesInvoicesPageObj.applyWriteOff(Double.parseDouble(totalAmountValueBeforeApplyWriteOff) / 2);
        salesInvoicesPageObj.removeTaxes();
        salesInvoicesPageObj.clickOnSaveAndSubmitBtn();
        creditNotePageObj = salesInvoicesPageObj.createCreditNoteFromSalesInvoice();
        creditNotePageObj.saveAndSubmitCreditNoteFromSalesInvoice();


//        Assert.assertTrue(salesInvoicesPageObj.getValidationMsg().contains(String.valueOf(Double.parseDouble(totalAmountValueBeforeApplyWriteOff) / 2)));
//        Assert.assertTrue(salesInvoicesPageObj.getValidationMsg().contains("مبلغ الشطب "));
//        System.out.println(" Validation Msg after Apply discount And Apply Write off With Value Greater Than Grand Total Amount is " + salesInvoicesPageObj.getValidationMsg());
//
//
    }
}
