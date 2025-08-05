package TestCases;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class AddingWareHouseTest extends BaseTest {
    Random random;
    int randomNumber;
    String wareHouseName;

    LoginPage loginPageObj;
    HomePage homePageObj;
    SalesInvoicesListPage salesInvoicesListPageObj;
    SalesOrderListPage salesOrdersListPageObj;
    SalesOrderPage salesOrdersPageObj;
    SalesInvoicesPage salesInvoicesPageObj;
    ItemPage itemPageObj;
    ItemListPage itemListPageObj;
    WareHouseListPage wareHouseListPageObj;
    WareHousePage wareHousePageObj;
    SellingPriceListsPage sellingPriceListsPageObj;
    CreditNotePage creditNotePageObj;
    StandardSellingListPage standardSellingListPageObj;
    ItemsPricesTablePage itemsPricesTablePageObj;
    ItemPricePage itemPricePageObj;

    private final String duesDate = "15-07-2026";
    private final String secretKey = "kX7NY9yMSag3";
    private final String invalidSecretKey = "kX7NY9yMSag4";
    private final String successfulConnectionMsg = "Connected Successfully";
    private final String failureConnectionMsg = "Cannot Connect";
    private final String submittedStatus = "معتمد";
    private final String draftStatus = "مسودة";
    private final String invoiceName = "ACC-SINV";

    @Test(priority = 1, enabled = true)
    public void TC01_createNewWareHouse() throws InterruptedException {
        random = new Random();
        randomNumber = random.nextInt(1000000000);
        wareHouseName = "wareHouse " + randomNumber;
        homePageObj = new HomePage(driver);
        wareHouseListPageObj = homePageObj.openWareHouseListPage();
        String numberOfAllWareHousesBeforeCreatingNewOne = wareHouseListPageObj.getNumberOfAllWareHouseBeforeCreatingNewWareHouse();
//        String numberOfSalesInvoicesBeforeCreatingNewOne = salesInvoicesListPageObj.getListAccountBeforeCreatingNewSalesInvoices();


        wareHousePageObj = wareHouseListPageObj.clickOnNewWareHouseBtn();
        wareHousePageObj.enterValidDataIntoWareHousePage(wareHouseName);
        Assert.assertTrue(wareHousePageObj.getWareHouseName(wareHouseName).contains(wareHouseName));
//
//        String salesInvoiceName = salesInvoicesPageObj.getDraftInvoiceName(invoiceName);
//        Assert.assertTrue(salesInvoiceName.contains(invoiceName));
        System.out.println("Verify the name of current created item is existed at item list view ");
        wareHouseListPageObj = wareHousePageObj.openWareHouseListPage();
        Assert.assertTrue(wareHouseListPageObj.getWareHouseNameAtViewList(wareHouseName).contains(wareHouseName));
//
        String numberOfWareHousesAfterCreatingNewOne = wareHouseListPageObj.getNumberOfAllWareHousesAfterCreatingNewWareHouse();
        System.out.println("verify that number of all warehouse at list view will increase by one after creating new warehouse");

        Assert.assertFalse(numberOfAllWareHousesBeforeCreatingNewOne.contains(numberOfWareHousesAfterCreatingNewOne));
        System.out.println(" number of all warehouses at list view before creating new one is " + numberOfAllWareHousesBeforeCreatingNewOne + " and after creating new one is  " + numberOfWareHousesAfterCreatingNewOne + " and this is correct ");

//
//        sellingPriceListsPageObj = itemListPageObj.openSellingPriceLists();
//        standardSellingListPageObj = sellingPriceListsPageObj.openStandardSellingList();
//        itemsPricesTablePageObj = standardSellingListPageObj.openItemsPricesTable();
//        itemPricePageObj = itemsPricesTablePageObj.openItemPricePage();
//        itemPricePageObj.addingPriceForItem(itemCode, itemPrice);
//
//
////        String numberOfDraftInvoicesAfterCreatingNewOne = salesInvoicesListPageObj.getNumberOfDraftInvoicesAfterCreatingNewDraftSalesInvoices();
////        System.out.println("verify that number of draft sales invoices at list view will increase by one after creating new draft sales invoice ");
////        Assert.assertFalse(numberOfDraftInvoicesBeforeCreatingNewOne.contains(numberOfDraftInvoicesAfterCreatingNewOne));
////        System.out.println(" number of draft sales invoices at list view before creating new one is " + numberOfDraftInvoicesBeforeCreatingNewOne+" and after creating new one is  "+ numberOfDraftInvoicesAfterCreatingNewOne+" and this is correct ");

    }

//    @Test(priority = 2, enabled = false)
//    public void TC02_createNewSalesItem() throws InterruptedException {
//        random = new Random();
//        randomNumber = random.nextInt(1000000000);
//        itemCode = "item " + randomNumber;
////        homePageObj = new HomePage(driver);
//        itemListPageObj = homePageObj.openItemListPage();
//        String numberOfSalesItemsBeforeCreatingNewOne = itemListPageObj.getNumberOfSalesItemsBeforeCreatingNewItem();
//        String numberOfPurchaseItemsBeforeCreatingNewOne = itemListPageObj.getNumberOfPurchaseItemsBeforeCreatingNewItem();
////        String numberOfSalesInvoicesBeforeCreatingNewOne = salesInvoicesListPageObj.getListAccountBeforeCreatingNewSalesInvoices();
//
//
//        itemPageObj = itemListPageObj.clickOnNewItemBtn();
//        itemPageObj.enterValidDataForSalesItem(itemCode);
//        Assert.assertTrue(itemPageObj.getItemCode(itemCode).contains(itemCode));
//
//        System.out.println("Verify the name of current created sales item is existed at item list view ");
//        itemListPageObj = itemPageObj.openItemListPage();
//        Assert.assertTrue(itemListPageObj.getItemNameAtViewList(itemCode).contains(itemCode));
////
//        String numberOfSalesItemsAfterCreatingNewOne = itemListPageObj.getNumberOfSalesItemsAfterCreatingNewItem();
//        String numberOfPurchaseItemsAfterCreatingNewOne = itemListPageObj.getNumberOfPurchaseItemsAfterCreatingNewItem();
//        System.out.println("verify that number of sales items at list view will increase by one after creating new sales item");
//
//        Assert.assertFalse(numberOfSalesItemsBeforeCreatingNewOne.contains(numberOfSalesItemsAfterCreatingNewOne));
//        System.out.println(" number of sales items at list view before creating new one is " + numberOfSalesItemsBeforeCreatingNewOne + " and after creating new one is  " + numberOfSalesItemsAfterCreatingNewOne + " and this is correct ");
//
//        System.out.println("verify that number of purchase items at list view will not increase after creating new sales item");
//
//        Assert.assertTrue(numberOfPurchaseItemsBeforeCreatingNewOne.contains(numberOfPurchaseItemsAfterCreatingNewOne));
//        System.out.println(" number of purchase items at list view before creating new one is " + numberOfPurchaseItemsBeforeCreatingNewOne + " and after creating new one is  " + numberOfPurchaseItemsAfterCreatingNewOne + " and this is correct ");
//
//    }
//
//    @Test(priority = 3, enabled = false)
//    public void TC03_createNewPurchaseItem() throws InterruptedException {
//        random = new Random();
//        randomNumber = random.nextInt(1000000000);
//        itemCode = "item " + randomNumber;
////        homePageObj = new HomePage(driver);
//        itemListPageObj = homePageObj.openItemListPage();
//        String numberOfSalesItemsBeforeCreatingNewOne = itemListPageObj.getNumberOfSalesItemsBeforeCreatingNewItem();
//        String numberOfPurchaseItemsBeforeCreatingNewOne = itemListPageObj.getNumberOfPurchaseItemsBeforeCreatingNewItem();
////        String numberOfSalesInvoicesBeforeCreatingNewOne = salesInvoicesListPageObj.getListAccountBeforeCreatingNewSalesInvoices();
//
//
//        itemPageObj = itemListPageObj.clickOnNewItemBtn();
//        itemPageObj.enterValidDataForPurchaseItem(itemCode);
//        Assert.assertTrue(itemPageObj.getItemName(itemCode).contains(itemCode));
//
//        System.out.println("Verify the name of current created sales item is existed at item list view ");
//        itemListPageObj = itemPageObj.openItemListPage();
//        Assert.assertTrue(itemListPageObj.getItemNameAtViewList(itemCode).contains(itemCode));
////
//        String numberOfSalesItemsAfterCreatingNewOne = itemListPageObj.getNumberOfSalesItemsAfterCreatingNewItem();
//        String numberOfPurchaseItemsAfterCreatingNewOne = itemListPageObj.getNumberOfPurchaseItemsAfterCreatingNewItem();
//        System.out.println("verify that number of purchase items at list view will increase by one after creating new purchase item");
//
//        Assert.assertFalse(numberOfPurchaseItemsBeforeCreatingNewOne.contains(numberOfPurchaseItemsAfterCreatingNewOne));
//        System.out.println(" number of purchase items at list view before creating new one is " + numberOfPurchaseItemsBeforeCreatingNewOne + " and after creating new one is  " + numberOfPurchaseItemsAfterCreatingNewOne + " and this is correct ");
//
//        System.out.println("verify that number of sales items at list view will not increase after creating new purchase item");
//
//        Assert.assertTrue(numberOfSalesItemsBeforeCreatingNewOne.contains(numberOfSalesItemsAfterCreatingNewOne));
//        System.out.println(" number of sales items at list view before creating new one is " + numberOfSalesItemsBeforeCreatingNewOne + " and after creating new one is  " + numberOfSalesItemsAfterCreatingNewOne + " and this is correct ");
//
//    }
//
//    @Test(priority = 4, enabled = false)
//    public void TC04_createCreditNoteFromSalesInvoice() throws InterruptedException {
////        homePageObj = new HomePage(driver);
//        salesInvoicesListPageObj = homePageObj.openSalesInvoicesListPage();
//        salesInvoicesPageObj = salesInvoicesListPageObj.clickOnNewSalesInvoiceBtn();
//        salesInvoicesPageObj.enterValidDataIntoSalesInvoicePageAndSumbit(duesDate);
//
//
//        String salesInvoiceName = salesInvoicesPageObj.getInvoiceNameForCreditNote(invoiceName);
//        creditNotePageObj = salesInvoicesPageObj.createCreditNoteFromSalesInvoice();
//        creditNotePageObj.saveAndSubmitCreditNoteFromSalesInvoice();
//        System.out.println("verify that credit note will include the same name of it's related sales invoice  ");
//
//        Assert.assertTrue(creditNotePageObj.getInvoiceNameInsideCreditNote(salesInvoiceName).contains(salesInvoiceName));
//
//
////        Assert.assertTrue(dataMigrationToolPageObj.checkVmConnectionMsg().getText().contains(successfulConnectionMsg));
//
//    }

}
