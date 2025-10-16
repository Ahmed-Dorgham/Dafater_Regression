package Pages;

import GeneralConstants.GeneralConstants;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SetupWizardPage extends MainPage {
    private String dataMigrationTitle = "data migration";
    // private WebDriver driver ;

    public SetupWizardPage(WebDriver driver) {
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
    private By fullNameField = By.xpath("(//*[contains(@id,'full_name')])");
    private By companyNameField = By.xpath("(//*[contains(@id,'company_name')])");
    private By passwordField = By.xpath("(//*[contains(@id,'password')])");
    private By companyIdField = By.xpath("(//*[contains(@id,'company_id')])");
    private By taxIdField = By.xpath("(//*[contains(@id,'tax_id')])");
    private By cityField = By.xpath("(//*[contains(@id,'city')])");
    private By addressField = By.xpath("(//*[contains(@id,'address_line1')])");
    private By phoneField = By.xpath("(//*[contains(@id,'phone')])");
    public By countryField = By.xpath("(//*[contains(@id,'country')])");
    private By completeSetupBtn = By.xpath("(//*[contains(@class,'complete-btn btn btn-sm primary btn-primary')])");
    private By nextBtn = By.xpath("(//*[contains(@class,'next-btn btn btn-default btn-sm btn-primary')])");
    private By welcomeHeader = By.xpath("(//*[contains(@class,'title slide-title')])");
    private By idSelectMenu = By.xpath("(//*[contains(@id,'id_type')])");
    private By domainSelectMenu = By.xpath("(//*[contains(@id,'company_domain')])");
    private By addressTypeSelectMenu = By.xpath("(//*[contains(@id,'address_type')])");

    public void enterDefaultVMData() {
        Allure.step(" enter default data for VM ");
        waitUntilElementToBePresent(welcomeHeader, GeneralConstants.minTimeOut);
        waitUntilElementToBePresent(nextBtn, GeneralConstants.minTimeOut);
        getWebElement(nextBtn).click();
        waitUntilElementToBePresent(fullNameField, GeneralConstants.minTimeOut);

    }

    public void setupAccount() {
        Allure.step(" setup Account ");

        waitUntilElementToBePresent(fullNameField, GeneralConstants.minTimeOut);
        waitUntilElementToBePresent(passwordField, GeneralConstants.minTimeOut);
        getWebElement(passwordField).sendKeys("123456");
        getWebElement(nextBtn).click();

    }

    public void setupOrganization(String companyName, String companyId, String taxId, String city, String address, String phone) {
        Allure.step(" setup organization ");
        Allure.step(" enter company name");
        waitUntilElementToBePresent(companyNameField, GeneralConstants.minTimeOut);
        getWebElement(companyNameField).click();
        getWebElement(companyNameField).sendKeys(companyName);

        Allure.step(" select id type ");
        Select idSelect = new Select(getWebElement(idSelectMenu));
        getWebElement(idSelectMenu).click();
        idSelect.selectByValue("National ID");

        Allure.step(" select company domain ");
        Select domainSelect = new Select(getWebElement(domainSelectMenu));
        getWebElement(domainSelectMenu).click();
        domainSelect.selectByValue("Manufacturing");

        Allure.step(" enter company id ");
        waitUntilElementToBePresent(companyIdField, GeneralConstants.minTimeOut);
        getWebElement(companyIdField).click();
        getWebElement(companyIdField).sendKeys(companyId);

        Allure.step(" enter tax id ");
        waitUntilElementToBePresent(taxIdField, GeneralConstants.minTimeOut);
        getWebElement(taxIdField).click();
        getWebElement(taxIdField).sendKeys(taxId);

        Allure.step(" enter address info ");

        Allure.step(" enter city name ");
        waitUntilElementToBePresent(cityField, GeneralConstants.minTimeOut);
        getWebElement(cityField).click();
        getWebElement(cityField).sendKeys(city);

        Allure.step(" select address type");
        Select addressTypeSelect = new Select(getWebElement(addressTypeSelectMenu));
        getWebElement(addressTypeSelectMenu).click();
        addressTypeSelect.selectByValue("Billing");


        Allure.step(" enter address  ");
        waitUntilElementToBePresent(addressField, GeneralConstants.minTimeOut);
        getWebElement(addressField).click();
        getWebElement(addressField).sendKeys(address);


        Allure.step(" enter phone  ");
        waitUntilElementToBePresent(phoneField, GeneralConstants.minTimeOut);
        getWebElement(phoneField).click();
        getWebElement(phoneField).sendKeys(phone);

        Allure.step(" click on complete setup btn");
        waitUntilElementToBePresent(completeSetupBtn, GeneralConstants.minTimeOut);
        getWebElement(completeSetupBtn).click();
    }

}
