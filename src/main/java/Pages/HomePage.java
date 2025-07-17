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
    private By salesOrdersOpt = By.xpath("//*[contains(@id,'sidebar-selling-sales-orders')]");
    private By salesInvoicesTab = By.id("module-anchor-Selling");
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
        waitUntilElementToBeClickable(salesInvoicesTab, GeneralConstants.minTimeOut);
        getWebElement(salesInvoicesTab).click();

        waitUntilElementToBeClickable(salesInvoicesOpt, GeneralConstants.minTimeOut);
        getWebElement(salesInvoicesOpt).click();
        return new SalesInvoicesListPage(driver);
    }
    public SalesOrdersListPage openSalesOrdersListPage()
    {
        waitUntilElementToBeClickable(salesInvoicesTab, GeneralConstants.minTimeOut);
        getWebElement(salesInvoicesTab).click();

        waitUntilElementToBeClickable(salesOrdersOpt, GeneralConstants.minTimeOut);
        getWebElement(salesOrdersOpt).click();
        return new SalesOrdersListPage(driver);
    }
}
