package Pages;

import GeneralConstants.GeneralConstants;
import io.qameta.allure.Allure;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SalesInvoicesListPage extends MainPage {
    private String dataMigrationTitle = "data migration";
    // private WebDriver driver ;

    public SalesInvoicesListPage(WebDriver driver) {
        this.driver = driver;
    }

    private By checkVmConnectionBtn = By.id("check_vm_connection");
    private By syncDocTypesDataBtn = By.id("sync_doctypes_data");
    private By statusMsg = By.className("msgprint");
    private By editIcon = By.className("icon-xs");
    private By salesInvoiceLabel = By.xpath("(//*[contains(@title,'فاتورة المبيعات')]");
    private By listCount = By.xpath("(//*[contains(@class,'list-count')])");
    private By draftLabel = By.xpath("(//h3[contains(text(),'مسودة')])" +
            "| (//div[contains(text(),'مسودة')])");
    private By newBtn = By.xpath("//*[contains(@class,'btn btn-default btn-sm primary-action toolbar-btn')]");
    By overlay = By.xpath("//*[contains(@class,'freeze-message-container')]");
    By searchIcon = By.xpath("//li[@class='fas fa-search']");
    By reloadIcon = By.xpath("//*[@data-original-title='Reload List']");
    By nameField = By.xpath("//input[@data-fieldname='name']");

    By numberOfDraftInvoices = By.xpath("//h3[contains(text(),'مسودة')]/following-sibling::div" +
            "| //*[contains(@class,'general-lv-drafts ')]");
    By firstSalesInvoice = By.xpath("(//*[contains(@class,'result-list')]//*[contains(@class,'doclist-row row')])[1]//a" +
            "|(//*[contains(@class,'result')]//*[contains(@class,'list-row-container')])[1]//*[contains(@class,'list-row-col ellipsis list-subject level ')]//a");
    private By invoiceNameAtViewList = By.xpath("(//a[contains(@data-doctype,'Sales Invoice')])[1]");
    private By invoiceStatusAtListView = By.xpath("(((((//*[contains(@class,'level list-row-head font-weight-bold')])/following-sibling::div)[2])/div/div/div)[3])/span/span");
    private By invoiceTotalAmountValueAtListView = By.xpath("(((((//*[contains(@class,'level list-row-head font-weight-bold')])/following-sibling::div)[2])/div/div/div))[6]/span/a/div/span");
    private By totalAmountOfSalesInvoicesAtViewList = By.xpath("//h3[contains(text(),'اجمالي الفواتير')]/following-sibling::div" +
            "|//*[@class='sales-invoice-lv-total-invoices ']");
    By closeFilter = By.xpath("//*[contains(@class,'btn btn-default btn-xs remove-filter')]");

    public SalesInvoicesPage clickOnNewSalesInvoiceBtn() {
        Allure.step("click on new sales invoice btn ");
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        waitUntilElementToBeClickable(newBtn, GeneralConstants.minTimeOut);

        getWebElement(newBtn).click();

        return new SalesInvoicesPage(driver);
    }

    public String getInvoiceNameAtViewList(String expected) {

        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        waitUntilElementToBePresent(newBtn, GeneralConstants.minTimeOut);
        Allure.step("actual text is " + getWebElement(invoiceNameAtViewList).getAttribute("title") + " and expected text is " + expected);
        return getWebElement(invoiceNameAtViewList).getText();
    }

    public String getListAccountBeforeCreatingNewSalesInvoices() {

        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        Allure.step("number of sales invoices at list view before creating new sales invoices " + getWebElement(listCount).getText());
        return getWebElement(listCount).getText();
    }

    public String getListAccountBeforeSyncing() {

        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        Allure.step("number of sales invoices at list view before syncing " + getWebElement(listCount).getText());
        return getWebElement(listCount).getText();
    }

    public String getNumberOfAllItemsBeforeSyncing() {

        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        Allure.step("number of draft sales invoices at list view before creating new sales invoices " + getWebElement(numberOfDraftInvoices).getText());
        return getWebElement(numberOfDraftInvoices).getText();
    }

    public String getNumberOfDraftInvoicesBeforeSyncing() throws InterruptedException {

        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        Allure.step("number of draft sales invoices at list view before syncing " + getWebElement(numberOfDraftInvoices).getText());
        return getWebElement(numberOfDraftInvoices).getText();
    }

    public String getNameOfFirstSalesInvoiceBeforeSyncing() throws InterruptedException {

        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        Thread.sleep(threadTimeOut);
        if (tryToGetWebElement(closeFilter) == GeneralConstants.SUCCESS) {
            Allure.step("close filter ");
            getWebElement(closeFilter).click();
        }
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        Allure.step("name of first sales invoice at list view at dafater 4  >> " + getWebElement(firstSalesInvoice).getText());
        return getWebElement(firstSalesInvoice).getText();
    }

    public SalesInvoicesPage openFirstSalesInvoiceAtDafater_4() throws InterruptedException {

        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        Allure.step(" open First Sales Invoice At Dafater_4 ");
        getWebElement(firstSalesInvoice).click();
        return new SalesInvoicesPage(driver);
    }

    public SalesInvoicesPage openSalesInvoiceAtDafater_5() throws InterruptedException {

        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        Allure.step(" open same Sales Invoice At Dafater_5  ");
        getWebElement(firstSalesInvoice).click();
        return new SalesInvoicesPage(driver);
    }

    public String getTotalAmountOfSalesInvoicesBeforeSyncing() throws InterruptedException {

        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        Allure.step("total amount of sales invoices at list view before syncing " + getWebElement(totalAmountOfSalesInvoicesAtViewList).getText());
        return getWebElement(totalAmountOfSalesInvoicesAtViewList).getText();
    }

    public String getTotalAmountOfSalesInvoicesAfterSyncing() throws InterruptedException {

        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        Allure.step("total amount of sales invoices at list view after syncing " + getWebElement(totalAmountOfSalesInvoicesAtViewList).getText());
        return getWebElement(totalAmountOfSalesInvoicesAtViewList).getText();
    }

    public String getNumberOfDraftInvoicesAfterCreatingNewDraftSalesInvoices() {

        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        Allure.step("number of draft sales invoices at list view after creating new sales invoices " + getWebElement(numberOfDraftInvoices).getText());
        return getWebElement(numberOfDraftInvoices).getText();
    }

    public String getNumberOfDraftInvoicesAfterSyncing() {

        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        Allure.step("number of draft sales invoices at list view after syncing " + getWebElement(numberOfDraftInvoices).getText());
        return getWebElement(numberOfDraftInvoices).getText();
    }

    public String searchAboutSpecificSalesInvoice(String invoiceName) throws InterruptedException {

        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        Allure.step(" search about " + invoiceName);
        waitUntilElementToBePresent(searchIcon, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        getWebElement(searchIcon).click();
        waitUntilElementToBePresent(nameField, GeneralConstants.minTimeOut);
        getWebElement(nameField).sendKeys(invoiceName);
//        getWebElement(reloadIcon).click();
        Thread.sleep(threadTimeOut);
        if (tryToGetWebElement(firstSalesInvoice) == GeneralConstants.SUCCESS) {
            Allure.step(" open sales invoice which appear after searching");
            getWebElement(firstSalesInvoice).click();
            return GeneralConstants.SUCCESS;
        } else {
            Allure.step(" error happen while syncing this sales invoice " + invoiceName + " from dafater 4 to dafater 5 and not synced successfully   ");
            return GeneralConstants.FAILED;
        }

    }

    public String getListAccountAfterCreatingNewSalesInvoices() {

        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
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
