package Pages;

import GeneralConstants.GeneralConstants;
import io.qameta.allure.Allure;
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
    private By listCount = By.xpath("(//*[contains(@class,'list-count')])" +
            "|(//*[contains(@class,'total-rows')])");
    private By creditNoteLabel = By.xpath("(//h3[contains(text(),'فاتورة المبيعات')])" +
            "| (//h5[contains(text(),'قائمة اشعار دائن')])" +
            "| (//h5[contains(text(),'قائمة مرتجع المشتريات')])" +
            "| (//h3[contains(text(),'فاتورة المشتريات')])");

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
    By closeFilter = By.xpath("//*[contains(@class,'btn btn-default btn-xs remove-filter')]");
    By firstCreditNote = By.xpath("(//*[contains(@class,'result-list')]//*[contains(@class,'doclist-row row')])[1]//a" +
            "|(//*[contains(@class,'result')]//*[contains(@class,'list-row-container')])[1]//*[contains(@class,'list-row-col ellipsis list-subject level ')]//a");
    By searchIcon = By.xpath("//li[@class='fas fa-search']");
    By nameField = By.xpath("//input[@data-fieldname='name']");
    private By totalPaymentReceivedAmountOfCreditNotesAtViewList = By.xpath("//h3[contains(text(),'الدفعات المقدمة')]/following-sibling::div" +
            "|//h3[contains(text(),'المبلغ المدفوع')]/following-sibling::div" +
            "|//*[@class='sales-invoice-lv-total-invoices ']");

    public String searchAboutSpecificCreditNote(String invoiceName) throws InterruptedException {

        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        Allure.step(" search about " + invoiceName);
        waitUntilElementToBePresent(searchIcon, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        getWebElement(searchIcon).click();
        waitUntilElementToBePresent(nameField, GeneralConstants.minTimeOut);
        getWebElement(nameField).sendKeys(invoiceName);
//        getWebElement(reloadIcon).click();
        Thread.sleep(threadTimeOut);
        if (tryToGetWebElementV(firstCreditNote) == GeneralConstants.SUCCESS) {
            Allure.step(" open credit note which appear after searching");
            getWebElement(firstCreditNote).click();
            return GeneralConstants.SUCCESS;
        } else {
            Allure.step(" error happen while syncing this credit note " + invoiceName + " from dafater 4 to dafater 5 and not synced successfully   ");
            return GeneralConstants.FAILED;
        }

    }

    public ItemPage clickOnNewItemBtn() {
        Allure.step("click on new item btn ");
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

        Allure.step("actual text is " + getWebElement(itemNameAtViewList).getAttribute("title") + " and expected text is " + expected);
        return getWebElement(itemNameAtViewList).getText();
    }

    public String getListAccountBeforeCreatingNewSalesInvoices() {

        waitUntilElementToBePresent(creditNoteLabel, GeneralConstants.minTimeOut);
        Allure.step("number of sales invoices at list view before creating new sales invoices " + getWebElement(listCount).getText());
        return getWebElement(listCount).getText();
    }

    public String getNumberOfAllItemsBeforeCreatingNewItem() throws InterruptedException {

        waitUntilElementToBePresent(creditNoteLabel, GeneralConstants.minTimeOut);

        Allure.step("number of all items at list view before creating new item " + getWebElement(numberOfAllCreditNotesField).getText());
        return getWebElement(numberOfAllCreditNotesField).getText();
    }

    public String getNumberOfAllCreditNotesBeforeSyncing() throws InterruptedException {
        waitUntilElementToBePresent(creditNoteLabel, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);

        Thread.sleep(threadTimeOut);
        System.out.println("number of all credit notes at list view before Syncing " + getWebElement(numberOfAllCreditNotesField).getText());
        Allure.step("number of all credit notes at list view before Syncing " + getWebElement(numberOfAllCreditNotesField).getText());
        return getWebElement(numberOfAllCreditNotesField).getText();
    }

    public String getNumberOfAllCreditNotesAfterSyncing() throws InterruptedException {

        waitUntilElementToBePresent(creditNoteLabel, GeneralConstants.minTimeOut);
        //   Thread.sleep(threadTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementNotHaveSpecificText(numberOfAllCreditNotesField, "تحديث");
        System.out.println("number of all credit notes at list view after Syncing " + getWebElement(numberOfAllCreditNotesField).getAttribute("textContent").replaceAll("[^0-9 ]", "").trim().split(" ")[getWebElement(numberOfAllCreditNotesField).getAttribute("textContent").replaceAll("[^0-9 ]", "").trim().split(" ").length - 1]);
        Allure.step("number of all credit notes at list view after Syncing " + getWebElement(numberOfAllCreditNotesField).getAttribute("textContent").replaceAll("[^0-9 ]", "").trim().split(" ")[getWebElement(numberOfAllCreditNotesField).getAttribute("textContent").replaceAll("[^0-9 ]", "").trim().split(" ").length - 1]);
        return  getWebElement(numberOfAllCreditNotesField).getAttribute("textContent").replaceAll("[^0-9 ]", "").trim().split(" ")[getWebElement(numberOfAllCreditNotesField).getAttribute("textContent").replaceAll("[^0-9 ]", "").trim().split(" ").length - 1];
    }

    public CreditNotePage openFirstCreditNoteAtDafater_4() throws InterruptedException {

        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        Allure.step(" open First Sales Invoice At Dafater_4 ");
        getWebElement(firstCreditNote).click();
        return new CreditNotePage(driver);
    }

    public String getNameOfFirstCreditNoteBeforeSyncing() throws InterruptedException {

        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        Thread.sleep(threadTimeOut);
        if (tryToGetWebElementV(closeFilter) == GeneralConstants.SUCCESS) {
            Allure.step("close filter ");
            getWebElement(closeFilter).click();
        }
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        Allure.step("name of first Credit Note at list view at dafater 4  >> " + getWebElement(firstCreditNote).getText());
        return getWebElement(firstCreditNote).getText();
    }


    public String getNumberOfSalesItemsBeforeCreatingNewItem() {

        waitUntilElementToBePresent(creditNoteLabel, GeneralConstants.minTimeOut);
        Allure.step("number of sales items at list view before creating new item " + getWebElement(numberOfCustomersDebitsField).getText());
        return getWebElement(numberOfCustomersDebitsField).getText();
    }

    public String getNumberOfCustomersDebitsBeforeSyncing() throws InterruptedException {

        waitUntilElementToBePresent(creditNoteLabel, GeneralConstants.minTimeOut);
//        Thread.sleep(threadTimeOut);
        Allure.step("value of Customers debits at list view before Syncing " + getWebElement(numberOfCustomersDebitsField).getText());
        return getWebElement(numberOfCustomersDebitsField).getText();
    }

    public String getNumberOfCustomersDebitsAfterSyncing() throws InterruptedException {

        waitUntilElementToBePresent(creditNoteLabel, GeneralConstants.minTimeOut);
//        Thread.sleep(threadTimeOut);
        Allure.step("value of Customers Debits at list view after Syncing " + getWebElement(numberOfCustomersDebitsField).getText());
        return getWebElement(numberOfCustomersDebitsField).getText();
    }

    public String getNumberOfPurchaseItemsBeforeCreatingNewItem() {

        waitUntilElementToBePresent(creditNoteLabel, GeneralConstants.minTimeOut);
        Allure.step("number of purchase items at list view before creating new item " + getWebElement(numberOfPrepaymentNotUserField).getText());
        return getWebElement(numberOfPrepaymentNotUserField).getText();
    }

    public String getNumberOfDraftCreditNotesBeforeSyncing() throws InterruptedException {

        waitUntilElementToBePresent(creditNoteLabel, GeneralConstants.minTimeOut);
        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        System.out.println("number of draft credit notes at list view before syncing " + getWebElement(numberOfDraftInvoices).getText());
        Allure.step("number of draft credit notes at list view before syncing " + getWebElement(numberOfDraftInvoices).getText());
        return getWebElement(numberOfDraftInvoices).getText();
    }

    public String getNumberOfDraftCreditNotesAfterSyncing() throws InterruptedException {

        waitUntilElementToBePresent(creditNoteLabel, GeneralConstants.minTimeOut);
        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        System.out.println("number of draft credit notes at list view after syncing " + getWebElement(numberOfDraftInvoices).getText());
        Allure.step("number of draft credit notes at list view after syncing " + getWebElement(numberOfDraftInvoices).getText());
        return getWebElement(numberOfDraftInvoices).getText();
    }

    public double getValueOfTotalInvoicesBeforeSyncing() throws InterruptedException {
        double sumOfTotalAmountValues = 0;
        waitUntilElementToBePresent(creditNoteLabel, GeneralConstants.minTimeOut);
        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        while (!getWebElement(listCountOffset).getText().contains(getWebElement(listCount).getText())) {
            // System.out.println(getWebElement(listCountOffset).getText());
            // System.out.println(getWebElement(listCount).getText());
            totalAmountValues = driver.findElements(totalAmountValue);
            for (int i = 0; i < totalAmountValues.size(); i++) {
                sumOfTotalAmountValues += Double.parseDouble(totalAmountValues.get(i).getText().replace(",", ""));
                //System.out.println(sumOfTotalAmountValues);
            }
            //  System.out.println("click on next icon");
            waitUntilElementToBeClickable(nextIcon, GeneralConstants.minTimeOut);
            getWebElement(nextIcon).click();
            Thread.sleep(threadTimeOut);
        }

        if (getWebElement(listCountOffset).getText().contains(getWebElement(listCount).getText())) {
            // System.out.println(getWebElement(listCountOffset).getText());
            // System.out.println(getWebElement(listCount).getText());
            totalAmountValues = driver.findElements(totalAmountValue);
            for (int i = 0; i < totalAmountValues.size(); i++) {
                sumOfTotalAmountValues += Double.parseDouble(totalAmountValues.get(i).getText().replace(",", ""));
                //System.out.println(sumOfTotalAmountValues);
            }

            if (getWebElement(listCount).getText().equals("0")) {
                System.out.println("value of total invoices of credit notes at list view before syncing  " + sumOfTotalAmountValues);
                Allure.step("value of total invoices of of credit notes at list view before syncing " + sumOfTotalAmountValues);
                return sumOfTotalAmountValues;
            } else {
                System.out.println("click on next icon");
//                scrollToSpeceficElement(nextIcon);
                getWebElement(nextIcon).click();
                Thread.sleep(threadTimeOut);
            }
        }
        System.out.println("value of total invoices of Credit notes at list view before syncing  " + sumOfTotalAmountValues);
        Allure.step("value of total invoices of Credit notes at list view before syncing  " + sumOfTotalAmountValues);
        return sumOfTotalAmountValues;

    }

    public String getValueOfTotalInvoicesAfterSyncing() throws InterruptedException {

        waitUntilElementToBePresent(creditNoteLabel, GeneralConstants.minTimeOut);
        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
       System.out.println("value of total invoices at list view After syncing " + getWebElement(valueOfTotalInvoices).getAttribute("textContent").replaceAll("\\s+", "") .replaceFirst("^-", ""));
        Allure.step("value of total invoices at list view After syncing " + getWebElement(valueOfTotalInvoices).getAttribute("textContent").replaceAll("\\s+", "") .replaceFirst("^-", ""));
        return getWebElement(valueOfTotalInvoices).getAttribute("textContent").replaceAll("\\s+", "") .replaceFirst("^-", "");
    }

    public double getValueOfOutstandingAmountBeforeSyncing() throws InterruptedException {
        double sumOfTotalOutstandingAmountValues = 0;
        waitUntilElementVisibility(draftLabel, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        Thread.sleep(threadTimeOut);
        while (!getWebElement(listCountOffset).getText().contains(getWebElement(listCount).getText())) {
            // System.out.println(getWebElement(listCountOffset).getText());
            // System.out.println(getWebElement(listCount).getText());
            totalOutstandingAmountValues = driver.findElements(totalOutstandingAmountValue);
            for (int i = 0; i < totalOutstandingAmountValues.size(); i++) {
                sumOfTotalOutstandingAmountValues += Double.parseDouble(totalOutstandingAmountValues.get(i).getText().replace(",", ""));
                // System.out.println(sumOfTotalOutstandingAmountValues);
            }
            //System.out.println("click on next icon");
            waitUntilElementToBeClickable(nextIcon, GeneralConstants.minTimeOut);
            getWebElement(nextIcon).click();
            Thread.sleep(threadTimeOut);
        }

        if (getWebElement(listCountOffset).getText().contains(getWebElement(listCount).getText())) {
//            System.out.println(getWebElement(listCountOffset).getText());
//            System.out.println(getWebElement(listCount).getText());
            totalOutstandingAmountValues = driver.findElements(totalOutstandingAmountValue);
            for (int i = 0; i < totalOutstandingAmountValues.size(); i++) {
                sumOfTotalOutstandingAmountValues += Double.parseDouble(totalOutstandingAmountValues.get(i).getText().replace(",", ""));
//                System.out.println(sumOfTotalOutstandingAmountValues);
            }
            if (getWebElement(listCount).getText().equals("0")) {
                System.out.println("total outstanding  amount of  credit notes at list view before syncing  " + sumOfTotalOutstandingAmountValues);
                Allure.step("total outstanding  amount of  credit notes at list view before syncing  " + sumOfTotalOutstandingAmountValues);
                return sumOfTotalOutstandingAmountValues;
            } else {
                System.out.println("click on next icon");
//                scrollToSpeceficElement(nextIcon);
                getWebElement(nextIcon).click();
                Thread.sleep(threadTimeOut);
            }
        }
        System.out.println("total outstanding  amount of  credit notes at list view before syncing " + sumOfTotalOutstandingAmountValues);
        Allure.step("total outstanding amount of credit notes  at list view before syncing " + sumOfTotalOutstandingAmountValues);
        return sumOfTotalOutstandingAmountValues;
    }

    public String getTotalPaymentReceivedAmountOfCreditNotesAfterSyncing() throws InterruptedException {

        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        System.out.println("total payment received amount of credit notes at list view after syncing " + getWebElement(totalPaymentReceivedAmountOfCreditNotesAtViewList).getAttribute("textContent").replaceAll("\\s+", "") .replaceFirst("^-", ""));
        Allure.step("total payment received  amount of credit notes at list view after syncing " + getWebElement(totalPaymentReceivedAmountOfCreditNotesAtViewList).getAttribute("textContent").replaceAll("\\s+", "") .replaceFirst("^-", ""));
        return getWebElement(totalPaymentReceivedAmountOfCreditNotesAtViewList).getAttribute("textContent").replaceAll("\\s+", "") .replaceFirst("^-", "");
    }
    public String getTotalPaidAmountOfCreditNotesAfterSyncing() throws InterruptedException {

        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        System.out.println("total paid amount amount of credit notes at list view after syncing " + getWebElement(totalPaymentReceivedAmountOfCreditNotesAtViewList).getAttribute("textContent").replaceAll("\\s+", ""));
        Allure.step("total paid amount  amount of credit notes at list view after syncing " + getWebElement(totalPaymentReceivedAmountOfCreditNotesAtViewList).getAttribute("textContent").replaceAll("\\s+", ""));
        return getWebElement(totalPaymentReceivedAmountOfCreditNotesAtViewList).getAttribute("textContent").replaceAll("\\s+", "");
    }
    public String getValueOfOutstandingAmountAfterSyncing() throws InterruptedException {

        waitUntilElementToBePresent(creditNoteLabel, GeneralConstants.minTimeOut);
        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
       System.out.println("value of outstanding amount at list view after syncing " + getWebElement(valueOfOutstandingAmount).getAttribute("textContent").replaceAll("\\s+", "") .replaceFirst("^-", ""));
        Allure.step("value of outstanding amount at list view after syncing " + getWebElement(valueOfOutstandingAmount).getAttribute("textContent").replaceAll("\\s+", "") .replaceFirst("^-", ""));
        return getWebElement(valueOfOutstandingAmount).getAttribute("textContent").replaceAll("\\s+", "") .replaceFirst("^-", "");
    }

    public String getNumberOfPrepaymentNotUsedBeforeSyncing() throws InterruptedException {

        waitUntilElementToBePresent(creditNoteLabel, GeneralConstants.minTimeOut);
//        Thread.sleep(threadTimeOut);
        Allure.step("value of prepayment not used at list view before Syncing " + getWebElement(numberOfPrepaymentNotUserField).getText());
        return getWebElement(numberOfPrepaymentNotUserField).getText();
    }

    public String getNumberOfPrepaymentNotUsedAfterSyncing() throws InterruptedException {

        waitUntilElementToBePresent(creditNoteLabel, GeneralConstants.minTimeOut);
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

        waitUntilElementToBePresent(creditNoteLabel, GeneralConstants.minTimeOut);
        Allure.step("number of all items at list view after creating new item " + getWebElement(numberOfAllCreditNotesField).getText());
        return getWebElement(numberOfAllCreditNotesField).getText();
    }

    public String getNumberOfSalesItemsAfterCreatingNewItem() {

        waitUntilElementToBePresent(creditNoteLabel, GeneralConstants.minTimeOut);
        Allure.step("number of sales items at list view after creating new item " + getWebElement(numberOfCustomersDebitsField).getText());
        return getWebElement(numberOfCustomersDebitsField).getText();
    }

    public String getNumberOfPurchaseItemsAfterCreatingNewItem() {

        waitUntilElementToBePresent(creditNoteLabel, GeneralConstants.minTimeOut);
        Allure.step("number of sales items at list view after creating new item " + getWebElement(numberOfPrepaymentNotUserField).getText());
        return getWebElement(numberOfPrepaymentNotUserField).getText();
    }

    public String getListAccountAfterCreatingNewSalesInvoices() {

        waitUntilElementToBePresent(creditNoteLabel, GeneralConstants.minTimeOut);
        Allure.step("number of sales invoices at list view After creating new sales invoices " + getWebElement(listCount).getText());
        return getWebElement(listCount).getText();
    }
}
