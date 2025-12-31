package TestCases;

import Pages.DataMigrationToolPage;
import Pages.HomePage;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataMigrationTest extends BaseTest {
    HomePage homePageObj;
    DataMigrationToolPage dataMigrationToolPageObj;
        private final String vmUrl = "mashraqicompany-v4.dafater.biz";
//        private final String vmUrl = "saber-v4.dafater.biz";
//        private final String vmUrl = "almorished-v4.dafater.biz";
//        private final String vmUrl = "bawabatalshifa-v4.dafater.biz";
//    private final String vmUrl = "nukhba-v4.dafater.biz";
//    private final String vmUrl = "misaha-v4.dafater.biz";
//    private final String vmUrl = "exact-standard-v4.dafater.biz";
    //    private final String vmUrl = "amar-v4.dafater.biz";
//    private final String vmUrl = "mss-v4.dafater.biz";
//    private final String vmUrl = "arrabtel-v4.dafater.biz";
//    private final String clientKey = "mashraqicompany-v4";
//        private final String clientKey = "nukhba-v4";
    //    private final String clientKey = "amar-v4";
//        private final String clientKey = "tarkibat-v4";
//        private final String clientKey = "gscce-v4";
//        private final String clientKey = "exact-standard-v4";
//        private final String clientKey = "bluediamond-v4";
//        private final String clientKey = "hmce-v4";
        private final String clientKey = "ctoe-v4";
//        private final String clientKey = "misaha-v4";
//    private final String clientKey = "bawabatalshifa-v4";
//    private final String clientKey = "mss-v4";
//    private final String clientKey = "arrabtel-v4";
//    private final String clientKey = "saber-v4";
    //    private final String clientKey = "almorished-v4";
    private final String secretKey = "3zFG68L4T89";

    private final String invalidSecretKey = "kX7NY9yMSag4";
    private final String successfulConnectionMsg = "Connected Successfully";
    private final String failureConnectionMsg = "Cannot Connect";
    private final String syncingMsg = "Enqueued Sync Data Method in Background";

    @Test(priority = 1, enabled = false)
    public void TC01_checkFailureVmConnection() {
        homePageObj = new HomePage(driver);
        AllureLifecycle lifecycle = Allure.getLifecycle();
        lifecycle.updateTestCase(testResult -> testResult.setName("TC03_checkFailureVmConnection"));
        dataMigrationToolPageObj = homePageObj.searchAboutDataMigrationTool();
        dataMigrationToolPageObj.enterValidDataIntoMainData(vmUrl, clientKey, invalidSecretKey);
        dataMigrationToolPageObj.clickOnCheckVmConnectionBtn();
        Assert.assertTrue(dataMigrationToolPageObj.checkStatusMsg().getText().contains(failureConnectionMsg));

    }

    @Test(priority = 2, enabled = false)
    public void TC02_checkSuccessVmConnection() {
        homePageObj = new HomePage(driver);
        AllureLifecycle lifecycle = Allure.getLifecycle();
        lifecycle.updateTestCase(testResult -> testResult.setName("TC01_checkSuccessVmConnection"));
        dataMigrationToolPageObj = homePageObj.searchAboutDataMigrationTool();
        dataMigrationToolPageObj.enterValidDataIntoMainData(vmUrl, clientKey, secretKey);
        dataMigrationToolPageObj.clickOnCheckVmConnectionBtn();
        Assert.assertTrue(dataMigrationToolPageObj.checkStatusMsg().getText().contains(successfulConnectionMsg));
    }

    @Test(priority = 3, enabled = true)
    public void TC03_syncDocTypesData() {
        homePageObj = new HomePage(driver);
        AllureLifecycle lifecycle = Allure.getLifecycle();
        lifecycle.updateTestCase(testResult -> testResult.setName("TC02_syncDocTypesData"));
        dataMigrationToolPageObj = homePageObj.searchAboutDataMigrationTool();
        dataMigrationToolPageObj.enterValidDataIntoMainData(vmUrl, clientKey, secretKey);
//        dataMigrationToolPageObj.selectAllDocTypes();
        dataMigrationToolPageObj.clickOnSyncDocTypesDataBtn();
        Assert.assertTrue(dataMigrationToolPageObj.checkStatusMsg().getText().contains(syncingMsg));

    }


}
