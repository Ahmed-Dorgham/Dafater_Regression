package Pages;

import GeneralConstants.GeneralConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SellingPriceListsPage extends MainPage {
    private String dataMigrationTitle = "data migration";
    // private WebDriver driver ;

    public SellingPriceListsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By checkVmConnectionBtn = By.id("check_vm_connection");
    private By syncDocTypesDataBtn = By.id("sync_doctypes_data");
    private By statusMsg = By.className("msgprint");
    private By editIcon = By.className("icon-xs");
    private By sellingPriceListsTitle = By.xpath("//h3[contains(text(),'قائمة الأسعار')]");
    private By listCount = By.xpath("(//*[contains(@class,'list-count')])");
    private By allItemsLabel = By.xpath("(//h3[contains(text(),'جميع العناصر')])");
    private By newBtn = By.xpath("//*[contains(@class,'btn btn-default btn-sm primary-action toolbar-btn')]");
    By overlay = By.xpath("//*[contains(@class,'freeze-message-container')]");
    By viewCompleteScreen = By.xpath("//*[@class='btn btn-secondary btn-sm']");
    By numberOfAllItemsField = By.xpath("//h3[contains(text(),'جميع العناصر')]/following-sibling::div");
    By standardSellingList = By.xpath("//*[contains(@title,'Standard Selling')]");
    By numberOfPurchaseItemsField = By.xpath("//h3[contains(text(),'عناصر الشراء')]/following-sibling::div");
    private By itemNameAtViewList = By.xpath("(//a[contains(@data-doctype,'Item')])[1]");
    private By invoiceStatusAtListView = By.xpath("(((((//*[contains(@class,'level list-row-head font-weight-bold')])/following-sibling::div)[2])/div/div/div)[3])/span/span");
    private By invoiceTotalAmountValueAtListView = By.xpath("(((((//*[contains(@class,'level list-row-head font-weight-bold')])/following-sibling::div)[2])/div/div/div))[6]/span/a/div/span");
    private By totalInvoicesAmountAtViewList = By.xpath("//h3[contains(text(),'اجمالي الفواتير')]/following-sibling::div");

    public ItemPage clickOnNewItemBtn() {
        System.out.println("click on new item btn ");
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(allItemsLabel, GeneralConstants.minTimeOut);
        waitUntilElementToBeClickable(newBtn, GeneralConstants.minTimeOut);

        getWebElement(newBtn).click();

        return new ItemPage(driver);
    }

    public String getInvoiceNameAtViewList(String expected) {

        waitUntilElementToBePresent(allItemsLabel, GeneralConstants.minTimeOut);
        waitUntilElementToBePresent(newBtn, GeneralConstants.minTimeOut);
        System.out.println("actual text is " + getWebElement(itemNameAtViewList).getAttribute("title") + " and expected text is " + expected);
        return getWebElement(itemNameAtViewList).getText();
    }

    public StandardSellingListPage openStandardSellingList() {

        waitUntilElementToBePresent(sellingPriceListsTitle, GeneralConstants.minTimeOut);
        System.out.println("open standard selling list");
        scrollToSpeceficElement(standardSellingList);
        getWebElement(standardSellingList).click();
        return new StandardSellingListPage(driver);
    }

    public String getNumberOfAllItemsBeforeCreatingNewItem() {

        waitUntilElementToBePresent(allItemsLabel, GeneralConstants.minTimeOut);
        System.out.println("number of all items at list view before creating new item " + getWebElement(numberOfAllItemsField).getText());
        return getWebElement(numberOfAllItemsField).getText();
    }

    public String getNumberOfItemsAfterCreatingNewItem() {

        waitUntilElementToBePresent(allItemsLabel, GeneralConstants.minTimeOut);
        System.out.println("number of all items at list view after creating new item " + getWebElement(numberOfAllItemsField).getText());
        return getWebElement(numberOfAllItemsField).getText();
    }

    public String getListAccountAfterCreatingNewSalesInvoices() {

        waitUntilElementToBePresent(allItemsLabel, GeneralConstants.minTimeOut);
        System.out.println("number of sales invoices at list view After creating new sales invoices " + getWebElement(listCount).getText());
        return getWebElement(listCount).getText();
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
