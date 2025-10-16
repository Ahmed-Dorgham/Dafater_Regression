package Pages;

import GeneralConstants.GeneralConstants;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReportsListPage extends MainPage {
    private String dataMigrationTitle = "data migration";
    // private WebDriver driver ;

    public ReportsListPage(WebDriver driver) {
        this.driver = driver;
    }

    private By checkVmConnectionBtn = By.id("check_vm_connection");
    private By syncDocTypesDataBtn = By.id("sync_doctypes_data");
    private By statusMsg = By.className("msgprint");
    private By editIcon = By.className("icon-xs");
    private By loadDataBtn = By.xpath("//*[contains(@id,'appframe-btn-تحميل البيانات')]");

    private By newBtn = By.xpath("//*[contains(@class,'btn btn-default btn-sm primary-action toolbar-btn')]");
    private By newReportBtn = By.xpath("//*[contains(@id,'appframe-btn-جديد')]" +
            "| //*[contains(@class,'btn btn-default btn-sm toolbar-btn')]");
    private By generalLedgerReport = By.xpath("//*[contains(@id,'report-general-ledger')]" +
            "| //*[contains(@href,'/app/query-report/General Ledger')]");
    private By customersAgingReport = By.xpath("//*[@id='report-customers-aging']" +
            "| //*[contains(@href,'/app/query-report/Customers Aging')]");
    private By taxDeclarationReport = By.xpath("//*[@id='page-report-tax-declaration']" +
            "|  //*[contains(@href,'/app/tax-declaration')]");
    private By stockBalanceReport = By.xpath("//*[@id='report-stock-balance']" +
            "|  //*[contains(@href,'/app/query-report/Stock Balance')]");
    private By trialBalanceReport = By.xpath("//*[@id='report-trial-balance']" +
            "|  //*[contains(@href,'/app/query-report/Dafater Trial Balance')]");
    private By grossProfitReport = By.xpath("//*[@id='report-customers-aging']" +
            "| //*[contains(@href,'/app/query-report/Gross Profit')]");

    private By financialStatementsReport = By.xpath("//*[@id='page-report-financial-statements']" +
            "| //*[contains(@href,'/app/query-report/Balance Sheet')]");

    private By balanceSheetReport = By.xpath("//*[contains(@href,'/app/query-report/Balance Sheet')]");
    private By profitAndLossReport = By.xpath("//*[contains(@href,'/app/query-report/Profit and Loss Statement')]");

    By overlay = By.xpath("//*[contains(@class,'freeze-message-container')]");
    By loadImage = By.xpath("(//*[contains(@alt,'Generic Empty State')])[3]" +
            "| (//*[contains(@class,'progress progress-striped active')])");
    By arrowIcon = By.xpath("(//*[contains(@class,'tabs-scroll-arrow')])[1]");
    By stockTab = By.xpath("//*[@id='stock-tab']|//*[@id='reports__stock-tab']");
    By accountInputField = By.xpath("//*[contains(@data-fieldname,'account')]");

    public GeneralLedgerReportPage openGeneralLedgerReport() {
        Allure.step("open general ledger report ");
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBeClickable(newReportBtn, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
//        scrollToSpeceficElement(generalLedgerReport);
        waitUntilElementToBePresent(generalLedgerReport, GeneralConstants.minTimeOut);
        getWebElement(generalLedgerReport).click();
        // getWebElement(newBtn).click();

//        waitUntilElementVisibility(statusMsg, GeneralConstants.minTimeOut);
        // Allure.step(getWebElement(connectionMsg).getText());
        return new GeneralLedgerReportPage(driver);
    }

    public CustomersAgingReportPage openCustomersAgingReport() {
        Allure.step("open customers aging report ");
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBeClickable(newReportBtn, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
//        scrollToSpeceficElement(generalLedgerReport);
        waitUntilElementToBePresent(customersAgingReport, GeneralConstants.minTimeOut);
        getWebElement(customersAgingReport).click();

        return new CustomersAgingReportPage(driver);
    }

    public TaxDeclarationReportPage openTaxDeclarationReport() {
        Allure.step("open tax declaration report ");
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBeClickable(newReportBtn, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
//        scrollToSpeceficElement(generalLedgerReport);
//        scrollToSpeceficElement(taxDeclarationReport);
        waitUntilElementToBePresent(taxDeclarationReport, GeneralConstants.minTimeOut);
        getWebElement(taxDeclarationReport).click();

        return new TaxDeclarationReportPage(driver);
    }

    public StockBalanceReportPage openStockBalanceReport_4() throws InterruptedException {
        Allure.step("open Stock Balance report ");
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBeClickable(newReportBtn, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilOverlayDisappear(loadImage, GeneralConstants.freezeTimeOut);
        Thread.sleep(threadTimeOut);
        getWebElement(arrowIcon).click();
        Thread.sleep(threadTimeOut);
        getWebElement(arrowIcon).click();
        Thread.sleep(threadTimeOut);
        getWebElement(stockTab).click();
        waitUntilElementToBePresent(stockBalanceReport, GeneralConstants.minTimeOut);
        getWebElement(stockBalanceReport).click();

        return new StockBalanceReportPage(driver);
    }

    public TrialBalanceReportPage openTrialBalanceReport() throws InterruptedException {
        Allure.step("open trial Balance report ");
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBeClickable(newReportBtn, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilOverlayDisappear(loadImage, GeneralConstants.freezeTimeOut);
        Thread.sleep(threadTimeOut);
        waitUntilElementToBePresent(trialBalanceReport, GeneralConstants.minTimeOut);
        getWebElement(trialBalanceReport).click();

        return new TrialBalanceReportPage(driver);
    }

    public FinancialStatementsReportPage openFinancialStatementsReport() throws InterruptedException {
        Allure.step("open Financial Statements report ");
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBeClickable(newReportBtn, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilOverlayDisappear(loadImage, GeneralConstants.freezeTimeOut);
        Thread.sleep(threadTimeOut);
        waitUntilElementToBePresent(financialStatementsReport, GeneralConstants.minTimeOut);
        getWebElement(financialStatementsReport).click();

        return new FinancialStatementsReportPage(driver);
    }
    public BalanceSheetReportPage openBalanceSheetReport_5() throws InterruptedException {
        Allure.step("open Balance sheet report ");
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBeClickable(newReportBtn, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilOverlayDisappear(loadImage, GeneralConstants.freezeTimeOut);
        Thread.sleep(threadTimeOut);
        waitUntilElementToBePresent(balanceSheetReport, GeneralConstants.minTimeOut);
        getWebElement(balanceSheetReport).click();

        return new BalanceSheetReportPage(driver);
    }
    public ProfitAndLossReportPage openProfitAndLossReport_5() throws InterruptedException {
        Allure.step("open Profit and loss  report ");
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBeClickable(newReportBtn, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilOverlayDisappear(loadImage, GeneralConstants.freezeTimeOut);
        Thread.sleep(threadTimeOut);
        waitUntilElementToBePresent(profitAndLossReport, GeneralConstants.minTimeOut);
        getWebElement(profitAndLossReport).click();

        return new ProfitAndLossReportPage(driver);
    }
    public StockBalanceReportPage openStockBalanceReport_5() throws InterruptedException {
        Allure.step("open Stock Balance report ");
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBeClickable(newReportBtn, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilOverlayDisappear(loadImage, GeneralConstants.freezeTimeOut);
        getWebElement(stockTab).click();
        waitUntilElementToBePresent(stockBalanceReport, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        getWebElement(stockBalanceReport).click();

        return new StockBalanceReportPage(driver);
    }
    public GrossProfitReportPage openGrossProfitReport() {
        Allure.step("open gross profit report ");
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBeClickable(newReportBtn, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
//        scrollToSpeceficElement(generalLedgerReport);
        waitUntilElementToBePresent(grossProfitReport, GeneralConstants.minTimeOut);
        getWebElement(grossProfitReport).click();

        return new GrossProfitReportPage(driver);
    }

    public void applyFilters(String accountName) {
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(loadDataBtn, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        Allure.step("enter specific account ");
        getWebElement(accountInputField).sendKeys(accountName);


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
