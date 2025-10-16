package Pages;

import GeneralConstants.GeneralConstants;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentEntryListPage extends MainPage {
    private String dataMigrationTitle = "data migration";
    // private WebDriver driver ;

    public PaymentEntryListPage(WebDriver driver) {
        this.driver = driver;
    }

    private By checkVmConnectionBtn = By.id("check_vm_connection");
    private By syncDocTypesDataBtn = By.id("sync_doctypes_data");
    private By statusMsg = By.className("msgprint");
    private By editIcon = By.className("icon-xs");
    private By salesInvoiceListTitle = By.xpath("(//*[contains(@title,'فاتورة المبيعات')]");

    private By newBtn = By.xpath("//*[contains(@class,'btn btn-default btn-sm primary-action toolbar-btn')]");
    private By paymentEntryLabel = By.xpath("(//h3[contains(text(),'سندات الدفع')]) | (//h5[contains(text(),'قائمة سند صرف')])");
    private By listCount = By.xpath("(//*[contains(@class,'list-count')])");
    By overlay = By.xpath("//*[contains(@class,'freeze-message-container')]");
    private By invoiceNameAtViewList = By.xpath("(//a[contains(@data-doctype,'Purchase Invoice')])[1]");
    private By totalAmountOfPurchaseInvoicesAtViewList = By.xpath("//h3[contains(text(),'اجمالي الفواتير')]/following-sibling::div" +
            "|//*[@class='sales-invoice-lv-total-invoices '] " +
            "|  //*[@class='purchase-invoice-lv-total-invoices ']");
    By numberOfAllPaymentEntry_4 = By.xpath("//*[contains(@class,'total-rows')]");
    By numberOfAllPaymentEntry_5 = By.xpath("//*[contains(@class,'total-rows')]");
    public SalesInvoicesPage clickOnNewSalesInvoiceBtn() {
       Allure.step("click on new sales invoice btn ");
        waitUntilElementToBeClickable(newBtn, GeneralConstants.minTimeOut);
        getWebElement(newBtn).click();

//        waitUntilElementVisibility(statusMsg, GeneralConstants.minTimeOut);
        //Allure.step(getWebElement(connectionMsg).getText());
        return new SalesInvoicesPage(driver);
    }
    public String getNumberOfAllPaymentEntryBeforeSyncing() throws InterruptedException {

        waitUntilElementToBePresent(paymentEntryLabel, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
       Allure.step("number of all payment entry at list view before syncing " + getWebElement(numberOfAllPaymentEntry_4).getText());
        return getWebElement(numberOfAllPaymentEntry_4).getText();
    }
    public String getNumberOfAllPaymentEntryAfterSyncing() {

        waitUntilElementToBePresent(paymentEntryLabel, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay,GeneralConstants.freezeTimeOut);
        waitUntilElementNotHaveSpecificText(numberOfAllPaymentEntry_5,"تحديث");
        if (getWebElement(numberOfAllPaymentEntry_5).getText().contains("من"))
        {
            Allure.step("number of all payment entry at list view after syncing  " + getWebElement(numberOfAllPaymentEntry_5).getText());

            Allure.step("number of all payment entry at list view after syncing  0 ");
            return "0";
        }

       return getWebElement(numberOfAllPaymentEntry_5).getText();
    }
    public String getTotalAmountOfPurchaseInvoicesAfterSyncing() throws InterruptedException {

        waitUntilElementToBePresent(paymentEntryLabel, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
       Allure.step("total amount of purchase invoices at list view after syncing " + getWebElement(totalAmountOfPurchaseInvoicesAtViewList).getText());
        return getWebElement(totalAmountOfPurchaseInvoicesAtViewList).getText();
    }
    public String getTotalAmountOfPurchaseInvoicesBeforeSyncing() throws InterruptedException {

        waitUntilElementToBePresent(paymentEntryLabel, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
       Allure.step("total amount of purchase invoices at list view before syncing " + getWebElement(totalAmountOfPurchaseInvoicesAtViewList).getText());
        return getWebElement(totalAmountOfPurchaseInvoicesAtViewList).getText();
    }
    public PurchaseInvoicesPage clickOnNewPurchaseInvoiceBtn() {
       Allure.step("click on new purchase invoice btn ");
        waitUntilOverlayDisappear(overlay,GeneralConstants.freezeTimeOut);
        waitUntilElementToBeClickable(newBtn, GeneralConstants.minTimeOut);
        waitUntilElementVisibility(newBtn, GeneralConstants.minTimeOut);
//        getWebElement(newBtn).click();
        clickByActions(newBtn);

//        waitUntilElementVisibility(statusMsg, GeneralConstants.minTimeOut);
        //Allure.step(getWebElement(connectionMsg).getText());
        return new PurchaseInvoicesPage(driver);
    }
    public String getInvoiceNameAtViewList(String expected) {

        waitUntilElementToBePresent(paymentEntryLabel, GeneralConstants.minTimeOut);
       Allure.step("actual text is " + getWebElement(invoiceNameAtViewList).getAttribute("title") + " and expected text is " + expected);
        return getWebElement(invoiceNameAtViewList).getText();
    }
    public WebElement checkVmConnectionMsg() {

        waitUntilElementVisibility(statusMsg, GeneralConstants.minTimeOut);
       Allure.step(getWebElement(statusMsg).getText());
        return getWebElement(statusMsg);
    }
    public String getListAccountAfterCreatingNewSalesInvoices() {

        waitUntilElementToBePresent(paymentEntryLabel, GeneralConstants.minTimeOut);
       Allure.step("number of purchase invoices at list view After creating new purchase invoices " + getWebElement(listCount).getText());
        return getWebElement(listCount).getText();
    }
    public String getListAccountBeforeCreatingNewPurchaseInvoices() {

        waitUntilElementToBePresent(paymentEntryLabel, GeneralConstants.minTimeOut);
       Allure.step("number of sales invoices at list view before creating new sales invoices " + getWebElement(listCount).getText());
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
