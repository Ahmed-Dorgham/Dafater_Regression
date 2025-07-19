package Pages;

import GeneralConstants.GeneralConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SalesOrderPage extends MainPage {
    private String dataMigrationTitle = "data migration";
    // private WebDriver driver ;

    public SalesOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    private By checkVmConnectionBtn = By.id("check_vm_connection");
    private By updateStockBtn = By.id("update_stock");
    private By statusMsg = By.className("msgprint");
    private By editIcon = By.className("icon-xs");
    private By newSalesOrderTitle = By.xpath("//*[contains(@title,'أمر بيع جديد')]");
    private By customerFieldSalesOrder = By.xpath("(//*[contains(@id,'customer')])[4]");
    private By itemCodeField = By.xpath("(//*[contains(@data-fieldname,'item_code')])[2]");
    private By itemsLabel = By.xpath("(//*[contains(text(),'الاصناف')])[2]");
    private By totalAmountLabel = By.xpath("(//*[contains(text(),'الكمية الإجمالية')])");
    private By itemCodeInputField = By.xpath("(//*[contains(@id,'item_code')])");
    private By customersListSalesOrder = By.xpath("(//*[contains(@data-target,'Customer')and @placeholder=' ']/following-sibling::ul)");
    private By customerOptSalesOrder = By.xpath("((//*[contains(@data-target,'Customer')and @placeholder=' ']/following-sibling::ul)/li)[1]");
    private By itemOpt = By.xpath("((//*[contains(@data-target,'Item')and @placeholder='رمز الصنف']/following-sibling::ul)/li)[1]");
    private By createBtn = By.xpath("//*[contains(@class,'btn toolbar-btn btn-primary')]");
    private By salesInvoiceChoice = By.xpath("//*[contains(text(),'فاتورة المبيعات') and @class = 'dropdown-item']");
    private By saveAndSubmitBtn = By.xpath("//*[contains(@class,'btn btn-inverse btn-sm save-submit-action toolbar-btn')]");
    private By yesBtn = By.xpath("(//*[contains(@class,'btn btn-primary btn-sm btn-modal-primary')])");

    public void enterValidDataIntoSalesOrderPage(String dueDate) throws InterruptedException {
        waitUntilElementToBePresent(newSalesOrderTitle, GeneralConstants.minTimeOut);
        System.out.println("select  customer ");
        getWebElement(customerFieldSalesOrder).click();
        waitUntilElementVisibility(customersListSalesOrder, GeneralConstants.minTimeOut);
        waitUntilElementToBeClickable(customerOptSalesOrder, GeneralConstants.minTimeOut);
        getWebElement(customerOptSalesOrder).click();
//        System.out.println("enter dues date  ");
//        waitUntilElementVisibility(dueDateField, GeneralConstants.minTimeOut);
//        getWebElement(dueDateField).sendKeys(dueDate);
        System.out.println("Scroll down to item field ");
        scrollToSpeceficElement(totalAmountLabel);
       //Thread.sleep(6000);
        System.out.println(" select item  ");
//        clickByJs(getWebElement(itemCodeField));
        getWebElement(itemCodeField).click();
         waitUntilElementToBePresent(itemCodeInputField,GeneralConstants.minTimeOut);
        getWebElement(itemCodeInputField).sendKeys("item");
        waitUntilElementToBePresent(itemOpt,GeneralConstants.minTimeOut);
        getWebElement(itemOpt).click();
//        clickByJs(getWebElement(itemOpt));
//        System.out.println("unselect update stock opt");
//        getWebElement(updateStockBtn).click();
       // Thread.sleep(6000);
        System.out.println("scroll up to save and submit btn ");
        scrollToSpeceficElement(saveAndSubmitBtn);
        System.out.println(" save and submit sales order ");
        getWebElement(saveAndSubmitBtn).click();
      //  Thread.sleep(10000);
        System.out.println("click on yes btn ");
         waitUntilElementToBeClickable(yesBtn, GeneralConstants.minTimeOut);
        getWebElement(yesBtn).click();

    }

    public SalesInvoicesPage createNewSalesInvoiceFromSalesOrder() {
        System.out.println("click on create btn");
        waitUntilElementVisibility(createBtn, GeneralConstants.minTimeOut);
       getWebElement(createBtn).click();
        System.out.println("click on sales invoice");
        waitUntilElementVisibility(salesInvoiceChoice, GeneralConstants.minTimeOut);
        getWebElement(salesInvoiceChoice).click();
        return new SalesInvoicesPage(driver);
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
