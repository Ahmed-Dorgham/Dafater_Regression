package Pages;

import GeneralConstants.GeneralConstants;
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
    private By salesInvoiceListTitle = By.xpath("(//*[contains(@title,'فاتورة المبيعات')]");
    private By listCount = By.xpath("(//*[contains(@class,'list-count')])");
    private By draftLabel = By.xpath("(//h3[contains(text(),'مسودة')])");
    private By newBtn = By.xpath("//*[contains(@class,'btn btn-default btn-sm primary-action toolbar-btn')]");
    By overlay = By.xpath("//*[contains(@class,'freeze-message-container')]");
    By numberOfDraftInvoices = By.xpath("//h3[contains(text(),'مسودة')]/following-sibling::div");
    private By invoiceNameAtViewList = By.xpath("(//a[contains(@data-doctype,'Sales Invoice')])[1]");
    private By invoiceStatusAtListView = By.xpath("(((((//*[contains(@class,'level list-row-head font-weight-bold')])/following-sibling::div)[2])/div/div/div)[3])/span/span");
    private By invoiceTotalAmountValueAtListView = By.xpath("(((((//*[contains(@class,'level list-row-head font-weight-bold')])/following-sibling::div)[2])/div/div/div))[6]/span/a/div/span");
    private By totalInvoicesAmountAtViewList = By.xpath("//h3[contains(text(),'اجمالي الفواتير')]/following-sibling::div");
    public SalesInvoicesPage clickOnNewSalesInvoiceBtn() {
        System.out.println("click on new sales invoice btn ");
        waitUntilOverlayDisappear(overlay,GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        waitUntilElementToBeClickable(newBtn, GeneralConstants.minTimeOut);

        getWebElement(newBtn).click();

        return new SalesInvoicesPage(driver);
    }
    public String getInvoiceNameAtViewList(String expected) {

        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        waitUntilElementToBePresent(newBtn, GeneralConstants.minTimeOut);
        System.out.println("actual text is " + getWebElement(invoiceNameAtViewList).getAttribute("title") + " and expected text is " + expected);
        return getWebElement(invoiceNameAtViewList).getText();
    }
    public String getListAccountBeforeCreatingNewSalesInvoices() {

        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        System.out.println("number of sales invoices at list view before creating new sales invoices " + getWebElement(listCount).getText());
        return getWebElement(listCount).getText();
    }
    public String getNumberOfDraftInvoicesBeforeCreatingNewSalesInvoices() {

        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        System.out.println("number of draft sales invoices at list view before creating new sales invoices " + getWebElement(numberOfDraftInvoices).getText());
        return getWebElement(numberOfDraftInvoices).getText();
    }
    public String getNumberOfDraftInvoicesAfterCreatingNewDraftSalesInvoices() {

        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        System.out.println("number of draft sales invoices at list view after creating new sales invoices " + getWebElement(numberOfDraftInvoices).getText());
        return getWebElement(numberOfDraftInvoices).getText();
    }
    public String getListAccountAfterCreatingNewSalesInvoices() {

        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
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
