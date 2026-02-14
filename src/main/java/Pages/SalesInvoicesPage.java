package Pages;

import GeneralConstants.GeneralConstants;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SalesInvoicesPage extends MainPage {
    private String dataMigrationTitle = "data migration";
    // private WebDriver driver ;

    public SalesInvoicesPage(WebDriver driver) {
        this.driver = driver;
    }

    private By checkVmConnectionBtn = By.id("check_vm_connection");
    private By updateStockBtn = By.xpath("//*[contains(@id,'update_stock ')] " +
            " | //input[contains(@data-fieldname,'update_stock')]");
    private By validationMsg = By.className("msgprint");
    private By editIcon = By.className("icon-xs");
    // فثسف
    private By newSalesInvoiceTitle = By.xpath("//*[contains(@title,'فاتورة المبيعات جديد')]");
    private By customerFieldSalesInvoice = By.xpath("(//*[contains(@id,'customer')])[4]");
    private By itemCodeField = By.xpath("(//*[contains(@data-fieldname,'item_code')])[2]");
    private By itemPriceField = By.xpath("(//*[contains(@data-fieldtype,'Currency')])[3]");
    private By itemCodeInputField = By.xpath("(//*[contains(@id,'item_code')])");
    private By customersListSalesInvoice = By.xpath("(//*[contains(@data-target,'Customer')and @placeholder=' ']/following-sibling::ul)");
    private By customerOptSalesInvoice = By.xpath("((//*[contains(@data-target,'Customer')and @placeholder=' ']/following-sibling::ul)/li)[1] " +
            "| ((//*[contains(@data-target,'Customer')and @placeholder=' ']/following-sibling::ul)/div/p/strong)[1]");
    private By itemOpt = By.xpath("((//*[contains(@data-target,'Item')and @placeholder='صنف']/following-sibling::ul)/li)[1]" +
            "| ((//*[contains(@data-target,'Item')and @placeholder='صنف']/following-sibling::ul)//div/p/strong)[1]");

    private By dueDateField = By.xpath("//*[contains(@id,'due_date')]");
    //*[contains(@class,'ellipsis title-text')]/following-sibling::div/span
    private By successStatusField = By.xpath("//*[contains(@class,'ellipsis title-text')]/following-sibling::div/span" +
            "|//*[contains(@class,'title-text pull-left')]/following-sibling::div//span[contains(@class,'label label-success')]");
    private By draftStatusField = By.xpath("(//*[contains(@class,'ellipsis title-text')]/following-sibling::span)[4]");
    private By selectedCustomer = By.xpath("//*[contains(@data-fieldname,'customer')]/../ul/div/p/strong");
    private By netTotalField = By.xpath("(//*[contains(@title,'net_total_export')]//span)[3]" +
            "| (//*[@data-fieldname='total']//span[@dir='rtl'])[1]");
    private By grandTotalField = By.xpath("(//*[contains(@title,'grand_total_export')]//span)[3]" +
            "| //*[contains(text(),'المجموع الإجمالي')]/following-sibling::div/div/span");
    private By paidStatusField = By.xpath("//*[contains(@class,'progress-chart col-md-12')]//h5" +
            "|//*[contains(@class,'progress-chart col-md-12')]//p");
    private By customerNameField = By.xpath("//*[contains(text(),' اسم العميل')]/../following-sibling::div/a" +
            "|//*[@data-fieldname='customer']//*[@data-doctype='Customer']");
    private By invoiceIssueDateField = By.xpath("//*[contains(text(),' تاريخ ادخال الفاتورة')]/../following-sibling::div" +
            "|//label[contains(@for,'posting_date')]/following-sibling::div " +
            "| //*[contains(@for,'posting_date')]/following-sibling::div ");
    private By listCount = By.xpath("(//*[contains(@class,'list-count')])");
    private By draftLabel = By.xpath("(//h3[contains(text(),'مسودة')])");
    private By saveAndSubmitBtn = By.xpath("//*[contains(@class,'btn btn-inverse btn-sm save-submit-action toolbar-btn')]" +
            "|(//*[contains(@id,'appframe-btn-حفظ')])[2]");
    private By saveBtn = By.xpath("//*[contains(@data-action_name,'Save')]" +
            "|(//*[contains(@id,'appframe-btn-حفظ')])[2]");
    private By saveAndSubmitBtnFromAnotherDoc = By.xpath("(//*[contains(@class,'btn btn-inverse btn-sm save-submit-action toolbar-btn')])[2]");
    private By yesBtn = By.xpath("(//*[contains(@class,'btn btn-primary btn-sm btn-modal-primary')])" +
            "|(//*[contains(@class,'btn  btn-yes')])");
    private By submittedStatus = By.xpath("(//*[contains(@class,'label label-success')])");
    private By draftStatus = By.xpath("(//*[contains(@class,'indicator-pill no-indicator-dot whitespace-nowrap red')])/span");
    private By invoiceName = By.xpath("(//h3[contains(@class,'ellipsis title-text')])[4]");
    private By invoiceLabel = By.xpath("(//h3[contains(@class,'ellipsis title-text')])[4]");
    private By DraftInvoiceName = By.xpath("(//h3[contains(@class,'ellipsis title-text')])[3]");
    private By invoiceNameForCreditNote = By.xpath("(//h3[contains(@class,'ellipsis title-text')])[3]");
    private By invoiceNameForPaymentReq = By.xpath("(//h3[contains(@class,'ellipsis title-text')])[3]");
    private By invoiceNameAtViewList = By.xpath("(//a[contains(@data-doctype,'Sales Invoice')])[1]");
    private By yesBtn_SO = By.xpath("(//*[contains(@class,'btn btn-primary btn-sm btn-modal-primary')])[2]");
    private By createBtn = By.xpath("//*[contains(@class,'btn toolbar-btn btn-primary')]" +
            "|//button[contains(text(),'معاينة')]");
    private By salesInvoicesOpt = By.xpath("//*[contains(@id,'sidebar-selling-invoice')]");
    private By grandTotalAmountValue = By.xpath("//div[@data-fieldname='grand_total']/div/div/div/div[2]/div/span");
    private By totalAmountValueWithOutTax = By.xpath("//div[@data-fieldname='total']/div/div/div/div[2]/div/span");
    private By creditNoteChoice = By.xpath("//*[contains(text(),'مرتجع / اشعار دائن') and @class = 'dropdown-item']");
    private By paymentChoice = By.xpath("//*[contains(text(),'دفع') and @class = 'dropdown-item']");
    private By itemsLabel = By.xpath("(//*[contains(text(),'الاصناف')])[2]");
    private By totalAmountLabel = By.xpath("(//*[contains(text(),'الكمية الإجمالية')])");
    private By posProfileUInputField = By.xpath("//input[contains(@data-fieldname,'pos_profile')]");
    private By posProfileChoice = By.xpath("(//input[contains(@data-fieldname,'pos_profile')]/following-sibling::ul/li)[1]");
    private By viewBtn = By.xpath("(//button[contains(text(),'واجهة')])[2]");
    private By generalLedgerChoice = By.xpath("(//a[contains(text(),'موازنة دفتر الأستاذ')])");
    private By posViewBtn = By.xpath("(//button[contains(text(),'واجهة نقاط البيع')])[1]");
    private By isPosCheckBox = By.id("is_pos");
    By overlay = By.xpath("//*[contains(@class,'freeze-message-container')]");

    private By paidStatus = By.xpath("(//*[@class='indicator-pill no-indicator-dot whitespace-nowrap green'])");
    private By unpaidStatusElement = By.xpath("(//*[@class='indicator-pill no-indicator-dot whitespace-nowrap orange'])");
    By loadImage = By.xpath("(//*[contains(@alt,'Generic Empty State')])[3]" +
            "| (//*[contains(@class,'progress progress-striped active')])" +
            "|(//*[contains(@id,'freeze')])");
    private By barcodeField = By.xpath("(//*[contains(@title,'الباركود')]//*[contains(@data-fieldname,'barcode')])[3]");

    private By namingField = By.xpath("(//*[contains(@title,'تسمية السلسلة')]//*[contains(@title,'إختر')])[3]");
    private By namingOpt = By.xpath("(//*[contains(@title,'تسمية السلسلة')]//ul//li//a)[4]");
    private By paymentsTab = By.id("sales-invoice-payments_tab-tab");
    private By taxesTab = By.id("sales-invoice-custom_taxes_and_charges-tab");
    private By discountTab = By.xpath("(//*[contains(@data-fieldname,'totals')]/following-sibling::div)[1]");
    private By writeOffAmountField = By.xpath("(//*[@id='write_off_amount'])");
    private By discountAmountField = By.xpath("(//*[@id='discount_amount'])");
    private By firstAdvancesTab = By.xpath("(//*[contains(@data-name,'new-sales-invoice-advance')])[1]");
    private By allocatedAmountInputField = By.xpath("((//*[contains(@data-name,'new-sales-invoice-advance')])[1]//div[contains(@data-fieldname,'allocated_amount')]//span)");
    private By allocatedAmountInputField_2 = By.xpath("(//*[contains(@data-name,'new-sales-invoice-advance')])[1]//div[contains(@data-fieldname,'allocated_amount')]//input");
    private By getAdvancesBtn = By.xpath("(//*[@id='get_advances'])");
    private By writeOffAccountField = By.xpath("(//*[@id='write_off_account'])");
    private By writeOffSection = By.xpath("//*[@data-fieldname='write_off_section']");
    private By taxesCheckBox = By.xpath("//*[@data-fieldname='taxes']//*[contains(@data-name,'new-sales-taxes-and-charges')]//input[@type='checkbox']");
    private By removeBtn = By.xpath("//*[@data-fieldname='taxes']//*[@data-action='delete_rows']");
    private By emptyMsg = By.xpath("//*[@data-fieldname='taxes']//*[contains(@class,'grid-empty text-center')]");
    private By writeOffSectionIndicator = By.xpath("//*[@data-fieldname='loyalty_points_redemption']");
    private By advancesSection = By.xpath("//*[@data-fieldname='advances_section']");
    private By chosenWriteOffAccount = By.xpath("((//*[@id='write_off_account']//following-sibling::*)//div//p)[1]");

    public By totalOutstandingAmountValue = By.xpath("(//*[contains(@for,'outstanding_amount')]//following-sibling::*//div//span)[1]");
    private By filterIcon = By.xpath("//*[contains(@class,'filter-x-button')]");
    public void applyWriteOff(double amount) throws InterruptedException {
        scrollToSpeceficElement(paymentsTab);
        System.out.println(" open payments section");
        waitUntilElementVisibility(paymentsTab, GeneralConstants.minTimeOut);
        getWebElement(paymentsTab).click();
        System.out.println(" enter write off amount");
        waitUntilElementVisibility(writeOffSection, GeneralConstants.minTimeOut);

        clickByActions(writeOffSection);
        waitUntilElementVisibility(writeOffAmountField, GeneralConstants.minTimeOut);
        clickByActions(writeOffAmountField);
        getWebElement(writeOffAmountField).click();
        getWebElement(writeOffAmountField).sendKeys(Keys.CONTROL, "a");
        getWebElement(writeOffAmountField).sendKeys(Keys.DELETE);
        getWebElement(writeOffAmountField).sendKeys(String.valueOf(amount));
        System.out.println("entered write off amount is  " + amount);
        waitUntilElementVisibility(writeOffAccountField, GeneralConstants.minTimeOut);
        getWebElement(writeOffAccountField).click();

        if (tryToGetWebElementV(chosenWriteOffAccount) == GeneralConstants.SUCCESS) {
            waitUntilElementVisibility(chosenWriteOffAccount, GeneralConstants.minTimeOut);
            getWebElement(chosenWriteOffAccount).click();
        }
    }

    public void removeTaxes() throws InterruptedException {

        System.out.println(" open Taxes section");
        waitUntilElementVisibility(taxesTab, GeneralConstants.minTimeOut);
        getWebElement(taxesTab).click();
        System.out.println("remove taxes");
        waitUntilElementVisibility(taxesCheckBox, GeneralConstants.minTimeOut);
//        getWebElement(writeOffSection).click();
        clickByActions(taxesCheckBox);
        waitUntilElementVisibility(removeBtn, GeneralConstants.minTimeOut);
        clickByActions(removeBtn);
        System.out.println(" taxes removed ");
        waitUntilElementVisibility(emptyMsg, GeneralConstants.minTimeOut);
    }
    public void applyDiscount(double amount) throws InterruptedException {
        scrollToSpeceficElement(discountTab);
        System.out.println(" open discount section");
        waitUntilElementVisibility(discountTab, GeneralConstants.minTimeOut);

        clickByActions(discountTab);
        System.out.println(" enter discount amount");
        waitUntilElementToBePresent(discountAmountField, GeneralConstants.minTimeOut);
        scrollToSpeceficElement(discountAmountField);
        waitUntilElementVisibility(discountAmountField, GeneralConstants.minTimeOut);
        clickByActions(discountAmountField);
        getWebElement(discountAmountField).click();
        getWebElement(discountAmountField).sendKeys(String.valueOf(amount));
        System.out.println("entered discount amount is  " + amount);


    }

    public void clickOnWriteOffSection() throws InterruptedException {
//    waitUntilElementVisibility(settingIcon, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        scrollToSpeceficElement(writeOffSectionIndicator);
        clickByActions(writeOffSectionIndicator);
    }

    public void payWithAdvances(double amount) throws InterruptedException {
        scrollToSpeceficElement(paymentsTab);
        System.out.println(" open payments section");
        waitUntilElementVisibility(paymentsTab, GeneralConstants.minTimeOut);
        getWebElement(paymentsTab).click();
        System.out.println(" use advances section ");
        waitUntilElementVisibility(advancesSection, GeneralConstants.minTimeOut);
        clickByActions(advancesSection);
        waitUntilElementVisibility(getAdvancesBtn, GeneralConstants.minTimeOut);
        clickByActions(getAdvancesBtn);
        waitUntilElementVisibility(firstAdvancesTab, GeneralConstants.minTimeOut);
        waitUntilElementVisibility(allocatedAmountInputField, GeneralConstants.minTimeOut);
        System.out.println(" enter allocated amount ");
        clickByActions(allocatedAmountInputField);
//        Thread.sleep(threadTimeOut);
//        clickByActions(allocatedAmountInputField);

//        getWebElement(writeOffAmountField).sendKeys(Keys.CONTROL, "a");
        waitUntilElementVisibility(allocatedAmountInputField_2, GeneralConstants.minTimeOut);
        getWebElement(allocatedAmountInputField_2).sendKeys(Keys.DELETE);
        getWebElement(allocatedAmountInputField_2).sendKeys(String.valueOf(amount));
        System.out.println("entered allocated amount is  " + amount);

    }

    public String getTotalAmountValue() throws InterruptedException {
        waitUntilElementNotHaveSpecificText(totalAmountValue, "0.00");

        System.out.println("total amount value is " + getWebElement(totalAmountValue).getAttribute("textContent"));
        return getWebElement(totalAmountValue).getAttribute("textContent");
    }

    public String getTotalOutstandingAmountValue() throws InterruptedException {
        waitUntilElementVisibility(draftStatus, GeneralConstants.minTimeOut);

        System.out.println("total outstanding amount value  after apply write off is " + getWebElement(totalOutstandingAmountValue).getAttribute("textContent"));
        Allure.step("total outstanding amount value  after apply write off is " + getWebElement(totalOutstandingAmountValue).getAttribute("textContent"));
        return getWebElement(totalOutstandingAmountValue).getAttribute("textContent");
    }

    public void enterValidDataIntoSalesInvoicePageAndSumbit(String dueDate, String itemName) throws InterruptedException {
        By selectedItem = By.xpath("((//*[contains(@data-target,'Item')and @placeholder='صنف']/following-sibling::ul)//div//p[@title='" + itemName + "'])");

        waitUntilElementToBePresent(newSalesInvoiceTitle, GeneralConstants.minTimeOut);
        Allure.step("select  customer ");
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        getWebElement(customerFieldSalesInvoice).click();
        if (tryToGetWebElementV(customersListSalesInvoice) == GeneralConstants.FAILED) {
            getWebElement(customerFieldSalesInvoice).click();
        }
//        clickByJs(getWebElement(customerFieldSalesInvoice));
        waitUntilElementToBePresent(customersListSalesInvoice, GeneralConstants.minTimeOut);
        waitUntilElementToBeClickable(customerOptSalesInvoice, GeneralConstants.minTimeOut);
        getWebElement(customerOptSalesInvoice).click();
        Allure.step("enter dues date  ");
        waitUntilElementVisibility(dueDateField, GeneralConstants.minTimeOut);
        getWebElement(dueDateField).sendKeys(dueDate);
        Allure.step("Scroll down to item field ");
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        scrollToSpeceficElement(totalAmountLabel);
        Allure.step(" select item  ");
        clickByActions(itemCodeField);
        waitUntilElementToBePresent(itemCodeInputField, GeneralConstants.minTimeOut);
        getWebElement(itemCodeInputField).sendKeys(itemName);
        waitUntilElementToBeClickable(itemOpt, GeneralConstants.minTimeOut);
        getWebElement(itemCodeInputField).clear();
        getWebElement(itemCodeInputField).sendKeys(itemName);
        waitUntilElementToBeClickable(selectedItem, GeneralConstants.minTimeOut);
        clickByActions(selectedItem);
        Allure.step("unselect update stock opt");
        getWebElement(updateStockBtn).click();

        Allure.step("scroll up to save and submit btn ");
        scrollToSpeceficElement(saveAndSubmitBtn);

        Allure.step(" save and submit sales invoice ");
        getWebElement(saveAndSubmitBtn).click();
        Allure.step("click on yes btn ");
        waitUntilElementToBeClickable(yesBtn, GeneralConstants.minTimeOut);
        getWebElement(yesBtn).click();
        waitUntilOverlayDisappear(overlay,GeneralConstants.minTimeOut);
        waitUntilElementToBePresent(viewBtn, GeneralConstants.minTimeOut);

    }

    public void clickOnSaveAndSubmitBtn()
    {      Allure.step("scroll up to save and submit btn ");
        scrollToSpeceficElement(saveAndSubmitBtn);

        Allure.step(" save and submit sales invoice ");
        getWebElement(saveAndSubmitBtn).click();
        Allure.step("click on yes btn ");
        waitUntilElementToBeClickable(yesBtn, GeneralConstants.minTimeOut);
        getWebElement(yesBtn).click();
        waitUntilElementToBePresent(viewBtn, GeneralConstants.minTimeOut);

    }

    public void saveAndSubmitSalesInvoice_4() throws InterruptedException {


        Allure.step("select  series naming ");
        waitUntilElementToBeClickable(namingField, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(loadImage, GeneralConstants.globalTimeOut);
        getWebElement(namingField).click();
        waitUntilElementVisibility(namingOpt, GeneralConstants.minTimeOut);
        getWebElement(namingOpt).click();

        Allure.step("select update stock opt");
        scrollToSpeceficElement(updateStockBtn);
        getWebElement(updateStockBtn).click();
        Allure.step(" click on save and submit btn   ");
        clickByActions(barcodeField);
        waitUntilOverlayDisappear(loadImage, GeneralConstants.globalTimeOut);
        scrollToSpeceficElement(saveBtn);
        Thread.sleep(threadTimeOut);
        clickByActions(saveBtn);
        waitUntilOverlayDisappear(loadImage, GeneralConstants.globalTimeOut);
        Allure.step("click on yes btn ");
        waitUntilElementToBeClickable(yesBtn, GeneralConstants.minTimeOut);
        getWebElement(yesBtn).click();
    }

    public void enterValidDataIntoSalesInvoicePageAndSave(String dueDate, String itemName) throws InterruptedException {
        By selectedItem = By.xpath("((//*[contains(@data-target,'Item')and @placeholder='صنف']/following-sibling::ul)//div//p[@title='" + itemName + "'])");

        waitUntilElementToBePresent(newSalesInvoiceTitle, GeneralConstants.minTimeOut);
        Allure.step("select  customer ");
        getWebElement(customerFieldSalesInvoice).click();
        if (tryToGetWebElementV(customersListSalesInvoice) == GeneralConstants.FAILED) {
            getWebElement(customerFieldSalesInvoice).click();
        }
//        clickByJs(getWebElement(customerFieldSalesInvoice));
        waitUntilElementToBePresent(customersListSalesInvoice, GeneralConstants.minTimeOut);
        waitUntilElementToBeClickable(customerOptSalesInvoice, GeneralConstants.minTimeOut);
        getWebElement(customerOptSalesInvoice).click();
        Allure.step("enter dues date  ");
        waitUntilElementVisibility(dueDateField, GeneralConstants.minTimeOut);
        getWebElement(dueDateField).sendKeys(dueDate);
        Allure.step("Scroll down to item field ");
        scrollToSpeceficElement(totalAmountLabel);
        Allure.step(" select item  ");
        clickByActions(itemCodeField);
        waitUntilElementToBePresent(itemCodeInputField, GeneralConstants.minTimeOut);
        getWebElement(itemCodeInputField).sendKeys(itemName);
        waitUntilElementToBeClickable(itemOpt, GeneralConstants.minTimeOut);
        getWebElement(itemCodeInputField).clear();
        getWebElement(itemCodeInputField).sendKeys(itemName);
        getWebElement(itemCodeInputField).clear();
        getWebElement(itemCodeInputField).sendKeys(itemName);
        waitUntilElementToBeClickable(selectedItem, GeneralConstants.minTimeOut);
        clickByActions(selectedItem);

        Allure.step("unselect update stock opt");
//        getWebElement(updateStockBtn).click();
        waitUntilElementToBeClickable(updateStockBtn, GeneralConstants.minTimeOut);
        clickByActions(updateStockBtn);


    }

    public void clickOnSaveBtn() {
        Allure.step("scroll up to save btn ");
        scrollToSpeceficElement(saveBtn);

        Allure.step(" save sales invoice ");
        getWebElement(saveBtn).click();

        waitUntilElementToBePresent(createBtn, GeneralConstants.minTimeOut);
    }

    public void clickOnSaveBtnForValidation() {
        Allure.step("scroll up to save btn ");
        scrollToSpeceficElement(saveBtn);

        Allure.step(" save sales invoice ");
        getWebElement(saveBtn).click();


    }

    public String getValidationMsg() {
        waitUntilElementVisibility(validationMsg, GeneralConstants.minTimeOut);
//        System.out.println(" validation msg is " + getWebElement(validationMsg).getText());
        return getWebElement(validationMsg).getText();
    }

    public PosViewPage openPosView() throws InterruptedException {
        Allure.step("click on is pos view btn");
        waitUntilElementToBePresent(posViewBtn, GeneralConstants.minTimeOut);
        getWebElement(posViewBtn).click();
        Allure.step("click on accept btn ");
//        Thread.sleep(9000);
        waitUntilElementNotToBeVisible(posViewBtn, GeneralConstants.minTimeOut);
//        Alert alert = driver.switchTo().alert();
//        alert.accept();
//       Allure.step("choose POS profile ");
//        waitUntilElementToBePresent(posProfileUInputField, GeneralConstants.minTimeOut);
//        getWebElement(posProfileUInputField).click();
        return new PosViewPage(driver);
    }

    public void saveAndSubmitSalesInvoiceFromSalesOrder() throws InterruptedException {

        waitUntilElementVisibility(saveAndSubmitBtnFromAnotherDoc, GeneralConstants.minTimeOut);
        scrollToSpeceficElement(updateStockBtn);
        Allure.step("unselect update stock opt");
        getWebElement(updateStockBtn).click();
        scrollToSpeceficElement(saveAndSubmitBtnFromAnotherDoc);
        waitUntilElementToBePresent(saveAndSubmitBtnFromAnotherDoc, GeneralConstants.minTimeOut);
        Allure.step("save and submit sales invoice  ");
        getWebElement(saveAndSubmitBtnFromAnotherDoc).click();
        Allure.step("click on yes btn ");
        waitUntilElementToBeClickable(yesBtn_SO, GeneralConstants.minTimeOut);
        getWebElement(yesBtn_SO).click();
        waitUntilElementToBePresent(createBtn, GeneralConstants.minTimeOut);
    }

    public void saveAndSubmitSalesInvoiceFromDeliveryNoteWithOutUpdateStock() throws InterruptedException {

        waitUntilElementVisibility(saveAndSubmitBtnFromAnotherDoc, GeneralConstants.minTimeOut);
        Allure.step("save and submit sales invoice  ");
        scrollToSpeceficElement(updateStockBtn);
        waitUntilElementToBePresent(updateStockBtn, GeneralConstants.minTimeOut);
        Allure.step(" unselect update stock checkbox ");
        getWebElement(updateStockBtn).click();
        scrollToSpeceficElement(saveAndSubmitBtnFromAnotherDoc);
        waitUntilElementToBePresent(saveAndSubmitBtnFromAnotherDoc, GeneralConstants.minTimeOut);
        getWebElement(saveAndSubmitBtnFromAnotherDoc).click();
        Allure.step("click on yes btn ");
        waitUntilElementToBeClickable(yesBtn_SO, GeneralConstants.minTimeOut);
        getWebElement(yesBtn_SO).click();
        waitUntilElementToBePresent(createBtn, GeneralConstants.minTimeOut);
    }

    public void saveAndSubmitSalesInvoiceFromDeliveryNoteWithUpdateStock() throws InterruptedException {

        waitUntilElementVisibility(saveAndSubmitBtnFromAnotherDoc, GeneralConstants.minTimeOut);
        Allure.step("save and submit sales invoice  ");

        scrollToSpeceficElement(saveAndSubmitBtnFromAnotherDoc);
        waitUntilElementToBePresent(saveAndSubmitBtnFromAnotherDoc, GeneralConstants.minTimeOut);
        getWebElement(saveAndSubmitBtnFromAnotherDoc).click();
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

    public PaymentPage createPaymentForSalesInvoice() {
        Allure.step("click on create btn");
        waitUntilElementVisibility(createBtn, GeneralConstants.minTimeOut);
        getWebElement(createBtn).click();
        Allure.step("click on payment");
        waitUntilElementVisibility(paymentChoice, GeneralConstants.minTimeOut);
        getWebElement(paymentChoice).click();
        return new PaymentPage(driver);
    }

    public String getInvoiceStatus(String expected) {
        Allure.step("Verify the status of sales invoice  ");
        waitUntilElementToBePresent(createBtn, GeneralConstants.minTimeOut);
        if (tryToGetWebElementV(submittedStatus) == GeneralConstants.SUCCESS) {
            Allure.step("actual text is " + getWebElement(submittedStatus).getText() + " and expected test is " + expected);
            return getWebElement(submittedStatus).getText();
        } else if (tryToGetWebElementV(draftStatus) == GeneralConstants.SUCCESS) {
            Allure.step("actual text is " + getWebElement(draftStatus).getText() + " and expected test is " + expected);
            return getWebElement(draftStatus).getText();
        } else
            return "unexpected status";
    }

    public String getSalesInvoicePaymentStatus(String paidStatus) {
        waitUntilElementToBePresent(this.paidStatus, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        Allure.step("actual text is " + getWebElement(this.paidStatus).getText() + " and expected test is " + paidStatus);
        return getWebElement(this.paidStatus).getText();
    }

    public String getSalesInvoicePaymentStatusBeforePayment(String unpaidStatus) {
        waitUntilElementToBePresent(unpaidStatusElement, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        Allure.step("actual text is " + getWebElement(unpaidStatusElement).getText() + " and expected test is " + unpaidStatus);
        return getWebElement(unpaidStatusElement).getText();
    }

    public String getPosInvoiceStatus(String expected) {
        Allure.step("open sales invoice which created using pos view ");
        getWebElement(invoiceNameAtViewList).click();
        waitUntilElementToBePresent(createBtn, GeneralConstants.minTimeOut);
        Allure.step("actual text is " + getWebElement(submittedStatus).getText() + " and expected test is " + expected);
        return getWebElement(submittedStatus).getText();
    }

    public String getInvoiceName(String expected) {
        Allure.step("Verify the name of sales invoice  ");
        waitUntilElementToBePresent(viewBtn, GeneralConstants.minTimeOut);
      System.out.println("actual text is  " + getWebElement(invoiceName).getAttribute("title") + "  and expected text is  " + expected);
        Allure.step("actual text is  " + getWebElement(invoiceName).getAttribute("title") + "  and expected text is  " + expected);
        return getWebElement(invoiceName).getText();
    }


    public String getSalesInvoiceStatus() {
        String draftStatus = "مسودة";
        waitUntilElementToBePresent(invoiceIssueDateField, GeneralConstants.minTimeOut);
        if (tryToGetWebElementV(successStatusField) == GeneralConstants.SUCCESS) {
//           Allure.step(" status of sales invoice  " + getWebElement(successStatusField).getText());
            return getWebElement(successStatusField).getText();
        } else {
//           Allure.step(" status of sales invoice  is " + draftStatus);
            return draftStatus;
        }
    }

    public String getSalesInvoicePaidStatus() {
        String paidStatus = "null";
        waitUntilElementToBePresent(invoiceIssueDateField, GeneralConstants.minTimeOut);

        if (tryToGetWebElementV(paidStatusField) == GeneralConstants.SUCCESS) {
            Allure.step("paid status of sales invoice  " + getWebElement(paidStatusField).getText());
            return getWebElement(paidStatusField).getText();
        } else {
            Allure.step("paid status of sales invoice  is  " + paidStatus + " and this meaning that this invoice is draft and not have paid status ");
            return paidStatus;
        }

    }

    public String getSalesInvoiceStatusAtDafater_5() {
        waitUntilElementToBePresent(invoiceIssueDateField, GeneralConstants.minTimeOut);
        if (tryToGetWebElementV(successStatusField) == GeneralConstants.SUCCESS) {
//           Allure.step("status of sales invoice  " + getWebElement(successStatusField).getText());
            return getWebElement(successStatusField).getText();
        } else {
//           Allure.step("status of sales invoice  is  " + getWebElement(draftStatusField).getText());
            return getWebElement(draftStatusField).getText();
        }
    }


    public String getSalesInvoiceIssueDate() {
        waitUntilElementToBePresent(invoiceIssueDateField, GeneralConstants.minTimeOut);
        System.out.println("issue date of sales invoice  " + getWebElement(invoiceIssueDateField).getText());
        Allure.step("issue date of sales invoice  " + getWebElement(invoiceIssueDateField).getText());
        return getWebElement(invoiceIssueDateField).getText();
    }


    public String getCustomerNameAtSalesInvoice() {
        waitUntilElementToBePresent(invoiceIssueDateField, GeneralConstants.minTimeOut);
        Allure.step("customer name at sales invoice  " + getWebElement(customerNameField).getText());
        return getWebElement(customerNameField).getText();
    }

    public String getCustomerNameAtSalesInvoiceAtDafater_5() {
        waitUntilElementToBePresent(invoiceIssueDateField, GeneralConstants.minTimeOut);

        System.out.println("customer name at sales invoice  " + getWebElement(customerNameField).getAttribute("textContent"));
        Allure.step("customer name at sales invoice  " + getWebElement(customerNameField).getAttribute("textContent"));
        return getWebElement(customerNameField).getAttribute("textContent");
    }

    public String getNetTotalValueAtSalesInvoice() {
        waitUntilElementToBePresent(invoiceIssueDateField, GeneralConstants.minTimeOut);
        Allure.step("net total value of sales invoice  " + getWebElement(netTotalField).getText());
        return getWebElement(netTotalField).getText();
    }

    public String getGrandTotalValueAtSalesInvoice() {
        waitUntilElementToBePresent(invoiceIssueDateField, GeneralConstants.minTimeOut);
        Allure.step("grand total value of  sales invoice  " + getWebElement(grandTotalField).getText());
        waitUntilElementToBePresent(grandTotalField, GeneralConstants.minTimeOut);
        return getWebElement(grandTotalField).getText();
    }


    public String getInvoiceName() {
        Allure.step("Verify the name of sales invoice  ");
        waitUntilElementToBePresent(viewBtn, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(invoiceLabel, GeneralConstants.minTimeOut);

       System.out.println("sales invoice name is   " + getWebElement(invoiceLabel).getAttribute("textContent"));
        Allure.step("sales invoice name is   " + getWebElement(invoiceLabel).getAttribute("textContent"));
        return getWebElement(invoiceLabel).getAttribute("textContent");
    }

    public String getDraftInvoiceName(String expected) {
        Allure.step("Verify the name of sales invoice  ");
        waitUntilElementToBePresent(createBtn, GeneralConstants.minTimeOut);
       System.out.println("actual text is  " + getWebElement(DraftInvoiceName).getAttribute("textContent") + "  and expected text is  " + expected);
        Allure.step("actual text is  " + getWebElement(DraftInvoiceName).getAttribute("textContent") + "  and expected text is  " + expected);
        return getWebElement(DraftInvoiceName).getAttribute("textContent");
    }


    public String getInvoiceNameForCreditNote(String expected) {
//       Allure.step("Verify the name of sales invoice  ");
        waitUntilElementToBePresent(viewBtn, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(invoiceNameForCreditNote, GeneralConstants.minTimeOut);
        Allure.step("actual text is  " + getWebElement(invoiceNameForCreditNote).getAttribute("title") + "  and expected text is  " + expected);
        return getWebElement(invoiceNameForCreditNote).getText();
    }

    public String getInvoiceNameForPayment(String expected) {
//       Allure.step("Verify the name of sales invoice  ");
        waitUntilElementToBePresent(viewBtn, GeneralConstants.minTimeOut);
        Allure.step("actual text is  " + getWebElement(invoiceNameForPaymentReq).getAttribute("title") + "  and expected text is  " + expected);
        return getWebElement(invoiceNameForPaymentReq).getText();
    }

    public PurchaseInvoicesListPage goToPurchaseListView() {
        waitUntilElementToBePresent(createBtn, GeneralConstants.minTimeOut);
        Allure.step("navigate to sales invoices list  ");
        getWebElement(salesInvoicesOpt).click();
        driver.navigate().refresh();
        return new PurchaseInvoicesListPage(driver);
    }


    public String getInvoiceNameAtViewList(String expected) throws InterruptedException {
        waitUntilElementToBePresent(createBtn, GeneralConstants.minTimeOut);
//        Allure.step("navigate to sales invoices list  ");
//        getWebElement(salesInvoicesOpt).click();
//        driver.navigate().refresh();
//
//        waitUntilElementVisibility(draftLabel, GeneralConstants.minTimeOut);
//        waitUntilElementVisibility(filterIcon, GeneralConstants.minTimeOut);
//        waitUntilElementToBeClickable(filterIcon, GeneralConstants.minTimeOut);
//        getWebElement(filterIcon).click();
//        Thread.sleep(threadTimeOut);
        System.out.println("actual text is " + getWebElement(invoiceNameAtViewList).getAttribute("textContent") + " and expected text is " + expected);
        Allure.step("actual text is " + getWebElement(invoiceNameAtViewList).getAttribute("textContent") + " and expected text is " + expected);
        return getWebElement(invoiceNameAtViewList).getAttribute("textContent");
    }


    public String getGrandTotalAmountOfSalesInvoice() {
        waitUntilElementToBePresent(viewBtn, GeneralConstants.minTimeOut);

        scrollToSpeceficElement(grandTotalAmountValue);
        waitUntilElementToBePresent(grandTotalAmountValue, GeneralConstants.minTimeOut);
        Allure.step("grand total amount of sales invoice is " + getWebElement(grandTotalAmountValue).getText());
//       Allure.step("actual text is " + getWebElement(totalAmountValue).getText() + " and expected text is " + expected);
        return getWebElement(grandTotalAmountValue).getText();
    }

    public String getTotalAmountOfSalesInvoice() {
        waitUntilElementToBePresent(viewBtn, GeneralConstants.minTimeOut);

        scrollToSpeceficElement(totalAmountValueWithOutTax);
        waitUntilElementToBePresent(totalAmountValueWithOutTax, GeneralConstants.minTimeOut);
        System.out.println("total amount of sales invoice is " + getWebElement(totalAmountValueWithOutTax).getAttribute("textContent"));
        Allure.step("total amount of sales invoice is " + getWebElement(totalAmountValueWithOutTax).getAttribute("textContent"));
//       Allure.step("actual text is " + getWebElement(totalAmountValue).getText() + " and expected text is " + expected);
        return getWebElement(totalAmountValueWithOutTax).getAttribute("textContent");
    }


    public GeneralLedgerReportPage openGeneralLedgerReport() {
        Allure.step("click on view btn ");
        scrollToSpeceficElement(viewBtn);
        waitUntilElementToBePresent(viewBtn, GeneralConstants.minTimeOut);
        getWebElement(viewBtn).click();
        Allure.step("click on general ledger choice ");
        waitUntilElementToBePresent(generalLedgerChoice, GeneralConstants.minTimeOut);
        getWebElement(generalLedgerChoice).click();
        return new GeneralLedgerReportPage(driver);
    }

    public ReportsListPage openReportsPage() {
        Allure.step("click on view btn ");
        scrollToSpeceficElement(viewBtn);
        waitUntilElementToBePresent(viewBtn, GeneralConstants.minTimeOut);
        getWebElement(viewBtn).click();
        Allure.step("click on general ledger choice ");
        waitUntilElementToBePresent(generalLedgerChoice, GeneralConstants.minTimeOut);
        getWebElement(generalLedgerChoice).click();
        return new ReportsListPage(driver);
    }

}
