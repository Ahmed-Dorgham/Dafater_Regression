package Pages;

import GeneralConstants.GeneralConstants;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JournalEntrytListPage extends MainPage {
    private String dataMigrationTitle = "data migration";
    // private WebDriver driver ;

    public JournalEntrytListPage(WebDriver driver) {
        this.driver = driver;
    }

    private By checkVmConnectionBtn = By.id("check_vm_connection");
    private By syncDocTypesDataBtn = By.id("sync_doctypes_data");
    private By statusMsg = By.className("msgprint");
    private By editIcon = By.className("icon-xs");
    private By salesInvoiceListTitle = By.xpath("(//*[contains(@title,'فاتورة المبيعات')]");

    private By newBtn = By.xpath("//*[contains(@class,'btn btn-default btn-sm primary-action toolbar-btn')]");
    By overlay = By.xpath("//*[contains(@class,'freeze-message-container')]");
    By closeFilter = By.xpath("//*[contains(@class,'btn btn-default btn-xs remove-filter')]");
    private By journalEntryListLabel = By.xpath("//h5[contains(text(),'قائمة قيد يومية')]" +
            "| //h3[contains(text(),'قيد محاسبي')]");
    By numberOfAllJournalEntries = By.xpath("//*[contains(@class,'total-rows')]");

    public PurchaseOrderPage clickOnNewPurchaseOrdersBtn() {
        Allure.step("click on new purchase order btn ");
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBeClickable(newBtn, GeneralConstants.minTimeOut);
        getWebElement(newBtn).click();

//        waitUntilElementVisibility(statusMsg, GeneralConstants.minTimeOut);
        // Allure.step(getWebElement(connectionMsg).getText());
        return new PurchaseOrderPage(driver);
    }

    public PurchaseReceiptPage clickOnNewPurchaseReceiptBtn() {
        Allure.step("click on new purchase receipt btn ");
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBeClickable(newBtn, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        getWebElement(newBtn).click();

//        waitUntilElementVisibility(statusMsg, GeneralConstants.minTimeOut);
        // Allure.step(getWebElement(connectionMsg).getText());
        return new PurchaseReceiptPage(driver);
    }

    public WebElement checkVmConnectionMsg() {

        waitUntilElementVisibility(statusMsg, GeneralConstants.minTimeOut);
        Allure.step(getWebElement(statusMsg).getText());
        return getWebElement(statusMsg);
    }

    public String getNumberOfAllJournalEntriesBeforeSyncing() throws InterruptedException {

        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(journalEntryListLabel, GeneralConstants.minTimeOut);
        if (tryToGetWebElement(closeFilter) == GeneralConstants.SUCCESS) {
            Allure.step("close filter ");
            getWebElement(closeFilter).click();
        }
        waitUntilElementToBePresent(numberOfAllJournalEntries, GeneralConstants.minTimeOut);
        Allure.step("number of all  journal entry list view before Syncing " + getWebElement(numberOfAllJournalEntries).getText());
        return getWebElement(numberOfAllJournalEntries).getText();
    }

    public String getNumberOfAllJournalEntriesAfterSyncing() throws InterruptedException {

        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(journalEntryListLabel, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        waitUntilElementNotHaveSpecificText(numberOfAllJournalEntries, "تحديث");

        Allure.step(" " + getWebElement(numberOfAllJournalEntries).getText());

        if (getWebElement(numberOfAllJournalEntries).getText().contains("من"))
        {
            Allure.step("number of all journal entry at list view after Syncing " + getWebElement(numberOfAllJournalEntries).getText());

            Allure.step("number of all journal entry at list view after Syncing 0 ");
            return "0";
        }
        return getWebElement(numberOfAllJournalEntries).getText();
    }
}
