package TestCases;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class AddingItemsTest extends BaseTest {
    Random random;
    int randomNumber;
    String itemCode;

    ItemPage itemPageObj;
    ItemListPage itemListPageObj;
    SellingPriceListsPage sellingPriceListsPageObj;
    StandardSellingListPage standardSellingListPageObj;
    ItemsPricesTablePage itemsPricesTablePageObj;
    ItemPricePage itemPricePageObj;
    @Test(priority = 1, enabled = true)
    public void TC01_createNewSalesAndPurchaseItemAndAddingIntoPriceList() throws InterruptedException {
        random = new Random();
        randomNumber = random.nextInt(1000000000);
        itemCode = "item 2" + randomNumber;
        homePageObj = new HomePage(driver);
        itemListPageObj = homePageObj.openItemListPage();
        String numberOfAllItemsBeforeCreatingNewOne = itemListPageObj.getNumberOfAllItemsBeforeCreatingNewItem();
        itemPageObj = itemListPageObj.clickOnNewItemBtn();
        itemPageObj.enterValidDataIntoItemPage(itemCode);
        Assert.assertTrue(itemPageObj.getItemName(itemCode).contains(itemCode));
        System.out.println("Verify the name of current created item is existed at item list view ");
        itemListPageObj = itemPageObj.openItemListPage();
        Assert.assertTrue(itemListPageObj.getItemNameAtViewList(itemCode).contains(itemCode));
        String numberOfItemsAfterCreatingNewOne = itemListPageObj.getNumberOfAllItemsAfterCreatingNewItem();
        System.out.println("verify that number of all items at list view will increase by one after creating new item");
        Assert.assertFalse(numberOfAllItemsBeforeCreatingNewOne.contains(numberOfItemsAfterCreatingNewOne));
        System.out.println(" number of all items at list view before creating new one is " + numberOfAllItemsBeforeCreatingNewOne + " and after creating new one is  " + numberOfItemsAfterCreatingNewOne + " and this is correct ");
        sellingPriceListsPageObj = itemListPageObj.openSellingPriceLists();
        standardSellingListPageObj = sellingPriceListsPageObj.openStandardSellingList();
        itemsPricesTablePageObj = standardSellingListPageObj.openItemsPricesTable();
        itemPricePageObj = itemsPricesTablePageObj.openItemPricePage();
        itemPricePageObj.addingPriceForItem(itemCode, itemPrice);
    }

    @Test(priority = 2, enabled = true)
    public void TC02_createNewSalesItem() throws InterruptedException {
        random = new Random();
        randomNumber = random.nextInt(1000000000);
        itemCode = "item 2" + randomNumber;
//        homePageObj = new HomePage(driver);
        itemListPageObj = homePageObj.openItemListPage();
        String numberOfSalesItemsBeforeCreatingNewOne = itemListPageObj.getNumberOfSalesItemsBeforeCreatingNewItem();
        String numberOfPurchaseItemsBeforeCreatingNewOne = itemListPageObj.getNumberOfPurchaseItemsBeforeCreatingNewItem();
        itemPageObj = itemListPageObj.clickOnNewItemBtn();
        itemPageObj.enterValidDataForSalesItem(itemCode);
        Assert.assertTrue(itemPageObj.getItemCode(itemCode).contains(itemCode));
        System.out.println("Verify the name of current created sales item is existed at item list view ");
        itemListPageObj = itemPageObj.openItemListPage();
        Assert.assertTrue(itemListPageObj.getItemNameAtViewList(itemCode).contains(itemCode));
        String numberOfSalesItemsAfterCreatingNewOne = itemListPageObj.getNumberOfSalesItemsAfterCreatingNewItem();
        String numberOfPurchaseItemsAfterCreatingNewOne = itemListPageObj.getNumberOfPurchaseItemsAfterCreatingNewItem();
        System.out.println("verify that number of sales items at list view will increase by one after creating new sales item");
        Assert.assertFalse(numberOfSalesItemsBeforeCreatingNewOne.contains(numberOfSalesItemsAfterCreatingNewOne));
        System.out.println(" number of sales items at list view before creating new one is " + numberOfSalesItemsBeforeCreatingNewOne + " and after creating new one is  " + numberOfSalesItemsAfterCreatingNewOne + " and this is correct ");
        System.out.println("verify that number of purchase items at list view will not increase after creating new sales item");
        Assert.assertTrue(numberOfPurchaseItemsBeforeCreatingNewOne.contains(numberOfPurchaseItemsAfterCreatingNewOne));
        System.out.println(" number of purchase items at list view before creating new one is " + numberOfPurchaseItemsBeforeCreatingNewOne + " and after creating new one is  " + numberOfPurchaseItemsAfterCreatingNewOne + " and this is correct ");
    }
    @Test(priority = 3, enabled = true)
    public void TC03_createNewPurchaseItem() throws InterruptedException {
        random = new Random();
        randomNumber = random.nextInt(1000000000);
        itemCode = "item 2" + randomNumber;
//        homePageObj = new HomePage(driver);
        itemListPageObj = homePageObj.openItemListPage();
        String numberOfSalesItemsBeforeCreatingNewOne = itemListPageObj.getNumberOfSalesItemsBeforeCreatingNewItem();
        String numberOfPurchaseItemsBeforeCreatingNewOne = itemListPageObj.getNumberOfPurchaseItemsBeforeCreatingNewItem();
        itemPageObj = itemListPageObj.clickOnNewItemBtn();
        itemPageObj.enterValidDataForPurchaseItem(itemCode);
        Assert.assertTrue(itemPageObj.getItemName_3(itemCode).contains(itemCode));

        System.out.println("Verify the name of current created sales item is existed at item list view ");
        itemListPageObj = itemPageObj.openItemListPage();
        Assert.assertTrue(itemListPageObj.getItemNameAtViewList(itemCode).contains(itemCode));

        String numberOfSalesItemsAfterCreatingNewOne = itemListPageObj.getNumberOfSalesItemsAfterCreatingNewItem();
        String numberOfPurchaseItemsAfterCreatingNewOne = itemListPageObj.getNumberOfPurchaseItemsAfterCreatingNewItem();
        System.out.println("verify that number of purchase items at list view will increase by one after creating new purchase item");

        Assert.assertFalse(numberOfPurchaseItemsBeforeCreatingNewOne.contains(numberOfPurchaseItemsAfterCreatingNewOne));
        System.out.println(" number of purchase items at list view before creating new one is " + numberOfPurchaseItemsBeforeCreatingNewOne + " and after creating new one is  " + numberOfPurchaseItemsAfterCreatingNewOne + " and this is correct ");

        System.out.println("verify that number of sales items at list view will not increase after creating new purchase item");

        Assert.assertTrue(numberOfSalesItemsBeforeCreatingNewOne.contains(numberOfSalesItemsAfterCreatingNewOne));
        System.out.println(" number of sales items at list view before creating new one is " + numberOfSalesItemsBeforeCreatingNewOne + " and after creating new one is  " + numberOfSalesItemsAfterCreatingNewOne + " and this is correct ");

    }



}
