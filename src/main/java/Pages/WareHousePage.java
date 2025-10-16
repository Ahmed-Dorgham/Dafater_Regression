package Pages;

import GeneralConstants.GeneralConstants;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WareHousePage extends MainPage {
    private String dataMigrationTitle = "data migration";
    // private WebDriver driver ;

    public WareHousePage(WebDriver driver) {
        this.driver = driver;
    }

    private By checkVmConnectionBtn = By.id("check_vm_connection");
    private By updateStockBtn = By.id("update_stock");
    private By statusMsg = By.className("msgprint");
    private By editIcon = By.className("icon-xs");
    private By newWareHouseTitle = By.xpath("//*[contains(@title,'المستودع جديد')]");
    private By itemCodeField = By.xpath("(//*[contains(@id,'item_code')])[1]");
    private By companyInputField = By.xpath("(//*[contains(@data-target,'Company') and @placeholder=\" \" and @data-doctype = \"Warehouse\"])");
    private By itemPriceField = By.xpath("(//*[contains(@data-fieldtype,'Currency')])[3]");
    private By wareHouseInputField = By.xpath("(//*[contains(@id,'warehouse_name')])");
    private By selectedCompany = By.xpath("(//*[contains(@data-target,'Company') and @placeholder=\" \" and @data-doctype = \"Warehouse\"])/following-sibling::ul/div/p/strong");
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
    private By wareHouseName = By.xpath("(//h3[contains(@class,'ellipsis title-text')])[3]");
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
    private By wareHousesOpt = By.xpath("(//*[contains(@id,'sidebar-stock-warehouse')]/span)[1]");
    private By selectAllCheckBox = By.xpath("(//*[contains(@class,'level-item list-check-all')])[2]");
    By overlay = By.xpath("//*[contains(@class,'freeze-message-container')]");
    private By closeFilterIcon = By.xpath("(//*[contains(@class,'filter-icon')])[2]");

//    public void enterValidDataIntoSalesInvoicePageAndSumbit(String dueDate) throws InterruptedException {
////        waitUntilElementToBePresent(newItemTitle, GeneralConstants.minTimeOut);
////        Allure.step("select  customer ");
////        getWebElement(customerFieldSalesInvoice).click();
////        if (tryToGetWebElement(customersListSalesInvoice) == GeneralConstants.FAILED) {
////            getWebElement(customerFieldSalesInvoice).click();
////        }
//////        clickByJs(getWebElement(customerFieldSalesInvoice));
////        waitUntilElementToBePresent(customersListSalesInvoice, GeneralConstants.minTimeOut);
////        waitUntilElementToBeClickable(customerOptSalesInvoice, GeneralConstants.minTimeOut);
////        getWebElement(customerOptSalesInvoice).click();
//        Allure.step("enter dues date  ");
//        waitUntilElementVisibility(dueDateField, GeneralConstants.minTimeOut);
//        getWebElement(dueDateField).sendKeys(dueDate);
//        Allure.step("Scroll down to item field ");
//        scrollToSpeceficElement(totalAmountLabel);
//        //   Thread.sleep(6000);
//        Allure.step(" select item  ");
//        clickByActions(itemCodeField);
//        waitUntilElementToBePresent(itemCodeInputField, GeneralConstants.minTimeOut);
//        getWebElement(itemCodeInputField).sendKeys("item");
//        waitUntilElementToBeClickable(itemGroupOpt, GeneralConstants.minTimeOut);
//        clickByActions(itemGroupOpt);
//
//        Allure.step("unselect update stock opt");
//        getWebElement(updateStockBtn).click();
//
//        Allure.step("scroll up to save and submit btn ");
//        scrollToSpeceficElement(saveAndSubmitBtn);
//
//        Allure.step(" save and submit sales invoice ");
//        getWebElement(saveAndSubmitBtn).click();
//        Allure.step("click on yes btn ");
//        waitUntilElementToBeClickable(yesBtn, GeneralConstants.minTimeOut);
//        getWebElement(yesBtn).click();
//        waitUntilElementToBePresent(viewBtn, GeneralConstants.minTimeOut);
//
//    }

    public void enterValidDataIntoWareHousePage(String wareHouseName) throws InterruptedException {

        waitUntilElementToBePresent(newWareHouseTitle, GeneralConstants.minTimeOut);

        Allure.step("enter wareHouse name");
        getWebElement(wareHouseInputField).sendKeys(wareHouseName);
        Allure.step("select company ");
        getWebElement(companyInputField).click();
        waitUntilElementToBePresent(selectedCompany, GeneralConstants.minTimeOut);
        getWebElement(selectedCompany).click();

//        waitUntilElementToBePresent(itemGroupOpt, GeneralConstants.minTimeOut);
//        getWebElement(itemGroupOpt).click();
        Thread.sleep(threadTimeOut);
        Allure.step("click on save btn ");

        getWebElement(saveBtn).click();
        waitUntilElementToBePresent(enablingLabel, GeneralConstants.minTimeOut);
    }

//    public void enterValidDataForSalesItem(String itemCode) throws InterruptedException {
//
//        waitUntilElementToBePresent(newItemTitle, GeneralConstants.minTimeOut);
//        Allure.step("enter item code");
//        getWebElement(itemCodeInputField).sendKeys(itemCode);
//        Allure.step("select item group ");
//        getWebElement(itemGroupField).click();
//        waitUntilElementToBePresent(itemGroupsList, GeneralConstants.minTimeOut);
//        waitUntilElementToBePresent(itemGroupOpt, GeneralConstants.minTimeOut);
//        getWebElement(itemGroupOpt).click();
//        Allure.step("click on purchase tab ");
//        getWebElement(purchaseTab).click();
//        getWebElement(purchaseTab).click();
//        Allure.step("unselect is purchase item checkbox ");
//        waitUntilElementToBePresent(isPurchaseItemCheckBox, GeneralConstants.minTimeOut);
//        getWebElement(isPurchaseItemCheckBox).click();
//
//        Allure.step("click on save btn ");
//        getWebElement(saveBtn).click();
//        waitUntilElementToBePresent(enablingLabel, GeneralConstants.minTimeOut);
//    }
//
//    public void enterValidDataForPurchaseItem(String itemCode) throws InterruptedException {
//
//        waitUntilElementToBePresent(newItemTitle, GeneralConstants.minTimeOut);
//        Allure.step("enter item code");
//        getWebElement(itemCodeInputField).sendKeys(itemCode);
//        Allure.step("select item group ");
//        getWebElement(itemGroupField).click();
//        waitUntilElementToBePresent(itemGroupsList, GeneralConstants.minTimeOut);
//        waitUntilElementToBePresent(itemGroupOpt, GeneralConstants.minTimeOut);
//        getWebElement(itemGroupOpt).click();
//        Allure.step("click on sales tab ");
//        getWebElement(salesTab).click();
//        getWebElement(salesTab).click();
//        Allure.step("unselect is sales item checkbox ");
//        waitUntilElementToBePresent(isSalesItemCheckBox, GeneralConstants.minTimeOut);
//        getWebElement(isSalesItemCheckBox).click();
//
//        Allure.step("click on save btn ");
//        getWebElement(saveBtn).click();
//        waitUntilElementToBePresent(enablingLabel, GeneralConstants.minTimeOut);
//    }
//
//    public void createNewSalesItem(String itemCode) throws InterruptedException {
//
//        waitUntilElementToBePresent(newItemTitle, GeneralConstants.minTimeOut);
//
//        Allure.step("enter item code");
//        getWebElement(itemCodeInputField).sendKeys(itemCode);
//        Allure.step("select item group ");
//        getWebElement(itemGroupField).click();
//        waitUntilElementToBePresent(itemGroupsList, GeneralConstants.minTimeOut);
//        waitUntilElementToBePresent(itemGroupOpt, GeneralConstants.minTimeOut);
//        getWebElement(itemGroupOpt).click();
//
//
//        Allure.step("click on save btn ");
//        getWebElement(saveBtn).click();
//        waitUntilElementToBePresent(enablingLabel, GeneralConstants.minTimeOut);
//
//
//    }

    public PosViewPage openPosView() throws InterruptedException {
        Allure.step("click on is pos view btn");
        waitUntilElementToBePresent(posViewBtn, GeneralConstants.minTimeOut);
        getWebElement(posViewBtn).click();
        Allure.step("click on accept btn ");
//        Thread.sleep(9000);
        waitUntilElementNotToBeVisible(posViewBtn, GeneralConstants.minTimeOut);
//        Alert alert = driver.switchTo().alert();
//        alert.accept();
//        Allure.step("choose POS profile ");
//        waitUntilElementToBePresent(posProfileUInputField, GeneralConstants.minTimeOut);
//        getWebElement(posProfileUInputField).click();
        return new PosViewPage(driver);
    }

//    public void saveAndSubmitSalesInvoiceFromSalesOrder() throws InterruptedException {
//
//        waitUntilElementVisibility(saveAndSubmitBtnFromSalesOrder, GeneralConstants.minTimeOut);
//        Allure.step("save and submit sales invoice  ");
//        getWebElement(saveAndSubmitBtnFromSalesOrder).click();
//        Allure.step("click on yes btn ");
//        waitUntilElementToBeClickable(yesBtn_SO, GeneralConstants.minTimeOut);
//        getWebElement(yesBtn_SO).click();
//        waitUntilElementToBePresent(createBtn, GeneralConstants.minTimeOut);
//    }

//    public CreditNotePage createCreditNoteFromSalesInvoice() {
//        Allure.step("click on create btn");
//        waitUntilElementVisibility(createBtn, GeneralConstants.minTimeOut);
//        getWebElement(createBtn).click();
//        Allure.step("click on credit note");
//        waitUntilElementVisibility(creditNoteChoice, GeneralConstants.minTimeOut);
//        getWebElement(creditNoteChoice).click();
//        return new CreditNotePage(driver);
//    }

//    public String getInvoiceStatus(String expected) {
//        Allure.step("Verify the status of sales invoice  ");
//        waitUntilElementToBePresent(createBtn, GeneralConstants.minTimeOut);
//        if (tryToGetWebElement(submittedStatus) == GeneralConstants.SUCCESS) {
//            Allure.step("actual text is " + getWebElement(submittedStatus).getText() + " and expected test is " + expected);
//            return getWebElement(submittedStatus).getText();
//        } else if (tryToGetWebElement(draftStatus) == GeneralConstants.SUCCESS) {
//            Allure.step("actual text is " + getWebElement(draftStatus).getText() + " and expected test is " + expected);
//            return getWebElement(draftStatus).getText();
//        } else
//            return "unexpected status";
//    }

//    public String getPosInvoiceStatus(String expected) {
//        Allure.step("open sales invoice which created using pos view ");
//        getWebElement(invoiceNameAtViewList).click();
//        waitUntilElementToBePresent(createBtn, GeneralConstants.minTimeOut);
//        Allure.step("actual text is " + getWebElement(submittedStatus).getText() + " and expected test is " + expected);
//        return getWebElement(submittedStatus).getText();
//    }

    public String getWareHouseName(String expected) {
        Allure.step("Verify the name of warehouse  ");
        waitUntilElementToBePresent(enablingLabel, GeneralConstants.minTimeOut);
        Allure.step("actual text is  " + getWebElement(wareHouseName).getText() + "  and expected text is  " + expected);
        return getWebElement(wareHouseName).getText();
    }

    public String getItemCode(String expected) {
        Allure.step("Verify the name of item  ");
        waitUntilElementToBePresent(enablingLabel, GeneralConstants.minTimeOut);
        Allure.step("actual text is  " + getWebElement(ItemCode).getText() + "  and expected text is  " + expected);
        return getWebElement(ItemCode).getText();
    }
//
//    public String getDraftInvoiceName(String expected) {
//        Allure.step("Verify the name of sales invoice  ");
//        waitUntilElementToBePresent(createBtn, GeneralConstants.minTimeOut);
//        Allure.step("actual text is  " + getWebElement(DraftInvoiceName).getAttribute("title") + "  and expected text is  " + expected);
//        return getWebElement(DraftInvoiceName).getText();
//    }


    public String getInvoiceNameForCreditNote(String expected) {
//        Allure.step("Verify the name of sales invoice  ");
        waitUntilElementToBePresent(viewBtn, GeneralConstants.minTimeOut);
        Allure.step("actual text is  " + getWebElement(invoiceNameForCreditNote).getAttribute("title") + "  and expected text is  " + expected);
        return getWebElement(invoiceNameForCreditNote).getText();
    }
//
//    public PurchaseInvoicesListPage goToPurchaseListView() {
//        waitUntilElementToBePresent(createBtn, GeneralConstants.minTimeOut);
//        Allure.step("navigate to sales invoices list  ");
//        getWebElement(salesInvoicesOpt).click();
//        driver.navigate().refresh();
//        return new PurchaseInvoicesListPage(driver);
//    }

    //
//    public String getInvoiceNameAtViewList(String expected) {
//        waitUntilElementToBePresent(createBtn, GeneralConstants.minTimeOut);
//        Allure.step("navigate to sales invoices list  ");
//        getWebElement(salesInvoicesOpt).click();
//        driver.navigate().refresh();
//        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
//        Allure.step("actual text is " + getWebElement(invoiceNameAtViewList).getAttribute("title") + " and expected text is " + expected);
//        return getWebElement(invoiceNameAtViewList).getText();
//    }
    public WareHouseListPage openWareHouseListPage() {

        Allure.step("navigate to warehouse list ");
        waitUntilElementToBeClickable(wareHousesOpt, GeneralConstants.minTimeOut);
        getWebElement(wareHousesOpt).click();
        driver.navigate().refresh();
        waitUntilElementNotHaveSpecificText(listCount, "تحديث...");
//        waitUntilElementToBePresent(closeFilterIcon, GeneralConstants.minTimeOut);
//        getWebElement(closeFilterIcon).click();
        return new WareHouseListPage(driver);
    }
}
