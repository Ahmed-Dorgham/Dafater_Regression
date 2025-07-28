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
    private By createBtn = By.xpath("//*[contains(text(),'انشاء') and contains(@class, 'btn btn-default toolbar-btn')]");
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
    private By supplierOptPurchaseInvoice = By.xpath("((//*[contains(@data-target,'Supplier')and @placeholder=' ']/following-sibling::ul)/li)[1]");
    private By itemOpt = By.xpath("((//*[contains(@data-target,'Item')and @placeholder='صنف']/following-sibling::ul)/li)[1]");
    private By dueDateField = By.xpath("//*[contains(@id,'due_date')]");
    private By saveAndSubmitBtn = By.xpath("//*[contains(@class,'btn btn-inverse btn-sm save-submit-action toolbar-btn')]");
    private By saveAndSubmitBtnFromPurchaseOrder = By.xpath("(//*[contains(@class,'btn btn-inverse btn-sm save-submit-action toolbar-btn')])[2]");
    private By yesBtn = By.xpath("(//*[contains(@class,'btn btn-primary btn-sm btn-modal-primary')])");
    private By yesBtn_PO = By.xpath("(//*[contains(@class,'btn btn-primary btn-sm btn-modal-primary')])[2]");
    private By totalAmountLabel = By.xpath("(//*[contains(text(),'الكمية الإجمالية')])");
    private By invoiceStatus = By.xpath("(//*[contains(@class,'label label-success')])");
    private By invoiceName = By.xpath("(//h3[contains(@class,'ellipsis title-text')])[4]");
    private By purchaseInvoicesOpt = By.xpath("//*[contains(@id,'sidebar-purchases-invoice')]");
    private By draftLabel = By.xpath("(//h3[contains(text(),'مسودة')])");
    private By invoiceNameAtViewList = By.xpath("(//a[contains(@data-doctype,'Purchase Invoice')])[1]");
    By overlay = By.xpath("//*[contains(@class,'freeze-message-container')]");
    public void enterValidDataIntoPurchaseInvoicePage() throws InterruptedException {
        waitUntilElementToBePresent(newPurchaseInvoiceTitle, GeneralConstants.minTimeOut);
        System.out.println("select  supplier ");
        getWebElement(supplierFieldPurchaseInvoice).click();
        waitUntilElementVisibility(supplierListPurchaseInvoice, GeneralConstants.minTimeOut);
        waitUntilElementToBeClickable(supplierOptPurchaseInvoice, GeneralConstants.minTimeOut);
        getWebElement(supplierOptPurchaseInvoice).click();
        System.out.println("Scroll down to item field ");
        scrollToSpeceficElement(totalAmountLabel);
        System.out.println(" select item  ");
        clickByActions(itemCodeField);
        waitUntilElementToBePresent(itemCodeInputField,GeneralConstants.minTimeOut);
        getWebElement(itemCodeInputField).sendKeys("item");
        waitUntilElementToBePresent(itemOpt,GeneralConstants.minTimeOut);
//        getWebElement(itemOpt).click();
        clickByActions(itemOpt);
        System.out.println("unselect update stock opt");
        getWebElement(updateStockBtn).click();

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
    public PurchaseInvoicesListPage goToPurchaseListView ()
    {
        waitUntilElementToBePresent(createBtn,GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay,GeneralConstants.freezeTimeOut);
        System.out.println("navigate to purchase invoices list  ");
        waitUntilElementToBeClickable(purchaseInvoicesOpt,GeneralConstants.minTimeOut);
        getWebElement(purchaseInvoicesOpt).click();
        driver.navigate().refresh();
        return new PurchaseInvoicesListPage(driver);
    }

    public String getInvoiceNameAtViewList(String expected) {

        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        System.out.println("actual text is " + getWebElement(invoiceNameAtViewList).getAttribute("title") + " and expected text is " + expected);
        return getWebElement(invoiceNameAtViewList).getText();
    }
    public String getInvoiceName(String expected) {
        System.out.println("Verify the name of purchase invoice  ");
        waitUntilElementToBePresent(viewBtn,GeneralConstants.minTimeOut);
        System.out.println("actual text is  " + getWebElement(invoiceName).getAttribute("title") + "  and expected text is  " + expected);
        return getWebElement(invoiceName).getText();
    }
    public String getInvoiceStatus(String expected) {
        System.out.println("Verify the status of purchase invoice  ");
        waitUntilElementToBePresent(createBtn,GeneralConstants.minTimeOut);
        System.out.println("actual text is " + getWebElement(invoiceStatus).getText() + " and expected test is " + expected);
        return getWebElement(invoiceStatus).getText();
    }

    public void saveAndSubmitPurchaseInvoiceFromPurchaseOrder() throws InterruptedException {

        waitUntilElementVisibility(saveAndSubmitBtnFromPurchaseOrder, GeneralConstants.minTimeOut);
        System.out.println(" save and submit purchase invoice ");
        getWebElement(saveAndSubmitBtnFromPurchaseOrder).click();
        System.out.println("click on yes btn ");
        waitUntilElementToBeClickable(yesBtn_PO, GeneralConstants.minTimeOut);
        getWebElement(yesBtn_PO).click();
    }
    public DebitNotePage createDebitNoteFromPurchaseInvoice() throws InterruptedException {
        System.out.println("click on create btn");
        waitUntilElementToBeClickable(viewBtn, GeneralConstants.minTimeOut);
       // Thread.sleep(10000);
//        clickByActions(viewBtn);
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
