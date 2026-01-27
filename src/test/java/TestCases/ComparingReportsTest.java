package TestCases;

import GeneralConstants.GeneralConstants;
import Pages.*;
import io.qameta.allure.Allure;
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
    GrossProfitReportPage grossProfitReportPageObj;
    GeneralLedgerReportPage generalLedgerReportPageObj;
    CustomersAgingReportPage customersAgingReportPageObj;
    TaxDeclarationReportPage taxDeclarationReportPageObj;
    StockBalanceReportPage stockBalanceReportPageObj;
    MonthlySalaryRegisterReportPage monthlySalaryRegisterReportPageObj;
    EmployeeLeaveBalanceReportPage employeeLeaveBalanceReportPageObj;
    TrialBalanceReportPage trialBalanceReportPageObj;
    FinancialStatementsReportPage financialStatementsReportPageObj;
    SupplierAgingDetailsPage supplierAgingDetailsPageObj;
    SalesPersonDetailedReport salesPersonDetailedReportObj;
    BalanceSheetReportPage balanceSheetReportPageObj;

    SellingPriceListsPage sellingPriceListsPageObj;
    CreditNotePage creditNotePageObj;
    StandardSellingListPage standardSellingListPageObj;
    ItemsPricesTablePage itemsPricesTablePageObj;
    ItemPricePage itemPricePageObj;
    DeliveryNoteListPage deliveryNoteListPageObj;
    PurchaseReceiptListPage purchaseReceiptListPageObj;
    PurchaseReceiptPage purchaseReceiptPage;
    DeliveryNotePage deliveryNotePageObj;


    private final String submittedStatus = "معتمد";
    private final String draftStatus = "مسودة";
    private final String invoiceName = "ACC-SINV";


    @Test(priority = 1, enabled = false)
    public void TC01_comparingGeneralLedgerReportWithSpecificAccount() throws InterruptedException, IOException {

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
        companyName = generalLedgerReportPageObj.chooseCompany();
        String accountName = generalLedgerReportPageObj.chooseAccount();
        generalLedgerReportPageObj.clickOnLoadDataBtn();
//        Allure.step("debit value for specific account before syncing  ");
//        String debitValueOfSpecificAccountBeforeSyncing = generalLedgerReportPageObj.getDebitValue();
//        Allure.step("credit value for specific account before syncing  ");
//
//        String creditValueOfSpecificAccountBeforeSyncing = generalLedgerReportPageObj.getCreditValue();
        Allure.step("balance value for specific account before syncing  ");
        String balanceValueOfSpecificCompanyBeforeSyncing = generalLedgerReportPageObj.getBalanceValue().replace(",", "");
        loginPageObj = homePageObj.logOutFromDafater_4(homePageLink_4);

        loginPageObj.switchToDafater_5(websiteLink_5);
        homePageObj = loginPageObj.loginWithValidData(userName_5, password_5);
        reportsListPageObj = homePageObj.openReportsListPage();
        generalLedgerReportPageObj = reportsListPageObj.openGeneralLedgerReport();
        generalLedgerReportPageObj.applyFiltersWithCompanyAndAccount_5(companyName, accountName);

//        String debitValueOfSpecificAccountAfterSyncing = generalLedgerReportPageObj.getDebitValue_5();
//        String creditValueOfSpecificAccountAfterSyncing = generalLedgerReportPageObj.getCreditValue_5();
        String balanceValueOfSpecificCompanyAfterSyncing = generalLedgerReportPageObj.getBalanceValue_5().replace(",", "");
//        Allure.step("verify that debit value of this account " + accountName + " which exist at dafater 5 is equal to debit value for the same account at dafater 4 ");
//        softAssert.assertEquals(debitValueOfSpecificAccountBeforeSyncing, debitValueOfSpecificAccountAfterSyncing);
//        Allure.step("debit value at dafater 4  before syncing is " + debitValueOfSpecificAccountBeforeSyncing + " and after syncing at dafater 5 is " + debitValueOfSpecificAccountAfterSyncing);
        Allure.step("verify that credit value of this account " + accountName + " which exist at dafater 5 is equal to credit value for the same account at dafater 4 ");
//        softAssert.assertEquals(creditValueOfSpecificAccountBeforeSyncing, creditValueOfSpecificAccountAfterSyncing);
//        Allure.step("credit value at dafater 4  before syncing is " + creditValueOfSpecificAccountBeforeSyncing + " and after syncing at dafater 5 is " + creditValueOfSpecificAccountAfterSyncing);
        Allure.step("verify that balance  value of this account " + accountName + " which exist at dafater 5 is equal to balance value for the same account at dafater 4 ");
        softAssert.assertEquals((long) Double.parseDouble(balanceValueOfSpecificCompanyBeforeSyncing.trim()), (long) Double.parseDouble(balanceValueOfSpecificCompanyAfterSyncing.trim()));
        Allure.step("credit value at dafater 4  before syncing is " + (long) Double.parseDouble(balanceValueOfSpecificCompanyBeforeSyncing) + " and after syncing at dafater 5 is " + (long) Double.parseDouble(balanceValueOfSpecificCompanyAfterSyncing));


        softAssert.assertAll();
    }

    @Test(priority = 2, enabled = false)
    public void TC02_comparingGeneralLedgerReportWithoutFiltration() throws InterruptedException, IOException {

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
        companyName = generalLedgerReportPageObj.chooseCompany();
//        String accountName = generalLedgerReportPageObj.chooseAccount();
        generalLedgerReportPageObj.clickOnLoadDataBtn();
//        Allure.step("debit value for specific company before syncing  ");
//        String debitValueOfSpecificCompanyBeforeSyncing = generalLedgerReportPageObj.getDebitValue();
//        Allure.step("credit value for specific company before syncing  ");
//        String creditValueOfSpecificCompanyBeforeSyncing = generalLedgerReportPageObj.getCreditValue();
        Allure.step("balance value for specific company before syncing  ");
        String balanceValueOfSpecificCompanyBeforeSyncing = generalLedgerReportPageObj.getBalanceValue();
        loginPageObj = homePageObj.logOutFromDafater_4(homePageLink_4);

        loginPageObj.switchToDafater_5(websiteLink_5);
        homePageObj = loginPageObj.loginWithValidData(userName_5, password_5);
        reportsListPageObj = homePageObj.openReportsListPage();
        generalLedgerReportPageObj = reportsListPageObj.openGeneralLedgerReport();
        generalLedgerReportPageObj.applyFiltersWithCompanyOnly_5(companyName);
//
//        String debitValueOfSpecificCompanyAfterSyncing = generalLedgerReportPageObj.getDebitValueF_5();
//        String creditValueOfSpecificCompanyAfterSyncing = generalLedgerReportPageObj.getCreditValueF_5();
        String balanceValueOfSpecificCompanyAfterSyncing = generalLedgerReportPageObj.getBalanceValueF_5();

//        Allure.step("verify that debit value for this company  " + companyName + " which exist at dafater 5 is equal to debit value for the same company at dafater 4 ");
//        softAssert.assertEquals(debitValueOfSpecificCompanyBeforeSyncing, debitValueOfSpecificCompanyAfterSyncing);
//        Allure.step("debit value at dafater 4  before syncing is " + debitValueOfSpecificCompanyBeforeSyncing + " and after syncing at dafater 5 is " + debitValueOfSpecificCompanyAfterSyncing);
//        Allure.step("verify that credit value for this company  " + companyName + " which exist at dafater 5 is equal to credit value for the same company at dafater 4 ");
//        softAssert.assertEquals(creditValueOfSpecificCompanyBeforeSyncing, creditValueOfSpecificCompanyAfterSyncing);
//        Allure.step("credit value at dafater 4  before syncing is " + creditValueOfSpecificCompanyBeforeSyncing + " and after syncing at dafater 5 is " + creditValueOfSpecificCompanyAfterSyncing);


        Allure.step("verify that balance  value of this account " + companyName + " which exist at dafater 5 is equal to balance value for the same account at dafater 4 ");
        softAssert.assertEquals(balanceValueOfSpecificCompanyBeforeSyncing, balanceValueOfSpecificCompanyAfterSyncing);
        Allure.step("balance value at dafater 4  before syncing is " + balanceValueOfSpecificCompanyBeforeSyncing + " and after syncing at dafater 5 is " + balanceValueOfSpecificCompanyAfterSyncing);


        softAssert.assertAll();
    }

    // with ghidaa
    @Test(priority = 3, enabled = false)
    public void TC03_comparingCustomersAgingReport() throws InterruptedException, IOException {

        homePageLink_4 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_4");
        websiteLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "websiteLink_5");
        homePageLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_5");
        random = new Random();
        randomNumber = random.nextInt(1000000000);
        itemCode = "item " + randomNumber;
        softAssert = new SoftAssert();
        homePageObj = new HomePage(driver);
//        driver.navigate().to(websiteLink_4);
//        loginPageObj = new LoginPage(driver);
//        homePageObj = loginPageObj.loginWithValidData(userName_4, password_4);
        reportsListPageObj = homePageObj.openReportsListPage();
        customersAgingReportPageObj = reportsListPageObj.openCustomersAgingReport();
        companyName = customersAgingReportPageObj.chooseCompany();
        String customerName = customersAgingReportPageObj.chooseCustomer();
        Allure.step(" outstanding amount for specific customer before syncing  ");
        String outstandingAmountOfSpecificCustomerBeforeSyncing = customersAgingReportPageObj.getOutstandingAmountValue();
        loginPageObj = homePageObj.logOutFromDafater_4(homePageLink_4);
        loginPageObj.switchToDafater_5(websiteLink_5);
        homePageObj = loginPageObj.loginWithValidData(userName_5, password_5);
        reportsListPageObj = homePageObj.openReportsListPage();
        customersAgingReportPageObj = reportsListPageObj.openCustomersAgingReport();
        customersAgingReportPageObj.applyFilters_5(companyName, customerName);
        String outstandingAmountOfSpecificCustomerAfterSyncing = customersAgingReportPageObj.getOutstandingAmounValue_5();
        Allure.step("verify that outstanding Amount value of this customer " + customerName + " which exist at dafater 5 is equal to outstanding Amount value for the same customer  at dafater 4 ");
        softAssert.assertEquals(outstandingAmountOfSpecificCustomerBeforeSyncing, outstandingAmountOfSpecificCustomerAfterSyncing);
        Allure.step("outstanding Amount  value at dafater 4  before syncing is " + outstandingAmountOfSpecificCustomerBeforeSyncing + " and after syncing at dafater 5 is " + outstandingAmountOfSpecificCustomerAfterSyncing);

        softAssert.assertAll();
    }

    @Test(priority = 4, enabled = false)
    public void TC04_comparingTaxDeclarationReport() throws InterruptedException, IOException {

        homePageLink_4 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_4");
        websiteLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "websiteLink_5");
        homePageLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_5");
        random = new Random();
        randomNumber = random.nextInt(1000000000);
        itemCode = "item " + randomNumber;
        softAssert = new SoftAssert();
        homePageObj = new HomePage(driver);
//        driver.navigate().to(websiteLink_4);
//        loginPageObj = new LoginPage(driver);
//        homePageObj = loginPageObj.loginWithValidData(userName_4, password_4);
        reportsListPageObj = homePageObj.openReportsListPage();
        taxDeclarationReportPageObj = reportsListPageObj.openTaxDeclarationReport();
        companyName = taxDeclarationReportPageObj.chooseCompany();
        taxDeclarationReportPageObj.chooseCurrentYear();
        taxDeclarationReportPageObj.applyFilters();
        Allure.step(" total tax amount for specific duration before syncing  ");
        String totalTaxAmountBeforeSyncing = taxDeclarationReportPageObj.getTotalTaxAmount();
        loginPageObj = homePageObj.logOutFromDafater_4(homePageLink_4);
        loginPageObj.switchToDafater_5(websiteLink_5);
        homePageObj = loginPageObj.loginWithValidData(userName_5, password_5);
        reportsListPageObj = homePageObj.openReportsListPage();
        taxDeclarationReportPageObj = reportsListPageObj.openTaxDeclarationReport();
        taxDeclarationReportPageObj.applyFilters_5(companyName);
        String totalTaxAmountAfterSyncing = taxDeclarationReportPageObj.getTotalTaxAmount_5();
        Allure.step("verify that total tax amount value for specific duration  which exist at dafater 5 is equal to total tax amount value for the same duration at dafater 4 ");


        softAssert.assertTrue(totalTaxAmountBeforeSyncing.equalsIgnoreCase(totalTaxAmountAfterSyncing));
        Allure.step("total tax amount value at dafater 4  before syncing is " + totalTaxAmountBeforeSyncing + " and after syncing at dafater 5 is " + totalTaxAmountAfterSyncing);

        softAssert.assertAll();
    }

    //
    @Test(priority = 5, enabled = false)
    public void TC05_comparingStockBalanceReport() throws InterruptedException, IOException {

        homePageLink_4 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_4");
        websiteLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "websiteLink_5");
        homePageLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_5");
        random = new Random();
        randomNumber = random.nextInt(1000000000);
        itemCode = "item " + randomNumber;
        softAssert = new SoftAssert();
        homePageObj = new HomePage(driver);

        reportsListPageObj = homePageObj.openReportsListPage();
        stockBalanceReportPageObj = reportsListPageObj.openStockBalanceReport_4();
//        companyName = taxDeclarationReportPageObj.chooseCompany();
        stockBalanceReportPageObj.openWareHouseList();
        String wareHouseName = stockBalanceReportPageObj.getSelectedWarehouseName();
//        companyName = stockBalanceReportPageObj.chooseCompany();
        stockBalanceReportPageObj.chooseSpecificWareHouse();
        String openingValueBeforeSyncing = stockBalanceReportPageObj.getOpeningValueFromStockBalance_4();
        Assert.assertFalse(openingValueBeforeSyncing.equals(GeneralConstants.FAILED));
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
        Allure.step("verify that opening value for this warehouse " + wareHouseName + "  which exist at dafater 5 is equal to opening value for the same warehouse at dafater 4 ");
        softAssert.assertTrue(openingValueBeforeSyncing.contains(openingValueAfterSyncing));
        Allure.step("opening value at dafater 4  before syncing is " + openingValueBeforeSyncing + " and after syncing at dafater 5 is " + openingValueAfterSyncing);
        Allure.step("verify that opening quantity for this warehouse " + wareHouseName + "  which exist at dafater 5 is equal to opening quantity for the same warehouse at dafater 4 ");
        softAssert.assertTrue(openingQuantityBeforeSyncing.contains(openingQuantityAfterSyncing));
        Allure.step("opening quantity at dafater 4  before syncing is " + openingQuantityBeforeSyncing + " and after syncing at dafater 5 is " + openingQuantityAfterSyncing);
        softAssert.assertAll();
    }

    // with ietmad
    @Test(priority = 6, enabled = false)
    public void TC06_comparingTrialBalanceReport() throws InterruptedException, IOException {

        homePageLink_4 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_4");
        websiteLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "websiteLink_5");
        homePageLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_5");
        random = new Random();
        randomNumber = random.nextInt(1000000000);
        itemCode = "item " + randomNumber;
        softAssert = new SoftAssert();
        homePageObj = new HomePage(driver);
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
        Allure.step(" data at trial balance report at dafater 5  after syncing  ");
        trialBalanceReportPageObj.scrollInsideTable();
        String totalOpeningDebitBalanceAfterSyncing = trialBalanceReportPageObj.getTotalOpeningDebitBalance();
        String totalOpeningCreditBalanceAfterSyncing = trialBalanceReportPageObj.getTotalOpeningCreditBalance();
        String totalDebitBalanceAfterSyncing = trialBalanceReportPageObj.getTotalDebitBalance();
        String totalCreditBalanceAfterSyncing = trialBalanceReportPageObj.getTotalCreditBalance();
        String totalClosingDebitBalanceAfterSyncing = trialBalanceReportPageObj.getTotalClosingDebitBalance();
        String totalClosingCreditBalanceAfterSyncing = trialBalanceReportPageObj.getTotalClosingCreditBalance();

        Allure.step("verify that total opening debit balance value which exist at dafater 5 is equal to total opening debit balance value for the same company and level at dafater 4 ");
        softAssert.assertTrue(totalOpeningDebitBalanceBeforeSyncing.contains(totalOpeningDebitBalanceAfterSyncing));
        Allure.step("total opening debit balance value at dafater 4  before syncing is " + totalOpeningDebitBalanceBeforeSyncing + " and after syncing at dafater 5 is " + totalOpeningDebitBalanceAfterSyncing);
        Allure.step("                          **********************************************************             ");
        Allure.step("verify that total opening credit balance value which exist at dafater 5 is equal to total opening credit balance value for the same company and level at dafater 4 ");
        softAssert.assertTrue(totalOpeningCreditBalanceBeforeSyncing.contains(totalOpeningCreditBalanceAfterSyncing));
        Allure.step("total opening Credit balance value at dafater 4  before syncing is " + totalOpeningCreditBalanceBeforeSyncing + " and after syncing at dafater 5 is " + totalOpeningCreditBalanceAfterSyncing);

        Allure.step("                          **********************************************************             ");
        Allure.step("verify that total debit balance value which exist at dafater 5 is equal to total debit balance value for the same company and level at dafater 4 ");
        softAssert.assertTrue(totalDebitBalanceBeforeSyncing.contains(totalDebitBalanceAfterSyncing));
        Allure.step("total debit balance value at dafater 4  before syncing is " + totalDebitBalanceBeforeSyncing + " and after syncing at dafater 5 is " + totalDebitBalanceAfterSyncing);
        Allure.step("                          **********************************************************             ");
        Allure.step("verify that total  credit balance value which exist at dafater 5 is equal to total credit balance value for the same company and level at dafater 4 ");
        softAssert.assertTrue(totalCreditBalanceBeforeSyncing.contains(totalCreditBalanceAfterSyncing));
        Allure.step("total  Credit balance value at dafater 4  before syncing is " + totalCreditBalanceBeforeSyncing + " and after syncing at dafater 5 is " + totalCreditBalanceAfterSyncing);
        Allure.step("                          **********************************************************             ");
        Allure.step("verify that total closing debit balance value which exist at dafater 5 is equal to total closing debit balance value for the same company and level at dafater 4 ");
        softAssert.assertTrue(totalClosingDebitBalanceBeforeSyncing.contains(totalClosingDebitBalanceAfterSyncing));
        Allure.step("total closing debit balance value at dafater 4  before syncing is " + totalClosingDebitBalanceBeforeSyncing + " and after syncing at dafater 5 is " + totalClosingDebitBalanceAfterSyncing);
        Allure.step("                          **********************************************************             ");
        Allure.step("verify that total closing credit balance value which exist at dafater 5 is equal to total closing credit balance value for the same company and level at dafater 4 ");
        softAssert.assertTrue(totalClosingCreditBalanceBeforeSyncing.contains(totalClosingCreditBalanceAfterSyncing));
        Allure.step("total closing Credit balance value at dafater 4  before syncing is " + totalClosingCreditBalanceBeforeSyncing + " and after syncing at dafater 5 is " + totalClosingCreditBalanceAfterSyncing);
        Allure.step("                          **********************************************************             ");
        softAssert.assertAll();
    }

    //
    @Test(priority = 7, enabled = false)
    public void TC07_comparingBalanceSheetReport() throws InterruptedException, IOException {

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
        Allure.step("profit or loss value in balance sheet report before syncing");
        System.out.println("profit or loss value in balance sheet report before syncing");
        String profitOrLossValueBeforeSyncing = financialStatementsReportPageObj.getProfitOrLossValue().replace(",", "");
        loginPageObj = homePageObj.logOutFromDafater_4(homePageLink_4);
        loginPageObj.switchToDafater_5(websiteLink_5);
        homePageObj = loginPageObj.loginWithValidData(userName_5, password_5);
        reportsListPageObj = homePageObj.openReportsListPage();
        balanceSheetReportPageObj = reportsListPageObj.openBalanceSheetReport_5();
        String filtrationBasedOnOptionName = balanceSheetReportPageObj.applyFilters_5(companyName, yearName);
        String periodNameAtDafater5 = balanceSheetReportPageObj.getPeriodOptionName();
        Assert.assertTrue(filtrationBasedOnOptionName.contains("السنة المالية"));
        Assert.assertTrue(periodNameAtDafater5.contains("سنوى"));
        balanceSheetReportPageObj.loadReportData_5();
//        balanceSheetReportPageObj.scrollInsideTable();
        System.out.println("profit or loss value in balance sheet report after syncing");
        Allure.step("profit or loss value in balance sheet report after syncing");
        String profitOrLossValueAfterSyncing = balanceSheetReportPageObj.getProfitOrLossValue().replace(",", "");
        Allure.step("verify that profit Or Loss value which exist at dafater 5 is equal to profit Or Loss value for the same company and level at dafater 4 ");
        softAssert.assertEquals((long) Double.parseDouble(profitOrLossValueBeforeSyncing.trim()), (long) Double.parseDouble(profitOrLossValueAfterSyncing.trim()));
        Allure.step("profit Or Loss value at dafater 4  before syncing is " + (long) Double.parseDouble(profitOrLossValueBeforeSyncing.trim()) + " and after syncing at dafater 5 is " + (long) Double.parseDouble(profitOrLossValueAfterSyncing.trim()));


        softAssert.assertAll();
    }

    //
    @Test(priority = 8, enabled = false)
    public void TC08_comparingProfitAndLossReport() throws InterruptedException, IOException {

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
        String profitOrLossValueBeforeSyncing = financialStatementsReportPageObj.getProfitOrLossValue().replace(",", "");
        loginPageObj = homePageObj.logOutFromDafater_4(homePageLink_4);
        loginPageObj.switchToDafater_5(websiteLink_5);
        homePageObj = loginPageObj.loginWithValidData(userName_5, password_5);
        reportsListPageObj = homePageObj.openReportsListPage();
        profitAndLossReportPageObj = reportsListPageObj.openProfitAndLossReport_5();
        String filtrationBasedOnOptionName = profitAndLossReportPageObj.applyFilters_5(companyName, yearName);
        String periodNameAtDafater5 = profitAndLossReportPageObj.getPeriodOptionName();
        Assert.assertTrue(filtrationBasedOnOptionName.contains("السنة المالية"));
        Assert.assertTrue(periodNameAtDafater5.contains("سنوى"));
        profitAndLossReportPageObj.loadReportData_5();
//        profitAndLossReportPageObj.scrollInsideTable();
        String profitOrLossValueAfterSyncing = profitAndLossReportPageObj.getProfitOrLossValue().replace(",", "");
        Allure.step("verify that profit Or Loss value which exist at dafater 5 is equal to profit Or Loss value for the same company and level at dafater 4 ");


        softAssert.assertEquals((long) Double.parseDouble(profitOrLossValueBeforeSyncing.trim()), (long) Double.parseDouble(profitOrLossValueAfterSyncing.trim()));
        Allure.step("profit Or Loss value at dafater 4  before syncing is " + (long) Double.parseDouble(profitOrLossValueBeforeSyncing.trim()) + " and after syncing at dafater 5 is " + (long) Double.parseDouble(profitOrLossValueAfterSyncing.trim()));
        softAssert.assertAll();
    }


    @Test(priority = 9, enabled = false)
    public void TC09_comparingGrossProfitReport() throws InterruptedException, IOException {

        homePageLink_4 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_4");
        websiteLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "websiteLink_5");
        homePageLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_5");
        random = new Random();
        randomNumber = random.nextInt(1000000000);
        itemCode = "item " + randomNumber;
        softAssert = new SoftAssert();
        homePageObj = new HomePage(driver);
//        itemListPageObj = homePageObj.openItemListPage();
//        itemPageObj = itemListPageObj.clickOnNewItemBtn_4();
//        itemPageObj.enterValidDataIntoItemPage_4(itemCode);
//
//        Assert.assertTrue(itemPageObj.getItemName(itemCode).contains(itemCode));
//        Allure.step("Verify the name of current created item is existed at item list view ");
//        itemListPageObj = itemPageObj.openItemListPage();
//        Assert.assertTrue(itemListPageObj.getItemNameAtViewList_4(itemCode).trim().contains(itemCode.trim()));
//
//        sellingPriceListsPageObj = itemListPageObj.openSellingPriceLists();
//        sellingPriceListsPageObj.openStandardSellingList();
//        sellingPriceListsPageObj.addingPriceForItem_4(itemCode, itemPrice);

//
//        purchaseReceiptListPageObj = homePageObj.openPurchaseReceiptListPage();
//        purchaseReceiptPage = purchaseReceiptListPageObj.clickOnNewPurchaseReceiptBtn();
//        purchaseReceiptPage.enterValidDataIntoPurchaseReceiptPage_4(itemCode);


//        deliveryNoteListPageObj = homePageObj.openDeliveryNoteListPage();
//        deliveryNotePageObj = deliveryNoteListPageObj.clickOnNewDeliveryNoteBtn();
//        deliveryNotePageObj.enterValidDataIntoDeliveryNotePage_4(itemCode);
//        Allure.step("verify that the  status of created delivery note is submitted  ");
//        Assert.assertTrue(deliveryNotePageObj.getDeliveryNoteStatus_4(submittedStatus).contains(submittedStatus));
//        String deliveryNoteName = deliveryNoteListPageObj.getDeliveryNoteNameAtViewList_4();
        reportsListPageObj = homePageObj.openReportsListPage();
        grossProfitReportPageObj = reportsListPageObj.openGrossProfitReport_4();
        String companyName = grossProfitReportPageObj.getSelectedCompanyName();
        String fromDateValue = grossProfitReportPageObj.getFromDateValue();
        String toDateValue = grossProfitReportPageObj.getToDateValue();

        grossProfitReportPageObj.loadData();
//        String sellingRateValue_4 = grossProfitReportPageObj.getSellingRateValue_4();
//        String avgBuyingValue_4 = grossProfitReportPageObj.getAvgBuyingValue_4();
        Allure.step("values at dafater 4 before Syncing ");
        System.out.println("values at dafater 4 before Syncing ");
        String sellingAmountValue_4 = grossProfitReportPageObj.getSellingAmountValue();
        String buyingAmountValue_4 = grossProfitReportPageObj.getBuyingAmountValue();
        String grossProfitValue_4 = grossProfitReportPageObj.getGrossProfitValue();

        loginPageObj = homePageObj.logOutFromDafater_4(homePageLink_4);
        loginPageObj.switchToDafater_5(websiteLink_5);
        homePageObj = loginPageObj.loginWithValidData(userName_5, password_5);
        reportsListPageObj = homePageObj.openReportsListPage();
        grossProfitReportPageObj = reportsListPageObj.openGrossProfitReport();

        grossProfitReportPageObj.setDatesValueAtDafater_5(fromDateValue, toDateValue);
        grossProfitReportPageObj.setCompanyName(companyName);

        Allure.step("values at dafater 5 after Syncing ");
        System.out.println("values at dafater5  after Syncing ");
        String sellingAmountValue_5 = grossProfitReportPageObj.getSellingAmountValue();
        String buyingAmountValue_5 = grossProfitReportPageObj.getBuyingAmountValue();
        String grossProfitValue_5 = grossProfitReportPageObj.getGrossProfitValue();


        Allure.step("verify that selling amount value which exist at dafater 5 is equal to selling amount value for the same company  at dafater 4 ");
        softAssert.assertTrue(sellingAmountValue_4.contains(sellingAmountValue_5));
        Allure.step("selling amount value at dafater 4  before syncing is " + sellingAmountValue_4 + " and after syncing at dafater 5 is " + sellingAmountValue_5);

        Allure.step("verify that buying amount value which exist at dafater 5 is equal to buying amount value for the same company  at dafater 4 ");
        softAssert.assertTrue(buyingAmountValue_4.contains(buyingAmountValue_5));
        Allure.step("buying amount value at dafater 4  before syncing is " + buyingAmountValue_4 + " and after syncing at dafater 5 is " + buyingAmountValue_5);


        Allure.step("verify that gross profit value which exist at dafater 5 is equal to gross profit value for the same company  at dafater 4 ");
        softAssert.assertTrue(grossProfitValue_4.contains(grossProfitValue_5));
        Allure.step("gross profit value at dafater 4  before syncing is " + grossProfitValue_4 + " and after syncing at dafater 5 is " + grossProfitValue_5);

        softAssert.assertAll();
    }

    @Test(priority = 10, enabled = true)
    public void TC010_comparingSupplierAgingDetailsReport() throws InterruptedException, IOException {

        homePageLink_4 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_4");
        websiteLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "websiteLink_5");
        homePageLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_5");
        random = new Random();
        randomNumber = random.nextInt(1000000000);
        itemCode = "item " + randomNumber;
        softAssert = new SoftAssert();
        homePageObj = new HomePage(driver);
        reportsListPageObj = homePageObj.openReportsListPage();
        supplierAgingDetailsPageObj = reportsListPageObj.openSupplierAgingDetailsReport();
        String companyName = supplierAgingDetailsPageObj.getSelectedCompanyName();
        supplierAgingDetailsPageObj.loadReportData_4();
        String invoicedAmountValue_4 = supplierAgingDetailsPageObj.getInvoicedAmountValue_4().replace(",", "");
        String outstandingAmountValue_4 = supplierAgingDetailsPageObj.getOutstandingAmountValue_4().replace(",", "");
        loginPageObj = homePageObj.logOutFromDafater_4(homePageLink_4);
        loginPageObj.switchToDafater_5(websiteLink_5);
        homePageObj = loginPageObj.loginWithValidData(userName_5, password_5);
        reportsListPageObj = homePageObj.openReportsListPage();
        supplierAgingDetailsPageObj = reportsListPageObj.openSupplierAgingDetailsReport();
        supplierAgingDetailsPageObj.applyFilters_5(companyName);
        String invoicedAmountValue_5 = supplierAgingDetailsPageObj.getInvoicedAmountValue().replace(",", "");
        String outstandingAmountValue_5 = supplierAgingDetailsPageObj.getTotalOutstandingAmountAfterSyncing().replace(",", "");

        softAssert.assertEquals((long) Double.parseDouble(invoicedAmountValue_4.trim()), (long) Double.parseDouble(invoicedAmountValue_5.trim()));
        softAssert.assertEquals((long) Double.parseDouble(outstandingAmountValue_4.trim()), (long) Double.parseDouble(outstandingAmountValue_5.trim()));
        softAssert.assertAll();


    }

    @Test(priority = 11, enabled = false)
    public void TC011_comparingSalesPersonDetailedReport() throws InterruptedException, IOException {

        homePageLink_4 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_4");
        websiteLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "websiteLink_5");
        homePageLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_5");
        random = new Random();
        randomNumber = random.nextInt(1000000000);
        itemCode = "item " + randomNumber;
        softAssert = new SoftAssert();
        homePageObj = new HomePage(driver);
        reportsListPageObj = homePageObj.openReportsListPage();
        salesPersonDetailedReportObj = reportsListPageObj.openSalesPersonDetailedReport_4();
        String companyName = salesPersonDetailedReportObj.getSelectedCompanyName();
        String fromDateValue = salesPersonDetailedReportObj.getFromDateValue();
        String toDateValue = salesPersonDetailedReportObj.getToDateValue();
        salesPersonDetailedReportObj.loadReportData_4();
        Allure.step("collected amount value at dafater 4 before Syncing ");
        System.out.println("collected amount value at dafater 4 before Syncing ");
        String collectedAmountValue_4 = salesPersonDetailedReportObj.getCollectedAmountValue();

        loginPageObj = homePageObj.logOutFromDafater_4(homePageLink_4);
        loginPageObj.switchToDafater_5(websiteLink_5);
        homePageObj = loginPageObj.loginWithValidData(userName_5, password_5);
        reportsListPageObj = homePageObj.openReportsListPage();
        salesPersonDetailedReportObj = reportsListPageObj.openSalesPersonDetailedReport_5();
        salesPersonDetailedReportObj.setDatesValueAtDafater_5(fromDateValue, toDateValue);
        salesPersonDetailedReportObj.setCompanyName(companyName);

        Allure.step("collected amount value at dafater 5 after Syncing ");
        System.out.println("collected amount value at dafater 5 after Syncing ");
        String collectedAmountValue_5 = salesPersonDetailedReportObj.getCollectedAmountValue();
        Allure.step("verify that ollected amount value which exist at dafater 5 is equal to collected amount value for the same company  at dafater 4 ");
        softAssert.assertTrue(collectedAmountValue_4.contains(collectedAmountValue_5));
        Allure.step("ollected amount value at dafater 4  before syncing is " + collectedAmountValue_4 + " and after syncing at dafater 5 is " + collectedAmountValue_5);
        softAssert.assertAll();
    }

    @Test(priority = 12, enabled = false)
    public void TC012_comparingMonthlySalaryRegisterReport() throws InterruptedException, IOException {

        homePageLink_4 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_4");
        websiteLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "websiteLink_5");
        homePageLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_5");
        random = new Random();
        randomNumber = random.nextInt(1000000000);
        itemCode = "item " + randomNumber;
        softAssert = new SoftAssert();
        homePageObj = new HomePage(driver);

        reportsListPageObj = homePageObj.openReportsListPage();
        monthlySalaryRegisterReportPageObj = reportsListPageObj.openMonthlySalaryRegisterReport_4();
       String currentYear =  monthlySalaryRegisterReportPageObj.chooseYear();


        // wait data to complete my implemntation for this report ************************************************


        String openingValueBeforeSyncing = monthlySalaryRegisterReportPageObj.getOpeningValueFromStockBalance_4();

        loginPageObj = homePageObj.logOutFromDafater_4(homePageLink_4);
        loginPageObj.switchToDafater_5(websiteLink_5);
        homePageObj = loginPageObj.loginWithValidData(userName_5, password_5);
        reportsListPageObj = homePageObj.openReportsListPage();
        monthlySalaryRegisterReportPageObj = reportsListPageObj.openMonthlySalaryRegisterReport_5();

        monthlySalaryRegisterReportPageObj.applyFilters_5(currentYear);
//        String openingValueAfterSyncing = stockBalanceReportPageObj.getOpeningValueFromStockBalance_5();
//        String openingQuantityAfterSyncing = stockBalanceReportPageObj.getOpeningQuantityFromStockBalance_5();
//        Allure.step("verify that opening value for this warehouse " + wareHouseName + "  which exist at dafater 5 is equal to opening value for the same warehouse at dafater 4 ");
//        softAssert.assertTrue(openingValueBeforeSyncing.contains(openingValueAfterSyncing));
//        Allure.step("opening value at dafater 4  before syncing is " + openingValueBeforeSyncing + " and after syncing at dafater 5 is " + openingValueAfterSyncing);
//        Allure.step("verify that opening quantity for this warehouse " + wareHouseName + "  which exist at dafater 5 is equal to opening quantity for the same warehouse at dafater 4 ");
//        softAssert.assertTrue(openingQuantityBeforeSyncing.contains(openingQuantityAfterSyncing));
//        Allure.step("opening quantity at dafater 4  before syncing is " + openingQuantityBeforeSyncing + " and after syncing at dafater 5 is " + openingQuantityAfterSyncing);
//        softAssert.assertAll();
    }


    @Test(priority = 13, enabled = false)
    public void TC013_comparingEmployeeLeaveBalanceReport() throws InterruptedException, IOException {

        homePageLink_4 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_4");
        websiteLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "websiteLink_5");
        homePageLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_5");
        random = new Random();
        randomNumber = random.nextInt(1000000000);
        itemCode = "item " + randomNumber;
        softAssert = new SoftAssert();
        homePageObj = new HomePage(driver);

        reportsListPageObj = homePageObj.openReportsListPage();
        employeeLeaveBalanceReportPageObj = reportsListPageObj.openEmployeeLeaveBalanceReport_4();
        String currentYear =  employeeLeaveBalanceReportPageObj.chooseYear();



        // wait data to complete my implemntation for this report ******************************************************


//        String openingValueBeforeSyncing = employeeLeaveBalanceReportPageObj.getOpeningValueFromStockBalance_4();

        loginPageObj = homePageObj.logOutFromDafater_4(homePageLink_4);
        loginPageObj.switchToDafater_5(websiteLink_5);
        homePageObj = loginPageObj.loginWithValidData(userName_5, password_5);
        reportsListPageObj = homePageObj.openReportsListPage();
        employeeLeaveBalanceReportPageObj = reportsListPageObj.openEmployeeLeaveBalanceReportPage_5();

        monthlySalaryRegisterReportPageObj.applyFilters_5(currentYear);
//        String openingValueAfterSyncing = stockBalanceReportPageObj.getOpeningValueFromStockBalance_5();
//        String openingQuantityAfterSyncing = stockBalanceReportPageObj.getOpeningQuantityFromStockBalance_5();
//        Allure.step("verify that opening value for this warehouse " + wareHouseName + "  which exist at dafater 5 is equal to opening value for the same warehouse at dafater 4 ");
//        softAssert.assertTrue(openingValueBeforeSyncing.contains(openingValueAfterSyncing));
//        Allure.step("opening value at dafater 4  before syncing is " + openingValueBeforeSyncing + " and after syncing at dafater 5 is " + openingValueAfterSyncing);
//        Allure.step("verify that opening quantity for this warehouse " + wareHouseName + "  which exist at dafater 5 is equal to opening quantity for the same warehouse at dafater 4 ");
//        softAssert.assertTrue(openingQuantityBeforeSyncing.contains(openingQuantityAfterSyncing));
//        Allure.step("opening quantity at dafater 4  before syncing is " + openingQuantityBeforeSyncing + " and after syncing at dafater 5 is " + openingQuantityAfterSyncing);
//        softAssert.assertAll();
    }

}
