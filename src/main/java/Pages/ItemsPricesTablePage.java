package Pages;

import GeneralConstants.GeneralConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemsPricesTablePage extends MainPage {
    private String dataMigrationTitle = "data migration";
    // private WebDriver driver ;
    private String homePageLink;

    public ItemsPricesTablePage(WebDriver driver) {
        this.driver = driver;
    }

    private By checkVmConnectionBtn = By.id("check_vm_connection");
    private By updateStockBtn = By.id("update_stock");
    private By statusMsg = By.className("msgprint");
    private By newItemPriceTitle = By.xpath("//h4[contains(@class,'modal-title')]");
    private By viewWithReportsBtn = By.xpath("(//*[contains(@class,'custom-btn-group-label')])[3]");
    private By newBtn = By.xpath("(//*[contains(@class,'btn btn-default btn-sm primary-action toolbar-btn')])[3]");
    private By customerFieldSalesOrder = By.xpath("(//*[contains(@id,'customer')])[4]");
    private By itemCodeField = By.xpath("(//*[contains(@id,'item_code')])[2]");
    private By uomField = By.xpath("(//*[contains(@data-fieldname,'uom')])[4]");
    private By itemPriceField = By.xpath("(//input[contains(@data-fieldname,'price_list_rate')])");
    private By saveBtn = By.xpath("(//button[contains(@class,'btn btn-primary btn-sm btn-modal-primary')])");
    private By totalAmountLabel = By.xpath("(//*[contains(text(),'الكمية الإجمالية')])");
    private By itemCodeInputField = By.xpath("(//*[contains(@id,'item_code')])");
    private By customersListSalesOrder = By.xpath("(//*[contains(@data-target,'Customer')and @placeholder=' ']/following-sibling::ul)");
    private By customerOptSalesOrder = By.xpath("((//*[contains(@data-target,'Customer')and @placeholder=' ']/following-sibling::ul)/li)[1]");
    private By itemOpt = By.xpath("((//*[contains(@data-target,'Item')and @placeholder='رمز الصنف']/following-sibling::ul)/li)[1]");
    private By createBtn = By.xpath("//*[contains(@class,'btn toolbar-btn btn-primary')]");
    private By salesInvoiceChoice = By.xpath("//*[contains(text(),'فاتورة المبيعات') and @class = 'dropdown-item']");
    private By saveAndSubmitBtn = By.xpath("//*[contains(@class,'btn btn-inverse btn-sm save-submit-action toolbar-btn')]");
    private By yesBtn = By.xpath("(//*[contains(@class,'btn btn-primary btn-sm btn-modal-primary')])");
    private By salesOrderStatus = By.xpath("(//*[contains(@class,'indicator-pill no-indicator-dot whitespace-nowrap orange')])");
    private By salesOrderCompletedStatus = By.xpath("(//*[contains(@class,'indicator-pill no-indicator-dot whitespace-nowrap green')])");
    private By salesOrdersOpt = By.xpath("(//*[contains(@id,'sidebar-selling-sales-orders')]/span)[1]");
    private By viewBtn = By.xpath("(//button[contains(text(),'واجهة')])[2]");
    //*[contains(text(),'أوامر البيع')]
    private By salesOrderNameAtViewList = By.xpath("(//a[contains(@data-doctype,'Sales Order')])[1]");
    private By listCount = By.xpath("(//*[contains(@class,'list-count')])");
    private By draftLabel = By.xpath("(//h3[contains(text(),'مسودة')])");
    private By salesInvoicesTab = By.id("module-anchor-Selling");
    By overlay = By.xpath("//*[contains(@class,'freeze-message-container')]");
    By viewCompleteScreen = By.xpath("(//button[@class='btn btn-secondary btn-sm '])[1]");

    public void enterValidDataIntoSalesOrderPage(String dueDate) throws InterruptedException {
//        waitUntilElementToBePresent(newSalesOrderTitle, GeneralConstants.minTimeOut);
        System.out.println("select  customer ");
        getWebElement(customerFieldSalesOrder).click();
        waitUntilElementVisibility(customersListSalesOrder, GeneralConstants.minTimeOut);
        waitUntilElementToBeClickable(customerOptSalesOrder, GeneralConstants.minTimeOut);
        getWebElement(customerOptSalesOrder).click();
//        System.out.println("enter dues date  ");
//        waitUntilElementVisibility(dueDateField, GeneralConstants.minTimeOut);
//        getWebElement(dueDateField).sendKeys(dueDate);
        System.out.println("Scroll down to item field ");
        scrollToSpeceficElement(totalAmountLabel);
        //Thread.sleep(6000);
        System.out.println(" select item  ");
//        clickByJs(getWebElement(itemCodeField));
        getWebElement(itemCodeField).click();
        waitUntilElementToBePresent(itemCodeInputField, GeneralConstants.minTimeOut);
        getWebElement(itemCodeInputField).sendKeys("item");
        waitUntilElementToBePresent(itemOpt, GeneralConstants.minTimeOut);
        getWebElement(itemOpt).click();
//        clickByJs(getWebElement(itemOpt));
//        System.out.println("unselect update stock opt");
//        getWebElement(updateStockBtn).click();
        // Thread.sleep(6000);
        System.out.println("scroll up to save and submit btn ");
        scrollToSpeceficElement(saveAndSubmitBtn);
        System.out.println(" save and submit sales order ");
        getWebElement(saveAndSubmitBtn).click();
        //  Thread.sleep(10000);
        System.out.println("click on yes btn ");
        waitUntilElementToBeClickable(yesBtn, GeneralConstants.minTimeOut);
        getWebElement(yesBtn).click();

    }

    public String getSalesOrderStatusBeforeCreatingRelatedSalesInvoice() {
//        System.out.println("Verify the status of sales invoice  ");
        waitUntilElementToBePresent(createBtn, GeneralConstants.minTimeOut);
        System.out.println("status of sales order before creating related sales invoices " + getWebElement(salesOrderStatus).getText());
        return getWebElement(salesOrderStatus).getText();

    }

    public ItemPricePage openItemPricePage() {
        System.out.println("click on new btn");
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(newBtn, GeneralConstants.minTimeOut);
        getWebElement(newBtn).click();
        waitUntilElementToBePresent(newItemPriceTitle,GeneralConstants.minTimeOut);
        getWebElement(newItemPriceTitle).click();
        System.out.println("click on view complete screen btn ");
        waitUntilElementToBePresent(viewCompleteScreen, GeneralConstants.minTimeOut);

        getWebElement(viewCompleteScreen).click();

        return new ItemPricePage(driver);
    }

    public String getSalesOrderStatusAfterCreatingRelatedSalesInvoice() throws InterruptedException {


        waitUntilElementToBeClickable(salesInvoicesTab, GeneralConstants.minTimeOut);
//        getWebElement(salesInvoicesTab).click();
        System.out.println("click on sales orders option");
        waitUntilElementToBePresent(viewBtn, GeneralConstants.minTimeOut);
//        Thread.sleep(9000);
        getWebElement(salesOrdersOpt).click();
        clickByActions(salesOrdersOpt);

        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        driver.navigate().refresh();
        System.out.println("open last created sales order ");
        getWebElement(salesOrderNameAtViewList).click();
        waitUntilElementToBePresent(createBtn, GeneralConstants.minTimeOut);
        System.out.println("status of sales order after creating related sales invoices " + getWebElement(salesOrderCompletedStatus).getText());
        return getWebElement(salesOrderCompletedStatus).getText();

    }

    public SalesInvoicesPage createNewSalesInvoiceFromSalesOrder() {
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
