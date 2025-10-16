package Pages;

import GeneralConstants.GeneralConstants;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DebitNotesListPage extends MainPage {
    private String dataMigrationTitle = "data migration";
    // private WebDriver driver ;

    public DebitNotesListPage(WebDriver driver) {
        this.driver = driver;
    }

    private By checkVmConnectionBtn = By.id("check_vm_connection");
    private By syncDocTypesDataBtn = By.id("sync_doctypes_data");
    private By statusMsg = By.className("msgprint");
    private By editIcon = By.className("icon-xs");
    private By salesInvoiceListTitle = By.xpath("(//*[contains(@title,'فاتورة المبيعات')]");
    private By listCount = By.xpath("(//*[contains(@class,'list-count')])");
    private By debitNoteLabel = By.xpath("(//h3[contains(text(),'فاتورة المبيعات')])| (//h5[contains(text(),'قائمة اشعار مدين')])");

    private By newBtn = By.xpath("//*[contains(@class,'btn btn-default btn-sm primary-action toolbar-btn')]");
    private By closeFilterIcon = By.xpath("(//*[contains(@class,'filter-icon')])[2]");
    By overlay = By.xpath("//*[contains(@class,'freeze-message-container')] | //*[contains(@id,'freeze')]");
    By viewCompleteScreen = By.xpath("//*[@class='btn btn-secondary btn-sm ']");
    By numberOfAllDebitNotesField_4 = By.xpath("//*[contains(@class,'total-rows')]");
    By numberOfAllDebitNotesField_5 = By.xpath("//*[contains(@class,'total-rows')]");
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

    public ItemPage clickOnNewItemBtn() {
      Allure.step("click on new item btn ");
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(debitNoteLabel, GeneralConstants.minTimeOut);
        waitUntilElementToBeClickable(newBtn, GeneralConstants.minTimeOut);

        getWebElement(newBtn).click();
        waitUntilElementToBePresent(viewCompleteScreen, GeneralConstants.minTimeOut);
        getWebElement(viewCompleteScreen).click();
        return new ItemPage(driver);
    }

    public String getItemNameAtViewList(String expected) {

        waitUntilElementToBePresent(debitNoteLabel, GeneralConstants.minTimeOut);
        waitUntilElementToBePresent(newBtn, GeneralConstants.minTimeOut);

      Allure.step("actual text is " + getWebElement(itemNameAtViewList).getAttribute("title") + " and expected text is " + expected);
        return getWebElement(itemNameAtViewList).getText();
    }

    public String getListAccountBeforeCreatingNewSalesInvoices() {

        waitUntilElementToBePresent(debitNoteLabel, GeneralConstants.minTimeOut);
      Allure.step("number of sales invoices at list view before creating new sales invoices " + getWebElement(listCount).getText());
        return getWebElement(listCount).getText();
    }

    public String getNumberOfAllItemsBeforeCreatingNewItem() throws InterruptedException {

        waitUntilElementToBePresent(debitNoteLabel, GeneralConstants.minTimeOut);

      Allure.step("number of all items at list view before creating new item " + getWebElement(numberOfAllDebitNotesField_4).getText());
        return getWebElement(numberOfAllDebitNotesField_4).getText();
    }

    public String getNumberOfAllDebitNotesBeforeSyncing() throws InterruptedException {
        waitUntilElementToBePresent(debitNoteLabel, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay,GeneralConstants.freezeTimeOut);
        //Thread.sleep(threadTimeOut);
      Allure.step("number of all debit notes at list view before Syncing " + getWebElement(numberOfAllDebitNotesField_4).getText());
        return getWebElement(numberOfAllDebitNotesField_4).getText();
    }

    public String getNumberOfAllDebitNotesAfterSyncing() throws InterruptedException {

        waitUntilElementToBePresent(debitNoteLabel, GeneralConstants.minTimeOut);

        waitUntilOverlayDisappear(overlay,GeneralConstants.freezeTimeOut);
        waitUntilElementNotHaveSpecificText(numberOfAllDebitNotesField_5,"تحديث");
//        Thread.sleep(threadTimeOut);
     if (getWebElement(numberOfAllDebitNotesField_5).getText().contains("من"))
     {
         Allure.step("number of all debit notes at list view after Syncing " + getWebElement(numberOfAllDebitNotesField_5).getText());

         Allure.step("number of all debit notes at list view after Syncing 0 ");
         return "0";
     }
     return getWebElement(numberOfAllDebitNotesField_5).getText();
    }

    public String getNumberOfSalesItemsBeforeCreatingNewItem() {

        waitUntilElementToBePresent(debitNoteLabel, GeneralConstants.minTimeOut);
      Allure.step("number of sales items at list view before creating new item " + getWebElement(numberOfCustomersDebitsField).getText());
        return getWebElement(numberOfCustomersDebitsField).getText();
    }

    public String getNumberOfCustomersDebitsBeforeSyncing() throws InterruptedException {

        waitUntilElementToBePresent(debitNoteLabel, GeneralConstants.minTimeOut);
//        Thread.sleep(threadTimeOut);
      Allure.step("value of Customers debits at list view before Syncing " + getWebElement(numberOfCustomersDebitsField).getText());
        return getWebElement(numberOfCustomersDebitsField).getText();
    }

    public String getNumberOfCustomersDebitsAfterSyncing() throws InterruptedException {

        waitUntilElementToBePresent(debitNoteLabel, GeneralConstants.minTimeOut);
//        Thread.sleep(threadTimeOut);
      Allure.step("value of Customers Debits at list view after Syncing " + getWebElement(numberOfCustomersDebitsField).getText());
        return getWebElement(numberOfCustomersDebitsField).getText();
    }

    public String getNumberOfPurchaseItemsBeforeCreatingNewItem() {

        waitUntilElementToBePresent(debitNoteLabel, GeneralConstants.minTimeOut);
      Allure.step("number of purchase items at list view before creating new item " + getWebElement(numberOfPrepaymentNotUserField).getText());
        return getWebElement(numberOfPrepaymentNotUserField).getText();
    }

    public String getNumberOfPrepaymentNotUsedBeforeSyncing() throws InterruptedException {

        waitUntilElementToBePresent(debitNoteLabel, GeneralConstants.minTimeOut);
//        Thread.sleep(threadTimeOut);
      Allure.step("value of prepayment not used at list view before Syncing " + getWebElement(numberOfPrepaymentNotUserField).getText());
        return getWebElement(numberOfPrepaymentNotUserField).getText();
    }

    public String getNumberOfPrepaymentNotUsedAfterSyncing() throws InterruptedException {

        waitUntilElementToBePresent(debitNoteLabel, GeneralConstants.minTimeOut);
//        Thread.sleep(threadTimeOut);
      Allure.step("value of prepayment Not Used at list view after Syncing " + getWebElement(numberOfPrepaymentNotUserField).getText());
        return getWebElement(numberOfPrepaymentNotUserField).getText();
    }

    public SellingPriceListsPage openSellingPriceLists() {
      Allure.step("click on sales invoices tab ");
        getWebElement(salesInvoicesTab).click();
      Allure.step("open prices list page  ");
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(sellingPriceListsOpt, GeneralConstants.minTimeOut);
        getWebElement(sellingPriceListsOpt).click();
        driver.navigate().refresh();
        return new SellingPriceListsPage(driver);
    }

    public String getNumberOfAllItemsAfterCreatingNewItem() {

        waitUntilElementToBePresent(debitNoteLabel, GeneralConstants.minTimeOut);
      Allure.step("number of all items at list view after creating new item " + getWebElement(numberOfAllDebitNotesField_4).getText());
        return getWebElement(numberOfAllDebitNotesField_4).getText();
    }

    public String getNumberOfSalesItemsAfterCreatingNewItem() {

        waitUntilElementToBePresent(debitNoteLabel, GeneralConstants.minTimeOut);
      Allure.step("number of sales items at list view after creating new item " + getWebElement(numberOfCustomersDebitsField).getText());
        return getWebElement(numberOfCustomersDebitsField).getText();
    }

    public String getNumberOfPurchaseItemsAfterCreatingNewItem() {

        waitUntilElementToBePresent(debitNoteLabel, GeneralConstants.minTimeOut);
      Allure.step("number of sales items at list view after creating new item " + getWebElement(numberOfPrepaymentNotUserField).getText());
        return getWebElement(numberOfPrepaymentNotUserField).getText();
    }

    public String getListAccountAfterCreatingNewSalesInvoices() {

        waitUntilElementToBePresent(debitNoteLabel, GeneralConstants.minTimeOut);
      Allure.step("number of sales invoices at list view After creating new sales invoices " + getWebElement(listCount).getText());
        return getWebElement(listCount).getText();
    }
}
