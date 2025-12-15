package Pages;

import GeneralConstants.GeneralConstants;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChartOfAccountsPage extends MainPage {
    private String dataMigrationTitle = "data migration";
    // private WebDriver driver ;

    public ChartOfAccountsPage(WebDriver driver) {
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
    private By accountIndicatorLabel = By.xpath("//h5[contains(text(),'دليل حساب')]" +
            "| //h3[contains(text(),'دليل الحسابات')]");
    By assetsAccount = By.xpath("//*[contains(text(),'الاصول')]/parent::*/following-sibling::*//span");
    By obligationsAccount = By.xpath("//*[contains(text(),'الالتزامات')]/parent::*/following-sibling::*//span");
    By revenuesAccount = By.xpath("//*[contains(text(),'الايرادات')]/parent::*/following-sibling::*//span");
    By expensesAccount = By.xpath("//*[contains(text(),'المصروفات')]/parent::*/following-sibling::*//span");


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

    public String getValueOfAssetsAccountBeforeSyncing() throws InterruptedException {

        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(accountIndicatorLabel, GeneralConstants.minTimeOut);
        waitUntilElementVisibility(assetsAccount, GeneralConstants.minTimeOut);
        System.out.println("value at assets account before Syncing " + getWebElement(assetsAccount).getAttribute("textContent"));
        Allure.step("value at assets account before Syncing " + getWebElement(assetsAccount).getAttribute("textContent"));
        return getWebElement(assetsAccount).getAttribute("textContent");
    }
    public String getValueOfAssetsAccountAfterSyncing() throws InterruptedException {

        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(accountIndicatorLabel, GeneralConstants.minTimeOut);
        waitUntilElementVisibility(assetsAccount, GeneralConstants.minTimeOut);
        System.out.println("value at assets account after Syncing " + getWebElement(assetsAccount).getAttribute("textContent"));
        Allure.step("value at assets account after Syncing " + getWebElement(assetsAccount).getAttribute("textContent"));
        return getWebElement(assetsAccount).getAttribute("textContent");
    }
    public String getValueOfObligationsAccountBeforeSyncing() throws InterruptedException {

        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(accountIndicatorLabel, GeneralConstants.minTimeOut);
        waitUntilElementVisibility(obligationsAccount, GeneralConstants.minTimeOut);
        System.out.println("value at Obligations account before Syncing " + getWebElement(obligationsAccount).getAttribute("textContent"));
        Allure.step("value at Obligations account before Syncing " + getWebElement(obligationsAccount).getAttribute("textContent"));
        return getWebElement(obligationsAccount).getAttribute("textContent");
    }
    public String getValueOfObligationsAccountAfterSyncing() throws InterruptedException {

        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(accountIndicatorLabel, GeneralConstants.minTimeOut);
        waitUntilElementVisibility(obligationsAccount, GeneralConstants.minTimeOut);
        System.out.println("value at Obligations account after Syncing " + getWebElement(obligationsAccount).getAttribute("textContent"));
        Allure.step("value at Obligations account after Syncing " + getWebElement(obligationsAccount).getAttribute("textContent"));
        return getWebElement(obligationsAccount).getAttribute("textContent");
    }
    public String getValueOfRevenuesAccountBeforeSyncing() throws InterruptedException {
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(accountIndicatorLabel, GeneralConstants.minTimeOut);
        waitUntilElementVisibility(revenuesAccount, GeneralConstants.minTimeOut);
        System.out.println("value at Revenues account before Syncing " + getWebElement(revenuesAccount).getAttribute("textContent"));
        Allure.step("value at Revenues account before Syncing " + getWebElement(revenuesAccount).getAttribute("textContent"));
        return getWebElement(revenuesAccount).getAttribute("textContent");
    }
    public String getValueOfRevenuesAccountAfterSyncing() throws InterruptedException {
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(accountIndicatorLabel, GeneralConstants.minTimeOut);
        waitUntilElementVisibility(revenuesAccount, GeneralConstants.minTimeOut);
        System.out.println("value at Revenues account after Syncing " + getWebElement(revenuesAccount).getAttribute("textContent"));
        Allure.step("value at Revenues account after Syncing " + getWebElement(revenuesAccount).getAttribute("textContent"));
        return getWebElement(revenuesAccount).getAttribute("textContent");
    }
    public String getValueOfExpensesAccountBeforeSyncing() throws InterruptedException {
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(accountIndicatorLabel, GeneralConstants.minTimeOut);
        waitUntilElementVisibility(expensesAccount, GeneralConstants.minTimeOut);
        System.out.println("value at Expenses account before Syncing " + getWebElement(expensesAccount).getAttribute("textContent"));
        Allure.step("value at Expenses account before Syncing " + getWebElement(expensesAccount).getAttribute("textContent"));
        return getWebElement(expensesAccount).getAttribute("textContent");
    }
    public String getValueOfExpensesAccountAfterSyncing() throws InterruptedException {
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(accountIndicatorLabel, GeneralConstants.minTimeOut);
        waitUntilElementVisibility(expensesAccount, GeneralConstants.minTimeOut);
        System.out.println("value at Expenses account after Syncing " + getWebElement(expensesAccount).getAttribute("textContent"));
        Allure.step("value at Expenses account after Syncing " + getWebElement(expensesAccount).getAttribute("textContent"));
        return getWebElement(expensesAccount).getAttribute("textContent");
    }

    public String getNumberOfAllJournalEntriesAfterSyncing() throws InterruptedException {

        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(accountIndicatorLabel, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        waitUntilElementNotHaveSpecificText(assetsAccount, "تحديث");

        System.out.println("number of all journal entry at list view after Syncing " +getWebElement(assetsAccount).getAttribute("textContent").replaceAll("[^0-9 ]", "").trim() .split(" ")[getWebElement(assetsAccount).getAttribute("textContent").replaceAll("[^0-9 ]", "").trim() .split(" ").length - 1]);
        Allure.step("number of all journal entry at list view after Syncing " + getWebElement(assetsAccount).getAttribute("textContent").replaceAll("[^0-9 ]", "").trim() .split(" ")[getWebElement(assetsAccount).getAttribute("textContent").replaceAll("[^0-9 ]", "").trim() .split(" ").length - 1]);


        return getWebElement(assetsAccount).getAttribute("textContent").replaceAll("[^0-9 ]", "").trim() .split(" ")[getWebElement(assetsAccount).getAttribute("textContent").replaceAll("[^0-9 ]", "").trim() .split(" ").length - 1];
    }
}
