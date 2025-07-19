package Pages;
import GeneralConstants.GeneralConstants;
import org.openqa.selenium.*;
public class HomePage extends MainPage {
    private String dataMigrationTitle = "data migration";
   // private WebDriver driver ;

    public HomePage (WebDriver driver)
    {
        this.driver = driver;
    }
    private By searchIcon = By.className("fa-search");
    private By searchField = By.className("search__input");
    private By dataMigrationToolOpt = By.xpath("//*[contains(@href,'data-migration-from-dafater4-tool')]");
    private By salesInvoicesOpt = By.xpath("//*[contains(@id,'sidebar-selling-invoice')]");
    private By purchaseInvoicesOpt = By.xpath("//*[contains(@id,'sidebar-purchases-invoice')]");
    private By salesOrdersOpt = By.xpath("//*[contains(@id,'sidebar-selling-sales-orders')]");
    private By purchaseOrdersOpt = By.xpath("//*[contains(@id,'sidebar-purchases-purchase-orders')]");
    private By salesInvoicesTab = By.id("module-anchor-Selling");
    private By purchaseInvoicesTab = By.id("module-icon-purchases");
    public DataMigrationToolPage searchAboutDataMigrationTool()
    {
        waitUntilElementVisibility(searchIcon, GeneralConstants.minTimeOut);
        getWebElement(searchIcon).click();

        waitUntilElementVisibility(searchField, GeneralConstants.minTimeOut);
        getWebElement(searchField).sendKeys(dataMigrationTitle);
        waitUntilElementVisibility(dataMigrationToolOpt,GeneralConstants.minTimeOut);
        getWebElement(dataMigrationToolOpt).click();
        return new DataMigrationToolPage(driver);
    }
    public SalesInvoicesListPage openSalesInvoicesListPage()
    {
        System.out.println("click on sales invoice tab ");
        waitUntilElementToBeClickable(salesInvoicesTab, GeneralConstants.minTimeOut);
        getWebElement(salesInvoicesTab).click();
        System.out.println("click on sales invoice option ");
        waitUntilElementToBeClickable(salesInvoicesOpt, GeneralConstants.minTimeOut);
        getWebElement(salesInvoicesOpt).click();
        return new SalesInvoicesListPage(driver);
    }

    public PurchaseInvoicesListPage openPurchaseInvoicesListPage()
    {
        System.out.println("click on purchase tab ");
        waitUntilElementToBeClickable(purchaseInvoicesTab, GeneralConstants.minTimeOut);
        getWebElement(purchaseInvoicesTab).click();
        System.out.println("click on purchase invoice ");
        waitUntilElementToBeClickable(purchaseInvoicesOpt, GeneralConstants.minTimeOut);
        getWebElement(purchaseInvoicesOpt).click();
        return new PurchaseInvoicesListPage(driver);
    }


    public SalesOrderListPage openSalesOrdersListPage()
    { System.out.println("click on sales invoice tab ");
        waitUntilElementToBeClickable(salesInvoicesTab, GeneralConstants.minTimeOut);
        getWebElement(salesInvoicesTab).click();
        System.out.println("click on sales invoice option");
        waitUntilElementToBeClickable(salesOrdersOpt, GeneralConstants.minTimeOut);
        getWebElement(salesOrdersOpt).click();
        return new SalesOrderListPage(driver);
    }
    public PurchaseOrderListPage openPurchaseOrdersListPage()
    {
        System.out.println("click on purchase tab ");
        waitUntilElementToBeClickable(purchaseInvoicesTab, GeneralConstants.minTimeOut);
        getWebElement(purchaseInvoicesTab).click();
        System.out.println("click on purchase order option");
        waitUntilElementToBeClickable(purchaseOrdersOpt, GeneralConstants.minTimeOut);
        getWebElement(purchaseOrdersOpt).click();
        return new PurchaseOrderListPage(driver);
    }
}
