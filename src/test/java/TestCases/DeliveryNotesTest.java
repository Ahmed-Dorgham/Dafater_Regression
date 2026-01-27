package TestCases;

import Pages.*;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class DeliveryNotesTest extends BaseTest {
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
    DeliveryNotePage deliveryNotePageObj;
    SalesInvoicesPage salesInvoicesPageObj;
    private final String submittedStatus = "معتمد";
    @Test(priority = 1, enabled = true)
    public void  TC01_createNewDeliveryNote() throws InterruptedException {
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
        deliveryNoteListPageObj = homePageObj.openDeliveryNoteListPage();
        deliveryNotePageObj=  deliveryNoteListPageObj.clickOnNewDeliveryNoteBtn();
        deliveryNotePageObj.enterValidDataIntoDeliveryNotePage(itemCode);
       Allure.step("verify that the  status of created delivery note is submitted  ");
        Assert.assertTrue(deliveryNotePageObj.getDeliveryNoteStatus(submittedStatus).contains(submittedStatus));
        String deliveryNoteName = deliveryNotePageObj.getDeliveryNoteName();
        Allure.step("Verify the name of current created delivery note is existed at delivery notes list view ");
        Assert.assertTrue(deliveryNotePageObj.getDeliveryNoteNameAtViewList(deliveryNoteName).contains(deliveryNoteName));

    }

}
