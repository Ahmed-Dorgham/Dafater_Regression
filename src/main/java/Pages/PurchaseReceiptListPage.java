package Pages;

import GeneralConstants.GeneralConstants;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PurchaseReceiptListPage extends MainPage {
    private String dataMigrationTitle = "data migration";
    // private WebDriver driver ;

    public PurchaseReceiptListPage(WebDriver driver) {
        this.driver = driver;
    }

    private By checkVmConnectionBtn = By.id("check_vm_connection");
    private By syncDocTypesDataBtn = By.id("sync_doctypes_data");
    private By statusMsg = By.className("msgprint");
    private By editIcon = By.className("icon-xs");
    private By salesInvoiceListTitle = By.xpath("(//*[contains(@title,'فاتورة المبيعات')]");

    private By newBtn = By.xpath("//*[contains(@class,'btn btn-default btn-sm primary-action toolbar-btn')]");
    By overlay = By.xpath("//*[contains(@class,'freeze-message-container')]");
    private By purchaseReceiptListLabel = By.xpath("//h5[contains(text(),'قائمة سند إستلام')]" +
            "| //h3[contains(text(),'سند إستلام')]");
    By numberOfAllPurchaseReceipts_4 = By.xpath("//*[contains(@class,'total-rows')");
    By numberOfAllPurchaseReceipts_5 = By.xpath("//*[contains(@class,'total-rows') ");
    public PurchaseOrderPage clickOnNewPurchaseOrdersBtn() {
       Allure.step("click on new purchase order btn ");
        waitUntilOverlayDisappear(overlay,GeneralConstants.freezeTimeOut);
        waitUntilElementToBeClickable(newBtn, GeneralConstants.minTimeOut);
        getWebElement(newBtn).click();

//        waitUntilElementVisibility(statusMsg, GeneralConstants.minTimeOut);
        //Allure.step(getWebElement(connectionMsg).getText());
        return new PurchaseOrderPage(driver);
    }
    public PurchaseReceiptPage clickOnNewPurchaseReceiptBtn() {
       Allure.step("click on new purchase receipt btn ");
        waitUntilOverlayDisappear(overlay,GeneralConstants.freezeTimeOut);
        waitUntilElementToBeClickable(newBtn, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay,GeneralConstants.freezeTimeOut);
        getWebElement(newBtn).click();

//        waitUntilElementVisibility(statusMsg, GeneralConstants.minTimeOut);
        //Allure.step(getWebElement(connectionMsg).getText());
        return new PurchaseReceiptPage(driver);
    }
    public WebElement checkVmConnectionMsg() {

        waitUntilElementVisibility(statusMsg, GeneralConstants.minTimeOut);
       Allure.step(getWebElement(statusMsg).getText());
        return getWebElement(statusMsg);
    }
    public String getNumberOfAllPurchaseReceiptsBeforeSyncing() throws InterruptedException {

        waitUntilOverlayDisappear(overlay,GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(purchaseReceiptListLabel, GeneralConstants.minTimeOut);
        //   Thread.sleep(threadTimeOut);
       Allure.step("number of all  purchase receiptat list view before Syncing " + getWebElement(numberOfAllPurchaseReceipts_4).getText());
        return getWebElement(numberOfAllPurchaseReceipts_4).getText();
    }
    public String getNumberOfAllPurchaseReceiptsAfterSyncing() throws InterruptedException {

        waitUntilOverlayDisappear(overlay,GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(purchaseReceiptListLabel, GeneralConstants.minTimeOut);
           Thread.sleep(threadTimeOut);
        waitUntilElementNotHaveSpecificText(numberOfAllPurchaseReceipts_5,"تحديث");

       Allure.step("number of all purchase receipt at list view after Syncing " + getWebElement(numberOfAllPurchaseReceipts_5).getText());

        if (getWebElement(numberOfAllPurchaseReceipts_5).getText().contains("من"))
        {
            Allure.step("number of all purchase receipt at list view after Syncing " + getWebElement(numberOfAllPurchaseReceipts_5).getText());

            Allure.step("number of all purchase receipt at list view after Syncing 0 ");
            return "0";
        }
       return getWebElement(numberOfAllPurchaseReceipts_5).getText();
    }
}
