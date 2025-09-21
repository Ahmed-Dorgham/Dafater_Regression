package Pages;

import GeneralConstants.GeneralConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeliveryNoteListPage extends MainPage {
    private String dataMigrationTitle = "data migration";
    // private WebDriver driver ;

    public DeliveryNoteListPage(WebDriver driver) {
        this.driver = driver;
    }

    private By checkVmConnectionBtn = By.id("check_vm_connection");
    private By syncDocTypesDataBtn = By.id("sync_doctypes_data");
    private By statusMsg = By.className("msgprint");
    private By editIcon = By.className("icon-xs");
    private By salesInvoiceListTitle = By.xpath("(//*[contains(@title,'فاتورة المبيعات')]");
    private By deliveryNoteListLabel = By.xpath("//h5[contains(text(),'قائمة سند تسليم')]" +
            "| //h3[contains(text(),'سند تسليم')]");
    private By newBtn = By.xpath("(//button[contains(@class,'btn btn-default btn-sm primary-action toolbar-btn')])");
    By overlay = By.xpath("//*[contains(@class,'freeze-message-container')]");

    By numberOfAllDeliveryNotes = By.xpath("//*[contains(@class,'total-rows')] " +
            "|//*[contains(@class,'list-count')]/span");

    public DeliveryNotePage clickOnNewDeliveryNoteBtn() {
        System.out.println("click on new delivery note btn ");
        waitUntilOverlayDisappear(overlay,GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(newBtn, GeneralConstants.minTimeOut);
//        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        getWebElement(newBtn).click();
//        clickByJs(getWebElement(newBtn));
//        clickByActions(newBtn);

//        waitUntilElementVisibility(statusMsg, GeneralConstants.minTimeOut);
        // System.out.println(getWebElement(connectionMsg).getText());
        return new DeliveryNotePage(driver);
    }

    public String getNumberOfAllDeliveryNotesBeforeSyncing() throws InterruptedException {

        waitUntilOverlayDisappear(overlay,GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(deliveryNoteListLabel, GeneralConstants.minTimeOut);
        //   Thread.sleep(threadTimeOut);
        System.out.println("number of all delivery notes at list view before Syncing " + getWebElement(numberOfAllDeliveryNotes).getText());
        return getWebElement(numberOfAllDeliveryNotes).getText();
    }
    public String getNumberOfAllDeliveryNotesAfterSyncing() throws InterruptedException {

        waitUntilOverlayDisappear(overlay,GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(deliveryNoteListLabel, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        waitUntilElementNotContainText(numberOfAllDeliveryNotes,"تحديث");

        System.out.println("number of all delivery notes at list view after Syncing " + getWebElement(numberOfAllDeliveryNotes).getText());
        return getWebElement(numberOfAllDeliveryNotes).getText();
    }
    public WebElement checkVmConnectionMsg() {

        waitUntilElementVisibility(statusMsg, GeneralConstants.minTimeOut);
        System.out.println(getWebElement(statusMsg).getText());
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
