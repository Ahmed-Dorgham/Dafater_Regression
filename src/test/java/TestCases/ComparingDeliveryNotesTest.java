package TestCases;

import GeneralConstants.GeneralConstants;
import Pages.DeliveryNoteListPage;
import Pages.DeliveryNotePage;
import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.Random;

public class ComparingDeliveryNotesTest extends BaseTest {
    Random random;
    int randomNumber;
    String itemCode;
    SoftAssert softAssert;

    LoginPage loginPageObj;
    HomePage homePageObj;
    DeliveryNoteListPage deliveryNoteListPageObj;
    DeliveryNotePage deliveryNotePageObj;
    private final String submittedStatus = "معتمد";
    private final String draftStatus = "مسودة";

    @Test(priority = 1, enabled = false)
    public void TC01_comparingNumberOfDeliveryNotes() throws InterruptedException, IOException {

        homePageLink_4 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_4");
        websiteLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "websiteLink_5");
        homePageLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_5");
        random = new Random();
        randomNumber = random.nextInt(1000000000);
        itemCode = "item " + randomNumber;
        softAssert = new SoftAssert();
        homePageObj = new HomePage(driver);
        deliveryNoteListPageObj = homePageObj.openDeliveryNoteListPage();
        String numberOfAllDeliveryNotesBeforeSyncing = deliveryNoteListPageObj.getNumberOfAllDeliveryNotesBeforeSyncing();
        loginPageObj = homePageObj.logOutFromDafater_4(homePageLink_4);
        loginPageObj.switchToDafater_5(websiteLink_5);
        homePageObj = loginPageObj.loginWithValidData(userName_5, password_5);
        deliveryNoteListPageObj = homePageObj.openDeliveryNoteListPage();
        String numberOfAllDeliveryNotesAfterSyncing = deliveryNoteListPageObj.getNumberOfAllDeliveryNotesAfterSyncing();
        System.out.println("verify that number of all delivery notes which appear at dafater 5 is equal to number of all items at dafater 4 ");
        softAssert.assertEquals(numberOfAllDeliveryNotesBeforeSyncing, numberOfAllDeliveryNotesAfterSyncing);
        softAssert.assertAll();
        System.out.println(" number of delivery notes which appear at dafater 5 is " + numberOfAllDeliveryNotesAfterSyncing + " and number of all  delivery notes at dafater 4 is " + numberOfAllDeliveryNotesBeforeSyncing + " and this is correct ");

    }

    @Test(priority = 2, enabled = true)
    public void TC02_comparingDeliveryNotesData() throws InterruptedException, IOException {
        String deliveryNoteStatusBeforeSyncing = null;
        String deliveryNoteStatusAfterSyncing = null;
        String salesInvoicePaidStatusBeforeSyncing = null;
        String salesInvoicePaidStatusAfterSyncing = null;
        String deliveryNoteIssueDateAfterSyncing = null;
        String deliveryNoteIssueDateBeforeSyncing = null;
        String customerNameAtDeliveryNoteBeforeSyncing = null;
        String customerNameAtDeliveryNoteAfterSyncing = null;
        String netTotalValueBeforeSyncing = null;
        String grandTotalValueBeforeSyncing = null;
        String netTotalValueAfterSyncing = null;
        String grandTotalValueAfterSyncing = null;

        homePageLink_4 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_4");
        websiteLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "websiteLink_5");
        homePageLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_5");
        random = new Random();
        randomNumber = random.nextInt(1000000000);
        itemCode = "item " + randomNumber;
        softAssert = new SoftAssert();
        homePageObj = new HomePage(driver);
        deliveryNoteListPageObj = homePageObj.openDeliveryNoteListPage();
        String nameOfSelectedDeliveryNoteAtDafater_4 = deliveryNoteListPageObj.getNameOfFirstDeliverNoteBeforeSyncing();
        deliveryNotePageObj = deliveryNoteListPageObj.openFirstDeliveryNoteAtDafater_4();


        if (deliveryNotePageObj.getDeliveryNoteStatus().contains(submittedStatus)) {
            System.out.println("status of  delivery note is  " + submittedStatus);
            deliveryNoteStatusBeforeSyncing = deliveryNotePageObj.getDeliveryNoteStatus();
            deliveryNoteIssueDateBeforeSyncing = deliveryNotePageObj.getDeliveryNoteIssueDate();
            customerNameAtDeliveryNoteBeforeSyncing = deliveryNotePageObj.getCustomerNameAtDeliveryNote();
            netTotalValueBeforeSyncing = deliveryNotePageObj.getNetTotalValueAtSalesInvoice();
            grandTotalValueBeforeSyncing = deliveryNotePageObj.getGrandTotalValueAtSalesInvoice();
        }

        loginPageObj = homePageObj.logOutFromDafater_4(homePageLink_4);
        loginPageObj.switchToDafater_5(websiteLink_5);
        homePageObj = loginPageObj.loginWithValidData(userName_5, password_5);
        deliveryNoteListPageObj = homePageObj.openDeliveryNoteListPage();
        Assert.assertTrue(deliveryNoteListPageObj.searchAboutSpecificDeliveryNote(nameOfSelectedDeliveryNoteAtDafater_4).equals(GeneralConstants.SUCCESS));



        if (deliveryNotePageObj.getDeliveryNoteStatus().contains(submittedStatus)) {
            System.out.println("status of delivery note is  " + submittedStatus);
            deliveryNoteStatusAfterSyncing = deliveryNotePageObj.getSalesInvoiceStatusAtDafater_5();

            deliveryNoteIssueDateAfterSyncing = deliveryNotePageObj.getDeliveryNoteIssueDate();
            customerNameAtDeliveryNoteAfterSyncing = deliveryNotePageObj.getCustomerNameAtDeliveryNoteAtDafater_5();
            netTotalValueAfterSyncing = deliveryNotePageObj.getNetTotalValueAtSalesInvoice();
            grandTotalValueAfterSyncing = deliveryNotePageObj.getGrandTotalValueAtSalesInvoice();
        }



    }

}
