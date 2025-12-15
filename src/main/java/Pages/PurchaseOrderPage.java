package Pages;

import GeneralConstants.GeneralConstants;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PurchaseOrderPage extends MainPage {
    private String dataMigrationTitle = "data migration";
    // private WebDriver driver ;

    public PurchaseOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    private By checkVmConnectionBtn = By.id("check_vm_connection");
    private By updateStockBtn = By.id("update_stock");
    private By statusMsg = By.className("msgprint");
    private By editIcon = By.className("icon-xs");
    private By newPurchaseOrderTitle = By.xpath("//*[contains(@title,'أمر الشراء جديد')]");
    private By supplierFieldPurchaseOrder = By.xpath("(//*[contains(@id,'supplier')])[5]");
    private By itemCodeField = By.xpath("(//*[contains(@data-fieldname,'item_code')])[2]");
    private By itemCodeInputField = By.xpath("(//*[contains(@id,'item_code')])");
    private By suppliersListPurchaseOrder = By.xpath("(//*[contains(@data-target,'Supplier')and @placeholder=' ']/following-sibling::ul)");
    private By supplierOptPurchaseOrder = By.xpath("((//*[contains(@data-target,'Supplier')and @placeholder=' ']/following-sibling::ul)/li)[1]" +
            "| ((//*[contains(@data-target,'Supplier')and @placeholder=' ']/following-sibling::ul)//div/p/strong)[1]");
    private By itemOpt = By.xpath("((//*[contains(@data-target,'Item')and @placeholder='رمز الصنف']/following-sibling::ul)/li)[1]" +
            "|((//*[contains(@data-target,'Item')and @placeholder='رمز الصنف']/following-sibling::ul)//div/p/strong)[1]");
    private By createBtn = By.xpath("//*[contains(@class,'btn toolbar-btn btn-primary')]");
    private By purchaseInvoiceChoice = By.xpath("//*[contains(text(),'فاتورة المشتريات') and @class = 'dropdown-item']");
    private By saveAndSubmitBtn = By.xpath("//*[contains(@class,'btn btn-inverse btn-sm save-submit-action toolbar-btn')]");
    private By yesBtn = By.xpath("(//*[contains(@class,'btn btn-primary btn-sm btn-modal-primary')])");
    private By purchaseOrderStatus = By.xpath("(//*[contains(@class,'indicator-pill no-indicator-dot whitespace-nowrap orange')])");
    private By viewBtn = By.xpath("(//button[contains(text(),'واجهة')])[2]");
    private By purchaseOrdersOpt = By.xpath("//*[contains(@id,'sidebar-purchases-purchase-orders')]");
    private By purchaseInvoicesTab = By.id("module-icon-purchases");
    private By draftLabel = By.xpath("(//h3[contains(text(),'مسودة')])");
    private By purchaseOrderNameAtViewList = By.xpath("(//a[contains(@data-doctype,'Purchase Order')])[1]");
    private By purchaseOrderCompletedStatus = By.xpath("(//*[contains(@class,'indicator-pill no-indicator-dot whitespace-nowrap green')])");
    private By selectedItem = By.xpath("((//*[contains(@data-target,'Item')and @placeholder='رمز الصنف']/following-sibling::ul)//div//p[@title='item 1'])");

    public void enterValidDataIntoPurchaseOrderPage() throws InterruptedException {
        waitUntilElementVisibility(newPurchaseOrderTitle, GeneralConstants.minTimeOut);
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
        Allure.step("save and submit purchase order ");
        getWebElement(saveAndSubmitBtn).click();
        //Thread.sleep(10000);
        Allure.step("click on yes btn ");
        waitUntilElementToBeClickable(yesBtn, GeneralConstants.minTimeOut);
        getWebElement(yesBtn).click();

    }

    public String getPurchaseOrderStatusBeforeCreatingRelatedPurchaseInvoice() {
//        Allure.step("Verify the status of sales invoice  ");
        waitUntilElementToBePresent(createBtn, GeneralConstants.minTimeOut);
        Allure.step("status of purchase order before creating related purchase invoices " + getWebElement(purchaseOrderStatus).getText());
        return getWebElement(purchaseOrderStatus).getText();

    }

    public PurchaseInvoicesPage createNewPurchaseInvoiceFromSalesOrder() {
        Allure.step("click on create btn");
        waitUntilElementVisibility(createBtn, GeneralConstants.minTimeOut);
        getWebElement(createBtn).click();
        Allure.step("click on purchase invoice");
        waitUntilElementVisibility(purchaseInvoiceChoice, GeneralConstants.minTimeOut);
        getWebElement(purchaseInvoiceChoice).click();
        return new PurchaseInvoicesPage(driver);
    }


    public String getPurchaseOrderStatusAfterCreatingRelatedPurchaseInvoice() throws InterruptedException {
        waitUntilElementToBeClickable(purchaseInvoicesTab, GeneralConstants.minTimeOut);
//        getWebElement(salesInvoicesTab).click();
        Allure.step("click on purchase orders option");
        waitUntilElementToBePresent(purchaseOrdersOpt, GeneralConstants.minTimeOut);
        if (tryToGetWebElementV(purchaseOrdersOpt) == GeneralConstants.SUCCESS)
        {
//            getWebElement(purchaseOrdersOpt).click();
            clickByActions(purchaseOrdersOpt);
        }
        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        driver.navigate().refresh();
        Allure.step("open last created purchase order ");
        waitUntilElementToBePresent(purchaseOrderNameAtViewList, GeneralConstants.minTimeOut);
        getWebElement(purchaseOrderNameAtViewList).click();
        waitUntilElementToBePresent(createBtn, GeneralConstants.minTimeOut);
        Allure.step("status of purchase order after creating related purchase invoices " + getWebElement(purchaseOrderCompletedStatus).getText());
        return getWebElement(purchaseOrderCompletedStatus).getText();
    }
}
