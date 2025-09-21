package TestCases;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.Random;

public class ComparingCompaniesTest extends BaseTest {
    Random random;
    int randomNumber;
    String itemCode;
    SoftAssert softAssert;

    LoginPage loginPageObj;
    HomePage homePageObj;

    CompaniesListPage companiesListPageOj;

    @Test(priority = 1, enabled = true)
    public void TC01_comparingNumberOfCompanies() throws InterruptedException, IOException {

        homePageLink_4 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_4");
        websiteLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "websiteLink_5");
        homePageLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_5");
        random = new Random();
        randomNumber = random.nextInt(1000000000);
        itemCode = "item " + randomNumber;
        softAssert = new SoftAssert();
        homePageObj = new HomePage(driver);
        companiesListPageOj = homePageObj.openCompaniesListPage();
        String numberOfAllTotalCompaniesBeforeSyncing = companiesListPageOj.getNumberOfAllCompaniesBeforeSyncing();
        loginPageObj = homePageObj.logOutFromDafater_4(homePageLink_4);
        loginPageObj.switchToDafater_5(websiteLink_5);
        homePageObj = loginPageObj.loginWithValidData(userName_5, password_5);
        companiesListPageOj = homePageObj.openCompaniesListPage();

        String numberOfAllCompaniesAfterSyncing = companiesListPageOj.getNumberOfAllCompaniesAfterSyncing();

        System.out.println("verify that number of all companies which appear at dafater 5 is equal to number of all companies at dafater 4 ");

        Assert.assertEquals(numberOfAllTotalCompaniesBeforeSyncing, numberOfAllCompaniesAfterSyncing);

        System.out.println(" number of companies which appear at dafater 5 is " + numberOfAllCompaniesAfterSyncing+" and number of all companies at dafater 4 is "+ numberOfAllTotalCompaniesBeforeSyncing +" and this is correct ");

    }


}
