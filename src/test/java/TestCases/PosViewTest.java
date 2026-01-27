package TestCases;

import Pages.*;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class PosViewTest extends BaseTest {

    HomePage homePageObj;
    double discountValue = 10;
    double discountEquation = ((100 - discountValue) / 100);
    SalesInvoicesListPage salesInvoicesListPageObj;
    SalesInvoicesPage salesInvoicesPageObj;
    PosViewPage posViewPageObj;
    private final String submittedStatus = "معتمد";
    private final String invoiceName = "INV";

    Random random;
    int randomNumber;
    String itemCode;

    ItemPage itemPageObj;
    ItemListPage itemListPageObj;
    SellingPriceListsPage sellingPriceListsPageObj;
    StandardSellingListPage standardSellingListPageObj;
    ItemsPricesTablePage itemsPricesTablePageObj;
    ItemPricePage itemPricePageObj;
    DeliveryNoteListPage deliveryNoteListPageObj;
    PurchaseReceiptListPage purchaseReceiptListPageObj;
    PurchaseReceiptPage purchaseReceiptPageObj;
    DeliveryNotePage deliveryNotePageObj;

    @Test(priority = 1, enabled = true)
    public void TC01_createNewSalesInvoiceUsingPosView() throws InterruptedException {
        random = new Random();
        randomNumber = random.nextInt(10000000);
        itemCode = "item 2" + randomNumber;
        homePageObj = new HomePage(driver);
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
        purchaseReceiptListPageObj = homePageObj.openPurchaseReceiptListPage();
        purchaseReceiptPageObj = purchaseReceiptListPageObj.clickOnNewPurchaseReceiptBtn();
        purchaseReceiptPageObj.enterValidDataIntoPurchaseReceiptPage(itemCode);
        Allure.step("verify that the  status of created purchase receipt is submitted  ");
        driver.navigate().to(homePageLink_5);
        salesInvoicesListPageObj = homePageObj.openSalesInvoicesListPage();
        salesInvoicesPageObj = salesInvoicesListPageObj.clickOnNewSalesInvoiceBtn();
        posViewPageObj = salesInvoicesPageObj.openPosView();
        posViewPageObj.createNewSalesInvoiceFromPosView(itemCode);
        String salesInvoiceName = posViewPageObj.getInvoiceName(invoiceName);

        Assert.assertTrue(posViewPageObj.getInvoiceName(invoiceName).contains(invoiceName));
        salesInvoicesListPageObj = posViewPageObj.backToSystem();
        salesInvoicesListPageObj.filterDocTypes("مرتجع", "No");
        salesInvoicesListPageObj.filterDocTypesWithSecondFilter("مدين", "No");
        Allure.step("Verify the name of current created sales invoice from pos view  is existed at sales invoice list view ");
        Assert.assertTrue(salesInvoicesListPageObj.getInvoiceNameAtViewList(salesInvoiceName).contains(salesInvoiceName));
        Assert.assertTrue(salesInvoicesPageObj.getPosInvoiceStatus(submittedStatus).contains(submittedStatus));
    }

    @Test(priority = 2, enabled = true)
    public void TC02_applyDiscountOnSalesInvoiceUsingPosView() throws InterruptedException {
        double netTotalAfterApplyDiscount;
        homePageObj = new HomePage(driver);
        purchaseReceiptListPageObj = homePageObj.openPurchaseReceiptListPage();
        purchaseReceiptPageObj = purchaseReceiptListPageObj.clickOnNewPurchaseReceiptBtn();
        purchaseReceiptPageObj.enterValidDataIntoPurchaseReceiptPageWithSpeceficQuantity(itemCode);
        Allure.step("verify that the  status of created purchase receipt is submitted  ");
        driver.navigate().to(homePageLink_5);
        salesInvoicesListPageObj = homePageObj.openSalesInvoicesListPage();
        salesInvoicesPageObj = salesInvoicesListPageObj.clickOnNewSalesInvoiceBtn();
        posViewPageObj = salesInvoicesPageObj.openPosView();
        posViewPageObj.applyDiscountForOneItem(discountValue, itemCode);
        Allure.step("total amount before applying discount for one item is " + posViewPageObj.getTotalAmountBeforeApplyingDiscount());
        Allure.step("total amount after applying discount for one item is " + posViewPageObj.getTotalAmountAfterApplyingDiscount());
        netTotalAfterApplyDiscount = posViewPageObj.getTotalAmountBeforeApplyingDiscount() * discountEquation;
        Assert.assertTrue(posViewPageObj.getTotalAmountAfterApplyingDiscount() == netTotalAfterApplyDiscount);
        Allure.step("net total amount after applying discount for one item should be " + netTotalAfterApplyDiscount + " and this is correct ");
        posViewPageObj.increaseQuantity();
        Allure.step("total amount before applying discount for 2  items is " + posViewPageObj.getTotalAmountBeforeApplyingDiscount());
        Allure.step("total amount after applying discount for 2 items is " + posViewPageObj.getTotalAmountAfterApplyingDiscount());
        netTotalAfterApplyDiscount = posViewPageObj.getTotalAmountBeforeApplyingDiscount() * ((100 - discountValue) / 100);
        Assert.assertTrue(posViewPageObj.getTotalAmountAfterApplyingDiscount() == netTotalAfterApplyDiscount);
        Allure.step("net total amount after applying discount for one item should be " + netTotalAfterApplyDiscount + " and this is correct ");
        posViewPageObj.completePaymentProcess();
        posViewPageObj.backToSystem();
    }

}
