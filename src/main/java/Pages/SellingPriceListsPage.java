package Pages;

import GeneralConstants.GeneralConstants;
import io.qameta.allure.Allure;
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
    private By sellingPriceListsTitle = By.xpath("//h3[contains(text(),'قائمة الأسعار')]" +
            "|//h5[contains(text(),'قائمة الأسعار')]");
    private By listCount = By.xpath("(//*[contains(@class,'list-count')])");
    private By allItemsLabel = By.xpath("(//h3[contains(text(),'جميع العناصر')])");
    private By newBtn = By.xpath("//*[contains(@class,'btn btn-default btn-sm primary-action toolbar-btn')]");
    By overlay = By.xpath("//*[contains(@class,'freeze-message-container')]");
    By viewCompleteScreen = By.xpath("//*[@class='btn btn-secondary btn-sm']");
    By numberOfAllItemsField = By.xpath("//h3[contains(text(),'جميع العناصر')]/following-sibling::div");
    By standardSellingList = By.xpath("//*[contains(@title,'Standard Selling')]");
    By standardBuyingList = By.xpath("//*[contains(@title,'Standard Buying')]");
    By numberOfPurchaseItemsField = By.xpath("//h3[contains(text(),'عناصر الشراء')]/following-sibling::div");
    private By itemNameAtViewList = By.xpath("(//a[contains(@data-doctype,'Item')])[1]");
    private By invoiceStatusAtListView = By.xpath("(((((//*[contains(@class,'level list-row-head font-weight-bold')])/following-sibling::div)[2])/div/div/div)[3])/span/span");
    private By invoiceTotalAmountValueAtListView = By.xpath("(((((//*[contains(@class,'level list-row-head font-weight-bold')])/following-sibling::div)[2])/div/div/div))[6]/span/a/div/span");
    private By totalInvoicesAmountAtViewList = By.xpath("//h3[contains(text(),'اجمالي الفواتير')]/following-sibling::div");
    private By saveBtn = By.xpath("//*[contains(@id,'appframe-btn-حفظ')]");
    private By closeIcon = By.xpath("(//*[contains(@data-dismiss,'modal')])[1]");
    private By addBtn = By.xpath("(//*[contains(text(),' إضافة صف جديد')])[2]");
    private By itemCode_4 = By.xpath("//*[contains(@title,'رمز الصنف')]//*[contains(@data-fieldname,'item_code')]");
    private By itemPrice_4 = By.xpath("//*[contains(@title,'ref_rate')]//*[contains(@data-fieldname,'ref_rate')]");
    public void addingPriceForItem_4(String itemCode, String price) throws InterruptedException {

//        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(saveBtn, GeneralConstants.minTimeOut);
        Allure.step("add item price  ");
        scrollToSpeceficElement(addBtn);
        getWebElement(addBtn).click();
        waitUntilElementVisibility(itemCode_4,GeneralConstants.minTimeOut);
        getWebElement(itemCode_4).sendKeys(itemCode);
        getWebElement(itemPrice_4).click();
        getWebElement(itemPrice_4).sendKeys(price);
        getWebElement(itemCode_4).click();
        Allure.step("click on save btn  ");
        scrollToSpeceficElement(saveBtn);
        Thread.sleep(threadTimeOut);
        getWebElement(saveBtn).click();
        waitUntilElementVisibility(closeIcon,GeneralConstants.minTimeOut);
        getWebElement(closeIcon).click();
//        getWebElement(newBtn).click();
//        Allure.step("adding price for item ");
//        waitUntilElementToBePresent(newItemPriceTitle, GeneralConstants.minTimeOut);
//        waitUntilElementToBePresent(itemCodeField, GeneralConstants.minTimeOut);
//        getWebElement(itemCodeField).click();
//        Allure.step("enter item code ");
//        getWebElement(itemCodeField).sendKeys(itemCode);
//        getWebElement(newItemPriceTitle).click();
//        //getWebElement(uomField).sendKeys(uom);
//        scrollToSpeceficElement(itemPriceField);
//        getWebElement(itemPriceField).click();
//        getWebElement(itemPriceField).clear();
//        getWebElement(itemPriceField).clear();
//        Allure.step("enter item price ");
//        getWebElement(itemPriceField).sendKeys(price);
//        scrollToSpeceficElement(saveBtn);
//        Allure.step("click on save btn");
//        getWebElement(saveBtn).click();
//        waitUntilElementToBePresent(saveMsg, GeneralConstants.minTimeOut);
    }
    public ItemPage clickOnNewItemBtn() {
       Allure.step("click on new item btn ");
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(allItemsLabel, GeneralConstants.minTimeOut);
        waitUntilElementToBeClickable(newBtn, GeneralConstants.minTimeOut);

        getWebElement(newBtn).click();

        return new ItemPage(driver);
    }


    public String getInvoiceNameAtViewList(String expected) {

        waitUntilElementToBePresent(allItemsLabel, GeneralConstants.minTimeOut);
        waitUntilElementToBePresent(newBtn, GeneralConstants.minTimeOut);
       Allure.step("actual text is " + getWebElement(itemNameAtViewList).getAttribute("title") + " and expected text is " + expected);
        return getWebElement(itemNameAtViewList).getText();
    }

    public StandardSellingListPage openStandardSellingList() {

        waitUntilElementToBePresent(sellingPriceListsTitle, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay,GeneralConstants.freezeTimeOut);
       Allure.step("open standard selling list");
        waitUntilElementToBePresent(standardSellingList, GeneralConstants.minTimeOut);
        scrollToSpeceficElement(standardSellingList);
        getWebElement(standardSellingList).click();
        return new StandardSellingListPage(driver);
    }
    public StandardBuyingListPage openStandardBuyingList() {

        waitUntilElementToBePresent(sellingPriceListsTitle, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay,GeneralConstants.freezeTimeOut);
        Allure.step("open standard buying list");
        waitUntilElementToBePresent(standardBuyingList, GeneralConstants.minTimeOut);
        scrollToSpeceficElement(standardBuyingList);
        getWebElement(standardBuyingList).click();
        return new StandardBuyingListPage(driver);
    }

    public String getNumberOfAllItemsBeforeCreatingNewItem() {

        waitUntilElementToBePresent(allItemsLabel, GeneralConstants.minTimeOut);
       Allure.step("number of all items at list view before creating new item " + getWebElement(numberOfAllItemsField).getText());
        return getWebElement(numberOfAllItemsField).getText();
    }

    public String getNumberOfItemsAfterCreatingNewItem() {

        waitUntilElementToBePresent(allItemsLabel, GeneralConstants.minTimeOut);
       Allure.step("number of all items at list view after creating new item " + getWebElement(numberOfAllItemsField).getText());
        return getWebElement(numberOfAllItemsField).getText();
    }

    public String getListAccountAfterCreatingNewSalesInvoices() {

        waitUntilElementToBePresent(allItemsLabel, GeneralConstants.minTimeOut);
       Allure.step("number of sales invoices at list view After creating new sales invoices " + getWebElement(listCount).getText());
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
