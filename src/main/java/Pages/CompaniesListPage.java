package Pages;

import GeneralConstants.GeneralConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompaniesListPage extends MainPage {
    private String dataMigrationTitle = "data migration";
    // private WebDriver driver ;

    public CompaniesListPage(WebDriver driver) {
        this.driver = driver;
    }

    private By checkVmConnectionBtn = By.id("check_vm_connection");
    private By syncDocTypesDataBtn = By.id("sync_doctypes_data");
    private By statusMsg = By.className("msgprint");
    private By editIcon = By.className("icon-xs");
    private By viewInListTitle = By.xpath("(//*[contains(@class,'custom-btn-group-label')])");
    private By listCount = By.xpath("(//*[contains(@class,'list-count')])");
    private By allItemsLabel = By.xpath("(//h3[contains(text(),'جميع العناصر')])| (//div[contains(text(),'الاصناف الكلية')])");
    private By newBtn = By.xpath("//*[contains(@class,'btn btn-default btn-sm primary-action toolbar-btn')]");
    private By closeFilterIcon = By.xpath("(//*[contains(@class,'filter-icon')])[2]");
    By overlay = By.xpath("//*[contains(@class,'freeze-message-container')] | //*[contains(@id,'freeze')]");
    By viewCompleteScreen = By.xpath("//*[@class='btn btn-secondary btn-sm ']");
    By numberOfAllItemsField = By.xpath("//h3[contains(text(),'جميع العناصر')]/following-sibling::div " +
            "|//*[contains(@class,'item-all')]");
    By numberOfSalesItemsField = By.xpath("//h3[contains(text(),'عناصر البيع')]/following-sibling::div " +
            "|//*[contains(@class,'item-sales-items ')]");
    By numberOfPurchaseItemsField = By.xpath("//h3[contains(text(),'عناصر الشراء')]/following-sibling::div" +
            "|//*[contains(@class,'item-purchase-items ')]");
    private By itemNameAtViewList = By.xpath("(//a[contains(@data-doctype,'Item')])[1]");
    private By invoiceStatusAtListView = By.xpath("(((((//*[contains(@class,'level list-row-head font-weight-bold')])/following-sibling::div)[2])/div/div/div)[3])/span/span");
    private By invoiceTotalAmountValueAtListView = By.xpath("(((((//*[contains(@class,'level list-row-head font-weight-bold')])/following-sibling::div)[2])/div/div/div))[6]/span/a/div/span");
    private By totalInvoicesAmountAtViewList = By.xpath("//h3[contains(text(),'اجمالي الفواتير')]/following-sibling::div");
    private By salesInvoicesTab = By.id("module-anchor-Selling");
    private By sellingPriceListsOpt = By.xpath("//*[contains(@id,'sidebar-selling-price-lists')]");
    private By chosenCompany ;
    private By totalCompanies = By.xpath("(//*[contains(@class,'total-rows')])" +
            "| (//*[contains(@class,'list-count')])");
    private By companyLabel = By.xpath("(//h3[contains(text(),'الشركة')])" +
            "| (//h5[contains(text(),'قائمة شركة')])");

    public CompanyPage openSpecificCompany(String companyName) {
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(viewInListTitle,GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
       chosenCompany = By.xpath( "//*[contains(@title,'" + companyName + "')]");
        System.out.println("open company  ");
        waitUntilElementToBePresent(chosenCompany,GeneralConstants.minTimeOut);
        scrollToSpeceficElement(chosenCompany);
        waitUntilElementToBePresent(chosenCompany,GeneralConstants.minTimeOut);
       getWebElement(chosenCompany).click();
       return new CompanyPage(driver);

    }

    public String getItemNameAtViewList(String expected) {

        waitUntilElementToBePresent(allItemsLabel, GeneralConstants.minTimeOut);
        waitUntilElementToBePresent(newBtn, GeneralConstants.minTimeOut);

        System.out.println("actual text is " + getWebElement(itemNameAtViewList).getAttribute("title") + " and expected text is " + expected);
        return getWebElement(itemNameAtViewList).getText();
    }

    public String getNumberOfAllCompaniesBeforeSyncing() {

        waitUntilElementToBePresent(companyLabel, GeneralConstants.minTimeOut);
        System.out.println("number of companies at list view before Syncing " + getWebElement(totalCompanies).getText());
        return getWebElement(totalCompanies).getText();
    }
    public String getNumberOfAllCompaniesAfterSyncing() {

        waitUntilElementToBePresent(companyLabel, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay,GeneralConstants.freezeTimeOut);
        waitUntilElementNotHaveSpecificText(listCount,"تحديث");
        System.out.println("number of companies at list view after Syncing " + getWebElement(totalCompanies).getText());
        return getWebElement(totalCompanies).getText();
    }
    public String getNumberOfAllItemsBeforeCreatingNewItem() throws InterruptedException {

        waitUntilElementToBePresent(allItemsLabel, GeneralConstants.minTimeOut);

        System.out.println("number of all items at list view before creating new item " + getWebElement(numberOfAllItemsField).getText());
        return getWebElement(numberOfAllItemsField).getText();
    }

    public String getNumberOfAllItemsBeforeSyncing() throws InterruptedException {

        waitUntilElementToBePresent(allItemsLabel, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        System.out.println("number of all items at list view before Syncing " + getWebElement(numberOfAllItemsField).getText());
        return getWebElement(numberOfAllItemsField).getText();
    }

    public String getNumberOfAllItemsAfterSyncing() throws InterruptedException {

        waitUntilElementToBePresent(allItemsLabel, GeneralConstants.minTimeOut);
        //   Thread.sleep(threadTimeOut);
        System.out.println("number of all items at list view after Syncing " + getWebElement(numberOfAllItemsField).getText());
        return getWebElement(numberOfAllItemsField).getText();
    }

    public String getNumberOfSalesItemsBeforeCreatingNewItem() {

        waitUntilElementToBePresent(allItemsLabel, GeneralConstants.minTimeOut);
        System.out.println("number of sales items at list view before creating new item " + getWebElement(numberOfSalesItemsField).getText());
        return getWebElement(numberOfSalesItemsField).getText();
    }

    public String getNumberOfSalesItemsBeforeSyncing() throws InterruptedException {

        waitUntilElementToBePresent(allItemsLabel, GeneralConstants.minTimeOut);
//        Thread.sleep(threadTimeOut);
        System.out.println("number of sales items at list view before Syncing " + getWebElement(numberOfSalesItemsField).getText());
        return getWebElement(numberOfSalesItemsField).getText();
    }

    public String getNumberOfSalesItemsAfterSyncing() throws InterruptedException {

        waitUntilElementToBePresent(allItemsLabel, GeneralConstants.minTimeOut);
//        Thread.sleep(threadTimeOut);
        System.out.println("number of sales items at list view after Syncing " + getWebElement(numberOfSalesItemsField).getText());
        return getWebElement(numberOfSalesItemsField).getText();
    }

    public String getNumberOfPurchaseItemsBeforeCreatingNewItem() {

        waitUntilElementToBePresent(allItemsLabel, GeneralConstants.minTimeOut);
        System.out.println("number of purchase items at list view before creating new item " + getWebElement(numberOfPurchaseItemsField).getText());
        return getWebElement(numberOfPurchaseItemsField).getText();
    }

    public String getNumberOfPurchaseItemsBeforeSyncing() throws InterruptedException {

        waitUntilElementToBePresent(allItemsLabel, GeneralConstants.minTimeOut);
//        Thread.sleep(threadTimeOut);
        System.out.println("number of purchase items at list view before Syncing " + getWebElement(numberOfPurchaseItemsField).getText());
        return getWebElement(numberOfPurchaseItemsField).getText();
    }

    public String getNumberOfPurchaseItemsAfterSyncing() throws InterruptedException {

        waitUntilElementToBePresent(allItemsLabel, GeneralConstants.minTimeOut);
//        Thread.sleep(threadTimeOut);
        System.out.println("number of purchase items at list view after Syncing " + getWebElement(numberOfPurchaseItemsField).getText());
        return getWebElement(numberOfPurchaseItemsField).getText();
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

        waitUntilElementToBePresent(allItemsLabel, GeneralConstants.minTimeOut);
        System.out.println("number of all items at list view after creating new item " + getWebElement(numberOfAllItemsField).getText());
        return getWebElement(numberOfAllItemsField).getText();
    }

    public String getNumberOfSalesItemsAfterCreatingNewItem() {

        waitUntilElementToBePresent(allItemsLabel, GeneralConstants.minTimeOut);
        System.out.println("number of sales items at list view after creating new item " + getWebElement(numberOfSalesItemsField).getText());
        return getWebElement(numberOfSalesItemsField).getText();
    }

    public String getNumberOfPurchaseItemsAfterCreatingNewItem() {

        waitUntilElementToBePresent(allItemsLabel, GeneralConstants.minTimeOut);
        System.out.println("number of sales items at list view after creating new item " + getWebElement(numberOfPurchaseItemsField).getText());
        return getWebElement(numberOfPurchaseItemsField).getText();
    }

    public String getListAccountAfterCreatingNewSalesInvoices() {

        waitUntilElementToBePresent(allItemsLabel, GeneralConstants.minTimeOut);
        System.out.println("number of sales invoices at list view After creating new sales invoices " + getWebElement(listCount).getText());
        return getWebElement(listCount).getText();
    }
//    public void enterValidDataIntoMainData (String vmUrl , String apiKey , String secretKey)
//    {
//        waitUntilElementVisibility(vmUrlInputField,GeneralConstants.minTimeOut);
//        getWebElement(vmUrlInputField).clear();
//        getWebElement(vmUrlInputField).sendKeys(vmUrl);
//        getWebElement(apiKeyInputField).clear();
//        getWebElement(apiKeyInputField).sendKeys(apiKey);
//        getWebElement(secretKeyInputField).clear();
//        getWebElement(secretKeyInputField).sendKeys(secretKey);
//    }
}
