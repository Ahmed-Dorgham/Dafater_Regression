package Pages;

import GeneralConstants.GeneralConstants;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DataMigrationToolPage extends MainPage {
    private String dataMigrationTitle = "data migration";
    // private WebDriver driver ;

    public DataMigrationToolPage(WebDriver driver) {
        this.driver = driver;
    }

    private By checkVmConnectionBtn = By.id("check_vm_connection");
    private By syncDocTypesDataBtn = By.id("sync_doctypes_data");
    private By statusMsg = By.className("msgprint");
    private By editIcon = By.className("icon-xs");
    private By closeIcon = By.xpath("(//*[contains(@class,'btn btn-modal-close btn-link')])");
    private By allCheckBox = By.xpath("//*[contains(@class,'grid-heading-row with-filter')]//*[contains(@type,'checkbox')]");
    private By vmUrlInputField = By.xpath("(//*[contains(@class,'input-with-feedback form-control')])[1]");
    private By apiKeyInputField = By.xpath("(//*[contains(@class,'input-with-feedback form-control')])[1]");
    private By saveBtn = By.xpath("(//*[contains(@data-action_name,'Save')])");
    private By secretKeyInputField = By.xpath("(//*[contains(@class,'input-with-feedback form-control')])[2]");
    By overlay = By.xpath("//*[contains(@class,'freeze-message-container')]");

    public void clickOnCheckVmConnectionBtn() {
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);

        waitUntilElementVisibility(saveBtn, GeneralConstants.minTimeOut);
        getWebElement(saveBtn).click();
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementVisibility(checkVmConnectionBtn, GeneralConstants.minTimeOut);
        getWebElement(checkVmConnectionBtn).click();

        waitUntilElementVisibility(statusMsg, GeneralConstants.minTimeOut);
        //Allure.step(getWebElement(connectionMsg).getText());

    }

    public void clickOnSyncDocTypesDataBtn() {
        Allure.step("click on sync doc types data btn ");
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);

        waitUntilElementVisibility(saveBtn, GeneralConstants.minTimeOut);
        getWebElement(saveBtn).click();
        Allure.step(" choose all doc types");
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementVisibility(allCheckBox, GeneralConstants.minTimeOut);
        getWebElement(allCheckBox).click();
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementVisibility(syncDocTypesDataBtn, GeneralConstants.minTimeOut);
        getWebElement(syncDocTypesDataBtn).click();


    }

    public void selectAllDocTypes() {
        Allure.step(" choose all doc types");
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementVisibility(allCheckBox, GeneralConstants.minTimeOut);
        getWebElement(allCheckBox).click();
    }

    public WebElement checkStatusMsg() {
        waitUntilElementVisibility(statusMsg, GeneralConstants.minTimeOut);
        Allure.step(" msg after clicking on btn is >>>   " + getWebElement(statusMsg).getText());
        Allure.step(getWebElement(statusMsg).getText());
        return getWebElement(statusMsg);
    }

    public void closeStatusMsg() {

        waitUntilElementVisibility(closeIcon, GeneralConstants.minTimeOut);
        Allure.step("close success msg ");
        getWebElement(closeIcon).click();

    }

    public void enterValidDataIntoMainData(String vmUrl, String apiKey, String secretKey) {
        Allure.step(" enter valid data into main data ");
//        waitUntilElementVisibility(vmUrlInputField, GeneralConstants.minTimeOut);
//        getWebElement(vmUrlInputField).clear();
//        getWebElement(vmUrlInputField).sendKeys(vmUrl);
        waitUntilElementVisibility(apiKeyInputField, GeneralConstants.minTimeOut);
        getWebElement(apiKeyInputField).clear();
        getWebElement(apiKeyInputField).sendKeys(apiKey);
        getWebElement(secretKeyInputField).clear();
        getWebElement(secretKeyInputField).sendKeys(secretKey);

    }
}
