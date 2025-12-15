package Pages;

import GeneralConstants.GeneralConstants;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SalesTaxesAndChargesTemplatesListPage extends MainPage {
    private String dataMigrationTitle = "data migration";
    // private WebDriver driver ;

    public SalesTaxesAndChargesTemplatesListPage(WebDriver driver) {
        this.driver = driver;
    }

    private By checkVmConnectionBtn = By.id("check_vm_connection");
    private By syncDocTypesDataBtn = By.id("sync_doctypes_data");
    private By statusMsg = By.className("msgprint");
    private By editIcon = By.className("icon-xs");
    private By salesInvoiceListTitle = By.xpath("(//*[contains(@title,'فاتورة المبيعات')]");
    private By listCount = By.xpath("(//*[contains(@class,'list-count')])");
    private By taxesAndChargesLabel = By.xpath("(//h3[contains(text(),'قالب الضرائب والرسوم على المبيعات')])" +
            "| (//h5[contains(text(),'قائمة تخصيص رسوم وضرائب المبيعات')])");
    private By newBtn = By.xpath("//*[contains(@class,'btn btn-default btn-sm primary-action toolbar-btn')]");
    By overlay = By.xpath("//*[contains(@class,'freeze-message-container')]");
    By numberOfSalesTaxesAndChargesTemplates = By.xpath("//*[contains(@class,'list-count')]/span" +
            "| //*[contains(@class,'total-rows')]");
    private By invoiceNameAtViewList = By.xpath("(//a[contains(@data-doctype,'Sales Invoice')])[1]");
    private By invoiceStatusAtListView = By.xpath("(((((//*[contains(@class,'level list-row-head font-weight-bold')])/following-sibling::div)[2])/div/div/div)[3])/span/span");
    private By invoiceTotalAmountValueAtListView = By.xpath("(((((//*[contains(@class,'level list-row-head font-weight-bold')])/following-sibling::div)[2])/div/div/div))[6]/span/a/div/span");
    private By totalAmountOfSalesInvoicesAtViewList = By.xpath("//h3[contains(text(),'اجمالي الفواتير')]/following-sibling::div" +
            "|//*[@class='sales-invoice-lv-total-invoices ']");

    public SalesInvoicesPage clickOnNewSalesInvoiceBtn() {
        Allure.step("click on new sales invoice btn ");
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(taxesAndChargesLabel, GeneralConstants.minTimeOut);
        waitUntilElementToBeClickable(newBtn, GeneralConstants.minTimeOut);

        getWebElement(newBtn).click();

        return new SalesInvoicesPage(driver);
    }

    public String getInvoiceNameAtViewList(String expected) {

        waitUntilElementToBePresent(taxesAndChargesLabel, GeneralConstants.minTimeOut);
        waitUntilElementToBePresent(newBtn, GeneralConstants.minTimeOut);
        Allure.step("actual text is " + getWebElement(invoiceNameAtViewList).getAttribute("title") + " and expected text is " + expected);
        return getWebElement(invoiceNameAtViewList).getText();
    }

    public String getListAccountBeforeCreatingNewSalesInvoices() {

        waitUntilElementToBePresent(taxesAndChargesLabel, GeneralConstants.minTimeOut);
        Allure.step("number of sales invoices at list view before creating new sales invoices " + getWebElement(listCount).getText());
        return getWebElement(listCount).getText();
    }

    public String getListAccountBeforeSyncing() {

        waitUntilElementToBePresent(taxesAndChargesLabel, GeneralConstants.minTimeOut);
        Allure.step("number of sales invoices at list view before syncing " + getWebElement(listCount).getText());
        return getWebElement(listCount).getText();
    }

    public String getNumberOfAllItemsBeforeSyncing() {

        waitUntilElementToBePresent(taxesAndChargesLabel, GeneralConstants.minTimeOut);
        Allure.step("number of draft sales invoices at list view before creating new sales invoices " + getWebElement(numberOfSalesTaxesAndChargesTemplates).getText());
        return getWebElement(numberOfSalesTaxesAndChargesTemplates).getText();
    }

    public String getNumberOfSalesTaxesAndChargesTemplatesBeforeSyncing() throws InterruptedException {

        waitUntilElementToBePresent(taxesAndChargesLabel, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        waitUntilElementToBePresent(numberOfSalesTaxesAndChargesTemplates, GeneralConstants.minTimeOut);
        Allure.step("number of draft Sales Taxes And Charges Templates at list view before syncing " + getWebElement(numberOfSalesTaxesAndChargesTemplates).getText());
        return getWebElement(numberOfSalesTaxesAndChargesTemplates).getText();
    }

    public String getTotalAmountOfSalesInvoicesBeforeSyncing() throws InterruptedException {

        waitUntilElementToBePresent(taxesAndChargesLabel, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        Allure.step("total amount of sales invoices at list view before syncing " + getWebElement(totalAmountOfSalesInvoicesAtViewList).getText());
        return getWebElement(totalAmountOfSalesInvoicesAtViewList).getText();
    }

    public String getTotalAmountOfSalesInvoicesAfterSyncing() throws InterruptedException {

        waitUntilElementToBePresent(taxesAndChargesLabel, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        Allure.step("total amount of sales invoices at list view after syncing " + getWebElement(totalAmountOfSalesInvoicesAtViewList).getText());
        return getWebElement(totalAmountOfSalesInvoicesAtViewList).getText();
    }

    public String getNumberOfDraftInvoicesAfterCreatingNewDraftSalesInvoices() {

        waitUntilElementToBePresent(taxesAndChargesLabel, GeneralConstants.minTimeOut);
        Allure.step("number of draft sales invoices at list view after creating new sales invoices " + getWebElement(numberOfSalesTaxesAndChargesTemplates).getText());
        return getWebElement(numberOfSalesTaxesAndChargesTemplates).getText();
    }

    public String getNumberOfSalesTaxesAndChargesTemplatesAfterSyncing() throws InterruptedException {

        waitUntilElementToBePresent(taxesAndChargesLabel, GeneralConstants.minTimeOut);
        waitUntilElementToBePresent(numberOfSalesTaxesAndChargesTemplates, GeneralConstants.minTimeOut);
        waitUntilElementNotHaveSpecificText(numberOfSalesTaxesAndChargesTemplates, "تحديث");

        Allure.step("number of draft sales invoices at list view after syncing " + getWebElement(numberOfSalesTaxesAndChargesTemplates).getText());
        return getWebElement(numberOfSalesTaxesAndChargesTemplates).getText();
    }

    public String getListAccountAfterCreatingNewSalesInvoices() {

        waitUntilElementToBePresent(taxesAndChargesLabel, GeneralConstants.minTimeOut);
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
