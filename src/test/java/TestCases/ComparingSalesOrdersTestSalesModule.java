package TestCases;

import GeneralConstants.GeneralConstants;
import Pages.*;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.Random;

public class ComparingSalesOrdersTestSalesModule extends BaseTest {
    Random random;
    int randomNumber;
    String itemCode;
    SoftAssert softAssert;
    LoginPage loginPageObj;
    HomePage homePageObj;
    SalesOrderListPage salesOrdersListPageObj;
    CreditNotePage creditNotePageObj;


    private final String zatcaStatus = "تم الارسال الي هيئة الزكاة والدخل بنجاح";
    private final String submittedStatus = "معتمد";
    private final String draftStatus = "مسودة";
    ItemListPage itemListPageObj;

    @Test(priority = 1, enabled = true)
    public void TC01_comparingSalesOrdersDataAtListViewSalesModule() throws InterruptedException, IOException {

        homePageLink_4 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_4");
        websiteLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "websiteLink_5");
        homePageLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_5");
        random = new Random();
        randomNumber = random.nextInt(1000000000);
        itemCode = "item " + randomNumber;
        softAssert = new SoftAssert();
        homePageObj = new HomePage(driver);
        salesOrdersListPageObj = homePageObj.openSalesOrdersListPage();
        String numberOfAllSalesOrdersBeforeSyncing = salesOrdersListPageObj.getNumberOfAllSalesOrdersBeforeSyncing();




//        String numberOfDraftCreditNotesBeforeSyncing = salesOrdersListPageObj.getNumberOfDraftCreditNotesBeforeSyncing();
//        salesOrdersListPageObj.filterWithSubmittedStatus_2();
//        double valueOfTotalInvoicesAtCreditNotesListViewBeforeSyncingAsNumber = salesOrdersListPageObj.getValueOfTotalInvoicesBeforeSyncing();
//        String valueOfTotalInvoicesAtCreditNotesListViewBeforeSyncing = salesOrdersListPageObj.convertToStringFormat(valueOfTotalInvoicesAtCreditNotesListViewBeforeSyncingAsNumber);
//        driver.navigate().refresh();
//        salesOrdersListPageObj.filterWithSubmittedStatus_2();
//        double valueOfOutstandingAmountAtCreditNotesListViewBeforeSyncingAsNumber = salesOrdersListPageObj.getValueOfOutstandingAmountBeforeSyncing();
//        String valueOfOutstandingAmountAtCreditNotesListViewBeforeSyncing =  salesOrdersListPageObj.convertToStringFormat(valueOfOutstandingAmountAtCreditNotesListViewBeforeSyncingAsNumber);
//
//
//        double totalPaymentReceivedOfCreditNotesBeforeSyncingAsNumber = valueOfTotalInvoicesAtCreditNotesListViewBeforeSyncingAsNumber - valueOfOutstandingAmountAtCreditNotesListViewBeforeSyncingAsNumber;
//        String totalPaymentReceivedOfCreditNotesBeforeSyncing =  salesOrdersListPageObj.convertToStringFormat(totalPaymentReceivedOfCreditNotesBeforeSyncingAsNumber);
//
//
//        System.out.println("total PaymentReceived Of credit Notes Before Syncing is "+totalPaymentReceivedOfCreditNotesBeforeSyncingAsNumber);
//
//
//
        loginPageObj = homePageObj.logOutFromDafater_4(homePageLink_4);
        loginPageObj.switchToDafater_5(websiteLink_5);
        homePageObj = loginPageObj.loginWithValidData(userName_5, password_5);
        salesOrdersListPageObj = homePageObj.openSalesOrdersListPage();
        String numberOfAllSalesOrdersAfterSyncing = salesOrdersListPageObj.getNumberOfAllSalesOrdersAfterSyncing();


//        salesOrdersListPageObj.filterDocTypesWithSecondFilterByVisibleText("حالة", "معتمد");
//
//        String numberOfAllCreditNotesAfterSyncing = salesOrdersListPageObj.getNumberOfAllCreditNotesAfterSyncing();
//        String numberOfDraftCreditNotesAfterSyncing = salesOrdersListPageObj.getNumberOfDraftCreditNotesAfterSyncing();
//        String valueOfTotalInvoicesAtCreditNotesListViewAfterSyncing = salesOrdersListPageObj.getValueOfTotalInvoicesAfterSyncing();
//        String valueOfOutstandingAmountAtCreditNotesListViewAfterSyncing = salesOrdersListPageObj.getValueOfOutstandingAmountAfterSyncing();
//        String valueOfPaymentReceivedAtCreditNotesListViewAfterSyncing = salesOrdersListPageObj.getTotalPaymentReceivedAmountOfCreditNotesAfterSyncing();
////
//
//        System.out.println("verify that number of all credit notes which appear at dafater 5 is equal to number of all credit notes at dafater 4");
//        softAssert.assertEquals(numberOfAllSalesOrdersBeforeSyncing, numberOfAllCreditNotesAfterSyncing);
//
//        System.out.println("verify that number of draft credit notes which appear at dafater 5 is equal to number of draft credit notes at dafater 4");
//        softAssert.assertEquals(numberOfDraftCreditNotesBeforeSyncing, numberOfDraftCreditNotesAfterSyncing);
//
//        System.out.println("verify that value Of Total Invoices At Credit Notes List View which appear at dafater 5 is equal to value Of Total Invoices At Credit Notes List View at dafater 4");
//        softAssert.assertTrue(valueOfTotalInvoicesAtCreditNotesListViewBeforeSyncing.equalsIgnoreCase(valueOfTotalInvoicesAtCreditNotesListViewAfterSyncing));
//
//        System.out.println("verify that value Of outstanding amount At Credit Notes List View which appear at dafater 5 is equal to value Of outstanding amount At Credit Notes List View at dafater 4");
//        softAssert.assertTrue(valueOfOutstandingAmountAtCreditNotesListViewBeforeSyncing.equalsIgnoreCase(valueOfOutstandingAmountAtCreditNotesListViewAfterSyncing));
//
//        System.out.println("verify that value Of payment received At Credit Notes List View which appear at dafater 5 is equal to value Of payment received At Credit Notes List View at dafater 4");
//
//
//        softAssert.assertTrue(valueOfPaymentReceivedAtCreditNotesListViewAfterSyncing.equalsIgnoreCase(totalPaymentReceivedOfCreditNotesBeforeSyncing));
//
//        softAssert.assertAll();
    }

    //, dependsOnMethods = "TC01_comparingCreditNotesDataAtListView"
    //
//    @Test(priority = 2, enabled = false)
//    public void TC02_comparingSpeceficCreditNoteDataSalesModule() throws InterruptedException, IOException {
//        homePageObj = new HomePage(driver);
////        salesOrdersListPageObj = homePageObj.openCreditNotesSalesModuleListPage();
//
//
//        String numberOfCreditNotesBeforeSyncing = salesOrderListPageObj.getNumberOfAllCreditNotesBeforeSyncing();
//        if (numberOfCreditNotesBeforeSyncing.contains("0")) {
//            System.out.println("there is no Credit Notes  to be compared ");
//            Allure.step("there is no Credit Notes  to be compared ");
//        } else {
//
//            String creditNoteStatusBeforeSyncing = null;
//            String badgeBarBeforeSyncing = null;
//            String badgeBarAfterSyncing = null;
//            String creditNoteStatusAfterSyncing = null;
//            String creditNotePaidStatusBeforeSyncing = null;
//            String creditNotePaidStatusAfterSyncing = null;
//            String creditNoteIssueDateAfterSyncing = null;
//            String creditNoteIssueDateBeforeSyncing = null;
//            String customerNameAtCreditNoteBeforeSyncing = null;
//            String customerNameAtCreditNoteAfterSyncing = null;
//            String netTotalValueBeforeSyncing = null;
//            String grandTotalValueBeforeSyncing = null;
//            String netTotalValueAfterSyncing = null;
//            String grandTotalValueAfterSyncing = null;
//            homePageLink_4 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_4");
//            websiteLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "websiteLink_5");
//            homePageLink_5 = mainPageObj.readDataFromPropertiesFile(configurationFilePath, "homePageLink_5");
//            random = new Random();
//            randomNumber = random.nextInt(1000000000);
//            itemCode = "item " + randomNumber;
//            softAssert = new SoftAssert();
//
//            String nameOfSelectedCreditNoteAtDafater_4 = salesOrderListPageObj.getNameOfFirstCreditNoteBeforeSyncing();
//            creditNotePageObj = salesOrderListPageObj.openFirstCreditNoteAtDafater_4();
//
//            if ((creditNotePageObj.getCreditNoteStatus().contains(submittedStatus) || creditNotePageObj.getCreditNoteStatus().contains(zatcaStatus))) {
//                System.out.println(" status of credit note  " + creditNotePageObj.getCreditNoteStatus());
//                creditNoteStatusBeforeSyncing = creditNotePageObj.getCreditNoteStatus();
//
//                creditNotePaidStatusBeforeSyncing = creditNotePageObj.getCreditNotePaidStatus();
//                badgeBarBeforeSyncing = creditNotePageObj.getBadgeBar();
//
//                creditNoteIssueDateBeforeSyncing = creditNotePageObj.getCreditNoteIssueDate();
//                customerNameAtCreditNoteBeforeSyncing = creditNotePageObj.getCustomerNameAtCreditNote();
//                netTotalValueBeforeSyncing = creditNotePageObj.getNetTotalValueAtCreditNote();
//                grandTotalValueBeforeSyncing = creditNotePageObj.getGrandTotalValueAtCreditNote();
//            }
//            if (creditNotePageObj.getCreditNoteStatus().contains(draftStatus)) {
//                System.out.println("status of sales invoice  is  " + draftStatus);
//                creditNoteStatusBeforeSyncing = creditNotePageObj.getCreditNoteStatus();
//                creditNotePaidStatusBeforeSyncing = creditNotePageObj.getCreditNotePaidStatus();
//                netTotalValueBeforeSyncing = creditNotePageObj.getNetTotalValueAtCreditNote();
//                grandTotalValueBeforeSyncing = creditNotePageObj.getGrandTotalValueAtCreditNote();
//            }
//            loginPageObj = homePageObj.logOutFromDafater_4(homePageLink_4);
//            loginPageObj.switchToDafater_5(websiteLink_5);
//            homePageObj = loginPageObj.loginWithValidData(userName_5, password_5);
//            salesOrderListPageObj = homePageObj.openCreditNotesSalesModuleListPage();
//            Assert.assertTrue(salesOrderListPageObj.searchAboutSpecificCreditNote(nameOfSelectedCreditNoteAtDafater_4).equals(GeneralConstants.SUCCESS));
//            if (creditNotePageObj.getCreditNoteStatus().contains(submittedStatus)) {
//                System.out.println(" status of credit note  " + creditNotePageObj.getCreditNoteStatus());
//                creditNoteStatusAfterSyncing = creditNotePageObj.getCreditNoteStatusAtDafater_5();
//                creditNotePaidStatusAfterSyncing = creditNotePageObj.getCreditNotePaidStatus();
//                badgeBarAfterSyncing = creditNotePageObj.getBadgeBar();
//                creditNoteIssueDateAfterSyncing = creditNotePageObj.getCreditNoteIssueDate();
//                customerNameAtCreditNoteAfterSyncing = creditNotePageObj.getCustomerNameAtCreditNote();
//                netTotalValueAfterSyncing = creditNotePageObj.getNetTotalValueAtCreditNote();
//                grandTotalValueAfterSyncing = creditNotePageObj.getGrandTotalValueAtCreditNote();
//            }
//
//            if (creditNotePageObj.getCreditNoteStatusAtDafater_5().contains(draftStatus)) {
//                System.out.println("status of credit note  is  " + draftStatus);
//                creditNoteStatusAfterSyncing = creditNotePageObj.getCreditNoteStatusAtDafater_5();
//                creditNotePaidStatusAfterSyncing = creditNotePageObj.getCreditNotePaidStatus();
//
//                netTotalValueAfterSyncing = creditNotePageObj.getNetTotalValueAtCreditNote();
//                grandTotalValueAfterSyncing = creditNotePageObj.getGrandTotalValueAtCreditNote();
//            }
//
//
//            if (creditNotePageObj.getCreditNoteStatus().contains(submittedStatus)) {
//
//                System.out.println("verify that the status of credit note at dafater 5 is same as exist at dafater 4 ");
//
//                softAssert.assertTrue((creditNoteStatusAfterSyncing.trim().contains(submittedStatus.trim())
//                        && creditNoteStatusBeforeSyncing.trim().contains(zatcaStatus.trim()))
//                        || (creditNoteStatusAfterSyncing.trim().contains(submittedStatus.trim())
//                        && creditNoteStatusBeforeSyncing.trim().contains(submittedStatus.trim())));
//                System.out.println(" status of credit note at dafater 5 is " + creditNoteStatusAfterSyncing + " and at dafater 4 is " + creditNoteStatusBeforeSyncing);
//                System.out.println("                   ***********************************************************            ");
//
//                System.out.println("verify that the paid status of credit note " + nameOfSelectedCreditNoteAtDafater_4 + " at dafater 5 is same as exist at dafater 4 ");
//                softAssert.assertEquals(creditNotePaidStatusBeforeSyncing.trim(), creditNotePaidStatusAfterSyncing.trim());
//                System.out.println(" paid status of credit note at dafater 5 is " + creditNotePaidStatusAfterSyncing + " and at dafater 4 is " + creditNotePaidStatusBeforeSyncing);
//                System.out.println("                   ***********************************************************            ");
//
//                System.out.println("verify that the issue date of credit note " + nameOfSelectedCreditNoteAtDafater_4 + " at dafater 5 is same as exist at dafater 4 ");
//                softAssert.assertEquals(creditNoteIssueDateBeforeSyncing.trim(), creditNoteIssueDateAfterSyncing.trim());
//                System.out.println(" issue date of credit notee at dafater 5 is " + creditNoteIssueDateAfterSyncing + " and at dafater 4 is " + creditNoteIssueDateBeforeSyncing);
//                System.out.println("                   ***********************************************************            ");
//
//                System.out.println("verify that the customer name of credit note " + nameOfSelectedCreditNoteAtDafater_4 + " at dafater 5 is same as exist at dafater 4 ");
//                softAssert.assertEquals(customerNameAtCreditNoteBeforeSyncing.trim(), customerNameAtCreditNoteAfterSyncing.trim());
//                System.out.println(" customer name of credit note at dafater 5 is " + customerNameAtCreditNoteAfterSyncing + " and at dafater 4 is " + customerNameAtCreditNoteBeforeSyncing);
//                System.out.println("                   ***********************************************************            ");
//
//                System.out.println("verify that the net total value of credit note " + nameOfSelectedCreditNoteAtDafater_4 + " at dafater 5 is same as exist at dafater 4 ");
//                softAssert.assertEquals(netTotalValueBeforeSyncing.trim(), netTotalValueAfterSyncing.trim());
//                System.out.println(" net total of sales value credit note at dafater 5 is " + netTotalValueAfterSyncing + " and at dafater 4 is " + netTotalValueBeforeSyncing);
//                System.out.println("                   ***********************************************************            ");
//
//                System.out.println("verify that the grand total value of credit note " + nameOfSelectedCreditNoteAtDafater_4 + " at dafater 5 is same as exist at dafater 4 ");
//                softAssert.assertEquals(grandTotalValueBeforeSyncing.trim(), grandTotalValueAfterSyncing.trim());
//                System.out.println("  grand total value of credit note at dafater 5 is " + grandTotalValueAfterSyncing + " and at dafater 4 is " + grandTotalValueBeforeSyncing);
//                System.out.println("                   ***********************************************************            ");
//
//                System.out.println("verify that the badge of credit note " + nameOfSelectedCreditNoteAtDafater_4 + " at dafater 5 is same as exist at dafater 4 ");
//                softAssert.assertEquals(badgeBarBeforeSyncing.trim(), badgeBarAfterSyncing.trim());
//                System.out.println("  the badge of credit note at dafater 5 is " + badgeBarAfterSyncing + " and at dafater 4 is " + badgeBarBeforeSyncing);
//                System.out.println("                   ***********************************************************            ");
//                softAssert.assertAll();
//            }
//
//            if (creditNotePageObj.getCreditNoteStatus().contains(draftStatus)) {
//                System.out.println("verify that the status of  credit note at dafater 5 is same as exist at dafater 4 ");
//                softAssert.assertEquals(creditNoteStatusBeforeSyncing.trim(), creditNoteStatusAfterSyncing.trim());
//                System.out.println(" status of sales invoice at dafater 5 is " + creditNoteStatusAfterSyncing + " and at dafater 4 is " + creditNoteStatusBeforeSyncing);
//                System.out.println("                   ***********************************************************            ");
//                System.out.println("verify that the paid status of  credit note" + nameOfSelectedCreditNoteAtDafater_4 + " at dafater 5 is same as exist at dafater 4 ");
//                softAssert.assertEquals(creditNotePaidStatusBeforeSyncing.trim(), creditNotePaidStatusAfterSyncing.trim());
//                System.out.println(" paid status of  credit note at dafater 5 is " + creditNotePaidStatusAfterSyncing + " and at dafater 4 is " + creditNotePaidStatusBeforeSyncing);
//                System.out.println("                   ***********************************************************            ");
//                System.out.println("verify that the net total value of s credit note " + nameOfSelectedCreditNoteAtDafater_4 + " at dafater 5 is same as exist at dafater 4 ");
//                softAssert.assertEquals(netTotalValueBeforeSyncing.trim(), netTotalValueAfterSyncing.trim());
//                System.out.println(" net total of sales value  credit note at dafater 5 is " + netTotalValueAfterSyncing + " and at dafater 4 is " + netTotalValueBeforeSyncing);
//                System.out.println("                   ***********************************************************            ");
//                System.out.println("verify that the grand total value of  credit note " + nameOfSelectedCreditNoteAtDafater_4 + " at dafater 5 is same as exist at dafater 4 ");
//                softAssert.assertEquals(grandTotalValueBeforeSyncing.trim(), grandTotalValueAfterSyncing.trim());
//                System.out.println("  grand total value of credit note at dafater 5 is " + grandTotalValueAfterSyncing + " and at dafater 4 is " + grandTotalValueBeforeSyncing);
//                System.out.println("                   ***********************************************************            ");
//                softAssert.assertAll();
//            }
//        }
//    }


}
