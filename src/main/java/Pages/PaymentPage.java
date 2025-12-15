package Pages;

import GeneralConstants.GeneralConstants;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class PaymentPage extends MainPage {
    private String dataMigrationTitle = "data migration";
    // private WebDriver driver ;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    private By checkVmConnectionBtn = By.id("check_vm_connection");
    private By updateStockBtn = By.id("update_stock");
    private By reasonField = By.id("reason");
    private By referenceNumField = By.xpath("(//input[@data-fieldname='reference_no'])");
    private By invoiceName = By.xpath("(//div[@data-fieldname='reference_name'])/div/a");
    private By statusMsg = By.id("msgprint");
    private By editIcon = By.className("icon-xs");
    Select reason;
    private By newSalesInvoiceTitle = By.xpath("//*[contains(@title,'فاتورة المبيعات جديد')]");
    private By customerFieldSalesInvoice = By.xpath("(//*[contains(@id,'customer')])[4]");
    private By itemCodeField = By.xpath("(//*[contains(@data-fieldname,'item_code')])[2]");
    private By itemCodeInputField = By.xpath("(//*[contains(@id,'item_code')])");
    private By customersListSalesInvoice = By.xpath("(//*[contains(@data-target,'Customer')and @placeholder=' ']/following-sibling::ul)");
    private By customerOptSalesInvoice = By.xpath("((//*[contains(@data-target,'Customer')and @placeholder=' ']/following-sibling::ul)/li)[1]");
    private By itemOpt = By.xpath("((//*[contains(@data-target,'Item')and @placeholder='صنف']/following-sibling::ul)/li)[1]");
    private By dueDateField = By.xpath("//*[contains(@id,'due_date')]");
    private By saveAndSubmitBtn = By.xpath("//*[contains(@class,'btn btn-inverse btn-sm save-submit-action toolbar-btn')]");
    private By saveAndSubmitBtnForPayment = By.xpath("(//*[@class='btn btn-inverse btn-sm save-submit-action toolbar-btn'])");
    private By yesBtn = By.xpath("(//*[contains(@class,'btn btn-primary btn-sm btn-modal-primary')])");
    private By yesBtn_SO = By.xpath("(//*[contains(@class,'btn btn-primary btn-sm btn-modal-primary')])[2]");
    private By closeIcon = By.xpath("(//*[contains(@class,'btn btn-modal-close btn-link')])[3]");
    private By creditNoteStatus = By.xpath("(//*[contains(@class,'label label-success')])");
    private By createBtn = By.xpath("(//*[contains(@class,'btn btn-default toolbar-btn')])[3]");
    private By cancelBtn = By.xpath("(//*[contains(@class,'btn btn-secondary btn-default btn-sm toolbar-btn')])[5]");
    private By salesInvoiceNameInsideCreditNote = By.xpath("//label[contains(@for,'return_against')]//following-sibling::div/a");
    By overlay = By.xpath("//*[contains(@class,'freeze-message-container')]");
    private By submittedStatus = By.xpath("(//*[contains(@class,'label label-success')])[2]");
    private By draftStatus = By.xpath("(//*[contains(@class,'indicator-pill no-indicator-dot whitespace-nowrap red')])/span");
    private By paidSalesInvoiceLink = By.xpath("(//*[@class='link-itself'])[3]");
    private By paidStatus = By.xpath("(//*[@class='indicator-pill no-indicator-dot whitespace-nowrap green'])");

    public void enterValidDataIntoSalesInvoicePage(String dueDate) throws InterruptedException {
        waitUntilElementVisibility(newSalesInvoiceTitle, GeneralConstants.minTimeOut);
       Allure.step("select  customer ");
        getWebElement(customerFieldSalesInvoice).click();
        waitUntilElementVisibility(customersListSalesInvoice, GeneralConstants.minTimeOut);
        waitUntilElementToBeClickable(customerOptSalesInvoice, GeneralConstants.minTimeOut);
        getWebElement(customerOptSalesInvoice).click();
       Allure.step("enter dues date  ");
        waitUntilElementVisibility(dueDateField, GeneralConstants.minTimeOut);
        getWebElement(dueDateField).sendKeys(dueDate);
       Allure.step("Scroll down to item field ");
        scrollToSpeceficElement(itemCodeField);
        //   Thread.sleep(6000);
       Allure.step(" select item  ");
        clickByActions(itemCodeField);
        waitUntilElementVisibility(itemCodeInputField, GeneralConstants.minTimeOut);
        getWebElement(itemCodeInputField).sendKeys("item");
        waitUntilElementToBeClickable(itemOpt, GeneralConstants.minTimeOut);
        getWebElement(itemOpt).click();
       Allure.step("unselect update stock opt");
        getWebElement(updateStockBtn).click();
        //Thread.sleep(6000);
       Allure.step("scroll up to save and submit btn ");
        scrollToSpeceficElement(saveAndSubmitBtn);

       Allure.step(" save and submit btn sales invoice ");
        getWebElement(saveAndSubmitBtn).click();
        //  Thread.sleep(10000);
       Allure.step("click on yes btn ");
        waitUntilElementToBeClickable(yesBtn, GeneralConstants.minTimeOut);
        getWebElement(yesBtn).click();

    }

    public String getCreditNoteStatus(String expected) {
//       Allure.step("Verify the status of sales invoice  ");
        waitUntilElementToBePresent(creditNoteStatus, GeneralConstants.minTimeOut);
       Allure.step("actual text is " + getWebElement(creditNoteStatus).getText() + " and expected test is " + expected);
        return getWebElement(creditNoteStatus).getText();
    }

    public String getInvoiceStatus(String expected) {
       Allure.step("Verify the status of payment doc type  ");
        waitUntilElementToBePresent(cancelBtn, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        if (tryToGetWebElementV(submittedStatus) == GeneralConstants.SUCCESS) {
           Allure.step("actual text is " + getWebElement(submittedStatus).getText() + " and expected test is " + expected);
            return getWebElement(submittedStatus).getText();
        } else if (tryToGetWebElementV(draftStatus) == GeneralConstants.SUCCESS) {
           Allure.step("actual text is " + getWebElement(draftStatus).getText() + " and expected test is " + expected);
            return getWebElement(draftStatus).getText();
        } else
            return "unexpected status";
    }

    public SalesInvoicesPage openPaidSalesInvoice() {
       Allure.step("open paid sales invoice");
        getWebElement(paidSalesInvoiceLink).click();
        return new SalesInvoicesPage(driver);
    }
    public PurchaseInvoicesPage openPaidPurchaseInvoice() {
       Allure.step("open paid  purchase invoice");
        getWebElement(paidSalesInvoiceLink).click();
        return new PurchaseInvoicesPage(driver);
    }

    public String getInvoiceNameFromPayment() {
        waitUntilElementToBePresent(saveAndSubmitBtnForPayment, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);

        scrollToSpeceficElement(invoiceName);
       Allure.step("invoice name at payment req " + getWebElement(invoiceName).getText());
        return getWebElement(invoiceName).getText();
    }

    public void saveAndSubmitPayment(double referenceNum) throws InterruptedException {

        waitUntilElementVisibility(saveAndSubmitBtnForPayment, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
       Allure.step("scroll down to reference num field ");
        scrollToSpeceficElement(referenceNumField);
////        getWebElement(reasonField).click();
//        clickByActions(reasonField);
//
        waitUntilElementToBePresent(referenceNumField, GeneralConstants.minTimeOut);
        getWebElement(referenceNumField).sendKeys(String.valueOf(referenceNum));
//
//       Allure.step("choose reason for credit note ");
//        reason = new Select(getWebElement(reasonField));
//        reason.selectByIndex(1);
        scrollToSpeceficElement(saveAndSubmitBtnForPayment);
       Allure.step("save and submit creditNote ");
        getWebElement(saveAndSubmitBtnForPayment).click();
       Allure.step("click on yes btn ");
        waitUntilElementToBeClickable(yesBtn_SO, GeneralConstants.minTimeOut);
        getWebElement(yesBtn_SO).click();
//       Allure.step("click on close icon ");
//        waitUntilElementToBeClickable(closeIcon, GeneralConstants.minTimeOut);
//        getWebElement(closeIcon).click();
        waitUntilElementToBePresent(cancelBtn, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
    }

    public String getInvoiceNameInsideCreditNote(String expected) {
//       Allure.step("Verify the name of sales invoice  ");
        waitUntilElementToBePresent(createBtn, GeneralConstants.minTimeOut);
       Allure.step("actual text is  " + getWebElement(salesInvoiceNameInsideCreditNote).getAttribute("data-value") + "  and expected text is  " + expected);
        return getWebElement(salesInvoiceNameInsideCreditNote).getText();
    }
}
