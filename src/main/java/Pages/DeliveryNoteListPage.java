package Pages;

import GeneralConstants.GeneralConstants;
import io.qameta.allure.Allure;
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

    By numberOfAllDeliveryNotes_4 = By.xpath("//*[contains(@class,'total-rows')]");
    By numberOfAllDeliveryNotes_5 = By.xpath("//*[contains(@class,'total-rows')]");
    By closeFilter = By.xpath("//*[contains(@class,'btn btn-default btn-xs remove-filter')]");
    By firstDeliveryNote = By.xpath("(//*[contains(@class,'result-list')]//*[contains(@class,'doclist-row row')])[1]//a" +
            "|(//*[contains(@class,'result')]//*[contains(@class,'list-row-container')])[1]//*[contains(@class,'list-row-col ellipsis list-subject level ')]//a");
    By searchIcon = By.xpath("//li[@class='fas fa-search']");
    By nameField = By.xpath("//input[@data-fieldname='name']");
    public DeliveryNotePage clickOnNewDeliveryNoteBtn() {
      Allure.step("click on new delivery note btn ");
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
      Allure.step("number of all delivery notes at list view before Syncing " + getWebElement(numberOfAllDeliveryNotes_4).getText());
        return getWebElement(numberOfAllDeliveryNotes_4).getText();
    }
    public String getNumberOfAllDeliveryNotesAfterSyncing() throws InterruptedException {

        waitUntilOverlayDisappear(overlay,GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(deliveryNoteListLabel, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        waitUntilElementNotHaveSpecificText(numberOfAllDeliveryNotes_5,"تحديث");
        if (getWebElement(numberOfAllDeliveryNotes_5).getText().contains("من"))
        {
            Allure.step("number of all Delivery Notes at list view after syncing  " + getWebElement(numberOfAllDeliveryNotes_5).getText());

            Allure.step("number of all Delivery Notes at list view after syncing  0 ");
            return "0";
        }
      Allure.step("number of all delivery notes at list view after Syncing " + getWebElement(numberOfAllDeliveryNotes_5).getText());





        return getWebElement(numberOfAllDeliveryNotes_5).getText();
    }
    public WebElement checkVmConnectionMsg() {

        waitUntilElementVisibility(statusMsg, GeneralConstants.minTimeOut);
      Allure.step(getWebElement(statusMsg).getText());
        return getWebElement(statusMsg);
    }
    public String getNameOfFirstDeliverNoteBeforeSyncing() throws InterruptedException {

        waitUntilOverlayDisappear(overlay,GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(deliveryNoteListLabel, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        if (tryToGetWebElement(closeFilter) == GeneralConstants.SUCCESS) {
          Allure.step("close filter ");
            getWebElement(closeFilter).click();
        }
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
      Allure.step("name of first delivery note  at list view at dafater 4  >> " + getWebElement(firstDeliveryNote).getText());
        return getWebElement(firstDeliveryNote).getText();
    }
    public DeliveryNotePage openFirstDeliveryNoteAtDafater_4() throws InterruptedException {
        waitUntilOverlayDisappear(overlay,GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(deliveryNoteListLabel, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
      Allure.step(" open First Delivery Note At Dafater_4 ");
        getWebElement(firstDeliveryNote).click();
        return new DeliveryNotePage(driver);
    }
    public String searchAboutSpecificDeliveryNote(String deliveryNoteName) throws InterruptedException {

        waitUntilOverlayDisappear(overlay,GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(deliveryNoteListLabel, GeneralConstants.minTimeOut);
      Allure.step(" search about " + deliveryNoteName);
        waitUntilElementToBePresent(searchIcon, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        getWebElement(searchIcon).click();
        waitUntilElementToBePresent(nameField, GeneralConstants.minTimeOut);
        getWebElement(nameField).clear();
        getWebElement(nameField).sendKeys(deliveryNoteName);
//        getWebElement(reloadIcon).click();
        Thread.sleep(threadTimeOut);
        if (tryToGetWebElement(firstDeliveryNote) == GeneralConstants.SUCCESS) {
          Allure.step(" open delivery note which appear after searching");
            getWebElement(firstDeliveryNote).click();
            return GeneralConstants.SUCCESS;
        } else {
          Allure.step(" error happen while syncing this delivery note " + deliveryNoteName + " from dafater 4 to dafater 5 and not synced successfully   ");
            return GeneralConstants.FAILED;
        }

    }
}
