package Pages;

import GeneralConstants.GeneralConstants;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PeriodClosingVoucherListPage extends MainPage {
    private String dataMigrationTitle = "data migration";
    // private WebDriver driver ;

    public PeriodClosingVoucherListPage(WebDriver driver) {
        this.driver = driver;
    }

    private By checkVmConnectionBtn = By.id("check_vm_connection");
    private By syncDocTypesDataBtn = By.id("sync_doctypes_data");
    private By statusMsg = By.className("msgprint");
    private By editIcon = By.className("icon-xs");
    private By salesInvoiceListTitle = By.xpath("(//*[contains(@title,'فاتورة المبيعات')]");
    private By fiscalYearListLabel = By.xpath("//h5[contains(text(),'قائمة السنة المالية')] " +
            "| //h3[contains(text(),'السنة المالية')]");
    private By newBtn = By.xpath("(//button[contains(@class,'btn btn-default btn-sm primary-action toolbar-btn')])");
    By overlay = By.xpath("//*[contains(@class,'freeze-message-container')]");
    By numberOfAllDeliveryNotes = By.xpath("//div[contains(@id,'page-List/Delivery Note/List')]//span[contains(@class,'list-count')]");
    By numberOfAllFiscalYearsField = By.xpath("//*[contains(@class,'total-rows')] " +
            "|//*[contains(@class,'list-count')]/span");
    By addFiscalYear = By.xpath("//*[contains(text(),'إضافة السنة المالية')]");
    By saveBtn = By.xpath("//*[contains(@data-action_name,'Save')]");
    By yearNameInputField = By.xpath("//input[@id='year']");
    By startDateInputField = By.xpath("//input[@id='year_start_date']");
    By addPeriodClosingVoucher = By.xpath("//*[contains(text(),'إضافة قيد إغلاق الفترة')]");
    public By periodClosingVoucherListCount = By.xpath("(//span[@class='list-count'])[2]");

    public int getPeriodClosingVoucherListCount() throws InterruptedException {
        if (tryToGetWebElementV(periodClosingVoucherListCount) == GeneralConstants.SUCCESS) {
            waitUntilElementVisibility(periodClosingVoucherListCount, GeneralConstants.minTimeOut);
            Thread.sleep(threadTimeOut);
            System.out.println(Integer.parseInt(getWebElement(periodClosingVoucherListCount).getText()));
            return Integer.parseInt(getWebElement(periodClosingVoucherListCount).getText());
        } else
            return 0;
    }

    public PeriodClosingVoucherPage openPeriodClosingVoucherPage() throws InterruptedException {
        waitUntilElementVisibility(addPeriodClosingVoucher, GeneralConstants.minTimeOut);
        getWebElement(addPeriodClosingVoucher).click();
        return new PeriodClosingVoucherPage(driver);

    }

    public DeliveryNotePage clickOnNewDeliveryNoteBtn() {
        Allure.step("click on new delivery note btn ");
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(newBtn, GeneralConstants.minTimeOut);
//        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        getWebElement(newBtn).click();
//        clickByJs(getWebElement(newBtn));
//        clickByActions(newBtn);

//        waitUntilElementVisibility(statusMsg, GeneralConstants.minTimeOut);
        //Allure.step(getWebElement(connectionMsg).getText());
        return new DeliveryNotePage(driver);
    }

    public String getNumberOfAllFiscalYearsBeforeSyncing() throws InterruptedException {

        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(fiscalYearListLabel, GeneralConstants.minTimeOut);
        //   Thread.sleep(threadTimeOut);
        Allure.step("number of all fiscal years at list view before syncing " + getWebElement(numberOfAllFiscalYearsField).getText());
        return getWebElement(numberOfAllFiscalYearsField).getText();
    }

    public String getNumberOfAllFiscalYearsAfterSyncing() throws InterruptedException {

        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(fiscalYearListLabel, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
//        waitUntilElementNotContainText(numberOfAllFiscalYearsField,"تحديث");
        Thread.sleep(threadTimeOut);
        //   Thread.sleep(threadTimeOut);
        Allure.step("number of all fiscal years at list view after syncing " + getWebElement(numberOfAllFiscalYearsField).getText());
        return getWebElement(numberOfAllFiscalYearsField).getText();
    }

    public String getNumberOfAllDeliveryNotesAfterSyncing() throws InterruptedException {

        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(newBtn, GeneralConstants.minTimeOut);
        //   Thread.sleep(threadTimeOut);
        Allure.step("number of all delivery notes at list view after Syncing " + getWebElement(numberOfAllDeliveryNotes).getText());
        return getWebElement(numberOfAllDeliveryNotes).getText();
    }

    public WebElement checkVmConnectionMsg() {

        waitUntilElementVisibility(statusMsg, GeneralConstants.minTimeOut);
        Allure.step(getWebElement(statusMsg).getText());
        return getWebElement(statusMsg);
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
