package Pages;

import GeneralConstants.GeneralConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreditNotesListPage extends MainPage {
    private String dataMigrationTitle = "data migration";
    // private WebDriver driver ;

    public CreditNotesListPage(WebDriver driver) {
        this.driver = driver;
    }

    private By checkVmConnectionBtn = By.id("check_vm_connection");
    private By syncDocTypesDataBtn = By.id("sync_doctypes_data");
    private By statusMsg = By.className("msgprint");
    private By editIcon = By.className("icon-xs");
    private By salesInvoiceListTitle = By.xpath("(//*[contains(@title,'فاتورة المبيعات')]");
    private By listCount = By.xpath("(//*[contains(@class,'list-count')])");
    private By creditNoteLabel = By.xpath("(//h3[contains(text(),'فاتورة المبيعات')])| (//h5[contains(text(),'قائمة اشعار دائن')])");

    private By newBtn = By.xpath("//*[contains(@class,'btn btn-default btn-sm primary-action toolbar-btn')]");
    private By closeFilterIcon = By.xpath("(//*[contains(@class,'filter-icon')])[2]");
    By overlay = By.xpath("//*[contains(@class,'freeze-message-container')] | //*[contains(@id,'freeze')]");
    By viewCompleteScreen = By.xpath("//*[@class='btn btn-secondary btn-sm ']");
    By numberOfAllCreditNotesField = By.xpath("//*[contains(@class,'total-rows')] " +
            "|//*[contains(@class,'list-count')]/span");
    By numberOfCustomersDebitsField = By.xpath("//h3[contains(text(),'ديون العملاء')]/following-sibling::div/span" +
            "|//*[contains(@class,'customer-lv-debits ')]");
    By numberOfPrepaymentNotUserField = By.xpath("//h3[contains(text(),'الدفعات المقدمة غير المستخدمة')]/following-sibling::div/span" +
            "|//*[contains(@class,'customer-lv-balance ')]");
    private By itemNameAtViewList = By.xpath("(//a[contains(@data-doctype,'Item')])[1]");
    private By invoiceStatusAtListView = By.xpath("(((((//*[contains(@class,'level list-row-head font-weight-bold')])/following-sibling::div)[2])/div/div/div)[3])/span/span");
    private By invoiceTotalAmountValueAtListView = By.xpath("(((((//*[contains(@class,'level list-row-head font-weight-bold')])/following-sibling::div)[2])/div/div/div))[6]/span/a/div/span");
    private By totalInvoicesAmountAtViewList = By.xpath("//h3[contains(text(),'اجمالي الفواتير')]/following-sibling::div");
    private By salesInvoicesTab = By.id("module-anchor-Selling");
    private By sellingPriceListsOpt = By.xpath("//*[contains(@id,'sidebar-selling-price-lists')]");
    private By draftLabel = By.xpath("(//h3[contains(text(),'مسودة')])" +
            "| (//div[contains(text(),'مسودة')])");

    private By numberOfDraftInvoices = By.xpath("//h3[contains(text(),'مسودة')]/following-sibling::div" +
            "|//*[@class='general-lv-drafts ']");
    private By valueOfTotalInvoices = By.xpath("//h3[contains(text(),'اجمالي الفواتير')]/following-sibling::div" +
            "|//*[@class='return-note-lv-total-invoices ']");

    private By valueOfOutstandingAmount = By.xpath("//h3[contains(text(),'المبلغ المعلق')]/following-sibling::div" +
            "|//*[@class='return-note-lv-outstanding-amt ']");
    public ItemPage clickOnNewItemBtn() {
        System.out.println("click on new item btn ");
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(creditNoteLabel, GeneralConstants.minTimeOut);
        waitUntilElementToBeClickable(newBtn, GeneralConstants.minTimeOut);

        getWebElement(newBtn).click();
        waitUntilElementToBePresent(viewCompleteScreen, GeneralConstants.minTimeOut);
        getWebElement(viewCompleteScreen).click();
        return new ItemPage(driver);
    }

    public String getItemNameAtViewList(String expected) {

        waitUntilElementToBePresent(creditNoteLabel, GeneralConstants.minTimeOut);
        waitUntilElementToBePresent(newBtn, GeneralConstants.minTimeOut);

        System.out.println("actual text is " + getWebElement(itemNameAtViewList).getAttribute("title") + " and expected text is " + expected);
        return getWebElement(itemNameAtViewList).getText();
    }

    public String getListAccountBeforeCreatingNewSalesInvoices() {

        waitUntilElementToBePresent(creditNoteLabel, GeneralConstants.minTimeOut);
        System.out.println("number of sales invoices at list view before creating new sales invoices " + getWebElement(listCount).getText());
        return getWebElement(listCount).getText();
    }

    public String getNumberOfAllItemsBeforeCreatingNewItem() throws InterruptedException {

        waitUntilElementToBePresent(creditNoteLabel, GeneralConstants.minTimeOut);

        System.out.println("number of all items at list view before creating new item " + getWebElement(numberOfAllCreditNotesField).getText());
        return getWebElement(numberOfAllCreditNotesField).getText();
    }

    public String getNumberOfAllCreditNotesBeforeSyncing() throws InterruptedException {
        waitUntilElementToBePresent(creditNoteLabel, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay,GeneralConstants.freezeTimeOut);

        Thread.sleep(threadTimeOut);
        System.out.println("number of all credit notes at list view before Syncing " + getWebElement(numberOfAllCreditNotesField).getText());
        return getWebElement(numberOfAllCreditNotesField).getText();
    }

    public String getNumberOfAllCreditNotesAfterSyncing() throws InterruptedException {

        waitUntilElementToBePresent(creditNoteLabel, GeneralConstants.minTimeOut);
        //   Thread.sleep(threadTimeOut);
        waitUntilOverlayDisappear(overlay,GeneralConstants.freezeTimeOut);
        waitUntilElementNotHaveSpecificText(numberOfAllCreditNotesField,"تحديث");
        System.out.println("number of all debit notes at list view after Syncing " + getWebElement(numberOfAllCreditNotesField).getText());
        return getWebElement(numberOfAllCreditNotesField).getText();
    }






    public String getNumberOfSalesItemsBeforeCreatingNewItem() {

        waitUntilElementToBePresent(creditNoteLabel, GeneralConstants.minTimeOut);
        System.out.println("number of sales items at list view before creating new item " + getWebElement(numberOfCustomersDebitsField).getText());
        return getWebElement(numberOfCustomersDebitsField).getText();
    }

    public String getNumberOfCustomersDebitsBeforeSyncing() throws InterruptedException {

        waitUntilElementToBePresent(creditNoteLabel, GeneralConstants.minTimeOut);
//        Thread.sleep(threadTimeOut);
        System.out.println("value of Customers debits at list view before Syncing " + getWebElement(numberOfCustomersDebitsField).getText());
        return getWebElement(numberOfCustomersDebitsField).getText();
    }

    public String getNumberOfCustomersDebitsAfterSyncing() throws InterruptedException {

        waitUntilElementToBePresent(creditNoteLabel, GeneralConstants.minTimeOut);
//        Thread.sleep(threadTimeOut);
        System.out.println("value of Customers Debits at list view after Syncing " + getWebElement(numberOfCustomersDebitsField).getText());
        return getWebElement(numberOfCustomersDebitsField).getText();
    }

    public String getNumberOfPurchaseItemsBeforeCreatingNewItem() {

        waitUntilElementToBePresent(creditNoteLabel, GeneralConstants.minTimeOut);
        System.out.println("number of purchase items at list view before creating new item " + getWebElement(numberOfPrepaymentNotUserField).getText());
        return getWebElement(numberOfPrepaymentNotUserField).getText();
    }
    public String getNumberOfDraftInvoicesBeforeSyncing() throws InterruptedException {

        waitUntilElementToBePresent(creditNoteLabel, GeneralConstants.minTimeOut);
        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        System.out.println("number of draft credit notes at list view before syncing " + getWebElement(numberOfDraftInvoices).getText());
        return getWebElement(numberOfDraftInvoices).getText();
    }
    public String getNumberOfDraftCreditNotesAfterSyncing() throws InterruptedException {

        waitUntilElementToBePresent(creditNoteLabel, GeneralConstants.minTimeOut);
        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        System.out.println("number of draft credit notes at list view after syncing " + getWebElement(numberOfDraftInvoices).getText());
        return getWebElement(numberOfDraftInvoices).getText();
    }
    public String getValueOfTotalInvoicesBeforeSyncing() throws InterruptedException {

        waitUntilElementToBePresent(creditNoteLabel, GeneralConstants.minTimeOut);
        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        System.out.println("value of total invoices at list view before syncing " + getWebElement(valueOfTotalInvoices).getText());
        return getWebElement(valueOfTotalInvoices).getText();
    }
    public String getValueOfTotalInvoicesAfterSyncing() throws InterruptedException {

        waitUntilElementToBePresent(creditNoteLabel, GeneralConstants.minTimeOut);
        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        System.out.println("value of total invoices at list view After syncing " + getWebElement(valueOfTotalInvoices).getText());
        return getWebElement(valueOfTotalInvoices).getText();
    }
    public String getValueOfOutstandingAmountBeforeSyncing() throws InterruptedException {

        waitUntilElementToBePresent(creditNoteLabel, GeneralConstants.minTimeOut);
        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        System.out.println("value of outstanding amount at list view before syncing " + getWebElement(valueOfOutstandingAmount).getText());
        return getWebElement(valueOfOutstandingAmount).getText();
    }
    public String getValueOfOutstandingAmountAfterSyncing() throws InterruptedException {

        waitUntilElementToBePresent(creditNoteLabel, GeneralConstants.minTimeOut);
        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        System.out.println("value of outstanding amount at list view after syncing " + getWebElement(valueOfOutstandingAmount).getText());
        return getWebElement(valueOfOutstandingAmount).getText();
    }
    public String getNumberOfPrepaymentNotUsedBeforeSyncing() throws InterruptedException {

        waitUntilElementToBePresent(creditNoteLabel, GeneralConstants.minTimeOut);
//        Thread.sleep(threadTimeOut);
        System.out.println("value of prepayment not used at list view before Syncing " + getWebElement(numberOfPrepaymentNotUserField).getText());
        return getWebElement(numberOfPrepaymentNotUserField).getText();
    }

    public String getNumberOfPrepaymentNotUsedAfterSyncing() throws InterruptedException {

        waitUntilElementToBePresent(creditNoteLabel, GeneralConstants.minTimeOut);
//        Thread.sleep(threadTimeOut);
        System.out.println("value of prepayment Not Used at list view after Syncing " + getWebElement(numberOfPrepaymentNotUserField).getText());
        return getWebElement(numberOfPrepaymentNotUserField).getText();
    }

    public SellingPriceListsPage openSellingPriceLists() {
        System.out.println("click on sales invoices tab ");
        getWebElement(salesInvoicesTab).click();
        System.out.println("open prices list page  ");
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(sellingPriceListsOpt, GeneralConstants.minTimeOut);
        getWebElement(sellingPriceListsOpt).click();
        driver.navigate().refresh();
        return new SellingPriceListsPage(driver);
    }

    public String getNumberOfAllItemsAfterCreatingNewItem() {

        waitUntilElementToBePresent(creditNoteLabel, GeneralConstants.minTimeOut);
        System.out.println("number of all items at list view after creating new item " + getWebElement(numberOfAllCreditNotesField).getText());
        return getWebElement(numberOfAllCreditNotesField).getText();
    }

    public String getNumberOfSalesItemsAfterCreatingNewItem() {

        waitUntilElementToBePresent(creditNoteLabel, GeneralConstants.minTimeOut);
        System.out.println("number of sales items at list view after creating new item " + getWebElement(numberOfCustomersDebitsField).getText());
        return getWebElement(numberOfCustomersDebitsField).getText();
    }

    public String getNumberOfPurchaseItemsAfterCreatingNewItem() {

        waitUntilElementToBePresent(creditNoteLabel, GeneralConstants.minTimeOut);
        System.out.println("number of sales items at list view after creating new item " + getWebElement(numberOfPrepaymentNotUserField).getText());
        return getWebElement(numberOfPrepaymentNotUserField).getText();
    }

    public String getListAccountAfterCreatingNewSalesInvoices() {

        waitUntilElementToBePresent(creditNoteLabel, GeneralConstants.minTimeOut);
        System.out.println("number of sales invoices at list view After creating new sales invoices " + getWebElement(listCount).getText());
        return getWebElement(listCount).getText();
    }
}
