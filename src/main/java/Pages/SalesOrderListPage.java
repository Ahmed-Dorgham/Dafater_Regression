package Pages;

import GeneralConstants.GeneralConstants;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SalesOrderListPage extends MainPage {
    private String dataMigrationTitle = "data migration";
    // private WebDriver driver ;

    public SalesOrderListPage(WebDriver driver) {
        this.driver = driver;
    }

    private By checkVmConnectionBtn = By.id("check_vm_connection");
    private By syncDocTypesDataBtn = By.id("sync_doctypes_data");
    private By statusMsg = By.className("msgprint");
    private By editIcon = By.className("icon-xs");
    private By salesInvoiceListTitle = By.xpath("(//*[contains(@title,'فاتورة المبيعات')]");
    private By draftLabel = By.xpath("(//h3[contains(text(),'مسودة')])");
    private By newBtn = By.xpath("(//button[contains(@class,'btn btn-default btn-sm primary-action toolbar-btn')])");
    By overlay = By.xpath("//*[contains(@class,'freeze-message-container')]");

    private By salesOrderLabel = By.xpath("(//h3[contains(text(),'أمر بيع')])" +
            "| (//h5[contains(text(),'قائمة أمر بيع')])");

    By numberOfAllSalesOrdersField = By.xpath("//*[contains(@class,'total-rows')] " +
            "|//*[contains(@class,'list-count')]/span");
    public String getNumberOfAllSalesOrdersBeforeSyncing() throws InterruptedException {
        waitUntilElementToBePresent(salesOrderLabel, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);

        Thread.sleep(threadTimeOut);
        System.out.println("number of all Sales Orders at list view before Syncing " + getWebElement(numberOfAllSalesOrdersField).getText());
        Allure.step("number of all Sales Orders at list view before Syncing " + getWebElement(numberOfAllSalesOrdersField).getText());
        return getWebElement(numberOfAllSalesOrdersField).getText();
    }

    public String getNumberOfAllSalesOrdersAfterSyncing() throws InterruptedException {

        waitUntilElementToBePresent(salesOrderLabel, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementNotHaveSpecificText(numberOfAllSalesOrdersField, "تحديث");
        System.out.println("number of Sales Orders at list view after Syncing " +getWebElement(numberOfAllSalesOrdersField).getAttribute("textContent"));
        Allure.step("number of Sales Orders at list view after Syncing " + getWebElement(numberOfAllSalesOrdersField).getAttribute("textContent"));
        return getWebElement(numberOfAllSalesOrdersField).getAttribute("textContent");

    }

    public SalesOrderPage clickOnNewSalesOrdersBtn() {
       Allure.step("click on new sales order btn ");
        waitUntilOverlayDisappear(overlay,GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(newBtn, GeneralConstants.minTimeOut);
        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        getWebElement(newBtn).click();
//        clickByJs(getWebElement(newBtn));
//        clickByActions(newBtn);

//        waitUntilElementVisibility(statusMsg, GeneralConstants.minTimeOut);
        //Allure.step(getWebElement(connectionMsg).getText());
        return new SalesOrderPage(driver);
    }

    public WebElement checkVmConnectionMsg() {

        waitUntilElementVisibility(statusMsg, GeneralConstants.minTimeOut);
       Allure.step(getWebElement(statusMsg).getText());
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
