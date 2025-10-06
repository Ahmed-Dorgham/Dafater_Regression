package Pages;

import GeneralConstants.GeneralConstants;
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
    By numberOfAllPurchaseReceipts = By.xpath("//*[contains(@class,'total-rows')] " +
            "|//*[contains(@class,'list-count')]/span");
    public PurchaseOrderPage clickOnNewPurchaseOrdersBtn() {
        System.out.println("click on new purchase order btn ");
        waitUntilOverlayDisappear(overlay,GeneralConstants.freezeTimeOut);
        waitUntilElementToBeClickable(newBtn, GeneralConstants.minTimeOut);
        getWebElement(newBtn).click();

//        waitUntilElementVisibility(statusMsg, GeneralConstants.minTimeOut);
        // System.out.println(getWebElement(connectionMsg).getText());
        return new PurchaseOrderPage(driver);
    }
    public PurchaseReceiptPage clickOnNewPurchaseReceiptBtn() {
        System.out.println("click on new purchase receipt btn ");
        waitUntilOverlayDisappear(overlay,GeneralConstants.freezeTimeOut);
        waitUntilElementToBeClickable(newBtn, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay,GeneralConstants.freezeTimeOut);
        getWebElement(newBtn).click();

//        waitUntilElementVisibility(statusMsg, GeneralConstants.minTimeOut);
        // System.out.println(getWebElement(connectionMsg).getText());
        return new PurchaseReceiptPage(driver);
    }
    public WebElement checkVmConnectionMsg() {

        waitUntilElementVisibility(statusMsg, GeneralConstants.minTimeOut);
        System.out.println(getWebElement(statusMsg).getText());
        return getWebElement(statusMsg);
    }
    public String getNumberOfAllPurchaseReceiptsBeforeSyncing() throws InterruptedException {

        waitUntilOverlayDisappear(overlay,GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(purchaseReceiptListLabel, GeneralConstants.minTimeOut);
        //   Thread.sleep(threadTimeOut);
        System.out.println("number of all  purchase receiptat list view before Syncing " + getWebElement(numberOfAllPurchaseReceipts).getText());
        return getWebElement(numberOfAllPurchaseReceipts).getText();
    }
    public String getNumberOfAllPurchaseReceiptsAfterSyncing() throws InterruptedException {

        waitUntilOverlayDisappear(overlay,GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(purchaseReceiptListLabel, GeneralConstants.minTimeOut);
           Thread.sleep(threadTimeOut);
        waitUntilElementNotHaveSpecificText(numberOfAllPurchaseReceipts,"تحديث");

        System.out.println("number of all purchase receipt at list view after Syncing " + getWebElement(numberOfAllPurchaseReceipts).getText());
        return getWebElement(numberOfAllPurchaseReceipts).getText();
    }
}
