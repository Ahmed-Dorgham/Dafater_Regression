package Pages;

import GeneralConstants.GeneralConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PurchaseTaxesAndChargesTemplatesListPage extends MainPage {
    private String dataMigrationTitle = "data migration";
    // private WebDriver driver ;

    public PurchaseTaxesAndChargesTemplatesListPage(WebDriver driver) {
        this.driver = driver;
    }

    private By checkVmConnectionBtn = By.id("check_vm_connection");
    private By syncDocTypesDataBtn = By.id("sync_doctypes_data");
    private By statusMsg = By.className("msgprint");
    private By editIcon = By.className("icon-xs");
    private By salesInvoiceListTitle = By.xpath("(//*[contains(@title,'فاتورة المبيعات')]");
    private By listCount = By.xpath("(//*[contains(@class,'list-count')])");
    private By taxesAndChargesLabel = By.xpath("(//h3[contains(text(),'قالب الضرائب والرسوم على المشتريات')])" +
            "| (//h5[contains(text(),'قائمة تخصيص رسوم وضرائب المشتريات')])");
    private By newBtn = By.xpath("//*[contains(@class,'btn btn-default btn-sm primary-action toolbar-btn')]");
    By overlay = By.xpath("//*[contains(@class,'freeze-message-container')]");
    By numberOfPurchaseTaxesAndChargesTemplates = By.xpath("//*[contains(@class,'list-count')]/span" +
            "| //*[contains(@class,'total-rows')]");
    private By invoiceNameAtViewList = By.xpath("(//a[contains(@data-doctype,'Sales Invoice')])[1]");
    private By invoiceStatusAtListView = By.xpath("(((((//*[contains(@class,'level list-row-head font-weight-bold')])/following-sibling::div)[2])/div/div/div)[3])/span/span");
    private By invoiceTotalAmountValueAtListView = By.xpath("(((((//*[contains(@class,'level list-row-head font-weight-bold')])/following-sibling::div)[2])/div/div/div))[6]/span/a/div/span");
    private By totalAmountOfSalesInvoicesAtViewList = By.xpath("//h3[contains(text(),'اجمالي الفواتير')]/following-sibling::div" +
            "|//*[@class='sales-invoice-lv-total-invoices ']");

    public SalesInvoicesPage clickOnNewSalesInvoiceBtn() {
        System.out.println("click on new sales invoice btn ");
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(taxesAndChargesLabel, GeneralConstants.minTimeOut);
        waitUntilElementToBeClickable(newBtn, GeneralConstants.minTimeOut);

        getWebElement(newBtn).click();

        return new SalesInvoicesPage(driver);
    }

    public String getInvoiceNameAtViewList(String expected) {

        waitUntilElementToBePresent(taxesAndChargesLabel, GeneralConstants.minTimeOut);
        waitUntilElementToBePresent(newBtn, GeneralConstants.minTimeOut);
        System.out.println("actual text is " + getWebElement(invoiceNameAtViewList).getAttribute("title") + " and expected text is " + expected);
        return getWebElement(invoiceNameAtViewList).getText();
    }

    public String getListAccountBeforeCreatingNewSalesInvoices() {

        waitUntilElementToBePresent(taxesAndChargesLabel, GeneralConstants.minTimeOut);
        System.out.println("number of sales invoices at list view before creating new sales invoices " + getWebElement(listCount).getText());
        return getWebElement(listCount).getText();
    }

    public String getListAccountBeforeSyncing() {

        waitUntilElementToBePresent(taxesAndChargesLabel, GeneralConstants.minTimeOut);
        System.out.println("number of sales invoices at list view before syncing " + getWebElement(listCount).getText());
        return getWebElement(listCount).getText();
    }

    public String getNumberOfAllItemsBeforeSyncing() {

        waitUntilElementToBePresent(taxesAndChargesLabel, GeneralConstants.minTimeOut);
        System.out.println("number of draft sales invoices at list view before creating new sales invoices " + getWebElement(numberOfPurchaseTaxesAndChargesTemplates).getText());
        return getWebElement(numberOfPurchaseTaxesAndChargesTemplates).getText();
    }

    public String getNumberOfPurchaseTaxesAndChargesTemplatesBeforeSyncing() throws InterruptedException {

        waitUntilElementToBePresent(taxesAndChargesLabel, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        waitUntilElementToBePresent(numberOfPurchaseTaxesAndChargesTemplates, GeneralConstants.minTimeOut);
        System.out.println("number of draft Sales Taxes And Charges Templates at list view before syncing " + getWebElement(numberOfPurchaseTaxesAndChargesTemplates).getText());
        return getWebElement(numberOfPurchaseTaxesAndChargesTemplates).getText();
    }

    public String getTotalAmountOfSalesInvoicesBeforeSyncing() throws InterruptedException {

        waitUntilElementToBePresent(taxesAndChargesLabel, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        System.out.println("total amount of sales invoices at list view before syncing " + getWebElement(totalAmountOfSalesInvoicesAtViewList).getText());
        return getWebElement(totalAmountOfSalesInvoicesAtViewList).getText();
    }

    public String getTotalAmountOfSalesInvoicesAfterSyncing() throws InterruptedException {

        waitUntilElementToBePresent(taxesAndChargesLabel, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        System.out.println("total amount of sales invoices at list view after syncing " + getWebElement(totalAmountOfSalesInvoicesAtViewList).getText());
        return getWebElement(totalAmountOfSalesInvoicesAtViewList).getText();
    }

    public String getNumberOfDraftInvoicesAfterCreatingNewDraftSalesInvoices() {

        waitUntilElementToBePresent(taxesAndChargesLabel, GeneralConstants.minTimeOut);
        System.out.println("number of draft sales invoices at list view after creating new sales invoices " + getWebElement(numberOfPurchaseTaxesAndChargesTemplates).getText());
        return getWebElement(numberOfPurchaseTaxesAndChargesTemplates).getText();
    }

    public String getNumberOfPurchaseTaxesAndChargesTemplatesAfterSyncing() {

        waitUntilElementToBePresent(taxesAndChargesLabel, GeneralConstants.minTimeOut);
        waitUntilElementToBePresent(numberOfPurchaseTaxesAndChargesTemplates, GeneralConstants.minTimeOut);
        waitUntilElementNotHaveSpecificText(numberOfPurchaseTaxesAndChargesTemplates, "تحديث");

        System.out.println("number of Purchase Taxes And Charges Templates at list view after syncing " + getWebElement(numberOfPurchaseTaxesAndChargesTemplates).getText());
        return getWebElement(numberOfPurchaseTaxesAndChargesTemplates).getText();
    }

    public String getListAccountAfterCreatingNewSalesInvoices() {

        waitUntilElementToBePresent(taxesAndChargesLabel, GeneralConstants.minTimeOut);
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
