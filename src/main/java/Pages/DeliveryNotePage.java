package Pages;

import GeneralConstants.GeneralConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeliveryNotePage extends MainPage {
    private String dataMigrationTitle = "data migration";
    // private WebDriver driver ;
    private String homePageLink;

    public DeliveryNotePage(WebDriver driver) {
        this.driver = driver;
    }

    private By checkVmConnectionBtn = By.id("check_vm_connection");
    private By updateStockBtn = By.id("update_stock");
    private By statusMsg = By.className("msgprint");
    private By editIcon = By.className("icon-xs");
    private By newDeliveryNoteTitle = By.xpath("//*[contains(@title,'سند تسليم جديد')]");
    private By customerFieldDeliveyNote = By.xpath("(//*[contains(@id,'customer')])[4]");
    private By itemCodeField = By.xpath("(//*[contains(@data-fieldname,'item_code')])[2]");
    private By itemsLabel = By.xpath("(//*[contains(text(),'الاصناف')])[2]");
    private By totalAmountLabel = By.xpath("(//*[contains(text(),'الكمية الإجمالية')])");
    private By itemCodeInputField = By.xpath("(//*[contains(@id,'item_code')])");
    private By customersListSalesOrder = By.xpath("(//*[contains(@data-target,'Customer')and @placeholder=' ']/following-sibling::ul)");
    private By customerOptDeliveryNote = By.xpath("((//*[contains(@data-target,'Customer')and @placeholder=' ']/following-sibling::ul)/li)[1]" +
            "| ((//*[contains(@data-target,'Customer')and @placeholder=' ']/following-sibling::ul)/div/p/strong)[1]");
    private By itemOpt = By.xpath("((//*[contains(@data-target,'Item')and @placeholder='رمز الصنف']/following-sibling::ul)/li)[1]" +
            "| ((//*[contains(@data-target,'Item')and @placeholder='رمز الصنف']/following-sibling::ul)/div/p/strong)[1]");
    private By createBtn = By.xpath("//*[contains(@class,'btn toolbar-btn btn-primary')]");
    private By salesInvoiceChoice = By.xpath("//*[contains(text(),'فاتورة المبيعات') and @class = 'dropdown-item']");
    private By saveAndSubmitBtn = By.xpath("//*[contains(@class,'btn btn-inverse btn-sm save-submit-action toolbar-btn')]");
    private By yesBtn = By.xpath("(//*[contains(@class,'btn btn-primary btn-sm btn-modal-primary')])");
    private By deliveryNoteStatus = By.xpath("(//*[contains(@class,'indicator-pill no-indicator-dot whitespace-nowrap orange')])[1]");
    private By deliveryNoteCompletedStatus = By.xpath("(//*[contains(@class,'indicator-pill no-indicator-dot whitespace-nowrap green')])");
    private By salesOrdersOpt = By.xpath("(//*[contains(@id,'sidebar-selling-sales-orders')]/span)[1]");
    private By deliveyNoteOpt = By.xpath("(//*[contains(@id,'sidebar-stock-delivery-note')]/span)[1]");
    private By viewBtn = By.xpath("(//button[contains(text(),'واجهة')])[2]");
    //*[contains(text(),'أوامر البيع')]
    private By deliveryNoteNameAtViewList = By.xpath("(//a[contains(@data-doctype,'Delivery Note')])[1]");
    private By listCount = By.xpath("(//*[contains(@class,'list-count')])");
    private By draftLabel = By.xpath("(//h3[contains(text(),'مسودة')])");
    private By salesInvoicesTab = By.id("module-anchor-Selling");
    By overlay = By.xpath("//*[contains(@class,'freeze-message-container')]");
    private By wareHouseTab = By.id("module-anchor-Stock");
    private By newBtn = By.xpath("(//button[contains(@class,'btn btn-default btn-sm primary-action toolbar-btn')])");
    private  By selectedItem = By.xpath("((//*[contains(@data-target,'Item')and @placeholder='رمز الصنف']/following-sibling::ul)/div/p[@title='item 1']/strong)");

    public void enterValidDataIntoDeliveryNotePage() throws InterruptedException {
        waitUntilElementToBePresent(newDeliveryNoteTitle, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        System.out.println("select  customer ");
        getWebElement(customerFieldDeliveyNote).click();
        waitUntilElementVisibility(customersListSalesOrder, GeneralConstants.minTimeOut);
        waitUntilElementToBeClickable(customerOptDeliveryNote, GeneralConstants.minTimeOut);
        getWebElement(customerOptDeliveryNote).click();
//        System.out.println("enter dues date  ");
//        waitUntilElementVisibility(dueDateField, GeneralConstants.minTimeOut);
//        getWebElement(dueDateField).sendKeys(dueDate);
        System.out.println("Scroll down to item field ");
        scrollToSpeceficElement(totalAmountLabel);
        //Thread.sleep(6000);
        System.out.println(" select item  ");
        clickByActions(itemCodeField);
        waitUntilElementToBePresent(itemCodeInputField, GeneralConstants.minTimeOut);
        getWebElement(itemCodeInputField).sendKeys("item 1");
        waitUntilElementToBeClickable(itemOpt, GeneralConstants.minTimeOut);
        getWebElement(itemCodeInputField).sendKeys("item 1");
        getWebElement(itemCodeInputField).sendKeys("item 1");
        waitUntilElementToBeClickable(selectedItem, GeneralConstants.minTimeOut);
        clickByActions(selectedItem);
//        clickByJs(getWebElement(itemOpt));
//        System.out.println("unselect update stock opt");
//        getWebElement(updateStockBtn).click();
        // Thread.sleep(6000);
        System.out.println("scroll up to save and submit btn ");
        scrollToSpeceficElement(saveAndSubmitBtn);
        System.out.println(" save and submit delivery note ");
        getWebElement(saveAndSubmitBtn).click();
        //  Thread.sleep(10000);
        System.out.println("click on yes btn ");
        waitUntilElementToBeClickable(yesBtn, GeneralConstants.minTimeOut);
        getWebElement(yesBtn).click();

    }

    public String getSalesOrderStatusBeforeCreatingRelatedSalesInvoice() {
//        System.out.println("Verify the status of sales invoice  ");
        waitUntilOverlayDisappear(overlay,GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(createBtn, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay,GeneralConstants.freezeTimeOut);
        System.out.println("status of delivery note before creating related sales invoices " + getWebElement(deliveryNoteStatus).getText());
        return getWebElement(deliveryNoteStatus).getText();

    }

    public String getDeliveryNoteStatusAfterCreatingRelatedSalesInvoice() throws InterruptedException {

        waitUntilElementToBePresent(viewBtn, GeneralConstants.minTimeOut);
        System.out.println("click on warehouse tab");
        waitUntilElementToBeClickable(wareHouseTab, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        getWebElement(wareHouseTab).click();
//        getWebElement(salesInvoicesTab).click();
        System.out.println("click on delivery note option");

//        Thread.sleep(9000);
        waitUntilElementToBePresent(deliveyNoteOpt, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay,GeneralConstants.freezeTimeOut);
        getWebElement(deliveyNoteOpt).click();
        clickByActions(deliveyNoteOpt);

        waitUntilElementToBePresent(newBtn, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        driver.navigate().refresh();
        System.out.println("open last created delivery note");
        waitUntilElementToBePresent(newBtn, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        getWebElement(deliveryNoteNameAtViewList).click();
        waitUntilElementToBePresent(createBtn, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay,GeneralConstants.freezeTimeOut);
        System.out.println("status of delivery note after creating related sales invoices " + getWebElement(deliveryNoteCompletedStatus).getText());
        return getWebElement(deliveryNoteCompletedStatus).getText();

    }

    public SalesInvoicesPage createNewSalesInvoiceFromDeliveryNote() {
        System.out.println("click on create btn");
        waitUntilElementToBePresent(createBtn, GeneralConstants.minTimeOut);
        getWebElement(createBtn).click();
        System.out.println("click on sales invoice");
        waitUntilElementVisibility(salesInvoiceChoice, GeneralConstants.minTimeOut);
        getWebElement(salesInvoiceChoice).click();
        return new SalesInvoicesPage(driver);
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
