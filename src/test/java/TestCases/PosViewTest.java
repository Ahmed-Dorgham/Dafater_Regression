package TestCases;

import Pages.*;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PosViewTest extends BaseTest {

    HomePage homePageObj;
    double discountValue = 10;
    double discountEquation =((100 - discountValue) / 100);
    SalesInvoicesListPage salesInvoicesListPageObj;
    SalesInvoicesPage salesInvoicesPageObj;
    PosViewPage posViewPageObj;
    private final String submittedStatus = "معتمد";
    private final String invoiceName = "ACC-SINV";

    @Test(priority = 1, enabled = true)
    public void TC01_createNewSalesInvoiceUsingPosView() throws InterruptedException {
        homePageObj = new HomePage(driver);
        salesInvoicesListPageObj = homePageObj.openSalesInvoicesListPage();
        salesInvoicesPageObj = salesInvoicesListPageObj.clickOnNewSalesInvoiceBtn();
        posViewPageObj = salesInvoicesPageObj.openPosView();
        posViewPageObj.createNewSalesInvoiceFromPosView();
        String salesInvoiceName = posViewPageObj.getInvoiceName(invoiceName);
        Assert.assertTrue(posViewPageObj.getInvoiceName(invoiceName).contains(invoiceName));
        salesInvoicesListPageObj = posViewPageObj.backToSystem();
        Allure.step("Verify the name of current created sales invoice from pos view  is existed at sales invoice list view ");
        Assert.assertTrue(salesInvoicesListPageObj.getInvoiceNameAtViewList(salesInvoiceName).contains(salesInvoiceName));
        Assert.assertTrue(salesInvoicesPageObj.getPosInvoiceStatus(submittedStatus).contains(submittedStatus));
    }

    @Test(priority = 2, enabled = true)
    public void TC02_applyDiscountOnSalesInvoiceUsingPosView() throws InterruptedException {
        double netTotalAfterApplyDiscount;
        homePageObj = new HomePage(driver);
        salesInvoicesListPageObj = homePageObj.openSalesInvoicesListPage();
        salesInvoicesPageObj = salesInvoicesListPageObj.clickOnNewSalesInvoiceBtn();
        posViewPageObj = salesInvoicesPageObj.openPosView();
        posViewPageObj.applyDiscountForOneItem(discountValue);
        Allure.step("total amount before applying discount for one item is " + posViewPageObj.getTotalAmountBeforeApplyingDiscount());
        Allure.step("total amount after applying discount for one item is " + posViewPageObj.getTotalAmountAfterApplyingDiscount());
        netTotalAfterApplyDiscount = posViewPageObj.getTotalAmountBeforeApplyingDiscount() * discountEquation;
        Assert.assertTrue(posViewPageObj.getTotalAmountAfterApplyingDiscount() == netTotalAfterApplyDiscount);
        Allure.step("net total amount after applying discount for one item should be " + netTotalAfterApplyDiscount + " and this is correct ");
        posViewPageObj.increaseQuantity();
        Allure.step("total amount before applying discount for 2  items is " + posViewPageObj.getTotalAmountBeforeApplyingDiscount());
        Allure.step("total amount after applying discount for 2 items is " + posViewPageObj.getTotalAmountAfterApplyingDiscount());
        netTotalAfterApplyDiscount = posViewPageObj.getTotalAmountBeforeApplyingDiscount() * ((100 - discountValue) / 100);
        Assert.assertTrue(posViewPageObj.getTotalAmountAfterApplyingDiscount() == netTotalAfterApplyDiscount);
        Allure.step("net total amount after applying discount for one item should be " + netTotalAfterApplyDiscount + " and this is correct ");
        posViewPageObj.completePaymentProcess();
        posViewPageObj.backToSystem();
    }

}
