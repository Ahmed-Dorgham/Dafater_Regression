package Pages;

import GeneralConstants.GeneralConstants;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CreditNotePage extends MainPage {
    private String dataMigrationTitle = "data migration";
    // private WebDriver driver ;

    public CreditNotePage(WebDriver driver) {
        this.driver = driver;
    }

    private By checkVmConnectionBtn = By.id("check_vm_connection");
    private By updateStockBtn = By.id("update_stock");
    private By reasonField = By.id("reason");
    private By statusMsg = By.id("msgprint");
    private By editIcon = By.className("icon-xs");
    Select reason;
    private By newSalesInvoiceTitle = By.xpath("//*[contains(@title,'فاتورة المبيعات جديد')]");
    private By customerFieldSalesInvoice = By.xpath("(//*[contains(@id,'customer')])[4]");
    private By itemCodeField = By.xpath("(//*[contains(@data-fieldname,'item_code')])[2]");
    private By itemCodeInputField = By.xpath("(//*[contains(@id,'item_code')])");
    private By customersListSalesInvoice = By.xpath("(//*[contains(@data-target,'Customer')and @placeholder=' ']/following-sibling::ul)");
    private By customerOptSalesInvoice = By.xpath("((//*[contains(@data-target,'Customer')and @placeholder=' ']/following-sibling::ul)/li)[1]");
    private By itemOpt = By.xpath("((//*[contains(@data-target,'Item')and @placeholder='صنف']/following-sibling::ul)/li)[1]");
    private By dueDateField = By.xpath("//*[contains(@id,'due_date')]");
    private By saveAndSubmitBtn = By.xpath("//*[contains(@class,'btn btn-inverse btn-sm save-submit-action toolbar-btn')]");
    private By saveAndSubmitBtnFromCreditNote = By.xpath("(//*[contains(@class,'btn btn-inverse btn-sm save-submit-action toolbar-btn')])");
    private By yesBtn = By.xpath("(//*[contains(@class,'btn btn-primary btn-sm btn-modal-primary')])");
    private By yesBtn_SO = By.xpath("(//*[contains(@class,'btn btn-primary btn-sm btn-modal-primary')])[2]");
    private By closeIcon = By.xpath("(//*[contains(@class,'btn btn-modal-close btn-link')])[3]");
    private By creditNoteStatus = By.xpath("(//*[contains(@class,'label label-success')])");
    private By createBtn = By.xpath("(//*[contains(@class,'btn btn-default toolbar-btn')])[3]");

    private By salesInvoiceNameInsideCreditNote = By.xpath("//label[contains(@for,'return_against')]//following-sibling::div/a");
    private By IssueDateField = By.xpath("//*[contains(text(),'تاريخ إصدار الإرجاع')]/../following-sibling::div" +
            "|//label[contains(@for,'posting_date')]/following-sibling::div " +
            "| //*[contains(@for,'posting_date')]/following-sibling::div ");
    private By successStatusField = By.xpath("//*[contains(@class,'ellipsis title-text')]/following-sibling::div/span" +
            "|//*[contains(@class,'title-text pull-left')]/following-sibling::div//span[contains(@class,'label label-success')]");

    public void enterValidDataIntoSalesInvoicePage(String dueDate) throws InterruptedException {
        waitUntilElementVisibility(newSalesInvoiceTitle, GeneralConstants.minTimeOut);
        System.out.println("select  customer ");
        getWebElement(customerFieldSalesInvoice).click();
        waitUntilElementVisibility(customersListSalesInvoice, GeneralConstants.minTimeOut);
        waitUntilElementToBeClickable(customerOptSalesInvoice, GeneralConstants.minTimeOut);
        getWebElement(customerOptSalesInvoice).click();
        System.out.println("enter dues date  ");
        waitUntilElementVisibility(dueDateField, GeneralConstants.minTimeOut);
        getWebElement(dueDateField).sendKeys(dueDate);
        System.out.println("Scroll down to item field ");
        scrollToSpeceficElement(itemCodeField);
        //   Thread.sleep(6000);
        System.out.println(" select item  ");
        clickByActions(itemCodeField);
        waitUntilElementVisibility(itemCodeInputField, GeneralConstants.minTimeOut);
        getWebElement(itemCodeInputField).sendKeys("item");
        waitUntilElementToBeClickable(itemOpt, GeneralConstants.minTimeOut);
        getWebElement(itemOpt).click();
        System.out.println("unselect update stock opt");
        getWebElement(updateStockBtn).click();
        //Thread.sleep(6000);
        System.out.println("scroll up to save and submit btn ");
        scrollToSpeceficElement(saveAndSubmitBtn);

        System.out.println(" save and submit btn sales invoice ");
        getWebElement(saveAndSubmitBtn).click();
        //  Thread.sleep(10000);
        System.out.println("click on yes btn ");
        waitUntilElementToBeClickable(yesBtn, GeneralConstants.minTimeOut);
        getWebElement(yesBtn).click();

    }

    private By paidStatusField = By.xpath("//*[contains(@class,'progress-chart col-md-12')]//h5" +
            "|//*[contains(@class,'progress-chart col-md-12')]//p");
    private By customerNameField = By.xpath("//*[contains(text(),' اسم العميل')]/../following-sibling::div/a" +
            "|//*[@data-fieldname='customer']//*[@data-doctype='Customer']");
    private By netTotalField = By.xpath("(//*[contains(@title,'net_total_export')]//span)[3]" +
            "| (//*[@data-fieldname='total']//span[@dir='rtl'])[1]");

    private By grandTotalField = By.xpath("(//*[contains(@title,'grand_total_export')]//span)[3]" +
            "| //*[contains(text(),'المجموع الإجمالي')]/following-sibling::div/div/span");

    private By draftStatusField = By.xpath("(//*[contains(@class,'ellipsis title-text')]/following-sibling::span)[4]");
    private By badgeBar = By.xpath("(//*[contains(@class,'badge-bar ')])//span");

    public String getBadgeBar() {
        waitUntilElementVisibility(badgeBar, GeneralConstants.minTimeOut);
        System.out.println(" badg bar is " + getWebElement(badgeBar).getAttribute("textContent").replaceAll("[\\s\\u00A0\\u200B]+", ""));
        Allure.step(" badg bar is " + getWebElement(badgeBar).getAttribute("textContent").replaceAll("[\\s\\u00A0\\u200B]+", ""));
        return getWebElement(badgeBar).getAttribute("textContent").replaceAll("[\\s\\u00A0\\u200B]+", "");
    }

    public String getCreditNoteStatusAtDafater_5() {
        waitUntilElementToBePresent(IssueDateField, GeneralConstants.minTimeOut);
        if (tryToGetWebElementV(successStatusField) == GeneralConstants.SUCCESS) {
//           System.out.println("status of sales invoice  " + getWebElement(successStatusField).getText());
            return getWebElement(successStatusField).getText();
        } else {
//           System.out.println("status of sales invoice  is  " + getWebElement(draftStatusField).getText());
            return getWebElement(draftStatusField).getText();
        }
    }


    public String getGrandTotalValueAtCreditNote() {
        waitUntilElementToBePresent(IssueDateField, GeneralConstants.minTimeOut);
        System.out.println("grand total value of  credit note  " + getWebElement(grandTotalField).getText().replace("-", ""));
        waitUntilElementToBePresent(grandTotalField, GeneralConstants.minTimeOut);
        return getWebElement(grandTotalField).getText().replace("-", "");
    }

    public String getNetTotalValueAtCreditNote() {
        waitUntilElementToBePresent(IssueDateField, GeneralConstants.minTimeOut);
        System.out.println("net total value of credit note  " + getWebElement(netTotalField).getText().replace("-", ""));
        return getWebElement(netTotalField).getText().replace("-", "");
    }

    public String getCustomerNameAtCreditNote() {
        waitUntilElementToBePresent(IssueDateField, GeneralConstants.minTimeOut);
        System.out.println("customer name at credit note  " + getWebElement(customerNameField).getText());
        return getWebElement(customerNameField).getText();
    }

    public String getCreditNoteIssueDate() {
        waitUntilElementToBePresent(IssueDateField, GeneralConstants.minTimeOut);
        System.out.println("issue date of credit note  " + getWebElement(IssueDateField).getText());
        return getWebElement(IssueDateField).getText();
    }

    public String getCreditNotePaidStatus() {
        String paidStatus = "null";
        waitUntilElementToBePresent(IssueDateField, GeneralConstants.minTimeOut);

        if (tryToGetWebElementV(paidStatusField) == GeneralConstants.SUCCESS) {
            System.out.println("paid status of credit note  " + getWebElement(paidStatusField).getText());
            return getWebElement(paidStatusField).getText();
        } else {
            System.out.println("paid status of credit note  is  " + paidStatus + " and this meaning that this credit note  is draft and not have paid status ");
            return paidStatus;
        }

    }

    public String getCreditNoteStatus() {
        String draftStatus = "مسودة";
        waitUntilElementToBePresent(IssueDateField, GeneralConstants.minTimeOut);
        if (tryToGetWebElementV(successStatusField) == GeneralConstants.SUCCESS) {

            return getWebElement(successStatusField).getText();
        } else {
            return draftStatus;
        }
    }

    public void saveAndSubmitCreditNoteFromSalesInvoice() throws InterruptedException {

        waitUntilElementVisibility(saveAndSubmitBtnFromCreditNote, GeneralConstants.minTimeOut);
        System.out.println("scroll down to reason field ");
        scrollToSpeceficElement(reasonField);
//        getWebElement(reasonField).click();
        clickByActions(reasonField);
        System.out.println("choose reason for credit note ");
        reason = new Select(getWebElement(reasonField));
        reason.selectByIndex(1);
        scrollToSpeceficElement(saveAndSubmitBtn);
        System.out.println("save and submit creditNote ");
        getWebElement(saveAndSubmitBtnFromCreditNote).click();
        System.out.println("click on yes btn ");
        waitUntilElementToBeClickable(yesBtn_SO, GeneralConstants.minTimeOut);
        getWebElement(yesBtn_SO).click();
        System.out.println("click on close icon ");
        waitUntilElementToBeClickable(closeIcon, GeneralConstants.minTimeOut);
        getWebElement(closeIcon).click();
        waitUntilElementToBePresent(createBtn, GeneralConstants.minTimeOut);
    }

    public String getInvoiceNameInsideCreditNote(String expected) {
//        System.out.println("Verify the name of sales invoice  ");
        waitUntilElementToBePresent(createBtn, GeneralConstants.minTimeOut);
        System.out.println("actual text is  " + getWebElement(salesInvoiceNameInsideCreditNote).getAttribute("data-value") + "  and expected text is  " + expected);
        return getWebElement(salesInvoiceNameInsideCreditNote).getText();
    }
}
