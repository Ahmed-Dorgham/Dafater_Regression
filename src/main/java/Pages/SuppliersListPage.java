package Pages;

import GeneralConstants.GeneralConstants;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuppliersListPage extends MainPage {
    private String dataMigrationTitle = "data migration";
    // private WebDriver driver ;

    public SuppliersListPage(WebDriver driver) {
        this.driver = driver;
    }

    private By checkVmConnectionBtn = By.id("check_vm_connection");
    private By syncDocTypesDataBtn = By.id("sync_doctypes_data");
    private By statusMsg = By.className("msgprint");
    private By editIcon = By.className("icon-xs");
    private By salesInvoiceListTitle = By.xpath("(//*[contains(@title,'فاتورة المبيعات')]");
    private By listCount = By.xpath("(//*[contains(@class,'list-count')])");
    private By supplierLabel = By.xpath("(//h3[contains(text(),'المورد')])| (//h5[contains(text(),'قائمة مورد')])");
    private By newBtn = By.xpath("//*[contains(@class,'btn btn-default btn-sm primary-action toolbar-btn')]");
    private By closeFilterIcon = By.xpath("(//*[contains(@class,'filter-icon')])[2]");
    By overlay = By.xpath("//*[contains(@class,'freeze-message-container')] | //*[contains(@id,'freeze')]");
    By viewCompleteScreen = By.xpath("//*[@class='btn btn-secondary btn-sm ']");
    By scroll = By.xpath("//*[contains(text(),'الصفوف لكل صفحة')]");
    By numberOfAllISuppliersField = By.xpath("//*[contains(@class,'total-rows')] " +
            "|//*[contains(@class,'list-count')]/span");
    By numberOfSuppliersDebitsField = By.xpath("//h3[contains(text(),'مديونيات المورّدين')]/following-sibling::div/span" +
            "|//*[contains(@class,'supplier-lv-debits ')]");
    By numberOfPrepaymentNotUserField = By.xpath("//h3[contains(text(),'الدفعات المقدمة غير المستخدمة')]/following-sibling::div/span" +
            "|//*[contains(@class,'supplier-lv-balance ')]");
    private By itemNameAtViewList = By.xpath("(//a[contains(@data-doctype,'Item')])[1]");
    private By invoiceStatusAtListView = By.xpath("(((((//*[contains(@class,'level list-row-head font-weight-bold')])/following-sibling::div)[2])/div/div/div)[3])/span/span");
    private By invoiceTotalAmountValueAtListView = By.xpath("(((((//*[contains(@class,'level list-row-head font-weight-bold')])/following-sibling::div)[2])/div/div/div))[6]/span/a/div/span");
    private By totalInvoicesAmountAtViewList = By.xpath("//h3[contains(text(),'اجمالي الفواتير')]/following-sibling::div");
    private By salesInvoicesTab = By.id("module-anchor-Selling");
    private By sellingPriceListsOpt = By.xpath("//*[contains(@id,'sidebar-selling-price-lists')]");

    public ItemPage clickOnNewItemBtn() {
       Allure.step("click on new item btn ");
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(supplierLabel, GeneralConstants.minTimeOut);
        waitUntilElementToBeClickable(newBtn, GeneralConstants.minTimeOut);

        getWebElement(newBtn).click();
        waitUntilElementToBePresent(viewCompleteScreen, GeneralConstants.minTimeOut);
        getWebElement(viewCompleteScreen).click();
        return new ItemPage(driver);
    }

    public String getItemNameAtViewList(String expected) {

        waitUntilElementToBePresent(supplierLabel, GeneralConstants.minTimeOut);
        waitUntilElementToBePresent(newBtn, GeneralConstants.minTimeOut);

       Allure.step("actual text is " + getWebElement(itemNameAtViewList).getAttribute("title") + " and expected text is " + expected);
        return getWebElement(itemNameAtViewList).getText();
    }

    public String getListAccountBeforeCreatingNewSalesInvoices() {

        waitUntilElementToBePresent(supplierLabel, GeneralConstants.minTimeOut);
       Allure.step("number of sales invoices at list view before creating new sales invoices " + getWebElement(listCount).getText());
        return getWebElement(listCount).getText();
    }

    public String getNumberOfAllItemsBeforeCreatingNewItem() throws InterruptedException {

        waitUntilElementToBePresent(supplierLabel, GeneralConstants.minTimeOut);

       Allure.step("number of all items at list view before creating new item " + getWebElement(numberOfAllISuppliersField).getText());
        return getWebElement(numberOfAllISuppliersField).getText();
    }

    public String getNumberOfAllSuppliersBeforeSyncing() throws InterruptedException {
        waitUntilElementToBePresent(supplierLabel, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay,GeneralConstants.freezeTimeOut);

        Thread.sleep(threadTimeOut);
        if (tryToGetWebElementV(numberOfAllISuppliersField)==GeneralConstants.SUCCESS)
        {
            Allure.step("number of all suppliers at list view before Syncing " + getWebElement(numberOfAllISuppliersField).getText());
            return getWebElement(numberOfAllISuppliersField).getText();
        }
        else
        {
            return "0";
        }

    }

    public String getNumberOfAllSuppliersAfterSyncing() throws InterruptedException {

        waitUntilElementToBePresent(supplierLabel, GeneralConstants.minTimeOut);
        //   Thread.sleep(threadTimeOut);
        waitUntilOverlayDisappear(overlay,GeneralConstants.freezeTimeOut);
        scrollToSpeceficElement(scroll);
        waitUntilElementNotHaveSpecificText(numberOfAllISuppliersField,"تحديث");
        waitUntilElementToBePresent(numberOfAllISuppliersField, GeneralConstants.minTimeOut);
      System.out.println("number of all suppliers at list view after Syncing " + getWebElement(numberOfAllISuppliersField).getAttribute("textContent").trim());
       Allure.step("number of all suppliers at list view after Syncing " + getWebElement(numberOfAllISuppliersField).getAttribute("textContent").trim());
        return getWebElement(numberOfAllISuppliersField).getAttribute("textContent").trim();
    }

    public String getNumberOfSalesItemsBeforeCreatingNewItem() {

        waitUntilElementToBePresent(supplierLabel, GeneralConstants.minTimeOut);
       Allure.step("number of sales items at list view before creating new item " + getWebElement(numberOfSuppliersDebitsField).getText());
        return getWebElement(numberOfSuppliersDebitsField).getText();
    }

    public String getNumberOfSuppliersDebitsBeforeSyncing() throws InterruptedException {

        waitUntilElementToBePresent(supplierLabel, GeneralConstants.minTimeOut);
//        Thread.sleep(threadTimeOut);
        if (tryToGetWebElementV(numberOfSuppliersDebitsField)==GeneralConstants.SUCCESS)
        {
            Allure.step("value of suppliers debits at list view before Syncing" + getWebElement(numberOfSuppliersDebitsField).getText());
            return getWebElement(numberOfSuppliersDebitsField).getText();
        }
        else
        {
            return "0";
        }

    }

    public String getNumberOfSuppliersDebitsAfterSyncing() throws InterruptedException {

        waitUntilElementToBePresent(supplierLabel, GeneralConstants.minTimeOut);

//        Thread.sleep(threadTimeOut);
        waitUntilOverlayDisappear(overlay,GeneralConstants.freezeTimeOut);
        waitUntilElementNotHaveSpecificText(numberOfAllISuppliersField,"تحديث");
        waitUntilElementToBePresent(numberOfSuppliersDebitsField, GeneralConstants.minTimeOut);
       Allure.step("value of Suppliers Debits at list view after Syncing " + getWebElement(numberOfSuppliersDebitsField).getText());
      System.out.println("value of Suppliers Debits at list view after Syncing " + getWebElement(numberOfSuppliersDebitsField).getText());
        return getWebElement(numberOfSuppliersDebitsField).getText();
    }

    public String getNumberOfPurchaseItemsBeforeCreatingNewItem() {

        waitUntilElementToBePresent(supplierLabel, GeneralConstants.minTimeOut);
       Allure.step("number of purchase items at list view before creating new item " + getWebElement(numberOfPrepaymentNotUserField).getText());
        return getWebElement(numberOfPrepaymentNotUserField).getText();
    }

    public String getNumberOfPrepaymentNotUsedBeforeSyncing() throws InterruptedException {

        waitUntilElementToBePresent(supplierLabel, GeneralConstants.minTimeOut);
//        Thread.sleep(threadTimeOut);
        if (tryToGetWebElementV(numberOfPrepaymentNotUserField)==GeneralConstants.SUCCESS)
        {
            Allure.step("value of prepayment not used at list view before Syncing " + getWebElement(numberOfPrepaymentNotUserField).getText());
            return getWebElement(numberOfPrepaymentNotUserField).getText();
        }
        else
        {
            return "0";
        }
    }

    public String getNumberOfPrepaymentNotUsedAfterSyncing() throws InterruptedException {

        waitUntilElementToBePresent(supplierLabel, GeneralConstants.minTimeOut);
//        Thread.sleep(threadTimeOut);
        waitUntilOverlayDisappear(overlay,GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(numberOfPrepaymentNotUserField, GeneralConstants.minTimeOut);
       System.out.println("value of prepayment Not Used at list view after Syncing " + getWebElement(numberOfPrepaymentNotUserField).getText());
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

        waitUntilElementToBePresent(supplierLabel, GeneralConstants.minTimeOut);
       Allure.step("number of all items at list view after creating new item " + getWebElement(numberOfAllISuppliersField).getText());
        return getWebElement(numberOfAllISuppliersField).getText();
    }

    public String getNumberOfSalesItemsAfterCreatingNewItem() {

        waitUntilElementToBePresent(supplierLabel, GeneralConstants.minTimeOut);
       Allure.step("number of sales items at list view after creating new item " + getWebElement(numberOfSuppliersDebitsField).getText());
        return getWebElement(numberOfSuppliersDebitsField).getText();
    }

    public String getNumberOfPurchaseItemsAfterCreatingNewItem() {

        waitUntilElementToBePresent(supplierLabel, GeneralConstants.minTimeOut);
       Allure.step("number of sales items at list view after creating new item " + getWebElement(numberOfPrepaymentNotUserField).getText());
        return getWebElement(numberOfPrepaymentNotUserField).getText();
    }

    public String getListAccountAfterCreatingNewSalesInvoices() {

        waitUntilElementToBePresent(supplierLabel, GeneralConstants.minTimeOut);
       Allure.step("number of sales invoices at list view After creating new sales invoices " + getWebElement(listCount).getText());
        return getWebElement(listCount).getText();
    }
}
