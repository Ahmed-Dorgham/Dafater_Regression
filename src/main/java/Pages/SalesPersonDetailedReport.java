package Pages;

import GeneralConstants.GeneralConstants;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class SalesPersonDetailedReport extends MainPage {
    private String dataMigrationTitle = "data migration";
    // private WebDriver driver ;

    public SalesPersonDetailedReport(WebDriver driver) {
        this.driver = driver;
    }

    JavascriptExecutor js;
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
    private By docTypeNameInputfield = By.xpath("//*[contains(@class,'ui-state-default slick-headerrow-column b1 f1')]//input");
    private By grossProfitValue_4 = By.xpath("//*[contains(@class,'slick-cell b14 f14')]//span");
    private By sellingRate_4 = By.xpath("//*[contains(@class,'slick-cell b10 f10')]//span");
    private By avgBuyingValue_4 = By.xpath("//*[contains(@class,'slick-cell b11 f11')]//span");
    private By sellingAmountValue_4 = By.xpath("//*[contains(@class,'slick-cell b12 f12')]//span");
    private By buyingAmountValue_4 = By.xpath("//*[contains(@class,'slick-cell b13 f13')]//span");
    private By companyInputField = By.xpath("//*[@id='company']");
    private By generalLedgerReportTitle = By.xpath("//h3[@title='دفتر الأستاذ العام']");

    private By customerInputField_4 = By.xpath("//*[contains(@data-original-title,'عميل')]");
    private By customerSearchField_4 = By.xpath("//*[contains(@data-original-title,'عميل')]//*[contains(@aria-label,'Search')]");
    private By enteredCustomer = By.xpath("//*[contains(@data-original-title,'عميل')]//*[contains(@class,'active')]");
    private By sellingAmountValue = By.xpath("(//div[contains(@class,'dt-cell__content dt-cell__content--col-12')])[4]");
    private By creditValue_5 = By.xpath("(//*[contains(@class,'dt-cell__content dt-cell__content--col-4')])[4]");
    private By outstandingAmountValue = By.xpath("(//*[contains(@class,'slick-cell b3 f3')])[2]/div/div/span");
    private By debitValue_GL = By.xpath("(//*[contains(@class,'dt-cell__content dt-cell__content--col-3')])[7]");
    private By creditValue_GL = By.xpath("(//*[contains(@class,'dt-cell__content dt-cell__content--col-4')])[7]");
    private By outstandingAmounValue_5 = By.xpath("(//*[contains(@class,'dt-cell__content dt-cell__content--col-3')])[3]/div/span");
    By overlay = By.xpath("//*[contains(@class,'freeze-message-container')]");
    By loadImage = By.xpath("(//*[contains(@alt,'Generic Empty State')])[3]");
    By salesInvoiceInputField_5 = By.xpath("(//div[@data-fieldname='sales_invoice'])/div/div/input");
    By salesInvoiceField_5 = By.xpath("(//div[@data-fieldname='sales_invoice'])");
    By chosenCompany = By.xpath("(//*[contains(@data-target,'Company')])/following-sibling::ul/div/p/strong" +
            "|(//*[contains(@style,'font-weight: bold;')])");
    By chosenInvoice = By.xpath("(//div[@data-fieldname='sales_invoice']/div/div/ul/div/p/strong)[1]");
    By customerInputField_5 = By.xpath("//input[@data-fieldname='customer']");
    By accounts = By.xpath("//div[contains(@class,'dt-cell__content dt-cell__content--col-2')]");
    By footer = By.xpath("//div[contains(@class,'report-footer text-muted')]");
    By table = By.xpath("//div[@class='datatable dt-instance-1']//div[@class='dt-scrollable']");
    private By companyField_4 = By.xpath("//input[contains(@data-fieldname,'company')]");
    private By collectedAmountVal = By.xpath("//*[contains(@class,'ui-widget-content slick-row odd')]//*[contains(@class,'slick-cell b11 f11')]//span" +
            "|(//*[contains(@class,'dt-cell dt-cell--col-11')]//span)[last()]");
    By createBtn = By.xpath("//button[contains(@id,'appframe-btn-تحميل البيانات')]");
    private By activeDateField = By.xpath("//*[contains(@class,'ui-datepicker-current-day')]");
    private By activeDayField = By.xpath("(//*[contains(@class,'ui-datepicker-current-day')]//span)[2]");
    private By fromDateField = By.xpath("//input[contains(@data-fieldname,'from_date')]");
    private By toDateField = By.xpath("//input[contains(@data-fieldname,'to_date')]");
    By valueAtDefaultDebitAccount;
    By valueAtDefaultIncomeAccount;
    By valueAtDefaultExpenseAccount;
    By valueAtDefaultCreditAccount;
    public String getFromDateValue() {

        waitUntilElementToBePresent(fromDateField, GeneralConstants.minTimeOut);
        getWebElement(fromDateField).click();
        waitUntilElementVisibility(activeDateField, GeneralConstants.minTimeOut);
        String day = getWebElement(activeDayField).getText();
        String month = getWebElement(activeDateField).getAttribute("data-month");
        int monthNumber = Integer.parseInt(month) + 1;
        String year = getWebElement(activeDateField).getAttribute("data-year");
//        System.out.println(" from date field is " + day);
//        System.out.println(" from date field is " + Double.parseDouble(month));
//        System.out.println(" from date field is " + year);
        String fullDate = day + "-" + monthNumber + "-" + year;
        System.out.println(" from date value is " + fullDate);
        Allure.step(" from date value is " + fullDate);
        return fullDate;
    }
    public void setCompanyName(String companyName) {
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(companyInputField, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        Allure.step("enter company name ");
        getWebElement(companyInputField).click();
        getWebElement(companyInputField).clear();
        getWebElement(companyInputField).sendKeys(companyName);
        waitUntilElementVisibility(chosenCompany, GeneralConstants.minTimeOut);
        getWebElement(chosenCompany).click();

    }
    public String getToDateValue() {
        waitUntilElementToBePresent(toDateField, GeneralConstants.minTimeOut);
        getWebElement(toDateField).click();
        waitUntilElementVisibility(activeDateField, GeneralConstants.minTimeOut);
        String day = getWebElement(activeDayField).getText();
        String month = getWebElement(activeDateField).getAttribute("data-month");
        int monthNumber = Integer.parseInt(month) + 1;
        String year = getWebElement(activeDateField).getAttribute("data-year");
//        System.out.println(" to date field is " + day);
//        System.out.println(" to date field is " + Double.parseDouble(month));
//        System.out.println(" to date field is " + year);
        String fullDate = day + "-" + monthNumber + "-" + year;
        System.out.println(" to date value is " + fullDate);
        Allure.step(" to date value is " + fullDate);
        return fullDate;
    }

    public void setDatesValueAtDafater_5(String fromDate, String toDate) {
        waitUntilElementVisibility(fromDateField, GeneralConstants.minTimeOut);

        getWebElement(fromDateField).click();
        getWebElement(fromDateField).clear();
        getWebElement(fromDateField).sendKeys(fromDate);
        getWebElement(toDateField).click();
        getWebElement(toDateField).clear();
        getWebElement(toDateField).sendKeys(toDate);
    }

    public void enterValidDataIntoSalesInvoicePageAndSubmit(String dueDate) throws InterruptedException {
//        waitUntilElementToBePresent(newItemTitle, GeneralConstants.minTimeOut);
//       Allure.step("select  customer ");
//        getWebElement(customerFieldSalesInvoice).click();
//        if (tryToGetWebElement(customersListSalesInvoice) == GeneralConstants.FAILED) {
//            getWebElement(customerFieldSalesInvoice).click();
//        }
////        clickByJs(getWebElement(customerFieldSalesInvoice));
//        waitUntilElementToBePresent(customersListSalesInvoice, GeneralConstants.minTimeOut);
//        waitUntilElementToBeClickable(customerOptSalesInvoice, GeneralConstants.minTimeOut);
//        getWebElement(customerOptSalesInvoice).click();
        Allure.step("enter dues date  ");
        waitUntilElementVisibility(dueDateField, GeneralConstants.minTimeOut);
        getWebElement(dueDateField).sendKeys(dueDate);
        Allure.step("Scroll down to item field ");
        scrollToSpeceficElement(totalAmountLabel);
        //   Thread.sleep(6000);
        Allure.step(" select item  ");
        clickByActions(itemCodeField);
        waitUntilElementToBePresent(itemCodeInputField, GeneralConstants.minTimeOut);
        getWebElement(itemCodeInputField).sendKeys("item");
        waitUntilElementToBeClickable(itemGroupOpt, GeneralConstants.minTimeOut);
        clickByActions(itemGroupOpt);

        Allure.step("unselect update stock opt");
        getWebElement(updateStockBtn).click();

        Allure.step("scroll up to save and submit btn ");
        scrollToSpeceficElement(saveAndSubmitBtn);

        Allure.step(" save and submit sales invoice ");
        getWebElement(saveAndSubmitBtn).click();
        Allure.step("click on yes btn ");
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
                Allure.step(" default debit account name is " + getListOfWebElements(accounts).get(i).getAttribute("title"));
                j = i;
            }
        }
        return j + 1;
    }

    public void loadReportData_4() {
        Allure.step(" load supplier sales person detailed report data at dafater 4 ");

        waitUntilElementToBePresent(createBtn, GeneralConstants.minTimeOut);
        getWebElement(createBtn).click();
    }

    public String getSelectedCompanyName() {
        waitUntilElementToBePresent(companyField_4, GeneralConstants.minTimeOut);
        getWebElement(companyField_4).clear();
        getWebElement(companyField_4).click();
        waitUntilElementToBePresent(chosenCompany, GeneralConstants.minTimeOut);
        String companyName = getWebElement(chosenCompany).getText();
        getWebElement(chosenCompany).click();
        System.out.println(" chosen company is " + companyName);
        Allure.step(" chosen company is " + companyName);
        return companyName;
    }

    public String getCollectedAmountValue() throws InterruptedException {
        String collectedAmountValue = null;
        waitUntilOverlayDisappear(loadImage, GeneralConstants.minTimeOut);
        if (tryToGetWebElementV(collectedAmountVal) == GeneralConstants.SUCCESS) {
            waitUntilElementToBeClickable(collectedAmountVal, GeneralConstants.minTimeOut);
            collectedAmountValue = getWebElement(collectedAmountVal).getText();
            System.out.println("collected amount value at sales person detailed report is " + collectedAmountVal);
            Allure.step("collected amount value at sales person detailed report  is " + collectedAmountVal);
            return collectedAmountValue;
        } else {
            System.out.println("collected amount value at sales person detailed report is  0 ");
            Allure.step("collected amount value at sales person detailed report is 0");
            return "0.00";
        }
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
                Allure.step(" default income account name is " + getListOfWebElements(accounts).get(i).getAttribute("title"));
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
                Allure.step(" default Expense account name is " + getListOfWebElements(accounts).get(i).getAttribute("title"));
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
                Allure.step(" default credit account name is " + getListOfWebElements(accounts).get(i).getAttribute("title"));
                j = i;
            }
        }
        return j + 1;
    }

    public String getValueAtDefaultDebitAccountFromGL(int i) {
        valueAtDefaultDebitAccount = By.xpath("(//div[contains(@class,'dt-cell__content dt-cell__content--col-3')])[" + i + "]");
        Allure.step("value which exist at default debit account " + getWebElement(valueAtDefaultDebitAccount).getText());

        return getWebElement(valueAtDefaultDebitAccount).getText();
    }

    public String getValueAtDefaultIncomeAccountFromGL(int i) {
        valueAtDefaultIncomeAccount = By.xpath("(//div[contains(@class,'dt-cell__content dt-cell__content--col-4')])[" + i + "]");
        Allure.step("value which exist at default income account " + getWebElement(valueAtDefaultIncomeAccount).getText());

        return getWebElement(valueAtDefaultIncomeAccount).getText();
    }

    public String getValueAtDefaultCreditAccountFromGL(int i) {
        valueAtDefaultCreditAccount = By.xpath("(//div[contains(@class,'dt-cell__content dt-cell__content--col-4')])[" + i + "]");
        Allure.step("value which exist at default debit account " + getWebElement(valueAtDefaultCreditAccount).getText());

        return getWebElement(valueAtDefaultCreditAccount).getText();
    }

    public String getValueAtDefaultExpenseAccountFromGL(int i) {
        valueAtDefaultExpenseAccount = By.xpath("(//div[contains(@class,'dt-cell__content dt-cell__content--col-3')])[" + i + "]");
        Allure.step("value which exist at default expense  account " + getWebElement(valueAtDefaultExpenseAccount).getText());

        return getWebElement(valueAtDefaultExpenseAccount).getText();
    }

    public void applyFilters_4(String doctypeName) throws InterruptedException {
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementVisibility(loadDataBtn, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(loadImage, GeneralConstants.minTimeOut);
        Allure.step("click on load data btn ");
        getWebElement(loadDataBtn).click();
        waitUntilElementVisibility(docTypeNameInputfield, GeneralConstants.minTimeOut);
        Allure.step("enter doc type name  ");
        getWebElement(docTypeNameInputfield).sendKeys(doctypeName);
    }

    public String getGrossProfitValue_4() throws InterruptedException {
//        Thread.sleep(threadTimeOut);
        System.out.println("gross profit value is " + getWebElement(grossProfitValue_4).getText());
        Allure.step("gross profit value is " + getWebElement(grossProfitValue_4).getText());
        return getWebElement(grossProfitValue_4).getText();
    }

    public String getSellingRateValue_4() throws InterruptedException {
        Thread.sleep(threadTimeOut);
        System.out.println("selling rate value is " + getWebElement(sellingRate_4).getText());
        Allure.step("selling rate value is " + getWebElement(sellingRate_4).getText());
        return getWebElement(sellingRate_4).getText();
    }

    public String getSellingAmountValue_4() throws InterruptedException {
//        Thread.sleep(threadTimeOut);
        System.out.println("selling amount value is " + getWebElement(sellingAmountValue_4).getText());
        Allure.step("selling amount value is " + getWebElement(sellingAmountValue_4).getText());
        return getWebElement(sellingAmountValue_4).getText();
    }

    public String getAvgBuyingValue_4() throws InterruptedException {
//        Thread.sleep(threadTimeOut);
        System.out.println("avg buying value is " + getWebElement(avgBuyingValue_4).getText());
        Allure.step("avg buying value is " + getWebElement(avgBuyingValue_4).getText());
        return getWebElement(avgBuyingValue_4).getText();
    }

    public String getBuyingAmountValue_4() throws InterruptedException {
//        Thread.sleep(threadTimeOut);
        System.out.println(" buying amount value is " + getWebElement(buyingAmountValue_4).getText());
        Allure.step(" buying amount value is " + getWebElement(buyingAmountValue_4).getText());
        return getWebElement(buyingAmountValue_4).getText();
    }

    public void applyFilters_5(String companyName, String invoiceName) {
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(companyInputField, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        Allure.step("enter company name ");
        getWebElement(companyInputField).clear();
        getWebElement(companyInputField).sendKeys(companyName);
        waitUntilElementToBePresent(chosenCompany, GeneralConstants.minTimeOut);
        getWebElement(chosenCompany).click();
        Allure.step("enter sales invoice name ");
        waitUntilElementToBePresent(salesInvoiceField_5, GeneralConstants.minTimeOut);
        getWebElement(salesInvoiceField_5).click();
        waitUntilElementToBePresent(salesInvoiceInputField_5, GeneralConstants.minTimeOut);
        getWebElement(salesInvoiceInputField_5).sendKeys(invoiceName);
        waitUntilElementToBePresent(chosenInvoice, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        getWebElement(chosenInvoice).click();
    }

    public String getOutstandingAmountValue() {
        waitUntilElementToBePresent(outstandingAmountValue, GeneralConstants.minTimeOut);
        Allure.step(" outstanding amount value for selected customer is " + getWebElement(outstandingAmountValue).getText());
        return getWebElement(outstandingAmountValue).getText();
    }

    public String getClosingDebitValueForInvoiceAtGL() {
        waitUntilElementToBePresent(generalLedgerReportTitle, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(loadImage, GeneralConstants.freezeTimeOut);
        scrollToSpeceficElement(debitValue_GL);
        Allure.step(" closing debit value at general ledger report is " + getWebElement(debitValue_GL).getText());
        return getWebElement(debitValue_GL).getText();
    }


    public String getClosingCreditValueForInvoiceAtGL() {
        waitUntilElementToBePresent(generalLedgerReportTitle, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(loadImage, GeneralConstants.freezeTimeOut);
        scrollToSpeceficElement(creditValue_GL);
        Allure.step(" closing credit value at general ledger report is " + getWebElement(creditValue_GL).getText());
        return getWebElement(creditValue_GL).getText();
    }

    public String getOutstandingAmounValue_5() throws InterruptedException {
//        Thread.sleep(20000);
        waitUntilOverlayDisappear(loadImage, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(outstandingAmounValue_5, GeneralConstants.minTimeOut);
        Allure.step(" outstanding Amoun value for selected customer is " + getWebElement(outstandingAmounValue_5).getText());
        return getWebElement(outstandingAmounValue_5).getText();
    }

//    public String getSellingAmountValue() {
//
//        waitUntilElementToBePresent(sellingAmountValue, GeneralConstants.minTimeOut);
//       Allure.step(" credit value for selected account is " + getWebElement(sellingAmountValue).getText());
//        return getWebElement(sellingAmountValue).getText();
//    }

    public String getSellingAmountValue_5() throws InterruptedException {

        waitUntilOverlayDisappear(loadImage, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(sellingAmountValue, GeneralConstants.minTimeOut);
        Allure.step(" selling amount value for selected invoice is " + getWebElement(sellingAmountValue).getAttribute("title"));
        return getWebElement(sellingAmountValue).getAttribute("title");
    }

    public void enterValidDataIntoItemPage(String itemCode) throws InterruptedException {

        waitUntilElementToBePresent(newItemTitle, GeneralConstants.minTimeOut);

        Allure.step("enter item code");
        getWebElement(itemCodeInputField).sendKeys(itemCode);
        Allure.step("select item group ");
        getWebElement(itemGroupField).click();
        waitUntilElementToBePresent(itemGroupsList, GeneralConstants.minTimeOut);
        waitUntilElementToBePresent(itemGroupOpt, GeneralConstants.minTimeOut);
        getWebElement(itemGroupOpt).click();
        Allure.step("click on save btn ");
        getWebElement(saveBtn).click();
        waitUntilElementToBePresent(enablingLabel, GeneralConstants.minTimeOut);
    }

    public void enterValidDataForSalesItem(String itemCode) throws InterruptedException {

        waitUntilElementToBePresent(newItemTitle, GeneralConstants.minTimeOut);
        Allure.step("enter item code");
        getWebElement(itemCodeInputField).sendKeys(itemCode);
        Allure.step("select item group ");
        getWebElement(itemGroupField).click();
        waitUntilElementToBePresent(itemGroupsList, GeneralConstants.minTimeOut);
        waitUntilElementToBePresent(itemGroupOpt, GeneralConstants.minTimeOut);
        getWebElement(itemGroupOpt).click();
        Allure.step("click on purchase tab ");
        getWebElement(purchaseTab).click();
        getWebElement(purchaseTab).click();
        Allure.step("unselect is purchase item checkbox ");
        waitUntilElementToBePresent(isPurchaseItemCheckBox, GeneralConstants.minTimeOut);
        getWebElement(isPurchaseItemCheckBox).click();

        Allure.step("click on save btn ");
        getWebElement(saveBtn).click();
        waitUntilElementToBePresent(enablingLabel, GeneralConstants.minTimeOut);
    }

    public void enterValidDataForPurchaseItem(String itemCode) throws InterruptedException {

        waitUntilElementToBePresent(newItemTitle, GeneralConstants.minTimeOut);
        Allure.step("enter item code");
        getWebElement(itemCodeInputField).sendKeys(itemCode);
        Allure.step("select item group ");
        getWebElement(itemGroupField).click();
        waitUntilElementToBePresent(itemGroupsList, GeneralConstants.minTimeOut);
        waitUntilElementToBePresent(itemGroupOpt, GeneralConstants.minTimeOut);
        getWebElement(itemGroupOpt).click();
        Allure.step("click on sales tab ");
        getWebElement(salesTab).click();
        getWebElement(salesTab).click();
        Allure.step("unselect is sales item checkbox ");
        waitUntilElementToBePresent(isSalesItemCheckBox, GeneralConstants.minTimeOut);
        getWebElement(isSalesItemCheckBox).click();

        Allure.step("click on save btn ");
        getWebElement(saveBtn).click();
        waitUntilElementToBePresent(enablingLabel, GeneralConstants.minTimeOut);
    }

    public void createNewSalesItem(String itemCode) throws InterruptedException {

        waitUntilElementToBePresent(newItemTitle, GeneralConstants.minTimeOut);

        Allure.step("enter item code");
        getWebElement(itemCodeInputField).sendKeys(itemCode);
        Allure.step("select item group ");
        getWebElement(itemGroupField).click();
        waitUntilElementToBePresent(itemGroupsList, GeneralConstants.minTimeOut);
        waitUntilElementToBePresent(itemGroupOpt, GeneralConstants.minTimeOut);
        getWebElement(itemGroupOpt).click();


        Allure.step("click on save btn ");
        getWebElement(saveBtn).click();
        waitUntilElementToBePresent(enablingLabel, GeneralConstants.minTimeOut);


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

//    public void saveAndSubmitSalesInvoiceFromSalesOrder() throws InterruptedException {
//
//        waitUntilElementVisibility(saveAndSubmitBtnFromSalesOrder, GeneralConstants.minTimeOut);
//       Allure.step("save and submit sales invoice  ");
//        getWebElement(saveAndSubmitBtnFromSalesOrder).click();
//       Allure.step("click on yes btn ");
//        waitUntilElementToBeClickable(yesBtn_SO, GeneralConstants.minTimeOut);
//        getWebElement(yesBtn_SO).click();
//        waitUntilElementToBePresent(createBtn, GeneralConstants.minTimeOut);
//    }

//    public CreditNotePage createCreditNoteFromSalesInvoice() {
//       Allure.step("click on create btn");
//        waitUntilElementVisibility(createBtn, GeneralConstants.minTimeOut);
//        getWebElement(createBtn).click();
//       Allure.step("click on credit note");
//        waitUntilElementVisibility(creditNoteChoice, GeneralConstants.minTimeOut);
//        getWebElement(creditNoteChoice).click();
//        return new CreditNotePage(driver);
//    }

//    public String getInvoiceStatus(String expected) {
//       Allure.step("Verify the status of sales invoice  ");
//        waitUntilElementToBePresent(createBtn, GeneralConstants.minTimeOut);
//        if (tryToGetWebElement(submittedStatus) == GeneralConstants.SUCCESS) {
//           Allure.step("actual text is " + getWebElement(submittedStatus).getText() + " and expected test is " + expected);
//            return getWebElement(submittedStatus).getText();
//        } else if (tryToGetWebElement(draftStatus) == GeneralConstants.SUCCESS) {
//           Allure.step("actual text is " + getWebElement(draftStatus).getText() + " and expected test is " + expected);
//            return getWebElement(draftStatus).getText();
//        } else
//            return "unexpected status";
//    }

//    public String getPosInvoiceStatus(String expected) {
//       Allure.step("open sales invoice which created using pos view ");
//        getWebElement(invoiceNameAtViewList).click();
//        waitUntilElementToBePresent(createBtn, GeneralConstants.minTimeOut);
//       Allure.step("actual text is " + getWebElement(submittedStatus).getText() + " and expected test is " + expected);
//        return getWebElement(submittedStatus).getText();
//    }

    public String getItemName(String expected) {
        Allure.step("Verify the name of item  ");
        waitUntilElementToBePresent(enablingLabel, GeneralConstants.minTimeOut);
        Allure.step("actual text is  " + getWebElement(itemName).getText() + "  and expected text is  " + expected);
        return getWebElement(itemName).getText();
    }

    public String getItemCode(String expected) {
        Allure.step("Verify the name of item  ");
        waitUntilElementToBePresent(enablingLabel, GeneralConstants.minTimeOut);
        Allure.step("actual text is  " + getWebElement(ItemCode).getText() + "  and expected text is  " + expected);
        return getWebElement(ItemCode).getText();
    }
//
//    public String getDraftInvoiceName(String expected) {
//       Allure.step("Verify the name of sales invoice  ");
//        waitUntilElementToBePresent(createBtn, GeneralConstants.minTimeOut);
//       Allure.step("actual text is  " + getWebElement(DraftInvoiceName).getAttribute("title") + "  and expected text is  " + expected);
//        return getWebElement(DraftInvoiceName).getText();
//    }


    public String getInvoiceNameForCreditNote(String expected) {
//       Allure.step("Verify the name of sales invoice  ");
        waitUntilElementToBePresent(viewBtn, GeneralConstants.minTimeOut);
        Allure.step("actual text is  " + getWebElement(invoiceNameForCreditNote).getAttribute("title") + "  and expected text is  " + expected);
        return getWebElement(invoiceNameForCreditNote).getText();
    }
//
//    public PurchaseInvoicesListPage goToPurchaseListView() {
//        waitUntilElementToBePresent(createBtn, GeneralConstants.minTimeOut);
//       Allure.step("navigate to sales invoices list  ");
//        getWebElement(salesInvoicesOpt).click();
//        driver.navigate().refresh();
//        return new PurchaseInvoicesListPage(driver);
//    }

    //
//    public String getInvoiceNameAtViewList(String expected) {
//        waitUntilElementToBePresent(createBtn, GeneralConstants.minTimeOut);
//       Allure.step("navigate to sales invoices list  ");
//        getWebElement(salesInvoicesOpt).click();
//        driver.navigate().refresh();
//        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
//       Allure.step("actual text is " + getWebElement(invoiceNameAtViewList).getAttribute("title") + " and expected text is " + expected);
//        return getWebElement(invoiceNameAtViewList).getText();
//    }
    public ItemListPage openItemListPage() {

        Allure.step("navigate to item list ");
        waitUntilElementToBeClickable(itemOpt, GeneralConstants.minTimeOut);
        getWebElement(itemOpt).click();
        driver.navigate().refresh();
        waitUntilElementToBePresent(closeFilterIcon, GeneralConstants.minTimeOut);
        getWebElement(closeFilterIcon).click();
        return new ItemListPage(driver);
    }
}
