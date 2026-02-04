package TestCases;

import GeneralConstants.GeneralConstants;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.SetupWizardPage;
import io.qameta.allure.Allure;
import org.testng.annotations.Test;

public class SetupVmTest extends BaseTest {
    LoginPage loginPageObj;
    HomePage homePageObj;
    SetupWizardPage setupWizardPageObj;
//test

    @Test(priority = 1, enabled = true)
    public void TC01_setupVm() {
        homePageObj = new HomePage(driver);
        setupWizardPageObj = new SetupWizardPage(driver);
        if (tryToGetWebElementV(setupWizardPageObj.countryField) == GeneralConstants.SUCCESS) {
            Allure.step(" setup Vm  ");
            setupWizardPageObj = new SetupWizardPage(driver);
            setupWizardPageObj.enterDefaultVMData();
            setupWizardPageObj.setupAccount();
            setupWizardPageObj.setupOrganization("testCompany", companyIdValue, taxIdValue, cityName, addressName, phoneValue);
        }
        waitUntilElementToBePresent(homePageObj.salesInvoicesTab, GeneralConstants.globalTimeOut);
    }

}
