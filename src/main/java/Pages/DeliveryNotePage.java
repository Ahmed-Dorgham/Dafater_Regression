package Pages;

import GeneralConstants.GeneralConstants;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class DeliveryNotePage extends MainPage {
    private String dataMigrationTitle = "data migration";
    // private WebDriver driver ;
    private String homePageLink;

    public DeliveryNotePage(WebDriver driver) {
        this.driver = driver;
    }

    private By checkVmConnectionBtn = By.id("check_vm_connection");
    private By updateStockBtn = By.id("update_stock");
    private By statusMsg = By.className("msgprint");
    private By editIcon = By.className("icon-xs");
    private By newDeliveryNoteTitle = By.xpath("//*[contains(@title,'سند تسليم جديد')]");
    private By customerFieldDeliveyNote = By.xpath("(//*[contains(@id,'customer')])[4]" +
            "| (//*[contains(@title,'عميل')]//*[contains(@data-fieldname,'customer')])[1]");
    private By itemCodeField = By.xpath("(//*[contains(@data-fieldname,'item_code')])[2]");
    private By itemsLabel = By.xpath("(//*[contains(text(),'الاصناف')])[2]");
    private By totalAmountLabel = By.xpath("(//*[contains(text(),'الكمية الإجمالية')])");
    private By itemCodeInputField = By.xpath("(//*[contains(@id,'item_code')])" +
            "|(//*[contains(@title,'delivery_note_details')]//*[contains(@data-doctype,'Delivery Note Item')])[1]");
    private By customersListSalesOrder = By.xpath("(//*[contains(@data-target,'Customer')and @placeholder=' ']/following-sibling::ul)");
    private By customerOptDeliveryNote = By.xpath("((//*[contains(@data-target,'Customer')and @placeholder=' ']/following-sibling::ul)/li)[1]" +
            "| ((//*[contains(@data-target,'Customer')and @placeholder=' ']/following-sibling::ul)/div/p/strong)[1]" +
            "|(//*[contains(@style,'font-weight: bold;')])[6]");
    private By itemOpt = By.xpath("((//*[contains(@data-target,'Item')and @placeholder='رمز الصنف']/following-sibling::ul)/li)[1]" +
            "| ((//*[contains(@data-target,'Item')and @placeholder='رمز الصنف']/following-sibling::ul)/div/p/strong)[1]");
    private By createBtn = By.xpath("//*[contains(@class,'btn toolbar-btn btn-primary')]" +
            "|(//*[contains(@id,'appframe-btn-إنشاء فاتورة')])[2]");

    private By salesInvoiceChoice = By.xpath("//*[contains(text(),'فاتورة المبيعات') and @class = 'dropdown-item']");
    private By saveAndSubmitBtn = By.xpath("//*[contains(@class,'btn btn-inverse btn-sm save-submit-action toolbar-btn')]" +
            "|(//*[contains(@id,'appframe-btn-حفظ')])[3]");
    private By yesBtn = By.xpath("(//*[contains(@class,'btn btn-primary btn-sm btn-modal-primary')])" +
            "|(//*[contains(@class,'btn  btn-yes')])");
    private By deliveryNoteStatus = By.xpath("(//*[contains(@class,'indicator-pill no-indicator-dot whitespace-nowrap orange')])[1]");
    private By deliveryNoteCompletedStatus = By.xpath("(//*[contains(@class,'indicator-pill no-indicator-dot whitespace-nowrap green')])");
    private By salesOrdersOpt = By.xpath("(//*[contains(@id,'sidebar-selling-sales-orders')]/span)[1]");
    private By deliveyNoteOpt = By.xpath("(//*[contains(@id,'sidebar-stock-delivery-note')]/span)[1]");
    private By viewBtn = By.xpath("(//button[contains(text(),'واجهة')])[2]");
    //*[contains(text(),'أوامر البيع')]
    private By deliveryNoteNameAtViewList = By.xpath("(//a[contains(@data-doctype,'Delivery Note')])[1]");
    private By listCount = By.xpath("(//*[contains(@class,'list-count')])");
    private By draftLabel = By.xpath("(//h3[contains(text(),'مسودة')])");
    private By salesInvoicesTab = By.id("module-anchor-Selling");
    By overlay = By.xpath("//*[contains(@class,'freeze-message-container')]");
    private By wareHouseTab = By.id("module-anchor-Stock");
    private By cancelBtn = By.xpath("(//*[contains(@id,'appframe-btn-إلغاء')])[4]");
    private By newBtn = By.xpath("(//button[contains(@class,'btn btn-default btn-sm primary-action toolbar-btn')])");
    private By deliveryNoteIssueDateField = By.xpath("//*[contains(text(),' تاريخ اصدار السند')]/../following-sibling::div" +
            "|//label[contains(@for,'posting_date')]/following-sibling::div " +
            "| //*[contains(@for,'posting_date')]/following-sibling::div " +
            "|(//*[contains(@title,'تاريخ الإدخال')])[2]");
    private By successStatusField = By.xpath("//*[contains(@class,'title-text pull-left')]/following-sibling::div//span[contains(@class,'label label-success')]" +
            "|//*[contains(@class,'ellipsis title-text')]/following-sibling::div/span" +
            "|(//*[contains(@class,'label label-success')])[2]//i");
    private By customerNameField = By.xpath("//*[contains(text(),' اسم العميل')]/../following-sibling::div/a" +
            "|//*[@data-doctype='Customer']");
    private By netTotalField = By.xpath("(//*[contains(@title,'net_total_export')]//span)[3]" +
            "| (//*[@data-fieldname='total']//span[@dir='rtl'])[1]");
    private By grandTotalField = By.xpath("(//*[contains(@title,'grand_total_export')]//span)[3]" +
            "| //*[contains(text(),'المجموع الإجمالي')]/following-sibling::div/div/span");
    private By draftStatusField = By.xpath("(//*[contains(@class,'ellipsis title-text')]/following-sibling::span)[4]");
    private By deliveryNoteName = By.xpath("(//*[contains(@class,'ellipsis title-text')]/following-sibling::span)[4]" +
            "|(//*[contains(@class,'title-text pull-left')])[6]");
    private By salesInvoicesOpt = By.xpath("//*[contains(@id,'sidebar-selling-invoice')]");

    private By invoiceNameAtViewList = By.xpath("(//a[contains(@data-doctype,'Sales Invoice')])[1]");

    private By namingField = By.xpath("(//*[contains(@title,'تسمية السلسلة')]//*[contains(@title,'إختر')])[2]");
    private By namingOpt = By.xpath("(//*[contains(@title,'تسمية السلسلة')]//ul//li//a)[3]");
    By loadImage = By.xpath("(//*[contains(@alt,'Generic Empty State')])[3]" +
            "| (//*[contains(@class,'progress progress-striped active')])" +
            "|(//*[contains(@id,'freeze')])");
    private By addBtn = By.xpath("//*[contains(@title,'delivery_note_details')]//*[contains(text(),' إضافة صف جديد')]");
    private By barcodeField = By.xpath("(//*[contains(@title,'الباركود')]//*[contains(@data-fieldname,'barcode')])[2]");

    public void enterValidDataIntoDeliveryNotePage(String itemName) throws InterruptedException {
        By selectedItem = By.xpath("((//*[contains(@data-target,'Item')and @placeholder='رمز الصنف']/following-sibling::ul)/div/p[@title='" + itemName + "']/strong)");

        waitUntilElementToBePresent(newDeliveryNoteTitle, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        Allure.step("select  customer ");
        getWebElement(customerFieldDeliveyNote).click();
        waitUntilElementVisibility(customersListSalesOrder, GeneralConstants.minTimeOut);
        waitUntilElementToBeClickable(customerOptDeliveryNote, GeneralConstants.minTimeOut);
        getWebElement(customerOptDeliveryNote).click();
//       Allure.step("enter dues date  ");
//        waitUntilElementVisibility(dueDateField, GeneralConstants.minTimeOut);
//        getWebElement(dueDateField).sendKeys(dueDate);
        Allure.step("Scroll down to item field ");
        scrollToSpeceficElement(totalAmountLabel);
        //Thread.sleep(6000);
        Allure.step(" select item  ");
        clickByActions(itemCodeField);
        waitUntilElementToBePresent(itemCodeInputField, GeneralConstants.minTimeOut);
        getWebElement(itemCodeInputField).sendKeys(itemName);
        waitUntilElementToBeClickable(itemOpt, GeneralConstants.minTimeOut);
        getWebElement(itemCodeInputField).sendKeys(itemName);
        getWebElement(itemCodeInputField).sendKeys(itemName);
        waitUntilElementToBeClickable(selectedItem, GeneralConstants.minTimeOut);
        clickByActions(selectedItem);
        Allure.step("scroll up to save and submit btn ");
        scrollToSpeceficElement(saveAndSubmitBtn);
        Allure.step(" save and submit delivery note ");
        getWebElement(saveAndSubmitBtn).click();
        Allure.step("click on yes btn ");
        waitUntilElementToBeClickable(yesBtn, GeneralConstants.minTimeOut);
        getWebElement(yesBtn).click();
    }

    public void enterValidDataIntoDeliveryNotePage_4(String itemName) throws InterruptedException {
        By selectedItem = By.xpath("((//*[contains(@data-target,'Item')and @placeholder='رمز الصنف']/following-sibling::ul)/div/p[@title='" + itemName + "']/strong)");

        waitUntilOverlayDisappear(loadImage, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(saveAndSubmitBtn, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        Allure.step("select  series naming ");
        waitUntilElementVisibility(namingField, GeneralConstants.minTimeOut);
        getWebElement(namingField).click();
        waitUntilElementVisibility(namingOpt, GeneralConstants.minTimeOut);
        getWebElement(namingOpt).click();
        Allure.step("select  customer ");
        getWebElement(customerFieldDeliveyNote).click();
        waitUntilElementToBeClickable(customerOptDeliveryNote, GeneralConstants.minTimeOut);
        getWebElement(customerOptDeliveryNote).click();
        Allure.step("Scroll down to item field ");
        scrollToSpeceficElement(addBtn);
        Allure.step(" enter item  ");
        clickByActions(addBtn);
        waitUntilElementVisibility(itemCodeInputField, GeneralConstants.minTimeOut);
        clickByActions(itemCodeInputField);
        getWebElement(itemCodeInputField).sendKeys(itemName);

        clickByActions(barcodeField);
        waitUntilOverlayDisappear(loadImage, GeneralConstants.minTimeOut);
        Allure.step(" click on save and submit btn   ");
        scrollToSpeceficElement(saveAndSubmitBtn);
        Thread.sleep(threadTimeOut);
        clickByActions(saveAndSubmitBtn);
        Allure.step("click on yes btn ");
        waitUntilElementToBeClickable(yesBtn, GeneralConstants.minTimeOut);
        getWebElement(yesBtn).click();
    }

    public String getDeliveryNoteName() {

        waitUntilElementToBePresent(viewBtn, GeneralConstants.minTimeOut);
        Allure.step("delivery note name  is  " + getWebElement(deliveryNoteName).getAttribute("title"));
        return getWebElement(deliveryNoteName).getText();
    }

    public String getDeliveryNoteName_4() {

        waitUntilElementToBePresent(cancelBtn, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(loadImage, GeneralConstants.globalTimeOut);
        System.out.println("delivery note name  is  " + (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].textContent.trim();", getWebElement(deliveryNoteName)));
        Allure.step("delivery note name  is  " + (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].textContent.trim();", getWebElement(deliveryNoteName)));

        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].textContent.trim();", getWebElement(deliveryNoteName));

    }

    public String getDeliveryNoteNameAtViewList(String expected) {
        waitUntilElementToBePresent(createBtn, GeneralConstants.minTimeOut);
        Allure.step("navigate to delivery note list  ");
        getWebElement(salesInvoicesOpt).click();
        driver.navigate().refresh();
        waitUntilElementToBePresent(draftLabel, GeneralConstants.minTimeOut);
        Allure.step("actual text is " + getWebElement(invoiceNameAtViewList).getAttribute("title") + " and expected text is " + expected);
        return getWebElement(invoiceNameAtViewList).getText();
    }

    public String getSalesOrderStatusBeforeCreatingRelatedSalesInvoice() {
//       Allure.step("Verify the status of sales invoice  ");
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(createBtn, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        Allure.step("status of delivery note before creating related sales invoices " + getWebElement(deliveryNoteStatus).getText());
        return getWebElement(deliveryNoteStatus).getText();

    }

    public String getDeliveryNoteStatusAfterCreatingRelatedSalesInvoice() throws InterruptedException {

        waitUntilElementToBePresent(viewBtn, GeneralConstants.minTimeOut);
        Allure.step("click on warehouse tab");
        waitUntilElementToBeClickable(wareHouseTab, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        getWebElement(wareHouseTab).click();
//        getWebElement(salesInvoicesTab).click();
        Allure.step("click on delivery note option");

//        Thread.sleep(9000);
        waitUntilElementToBePresent(deliveyNoteOpt, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        getWebElement(deliveyNoteOpt).click();
        clickByActions(deliveyNoteOpt);

        waitUntilElementToBePresent(newBtn, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        driver.navigate().refresh();
        Allure.step("open last created delivery note");
        waitUntilElementToBePresent(newBtn, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        getWebElement(deliveryNoteNameAtViewList).click();
        waitUntilElementToBePresent(createBtn, GeneralConstants.minTimeOut);
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        Allure.step("status of delivery note after creating related sales invoices " + getWebElement(deliveryNoteCompletedStatus).getText());
        return getWebElement(deliveryNoteCompletedStatus).getText();

    }

    public SalesInvoicesPage createNewSalesInvoiceFromDeliveryNote() {
        Allure.step("click on create btn");
        waitUntilElementToBePresent(createBtn, GeneralConstants.minTimeOut);
        getWebElement(createBtn).click();
        Allure.step("click on sales invoice");
        waitUntilElementVisibility(salesInvoiceChoice, GeneralConstants.minTimeOut);
        getWebElement(salesInvoiceChoice).click();
        return new SalesInvoicesPage(driver);
    }

    public SalesInvoicesPage createNewSalesInvoiceFromDeliveryNote_4() {
        Allure.step("click on create btn");
        waitUntilElementToBePresent(createBtn, GeneralConstants.minTimeOut);
        getWebElement(createBtn).click();
        waitUntilOverlayDisappear(loadImage, GeneralConstants.globalTimeOut);
        return new SalesInvoicesPage(driver);
    }

    public String getDeliveryNoteStatus() {
        String draftStatus = "مسودة";
        waitUntilElementToBePresent(deliveryNoteIssueDateField, GeneralConstants.minTimeOut);
        if (tryToGetWebElementV(successStatusField) == GeneralConstants.SUCCESS) {
//           Allure.step(" status of sales invoice  " + getWebElement(successStatusField).getText());
            return getWebElement(successStatusField).getText();
        } else {
//           Allure.step(" status of sales invoice  is " + draftStatus);
            return draftStatus;
        }
    }

    public String getDeliveryNoteStatus(String status) {

        String draftStatus = "مسودة";

        waitUntilElementToBePresent(deliveryNoteIssueDateField, GeneralConstants.minTimeOut);

        if (tryToGetWebElementV(successStatusField) == GeneralConstants.SUCCESS) {

            return getWebElement(successStatusField).getText().trim();
        } else {
            return draftStatus;
        }
    }

    public String getDeliveryNoteStatus_4(String status) {

        String draftStatus = "مسودة";
        waitUntilOverlayDisappear(loadImage, GeneralConstants.minTimeOut);
        waitUntilElementToBePresent(deliveryNoteIssueDateField, GeneralConstants.minTimeOut);
        if (tryToGetWebElementV(cancelBtn) == GeneralConstants.SUCCESS) {

            return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].textContent.trim();", getWebElement(successStatusField));
        } else {
            return draftStatus;
        }
    }

    public String getDeliveryNoteIssueDate() {
        waitUntilElementToBePresent(deliveryNoteIssueDateField, GeneralConstants.minTimeOut);
        Allure.step("issue date of delivery note " + getWebElement(deliveryNoteIssueDateField).getText());
        return getWebElement(deliveryNoteIssueDateField).getText();
    }

    public String getCustomerNameAtDeliveryNote() {
        waitUntilElementToBePresent(deliveryNoteIssueDateField, GeneralConstants.minTimeOut);
        Allure.step("customer name at delivery note  " + getWebElement(customerNameField).getText());
        return getWebElement(customerNameField).getText();
    }

    public String getNetTotalValueAtSalesInvoice() {
        waitUntilElementToBePresent(deliveryNoteIssueDateField, GeneralConstants.minTimeOut);
        Allure.step("net total value of delivery note  " + getWebElement(netTotalField).getText());
        return getWebElement(netTotalField).getText();
    }

    public String getGrandTotalValueAtSalesInvoice() {
        waitUntilElementToBePresent(deliveryNoteIssueDateField, GeneralConstants.minTimeOut);
        Allure.step("grand total value of   delivery note  " + getWebElement(grandTotalField).getText());
        return getWebElement(grandTotalField).getText();
    }

    public String getSalesInvoiceStatusAtDafater_5() {
        waitUntilElementToBePresent(deliveryNoteIssueDateField, GeneralConstants.minTimeOut);
        if (tryToGetWebElementV(successStatusField) == GeneralConstants.SUCCESS) {
//           Allure.step("status of sales invoice  " + getWebElement(successStatusField).getText());
            return getWebElement(successStatusField).getText();
        } else {
//           Allure.step("status of sales invoice  is  " + getWebElement(draftStatusField).getText());
            return getWebElement(draftStatusField).getText();
        }
    }

    public String getCustomerNameAtDeliveryNoteAtDafater_5() {
        waitUntilElementToBePresent(deliveryNoteIssueDateField, GeneralConstants.minTimeOut);

        Allure.step("customer name at delivery note  " + getWebElement(customerNameField).getText());
        return getWebElement(customerNameField).getText();
    }
}
