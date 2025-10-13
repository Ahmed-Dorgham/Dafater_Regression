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
    private final String vmUrl = "almorished-v4.dafater.biz";
    private final String clientKey = "almorished-v4";
    private final String secretKey = "3zFG68L4T89";
    private final String invalidSecretKey = "kX7NY9yMSag4";
    private final String successfulConnectionMsg = "Connected Successfully";
    private final String failureConnectionMsg = "Cannot Connect";
    private final String syncingMsg = "Enqueued Sync Data Method in Background";


    //    @Test(priority = 1,enabled = true,dependsOnMethods = "TC01_setupVm")
    @Test(priority = 1, enabled = true)
    public void TC01_checkSuccessVmConnection() {
        homePageObj = new HomePage(driver);
        dataMigrationToolPageObj = homePageObj.searchAboutDataMigrationTool();
        dataMigrationToolPageObj.enterValidDataIntoMainData(vmUrl, clientKey, secretKey);
        dataMigrationToolPageObj.clickOnCheckVmConnectionBtn();
        Assert.assertTrue(dataMigrationToolPageObj.checkStatusMsg().getText().contains(successfulConnectionMsg));
    }

    @Test(priority = 2, enabled = true)
    public void TC02_syncDocTypesData() {
        homePageObj = new HomePage(driver);

        dataMigrationToolPageObj = homePageObj.searchAboutDataMigrationTool();
        dataMigrationToolPageObj.enterValidDataIntoMainData(vmUrl, clientKey, invalidSecretKey);
        dataMigrationToolPageObj.selectAllDocTypes();
        dataMigrationToolPageObj.clickOnSyncDocTypesDataBtn();
        Assert.assertTrue(dataMigrationToolPageObj.checkStatusMsg().getText().contains(syncingMsg));

    }

    @Test(priority = 3, enabled = true)
    public void TC03_checkFailureVmConnection() {
        homePageObj = new HomePage(driver);

        dataMigrationToolPageObj = homePageObj.searchAboutDataMigrationTool();
        dataMigrationToolPageObj.enterValidDataIntoMainData(vmUrl, clientKey, invalidSecretKey);
        dataMigrationToolPageObj.clickOnCheckVmConnectionBtn();
        Assert.assertTrue(dataMigrationToolPageObj.checkStatusMsg().getText().contains(failureConnectionMsg));

    }


}
