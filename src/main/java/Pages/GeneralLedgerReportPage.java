package Pages;

import GeneralConstants.GeneralConstants;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GeneralLedgerReportPage extends MainPage {
    private String dataMigrationTitle = "data migration";
    // private WebDriver driver ;

    public GeneralLedgerReportPage(WebDriver driver) {
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
    private By companyInputField = By.xpath("//*[@id='company'] " +
            "| //input[@data-fieldname='company']");
    private By generalLedgerReportTitle = By.xpath("//h3[@title='دفتر الأستاذ العام']");

    private By accountInputField_4 = By.xpath("//*[@data-fieldname='account']");
    private By voucherInputField_4 = By.xpath("//*[@data-fieldname='voucher_no']");
    private By issueDateField_4 = By.xpath("//*[@data-fieldname='from_date']");
    private By creditValue = By.xpath("(//*[contains(@class,'slick-cell b6 f6')])[last()]/div/div/span");
    private By creditValueF_5 = By.xpath("(//*[contains(@class,'dt-cell__content dt-cell__content--col-4')])[last()-1]");
    private By creditValue_5 = By.xpath("(//*[contains(@class,'dt-cell__content dt-cell__content--col-4')])[last()-1]");
    private By debitValue = By.xpath("(//*[contains(@class,'slick-cell b5 f5')])[last()]/div/div/span");
    private By balanceValue = By.xpath("(//*[contains(@class,'slick-cell b7 f7')])[last()]/div/div/span");
    private By debitValue_GL = By.xpath("(//*[contains(@class,'dt-cell__content dt-cell__content--col-3')])[last()]");
    private By creditValue_GL = By.xpath("(//*[contains(@class,'dt-cell__content dt-cell__content--col-4')])[last()]");
    private By debitValue_5 = By.xpath(" (//*[contains(@class,'dt-cell__content dt-cell__content--col-3')])[last()]");
    private By debitValueF_5 = By.xpath(" (//*[contains(@class,'dt-cell__content dt-cell__content--col-3')])[last()-1]");
    private By balanceValue_5 = By.xpath(" (//*[contains(@class,'dt-cell__content dt-cell__content--col-5')])[last()]");
    private By balanceValueF_5 = By.xpath(" (//*[contains(@class,'dt-cell__content dt-cell__content--col-5')])[last()-1]");
    By overlay = By.xpath("//*[contains(@class,'freeze-message-container')]");
    By loadImage = By.xpath("(//*[contains(@alt,'Generic Empty State')])[3]");
    By accountField_5 = By.xpath("(//*[contains(@data-fieldname,'account')])[1]");
    By deleteAllBtn = By.xpath("(//*[contains(@data-fieldname,'account')])[1]//button");
    By voucherInputField_5 = By.xpath("(//*[contains(@id,'voucher_no')])[1]");
    By issueDateField_5 = By.xpath("//input[@data-fieldname='from_date']");
    By chosenCompany = By.xpath("(//*[contains(@data-target,'Company')])/following-sibling::ul/li" +
            "| ((//*[contains(@data-target,'Company')])/following-sibling::ul/div/p/strong)" +
            " | //*[@id='ui-id-1']/li/a/span" +
            "|(//*[contains(@id,'ui-id')]/li/a/span)[1]");


    By chosenAccount = By.xpath("((//*[contains(@data-fieldname,'account')])/ul/div/li/div/strong)[1]" +
            "| ((//*[contains(@data-fieldname,'account')])/ul//div/p/strong)[1] " +
            "| //*[@id='ui-id-2']/li/a/span");
    By accountInputField_5 = By.xpath("(//*[contains(@class,'dropdown-input-wrapper')]/input)[1]");
    By accounts = By.xpath("//div[contains(@class,'dt-cell__content dt-cell__content--col-2')]");
    By footer = By.xpath("//div[contains(@class,'report-footer text-muted')]");
    By valueAtDefaultDebitAccount;
    By valueAtDefaultIncomeAccount;
    By valueAtDefaultExpenseAccount;
    By valueAtDefaultCreditAccount;

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

    public int getDefaultExpenseAccountOrDefaultStockNotBilledAccountFromGL(String defaultIncomeAccount) throws InterruptedException {
        int i;
        int j = 0;
        waitUntilElementToBePresent(generalLedgerReportTitle, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(loadImage, GeneralConstants.freezeTimeOut);

        scrollToSpeceficElement(footer);
        getListOfWebElements(accounts);
        for (i = 0; i < getListOfWebElements(accounts).size(); i++) {
            if (getListOfWebElements(accounts).get(i).getAttribute("title").contains(defaultIncomeAccount)) {
                Allure.step(" default Expense account or default Stock Not Billed Account name is " + getListOfWebElements(accounts).get(i).getAttribute("title"));
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
               System.out.println(" default credit account name is " + getListOfWebElements(accounts).get(i).getAttribute("title"));
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
        System.out.println("value which exist at default income account " + getWebElement(valueAtDefaultIncomeAccount).getText());
        Allure.step("value which exist at default income account " + getWebElement(valueAtDefaultIncomeAccount).getText());

        return getWebElement(valueAtDefaultIncomeAccount).getText();
    }

    public String getValueAtDefaultCreditAccountFromGL(int i) {
        valueAtDefaultCreditAccount = By.xpath("(//div[contains(@class,'dt-cell__content dt-cell__content--col-4')])[" + i + "]");
        Allure.step("value which exist at default credit account " + getWebElement(valueAtDefaultCreditAccount).getText());
        System.out.println("value which exist at default credit account " + getWebElement(valueAtDefaultCreditAccount).getText());

        return getWebElement(valueAtDefaultCreditAccount).getText();
    }

    public String getValueAtDefaultExpenseAccountFromGL(int i) {
        valueAtDefaultExpenseAccount = By.xpath("(//div[contains(@class,'dt-cell__content dt-cell__content--col-3')])[" + i + "]");
        Allure.step("value which exist at default expense  account " + getWebElement(valueAtDefaultExpenseAccount).getText());
        System.out.println("value which exist at default expense  account " + getWebElement(valueAtDefaultExpenseAccount).getText());

        return getWebElement(valueAtDefaultExpenseAccount).getText();
    }

    public String chooseCompany() {
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(loadDataBtn, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        Allure.step("enter specific company ");
        waitUntilElementToBePresent(companyInputField, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);

        getWebElement(companyInputField).click();
        getWebElement(companyInputField).clear();
        getWebElement(companyInputField).click();
        waitUntilElementToBePresent(chosenCompany, GeneralConstants.minTimeOut);
        String chosenCompanyName = getWebElement(chosenCompany).getText();
        getWebElement(chosenCompany).click();
        System.out.println(" chosen company is " + chosenCompanyName);
        Allure.step(" chosen company is " + chosenCompanyName);
        return chosenCompanyName;
    }


    public String chooseAccount() {
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(loadDataBtn, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        Allure.step("enter specific account ");
        waitUntilElementToBePresent(accountInputField_4, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);

        getWebElement(accountInputField_4).click();
        waitUntilElementToBePresent(chosenAccount, GeneralConstants.minTimeOut);
        String chosenAccountName = getWebElement(chosenAccount).getText();
        getWebElement(chosenAccount).click();
        Allure.step(" chosen account is " + chosenAccountName);
        return chosenAccountName;
    }

    public void searchAboutSpecificVoucher(String voucherName,String issueDate) {
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(loadDataBtn, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        Allure.step("enter specific voucher  ");
        waitUntilElementToBePresent(voucherInputField_4, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        getWebElement(voucherInputField_4).sendKeys(voucherName);



        Allure.step("enter issue date for selected sales invoice  ");
        waitUntilElementToBePresent(issueDateField_4, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        getWebElement(issueDateField_4).clear();
        getWebElement(issueDateField_4).sendKeys(issueDate);

    }

    public void clickOnLoadDataBtn() {
        Allure.step("click on load data btn ");
        waitUntilElementToBePresent(loadDataBtn, GeneralConstants.minTimeOut);
        getWebElement(loadDataBtn).click();
    }

    public void applyFiltersWithCompanyAndAccount_5(String companyName, String accountName) throws InterruptedException {
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(companyInputField, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        Allure.step("enter company name ");
        getWebElement(companyInputField).clear();
        getWebElement(companyInputField).sendKeys(companyName);
        waitUntilElementToBePresent(chosenCompany, GeneralConstants.minTimeOut);
        getWebElement(chosenCompany).click();
        Allure.step("enter account name ");
        waitUntilElementToBePresent(accountField_5, GeneralConstants.minTimeOut);
        getWebElement(accountField_5).click();
        waitUntilElementToBePresent(accountInputField_5, GeneralConstants.minTimeOut);
        getWebElement(accountInputField_5).sendKeys(accountName);
        waitUntilElementToBePresent(chosenAccount, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        Thread.sleep(threadTimeOut);
        getWebElement(chosenAccount).click();
        Thread.sleep(threadTimeOut);
    }

    public void applyFiltersWithCompanyOnly_5(String companyName) throws InterruptedException {
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(companyInputField, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        Allure.step("enter company name ");
        getWebElement(companyInputField).clear();
        getWebElement(companyInputField).sendKeys(companyName);
        waitUntilElementToBePresent(chosenCompany, GeneralConstants.minTimeOut);
        getWebElement(chosenCompany).click();
//        Allure.step("enter account name ");
        waitUntilElementToBePresent(accountField_5, GeneralConstants.minTimeOut);
        getWebElement(accountField_5).click();
        waitUntilElementToBePresent(deleteAllBtn, GeneralConstants.minTimeOut);
        getWebElement(deleteAllBtn).click();
//        waitUntilElementToBePresent(accountInputField_5, GeneralConstants.minTimeOut);
//        getWebElement(accountInputField_5).sendKeys(accountName);
//        waitUntilElementToBePresent(chosenAccount, GeneralConstants.minTimeOut);
//        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
//        Thread.sleep(threadTimeOut);
//        getWebElement(chosenAccount).click();
        Thread.sleep(threadTimeOut);
    }

    public void applyFiltersWithCompanyAndVoucherName_5(String companyName, String voucherNameName,String issueDate) throws InterruptedException {
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(companyInputField, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        Allure.step("enter issue date for selected sales invoice ");
        waitUntilElementToBePresent(issueDateField_5, GeneralConstants.minTimeOut);
        getWebElement(issueDateField_5).clear();
        getWebElement(issueDateField_5).sendKeys(issueDate);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        Allure.step("enter voucher  name ");
        waitUntilElementToBePresent(voucherInputField_5, GeneralConstants.minTimeOut);
        getWebElement(voucherInputField_5).click();
        getWebElement(voucherInputField_5).sendKeys(voucherNameName);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        Allure.step("enter company name ");
        getWebElement(companyInputField).clear();
        getWebElement(companyInputField).sendKeys(companyName);
        waitUntilElementToBePresent(chosenCompany, GeneralConstants.minTimeOut);
        getWebElement(chosenCompany).click();
        Thread.sleep(threadTimeOut);



    }

    public String getDebitValue() {
        if (tryToGetWebElementV(debitValue) == GeneralConstants.SUCCESS) {
            waitUntilElementToBePresent(debitValue, GeneralConstants.minTimeOut);
            System.out.println(" debit value  is " + getWebElement(debitValue).getText());
            Allure.step(" debit value  is " + getWebElement(debitValue).getText());
            return getWebElement(debitValue).getText();
        } else {
          System.out.println(" no data exist at general ledger report ");
            Allure.step(" no data exist at general ledger report ");
            return "0.00";
        }
    }

    public String getBalanceValue() {
        if (tryToGetWebElementV(balanceValue) == GeneralConstants.SUCCESS) {
            waitUntilElementToBePresent(balanceValue, GeneralConstants.minTimeOut);
            System.out.println(" Balance value  at dafater 4  is " + getWebElement(balanceValue).getText().replace(",", ""));
            Allure.step(" Balance value  at dafater 4 is " + getWebElement(balanceValue).getText().replace(",", ""));
            return getWebElement(balanceValue).getText().replace(",", "");
        } else {
            System.out.println(" no data exist at general ledger report so balance value is 0.00");
            Allure.step("  no data exist at general ledger report so balance value is 0.00 ");
            return "0.00";
        }
    }

    public String getClosingDebitValueForInvoiceAtGL() {
        waitUntilElementToBePresent(generalLedgerReportTitle, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(loadImage, GeneralConstants.freezeTimeOut);
        scrollToSpeceficElement(debitValue_GL);
        System.out.println(" closing debit value at general ledger report is " + getWebElement(debitValue_GL).getText());
        Allure.step(" closing debit value at general ledger report is " + getWebElement(debitValue_GL).getText());
        return getWebElement(debitValue_GL).getText();
    }


    public String getClosingCreditValueForInvoiceAtGL() {
        waitUntilElementToBePresent(generalLedgerReportTitle, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(loadImage, GeneralConstants.freezeTimeOut);
        scrollToSpeceficElement(creditValue_GL);
        System.out.println(" closing credit value at general ledger report is " + getWebElement(creditValue_GL).getText());
        Allure.step(" closing credit value at general ledger report is " + getWebElement(creditValue_GL).getText());
        return getWebElement(creditValue_GL).getText();
    }

    public String getDebitValue_5() throws InterruptedException {
//        Thread.sleep(20000);
        waitUntilOverlayDisappear(loadImage, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(debitValue_5, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(loadImage, GeneralConstants.freezeTimeOut);
        System.out.println(" debit value for selected account is " + getWebElement(debitValue_5).getAttribute("title"));
        Allure.step(" debit value for selected account is " + getWebElement(debitValue_5).getAttribute("title"));
        return getWebElement(debitValue_5).getText();
    }
    public String getDebitValueF_5() throws InterruptedException {
//        Thread.sleep(20000);
        waitUntilOverlayDisappear(loadImage, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(debitValueF_5, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(loadImage, GeneralConstants.freezeTimeOut);
        System.out.println(" debit value for selected account is " + getWebElement(debitValueF_5).getAttribute("title"));
        Allure.step(" debit value for selected account is " + getWebElement(debitValueF_5).getAttribute("title"));
        return getWebElement(debitValueF_5).getText();
    }
    public String getBalanceValue_5() throws InterruptedException {
//        Thread.sleep(20000);
        waitUntilOverlayDisappear(loadImage, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(debitValue_5, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(loadImage, GeneralConstants.freezeTimeOut);
        System.out.println("  balance value   at dafater 5 is " + getWebElement(balanceValue_5).getAttribute("title"));
        Allure.step("  balance value at dafater 5 is " + getWebElement(balanceValue_5).getAttribute("title"));
        return getWebElement(balanceValue_5).getText();
    }
    public String getBalanceValueF_5() throws InterruptedException {
//        Thread.sleep(20000);
        waitUntilOverlayDisappear(loadImage, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(balanceValueF_5, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(loadImage, GeneralConstants.freezeTimeOut);
        System.out.println("  balance value is " + getWebElement(balanceValueF_5).getAttribute("title"));
        Allure.step("  balance value is " + getWebElement(balanceValueF_5).getAttribute("title"));
        return getWebElement(balanceValueF_5).getText();
    }
    public String getCreditValue() {
        if (tryToGetWebElementV(creditValue) == GeneralConstants.SUCCESS) {
            waitUntilElementToBePresent(creditValue, GeneralConstants.minTimeOut);
            System.out.println(" credit value for selected account is " + getWebElement(creditValue).getText());
            Allure.step(" credit value for selected account is " + getWebElement(creditValue).getText());
            return getWebElement(creditValue).getText();
        } else {
            System.out.println(" no data exist at general ledger report ");
            Allure.step(" no data exist at general ledger report ");
            return "0.00";
        }


    }
    public String getCreditValue_5() throws InterruptedException {
        waitUntilOverlayDisappear(loadImage, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(creditValue_5, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(loadImage, GeneralConstants.freezeTimeOut);
        System.out.println(" credit value for selected account is " + getWebElement(creditValue_5).getAttribute("title"));
        Allure.step(" credit value for selected account is " + getWebElement(creditValue_5).getAttribute("title"));
        return getWebElement(creditValue_5).getText();
    }
    public String getCreditValueF_5() throws InterruptedException {
        waitUntilOverlayDisappear(loadImage, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(creditValueF_5, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(loadImage, GeneralConstants.freezeTimeOut);
        System.out.println(" credit value for selected account is " + getWebElement(creditValueF_5).getAttribute("title"));
        Allure.step(" credit value for selected account is " + getWebElement(creditValueF_5).getAttribute("title"));
        return getWebElement(creditValueF_5).getText();
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
