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
    By closeFilter = By.xpath("//*[contains(@class,'btn btn-default btn-xs remove-filter')]");
    By firstDeliveryNote = By.xpath("(//*[contains(@class,'result-list')]//*[contains(@class,'doclist-row row')])[1]//a" +
            "|(//*[contains(@class,'result')]//*[contains(@class,'list-row-container')])[1]//*[contains(@class,'list-row-col ellipsis list-subject level ')]//a");
    By searchIcon = By.xpath("//li[@class='fas fa-search']");
    By nameField = By.xpath("//input[@data-fieldname='name']");
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
        waitUntilElementNotHaveSpecificText(numberOfAllDeliveryNotes,"تحديث");

        System.out.println("number of all delivery notes at list view after Syncing " + getWebElement(numberOfAllDeliveryNotes).getText());
        return getWebElement(numberOfAllDeliveryNotes).getText();
    }
    public WebElement checkVmConnectionMsg() {

        waitUntilElementVisibility(statusMsg, GeneralConstants.minTimeOut);
        System.out.println(getWebElement(statusMsg).getText());
        return getWebElement(statusMsg);
    }
    public String getNameOfFirstDeliverNoteBeforeSyncing() throws InterruptedException {

        waitUntilOverlayDisappear(overlay,GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(deliveryNoteListLabel, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        if (tryToGetWebElement(closeFilter) == GeneralConstants.SUCCESS) {
            System.out.println("close filter ");
            getWebElement(closeFilter).click();
        }
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        System.out.println("name of first delivery note  at list view at dafater 4  >> " + getWebElement(firstDeliveryNote).getText());
        return getWebElement(firstDeliveryNote).getText();
    }
    public DeliveryNotePage openFirstDeliveryNoteAtDafater_4() throws InterruptedException {
        waitUntilOverlayDisappear(overlay,GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(deliveryNoteListLabel, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        System.out.println(" open First Delivery Note At Dafater_4 ");
        getWebElement(firstDeliveryNote).click();
        return new DeliveryNotePage(driver);
    }
    public String searchAboutSpecificDeliveryNote(String deliveryNoteName) throws InterruptedException {

        waitUntilOverlayDisappear(overlay,GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(deliveryNoteListLabel, GeneralConstants.minTimeOut);
        System.out.println(" search about " + deliveryNoteName);
        waitUntilElementToBePresent(searchIcon, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        getWebElement(searchIcon).click();
        waitUntilElementToBePresent(nameField, GeneralConstants.minTimeOut);
        getWebElement(nameField).clear();
        getWebElement(nameField).sendKeys(deliveryNoteName);
//        getWebElement(reloadIcon).click();
        Thread.sleep(threadTimeOut);
        if (tryToGetWebElement(firstDeliveryNote) == GeneralConstants.SUCCESS) {
            System.out.println(" open delivery note which appear after searching");
            getWebElement(firstDeliveryNote).click();
            return GeneralConstants.SUCCESS;
        } else {
            System.out.println(" error happen while syncing this delivery note " + deliveryNoteName + " from dafater 4 to dafater 5 and not synced successfully   ");
            return GeneralConstants.FAILED;
        }

    }
}
