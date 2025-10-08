package TestCases;

import GeneralConstants.GeneralConstants;
import Pages.DataMigrationToolPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.SetupWizardPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataMigrationTest extends BaseTest {
    LoginPage loginPageObj;
    HomePage homePageObj;
    SetupWizardPage setupWizardPageObj;
    DataMigrationToolPage dataMigrationToolPageObj;
    private final String vmUrl = "mss-v4.dafater.biz";
    private final String clientKey = "mss-v4";
    private final String secretKey = "3zFG68L4T89";
    private final String invalidSecretKey = "kX7NY9yMSag4";
    private final String successfulConnectionMsg = "Connected Successfully";
    private final String failureConnectionMsg = "Cannot Connect";
    private final String syncingMsg = "Enqueued Sync Data Method in Background";


    @Test(priority = 1, enabled = false)
    public void TC01_setupVm() {
        homePageObj = new HomePage(driver);
        setupWizardPageObj = new SetupWizardPage(driver);
        if (tryToGetWebElement(setupWizardPageObj.countryField) == GeneralConstants.SUCCESS) {
            System.out.println(" setup Vm  ");
            setupWizardPageObj = new SetupWizardPage(driver);
            setupWizardPageObj.enterDefaultVMData();
            setupWizardPageObj.setupAccount();
            setupWizardPageObj.setupOrganization(companyName, companyIdValue, taxIdValue, cityName, addressName, phoneValue);
        }
        waitUntilElementToBePresent(homePageObj.salesInvoicesTab, GeneralConstants.globalTimeOut);
    }

    //    @Test(priority = 1,enabled = true,dependsOnMethods = "TC01_setupVm")
    @Test(priority = 2, enabled = true)
    public void TC02_checkSuccessVmConnection() {
        homePageObj = new HomePage(driver);
        dataMigrationToolPageObj = homePageObj.searchAboutDataMigrationTool();
        dataMigrationToolPageObj.enterValidDataIntoMainData(vmUrl, clientKey, secretKey);
        dataMigrationToolPageObj.clickOnCheckVmConnectionBtn();
        Assert.assertTrue(dataMigrationToolPageObj.checkStatusMsg().getText().contains(successfulConnectionMsg));
    }

    @Test(priority = 3, enabled = true)
    public void TC03_syncDocTypesData() {
        homePageObj = new HomePage(driver);

        dataMigrationToolPageObj = homePageObj.searchAboutDataMigrationTool();
        dataMigrationToolPageObj.enterValidDataIntoMainData(vmUrl, clientKey, invalidSecretKey);
        dataMigrationToolPageObj.selectAllDocTypes();
        dataMigrationToolPageObj.clickOnSyncDocTypesDataBtn();
        Assert.assertTrue(dataMigrationToolPageObj.checkStatusMsg().getText().contains(syncingMsg));

    }

    @Test(priority = 4, enabled = true)
    public void TC04_checkFailureVmConnection() {
        homePageObj = new HomePage(driver);

        dataMigrationToolPageObj = homePageObj.searchAboutDataMigrationTool();
        dataMigrationToolPageObj.enterValidDataIntoMainData(vmUrl, clientKey, invalidSecretKey);
        dataMigrationToolPageObj.clickOnCheckVmConnectionBtn();
        Assert.assertTrue(dataMigrationToolPageObj.checkStatusMsg().getText().contains(failureConnectionMsg));

    }


}
