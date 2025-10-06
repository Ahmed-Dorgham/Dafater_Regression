package TestCases;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.Random;

public class ComparingReportsTest extends BaseTest {
    Random random;
    int randomNumber;
    String itemCode;
    SoftAssert softAssert;

    LoginPage loginPageObj;
    HomePage homePageObj;
    SalesInvoicesListPage salesInvoicesListPageObj;
    SalesOrderListPage salesOrdersListPageObj;
    SalesOrderPage salesOrdersPageObj;
    SalesInvoicesPage salesInvoicesPageObj;
    ItemPage itemPageObj;
    ItemListPage itemListPageObj;
    ProfitAndLossReportPage profitAndLossReportPageObj;
    ReportsListPage reportsListPageObj;
    GeneralLedgerReportPage generalLedgerReportPageObj;
    CustomersAgingReportPage customersAgingReportPageObj;
    TaxDeclarationReportPage taxDeclarationReportPageObj;
    StockBalanceReportPage stockBalanceReportPageObj;
    TrialBalanceReportPage trialBalanceReportPageObj;
    FinancialStatementsReportPage financialStatementsReportPageObj;
    BalanceSheetReportPage balanceSheetReportPageObj;

    SellingPriceListsPage sellingPriceListsPageObj;
    CreditNotePage creditNotePageObj;
    StandardSellingListPage standardSellingListPageObj;
    ItemsPricesTablePage itemsPricesTablePageObj;
    ItemPricePage itemPricePageObj;

    private final String duesDate = "15-07-2026";
    private final String secretKey = "kX7NY9yMSag3";
    private final String invalidSecretKey = "kX7NY9yMSag4";
    private final String successfulConnectionMsg = "Connected Successfully";
    private final String failureConnectionMsg = "Cannot Connect";
    private final String submittedStatus = "معتمد";
    private final String draftStatus = "مسودة";
    private final String invoiceName = "ACC-SINV";
    //    private final String accountName = "0 - NAMAC";
    private final String accountName = "1 الاصول - NAMAC";
    private final String customerName = "السلامة لتجارة المحاصيل الزراعية";
    private final String companyName = "شركة نماك الوطنية الزراعية";

    @Test(priority = 1, enabled = false)
    public void TC01_comparingGeneralLedgerReport() throws InterruptedException, IOException {

        homePageLink_4 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_4");
        websiteLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "websiteLink_5");
        homePageLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_5");
        random = new Random();
        randomNumber = random.nextInt(1000000000);
        itemCode = "item " + randomNumber;
        softAssert = new SoftAssert();
        homePageObj = new HomePage(driver);
        reportsListPageObj = homePageObj.openReportsListPage();
        generalLedgerReportPageObj = reportsListPageObj.openGeneralLedgerReport();
        generalLedgerReportPageObj.applyFilters(accountName);
        System.out.println("debit value for specific account before syncing  ");
        String debitValueOfSpecificAccountBeforeSyncing = generalLedgerReportPageObj.getDebitValue();
        System.out.println("credit value for specific account before syncing  ");

        String creditValueOfSpecificAccountBeforeSyncing = generalLedgerReportPageObj.getCreditValue();
        loginPageObj = homePageObj.logOutFromDafater_4(homePageLink_4);

        loginPageObj.switchToDafater_5(websiteLink_5);
        homePageObj = loginPageObj.loginWithValidData(userName_5, password_5);
        reportsListPageObj = homePageObj.openReportsListPage();
        generalLedgerReportPageObj = reportsListPageObj.openGeneralLedgerReport();
        generalLedgerReportPageObj.applyFilters_5(companyName, accountName);

        String debitValueOfSpecificAccountAfterSyncing = generalLedgerReportPageObj.getDebitValue_5();
        String creditValueOfSpecificAccountAfterSyncing = generalLedgerReportPageObj.getCreditValue_5();
        System.out.println("verify that debit value of this account " + accountName + " which exist at dafater 5 is equal to debit value for the same account at dafater 4 ");
        softAssert.assertEquals(debitValueOfSpecificAccountBeforeSyncing, debitValueOfSpecificAccountAfterSyncing);
        System.out.println("debit value at dafater 4  before syncing is " + debitValueOfSpecificAccountBeforeSyncing + " and after syncing at dafater 5 is " + debitValueOfSpecificAccountAfterSyncing);
        System.out.println("verify that credit value of this account " + accountName + " which exist at dafater 5 is equal to credit value for the same account at dafater 4 ");
        softAssert.assertEquals(debitValueOfSpecificAccountBeforeSyncing, debitValueOfSpecificAccountAfterSyncing);
        System.out.println("credit value at dafater 4  before syncing is " + creditValueOfSpecificAccountBeforeSyncing + " and after syncing at dafater 5 is " + creditValueOfSpecificAccountAfterSyncing);
        softAssert.assertAll();
    }

    @Test(priority = 2, enabled = false)
    public void TC02_comparingCustomersAgingReport() throws InterruptedException, IOException {

        homePageLink_4 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_4");
        websiteLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "websiteLink_5");
        homePageLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_5");
        random = new Random();
        randomNumber = random.nextInt(1000000000);
        itemCode = "item " + randomNumber;
        softAssert = new SoftAssert();
        //   homePageObj = new HomePage(driver);
//        driver.navigate().to(websiteLink_4);
//        loginPageObj = new LoginPage(driver);
//        homePageObj = loginPageObj.loginWithValidData(userName_4, password_4);
        reportsListPageObj = homePageObj.openReportsListPage();
        customersAgingReportPageObj = reportsListPageObj.openCustomersAgingReport();
        customersAgingReportPageObj.applyFilters(customerName);
        System.out.println(" outstanding amount for specific customer before syncing  ");
        String outstandingAmountOfSpecificCustomerBeforeSyncing = customersAgingReportPageObj.getOutstandingAmountValue();
        loginPageObj = homePageObj.logOutFromDafater_4(homePageLink_4);
        loginPageObj.switchToDafater_5(websiteLink_5);
        homePageObj = loginPageObj.loginWithValidData(userName_5, password_5);
        reportsListPageObj = homePageObj.openReportsListPage();
        customersAgingReportPageObj = reportsListPageObj.openCustomersAgingReport();
        customersAgingReportPageObj.applyFilters_5(companyName, customerName);
        String outstandingAmountOfSpecificCustomerAfterSyncing = customersAgingReportPageObj.getOutstandingAmounValue_5();
        System.out.println("verify that outstanding Amount value of this customer " + customerName + " which exist at dafater 5 is equal to outstanding Amount value for the same customer  at dafater 4 ");
        softAssert.assertEquals(outstandingAmountOfSpecificCustomerBeforeSyncing, outstandingAmountOfSpecificCustomerAfterSyncing);
        System.out.println("outstanding Amount  value at dafater 4  before syncing is " + outstandingAmountOfSpecificCustomerBeforeSyncing + " and after syncing at dafater 5 is " + outstandingAmountOfSpecificCustomerAfterSyncing);

        softAssert.assertAll();
    }

    @Test(priority = 3, enabled = false)
    public void TC03_comparingTaxDeclarationReport() throws InterruptedException, IOException {

        homePageLink_4 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_4");
        websiteLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "websiteLink_5");
        homePageLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_5");
        random = new Random();
        randomNumber = random.nextInt(1000000000);
        itemCode = "item " + randomNumber;
        softAssert = new SoftAssert();
//        homePageObj = new HomePage(driver);
//        driver.navigate().to(websiteLink_4);
//        loginPageObj = new LoginPage(driver);
//        homePageObj = loginPageObj.loginWithValidData(userName_4, password_4);
        reportsListPageObj = homePageObj.openReportsListPage();
        taxDeclarationReportPageObj = reportsListPageObj.openTaxDeclarationReport();
//        taxDeclarationReportPageObj.applyFilters();
        System.out.println(" total tax amount for specific duration before syncing  ");
        String totalTaxAmountBeforeSyncing = taxDeclarationReportPageObj.getTotalTaxAmount();
        loginPageObj = homePageObj.logOutFromDafater_4(homePageLink_4);
        loginPageObj.switchToDafater_5(websiteLink_5);
        homePageObj = loginPageObj.loginWithValidData(userName_5, password_5);
        reportsListPageObj = homePageObj.openReportsListPage();
        taxDeclarationReportPageObj = reportsListPageObj.openTaxDeclarationReport();
        taxDeclarationReportPageObj.applyFilters_5(companyName);
        String totalTaxAmountAfterSyncing = taxDeclarationReportPageObj.getTotalTaxAmount_5();
        System.out.println("verify that total tax amount value for specific duration  which exist at dafater 5 is equal to total tax amount value for the same duration at dafater 4 ");
        softAssert.assertTrue(totalTaxAmountBeforeSyncing.contains(totalTaxAmountAfterSyncing));
        System.out.println("total tax amount value at dafater 4  before syncing is " + totalTaxAmountBeforeSyncing + " and after syncing at dafater 5 is " + totalTaxAmountAfterSyncing);

        softAssert.assertAll();
    }

    @Test(priority = 4, enabled = false)
    public void TC04_comparingStockBalanceReport() throws InterruptedException, IOException {

        homePageLink_4 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_4");
        websiteLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "websiteLink_5");
        homePageLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_5");
        random = new Random();
        randomNumber = random.nextInt(1000000000);
        itemCode = "item " + randomNumber;
        softAssert = new SoftAssert();
//        homePageObj = new HomePage(driver);
//        driver.navigate().to(websiteLink_4);
//        loginPageObj = new LoginPage(driver);
//        homePageObj = loginPageObj.loginWithValidData(userName_4, password_4);
        reportsListPageObj = homePageObj.openReportsListPage();
        stockBalanceReportPageObj = reportsListPageObj.openStockBalanceReport_4();
        stockBalanceReportPageObj.openWareHouseList();
        String wareHouseName = stockBalanceReportPageObj.getSelectedWarehouseName();
        stockBalanceReportPageObj.chooseSpecificWareHouse();
        String openingValueBeforeSyncing = stockBalanceReportPageObj.getOpeningValueFromStockBalance_4();
        String openingQuantityBeforeSyncing = stockBalanceReportPageObj.getOpeningQuantityFromStockBalance_4();
        String closingQuantityBeforeSyncing = stockBalanceReportPageObj.getClosingQuantityFromStockBalance_4();
        loginPageObj = homePageObj.logOutFromDafater_4(homePageLink_4);
        loginPageObj.switchToDafater_5(websiteLink_5);
        homePageObj = loginPageObj.loginWithValidData(userName_5, password_5);
        reportsListPageObj = homePageObj.openReportsListPage();
        stockBalanceReportPageObj = reportsListPageObj.openStockBalanceReport_5();
        stockBalanceReportPageObj.applyFilters_5(companyName, wareHouseName);
        String openingValueAfterSyncing = stockBalanceReportPageObj.getOpeningValueFromStockBalance_5();
        String openingQuantityAfterSyncing = stockBalanceReportPageObj.getOpeningQuantityFromStockBalance_5();
        System.out.println("verify that opening value for this warehouse " + wareHouseName + "  which exist at dafater 5 is equal to opening value for the same warehouse at dafater 4 ");
        softAssert.assertTrue(openingValueBeforeSyncing.contains(openingValueAfterSyncing));
        System.out.println("opening value at dafater 4  before syncing is " + openingValueBeforeSyncing + " and after syncing at dafater 5 is " + openingValueAfterSyncing);
        System.out.println("verify that opening quantity for this warehouse " + wareHouseName + "  which exist at dafater 5 is equal to opening quantity for the same warehouse at dafater 4 ");
        softAssert.assertTrue(openingQuantityBeforeSyncing.contains(openingQuantityAfterSyncing));
        System.out.println("opening quantity at dafater 4  before syncing is " + openingQuantityBeforeSyncing + " and after syncing at dafater 5 is " + openingQuantityAfterSyncing);
        softAssert.assertAll();
    }

    @Test(priority = 5, enabled = false)
    public void TC05_comparingTrialBalanceReport() throws InterruptedException, IOException {

        homePageLink_4 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_4");
        websiteLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "websiteLink_5");
        homePageLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_5");
        random = new Random();
        randomNumber = random.nextInt(1000000000);
        itemCode = "item " + randomNumber;
        softAssert = new SoftAssert();
//        homePageObj = new HomePage(driver);
//        driver.navigate().to(websiteLink_4);
//        loginPageObj = new LoginPage(driver);
//        homePageObj = loginPageObj.loginWithValidData(userName_4, password_4);
        reportsListPageObj = homePageObj.openReportsListPage();
        trialBalanceReportPageObj = reportsListPageObj.openTrialBalanceReport();
//        stockBalanceReportPageObj.openWareHouseList();
        String companyName = trialBalanceReportPageObj.getSelectedCompanyName();
        String levelName = trialBalanceReportPageObj.getSelectedLevelName();
//        String yearName = trialBalanceReportPageObj.getSelectedYearName();
        trialBalanceReportPageObj.loadData();
        String totalOpeningDebitBalanceBeforeSyncing = trialBalanceReportPageObj.getTotalOpeningDebitBalance();
        String totalOpeningCreditBalanceBeforeSyncing = trialBalanceReportPageObj.getTotalOpeningCreditBalance();
        String totalDebitBalanceBeforeSyncing = trialBalanceReportPageObj.getTotalDebitBalance();
        String totalCreditBalanceBeforeSyncing = trialBalanceReportPageObj.getTotalCreditBalance();
        String totalClosingDebitBalanceBeforeSyncing = trialBalanceReportPageObj.getTotalClosingDebitBalance();
        String totalClosingCreditBalanceBeforeSyncing = trialBalanceReportPageObj.getTotalClosingCreditBalance();

        loginPageObj = homePageObj.logOutFromDafater_4(homePageLink_4);
        loginPageObj.switchToDafater_5(websiteLink_5);
        homePageObj = loginPageObj.loginWithValidData(userName_5, password_5);
        reportsListPageObj = homePageObj.openReportsListPage();
        trialBalanceReportPageObj = reportsListPageObj.openTrialBalanceReport();
        trialBalanceReportPageObj.applyFilters_5(companyName, levelName);
//        trialBalanceReportPageObj.loadData();
        System.out.println(" data at trial balance report at dafater 5  after syncing  ");
        trialBalanceReportPageObj.scrollInsideTable();
        String totalOpeningDebitBalanceAfterSyncing = trialBalanceReportPageObj.getTotalOpeningDebitBalance();
        String totalOpeningCreditBalanceAfterSyncing = trialBalanceReportPageObj.getTotalOpeningCreditBalance();
        String totalDebitBalanceAfterSyncing = trialBalanceReportPageObj.getTotalDebitBalance();
        String totalCreditBalanceAfterSyncing = trialBalanceReportPageObj.getTotalCreditBalance();
        String totalClosingDebitBalanceAfterSyncing = trialBalanceReportPageObj.getTotalClosingDebitBalance();
        String totalClosingCreditBalanceAfterSyncing = trialBalanceReportPageObj.getTotalClosingCreditBalance();

        System.out.println("verify that total opening debit balance value which exist at dafater 5 is equal to total opening debit balance value for the same company and level at dafater 4 ");
        softAssert.assertTrue(totalOpeningDebitBalanceBeforeSyncing.contains(totalOpeningDebitBalanceAfterSyncing));
        System.out.println("total opening debit balance value at dafater 4  before syncing is " + totalOpeningDebitBalanceBeforeSyncing + " and after syncing at dafater 5 is " + totalOpeningDebitBalanceAfterSyncing);
        System.out.println("                          **********************************************************             ");
        System.out.println("verify that total opening credit balance value which exist at dafater 5 is equal to total opening credit balance value for the same company and level at dafater 4 ");
        softAssert.assertTrue(totalOpeningCreditBalanceBeforeSyncing.contains(totalOpeningCreditBalanceAfterSyncing));
        System.out.println("total opening Credit balance value at dafater 4  before syncing is " + totalOpeningCreditBalanceBeforeSyncing + " and after syncing at dafater 5 is " + totalOpeningCreditBalanceAfterSyncing);

        System.out.println("                          **********************************************************             ");
        System.out.println("verify that total debit balance value which exist at dafater 5 is equal to total debit balance value for the same company and level at dafater 4 ");
        softAssert.assertTrue(totalDebitBalanceBeforeSyncing.contains(totalDebitBalanceAfterSyncing));
        System.out.println("total debit balance value at dafater 4  before syncing is " + totalDebitBalanceBeforeSyncing + " and after syncing at dafater 5 is " + totalDebitBalanceAfterSyncing);
        System.out.println("                          **********************************************************             ");
        System.out.println("verify that total  credit balance value which exist at dafater 5 is equal to total credit balance value for the same company and level at dafater 4 ");
        softAssert.assertTrue(totalCreditBalanceBeforeSyncing.contains(totalCreditBalanceAfterSyncing));
        System.out.println("total  Credit balance value at dafater 4  before syncing is " + totalCreditBalanceBeforeSyncing + " and after syncing at dafater 5 is " + totalCreditBalanceAfterSyncing);
        System.out.println("                          **********************************************************             ");
        System.out.println("verify that total closing debit balance value which exist at dafater 5 is equal to total closing debit balance value for the same company and level at dafater 4 ");
        softAssert.assertTrue(totalClosingDebitBalanceBeforeSyncing.contains(totalClosingDebitBalanceAfterSyncing));
        System.out.println("total closing debit balance value at dafater 4  before syncing is " + totalClosingDebitBalanceBeforeSyncing + " and after syncing at dafater 5 is " + totalClosingDebitBalanceAfterSyncing);
        System.out.println("                          **********************************************************             ");
        System.out.println("verify that total closing credit balance value which exist at dafater 5 is equal to total closing credit balance value for the same company and level at dafater 4 ");
        softAssert.assertTrue(totalClosingCreditBalanceBeforeSyncing.contains(totalClosingCreditBalanceAfterSyncing));
        System.out.println("total closing Credit balance value at dafater 4  before syncing is " + totalClosingCreditBalanceBeforeSyncing + " and after syncing at dafater 5 is " + totalClosingCreditBalanceAfterSyncing);
        System.out.println("                          **********************************************************             ");
        softAssert.assertAll();
    }

    @Test(priority = 6, enabled = false)
    public void TC06_comparingBalanceSheetReport() throws InterruptedException, IOException {

        homePageLink_4 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_4");
        websiteLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "websiteLink_5");
        homePageLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_5");
        random = new Random();
        randomNumber = random.nextInt(1000000000);
        itemCode = "item " + randomNumber;
        softAssert = new SoftAssert();
        homePageObj = new HomePage(driver);
        reportsListPageObj = homePageObj.openReportsListPage();
        financialStatementsReportPageObj = reportsListPageObj.openFinancialStatementsReport();
        String listName = financialStatementsReportPageObj.selectBalanceSheetReport();
        String companyName = financialStatementsReportPageObj.getSelectedCompanyName();

        String periodName = financialStatementsReportPageObj.getSelectedPeriodName();
        String yearName = financialStatementsReportPageObj.getSelectedYearName();
        financialStatementsReportPageObj.loadReportData_4();
        String profitOrLossValueBeforeSyncing = financialStatementsReportPageObj.getProfitOrLossValue();
        loginPageObj = homePageObj.logOutFromDafater_4(homePageLink_4);
        loginPageObj.switchToDafater_5(websiteLink_5);
        homePageObj = loginPageObj.loginWithValidData(userName_5, password_5);
        reportsListPageObj = homePageObj.openReportsListPage();
        balanceSheetReportPageObj = reportsListPageObj.openBalanceSheetReport_5();
      String filtrationBasedOnOptionName =  balanceSheetReportPageObj.applyFilters_5(companyName, yearName);
        String periodNameAtDafater5 = balanceSheetReportPageObj.getPeriodOptionName();
        Assert.assertTrue(filtrationBasedOnOptionName.contains("السنة المالية"));
        Assert.assertTrue(periodNameAtDafater5.contains("سنوى"));
        balanceSheetReportPageObj.loadReportData_5();
        balanceSheetReportPageObj.scrollInsideTable();
       String profitOrLossValueAfterSyncing =  balanceSheetReportPageObj.getProfitOrLossValue();
        System.out.println("verify that profit Or Loss value which exist at dafater 5 is equal to profit Or Loss value for the same company and level at dafater 4 ");
        softAssert.assertTrue(profitOrLossValueBeforeSyncing.contains(profitOrLossValueAfterSyncing));
        System.out.println("profit Or Loss value at dafater 4  before syncing is " + profitOrLossValueBeforeSyncing + " and after syncing at dafater 5 is " + profitOrLossValueAfterSyncing);
        softAssert.assertAll();
    }

    @Test(priority = 7, enabled = true)
    public void TC07_comparingProfitAndLossReport() throws InterruptedException, IOException {

        homePageLink_4 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_4");
        websiteLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "websiteLink_5");
        homePageLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_5");
        random = new Random();
        randomNumber = random.nextInt(1000000000);
        itemCode = "item " + randomNumber;
        softAssert = new SoftAssert();
        homePageObj = new HomePage(driver);
        reportsListPageObj = homePageObj.openReportsListPage();
        financialStatementsReportPageObj = reportsListPageObj.openFinancialStatementsReport();
        String listName = financialStatementsReportPageObj.selectProfitAndLossReport();
        String companyName = financialStatementsReportPageObj.getSelectedCompanyName();

        String periodName = financialStatementsReportPageObj.getSelectedPeriodName();
        String yearName = financialStatementsReportPageObj.getSelectedYearName();
        financialStatementsReportPageObj.loadReportData_4();


        String profitOrLossValueBeforeSyncing = financialStatementsReportPageObj.getProfitOrLossValue();
        loginPageObj = homePageObj.logOutFromDafater_4(homePageLink_4);
        loginPageObj.switchToDafater_5(websiteLink_5);
        homePageObj = loginPageObj.loginWithValidData(userName_5, password_5);
        reportsListPageObj = homePageObj.openReportsListPage();
        profitAndLossReportPageObj = reportsListPageObj.openProfitAndLossReport_5();

        String filtrationBasedOnOptionName =  profitAndLossReportPageObj.applyFilters_5(companyName, yearName);
        String periodNameAtDafater5 = profitAndLossReportPageObj.getPeriodOptionName();
        Assert.assertTrue(filtrationBasedOnOptionName.contains("السنة المالية"));
        Assert.assertTrue(periodNameAtDafater5.contains("سنوى"));
        profitAndLossReportPageObj.loadReportData_5();
        profitAndLossReportPageObj.scrollInsideTable();
        String profitOrLossValueAfterSyncing =  profitAndLossReportPageObj.getProfitOrLossValue();
        System.out.println("verify that profit Or Loss value which exist at dafater 5 is equal to profit Or Loss value for the same company and level at dafater 4 ");
        softAssert.assertTrue(profitOrLossValueBeforeSyncing.contains(profitOrLossValueAfterSyncing));
        System.out.println("profit Or Loss value at dafater 4  before syncing is " + profitOrLossValueBeforeSyncing + " and after syncing at dafater 5 is " + profitOrLossValueAfterSyncing);
        softAssert.assertAll();
    }
}
