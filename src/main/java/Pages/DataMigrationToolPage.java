package Pages;

import GeneralConstants.GeneralConstants;
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
    private By vmUrlInputField = By.xpath("(//*[contains(@class,'input-with-feedback form-control')])[1]");
    private By apiKeyInputField = By.xpath("(//*[contains(@class,'input-with-feedback form-control')])[2]");
    private By secretKeyInputField = By.xpath("(//*[contains(@class,'input-with-feedback form-control')])[3]");
    By overlay = By.xpath("//*[contains(@class,'freeze-message-container')]");
    public void clickOnCheckVmConnectionBtn() {
        waitUntilOverlayDisappear(overlay,GeneralConstants.freezeTimeOut);
        waitUntilElementVisibility(checkVmConnectionBtn, GeneralConstants.minTimeOut);
        getWebElement(checkVmConnectionBtn).click();

        waitUntilElementVisibility(statusMsg, GeneralConstants.minTimeOut);
        // System.out.println(getWebElement(connectionMsg).getText());

    }

    public WebElement checkVmConnectionMsg() {

        waitUntilElementVisibility(statusMsg, GeneralConstants.minTimeOut);
        System.out.println(getWebElement(statusMsg).getText());
        return getWebElement(statusMsg);
    }
    public void enterValidDataIntoMainData (String vmUrl , String apiKey , String secretKey)
    {
        waitUntilElementVisibility(vmUrlInputField,GeneralConstants.minTimeOut);
        getWebElement(vmUrlInputField).clear();
        getWebElement(vmUrlInputField).sendKeys(vmUrl);
        getWebElement(apiKeyInputField).clear();
        getWebElement(apiKeyInputField).sendKeys(apiKey);
        getWebElement(secretKeyInputField).clear();
        getWebElement(secretKeyInputField).sendKeys(secretKey);
    }
}
