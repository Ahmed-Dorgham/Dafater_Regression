package Pages;

import GeneralConstants.GeneralConstants;
import io.qameta.allure.Allure;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PosViewPage extends MainPage {
    private String dataMigrationTitle = "data migration";
    // private WebDriver driver ;

    public PosViewPage(WebDriver driver) {
        this.driver = driver;
    }

    private By checkVmConnectionBtn = By.id("check_vm_connection");
    private By updateStockBtn = By.id("update_stock");
    private By statusMsg = By.className("msgprint");
    private By editIcon = By.className("icon-xs");
    private By newSalesInvoiceTitle = By.xpath("//*[contains(@title,'فاتورة المبيعات جديد')]");
    private By customerFieldSalesInvoice = By.xpath("(//*[contains(@id,'customer')])[4]");
    private By itemCodeField = By.xpath("(//*[contains(@data-fieldname,'item_code')])[2]");
    private By itemPriceField = By.xpath("(//*[contains(@data-fieldtype,'Currency')])[3]");
    private By itemCodeInputField = By.xpath("(//input[contains(@class,'input-with-feedback form-control') and contains(@data-fieldtype,'Data')])[1]");
    private By customersListSalesInvoice = By.xpath("(//*[contains(@data-target,'Customer')and @placeholder=' ']/following-sibling::ul)");
    private By customerOptSalesInvoice = By.xpath("((//*[contains(@data-target,'Customer')and @placeholder=' ']/following-sibling::ul)/li)[1]");
    private By itemOpt = By.xpath("(//div[contains(text(),'item 1')])[2]");
    private By closeIcon = By.xpath("(//a[@class='btn-open no-decoration'])");
    private By listCount = By.xpath("(//*[contains(@class,'list-count')])");
    private By draftLabel = By.xpath("(//h3[contains(text(),'مسودة')])");
    private By payBtn = By.xpath("(//div[@class='checkout-btn'])");
    private By completeOrder = By.xpath("(//div[@class='submit-order-btn'])");
    private By saveAndSubmitBtn = By.xpath("//*[contains(@class,'btn btn-inverse btn-sm save-submit-action toolbar-btn')]");
    private By saveAndSubmitBtnFromSalesOrder = By.xpath("(//*[contains(@class,'btn btn-inverse btn-sm save-submit-action toolbar-btn')])[2]");
    private By yesBtn = By.xpath("(//*[contains(@class,'btn btn-primary btn-sm btn-modal-primary')])");
    private By newOrderBtn = By.xpath("(//div[@class='summary-btn btn btn-default new-btn'])");
    private By invoiceStatus = By.xpath("(//*[contains(@class,'label label-success')])");
    private By invoiceName = By.xpath("(//div[contains(@class,'invoice-name')])");
    private By invoiceNameForCreditNote = By.xpath("(//h3[contains(@class,'ellipsis title-text')])[1]");
    private By invoiceNameAtViewList = By.xpath("(//a[contains(@data-doctype,'Sales Invoice')])[1]");
    private By yesBtn_SO = By.xpath("(//*[contains(@class,'btn btn-primary btn-sm btn-modal-primary')])[2]");
    private By createBtn = By.xpath("//*[contains(@class,'btn toolbar-btn btn-primary')]");
    private By salesInvoicesOpt = By.xpath("//*[contains(@id,'sidebar-selling-invoice')]");
    private By creditNoteChoice = By.xpath("//*[contains(text(),'مرتجع / اشعار دائن') and @class = 'dropdown-item']");
    private By noItemsLabel = By.xpath("(//div[contains(@class,'no-item-wrapper') ])");
    private By totalAmountLabel = By.xpath("(//*[contains(text(),'الكمية الإجمالية')])");
    private By posProfileUInputField = By.xpath("//input[contains(@data-fieldname,'pos_profile')]");
    private By posProfileChoice = By.xpath("(//input[contains(@data-fieldname,'pos_profile')]/following-sibling::ul/li)[1]");
    private By viewBtn = By.xpath("(//button[contains(text(),'واجهة')])[2]");
    private By posViewBtn = By.xpath("(//button[contains(text(),'واجهة نقاط البيع')])[1]");
    private By isPosCheckBox = By.id("is_pos");
    private By backToSystemBtn = By.xpath("//*[contains(@class,'btn-back')]/span");
    private By increaseQuantityIcon = By.xpath("//*[contains(@class,'qty-increase')]");
    private By QuantityField = By.xpath("//*[contains(@class,'qty-input')]");
    private By QuantityFieldAtFooter = By.xpath("(//*[contains(@class,'item-qty-total-container')]//div)[2]");
    By overlay = By.xpath("//*[contains(@class,'freeze-message-container')]");
    By applyDiscountBtn = By.xpath("//*[contains(@class,'add-discount-wrapper')]");
    By discountField = By.xpath("(//*[contains(@class,'add-discount-wrapper')]//input)[1]");
    By totalAmountBeforeDiscountField = By.xpath("//*[contains(@class,'total-before-discount-container')]//span");
    By totalAmountBeforeDiscountLabel = By.xpath("(//*[contains(@class,'total-before-discount-container')]/div)[1]");
    By netAmountAfterDiscountField = By.xpath("//*[contains(@class,'net-total-container')]//span");

    public void createNewSalesInvoiceFromPosView() throws InterruptedException {
        waitUntilElementToBePresent(backToSystemBtn, GeneralConstants.minTimeOut);
        waitUntilElementToBePresent(itemCodeInputField, GeneralConstants.minTimeOut);

       Allure.step(" select item  ");
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        getWebElement(itemCodeInputField).sendKeys("item 1");
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBeClickable(itemOpt, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        getWebElement(itemOpt).click();
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        if (tryToGetWebElementV(noItemsLabel) == GeneralConstants.SUCCESS) {
           Allure.step("***************************");
            waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
            getWebElement(itemOpt).click();
        }
        waitUntilOverlayDisappear(overlay, GeneralConstants.minTimeOut);
        waitUntilElementNotToBeVisible(noItemsLabel, GeneralConstants.minTimeOut);
        scrollToSpeceficElement(payBtn);
       Allure.step(" click on pay btn  ");
        getWebElement(payBtn).click();
       Allure.step("click on complete order btn ");
        waitUntilElementToBeClickable(completeOrder, GeneralConstants.minTimeOut);
        scrollToSpeceficElement(completeOrder);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        getWebElement(completeOrder).click();
       Allure.step("click on yes btn ");
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(yesBtn, GeneralConstants.minTimeOut);
        getWebElement(yesBtn).click();
        waitUntilElementToBePresent(newOrderBtn, GeneralConstants.minTimeOut);

    }

    public void completePaymentProcess() throws InterruptedException {

        scrollToSpeceficElement(payBtn);
       Allure.step(" click on pay btn  ");
        getWebElement(payBtn).click();
       Allure.step("click on complete order btn ");
        waitUntilElementToBeClickable(completeOrder, GeneralConstants.minTimeOut);
        scrollToSpeceficElement(completeOrder);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        getWebElement(completeOrder).click();
       Allure.step("click on yes btn ");
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(yesBtn, GeneralConstants.minTimeOut);
        getWebElement(yesBtn).click();
        waitUntilElementToBePresent(newOrderBtn, GeneralConstants.minTimeOut);

    }

    public void openPosView() throws InterruptedException {
       Allure.step("click on is pos view btn");
        waitUntilElementToBePresent(posViewBtn, GeneralConstants.minTimeOut);
        getWebElement(posViewBtn).click();
       Allure.step("click on accept btn ");
//        Thread.sleep(9000);
        waitUntilElementNotToBeVisible(posViewBtn, GeneralConstants.minTimeOut);
        Alert alert = driver.switchTo().alert();
        alert.accept();
//       Allure.step("choose POS profile ");
//        waitUntilElementToBePresent(posProfileUInputField, GeneralConstants.minTimeOut);
//        getWebElement(posProfileUInputField).click();
//        return new SalesInvoicesPage(driver);
    }

    public void saveAndSubmitSalesInvoiceFromSalesOrder() throws InterruptedException {

        waitUntilElementVisibility(saveAndSubmitBtnFromSalesOrder, GeneralConstants.minTimeOut);
       Allure.step("save and submit sales invoice  ");
        getWebElement(saveAndSubmitBtnFromSalesOrder).click();
       Allure.step("click on yes btn ");
        waitUntilElementToBeClickable(yesBtn_SO, GeneralConstants.minTimeOut);
        getWebElement(yesBtn_SO).click();
        waitUntilElementToBePresent(createBtn, GeneralConstants.minTimeOut);
    }

    public CreditNotePage createCreditNoteFromSalesInvoice() {
       Allure.step("click on create btn");
        waitUntilElementVisibility(createBtn, GeneralConstants.minTimeOut);
        getWebElement(createBtn).click();
       Allure.step("click on credit note");
        waitUntilElementVisibility(creditNoteChoice, GeneralConstants.minTimeOut);
        getWebElement(creditNoteChoice).click();
        return new CreditNotePage(driver);
    }

    public void applyDiscountForOneItem(double discountValue) {

        waitUntilElementToBePresent(backToSystemBtn, GeneralConstants.minTimeOut);
        waitUntilElementToBePresent(itemCodeInputField, GeneralConstants.minTimeOut);

       Allure.step(" select item  ");
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        getWebElement(itemCodeInputField).sendKeys("item 1");
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBeClickable(itemOpt, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        getWebElement(itemOpt).click();
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        if (tryToGetWebElementV(noItemsLabel) == GeneralConstants.SUCCESS) {
           Allure.step("***************************");
            waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
            getWebElement(itemOpt).click();
        }
        waitUntilOverlayDisappear(overlay, GeneralConstants.minTimeOut);
        waitUntilElementNotToBeVisible(noItemsLabel, GeneralConstants.minTimeOut);
        scrollToSpeceficElement(payBtn);

       Allure.step("click on apply discount btn ");
        getWebElement(applyDiscountBtn).click();
        waitUntilElementToBePresent(discountField, GeneralConstants.minTimeOut);
       Allure.step("enter discount value  ");
        getWebElement(discountField).sendKeys(String.valueOf(discountValue));
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        getWebElement(totalAmountLabel).click();
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);

    }

    public double getTotalAmountBeforeApplyingDiscount() {
        waitUntilElementToBePresent(totalAmountBeforeDiscountLabel, GeneralConstants.minTimeOut);
        double totalAmountBeforeDiscount = Double.parseDouble(getWebElement(totalAmountBeforeDiscountField).getText());

        return totalAmountBeforeDiscount;
    }
public void increaseQuantity ()
{
   Allure.step("click on increase quantity icon ");
    getWebElement(increaseQuantityIcon).click();
    waitUntilOverlayDisappear(overlay,GeneralConstants.freezeTimeOut);
}
    public double getTotalAmountAfterApplyingDiscount() {

        double netAmountAfterDiscount = Double.parseDouble(getWebElement(netAmountAfterDiscountField).getText());

        return netAmountAfterDiscount;
    }

    public String getInvoiceStatus(String expected) {
       Allure.step("Verify the status of sales invoice  ");
        waitUntilElementToBePresent(createBtn, GeneralConstants.minTimeOut);
       Allure.step("actual text is " + getWebElement(invoiceStatus).getText() + " and expected test is " + expected);
        return getWebElement(invoiceStatus).getText();
    }

    public String getInvoiceName(String expected) {
//       Allure.step("Verify the name of sales invoice  ");
        waitUntilElementToBePresent(invoiceName, GeneralConstants.minTimeOut);
       Allure.step("actual text is  " + getWebElement(invoiceName).getText() + "  and expected text is  " + expected);
        return getWebElement(invoiceName).getText();
    }

    public String getInvoiceNameForCreditNote(String expected) {
//       Allure.step("Verify the name of sales invoice  ");
        waitUntilElementToBePresent(viewBtn, GeneralConstants.minTimeOut);
       Allure.step("actual text is  " + getWebElement(invoiceNameForCreditNote).getAttribute("title") + "  and expected text is  " + expected);
        return getWebElement(invoiceNameForCreditNote).getText();
    }

    public SalesInvoicesListPage backToSystem() {
       Allure.step("click on back to system btn  ");
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        scrollToSpeceficElement(backToSystemBtn);

        waitUntilElementToBePresent(backToSystemBtn, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay,GeneralConstants.freezeTimeOut);
        getWebElement(backToSystemBtn).click();
        return new SalesInvoicesListPage(driver);
    }

    public String getInvoiceNameAtViewList(String expected) {
       Allure.step("Verify the name of current created sales invoice is existed at sales invoice list view ");
        waitUntilElementToBePresent(createBtn, GeneralConstants.minTimeOut);
       Allure.step("navigate to sales invoices list  ");
        getWebElement(salesInvoicesOpt).click();
        driver.navigate().refresh();
        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
       Allure.step("actual text is " + getWebElement(invoiceNameAtViewList).getAttribute("title") + " and expected text is " + expected);
        return getWebElement(invoiceNameAtViewList).getText();
    }
}
