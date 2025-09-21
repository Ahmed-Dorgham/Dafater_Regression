package Pages;

import GeneralConstants.GeneralConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends MainPage {
    private String dataMigrationTitle = "data migration";
    // private WebDriver driver ;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By searchIcon = By.className("fa-search");
    private By searchField = By.className("search__input");
    private By dataMigrationToolOpt = By.xpath("//*[contains(@href,'data-migration-from-dafater4-tool')]");
    private By salesInvoicesOpt = By.xpath("(//*[contains(@id,'sidebar-selling-invoice')]/span)[1]");
    private By suppliersOpt = By.xpath("(//*[contains(@id,'sidebar-purchases-suppliers')]/span)[1]" +
            "| (//*[contains(@href,'#List/Supplier')]/span)[1]");
    private By customersOpt = By.xpath("(//*[contains(@id,'sidebar-selling-customers')]/span)[1]" +
            "| (//*[contains(@href,'#List/Customer')]/span)[1]");

    private By debitNotesOpt = By.xpath("(//*[contains(@id,'sidebar-selling-debit-note')]/span)[1]");
    private By creditNotesOpt = By.xpath("(//*[contains(@id,'sidebar-selling-credit-notes')]/span)[1]" +
            "| (//*[contains(@id,'sidebar-selling-return-note')]/span)[1]");
    private By companiesOpt = By.xpath("//*[@id='sidebar-accounts-company-section-companies']/span" +
            "| //*[@id='sidebar-accounts-company']");
    private By companyTab = By.xpath("(//*[@id='sidebar-accounts-company-section']/span)[1]");

    private By wareHousesOpt = By.xpath("(//*[contains(@id,'sidebar-stock-warehouse')]/span)[1]");
    private By purchaseInvoicesOpt = By.xpath("//*[contains(@id,'sidebar-purchases-invoice')] | //*[contains(@id,'sidebar-buying-invoice')]");
    private By paymentEntryOpt = By.xpath("//*[contains(@id,'sidebar-buying-payment-voucher')]");
    private By salesOrdersOpt = By.xpath("(//*[contains(@id,'sidebar-selling-sales-orders')]/span)[1]");
    private By sellingPriceListsOpt = By.xpath("(//*[contains(@id,'sidebar-selling-price-lists')]/span)[1]");
    private By purchaseOrdersOpt = By.xpath("//*[contains(@id,'sidebar-purchases-purchase-orders')]");
    private By itemOpt = By.xpath("(//*[contains(@id,'sidebar-stock-item')]/span)[1]");
    private By stockEntryOpt = By.xpath("(//*[contains(@id,'sidebar-stock-stock-entry')]/span)[1]");
    private By deliveryNoteOpt = By.xpath("(//*[contains(@id,'sidebar-stock-delivery-note')]/span)[1]");
    private By purchaseReceiptOpt = By.xpath("(//*[contains(@id,'sidebar-stock-purchase-receipt')]/span)[1]");
    private By arrowIcon = By.xpath("(//*[contains(@class,'header-btn btn header__profile-btn need-work')])/i");
    private By logoutBtn = By.xpath("(//*[contains(@class,'pos-header__sign-out')])");
    private By welcomeHeader = By.xpath("(//*[contains(@class,'starter-welcome-msg starter-box my-3 col-xs-12 d-flex d-between')])" +
            "| //*[contains(@class,'starter-menu-container')]//*[contains(@class,'starter-welcome-msg starter-box my-3 col-xs-12 d-flex justify-content-between')]/div/span");

    public By salesInvoicesTab = By.id("module-anchor-Selling");
    private By reportsTab = By.id("module-anchor-reports");
    private By accountsTab = By.id("module-anchor-Accounts");
    public By purchaseInvoicesTab = By.xpath("//*[contains(@id,'module-anchor-Buying')] |//*[contains(@id,'module-icon-purchases')] ");
    private By wareHouseTab = By.id("module-anchor-Stock");
    private By userNameField = By.xpath("//input[@id='login_email'] | //input[@id='login_id']");
    By overlay = By.xpath("//*[contains(@class,'freeze-message-container')]");
    By settingIcon = By.xpath("//*[contains(@class,'header-btn btn need-work header__settings-btn active')]" +
            "| //*[contains(@class,'header-btn btn need-work header__settings-btn')]");
    By setupOpt = By.xpath("//*[contains(@id,'toolbar-setup')]| //*[contains(@href,'/app/list-settings')]");
    public By closeIcon = By.xpath("(//*[contains(@class,'modal-header')]//*[contains(@class,'close')])[3]");

    public DataMigrationToolPage searchAboutDataMigrationTool() {
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementVisibility(searchIcon, GeneralConstants.minTimeOut);
        getWebElement(searchIcon).click();

        waitUntilElementVisibility(searchField, GeneralConstants.minTimeOut);
        getWebElement(searchField).sendKeys(dataMigrationTitle);
        waitUntilElementVisibility(dataMigrationToolOpt, GeneralConstants.minTimeOut);
        getWebElement(dataMigrationToolOpt).click();
        return new DataMigrationToolPage(driver);
    }

    public void closeWelcomeMsg() {
        System.out.println("close welcome msg ");
        // waitUntilElementToBeClickable(salesInvoicesTab, GeneralConstants.minTimeOut);
        waitUntilElementToBeClickable(closeIcon, GeneralConstants.minTimeOut);
        getWebElement(closeIcon).click();
    }

    public SalesInvoicesListPage openSalesInvoicesListPage() throws InterruptedException {
        System.out.println("click on sales invoice tab ");

        waitUntilElementToBeClickable(salesInvoicesTab, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        getWebElement(salesInvoicesTab).click();
        if (tryToGetWebElement(salesInvoicesOpt) == GeneralConstants.FAILED) {
            System.out.println("************************************");
            getWebElement(salesInvoicesTab).click();
        }
        System.out.println("click on sales invoice option ");
        waitUntilElementToBeClickable(salesInvoicesOpt, GeneralConstants.minTimeOut);
        getWebElement(salesInvoicesOpt).click();
        return new SalesInvoicesListPage(driver);
    }

    public ReportsListPage openReportsListPage() throws InterruptedException {
        System.out.println("click on  reports tab ");

        waitUntilElementToBeClickable(reportsTab, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        getWebElement(reportsTab).click();
        if (tryToGetWebElement(reportsTab) == GeneralConstants.FAILED) {
            System.out.println("************************************");
            getWebElement(reportsTab).click();
        }
//        System.out.println("click on sales invoice option ");
//        waitUntilElementToBeClickable(salesInvoicesOpt, GeneralConstants.minTimeOut);
//        getWebElement(salesInvoicesOpt).click();
        return new ReportsListPage(driver);
    }

    public CompaniesListPage openCompaniesListPage() throws InterruptedException {
        System.out.println("click on  accounts tab ");

        waitUntilElementToBeClickable(accountsTab, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        getWebElement(accountsTab).click();
        if (tryToGetWebElement(accountsTab) == GeneralConstants.FAILED) {
            System.out.println("************************************");
            getWebElement(accountsTab).click();
        }
        System.out.println("open companies list ");
        if (tryToGetWebElement(companyTab) == GeneralConstants.SUCCESS) {
            getWebElement(companyTab).click();
            waitUntilElementToBeClickable(companiesOpt, GeneralConstants.minTimeOut);
            getWebElement(companiesOpt).click();

        } else {
            waitUntilElementToBeClickable(companiesOpt, GeneralConstants.minTimeOut);
            getWebElement(companiesOpt).click();
        }


        return new CompaniesListPage(driver);
    }

    public ItemListPage openItemListPage() throws InterruptedException {
        System.out.println("click on wareHouse tab ");
        waitUntilElementToBeClickable(wareHouseTab, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        getWebElement(wareHouseTab).click();
        if (tryToGetWebElement(salesInvoicesOpt) == GeneralConstants.FAILED) {
            System.out.println("************************************");
            getWebElement(wareHouseTab).click();
        }
        System.out.println("click on item option ");
        waitUntilElementToBeClickable(itemOpt, GeneralConstants.minTimeOut);
        getWebElement(itemOpt).click();
        return new ItemListPage(driver);
    }


    public StockEntryListPage openStockEntryListPage() throws InterruptedException {
        System.out.println("click on wareHouse tab ");
        waitUntilElementToBeClickable(wareHouseTab, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        getWebElement(wareHouseTab).click();
        if (tryToGetWebElement(stockEntryOpt) == GeneralConstants.FAILED) {
            System.out.println("************************************");
            getWebElement(wareHouseTab).click();
        }
        System.out.println("click on stock entry option ");
        waitUntilElementToBeClickable(stockEntryOpt, GeneralConstants.minTimeOut);
        getWebElement(stockEntryOpt).click();
        return new StockEntryListPage(driver);
    }

    public SetupPage openSetupPage() throws InterruptedException {
        System.out.println("click on setting icon ");
        waitUntilElementToBeClickable(settingIcon, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        getWebElement(settingIcon).click();

        System.out.println("click on setup option ");
        waitUntilElementToBeClickable(setupOpt, GeneralConstants.minTimeOut);
        getWebElement(setupOpt).click();
        return new SetupPage(driver);
    }

    public SuppliersListPage openSuppliersListPage() throws InterruptedException {
        System.out.println("click on purchase tab ");
        waitUntilElementToBeClickable(purchaseInvoicesTab, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        getWebElement(purchaseInvoicesTab).click();
        if (tryToGetWebElement(suppliersOpt) == GeneralConstants.FAILED) {
            System.out.println("************************************");
            getWebElement(purchaseInvoicesTab).click();
        }
        System.out.println("click on suppliers option ");
        waitUntilElementToBeClickable(suppliersOpt, GeneralConstants.minTimeOut);
        getWebElement(suppliersOpt).click();
        return new SuppliersListPage(driver);
    }

    public CustomersListPage openCustomersListPage() throws InterruptedException {
        System.out.println("click on sales tab ");
        waitUntilElementToBeClickable(salesInvoicesTab, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        getWebElement(salesInvoicesTab).click();
        if (tryToGetWebElement(customersOpt) == GeneralConstants.FAILED) {
            System.out.println("************************************");
            getWebElement(salesInvoicesTab).click();
        }
        System.out.println("click on customers option ");
        waitUntilElementToBeClickable(customersOpt, GeneralConstants.minTimeOut);
        getWebElement(customersOpt).click();
        return new CustomersListPage(driver);
    }

    public DebitNotesListPage openDebitNotesListPage() throws InterruptedException {
        System.out.println("click on sales tab ");
        waitUntilElementToBeClickable(salesInvoicesTab, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        getWebElement(salesInvoicesTab).click();
        if (tryToGetWebElement(customersOpt) == GeneralConstants.FAILED) {
            System.out.println("************************************");
            getWebElement(salesInvoicesTab).click();
        }
        System.out.println("click on debit notes option ");
        waitUntilElementToBeClickable(debitNotesOpt, GeneralConstants.minTimeOut);
        getWebElement(debitNotesOpt).click();
        return new DebitNotesListPage(driver);
    }

    public CreditNotesListPage openCreditNotesListPage() throws InterruptedException {
        System.out.println("click on sales tab ");
        waitUntilElementToBeClickable(salesInvoicesTab, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        getWebElement(salesInvoicesTab).click();
        if (tryToGetWebElement(customersOpt) == GeneralConstants.FAILED) {
            System.out.println("************************************");
            getWebElement(salesInvoicesTab).click();
        }
        System.out.println("click on credit notes option ");
        waitUntilElementToBeClickable(creditNotesOpt, GeneralConstants.minTimeOut);
        getWebElement(creditNotesOpt).click();
        return new CreditNotesListPage(driver);
    }

    public DeliveryNoteListPage openDeliveryNoteListPage() throws InterruptedException {
        System.out.println("click on wareHouse tab ");
        waitUntilElementToBeClickable(wareHouseTab, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        getWebElement(wareHouseTab).click();
        if (tryToGetWebElement(deliveryNoteOpt) == GeneralConstants.FAILED) {
            System.out.println("************************************");
            getWebElement(wareHouseTab).click();
        }
        System.out.println("click on delivery note option ");
        waitUntilElementToBeClickable(deliveryNoteOpt, GeneralConstants.minTimeOut);
        getWebElement(deliveryNoteOpt).click();
        return new DeliveryNoteListPage(driver);
    }


    public LoginPage logOutFromDafater_4(String homePageLink) throws InterruptedException {
        driver.navigate().to(homePageLink);
        System.out.println("close welcome msg ");
        waitUntilElementToBeClickable(salesInvoicesTab, GeneralConstants.minTimeOut);
        waitUntilElementToBeClickable(closeIcon, GeneralConstants.minTimeOut);
        getWebElement(closeIcon).click();
        waitUntilElementToBePresent(welcomeHeader, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        waitUntilElementToBeClickable(arrowIcon, GeneralConstants.minTimeOut);
        getWebElement(arrowIcon).click();
        waitUntilElementToBeClickable(logoutBtn, GeneralConstants.minTimeOut);
        getWebElement(logoutBtn).click();
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(userNameField, GeneralConstants.minTimeOut);
        driver.navigate().refresh();
        return new LoginPage(driver);
    }

    public LoginPage logOutFromDafater_5() throws InterruptedException {
        //  driver.navigate().to(homePageLink);
        waitUntilElementToBePresent(welcomeHeader, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        waitUntilElementToBeClickable(arrowIcon, GeneralConstants.minTimeOut);
        getWebElement(arrowIcon).click();
        waitUntilElementToBeClickable(logoutBtn, GeneralConstants.minTimeOut);
        getWebElement(logoutBtn).click();
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(userNameField, GeneralConstants.minTimeOut);
        driver.navigate().refresh();
        return new LoginPage(driver);
    }


    public WareHouseListPage openWareHouseListPage() throws InterruptedException {
        System.out.println("click on wareHouse tab ");
        waitUntilElementToBeClickable(wareHouseTab, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        getWebElement(wareHouseTab).click();
        if (tryToGetWebElement(wareHousesOpt) == GeneralConstants.FAILED) {
            System.out.println("************************************");
            getWebElement(wareHouseTab).click();
        }
        System.out.println("click on warehouse option ");
        waitUntilElementToBeClickable(wareHousesOpt, GeneralConstants.minTimeOut);
        getWebElement(wareHousesOpt).click();
        return new WareHouseListPage(driver);
    }

    public PurchaseInvoicesListPage openPurchaseInvoicesListPage() throws InterruptedException {
        System.out.println("click on purchase tab ");
        waitUntilElementToBeClickable(purchaseInvoicesTab, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);

        getWebElement(purchaseInvoicesTab).click();

        if (tryToGetWebElement(purchaseInvoicesOpt) == GeneralConstants.FAILED) {
            System.out.println("************************************");
            getWebElement(purchaseInvoicesTab).click();
        }
        System.out.println("click on purchase invoice ");
        waitUntilElementToBeClickable(purchaseInvoicesOpt, GeneralConstants.minTimeOut);
        getWebElement(purchaseInvoicesOpt).click();
        return new PurchaseInvoicesListPage(driver);
    }

    public PaymentEntryListPage openPaymentEntryListPage() throws InterruptedException {
        System.out.println("click on purchase tab ");
        waitUntilElementToBeClickable(purchaseInvoicesTab, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);

        getWebElement(purchaseInvoicesTab).click();

        if (tryToGetWebElement(purchaseInvoicesOpt) == GeneralConstants.FAILED) {
            System.out.println("************************************");
            getWebElement(purchaseInvoicesTab).click();
        }
        System.out.println("click on payment entry ");
        waitUntilElementToBeClickable(paymentEntryOpt, GeneralConstants.minTimeOut);
        getWebElement(paymentEntryOpt).click();
        return new PaymentEntryListPage(driver);
    }

    public SalesOrderListPage openSalesOrdersListPage() {
        System.out.println("click on sales invoice tab ");
        waitUntilElementToBeClickable(salesInvoicesTab, GeneralConstants.minTimeOut);
        getWebElement(salesInvoicesTab).click();
        System.out.println("click on sales orders option");
        waitUntilElementToBeClickable(salesOrdersOpt, GeneralConstants.minTimeOut);
        getWebElement(salesOrdersOpt).click();
        return new SalesOrderListPage(driver);
    }

    public PurchaseOrderListPage openPurchaseOrdersListPage() {
        System.out.println("click on purchase tab ");
        waitUntilElementToBeClickable(purchaseInvoicesTab, GeneralConstants.minTimeOut);
        getWebElement(purchaseInvoicesTab).click();
        System.out.println("click on purchase order option");
        waitUntilElementToBeClickable(purchaseOrdersOpt, GeneralConstants.minTimeOut);
        getWebElement(purchaseOrdersOpt).click();
        return new PurchaseOrderListPage(driver);
    }

    public PurchaseReceiptListPage openPurchaseReceiptListPage() throws InterruptedException {
        System.out.println("click on wareHouse tab ");
        waitUntilElementToBeClickable(wareHouseTab, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        getWebElement(wareHouseTab).click();
        if (tryToGetWebElement(purchaseReceiptOpt) == GeneralConstants.FAILED) {
            System.out.println("************************************");
            getWebElement(wareHouseTab).click();
        }
        System.out.println("click on purchase receipt option ");
        waitUntilElementToBeClickable(purchaseReceiptOpt, GeneralConstants.minTimeOut);
        getWebElement(purchaseReceiptOpt).click();
        return new PurchaseReceiptListPage(driver);
    }
}
