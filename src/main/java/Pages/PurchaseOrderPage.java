package Pages;

import GeneralConstants.GeneralConstants;
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
    private By supplierOptPurchaseOrder = By.xpath("((//*[contains(@data-target,'Supplier')and @placeholder=' ']/following-sibling::ul)/li)[1]");
    private By itemOpt = By.xpath("((//*[contains(@data-target,'Item')and @placeholder='رمز الصنف']/following-sibling::ul)/li)[1]");
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

    public void enterValidDataIntoPurchaseOrderPage() throws InterruptedException {
        waitUntilElementVisibility(newPurchaseOrderTitle, GeneralConstants.minTimeOut);
        System.out.println("select  supplier ");
        getWebElement(supplierFieldPurchaseOrder).click();
        waitUntilElementVisibility(suppliersListPurchaseOrder, GeneralConstants.minTimeOut);
        waitUntilElementToBeClickable(supplierOptPurchaseOrder, GeneralConstants.minTimeOut);
        getWebElement(supplierOptPurchaseOrder).click();
//        System.out.println("enter dues date  ");
//        waitUntilElementVisibility(dueDateField, GeneralConstants.minTimeOut);
//        getWebElement(dueDateField).sendKeys(dueDate);
        System.out.println("Scroll down to item field ");
        scrollToSpeceficElement(itemCodeField);
//        Thread.sleep(6000);
        System.out.println(" select item  ");
        clickByActions(itemCodeField);
        waitUntilElementVisibility(itemCodeInputField,GeneralConstants.minTimeOut);
        getWebElement(itemCodeInputField).sendKeys("item");
        waitUntilElementToBeClickable(itemOpt,GeneralConstants.minTimeOut);
        getWebElement(itemOpt).click();
//        System.out.println("unselect update stock opt");
//        getWebElement(updateStockBtn).click();
//        Thread.sleep(6000);
        System.out.println("scroll up to save and submit btn ");
        scrollToSpeceficElement(saveAndSubmitBtn);
        System.out.println("save and submit purchase order ");
        getWebElement(saveAndSubmitBtn).click();
        //Thread.sleep(10000);
        System.out.println("click on yes btn ");
         waitUntilElementToBeClickable(yesBtn, GeneralConstants.minTimeOut);
        getWebElement(yesBtn).click();

    }
    public String getPurchaseOrderStatusBeforeCreatingRelatedPurchaseInvoice() {
//        System.out.println("Verify the status of sales invoice  ");
        waitUntilElementToBePresent(createBtn,GeneralConstants.minTimeOut);
        System.out.println("status of purchase order before creating related purchase invoices " +getWebElement(purchaseOrderStatus).getText());
        return getWebElement(purchaseOrderStatus).getText();

    }
    public PurchaseInvoicesPage createNewPurchaseInvoiceFromSalesOrder() {
        System.out.println("click on create btn");
        waitUntilElementVisibility(createBtn, GeneralConstants.minTimeOut);
       getWebElement(createBtn).click();
        System.out.println("click on purchase invoice");
        waitUntilElementVisibility(purchaseInvoiceChoice, GeneralConstants.minTimeOut);
        getWebElement(purchaseInvoiceChoice).click();
        return new PurchaseInvoicesPage(driver);
    }


    public String getPurchaseOrderStatusAfterCreatingRelatedPurchaseInvoice() throws InterruptedException {


        waitUntilElementToBeClickable(purchaseInvoicesTab, GeneralConstants.minTimeOut);
//        getWebElement(salesInvoicesTab).click();
        System.out.println("click on purchase orders option");
        waitUntilElementToBePresent(purchaseOrdersOpt, GeneralConstants.minTimeOut);
//        Thread.sleep(9000);
        getWebElement(purchaseOrdersOpt).click();
      //  clickByActions(purchaseOrdersOpt);

        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        driver.navigate().refresh();
        System.out.println("open last created purchase order ");
        getWebElement(purchaseOrderNameAtViewList).click();
        waitUntilElementToBePresent(createBtn,GeneralConstants.minTimeOut);
        System.out.println("status of sales order after creating related sales invoices " +getWebElement(purchaseOrderCompletedStatus).getText());
        return getWebElement(purchaseOrderCompletedStatus).getText();

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
