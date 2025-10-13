package Pages;

import GeneralConstants.GeneralConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomersAgingReportPage extends MainPage {
    private String dataMigrationTitle = "data migration";
    // private WebDriver driver ;

    public CustomersAgingReportPage(WebDriver driver) {
        this.driver = driver;
    }

    private By checkVmConnectionBtn = By.id("check_vm_connection");
    private By updateStockBtn = By.id("update_stock");
    private By statusMsg = By.className("msgprint");
    private By editIcon = By.className("icon-xs");
    private By newItemTitle = By.xpath("//*[contains(@title,'صنف جديد')]");
    private By itemCodeField = By.xpath("(//*[contains(@id,'item_code')])[1]");
    private By itemGroupField = By.xpath("(//*[contains(@id,'item_group')])[2]");
    private By itemPriceField = By.xpath("(//*[contains(@data-fieldtype,'Currency')])[3]");
    private By itemCodeInputField = By.xpath("(//*[contains(@id,'item_code')])");
    private By itemGroupsList = By.xpath("(//*[contains(@data-target,'Item Group')and @placeholder=' ']/following-sibling::ul)");
    private By itemGroupOpt = By.xpath("((//*[contains(@data-target,'Item Group')and @placeholder=' ']/following-sibling::ul/li))[1]");
    //    private By itemOpt = By.xpath("((//*[contains(@data-target,'Item')and @placeholder='صنف']/following-sibling::ul)/li)[1]");
    private By dueDateField = By.xpath("//*[contains(@id,'due_date')]");
    private By salesTab = By.xpath("//*[contains(@id,'item-sales_details-tab')]");
    private By purchaseTab = By.xpath("//*[contains(@id,'item-purchasing_tab-tab')]");
    private By isPurchaseItemCheckBox = By.xpath("//*[contains(@id,'is_purchase_item')]");
    private By isSalesItemCheckBox = By.xpath("//*[contains(@id,'is_sales_item')]");
    private By listCount = By.xpath("(//*[contains(@class,'list-count')])");
    private By draftLabel = By.xpath("(//h3[contains(text(),'مسودة')])");
    private By saveAndSubmitBtn = By.xpath("//*[contains(@class,'btn btn-inverse btn-sm save-submit-action toolbar-btn')]");
    private By saveBtn = By.xpath("//*[contains(@data-action_name,'Save')]");
    private By enablingLabel = By.xpath("(//*[contains(@class,'indicator-pill no-indicator-dot whitespace-nowrap blue')])");
    private By saveAndSubmitBtnFromSalesOrder = By.xpath("(//*[contains(@class,'btn btn-inverse btn-sm save-submit-action toolbar-btn')])[2]");
    private By yesBtn = By.xpath("(//*[contains(@class,'btn btn-primary btn-sm btn-modal-primary')])");
    private By submittedStatus = By.xpath("(//*[contains(@class,'label label-success')])");
    private By draftStatus = By.xpath("(//*[contains(@class,'indicator-pill no-indicator-dot whitespace-nowrap red')])/span");
    private By itemName = By.xpath("(//h3[contains(@class,'ellipsis title-text')])[4]");
    private By ItemCode = By.xpath("(//h3[contains(@class,'ellipsis title-text')])[3]");
    private By DraftInvoiceName = By.xpath("(//h3[contains(@class,'ellipsis title-text')])[4]");
    private By invoiceNameForCreditNote = By.xpath("(//h3[contains(@class,'ellipsis title-text')])[1]");
    private By invoiceNameAtViewList = By.xpath("(//a[contains(@data-doctype,'Sales Invoice')])[1]");
    private By yesBtn_SO = By.xpath("(//*[contains(@class,'btn btn-primary btn-sm btn-modal-primary')])[2]");
    private By viewBtn = By.xpath("(//*[contains(@class,'btn btn-default toolbar-btn')])[2]");
    private By salesInvoicesOpt = By.xpath("//*[contains(@id,'sidebar-selling-invoice')]");
    private By creditNoteChoice = By.xpath("//*[contains(text(),'مرتجع / اشعار دائن') and @class = 'dropdown-item']");
    private By itemsLabel = By.xpath("(//*[contains(text(),'الاصناف')])[2]");
    private By totalAmountLabel = By.xpath("(//*[contains(text(),'الكمية الإجمالية')])");
    private By posProfileUInputField = By.xpath("//input[contains(@data-fieldname,'pos_profile')]");
    private By posProfileChoice = By.xpath("(//input[contains(@data-fieldname,'pos_profile')]/following-sibling::ul/li)[1]");
    //    private By viewBtn = By.xpath("(//button[contains(text(),'واجهة')])[2]");
    private By posViewBtn = By.xpath("(//button[contains(text(),'واجهة نقاط البيع')])[1]");
    private By isPosCheckBox = By.id("is_pos");
    private By itemOpt = By.xpath("(//*[contains(@id,'sidebar-stock-item')]/span)[1]");
    private By closeFilterIcon = By.xpath("(//*[contains(@class,'filter-icon')])[2]");
    private By loadDataBtn = By.xpath("//*[contains(@id,'appframe-btn-تحميل البيانات')]");
    private By companyInputField = By.xpath("//*[@id='company']");
    private By generalLedgerReportTitle = By.xpath("//h3[@title='دفتر الأستاذ العام']");

    private By customerInputField_4 = By.xpath("//*[contains(@data-original-title,'عميل')]");
    private By chosenCustomer_4 = By.xpath("((//*[contains(@data-original-title,'عميل')]//ul//li)[2]/a/span)[1]");
    private By enteredCustomer = By.xpath("//*[contains(@data-original-title,'عميل')]//*[contains(@class,'active')]");
    private By creditValue = By.xpath("(//*[contains(@class,'slick-cell b6 f6')])[3]/div/div/span");
    private By creditValue_5 = By.xpath("(//*[contains(@class,'dt-cell__content dt-cell__content--col-4')])[4]");
    private By outstandingAmountValue = By.xpath("(//*[contains(@class,'slick-cell b3 f3')])[2]/div/div/span");
    private By debitValue_GL = By.xpath("(//*[contains(@class,'dt-cell__content dt-cell__content--col-3')])[7]");
    private By creditValue_GL = By.xpath("(//*[contains(@class,'dt-cell__content dt-cell__content--col-4')])[7]");
    private By outstandingAmounValue_5 = By.xpath("(//*[contains(@class,'dt-cell__content dt-cell__content--col-3')])[3]/div/span");
    By overlay = By.xpath("//*[contains(@class,'freeze-message-container')]");
    By loadImage = By.xpath("(//*[contains(@alt,'Generic Empty State')])[3]");
    By customerField_5 = By.xpath("(//div[@data-fieldname='customer'])");
    By chosenCompany = By.xpath("(//*[contains(@data-target,'Company')])/following-sibling::ul/div/p/strong");
    By chosenCustomer = By.xpath("(//div[@data-fieldname='customer']/div/div/ul/div/p/strong)[1]");
    By zeroValueBtn = By.id("show_accounts_with_zero_value");
    By customerInputField_5 = By.xpath("//input[@data-fieldname='customer']");
    By accounts = By.xpath("//div[contains(@class,'dt-cell__content dt-cell__content--col-2')]");
    By footer = By.xpath("//div[contains(@class,'report-footer text-muted')]");
    By valueAtDefaultDebitAccount;
    By valueAtDefaultIncomeAccount;
    By valueAtDefaultExpenseAccount;
    By valueAtDefaultCreditAccount;

    public void enterValidDataIntoSalesInvoicePageAndSubmit(String dueDate) throws InterruptedException {
//        waitUntilElementToBePresent(newItemTitle, GeneralConstants.minTimeOut);
//        System.out.println("select  customer ");
//        getWebElement(customerFieldSalesInvoice).click();
//        if (tryToGetWebElement(customersListSalesInvoice) == GeneralConstants.FAILED) {
//            getWebElement(customerFieldSalesInvoice).click();
//        }
////        clickByJs(getWebElement(customerFieldSalesInvoice));
//        waitUntilElementToBePresent(customersListSalesInvoice, GeneralConstants.minTimeOut);
//        waitUntilElementToBeClickable(customerOptSalesInvoice, GeneralConstants.minTimeOut);
//        getWebElement(customerOptSalesInvoice).click();
        System.out.println("enter dues date  ");
        waitUntilElementVisibility(dueDateField, GeneralConstants.minTimeOut);
        getWebElement(dueDateField).sendKeys(dueDate);
        System.out.println("Scroll down to item field ");
        scrollToSpeceficElement(totalAmountLabel);
        //   Thread.sleep(6000);
        System.out.println(" select item  ");
        clickByActions(itemCodeField);
        waitUntilElementToBePresent(itemCodeInputField, GeneralConstants.minTimeOut);
        getWebElement(itemCodeInputField).sendKeys("item");
        waitUntilElementToBeClickable(itemGroupOpt, GeneralConstants.minTimeOut);
        clickByActions(itemGroupOpt);

        System.out.println("unselect update stock opt");
        getWebElement(updateStockBtn).click();

        System.out.println("scroll up to save and submit btn ");
        scrollToSpeceficElement(saveAndSubmitBtn);

        System.out.println(" save and submit sales invoice ");
        getWebElement(saveAndSubmitBtn).click();
        System.out.println("click on yes btn ");
        waitUntilElementToBeClickable(yesBtn, GeneralConstants.minTimeOut);
        getWebElement(yesBtn).click();
        waitUntilElementToBePresent(viewBtn, GeneralConstants.minTimeOut);

    }

    public int getDefaultDebitAccountFromGL(String defaultDebitAccount) throws InterruptedException {
        int i;
        int j = 0;
        waitUntilElementToBePresent(generalLedgerReportTitle, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(loadImage, GeneralConstants.freezeTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        Thread.sleep(threadTimeOut);
        scrollToSpeceficElement(footer);
        getListOfWebElements(accounts);
        for (i = 0; i < getListOfWebElements(accounts).size(); i++) {
            if (getListOfWebElements(accounts).get(i).getAttribute("title").contains(defaultDebitAccount)) {
                System.out.println(" default debit account name is " + getListOfWebElements(accounts).get(i).getAttribute("title"));
                j = i;
            }
        }
        return j + 1;
    }

    public int getDefaultIncomeAccountFromGL(String defaultIncomeAccount) {
        int i;
        int j = 0;
        waitUntilElementToBePresent(generalLedgerReportTitle, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(loadImage, GeneralConstants.freezeTimeOut);
        scrollToSpeceficElement(footer);
        getListOfWebElements(accounts);
        for (i = 0; i < getListOfWebElements(accounts).size(); i++) {
            if (getListOfWebElements(accounts).get(i).getAttribute("title").contains(defaultIncomeAccount)) {
                System.out.println(" default income account name is " + getListOfWebElements(accounts).get(i).getAttribute("title"));
                j = i;
            }
        }
        return j + 1;
    }

    public int getDefaultExpenseAccountFromGL(String defaultIncomeAccount) throws InterruptedException {
        int i;
        int j = 0;
        waitUntilElementToBePresent(generalLedgerReportTitle, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(loadImage, GeneralConstants.freezeTimeOut);

        scrollToSpeceficElement(footer);
        getListOfWebElements(accounts);
        for (i = 0; i < getListOfWebElements(accounts).size(); i++) {
            if (getListOfWebElements(accounts).get(i).getAttribute("title").contains(defaultIncomeAccount)) {
                System.out.println(" default Expense account name is " + getListOfWebElements(accounts).get(i).getAttribute("title"));
                j = i;
            }
        }
        return j + 1;
    }

    public int getDefaultCreditAccountFromGL(String defaultCreditAccount) throws InterruptedException {
        int i;
        int j = 0;
        waitUntilElementToBePresent(generalLedgerReportTitle, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(loadImage, GeneralConstants.freezeTimeOut);
        Thread.sleep(threadTimeOut);
        scrollToSpeceficElement(footer);
        getListOfWebElements(accounts);
        for (i = 0; i < getListOfWebElements(accounts).size(); i++) {
            if (getListOfWebElements(accounts).get(i).getAttribute("title").contains(defaultCreditAccount)) {
                System.out.println(" default credit account name is " + getListOfWebElements(accounts).get(i).getAttribute("title"));
                j = i;
            }
        }
        return j + 1;
    }

    public String getValueAtDefaultDebitAccountFromGL(int i) {
        valueAtDefaultDebitAccount = By.xpath("(//div[contains(@class,'dt-cell__content dt-cell__content--col-3')])[" + i + "]");
        System.out.println("value which exist at default debit account " + getWebElement(valueAtDefaultDebitAccount).getText());

        return getWebElement(valueAtDefaultDebitAccount).getText();
    }

    public String getValueAtDefaultIncomeAccountFromGL(int i) {
        valueAtDefaultIncomeAccount = By.xpath("(//div[contains(@class,'dt-cell__content dt-cell__content--col-4')])[" + i + "]");
        System.out.println("value which exist at default income account " + getWebElement(valueAtDefaultIncomeAccount).getText());

        return getWebElement(valueAtDefaultIncomeAccount).getText();
    }

    public String getValueAtDefaultCreditAccountFromGL(int i) {
        valueAtDefaultCreditAccount = By.xpath("(//div[contains(@class,'dt-cell__content dt-cell__content--col-4')])[" + i + "]");
        System.out.println("value which exist at default debit account " + getWebElement(valueAtDefaultCreditAccount).getText());

        return getWebElement(valueAtDefaultCreditAccount).getText();
    }
    public String getValueAtDefaultExpenseAccountFromGL(int i) {
        valueAtDefaultExpenseAccount = By.xpath("(//div[contains(@class,'dt-cell__content dt-cell__content--col-3')])[" + i + "]");
        System.out.println("value which exist at default expense  account " + getWebElement(valueAtDefaultExpenseAccount).getText());

        return getWebElement(valueAtDefaultExpenseAccount).getText();
    }

    public String chooseCustomer() {
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(loadDataBtn, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        System.out.println("enter specific customer ");
        waitUntilElementToBePresent(customerInputField_4, GeneralConstants.minTimeOut);
        getWebElement(customerInputField_4).click();
        waitUntilElementToBePresent(chosenCustomer_4, GeneralConstants.minTimeOut);
        String chosenCustomerName = getWebElement(chosenCustomer_4).getText().split("\\(")[0].trim();
        getWebElement(chosenCustomer_4).click();
        System.out.println("chosen customer name is " + chosenCustomerName);
        getWebElement(loadDataBtn).click();
        waitUntilOverlayDisappear(loadImage, freezeTimeOut);
        return chosenCustomerName;
    }
    public void applyFilters_5(String companyName, String customerName) {
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(companyInputField, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        System.out.println("enter company name ");
        getWebElement(companyInputField).clear();
        getWebElement(companyInputField).sendKeys(companyName);
        waitUntilElementToBePresent(chosenCompany, GeneralConstants.minTimeOut);
        getWebElement(chosenCompany).click();
        System.out.println("enter Customer name ");
        waitUntilElementToBePresent(customerField_5, GeneralConstants.minTimeOut);
        getWebElement(customerField_5).click();
        waitUntilElementToBePresent(customerInputField_5, GeneralConstants.minTimeOut);
        getWebElement(customerInputField_5).sendKeys(customerName);
        waitUntilElementToBePresent(chosenCustomer, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        getWebElement(chosenCustomer).click();
        getWebElement(zeroValueBtn).click();
    }
    public String getOutstandingAmountValue() {
        waitUntilElementToBePresent(outstandingAmountValue, GeneralConstants.minTimeOut);
        System.out.println(" outstanding amount value for selected customer is " + getWebElement(outstandingAmountValue).getText());
        return getWebElement(outstandingAmountValue).getText();
    }

    public String getClosingDebitValueForInvoiceAtGL() {
        waitUntilElementToBePresent(generalLedgerReportTitle, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(loadImage, GeneralConstants.freezeTimeOut);
        scrollToSpeceficElement(debitValue_GL);
        System.out.println(" closing debit value at general ledger report is " + getWebElement(debitValue_GL).getText());
        return getWebElement(debitValue_GL).getText();
    }


    public String getClosingCreditValueForInvoiceAtGL() {
        waitUntilElementToBePresent(generalLedgerReportTitle, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(loadImage, GeneralConstants.freezeTimeOut);
        scrollToSpeceficElement(creditValue_GL);
        System.out.println(" closing credit value at general ledger report is " + getWebElement(creditValue_GL).getText());
        return getWebElement(creditValue_GL).getText();
    }

    public String getOutstandingAmounValue_5() throws InterruptedException {
//        Thread.sleep(20000);
        waitUntilOverlayDisappear(loadImage, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(outstandingAmounValue_5, GeneralConstants.minTimeOut);
        System.out.println(" outstanding Amoun value for selected customer is " + getWebElement(outstandingAmounValue_5).getText());
        return getWebElement(outstandingAmounValue_5).getText();
    }

    public String getCreditValue() {

        waitUntilElementToBePresent(creditValue, GeneralConstants.minTimeOut);
        System.out.println(" credit value for selected account is " + getWebElement(creditValue).getText());
        return getWebElement(creditValue).getText();
    }

    public String getCreditValue_5() throws InterruptedException {
        waitUntilOverlayDisappear(loadImage, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(creditValue_5, GeneralConstants.minTimeOut);
        System.out.println(" credit value for selected account is " + getWebElement(creditValue_5).getAttribute("title"));
        return getWebElement(creditValue_5).getText();
    }

    public void enterValidDataIntoItemPage(String itemCode) throws InterruptedException {

        waitUntilElementToBePresent(newItemTitle, GeneralConstants.minTimeOut);

        System.out.println("enter item code");
        getWebElement(itemCodeInputField).sendKeys(itemCode);
        System.out.println("select item group ");
        getWebElement(itemGroupField).click();
        waitUntilElementToBePresent(itemGroupsList, GeneralConstants.minTimeOut);
        waitUntilElementToBePresent(itemGroupOpt, GeneralConstants.minTimeOut);
        getWebElement(itemGroupOpt).click();
        System.out.println("click on save btn ");
        getWebElement(saveBtn).click();
        waitUntilElementToBePresent(enablingLabel, GeneralConstants.minTimeOut);
    }

    public void enterValidDataForSalesItem(String itemCode) throws InterruptedException {

        waitUntilElementToBePresent(newItemTitle, GeneralConstants.minTimeOut);
        System.out.println("enter item code");
        getWebElement(itemCodeInputField).sendKeys(itemCode);
        System.out.println("select item group ");
        getWebElement(itemGroupField).click();
        waitUntilElementToBePresent(itemGroupsList, GeneralConstants.minTimeOut);
        waitUntilElementToBePresent(itemGroupOpt, GeneralConstants.minTimeOut);
        getWebElement(itemGroupOpt).click();
        System.out.println("click on purchase tab ");
        getWebElement(purchaseTab).click();
        getWebElement(purchaseTab).click();
        System.out.println("unselect is purchase item checkbox ");
        waitUntilElementToBePresent(isPurchaseItemCheckBox, GeneralConstants.minTimeOut);
        getWebElement(isPurchaseItemCheckBox).click();

        System.out.println("click on save btn ");
        getWebElement(saveBtn).click();
        waitUntilElementToBePresent(enablingLabel, GeneralConstants.minTimeOut);
    }

    public void enterValidDataForPurchaseItem(String itemCode) throws InterruptedException {

        waitUntilElementToBePresent(newItemTitle, GeneralConstants.minTimeOut);
        System.out.println("enter item code");
        getWebElement(itemCodeInputField).sendKeys(itemCode);
        System.out.println("select item group ");
        getWebElement(itemGroupField).click();
        waitUntilElementToBePresent(itemGroupsList, GeneralConstants.minTimeOut);
        waitUntilElementToBePresent(itemGroupOpt, GeneralConstants.minTimeOut);
        getWebElement(itemGroupOpt).click();
        System.out.println("click on sales tab ");
        getWebElement(salesTab).click();
        getWebElement(salesTab).click();
        System.out.println("unselect is sales item checkbox ");
        waitUntilElementToBePresent(isSalesItemCheckBox, GeneralConstants.minTimeOut);
        getWebElement(isSalesItemCheckBox).click();

        System.out.println("click on save btn ");
        getWebElement(saveBtn).click();
        waitUntilElementToBePresent(enablingLabel, GeneralConstants.minTimeOut);
    }

    public void createNewSalesItem(String itemCode) throws InterruptedException {

        waitUntilElementToBePresent(newItemTitle, GeneralConstants.minTimeOut);

        System.out.println("enter item code");
        getWebElement(itemCodeInputField).sendKeys(itemCode);
        System.out.println("select item group ");
        getWebElement(itemGroupField).click();
        waitUntilElementToBePresent(itemGroupsList, GeneralConstants.minTimeOut);
        waitUntilElementToBePresent(itemGroupOpt, GeneralConstants.minTimeOut);
        getWebElement(itemGroupOpt).click();


        System.out.println("click on save btn ");
        getWebElement(saveBtn).click();
        waitUntilElementToBePresent(enablingLabel, GeneralConstants.minTimeOut);


    }

    public PosViewPage openPosView() throws InterruptedException {
        System.out.println("click on is pos view btn");
        waitUntilElementToBePresent(posViewBtn, GeneralConstants.minTimeOut);
        getWebElement(posViewBtn).click();
        System.out.println("click on accept btn ");
//        Thread.sleep(9000);
        waitUntilElementNotToBeVisible(posViewBtn, GeneralConstants.minTimeOut);
//        Alert alert = driver.switchTo().alert();
//        alert.accept();
//        System.out.println("choose POS profile ");
//        waitUntilElementToBePresent(posProfileUInputField, GeneralConstants.minTimeOut);
//        getWebElement(posProfileUInputField).click();
        return new PosViewPage(driver);
    }

//    public void saveAndSubmitSalesInvoiceFromSalesOrder() throws InterruptedException {
//
//        waitUntilElementVisibility(saveAndSubmitBtnFromSalesOrder, GeneralConstants.minTimeOut);
//        System.out.println("save and submit sales invoice  ");
//        getWebElement(saveAndSubmitBtnFromSalesOrder).click();
//        System.out.println("click on yes btn ");
//        waitUntilElementToBeClickable(yesBtn_SO, GeneralConstants.minTimeOut);
//        getWebElement(yesBtn_SO).click();
//        waitUntilElementToBePresent(createBtn, GeneralConstants.minTimeOut);
//    }

//    public CreditNotePage createCreditNoteFromSalesInvoice() {
//        System.out.println("click on create btn");
//        waitUntilElementVisibility(createBtn, GeneralConstants.minTimeOut);
//        getWebElement(createBtn).click();
//        System.out.println("click on credit note");
//        waitUntilElementVisibility(creditNoteChoice, GeneralConstants.minTimeOut);
//        getWebElement(creditNoteChoice).click();
//        return new CreditNotePage(driver);
//    }

//    public String getInvoiceStatus(String expected) {
//        System.out.println("Verify the status of sales invoice  ");
//        waitUntilElementToBePresent(createBtn, GeneralConstants.minTimeOut);
//        if (tryToGetWebElement(submittedStatus) == GeneralConstants.SUCCESS) {
//            System.out.println("actual text is " + getWebElement(submittedStatus).getText() + " and expected test is " + expected);
//            return getWebElement(submittedStatus).getText();
//        } else if (tryToGetWebElement(draftStatus) == GeneralConstants.SUCCESS) {
//            System.out.println("actual text is " + getWebElement(draftStatus).getText() + " and expected test is " + expected);
//            return getWebElement(draftStatus).getText();
//        } else
//            return "unexpected status";
//    }

//    public String getPosInvoiceStatus(String expected) {
//        System.out.println("open sales invoice which created using pos view ");
//        getWebElement(invoiceNameAtViewList).click();
//        waitUntilElementToBePresent(createBtn, GeneralConstants.minTimeOut);
//        System.out.println("actual text is " + getWebElement(submittedStatus).getText() + " and expected test is " + expected);
//        return getWebElement(submittedStatus).getText();
//    }

    public String getItemName(String expected) {
        System.out.println("Verify the name of item  ");
        waitUntilElementToBePresent(enablingLabel, GeneralConstants.minTimeOut);
        System.out.println("actual text is  " + getWebElement(itemName).getText() + "  and expected text is  " + expected);
        return getWebElement(itemName).getText();
    }

    public String getItemCode(String expected) {
        System.out.println("Verify the name of item  ");
        waitUntilElementToBePresent(enablingLabel, GeneralConstants.minTimeOut);
        System.out.println("actual text is  " + getWebElement(ItemCode).getText() + "  and expected text is  " + expected);
        return getWebElement(ItemCode).getText();
    }
//
//    public String getDraftInvoiceName(String expected) {
//        System.out.println("Verify the name of sales invoice  ");
//        waitUntilElementToBePresent(createBtn, GeneralConstants.minTimeOut);
//        System.out.println("actual text is  " + getWebElement(DraftInvoiceName).getAttribute("title") + "  and expected text is  " + expected);
//        return getWebElement(DraftInvoiceName).getText();
//    }


    public String getInvoiceNameForCreditNote(String expected) {
//        System.out.println("Verify the name of sales invoice  ");
        waitUntilElementToBePresent(viewBtn, GeneralConstants.minTimeOut);
        System.out.println("actual text is  " + getWebElement(invoiceNameForCreditNote).getAttribute("title") + "  and expected text is  " + expected);
        return getWebElement(invoiceNameForCreditNote).getText();
    }
//
//    public PurchaseInvoicesListPage goToPurchaseListView() {
//        waitUntilElementToBePresent(createBtn, GeneralConstants.minTimeOut);
//        System.out.println("navigate to sales invoices list  ");
//        getWebElement(salesInvoicesOpt).click();
//        driver.navigate().refresh();
//        return new PurchaseInvoicesListPage(driver);
//    }

    //
//    public String getInvoiceNameAtViewList(String expected) {
//        waitUntilElementToBePresent(createBtn, GeneralConstants.minTimeOut);
//        System.out.println("navigate to sales invoices list  ");
//        getWebElement(salesInvoicesOpt).click();
//        driver.navigate().refresh();
//        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
//        System.out.println("actual text is " + getWebElement(invoiceNameAtViewList).getAttribute("title") + " and expected text is " + expected);
//        return getWebElement(invoiceNameAtViewList).getText();
//    }
    public ItemListPage openItemListPage() {

        System.out.println("navigate to item list ");
        waitUntilElementToBeClickable(itemOpt, GeneralConstants.minTimeOut);
        getWebElement(itemOpt).click();
        driver.navigate().refresh();
        waitUntilElementToBePresent(closeFilterIcon, GeneralConstants.minTimeOut);
        getWebElement(closeFilterIcon).click();
        return new ItemListPage(driver);
    }
}
