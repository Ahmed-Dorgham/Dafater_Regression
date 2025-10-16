package Pages;

import GeneralConstants.GeneralConstants;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PurchaseReceiptPage extends MainPage {
    private String dataMigrationTitle = "data migration";
    // private WebDriver driver ;

    public PurchaseReceiptPage(WebDriver driver) {
        this.driver = driver;
    }

    private By checkVmConnectionBtn = By.id("check_vm_connection");
    private By updateStockBtn = By.id("update_stock");
    private By statusMsg = By.className("msgprint");
    private By editIcon = By.className("icon-xs");
    private By newPurchaseOrderTitle = By.xpath("//*[contains(@title,'أمر الشراء جديد')]");
    private By newPurchaseReceiptTitle = By.xpath("//*[contains(@title,'سند إستلام جديد')]");
    private By supplierFieldPurchaseOrder = By.xpath("(//*[contains(@id,'supplier')])[5]");
    private By itemCodeField = By.xpath("(//*[contains(@data-fieldname,'item_code')])[2]");
    private By itemCodeInputField = By.xpath("(//*[contains(@id,'item_code')])");
    private By suppliersListPurchaseOrder = By.xpath("(//*[contains(@data-target,'Supplier')and @placeholder=' ']/following-sibling::ul)");
    private By supplierOptPurchaseOrder = By.xpath("((//*[contains(@data-target,'Supplier')and @placeholder=' ']/following-sibling::ul)/li)[1]" +
            "| ((//*[contains(@data-target,'Supplier')and @placeholder=' ']/following-sibling::ul)//div/p/strong)[1]");
    private By itemOpt = By.xpath("((//*[contains(@data-target,'Item')and @placeholder='رمز الصنف']/following-sibling::ul)/li)[1]" +
            "| ((//*[contains(@data-target,'Item')and @placeholder='رمز الصنف']/following-sibling::ul)//div/p/strong)[1]");
    private By createBtn = By.xpath("//*[contains(@class,'btn toolbar-btn btn-primary')]");
    private By cancelBtn = By.xpath("(//*[contains(text(),'إلغاء')])[2]");
    private By closeIcon = By.xpath("(//*[contains(@class,'btn btn-modal-close btn-link')])[2]");
    private By closeIcon_3 = By.xpath("(//*[contains(@class,'btn btn-modal-close btn-link')])[3]");
    private By purchaseInvoiceChoice = By.xpath("//*[contains(text(),'فاتورة المشتريات') and @class = 'dropdown-item']");
    private By saveAndSubmitBtn = By.xpath("//*[contains(@class,'btn btn-inverse btn-sm save-submit-action toolbar-btn')]");
    private By yesBtn = By.xpath("(//*[contains(@class,'btn btn-primary btn-sm btn-modal-primary')])");
    private By purchaseOrderStatus = By.xpath("(//*[contains(@class,'indicator-pill no-indicator-dot whitespace-nowrap orange')])");
    private By purchaseReceiptStatus = By.xpath("(//*[contains(@class,'indicator-pill no-indicator-dot whitespace-nowrap orange')])");
    private By viewBtn = By.xpath("(//button[contains(text(),'واجهة')])[2]");
    private By purchaseOrdersOpt = By.xpath("//*[contains(@id,'sidebar-purchases-purchase-orders')]");
    private By purchaseReceiptOpt = By.xpath("(//*[contains(@id,'sidebar-stock-purchase-receipt')]/span)[1]");
    private By wareHouseTab = By.id("module-anchor-Stock");
    private By purchaseInvoicesTab = By.id("module-icon-purchases");
    private By draftLabel = By.xpath("(//h3[contains(text(),'مسودة')])");
    private By purchaseReceiptNameAtViewList = By.xpath("(//a[contains(@data-doctype,'Purchase Receipt')])[1]");
    private By purchaseReceiptCompletedStatus = By.xpath("(//*[contains(@class,'indicator-pill no-indicator-dot whitespace-nowrap green')])");
    By overlay = By.xpath("//*[contains(@class,'freeze-message-container')]");
    private By newBtn = By.xpath("//*[contains(@class,'btn btn-default btn-sm primary-action toolbar-btn')]");
    private By selectedItem = By.xpath("((//*[contains(@data-target,'Item')and @placeholder='رمز الصنف']/following-sibling::ul)//div//p[@title='item 1'])");

    public void enterValidDataIntoPurchaseOrderPage() throws InterruptedException {
        waitUntilElementVisibility(newPurchaseReceiptTitle, GeneralConstants.minTimeOut);
       Allure.step("select  supplier ");
        getWebElement(supplierFieldPurchaseOrder).click();
        waitUntilElementVisibility(suppliersListPurchaseOrder, GeneralConstants.minTimeOut);
        waitUntilElementToBeClickable(supplierOptPurchaseOrder, GeneralConstants.minTimeOut);
        getWebElement(supplierOptPurchaseOrder).click();
//       Allure.step("enter dues date  ");
//        waitUntilElementVisibility(dueDateField, GeneralConstants.minTimeOut);
//        getWebElement(dueDateField).sendKeys(dueDate);
       Allure.step("Scroll down to item field ");
        scrollToSpeceficElement(itemCodeField);
//        Thread.sleep(6000);
       Allure.step(" select item  ");
        clickByActions(itemCodeField);
        waitUntilElementVisibility(itemCodeInputField, GeneralConstants.minTimeOut);
        getWebElement(itemCodeInputField).sendKeys("item");
        waitUntilElementToBeClickable(itemOpt, GeneralConstants.minTimeOut);
        scrollToSpeceficElement(itemOpt);
        getWebElement(itemOpt).click();
//       Allure.step("unselect update stock opt");
//        getWebElement(updateStockBtn).click();
//        Thread.sleep(6000);
       Allure.step("scroll up to save and submit btn ");
        scrollToSpeceficElement(saveAndSubmitBtn);
       Allure.step("save and submit purchase receipt ");
        getWebElement(saveAndSubmitBtn).click();
        //Thread.sleep(10000);
       Allure.step("click on yes btn ");
        waitUntilElementToBeClickable(yesBtn, GeneralConstants.minTimeOut);
        getWebElement(yesBtn).click();

    }

    public void enterValidDataIntoPurchaseReceiptPage() throws InterruptedException {
        waitUntilElementVisibility(newPurchaseReceiptTitle, GeneralConstants.minTimeOut);
       Allure.step("select  supplier ");
        getWebElement(supplierFieldPurchaseOrder).click();
        waitUntilElementVisibility(suppliersListPurchaseOrder, GeneralConstants.minTimeOut);
        waitUntilElementToBeClickable(supplierOptPurchaseOrder, GeneralConstants.minTimeOut);
        getWebElement(supplierOptPurchaseOrder).click();
       Allure.step("Scroll down to item field ");
        scrollToSpeceficElement(itemCodeField);
       Allure.step(" select item  ");
        waitUntilElementToBePresent(itemCodeField, GeneralConstants.minTimeOut);
//        clickByActions(itemCodeField);
        getWebElement(itemCodeField).click();
        waitUntilElementToBePresent(itemCodeInputField, GeneralConstants.minTimeOut);
        getWebElement(itemCodeInputField).sendKeys("item 1");
        waitUntilElementToBeClickable(itemOpt, GeneralConstants.minTimeOut);
        getWebElement(itemCodeInputField).clear();
        getWebElement(itemCodeInputField).sendKeys("item 1");
//        getWebElement(itemCodeInputField).sendKeys("item 1");

        waitUntilElementToBeClickable(selectedItem, GeneralConstants.minTimeOut);
        clickByActions(selectedItem);
       Allure.step("scroll up to save and submit btn ");
        scrollToSpeceficElement(saveAndSubmitBtn);
       Allure.step("save and submit purchase receipt ");
        getWebElement(saveAndSubmitBtn).click();
        //Thread.sleep(10000);
       Allure.step("click on yes btn ");
        waitUntilElementToBeClickable(yesBtn, GeneralConstants.minTimeOut);
        getWebElement(yesBtn).click();

    }

    public String getPurchaseOrderStatusBeforeCreatingRelatedPurchaseInvoice() {
//       Allure.step("Verify the status of sales invoice  ");
        waitUntilElementToBePresent(createBtn, GeneralConstants.minTimeOut);
       Allure.step("status of purchase order before creating related purchase invoices " + getWebElement(purchaseOrderStatus).getText());
        return getWebElement(purchaseOrderStatus).getText();

    }

    public String getPurchaseReceiptStatusBeforeCreatingRelatedPurchaseInvoice() {
//       Allure.step("Verify the status of sales invoice  ");
        waitUntilElementToBePresent(cancelBtn, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);

        if (tryToGetWebElement(closeIcon) == GeneralConstants.SUCCESS) {
            getWebElement(closeIcon).click();
        }
       Allure.step("status of purchase receipt before creating related purchase invoices " + getWebElement(purchaseReceiptStatus).getText());
        return getWebElement(purchaseReceiptStatus).getText();

    }

    public PurchaseInvoicesPage createNewPurchaseInvoiceFromPurchaseReceipt() {
       Allure.step("click on create btn");
        waitUntilElementVisibility(createBtn, GeneralConstants.minTimeOut);
        if (tryToGetWebElement(closeIcon) == GeneralConstants.SUCCESS) {
            getWebElement(closeIcon).click();
        }


        getWebElement(createBtn).click();
       Allure.step("click on purchase invoice");
        waitUntilElementVisibility(purchaseInvoiceChoice, GeneralConstants.minTimeOut);
        getWebElement(purchaseInvoiceChoice).click();
        return new PurchaseInvoicesPage(driver);
    }


    public String getPurchaseReceiptStatusAfterCreatingRelatedPurchaseInvoice() throws InterruptedException {

        waitUntilElementToBePresent(viewBtn, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        if (tryToGetWebElement(closeIcon_3) == GeneralConstants.SUCCESS) {
            waitUntilElementToBePresent(closeIcon_3,GeneralConstants.minTimeOut);
            clickByActions(closeIcon_3);
        }
        waitUntilElementToBeClickable(wareHouseTab, GeneralConstants.minTimeOut);
        getWebElement(wareHouseTab).click();
//        waitUntilOverlayDisappear(overlay,GeneralConstants.freezeTimeOut);
//        getWebElement(salesInvoicesTab).click();
       Allure.step("click on purchase receipt option");
        waitUntilElementToBePresent(purchaseReceiptOpt, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
//        Thread.sleep(9000);
        getWebElement(purchaseReceiptOpt).click();
        //  clickByActions(purchaseOrdersOpt);

        waitUntilElementToBePresent(newBtn, GeneralConstants.minTimeOut);
        driver.navigate().refresh();
       Allure.step("open last created purchase receipt ");
        getWebElement(purchaseReceiptNameAtViewList).click();
        waitUntilElementToBePresent(createBtn, GeneralConstants.minTimeOut);
       Allure.step("status of purchase receipt after creating related purchase invoices " + getWebElement(purchaseReceiptCompletedStatus).getText());
        return getWebElement(purchaseReceiptCompletedStatus).getText();

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
