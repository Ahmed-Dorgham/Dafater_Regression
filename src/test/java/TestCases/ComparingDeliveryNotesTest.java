package TestCases;

import Pages.*;
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

    @Test(priority = 1, enabled = true)
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


}
