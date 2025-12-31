package Pages;

import GeneralConstants.GeneralConstants;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    By assetsAccount = By.xpath("//*[contains(text(),'الاصول')]/parent::*/following-sibling::*//span[@style='font-size: var(--input-text-size);']" +
            "|//*[contains(text(),'الاصول')]/parent::*/following-sibling::*//span");
    By obligationsAccount = By.xpath("//*[contains(text(),'الالتزامات')]/parent::*/following-sibling::*//span[@style='font-size: var(--input-text-size);']" +
            "|//*[contains(text(),'الالتزامات')]/parent::*/following-sibling::*//span" +
            "|//*[contains(text(),'حقوق الملكية')]/parent::*/following-sibling::*//span[@style='font-size: var(--input-text-size);']" +
            "|//*[contains(text(),'حقوق الملكية')]/parent::*/following-sibling::*//span");
    By revenuesAccount = By.xpath("//*[contains(text(),'الايرادات')]/parent::*/following-sibling::*//span");
    public By fiscalYearErrorMsg = By.xpath("//*[contains(text(),'ليس في أي سنة مالية')]");

    By revenuesAccount_4 = By.xpath("//*[contains(text(),'الايرادات')]/parent::*/following-sibling::*//span[@style='font-size: var(--input-text-size);']");
    By toolsTab = By.xpath("//*[contains(@id,'sidebar-accounts-tools')]");
    By periodClosingVoucherOpt = By.xpath("//*[contains(@id,'sidebar-accounts-period-closing-voucher')]");

    By expensesAccount = By.xpath("//*[contains(text(),'المصروفات')]/parent::*/following-sibling::*//span" +
            "|//*[contains(text(),'المصروفات')]/parent::*/following-sibling::*//span[@style='font-size: var(--input-text-size);']" +
            "|//*[contains(text(),'المصاريف')]/parent::*/following-sibling::*//span[@style='font-size: var(--input-text-size);']" +
            "|//*[contains(text(),'المصاريف')]/parent::*/following-sibling::*//span");



    public PeriodClosingVoucherListPage openPeriodClosingVoucherListPage()
    {
        System.out.println("open period closing voucher page");
        waitUntilElementVisibility(toolsTab,GeneralConstants.minTimeOut);
        getWebElement(toolsTab).click();
        waitUntilElementVisibility(periodClosingVoucherOpt,GeneralConstants.minTimeOut);
        getWebElement(periodClosingVoucherOpt).click();
        return new PeriodClosingVoucherListPage(driver);
    }
    public String extractDate() {

        String fiscalYearMsg = getWebElement(fiscalYearErrorMsg).getText();
        System.out.println(fiscalYearMsg);

        Pattern pattern = Pattern.compile("\\d{1,2}-\\d{1,2}-\\d{4}");
        Matcher matcher = pattern.matcher(fiscalYearMsg);

        if (matcher.find()) {
            System.out.println("date which exist at fiscal year error msg is " + matcher.group());
            return matcher.group();
        } else {
            throw new RuntimeException("No date found in fiscal year error message");
        }
    }

    public String extractYear() {

        String fiscalYearMsg = getWebElement(fiscalYearErrorMsg).getText();

        Pattern pattern = Pattern.compile("\\d{1,2}-\\d{1,2}-\\d{4}");
        Matcher matcher = pattern.matcher(fiscalYearMsg);

        if (matcher.find()) {
            String dateStr = matcher.group();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-yyyy");
            LocalDate date = LocalDate.parse(dateStr, formatter);
            System.out.println("year which should added to Dafater 5  " + String.valueOf(date.getYear() + 1));

            return String.valueOf(date.getYear() + 1);
        } else {
            throw new RuntimeException("No date found in fiscal year error message");
        }
    }

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
        waitUntilElementVisibility(revenuesAccount_4, GeneralConstants.minTimeOut);
        System.out.println("value at Revenues account before Syncing " + getWebElement(revenuesAccount_4).getAttribute("textContent"));
        Allure.step("value at Revenues account before Syncing " + getWebElement(revenuesAccount_4).getAttribute("textContent"));
        return getWebElement(revenuesAccount_4).getAttribute("textContent");
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

        System.out.println("number of all journal entry at list view after Syncing " + getWebElement(assetsAccount).getAttribute("textContent").replaceAll("[^0-9 ]", "").trim().split(" ")[getWebElement(assetsAccount).getAttribute("textContent").replaceAll("[^0-9 ]", "").trim().split(" ").length - 1]);
        Allure.step("number of all journal entry at list view after Syncing " + getWebElement(assetsAccount).getAttribute("textContent").replaceAll("[^0-9 ]", "").trim().split(" ")[getWebElement(assetsAccount).getAttribute("textContent").replaceAll("[^0-9 ]", "").trim().split(" ").length - 1]);


        return getWebElement(assetsAccount).getAttribute("textContent").replaceAll("[^0-9 ]", "").trim().split(" ")[getWebElement(assetsAccount).getAttribute("textContent").replaceAll("[^0-9 ]", "").trim().split(" ").length - 1];
    }
}
