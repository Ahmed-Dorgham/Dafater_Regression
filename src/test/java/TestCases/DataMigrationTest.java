package TestCases;

import Pages.DataMigrationToolPage;
import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataMigrationTest extends BaseTest {
    LoginPage loginPageObj;
    HomePage homePageObj;
    DataMigrationToolPage dataMigrationToolPageObj;
    private final String vmUrl = "temp-wi28927.dafater.biz";
    private final String clientKey = "temp-wi28927";
    private final String secretKey = "kX7NY9yMSag3";
    private final String invalidSecretKey = "kX7NY9yMSag4";
    private final String successfulConnectionMsg = "Connected Successfully";
    private final String failureConnectionMsg = "Cannot Connect";
    private final String syncingMsg = "Enqueued Sync Data Method in Background";

    @Test(priority = 1)
    public void TC01_checkSuccessVmConnection() {
        homePageObj = new HomePage(driver);
        dataMigrationToolPageObj = homePageObj.searchAboutDataMigrationTool();
        dataMigrationToolPageObj.enterValidDataIntoMainData(vmUrl, clientKey, secretKey);
        dataMigrationToolPageObj.clickOnCheckVmConnectionBtn();
        Assert.assertTrue(dataMigrationToolPageObj.checkStatusMsg().getText().contains(successfulConnectionMsg));

    }

    @Test(priority = 2)
    public void TC02_checkFailureVmConnection() {
        homePageObj = new HomePage(driver);

        dataMigrationToolPageObj = homePageObj.searchAboutDataMigrationTool();
        dataMigrationToolPageObj.enterValidDataIntoMainData(vmUrl, clientKey, invalidSecretKey);
        dataMigrationToolPageObj.clickOnCheckVmConnectionBtn();
        Assert.assertTrue(dataMigrationToolPageObj.checkStatusMsg().getText().contains(failureConnectionMsg));

    }

    @Test(priority = 3)
    public void TC03_syncDocTypesData() {
        homePageObj = new HomePage(driver);

        dataMigrationToolPageObj = homePageObj.searchAboutDataMigrationTool();
        dataMigrationToolPageObj.enterValidDataIntoMainData(vmUrl, clientKey, invalidSecretKey);
        dataMigrationToolPageObj.selectAllDocTypes();
        dataMigrationToolPageObj.clickOnSyncDocTypesDataBtn();
        Assert.assertTrue(dataMigrationToolPageObj.checkStatusMsg().getText().contains(syncingMsg));

    }
}
