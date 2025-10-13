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
    private By purchaseListLabel = By.xpath("(//h5[contains(text(),'قائمة فاتورة شراء')])");
    private By listCount = By.xpath("(//*[contains(@class,'list-count')])");
    By overlay = By.xpath("//*[contains(@class,'freeze-message-container')]");
    private By invoiceNameAtViewList = By.xpath("(//a[contains(@data-doctype,'Purchase Invoice')])[1]");
    private By totalAmountOfPurchaseInvoicesAtViewList = By.xpath("//h3[contains(text(),'اجمالي الفواتير')]/following-sibling::div" +
            "|//*[@class='sales-invoice-lv-total-invoices '] " +
            "|  //*[@class='purchase-invoice-lv-total-invoices ']");
    By numberOfDraftInvoices = By.xpath("//h3[contains(text(),'مسودة')]/following-sibling::div" +
            "| //*[contains(@class,'general-lv-drafts ')]");
    By closeFilter = By.xpath("//*[contains(@class,'btn btn-default btn-xs remove-filter')]");
    By emptyList = By.xpath("//*[contains(@class,'empty-invoice__title')]");
    By firstPurchaseInvoice = By.xpath("(//*[contains(@class,'result-list')]//*[contains(@class,'doclist-row row')])[1]//a" +
            "|(//*[contains(@class,'result')]//*[contains(@class,'list-row-container')])[1]//*[contains(@class,'list-row-col ellipsis list-subject level ')]//a");
    By searchIcon = By.xpath("//li[@class='fas fa-search']");
    By nameField = By.xpath("//input[@data-fieldname='name']");

    public SalesInvoicesPage clickOnNewSalesInvoiceBtn() {
        System.out.println("click on new sales invoice btn ");
        waitUntilElementToBeClickable(newBtn, GeneralConstants.minTimeOut);
        getWebElement(newBtn).click();

//        waitUntilElementVisibility(statusMsg, GeneralConstants.minTimeOut);
        // System.out.println(getWebElement(connectionMsg).getText());
        return new SalesInvoicesPage(driver);
    }

    public String getNameOfFirstPurchaseInvoiceBeforeSyncing() throws InterruptedException {

        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        Thread.sleep(threadTimeOut);
        if (tryToGetWebElement(closeFilter) == GeneralConstants.SUCCESS) {
            System.out.println("close filter ");
            getWebElement(closeFilter).click();
        }
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        System.out.println("name of first purchase invoice at list view at dafater 4  >> " + getWebElement(firstPurchaseInvoice).getText());
        return getWebElement(firstPurchaseInvoice).getText();
    }

    public PurchaseInvoicesPage openFirstPurchaseInvoiceAtDafater_4() throws InterruptedException {

        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        System.out.println(" open Firstpurchase Invoice At Dafater_4 ");
        getWebElement(firstPurchaseInvoice).click();
        return new PurchaseInvoicesPage(driver);
    }


    public String searchAboutSpecificPurchaseInvoice(String invoiceName) throws InterruptedException {

        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        System.out.println(" search about " + invoiceName);
        waitUntilElementToBePresent(searchIcon, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        getWebElement(searchIcon).click();
        waitUntilElementToBePresent(nameField, GeneralConstants.minTimeOut);
        getWebElement(nameField).sendKeys(invoiceName);
//        getWebElement(reloadIcon).click();
        Thread.sleep(threadTimeOut);
        if (tryToGetWebElement(firstPurchaseInvoice) == GeneralConstants.SUCCESS) {
            System.out.println(" open purchase invoice which appear after searching");
            getWebElement(firstPurchaseInvoice).click();
            return GeneralConstants.SUCCESS;
        } else {
            System.out.println(" error happen while syncing this Purchase invoice " + invoiceName + " from dafater 4 to dafater 5 and not synced successfully   ");
            return GeneralConstants.FAILED;
        }

    }

    public PurchaseInvoicesPage openPurchaseInvoiceAtDafater_5() throws InterruptedException {

        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        System.out.println(" open same purchase Invoice At Dafater_5  ");
        getWebElement(firstPurchaseInvoice).click();
        return new PurchaseInvoicesPage(driver);
    }




















    public String getNumberOfDraftInvoicesBeforeSyncing() throws InterruptedException {

        waitUntilElementToBePresent(purchaseListLabel, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        if (tryToGetWebElement(emptyList) == GeneralConstants.SUCCESS) {
            System.out.println("msg which appear at view list"+getWebElement(emptyList).getText());
            System.out.println("there is no purchase invoice at purchase view list and comparing data of specific purchase invoice not applicable");
           return GeneralConstants.FAILED;
        }
        if (tryToGetWebElement(closeFilter) == GeneralConstants.SUCCESS) {
            System.out.println("close filter ");
            getWebElement(closeFilter).click();
        }
        waitUntilElementToBePresent(numberOfDraftInvoices, GeneralConstants.minTimeOut);
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
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
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
    public String getListAccountBeforeSyncing() {

        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        System.out.println("number of sales invoices at list view before Syncing " + getWebElement(listCount).getText());
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
