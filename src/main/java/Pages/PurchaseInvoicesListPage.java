package Pages;

import GeneralConstants.GeneralConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PurchaseInvoicesListPage extends MainPage {
    private String dataMigrationTitle = "data migration";
    // private WebDriver driver ;

    public PurchaseInvoicesListPage(WebDriver driver) {
        this.driver = driver;
    }

    private By checkVmConnectionBtn = By.id("check_vm_connection");
    private By syncDocTypesDataBtn = By.id("sync_doctypes_data");
    private By statusMsg = By.className("msgprint");
    private By editIcon = By.className("icon-xs");
    private By salesInvoiceListTitle = By.xpath("(//*[contains(@title,'فاتورة المبيعات')]");

    private By newBtn = By.xpath("//*[contains(@class,'btn btn-default btn-sm primary-action toolbar-btn')]");
    private By draftLabel = By.xpath("(//h3[contains(text(),'مسودة')]) | (//div[contains(text(),'مسودة')])");
    private By listCount = By.xpath("(//*[contains(@class,'list-count')])");
    By overlay = By.xpath("//*[contains(@class,'freeze-message-container')]");
    private By invoiceNameAtViewList = By.xpath("(//a[contains(@data-doctype,'Purchase Invoice')])[1]");
    private By totalAmountOfPurchaseInvoicesAtViewList = By.xpath("//h3[contains(text(),'اجمالي الفواتير')]/following-sibling::div" +
            "|//*[@class='sales-invoice-lv-total-invoices '] " +
            "|  //*[@class='purchase-invoice-lv-total-invoices ']");
    By numberOfDraftInvoices = By.xpath("//h3[contains(text(),'مسودة')]/following-sibling::div" +
            "| //*[contains(@class,'general-lv-drafts ')]");
    public SalesInvoicesPage clickOnNewSalesInvoiceBtn() {
        System.out.println("click on new sales invoice btn ");
        waitUntilElementToBeClickable(newBtn, GeneralConstants.minTimeOut);
        getWebElement(newBtn).click();

//        waitUntilElementVisibility(statusMsg, GeneralConstants.minTimeOut);
        // System.out.println(getWebElement(connectionMsg).getText());
        return new SalesInvoicesPage(driver);
    }
    public String getNumberOfDraftInvoicesBeforeSyncing() throws InterruptedException {

        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        System.out.println("number of draft purchase invoices at list view before syncing " + getWebElement(numberOfDraftInvoices).getText());
        return getWebElement(numberOfDraftInvoices).getText();
    }
    public String getNumberOfDraftInvoicesAfterSyncing() {

        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        System.out.println("number of draft sales invoices at list view after syncing " + getWebElement(numberOfDraftInvoices).getText());
        return getWebElement(numberOfDraftInvoices).getText();
    }
    public String getTotalAmountOfPurchaseInvoicesAfterSyncing() throws InterruptedException {

        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        System.out.println("total amount of purchase invoices at list view after syncing " + getWebElement(totalAmountOfPurchaseInvoicesAtViewList).getText());
        return getWebElement(totalAmountOfPurchaseInvoicesAtViewList).getText();
    }
    public String getTotalAmountOfPurchaseInvoicesBeforeSyncing() throws InterruptedException {

        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        System.out.println("total amount of purchase invoices at list view before syncing " + getWebElement(totalAmountOfPurchaseInvoicesAtViewList).getText());
        return getWebElement(totalAmountOfPurchaseInvoicesAtViewList).getText();
    }
    public PurchaseInvoicesPage clickOnNewPurchaseInvoiceBtn() {
        System.out.println("click on new purchase invoice btn ");
        waitUntilOverlayDisappear(overlay,GeneralConstants.freezeTimeOut);
        waitUntilElementToBeClickable(newBtn, GeneralConstants.minTimeOut);
        waitUntilElementVisibility(newBtn, GeneralConstants.minTimeOut);
//        getWebElement(newBtn).click();
        clickByActions(newBtn);

//        waitUntilElementVisibility(statusMsg, GeneralConstants.minTimeOut);
        // System.out.println(getWebElement(connectionMsg).getText());
        return new PurchaseInvoicesPage(driver);
    }
    public String getInvoiceNameAtViewList(String expected) {

        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        System.out.println("actual text is " + getWebElement(invoiceNameAtViewList).getAttribute("title") + " and expected text is " + expected);
        return getWebElement(invoiceNameAtViewList).getText();
    }
    public WebElement checkVmConnectionMsg() {

        waitUntilElementVisibility(statusMsg, GeneralConstants.minTimeOut);
        System.out.println(getWebElement(statusMsg).getText());
        return getWebElement(statusMsg);
    }
    public String getListAccountAfterCreatingNewSalesInvoices() {

        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        System.out.println("number of purchase invoices at list view After creating new purchase invoices " + getWebElement(listCount).getText());
        return getWebElement(listCount).getText();
    }
    public String getListAccountBeforeCreatingNewPurchaseInvoices() {

        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        System.out.println("number of sales invoices at list view before creating new sales invoices " + getWebElement(listCount).getText());
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
