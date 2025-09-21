package TestCases;

import Pages.*;
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
        System.out.println("Verify the name of current created sales invoice from pos view  is existed at sales invoice list view ");
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
        System.out.println("total amount before applying discount for one item is " + posViewPageObj.getTotalAmountBeforeApplyingDiscount());
        System.out.println("total amount after applying discount for one item is " + posViewPageObj.getTotalAmountAfterApplyingDiscount());
        netTotalAfterApplyDiscount = posViewPageObj.getTotalAmountBeforeApplyingDiscount() * discountEquation;
        Assert.assertTrue(posViewPageObj.getTotalAmountAfterApplyingDiscount() == netTotalAfterApplyDiscount);
        System.out.println("net total amount after applying discount for one item should be " + netTotalAfterApplyDiscount + " and this is correct ");
        posViewPageObj.increaseQuantity();
        System.out.println("total amount before applying discount for 2  items is " + posViewPageObj.getTotalAmountBeforeApplyingDiscount());
        System.out.println("total amount after applying discount for 2 items is " + posViewPageObj.getTotalAmountAfterApplyingDiscount());
        netTotalAfterApplyDiscount = posViewPageObj.getTotalAmountBeforeApplyingDiscount() * ((100 - discountValue) / 100);
        Assert.assertTrue(posViewPageObj.getTotalAmountAfterApplyingDiscount() == netTotalAfterApplyDiscount);
        System.out.println("net total amount after applying discount for one item should be " + netTotalAfterApplyDiscount + " and this is correct ");
        posViewPageObj.completePaymentProcess();
        posViewPageObj.backToSystem();
    }

}
