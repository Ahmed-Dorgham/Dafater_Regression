package Pages;

import GeneralConstants.GeneralConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WareHouseListPage extends MainPage {
    private String dataMigrationTitle = "data migration";
    // private WebDriver driver ;

    public WareHouseListPage(WebDriver driver) {
        this.driver = driver;
    }

    private By checkVmConnectionBtn = By.id("check_vm_connection");
    private By syncDocTypesDataBtn = By.id("sync_doctypes_data");
    private By statusMsg = By.className("msgprint");
    private By editIcon = By.className("icon-xs");
    private By salesInvoiceListTitle = By.xpath("(//*[contains(@title,'فاتورة المبيعات')]");
    private By listCount = By.xpath("(//*[contains(@class,'list-count')])");
    private By wareHouseLabel = By.xpath("(//h3[contains(text(),'المستودع')])");
    private By newBtn = By.xpath("//*[contains(@class,'btn btn-default btn-sm primary-action toolbar-btn')]");
    private By closeFilterIcon = By.xpath("(//*[contains(@class,'filter-icon')])[2]");
    By overlay = By.xpath("//*[contains(@class,'freeze-message-container')]");
    By viewCompleteScreen = By.xpath("//*[@class='btn btn-secondary btn-sm ']");
    By numberOfAllItemsField = By.xpath("//h3[contains(text(),'جميع العناصر')]/following-sibling::div");
    By numberOfSalesItemsField = By.xpath("//h3[contains(text(),'عناصر البيع')]/following-sibling::div");
    By numberOfPurchaseItemsField = By.xpath("//h3[contains(text(),'عناصر الشراء')]/following-sibling::div");
    private By itemNameAtViewList = By.xpath("(//a[contains(@data-doctype,'Item')])[1]");
    private By wareHouseNameAtViewList = By.xpath("(//a[contains(@data-doctype,'Warehouse')])[1]");
    private By invoiceStatusAtListView = By.xpath("(((((//*[contains(@class,'level list-row-head font-weight-bold')])/following-sibling::div)[2])/div/div/div)[3])/span/span");
    private By invoiceTotalAmountValueAtListView = By.xpath("(((((//*[contains(@class,'level list-row-head font-weight-bold')])/following-sibling::div)[2])/div/div/div))[6]/span/a/div/span");
    private By totalInvoicesAmountAtViewList = By.xpath("//h3[contains(text(),'اجمالي الفواتير')]/following-sibling::div");
    private By salesInvoicesTab = By.id("module-anchor-Selling");
    private By sellingPriceListsOpt = By.xpath("//*[contains(@id,'sidebar-selling-price-lists')]");

    public WareHousePage clickOnNewWareHouseBtn() {
        System.out.println("click on new warehouse btn ");
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(wareHouseLabel, GeneralConstants.minTimeOut);
        waitUntilElementToBeClickable(newBtn, GeneralConstants.minTimeOut);

        getWebElement(newBtn).click();
        return new WareHousePage(driver);
    }

    public String getWareHouseNameAtViewList(String expected) {

        waitUntilElementToBePresent(wareHouseLabel, GeneralConstants.minTimeOut);
        waitUntilElementToBePresent(newBtn, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);

        System.out.println("actual text is " + getWebElement(wareHouseNameAtViewList).getAttribute("title") + " and expected text is " + expected);
        return getWebElement(wareHouseNameAtViewList).getText();
    }

    public String getListAccountBeforeCreatingNewWareHouse() {

        waitUntilElementToBePresent(wareHouseLabel, GeneralConstants.minTimeOut);
        System.out.println("number of warehouse at list view before creating new ware house " + getWebElement(listCount).getText());
        return getWebElement(listCount).getText();
    }

    //
    public String getNumberOfAllWareHouseBeforeCreatingNewWareHouse() {

        waitUntilElementToBePresent(wareHouseLabel, GeneralConstants.minTimeOut);
        waitUntilElementNotContainText(listCount, "تحديث");
        System.out.println("number of all warehouses at list view before creating new warehouse " + getWebElement(listCount).getText());

        return getWebElement(listCount).getText();
    }

//    public String getNumberOfSalesItemsBeforeCreatingNewItem() {
//
//        waitUntilElementToBePresent(allItemsLabel, GeneralConstants.minTimeOut);
//        System.out.println("number of sales items at list view before creating new item " + getWebElement(numberOfSalesItemsField).getText());
//        return getWebElement(numberOfSalesItemsField).getText();
//    }
//
//    public String getNumberOfPurchaseItemsBeforeCreatingNewItem() {
//
//        waitUntilElementToBePresent(allItemsLabel, GeneralConstants.minTimeOut);
//        System.out.println("number of purchase items at list view before creating new item " + getWebElement(numberOfPurchaseItemsField).getText());
//        return getWebElement(numberOfPurchaseItemsField).getText();
//    }

    public SellingPriceListsPage openSellingPriceLists() {
        System.out.println("click on sales invoices tab ");
        getWebElement(salesInvoicesTab).click();
        System.out.println("open prices list page  ");
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(sellingPriceListsOpt, GeneralConstants.minTimeOut);
        getWebElement(sellingPriceListsOpt).click();
        driver.navigate().refresh();
        return new SellingPriceListsPage(driver);
    }

    public String getNumberOfAllWareHousesAfterCreatingNewWareHouse() {

        waitUntilElementToBePresent(wareHouseLabel, GeneralConstants.minTimeOut);
        System.out.println("number of all warehouse at list view after creating new warehouse " + getWebElement(listCount).getText());
        getWebElement(listCount).click();
        return getWebElement(listCount).getText();
    }
//
//    public String getNumberOfSalesItemsAfterCreatingNewItem() {
//
//        waitUntilElementToBePresent(allItemsLabel, GeneralConstants.minTimeOut);
//        System.out.println("number of sales items at list view after creating new item " + getWebElement(numberOfSalesItemsField).getText());
//        return getWebElement(numberOfSalesItemsField).getText();
//    }
//
//    public String getNumberOfPurchaseItemsAfterCreatingNewItem() {
//
//        waitUntilElementToBePresent(allItemsLabel, GeneralConstants.minTimeOut);
//        System.out.println("number of sales items at list view after creating new item " + getWebElement(numberOfPurchaseItemsField).getText());
//        return getWebElement(numberOfPurchaseItemsField).getText();
//    }
//
//    public String getListAccountAfterCreatingNewSalesInvoices() {
//
//        waitUntilElementToBePresent(allItemsLabel, GeneralConstants.minTimeOut);
//        System.out.println("number of sales invoices at list view After creating new sales invoices " + getWebElement(listCount).getText());
//        return getWebElement(listCount).getText();
//    }
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
