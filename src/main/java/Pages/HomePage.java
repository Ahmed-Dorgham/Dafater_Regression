package Pages;

import GeneralConstants.GeneralConstants;
import io.qameta.allure.Allure;
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
    private By createBtn = By.xpath("//button[contains(@id,'appframe-btn-إنشاء')]");
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
    private By journalEntryOpt = By.xpath("(//*[contains(@id,'sidebar-accounts-journal-voucher')]/span)[1]" +
            " | (//*[contains(@id,'sidebar-accounts-journal-entry')]/span)[1]");
    private By arrowIcon = By.xpath("(//*[contains(@class,'header-btn btn header__profile-btn need-work')])/i");
    private By logoutBtn = By.xpath("(//*[contains(@class,'pos-header__sign-out')])");
    private By welcomeHeader = By.xpath("(//*[contains(@class,'starter-welcome-msg starter-box my-3 col-xs-12 d-flex d-between')])" +
            "| //*[contains(@class,'starter-menu-container')]//*[contains(@class,'starter-welcome-msg starter-box my-3 col-xs-12 d-flex justify-content-between')]/div/span");

    public By salesInvoicesTab = By.id("module-anchor-Selling");
    public By sellingSetup = By.xpath("//*[@id='sidebar-selling-'] " +
            "| //*[@id='sidebar-selling-initiate-sales'] ");
    public By purchaseSetup = By.xpath("//*[@id='sidebar-buying-initiate-purchases'] ");
    public By salesTaxesAndChargesOpt = By.id("sidebar-selling-sales-tax-charges");
    public By purchaseTaxesAndChargesOpt = By.xpath("//*[@id='sidebar-buying-purchase-tax-charges']  " +
            "| //*[@id='sidebar-buying-purchase-taxes-and-charges-master']");
    private By reportsTab = By.xpath("//*[@id='module-anchor-reports']| //*[@id='module-icon-reports']/a/span");
    private By accountsTab = By.id("module-anchor-Accounts");
    public By purchaseInvoicesTab = By.xpath("//*[contains(@id,'module-anchor-Buying')] |//*[contains(@id,'module-icon-purchases')] ");
    private By wareHouseTab = By.id("module-anchor-Stock");
    private By userNameField = By.xpath("//input[@id='login_email'] | //input[@id='login_id']");
    By overlay = By.xpath("//*[contains(@class,'freeze-message-container')]");
    By settingIcon = By.xpath("//*[contains(@class,'header-btn btn need-work header__settings-btn active')]" +
            "| //*[contains(@class,'header-btn btn need-work header__settings-btn')]");
    By setupOpt = By.xpath("//*[contains(@id,'toolbar-setup')]| //*[contains(@href,'/app/list-settings')]");
    public By closeIcon = By.xpath("(//*[contains(@class,'modal-header')]//*[contains(@class,'close')])[3]");
    private By newReportBtn = By.xpath("//*[contains(@id,'appframe-btn-جديد')]" +
            "| //*[contains(@class,'btn btn-default btn-sm toolbar-btn')]");

    public DataMigrationToolPage searchAboutDataMigrationTool() {
        Allure.step(" search About Data Migration Tool ");
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
        Allure.step("close welcome msg ");
        // waitUntilElementToBeClickable(salesInvoicesTab, GeneralConstants.minTimeOut);
        waitUntilElementToBeClickable(closeIcon, GeneralConstants.minTimeOut);
        getWebElement(closeIcon).click();
    }

    public SalesInvoicesListPage openSalesInvoicesListPage() throws InterruptedException {
        Allure.step("click on sales invoice tab ");

        waitUntilElementToBeClickable(salesInvoicesTab, GeneralConstants.globalTimeOut);
        Thread.sleep(threadTimeOut);
        getWebElement(salesInvoicesTab).click();
        if (tryToGetWebElement(salesInvoicesOpt) == GeneralConstants.FAILED) {
            Allure.step("************************************");
            getWebElement(salesInvoicesTab).click();
        }
        Allure.step("click on sales invoice option ");
        waitUntilElementToBeClickable(salesInvoicesOpt, GeneralConstants.minTimeOut);
        getWebElement(salesInvoicesOpt).click();
        return new SalesInvoicesListPage(driver);
    }

    public SalesTaxesAndChargesTemplatesListPage openSalesTaxesAndChargesTemplatesListPage() throws InterruptedException {
        Allure.step("click on selling tab ");

        waitUntilElementToBeClickable(salesInvoicesTab, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        getWebElement(salesInvoicesTab).click();
        if (tryToGetWebElement(salesInvoicesOpt) == GeneralConstants.FAILED) {
            Allure.step("************************************");
            getWebElement(salesInvoicesTab).click();
        }
        waitUntilElementToBeClickable(sellingSetup, GeneralConstants.minTimeOut);
        getWebElement(sellingSetup).click();
        Allure.step(" open Sales Taxes And Charges Templates list");
        waitUntilElementToBeClickable(salesTaxesAndChargesOpt, GeneralConstants.minTimeOut);
        getWebElement(salesTaxesAndChargesOpt).click();
        return new SalesTaxesAndChargesTemplatesListPage(driver);
    }

    public PurchaseTaxesAndChargesTemplatesListPage openPurchaseTaxesAndChargesTemplatesListPage() throws InterruptedException {
        Allure.step("click on purchase tab ");

        waitUntilElementToBeClickable(purchaseInvoicesTab, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        getWebElement(purchaseInvoicesTab).click();
        if (tryToGetWebElement(purchaseInvoicesOpt) == GeneralConstants.FAILED) {
            Allure.step("************************************");
            getWebElement(purchaseInvoicesTab).click();
        }
        waitUntilElementToBeClickable(purchaseSetup, GeneralConstants.minTimeOut);
        getWebElement(purchaseSetup).click();
        Allure.step(" open purchase Taxes And Charges Templates list");
        waitUntilElementToBeClickable(purchaseTaxesAndChargesOpt, GeneralConstants.minTimeOut);
        getWebElement(purchaseTaxesAndChargesOpt).click();
        return new PurchaseTaxesAndChargesTemplatesListPage(driver);
    }

    public ReportsListPage openReportsListPage() throws InterruptedException {
        Allure.step("click on  reports tab ");

        waitUntilElementToBeClickable(arrowIcon, GeneralConstants.minTimeOut);
        Allure.step("wait until reports tab to be clickable  ");
        waitUntilElementToBePresent(reportsTab, GeneralConstants.minTimeOut);
        Allure.step("reports tab is clickable now");
        Thread.sleep(15000);
        waitUntilElementToBePresent(reportsTab, GeneralConstants.minTimeOut);
//        scrollToSpeceficElement(reportsTab);
//        getWebElement(reportsTab).click();
        clickByActions(reportsTab);
        if (tryToGetWebElement(newReportBtn) == GeneralConstants.FAILED) {
            Allure.step("************************************");
            Thread.sleep(threadTimeOut);
            clickByActions(reportsTab);
        }

        return new ReportsListPage(driver);
    }

    public CompaniesListPage openCompaniesListPage() throws InterruptedException {
        Allure.step("click on  accounts tab ");

        waitUntilElementToBeClickable(accountsTab, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        getWebElement(accountsTab).click();
        if (tryToGetWebElement(accountsTab) == GeneralConstants.FAILED) {
            Allure.step("************************************");
            getWebElement(accountsTab).click();
        }
        Allure.step("open companies list ");
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
        Allure.step("click on wareHouse tab ");
        waitUntilElementToBeClickable(wareHouseTab, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        getWebElement(wareHouseTab).click();
        if (tryToGetWebElement(salesInvoicesOpt) == GeneralConstants.FAILED) {
            Allure.step("************************************");
            getWebElement(wareHouseTab).click();
        }
        Allure.step("click on item option ");
        waitUntilElementToBeClickable(itemOpt, GeneralConstants.minTimeOut);
        getWebElement(itemOpt).click();
        return new ItemListPage(driver);
    }


    public StockEntryListPage openStockEntryListPage() throws InterruptedException {
        Allure.step("click on wareHouse tab ");
        waitUntilElementToBeClickable(wareHouseTab, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        getWebElement(wareHouseTab).click();
        if (tryToGetWebElement(stockEntryOpt) == GeneralConstants.FAILED) {
            Allure.step("************************************");
            getWebElement(wareHouseTab).click();
        }
        Allure.step("click on stock entry option ");
        waitUntilElementToBeClickable(stockEntryOpt, GeneralConstants.minTimeOut);
        getWebElement(stockEntryOpt).click();
        return new StockEntryListPage(driver);
    }

    public SetupPage openSetupPage() throws InterruptedException {
        Allure.step("click on setting icon ");
        waitUntilElementToBeClickable(settingIcon, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        getWebElement(settingIcon).click();

        Allure.step("click on setup option ");
        waitUntilElementToBeClickable(setupOpt, GeneralConstants.minTimeOut);
        getWebElement(setupOpt).click();
        return new SetupPage(driver);
    }

    public SuppliersListPage openSuppliersListPage() throws InterruptedException {
        Allure.step("click on purchase tab ");
        waitUntilElementToBeClickable(purchaseInvoicesTab, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        getWebElement(purchaseInvoicesTab).click();
        if (tryToGetWebElement(suppliersOpt) == GeneralConstants.FAILED) {
            Allure.step("************************************");
            getWebElement(purchaseInvoicesTab).click();
        }
        Allure.step("click on suppliers option ");
        waitUntilElementToBeClickable(suppliersOpt, GeneralConstants.minTimeOut);
        getWebElement(suppliersOpt).click();
        return new SuppliersListPage(driver);
    }

    public CustomersListPage openCustomersListPage() throws InterruptedException {
        Allure.step("click on sales tab ");
        waitUntilElementToBeClickable(salesInvoicesTab, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        getWebElement(salesInvoicesTab).click();
        if (tryToGetWebElement(customersOpt) == GeneralConstants.FAILED) {
            Allure.step("************************************");
            getWebElement(salesInvoicesTab).click();
        }
        Allure.step("click on customers option ");
        waitUntilElementToBeClickable(customersOpt, GeneralConstants.minTimeOut);
        getWebElement(customersOpt).click();
        return new CustomersListPage(driver);
    }

    public DebitNotesListPage openDebitNotesListPage() throws InterruptedException {
        Allure.step("click on sales tab ");
        waitUntilElementToBeClickable(salesInvoicesTab, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        getWebElement(salesInvoicesTab).click();
        if (tryToGetWebElement(customersOpt) == GeneralConstants.FAILED) {
            Allure.step("************************************");
            getWebElement(salesInvoicesTab).click();
        }
        Allure.step("click on debit notes option ");
        waitUntilElementToBeClickable(debitNotesOpt, GeneralConstants.minTimeOut);
        getWebElement(debitNotesOpt).click();
        return new DebitNotesListPage(driver);
    }

    public CreditNotesListPage openCreditNotesListPage() throws InterruptedException {
        Allure.step("click on sales tab ");
        waitUntilElementToBeClickable(salesInvoicesTab, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        getWebElement(salesInvoicesTab).click();
        if (tryToGetWebElement(customersOpt) == GeneralConstants.FAILED) {
            Allure.step("************************************");
            getWebElement(salesInvoicesTab).click();
        }
        Allure.step("click on credit notes option ");
        waitUntilElementToBeClickable(creditNotesOpt, GeneralConstants.minTimeOut);
        getWebElement(creditNotesOpt).click();
        return new CreditNotesListPage(driver);
    }

    public DeliveryNoteListPage openDeliveryNoteListPage() throws InterruptedException {
        Allure.step("click on wareHouse tab ");
        waitUntilElementToBeClickable(wareHouseTab, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        getWebElement(wareHouseTab).click();
        if (tryToGetWebElement(deliveryNoteOpt) == GeneralConstants.FAILED) {
            Allure.step("************************************");
            getWebElement(wareHouseTab).click();
        }
        Allure.step("click on delivery note option ");
        waitUntilElementToBeClickable(deliveryNoteOpt, GeneralConstants.minTimeOut);
        getWebElement(deliveryNoteOpt).click();
        return new DeliveryNoteListPage(driver);
    }


    public LoginPage logOutFromDafater_4(String homePageLink) throws InterruptedException {
        driver.navigate().to(homePageLink);
        Allure.step("close welcome msg ");
        waitUntilElementToBeClickable(salesInvoicesTab, GeneralConstants.minTimeOut);
        waitUntilElementToBeClickable(closeIcon, GeneralConstants.minTimeOut);
        getWebElement(closeIcon).click();
        waitUntilElementToBePresent(salesInvoicesTab, GeneralConstants.minTimeOut);
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
        waitUntilElementToBePresent(salesInvoicesTab, GeneralConstants.minTimeOut);
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
        Allure.step("click on wareHouse tab ");
        waitUntilElementToBeClickable(wareHouseTab, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        getWebElement(wareHouseTab).click();
        if (tryToGetWebElement(wareHousesOpt) == GeneralConstants.FAILED) {
            Allure.step("************************************");
            getWebElement(wareHouseTab).click();
        }
        Allure.step("click on warehouse option ");
        waitUntilElementToBeClickable(wareHousesOpt, GeneralConstants.minTimeOut);
        getWebElement(wareHousesOpt).click();
        return new WareHouseListPage(driver);
    }

    public PurchaseInvoicesListPage openPurchaseInvoicesListPage() throws InterruptedException {
        Allure.step("click on purchase tab ");
        waitUntilElementToBeClickable(purchaseInvoicesTab, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);

        getWebElement(purchaseInvoicesTab).click();

        if (tryToGetWebElement(purchaseInvoicesOpt) == GeneralConstants.FAILED) {
            Allure.step("************************************");
            getWebElement(purchaseInvoicesTab).click();
        }
        Allure.step("click on purchase invoice ");
        waitUntilElementToBeClickable(purchaseInvoicesOpt, GeneralConstants.minTimeOut);
        getWebElement(purchaseInvoicesOpt).click();
        return new PurchaseInvoicesListPage(driver);
    }

    public PaymentEntryListPage openPaymentEntryListPage() throws InterruptedException {
        Allure.step("click on purchase tab ");
        waitUntilElementToBeClickable(purchaseInvoicesTab, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);

        getWebElement(purchaseInvoicesTab).click();

        if (tryToGetWebElement(purchaseInvoicesOpt) == GeneralConstants.FAILED) {
            Allure.step("************************************");
            getWebElement(purchaseInvoicesTab).click();
        }
        Allure.step("click on payment entry ");
        waitUntilElementToBeClickable(paymentEntryOpt, GeneralConstants.minTimeOut);
        getWebElement(paymentEntryOpt).click();
        return new PaymentEntryListPage(driver);
    }

    public SalesOrderListPage openSalesOrdersListPage() {
        Allure.step("click on sales invoice tab ");
        waitUntilElementToBeClickable(salesInvoicesTab, GeneralConstants.minTimeOut);
        getWebElement(salesInvoicesTab).click();
        Allure.step("click on sales orders option");
        waitUntilElementToBeClickable(salesOrdersOpt, GeneralConstants.minTimeOut);
        getWebElement(salesOrdersOpt).click();
        return new SalesOrderListPage(driver);
    }

    public PurchaseOrderListPage openPurchaseOrdersListPage() {
        Allure.step("click on purchase tab ");
        waitUntilElementToBeClickable(purchaseInvoicesTab, GeneralConstants.minTimeOut);
        getWebElement(purchaseInvoicesTab).click();
        Allure.step("click on purchase order option");
        waitUntilElementToBeClickable(purchaseOrdersOpt, GeneralConstants.minTimeOut);
        getWebElement(purchaseOrdersOpt).click();
        return new PurchaseOrderListPage(driver);
    }

    public PurchaseReceiptListPage openPurchaseReceiptListPage() throws InterruptedException {
        Allure.step("click on wareHouse tab ");
        waitUntilElementToBeClickable(wareHouseTab, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        getWebElement(wareHouseTab).click();
        if (tryToGetWebElement(purchaseReceiptOpt) == GeneralConstants.FAILED) {
            Allure.step("************************************");
            getWebElement(wareHouseTab).click();
        }
        Allure.step("click on purchase receipt option ");
        waitUntilElementToBeClickable(purchaseReceiptOpt, GeneralConstants.minTimeOut);
        getWebElement(purchaseReceiptOpt).click();
        return new PurchaseReceiptListPage(driver);
    }


    public JournalEntrytListPage openJournalEntryListPage() throws InterruptedException {
        Allure.step("click on Accounts tab ");
        waitUntilElementToBeClickable(accountsTab, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        getWebElement(accountsTab).click();
        if (tryToGetWebElement(journalEntryOpt) == GeneralConstants.FAILED) {
            Allure.step("************************************");
            getWebElement(accountsTab).click();
        }
        Allure.step("click on journal entry option ");
        waitUntilElementToBeClickable(journalEntryOpt, GeneralConstants.minTimeOut);
        getWebElement(journalEntryOpt).click();
        return new JournalEntrytListPage(driver);
    }
}
