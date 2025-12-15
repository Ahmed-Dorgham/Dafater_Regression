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
    private By listCount = By.xpath("(//*[contains(@class,'list-count')])" +
            "|(//*[contains(@class,'total-rows')])");
    private By debitNoteLabel = By.xpath("(//h3[contains(text(),'فاتورة المبيعات')])| (//h5[contains(text(),'قائمة اشعار مدين')])");
    public By emptyList = By.xpath("//*[contains(@class,'empty-invoice__title')]");
    By closeFilter = By.xpath("//*[contains(@class,'btn btn-default btn-xs remove-filter')]");

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
    private By draftLabel = By.xpath("(//h3[contains(text(),'مسودة')]) | (//div[contains(text(),'مسودة')])");
    private By totalAmountOfDebitNotesAtViewList = By.xpath("//h3[contains(text(),'اجمالي الفواتير')]/following-sibling::div" +
            "|//*[@class='sales-invoice-lv-total-invoices '] " +
            "|  //*[@class='purchase-invoice-lv-total-invoices ']");
    private By totalOutstandingAmountOfDebitNotesAtViewList = By.xpath("//h3[contains(text(),'المبلغ المعلق')]/following-sibling::div" +
            "|//*[@class='sales-invoice-lv-total-invoices '] " +
            "|  //*[@class='purchase-invoice-lv-total-invoices ']");
    private By totalPaidAmountOfDebitNotesAtViewList = By.xpath("//h3[contains(text(),'الدفعات المقدمة')]/following-sibling::div" +
            "|//*[@class='sales-invoice-lv-total-invoices '] " +
            "|  //*[@class='purchase-invoice-lv-total-invoices ']");

    By numberOfDraftNotes = By.xpath("//h3[contains(text(),'مسودة')]/following-sibling::div" +
            "| //*[contains(@class,'general-lv-drafts ')]");

    public double getTotalAmountOfDebitNotesBeforeSyncing() throws InterruptedException {
        double sumOfTotalAmountValues = 0;
        waitUntilElementVisibility(debitNoteLabel, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        while (!getWebElement(listCountOffset).getText().contains(getWebElement(listCount).getText())) {
            System.out.println(getWebElement(listCountOffset).getText());
            System.out.println(getWebElement(listCount).getText());
            totalAmountValues = driver.findElements(totalAmountValue);
            for (int i = 0; i < totalAmountValues.size(); i++) {
                sumOfTotalAmountValues += Double.parseDouble(totalAmountValues.get(i).getText().replace(",", ""));
                //System.out.println(sumOfTotalAmountValues);
            }
            //  System.out.println("click on next icon");
            getWebElement(nextIcon).click();
            Thread.sleep(threadTimeOut);
        }

        if (getWebElement(listCountOffset).getText().contains(getWebElement(listCount).getText())) {
            System.out.println(getWebElement(listCountOffset).getText());
            System.out.println(getWebElement(listCount).getText());
            totalAmountValues = driver.findElements(totalAmountValue);
            for (int i = 0; i < totalAmountValues.size(); i++) {
                sumOfTotalAmountValues += Double.parseDouble(totalAmountValues.get(i).getText().replace(",", ""));
                System.out.println(sumOfTotalAmountValues);
            }
            if (tryToGetWebElementV(emptyList) == GeneralConstants.SUCCESS) {
                System.out.println("total amount of debit notes at list view before syncing  " + sumOfTotalAmountValues);
                Allure.step("total amount of debit notes at list view before syncing " + sumOfTotalAmountValues);
                return sumOfTotalAmountValues;
            } else {
                System.out.println("click on next icon");
                getWebElement(nextIcon).click();
                Thread.sleep(threadTimeOut);
            }
        }
        System.out.println("total amount of debit notes at list view before syncing  " + sumOfTotalAmountValues);
        Allure.step("total amount of debit notes at list view before syncing " + sumOfTotalAmountValues);
        return sumOfTotalAmountValues;
    }
    public String getTotalAmountOfDebitNotesAfterSyncing() throws InterruptedException {

        waitUntilElementVisibility(debitNoteLabel, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        System.out.println("total amount of debit notes at list view after syncing " + getWebElement(totalOutstandingAmountOfDebitNotesAtViewList).getText());
        Allure.step("total amount of debit notes at list view after syncing " + getWebElement(totalOutstandingAmountOfDebitNotesAtViewList).getText());
        return getWebElement(totalOutstandingAmountOfDebitNotesAtViewList).getText();
    }
    public String getTotalPaidAmountOfDebitNotesAfterSyncing() throws InterruptedException {

        waitUntilElementVisibility(debitNoteLabel, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        System.out.println("total paid  amount of debit notes at list view after syncing " + getWebElement(totalPaidAmountOfDebitNotesAtViewList).getText());
        Allure.step("total paid amount of debit notes at list view after syncing " + getWebElement(totalPaidAmountOfDebitNotesAtViewList).getText());
        return getWebElement(totalPaidAmountOfDebitNotesAtViewList).getText();
    }
    public String getTotalOutstandingAmountOfDebitNotesAfterSyncing() throws InterruptedException {


        waitUntilElementVisibility(debitNoteLabel, GeneralConstants.minTimeOut);

        Thread.sleep(threadTimeOut);
        System.out.println("total outstanding  amount of Debit Notes at list view after syncing " + getWebElement(totalAmountOfDebitNotesAtViewList).getText());
        Allure.step("total outstanding amount of Debit Notes at list view after syncing " + getWebElement(totalAmountOfDebitNotesAtViewList).getText());
        return getWebElement(totalAmountOfDebitNotesAtViewList).getText();
    }
    public String getNumberOfDraftInvoicesAfterSyncing() {


        waitUntilElementVisibility(debitNoteLabel, GeneralConstants.minTimeOut);

        Allure.step("number of draft debit notes at list view after syncing " + getWebElement(numberOfDraftNotes).getText());
        return getWebElement(numberOfDraftNotes).getText();
    }
    public double getTotalOutstandingAmountOfDebitNotesBeforeSyncing() throws InterruptedException {

        double sumOfTotalOutstandingAmountValues = 0;

        waitUntilElementVisibility(debitNoteLabel, GeneralConstants.minTimeOut);

        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        Thread.sleep(threadTimeOut);
        while (!getWebElement(listCountOffset).getText().contains(getWebElement(listCount).getText())) {
            System.out.println(getWebElement(listCountOffset).getText());
            System.out.println(getWebElement(listCount).getText());
            totalOutstandingAmountValues = driver.findElements(totalOutstandingAmountValue);
            for (int i = 0; i < totalOutstandingAmountValues.size(); i++) {
                sumOfTotalOutstandingAmountValues += Double.parseDouble(totalOutstandingAmountValues.get(i).getText().replace(",", ""));
                System.out.println(sumOfTotalOutstandingAmountValues);
            }
            System.out.println("click on next icon");
            getWebElement(nextIcon).click();
            Thread.sleep(threadTimeOut);
        }

        if (getWebElement(listCountOffset).getText().contains(getWebElement(listCount).getText())) {
            System.out.println(getWebElement(listCountOffset).getText());
            System.out.println(getWebElement(listCount).getText());
            totalOutstandingAmountValues = driver.findElements(totalOutstandingAmountValue);
            for (int i = 0; i < totalOutstandingAmountValues.size(); i++) {
                sumOfTotalOutstandingAmountValues += Double.parseDouble(totalOutstandingAmountValues.get(i).getText().replace(",", ""));
                System.out.println(sumOfTotalOutstandingAmountValues);
            }
            if (tryToGetWebElementV(emptyList) == GeneralConstants.SUCCESS) {
                System.out.println("total outstanding amount of Debit Notes at list view before syncing  " + sumOfTotalOutstandingAmountValues);
                Allure.step("total outstanding amount of Debit Notes at list view before syncing " + sumOfTotalOutstandingAmountValues);

                return sumOfTotalOutstandingAmountValues;
            } else {
                System.out.println("click on next icon");
                getWebElement(nextIcon).click();
                Thread.sleep(threadTimeOut);
            }
        }
        System.out.println("total outstanding amount of Debit Notes at list view before syncing  " + sumOfTotalOutstandingAmountValues);
        Allure.step("total outstanding amount of Debit Notes at list view before syncing " + sumOfTotalOutstandingAmountValues);

        return sumOfTotalOutstandingAmountValues;
    }
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
    public String getListAccountBeforeSyncing() {


        waitUntilElementVisibility(debitNoteLabel, GeneralConstants.minTimeOut);

        System.out.println("number of debit notes  at list view before Syncing " + getWebElement(listCount).getText());
        Allure.step("number of debit notes at list view before Syncing " + getWebElement(listCount).getText());


        return getWebElement(listCount).getText();
    }
    public String getNumberOfDraftNotesBeforeSyncing() throws InterruptedException {

        waitUntilElementToBePresent(debitNoteLabel, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        if (tryToGetWebElementV(emptyList) == GeneralConstants.SUCCESS) {
            System.out.println("msg which appear at view list " + getWebElement(emptyList).getText());
            System.out.println("there is no debit notes at purchase view list and comparing data of specific debit note not applicable");
            Allure.step("msg which appear at view list" + getWebElement(emptyList).getText());
            Allure.step("there is no debit notes at debit notes view list and comparing data of specific debit note not applicable");
            return "0";
        }
        if (tryToGetWebElementV(closeFilter) == GeneralConstants.SUCCESS) {
            System.out.println("close filter ");
            Allure.step("close filter ");
            getWebElement(closeFilter).click();
        }
        waitUntilElementToBePresent(numberOfDraftNotes, GeneralConstants.minTimeOut);
        System.out.println("number of draft debit notes at list view before syncing " + getWebElement(numberOfDraftNotes).getText());
        Allure.step("number of draft debit notes at list view before syncing " + getWebElement(numberOfDraftNotes).getText());
        return getWebElement(numberOfDraftNotes).getText();
    }
    public String getNumberOfAllDebitNotesBeforeSyncing() throws InterruptedException {
        waitUntilElementToBePresent(debitNoteLabel, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay,GeneralConstants.freezeTimeOut);
        //Thread.sleep(threadTimeOut);
      System.out.println("number of all debit notes at list view before Syncing " + getWebElement(numberOfAllDebitNotesField_4).getText());
      Allure.step("number of all debit notes at list view before Syncing " + getWebElement(numberOfAllDebitNotesField_4).getText());
        return getWebElement(numberOfAllDebitNotesField_4).getText();
    }

    public String getNumberOfAllDebitNotesAfterSyncing() throws InterruptedException {

        waitUntilElementToBePresent(debitNoteLabel, GeneralConstants.minTimeOut);

        waitUntilOverlayDisappear(overlay,GeneralConstants.freezeTimeOut);
        waitUntilElementNotHaveSpecificText(numberOfAllDebitNotesField_5,"تحديث");
        Thread.sleep(threadTimeOut);

        System.out.println("number of all debit notes at list view after Syncing " +getWebElement(numberOfAllDebitNotesField_5).getAttribute("textContent").replaceAll("[^0-9 ]", "").trim() .split(" ")[getWebElement(numberOfAllDebitNotesField_5).getAttribute("textContent").replaceAll("[^0-9 ]", "").trim() .split(" ").length - 1]);
         Allure.step("number of all debit notes at list view after Syncing " +getWebElement(numberOfAllDebitNotesField_5).getAttribute("textContent").replaceAll("[^0-9 ]", "").trim() .split(" ")[getWebElement(numberOfAllDebitNotesField_5).getAttribute("textContent").replaceAll("[^0-9 ]", "").trim() .split(" ").length - 1]);

     return getWebElement(numberOfAllDebitNotesField_5).getAttribute("textContent").replaceAll("[^0-9 ]", "").trim() .split(" ")[getWebElement(numberOfAllDebitNotesField_5).getAttribute("textContent").replaceAll("[^0-9 ]", "").trim() .split(" ").length - 1];
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
