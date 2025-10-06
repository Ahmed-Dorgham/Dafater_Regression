package Pages;

import GeneralConstants.GeneralConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class PurchaseInvoicesPage extends MainPage {
    private String dataMigrationTitle = "data migration";
    // private WebDriver driver ;
    JavascriptExecutor js;
    Actions actions;

    public PurchaseInvoicesPage(WebDriver driver) {
        this.driver = driver;
    }

    private By createBtn = By.xpath("//*[contains(text(),'انشاء') and contains(@class, 'btn toolbar-btn btn-primary')]" +
            "| //*[contains(text(),'انشاء') and contains(@class, 'btn btn-default toolbar-btn')]");
    private By viewBtn = By.xpath("//*[contains(text(),'واجهة') and contains(@class, 'btn btn-default toolbar-btn')]");
    private By debitNoteChoice = By.xpath("//*[contains(text(),'ارجاع / اشعار مدين') and @class = 'dropdown-item']");
    private By checkVmConnectionBtn = By.id("check_vm_connection");
    private By updateStockBtn = By.id("update_stock");
    private By statusMsg = By.className("msgprint");
    private By editIcon = By.className("icon-xs");
    private By newPurchaseInvoiceTitle = By.xpath("//*[contains(@title,'فاتورة المشتريات جديد')]");
    private By supplierFieldPurchaseInvoice = By.xpath("(//*[contains(@id,'supplier')])[5]");
    private By itemCodeField = By.xpath("(//*[contains(@data-fieldname,'item_code')])[2]");
    private By itemCodeInputField = By.xpath("(//*[contains(@id,'item_code')])");
    private By supplierListPurchaseInvoice = By.xpath("(//*[contains(@data-target,'Supplier')and @placeholder=' ']/following-sibling::ul)");
    private By supplierOptPurchaseInvoice = By.xpath("((//*[contains(@data-target,'Supplier')and @placeholder=' ']/following-sibling::ul)/li)[1]" +
            "|((//*[contains(@data-target,'Supplier')and @placeholder=' ']/following-sibling::ul)//div/p/strong)[1]");
    private By itemOpt = By.xpath("((//*[contains(@data-target,'Item')and @placeholder='صنف']/following-sibling::ul)/li)[1]" +
            "| ((//*[contains(@data-target,'Item')and @placeholder='صنف']/following-sibling::ul)//div/p/strong)[1]");
    private By notSavedLabel = By.xpath("(//*[contains(@class,'indicator-pill no-indicator-dot whitespace-nowrap orange')])[2]");
    private By selectedItem = By.xpath("((//*[contains(@data-target,'Item')and @placeholder='صنف']/following-sibling::ul)//div//p[@title='item 1'])");

    private By saveAndSubmitBtn = By.xpath("//*[contains(@class,'btn btn-inverse btn-sm save-submit-action toolbar-btn')]");
    private By saveAndSubmitBtnFromAnotherDoc = By.xpath("(//*[contains(@class,'btn btn-inverse btn-sm save-submit-action toolbar-btn')])[2]");
    private By yesBtn = By.xpath("(//*[contains(@class,'btn btn-primary btn-sm btn-modal-primary')])");
    private By yesBtn_PO = By.xpath("(//*[contains(@class,'btn btn-primary btn-sm btn-modal-primary')])[2]");
    private By totalAmountLabel = By.xpath("(//*[contains(text(),'الكمية الإجمالية')])");
    private By invoiceStatus = By.xpath("(//*[contains(@class,'label label-success')])");
    private By invoiceName = By.xpath("(//h3[contains(@class,'ellipsis title-text')])[4]");
    private By invoiceNamePayment = By.xpath("(//h3[contains(@class,'ellipsis title-text')])[3]");
    private By purchaseInvoicesOpt = By.xpath("//*[contains(@id,'sidebar-purchases-invoice')]");
    private By draftLabel = By.xpath("(//h3[contains(text(),'مسودة')])");
    private By invoiceNameAtViewList = By.xpath("(//a[contains(@data-doctype,'Purchase Invoice')])[1]");
    By overlay = By.xpath("//*[contains(@class,'freeze-message-container')]");
    private By unpaidStatusElement = By.xpath("(//*[@class='indicator-pill no-indicator-dot whitespace-nowrap orange'])");
    private By paymentChoice = By.xpath("//*[contains(text(),'دفع') and @class = 'dropdown-item']");
    private By paidStatus = By.xpath("(//*[@class='indicator-pill no-indicator-dot whitespace-nowrap green'])");
    private By grandTotalAmountValue = By.xpath("//div[@data-fieldname='grand_total']/div/div/div/div[2]/div/span");
    private By totalAmountValue = By.xpath("//div[@data-fieldname='total']/div/div/div/div[2]/div/span");
    private By generalLedgerChoice = By.xpath("(//a[contains(text(),'موازنة دفتر الأستاذ')])");
    private By closeIcon = By.xpath("(//*[contains(@class,'btn btn-modal-close btn-link')])[2]");
    private By invoiceIssueDateField = By.xpath("//*[contains(text(),' تاريخ ادخال الفاتورة')]/../following-sibling::div" +
            "|//label[contains(@for,'posting_date')]/following-sibling::div " +
            "| //*[contains(@for,'posting_date')]/following-sibling::div ");
    private By successStatusField = By.xpath("//*[contains(@class,'status-bar pull-left')]/span" +
            "|//*[contains(@class,'ellipsis title-text')]/following-sibling::div//span[contains(@class,'label label-success')]");
    private By supplierNameField = By.xpath("//*[contains(text(),'اسم المورد')]/../following-sibling::div/a" +
            "|//*[contains(text(),'المورد')]//following-sibling::div/a");

    private By netTotalField = By.xpath("(//*[contains(@title,'net_total_import')]//span)[3]" +
            "| (//*[@data-fieldname='total']//span[@dir='rtl'])[1]");
    private By grandTotalField = By.xpath("(//*[@data-fieldname='grand_total']//span)[1]" +
            "| (//*[contains(@title,'grand_total_import')]//span)[3]");
    public String getPurchaseInvoiceStatus() {
        String draftStatus = "مسودة";
        waitUntilElementToBePresent(invoiceIssueDateField, GeneralConstants.minTimeOut);
        if (tryToGetWebElement(successStatusField) == GeneralConstants.SUCCESS) {
//            System.out.println(" status of sales invoice  " + getWebElement(successStatusField).getText());
            return getWebElement(successStatusField).getText();
        } else {
//            System.out.println(" status of sales invoice  is " + draftStatus);
            return draftStatus;
        }
    }

    public String getPurchaseInvoiceIssueDate() {
        waitUntilElementToBePresent(invoiceIssueDateField, GeneralConstants.minTimeOut);
        System.out.println("issue date of sales invoice  " + getWebElement(invoiceIssueDateField).getText());
        return getWebElement(invoiceIssueDateField).getText();
    }
    public String getSupplierNameAtSalesInvoice() throws InterruptedException {
        waitUntilElementToBePresent(invoiceIssueDateField, GeneralConstants.minTimeOut);
        waitUntilElementToBePresent(supplierNameField,GeneralConstants.minTimeOut);

        System.out.println("supplier name at purchase invoice  " + getWebElement(supplierNameField).getText());
        return getWebElement(supplierNameField).getText();
    }

    public String getNetTotalValueAtPurchaseInvoice() {
        waitUntilElementToBePresent(invoiceIssueDateField, GeneralConstants.minTimeOut);
        System.out.println("net total value of purchase invoice  " + getWebElement(netTotalField).getText());
        return getWebElement(netTotalField).getText();
    }

    public String getGrandTotalValueAtPurchaseInvoice() {
        waitUntilElementToBePresent(invoiceIssueDateField, GeneralConstants.minTimeOut);
        System.out.println("grand total value of  purchase invoice  " + getWebElement(grandTotalField).getText());
        return getWebElement(grandTotalField).getText();
    }

    public void enterValidDataIntoPurchaseInvoicePage() throws InterruptedException {

        waitUntilElementToBePresent(newPurchaseInvoiceTitle, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        System.out.println("select  supplier ");
        getWebElement(supplierFieldPurchaseInvoice).click();
        waitUntilElementVisibility(supplierListPurchaseInvoice, GeneralConstants.minTimeOut);
        waitUntilElementToBeClickable(supplierOptPurchaseInvoice, GeneralConstants.minTimeOut);
        getWebElement(supplierOptPurchaseInvoice).click();
        System.out.println("Scroll down to item field ");
        scrollToSpeceficElement(totalAmountLabel);
        System.out.println(" select item  ");
        waitUntilElementToBePresent(itemCodeField, GeneralConstants.minTimeOut);
//        clickByActions(itemCodeField);
        getWebElement(itemCodeField).click();
        waitUntilElementToBePresent(itemCodeInputField, GeneralConstants.minTimeOut);
        getWebElement(itemCodeInputField).sendKeys("item 1");
        waitUntilElementToBeClickable(itemOpt, GeneralConstants.minTimeOut);
        getWebElement(itemCodeInputField).clear();
        getWebElement(itemCodeInputField).sendKeys("item 1");

        waitUntilElementToBeClickable(selectedItem, GeneralConstants.minTimeOut);
        clickByActions(selectedItem);

        System.out.println("unselect update stock opt");
        waitUntilElementToBeClickable(updateStockBtn, GeneralConstants.minTimeOut);
//        getWebElement(updateStockBtn).click();
        clickByActions(updateStockBtn);

        System.out.println("scroll up to save and submit btn ");
        scrollToSpeceficElement(saveAndSubmitBtn);
        System.out.println("click on save and submit btn ");
//        actions.moveToElement(getWebElement(saveAndSubmitBtn)).perform();
        getWebElement(saveAndSubmitBtn).click();
//        Thread.sleep(10000);
        System.out.println("click on yes btn ");
        waitUntilElementToBeClickable(yesBtn, GeneralConstants.minTimeOut);
        getWebElement(yesBtn).click();

    }

    public PurchaseInvoicesListPage goToPurchaseListView() throws InterruptedException {
        waitUntilElementToBePresent(createBtn, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        System.out.println("navigate to purchase invoices list  ");
        waitUntilElementToBeClickable(purchaseInvoicesOpt, GeneralConstants.minTimeOut);

//        if (tryToGetWebElement(closeIcon) == GeneralConstants.SUCCESS) {
////            getWebElement(closeIcon).click();
//            clickByActions(closeIcon);
//        }
        getWebElement(purchaseInvoicesOpt).click();
        driver.navigate().refresh();
        return new PurchaseInvoicesListPage(driver);
    }

    public GeneralLedgerReportPage openGeneralLedgerReport() {
        System.out.println("click on view btn ");
        scrollToSpeceficElement(viewBtn);
        waitUntilElementToBePresent(viewBtn, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        if (tryToGetWebElement(closeIcon) == GeneralConstants.SUCCESS) {
            getWebElement(closeIcon).click();
        }
        getWebElement(viewBtn).click();
        System.out.println("click on general ledger choice ");
        waitUntilElementToBePresent(generalLedgerChoice, GeneralConstants.minTimeOut);
        getWebElement(generalLedgerChoice).click();
        return new GeneralLedgerReportPage(driver);
    }

    public String getGrandTotalAmountOfPurchaseInvoice() {
        waitUntilElementToBePresent(viewBtn, GeneralConstants.minTimeOut);

        scrollToSpeceficElement(grandTotalAmountValue);
        waitUntilElementToBePresent(grandTotalAmountValue, GeneralConstants.minTimeOut);
        System.out.println("grand total amount of purchase invoice is " + getWebElement(grandTotalAmountValue).getText());
//        System.out.println("actual text is " + getWebElement(totalAmountValue).getText() + " and expected text is " + expected);
        return getWebElement(grandTotalAmountValue).getText();
    }

    public String getTotalAmountOfPurchaseInvoice() {
        waitUntilElementToBePresent(viewBtn, GeneralConstants.minTimeOut);

        scrollToSpeceficElement(totalAmountValue);
        waitUntilElementToBePresent(totalAmountValue, GeneralConstants.minTimeOut);
        System.out.println("total amount of purchase invoice is " + getWebElement(totalAmountValue).getText());
//        System.out.println("actual text is " + getWebElement(totalAmountValue).getText() + " and expected text is " + expected);
        return getWebElement(totalAmountValue).getText();
    }

    public String getPurchaseInvoicePaymentStatusBeforePayment(String unpaidStatus) {
        waitUntilElementToBePresent(unpaidStatusElement, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        System.out.println("actual text is " + getWebElement(unpaidStatusElement).getText() + " and expected test is " + unpaidStatus);
        return getWebElement(unpaidStatusElement).getText();
    }

    public PaymentPage createPaymentForPurchaseInvoice() {
        System.out.println("click on create btn");
        waitUntilElementVisibility(createBtn, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
//
//        if (tryToGetWebElement(closeIcon) == GeneralConstants.SUCCESS) {
//            clickByActions(closeIcon);
////            getWebElement(closeIcon).click();
//        }
        getWebElement(createBtn).click();
//        getWebElement(createBtn).click();
        System.out.println("click on payment");
        waitUntilElementVisibility(paymentChoice, GeneralConstants.minTimeOut);
        getWebElement(paymentChoice).click();
        return new PaymentPage(driver);
    }

    public String getPurchaseInvoicePaymentStatus(String paidStatus) {
        waitUntilElementToBePresent(this.paidStatus, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        System.out.println("actual text is " + getWebElement(this.paidStatus).getText() + " and expected test is " + paidStatus);
        return getWebElement(this.paidStatus).getText();
    }

    public String getInvoiceNameAtViewList(String expected) {

        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        System.out.println("actual text is " + getWebElement(invoiceNameAtViewList).getAttribute("title") + " and expected text is " + expected);
        return getWebElement(invoiceNameAtViewList).getText();
    }

    public String getInvoiceName(String expected) {
        System.out.println("Verify the name of purchase invoice  ");

        waitUntilElementToBePresent(viewBtn, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay,GeneralConstants.freezeTimeOut);
//        waitUntilElementNotContainText(invoiceName,"فاتورة");
        if (tryToGetWebElement(closeIcon) == GeneralConstants.SUCCESS) {
            getWebElement(closeIcon).click();
        }
        System.out.println("actual text is  " + getWebElement(invoiceName).getAttribute("title") + "  and expected text is  " + expected);
        return getWebElement(invoiceName).getText();
    }
    public String getInvoiceNameForPayment(String expected) {
        System.out.println("Verify the name of purchase invoice  ");

        waitUntilElementToBePresent(viewBtn, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay,GeneralConstants.freezeTimeOut);

        if (tryToGetWebElement(closeIcon) == GeneralConstants.SUCCESS) {
            getWebElement(closeIcon).click();
        }
        System.out.println("actual text is  " + getWebElement(invoiceNamePayment).getAttribute("title") + "  and expected text is  " + expected);
        return getWebElement(invoiceNamePayment).getText();
    }
    public String getInvoiceStatus(String expected) {
        System.out.println("Verify the status of purchase invoice  ");
        waitUntilElementToBePresent(createBtn, GeneralConstants.minTimeOut);
        System.out.println("actual text is " + getWebElement(invoiceStatus).getText() + " and expected test is " + expected);
        return getWebElement(invoiceStatus).getText();
    }

    public void saveAndSubmitPurchaseInvoiceFromPurchaseOrder() throws InterruptedException {

        waitUntilElementVisibility(saveAndSubmitBtnFromAnotherDoc, GeneralConstants.minTimeOut);
        System.out.println(" save and submit purchase invoice ");
        getWebElement(saveAndSubmitBtnFromAnotherDoc).click();
        System.out.println("click on yes btn ");
        waitUntilElementToBeClickable(yesBtn_PO, GeneralConstants.minTimeOut);
        getWebElement(yesBtn_PO).click();
    }

    public void saveAndSubmitPurchaseInvoiceFromPurchaseReceipt() throws InterruptedException {

        waitUntilElementVisibility(saveAndSubmitBtnFromAnotherDoc, GeneralConstants.minTimeOut);
        scrollToSpeceficElement(updateStockBtn);
        waitUntilElementToBePresent(updateStockBtn, GeneralConstants.minTimeOut);
        getWebElement(updateStockBtn).click();
        scrollToSpeceficElement(notSavedLabel);
        waitUntilElementToBePresent(saveAndSubmitBtnFromAnotherDoc, GeneralConstants.minTimeOut);
        System.out.println(" save and submit purchase invoice ");
        getWebElement(saveAndSubmitBtnFromAnotherDoc).click();
//        clickByActions(saveAndSubmitBtnFromAnotherDoc);
        System.out.println("click on yes btn ");
        waitUntilElementToBeClickable(yesBtn_PO, GeneralConstants.minTimeOut);
        getWebElement(yesBtn_PO).click();
    }

    public DebitNotePage createDebitNoteFromPurchaseInvoice() throws InterruptedException {
        System.out.println("click on create btn");
        waitUntilElementToBeClickable(viewBtn, GeneralConstants.minTimeOut);

        if (tryToGetWebElement(closeIcon) == GeneralConstants.SUCCESS) {
            getWebElement(closeIcon).click();
        }
        getWebElement(viewBtn).click();
        getWebElement(createBtn).click();
//        clickByActions(createBtn);
//        clickByActions(createNewBtn);
        System.out.println("click on debit note");
        waitUntilElementVisibility(debitNoteChoice, GeneralConstants.minTimeOut);
        getWebElement(debitNoteChoice).click();
        return new DebitNotePage(driver);
    }
}
