package Pages;

import GeneralConstants.GeneralConstants;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StockEntryListPage extends MainPage {
    private String dataMigrationTitle = "data migration";
    // private WebDriver driver ;

    public StockEntryListPage(WebDriver driver) {
        this.driver = driver;
    }

    private By checkVmConnectionBtn = By.id("check_vm_connection");
    private By syncDocTypesDataBtn = By.id("sync_doctypes_data");
    private By statusMsg = By.className("msgprint");
    private By editIcon = By.className("icon-xs");
    private By stockEntryListLabel = By.xpath("//h5[contains(text(),'قائمة حركة مخزون')]" +
            "| //h3[contains(text(),'حركة المخزون')]");
    private By listCount_4 = By.xpath("(//*[contains(@class,'total-rows')])");
    private By listCount_5 = By.xpath("(//*[contains(@class,'total-rows')])");
    private By allItemsLabel = By.xpath("(//h3[contains(text(),'جميع العناصر')])| (//div[contains(text(),'الاصناف الكلية')])");
    private By newBtn = By.xpath("//*[contains(@class,'btn btn-default btn-sm primary-action toolbar-btn')]");
    private By closeFilterIcon = By.xpath("(//*[contains(@class,'filter-icon')])[2]");
    By overlay = By.xpath("//*[contains(@class,'freeze-message-container')] | //*[contains(@id,'freeze')]");
    By viewCompleteScreen = By.xpath("//*[@class='btn btn-secondary btn-sm ']");
    By numberOfAllItemsField = By.xpath("//h3[contains(text(),'جميع العناصر')]/following-sibling::div " +
            "|//*[contains(@class,'item-all')]");
    By numberOfSalesItemsField = By.xpath("//h3[contains(text(),'عناصر البيع')]/following-sibling::div " +
            "|//*[contains(@class,'item-sales-items ')]");
    By numberOfPurchaseItemsField = By.xpath("//h3[contains(text(),'عناصر الشراء')]/following-sibling::div" +
            "|//*[contains(@class,'item-purchase-items ')]");
    private By itemNameAtViewList = By.xpath("(//a[contains(@data-doctype,'Item')])[1]");
    private By invoiceStatusAtListView = By.xpath("(((((//*[contains(@class,'level list-row-head font-weight-bold')])/following-sibling::div)[2])/div/div/div)[3])/span/span");
    private By invoiceTotalAmountValueAtListView = By.xpath("(((((//*[contains(@class,'level list-row-head font-weight-bold')])/following-sibling::div)[2])/div/div/div))[6]/span/a/div/span");
    private By totalInvoicesAmountAtViewList = By.xpath("//h3[contains(text(),'اجمالي الفواتير')]/following-sibling::div");
    private By salesInvoicesTab = By.id("module-anchor-Selling");
    private By sellingPriceListsOpt = By.xpath("//*[contains(@id,'sidebar-selling-price-lists')]");

    public ItemPage clickOnNewItemBtn() {
      Allure.step("click on new item btn ");
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(allItemsLabel, GeneralConstants.minTimeOut);
        waitUntilElementToBeClickable(newBtn, GeneralConstants.minTimeOut);

        getWebElement(newBtn).click();
        waitUntilElementToBePresent(viewCompleteScreen, GeneralConstants.minTimeOut);
        getWebElement(viewCompleteScreen).click();
        return new ItemPage(driver);
    }

    public String getItemNameAtViewList(String expected) {

        waitUntilElementToBePresent(allItemsLabel, GeneralConstants.minTimeOut);
        waitUntilElementToBePresent(newBtn, GeneralConstants.minTimeOut);

      Allure.step("actual text is " + getWebElement(itemNameAtViewList).getAttribute("title") + " and expected text is " + expected);
        return getWebElement(itemNameAtViewList).getText();
    }

    public String getListAccountBeforeCreatingNewSalesInvoices() {

        waitUntilElementToBePresent(allItemsLabel, GeneralConstants.minTimeOut);
      Allure.step("number of sales invoices at list view before creating new sales invoices " + getWebElement(listCount_4).getText());
        return getWebElement(listCount_4).getText();
    }

    public String getNumberOfAllItemsBeforeCreatingNewItem() throws InterruptedException {

        waitUntilElementToBePresent(allItemsLabel, GeneralConstants.minTimeOut);

      Allure.step("number of all items at list view before creating new item " + getWebElement(numberOfAllItemsField).getText());
        return getWebElement(numberOfAllItemsField).getText();
    }

    public String getNumberOfAllStockEntriesBeforeSyncing() throws InterruptedException {

        waitUntilElementToBePresent(stockEntryListLabel, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
      Allure.step("number of all stock entries at list view before Syncing " + getWebElement(listCount_4).getText());
        return getWebElement(listCount_4).getText();
    }

    public String getNumberOfAllStockEntriesAfterSyncing() throws InterruptedException {

        waitUntilElementToBePresent(stockEntryListLabel, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementNotHaveSpecificText(listCount_5, "تحديث");
      Allure.step("number of all stock entries at list view after Syncing " + getWebElement(listCount_5).getText());
        if (getWebElement(listCount_5).getText().contains("من"))
        {
            Allure.step("number of all stock entries at list view after Syncing  " + getWebElement(listCount_5).getText());

            Allure.step("number of all stock entries at list view after Syncing  0 ");
            return "0";
        }

        return getWebElement(listCount_5).getText();
    }

    public String getNumberOfAllItemsAfterSyncing() throws InterruptedException {

        waitUntilElementToBePresent(allItemsLabel, GeneralConstants.minTimeOut);
        //   Thread.sleep(threadTimeOut);
      Allure.step("number of all items at list view after Syncing " + getWebElement(numberOfAllItemsField).getText());
        return getWebElement(numberOfAllItemsField).getText();
    }

    public String getNumberOfSalesItemsBeforeCreatingNewItem() {

        waitUntilElementToBePresent(allItemsLabel, GeneralConstants.minTimeOut);
      Allure.step("number of sales items at list view before creating new item " + getWebElement(numberOfSalesItemsField).getText());
        return getWebElement(numberOfSalesItemsField).getText();
    }

    public String getNumberOfSalesItemsBeforeSyncing() throws InterruptedException {

        waitUntilElementToBePresent(allItemsLabel, GeneralConstants.minTimeOut);
//        Thread.sleep(threadTimeOut);
      Allure.step("number of sales items at list view before Syncing " + getWebElement(numberOfSalesItemsField).getText());
        return getWebElement(numberOfSalesItemsField).getText();
    }

    public String getNumberOfSalesItemsAfterSyncing() throws InterruptedException {

        waitUntilElementToBePresent(allItemsLabel, GeneralConstants.minTimeOut);
//        Thread.sleep(threadTimeOut);
      Allure.step("number of sales items at list view after Syncing " + getWebElement(numberOfSalesItemsField).getText());
        return getWebElement(numberOfSalesItemsField).getText();
    }

    public String getNumberOfPurchaseItemsBeforeCreatingNewItem() {

        waitUntilElementToBePresent(allItemsLabel, GeneralConstants.minTimeOut);
      Allure.step("number of purchase items at list view before creating new item " + getWebElement(numberOfPurchaseItemsField).getText());
        return getWebElement(numberOfPurchaseItemsField).getText();
    }

    public String getNumberOfPurchaseItemsBeforeSyncing() throws InterruptedException {

        waitUntilElementToBePresent(allItemsLabel, GeneralConstants.minTimeOut);
//        Thread.sleep(threadTimeOut);
      Allure.step("number of purchase items at list view before Syncing " + getWebElement(numberOfPurchaseItemsField).getText());
        return getWebElement(numberOfPurchaseItemsField).getText();
    }

    public String getNumberOfPurchaseItemsAfterSyncing() throws InterruptedException {

        waitUntilElementToBePresent(allItemsLabel, GeneralConstants.minTimeOut);
//        Thread.sleep(threadTimeOut);
      Allure.step("number of purchase items at list view after Syncing " + getWebElement(numberOfPurchaseItemsField).getText());
        return getWebElement(numberOfPurchaseItemsField).getText();
    }

    public SellingPriceListsPage openSellingPriceLists() {
      Allure.step("click on sales invoices tab ");
        getWebElement(salesInvoicesTab).click();
      Allure.step("open prices list page  ");
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(sellingPriceListsOpt, GeneralConstants.minTimeOut);
        getWebElement(sellingPriceListsOpt).click();
        driver.navigate().refresh();
        return new SellingPriceListsPage(driver);
    }

    public String getNumberOfAllItemsAfterCreatingNewItem() {

        waitUntilElementToBePresent(allItemsLabel, GeneralConstants.minTimeOut);
      Allure.step("number of all items at list view after creating new item " + getWebElement(numberOfAllItemsField).getText());
        return getWebElement(numberOfAllItemsField).getText();
    }

    public String getNumberOfSalesItemsAfterCreatingNewItem() {

        waitUntilElementToBePresent(allItemsLabel, GeneralConstants.minTimeOut);
      Allure.step("number of sales items at list view after creating new item " + getWebElement(numberOfSalesItemsField).getText());
        return getWebElement(numberOfSalesItemsField).getText();
    }

    public String getNumberOfPurchaseItemsAfterCreatingNewItem() {

        waitUntilElementToBePresent(allItemsLabel, GeneralConstants.minTimeOut);
      Allure.step("number of sales items at list view after creating new item " + getWebElement(numberOfPurchaseItemsField).getText());
        return getWebElement(numberOfPurchaseItemsField).getText();
    }

    public String getListAccountAfterCreatingNewSalesInvoices() {

        waitUntilElementToBePresent(allItemsLabel, GeneralConstants.minTimeOut);
      Allure.step("number of sales invoices at list view After creating new sales invoices " + getWebElement(listCount_4).getText());
        return getWebElement(listCount_4).getText();
    }
//    public void enterValidDataIntoMainData (String vmUrl , String apiKey , String secretKey)
//    {
//        waitUntilElementVisibility(vmUrlInputField,GeneralConstants.minTimeOut);
//        getWebElement(vmUrlInputField).clear();
//        getWebElement(vmUrlInputField).sendKeys(vmUrl);
//        getWebElement(apiKeyInputField).clear();
//        getWebElement(apiKeyInputField).sendKeys(apiKey);
//        getWebElement(secretKeyInputField).clear();
//        getWebElement(secretKeyInputField).sendKeys(secretKey);
//    }
}
