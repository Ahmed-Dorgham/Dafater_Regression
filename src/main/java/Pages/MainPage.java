package Pages;

import GeneralConstants.GeneralConstants;
import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;

public class MainPage extends GeneralConstants {
    public static WebDriver driver;
    public WebDriverWait wait;
    //    JavascriptExecutor js;
    public Actions actions;
    public JavascriptExecutor js;
    By filterTab = By.xpath("//*[contains(@class,'filter-icon active')]" +
            "|//*[contains(@class,'filter-icon')]//*[contains(@href,'#es-line-filter')]");
    By filterLabelField = By.xpath("//*[contains(@class,'list_filter row')]//*[contains(@role,'combobox')]");
    By filterLabelField_2 = By.xpath("(//*[contains(@class,'list_filter row')]//*[contains(@role,'combobox')])[2]");
    By filterLabelField_3 = By.xpath("(//*[contains(@class,'list_filter row')]//*[contains(@role,'combobox')])[3]");
    By selectedFilterLabel = By.xpath("//*[contains(@class,'filter-field-select')]/p");
    By selectedFilterLabel_2 = By.xpath("(//*[contains(@class,'filter-field-select')]/p)[2]");
    By selectedFilterLabel_3 = By.xpath("(//*[contains(@class,'filter-field-select')]/p)[3]");
    By addFilter = By.xpath("//*[contains(text(),'إضافة فلتر')]");
    public By totalAmountValue = By.xpath("//*[contains(@title,'الفاتورة')]//span//span");
    By filterValField = By.xpath("//*[@class='filter-field']//select");
    By filterValField_2 = By.xpath("(//*[@class='filter-field']//select)[2]");
    By filterValField_3 = By.xpath("(//*[@class='filter-field']//select)[3]");
    By applyFilterBtn = By.xpath("//*[@class='btn btn-primary btn-xs apply-filters']");
    public By listCountOffset = By.xpath("(//*[contains(@class,'rows-offset')])");
    public By nextIcon = By.xpath("(//*[contains(@class,'next')])//*[contains(@class,'fas fa-chevron-left')]");

    public By applyBtn_2 = By.xpath("((//div[contains(@class,'filter-actions btn-group col-sm-12')])//span[contains(text(),'تطبيق')])[2]");
    public By applyBtn_1 = By.xpath("((//div[contains(@class,'filter-actions btn-group col-sm-12')])//span[contains(text(),'تطبيق')])[1]");
    public List<WebElement> totalAmountValues;
    public List<WebElement> totalOutstandingAmountValues;
    private By filterIcon = By.xpath("//*[contains(@class,'fal fa-filter')]");
    private By idField = By.xpath("(//*[contains(@class,'fieldname_select_area')]//button[contains(@title,'معرف')]//span)[1]");
    private By valueField = By.xpath("//div[contains(@class,'col-sm-4 filter_field pull-left form-column')]//button//span[contains(text(),'ختر')]");
    private By idInputField = By.xpath("(//*[contains(@class,'fieldname_select_area')]//button[contains(@title,'معرف')])/following-sibling::div//input");
    private By chosenId_2 = By.xpath("(//ul[contains(@class,'dropdown-menu inner scroll-styler')]//span[contains(text(),'حالة المستندات')])[2]");
    private By chosenId_1 = By.xpath("(//ul[contains(@class,'dropdown-menu inner scroll-styler')]//span[contains(text(),'حالة المستندات')])[1]");
    private By submittedStatus_2 = By.xpath("(//span[contains(text(),'معتمد')])[2]");
    private By submittedStatus_1 = By.xpath("(//span[contains(text(),'معتمد')])[1]");
    private By draftLabel = By.xpath("(//h3[contains(text(),'مسودة')])" +
            "| (//div[contains(text(),'مسودة')])");
    By overlay = By.xpath("//*[contains(@class,'freeze-message-container')]");
    public By totalOutstandingAmountValue = By.xpath("//*[contains(@title,'المعلق')]//span//span");
//    Random random = new Random();
//    public int randomNumber = random.nextInt(1000000000);

    public String itemPrice = "100";

    public void filterWithSubmittedStatus_2() throws InterruptedException {
        waitUntilElementToBePresent(filterIcon, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        waitUntilElementToBeClickable(filterIcon, GeneralConstants.minTimeOut);
        getWebElement(filterIcon).click();
        getWebElement(filterIcon).click();
        waitUntilElementVisibility(idField, GeneralConstants.minTimeOut);
        getWebElement(idField).click();
        waitUntilElementVisibility(idInputField, GeneralConstants.minTimeOut);
        getWebElement(idInputField).sendKeys("حالة");
        waitUntilElementVisibility(chosenId_2, GeneralConstants.minTimeOut);
        getWebElement(chosenId_2).click();
        waitUntilElementVisibility(valueField, GeneralConstants.minTimeOut);
        getWebElement(valueField).click();
        waitUntilElementVisibility(submittedStatus_2, GeneralConstants.minTimeOut);
        getWebElement(submittedStatus_2).click();
        getWebElement(applyBtn_2).click();
        waitUntilOverlayDisappear(overlay, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
    }

    public void filterWithSubmittedStatus() throws InterruptedException {
        waitUntilElementToBePresent(filterIcon, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
        waitUntilElementToBeClickable(filterIcon, GeneralConstants.minTimeOut);
        getWebElement(filterIcon).click();
        getWebElement(filterIcon).click();
        waitUntilElementVisibility(idField, GeneralConstants.minTimeOut);
        getWebElement(idField).click();
        waitUntilElementVisibility(idInputField, GeneralConstants.minTimeOut);
        getWebElement(idInputField).sendKeys("حالة");
        waitUntilElementVisibility(chosenId_1, GeneralConstants.minTimeOut);
        getWebElement(chosenId_1).click();
        waitUntilElementVisibility(valueField, GeneralConstants.minTimeOut);
        getWebElement(valueField).click();
        waitUntilElementVisibility(submittedStatus_1, GeneralConstants.minTimeOut);
        getWebElement(submittedStatus_1).click();
        getWebElement(applyBtn_1).click();
        waitUntilOverlayDisappear(overlay, GeneralConstants.minTimeOut);
        Thread.sleep(threadTimeOut);
    }

    public void filterDocTypes(String id, String value) throws InterruptedException {

        Select select;
        waitUntilElementVisibility(filterTab, GeneralConstants.minTimeOut);
        getWebElement(filterTab).click();

        waitUntilElementVisibility(filterLabelField, GeneralConstants.minTimeOut);
        getWebElement(filterLabelField).click();
        getWebElement(filterLabelField).sendKeys(id);
        waitUntilElementVisibility(selectedFilterLabel, GeneralConstants.minTimeOut);
        getWebElement(selectedFilterLabel).click();
        waitUntilElementVisibility(filterValField, GeneralConstants.minTimeOut);
        getWebElement(filterValField).click();
        select = new Select(getWebElement(filterValField));
        select.selectByValue(value);
        getWebElement(applyFilterBtn).click();
        Thread.sleep(threadTimeOut);
    }

    public void filterDocTypesWithSecondFilter(String id, String value) throws InterruptedException {

        Select select;
        waitUntilElementVisibility(filterTab, GeneralConstants.minTimeOut);
        getWebElement(filterTab).click();
        waitUntilElementVisibility(addFilter, GeneralConstants.minTimeOut);
        getWebElement(addFilter).click();
//        Thread.sleep(threadTimeOut);
        waitUntilElementVisibility(filterLabelField_2, GeneralConstants.minTimeOut);
        getWebElement(filterLabelField_2).click();
        getWebElement(filterLabelField_2).sendKeys(id);
        waitUntilElementVisibility(selectedFilterLabel_2, GeneralConstants.minTimeOut);
        getWebElement(selectedFilterLabel_2).click();

        waitUntilElementVisibility(filterValField_2, GeneralConstants.minTimeOut);
        getWebElement(filterValField_2).click();
//        waitUntilElementVisibility(filterValField_2,GeneralConstants.minTimeOut);
        select = new Select(getWebElement(filterValField_2));

        select.selectByValue(value);
        getWebElement(applyFilterBtn).click();
        Thread.sleep(threadTimeOut);
    }

    public void filterDocTypesWithSecondFilterByVisibleText(String id, String value) throws InterruptedException {

        Select select;
        waitUntilElementVisibility(filterTab, GeneralConstants.minTimeOut);
        getWebElement(filterTab).click();
        waitUntilElementVisibility(addFilter, GeneralConstants.minTimeOut);
        getWebElement(addFilter).click();
//        Thread.sleep(threadTimeOut);
        if (tryToGetWebElementV(filterLabelField_2) == GeneralConstants.FAILED) {
            getWebElement(addFilter).click();
        }

        getWebElement(filterLabelField_2).click();
        getWebElement(filterLabelField_2).sendKeys(id);
        waitUntilElementVisibility(selectedFilterLabel_2, GeneralConstants.minTimeOut);
        getWebElement(selectedFilterLabel_2).click();

        waitUntilElementVisibility(filterValField_2, GeneralConstants.minTimeOut);
        getWebElement(filterValField_2).click();
//        waitUntilElementVisibility(filterValField_2,GeneralConstants.minTimeOut);
        select = new Select(getWebElement(filterValField_2));

        select.selectByVisibleText(value);
        getWebElement(applyFilterBtn).click();
        Thread.sleep(threadTimeOut);
    }

    public void filterDocTypesWithThirdFilter(String id, String value) throws InterruptedException {

        Select select;
        waitUntilElementVisibility(filterTab, GeneralConstants.minTimeOut);
        getWebElement(filterTab).click();
        waitUntilElementVisibility(addFilter, GeneralConstants.minTimeOut);
        getWebElement(addFilter).click();
//        Thread.sleep(threadTimeOut);
        waitUntilElementVisibility(filterLabelField_3, GeneralConstants.minTimeOut);
        getWebElement(filterLabelField_3).click();
        getWebElement(filterLabelField_3).sendKeys(id);
        waitUntilElementVisibility(selectedFilterLabel_3, GeneralConstants.minTimeOut);
        getWebElement(selectedFilterLabel_3).click();
        waitUntilElementVisibility(filterValField_3, GeneralConstants.minTimeOut);
        getWebElement(filterValField_3).click();
        select = new Select(getWebElement(filterValField_3));
        select.selectByVisibleText(value);
        getWebElement(applyFilterBtn).click();
        Thread.sleep(threadTimeOut);
    }

    public void waitUntilElementVisibility(By by, int duration) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public String convertToStringFormat(double number) {
        String formatted;
        if (number == 0) {
            formatted = "0";
        } else if (number >= 1_000_000) {
            formatted = String.format("%.2fM", number / 1_000_000);
        } else if (number >= 1_000) {
            formatted = String.format("%.2fK", number / 1_000);
        } else {
            formatted = String.valueOf((int) Math.round(number));  // <-- NO DECIMALS
        }
        System.out.println(formatted);
        return formatted;
    }

    public void waitTime(int duration) {
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
    }

    public void waitUntilElementToBePresent(By by, int duration) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitUntilElementNotHaveSpecificText(By by, String text) throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(GeneralConstants.freezeTimeOut));
        wait.until(ExpectedConditions.not(textToBePresentInElementLocated(by, text)));
        Thread.sleep(2000);
    }

    public void waitUntilElementNotToBeVisible(By by, int duration) {

        wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void waitUntilElementToBeClickable(By by, int duration) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public WebElement getWebElement(By by) {
        // System.out.println(driver.findElement(by).getText() + " >>>> element is displayed");
        return driver.findElement(by);
    }

    public List<WebElement> getListOfWebElements(By by) {
        // System.out.println(driver.findElement(by).getText() + " >>>> element is displayed");
        return driver.findElements(by);
    }

    public String tryToGetWebElementV(By by) {

        try {
            waitUntilElementVisibility(by, GeneralConstants.tryTimeOut);
            return GeneralConstants.SUCCESS;
        } catch (Exception e) {
            return GeneralConstants.FAILED;
        }

    }

    public String tryToGetWebElementC(By by) {
        // System.out.println(driver.findElement(by).getText() + " >>>> element is displayed");
        try {
            waitUntilElementToBeClickable(by, GeneralConstants.tryTimeOut);
            return GeneralConstants.SUCCESS;
        } catch (Exception e) {
            return GeneralConstants.FAILED;
        }

    }

    public String tryToGetWebElementP(By by) {
        // System.out.println(driver.findElement(by).getText() + " >>>> element is displayed");
        try {
            waitUntilElementToBePresent(by, GeneralConstants.tryTimeOut);
            return GeneralConstants.SUCCESS;
        } catch (Exception e) {
            return GeneralConstants.FAILED;
        }

    }

    public String tryToGetWebElementVLongWait(By by) {
        // System.out.println(driver.findElement(by).getText() + " >>>> element is displayed");
        try {
            waitUntilElementToBePresent(by, GeneralConstants.minTimeOut);
            return GeneralConstants.SUCCESS;
        } catch (Exception e) {
            return GeneralConstants.FAILED;
        }

    }

    public void clickByActions(By by) {
        actions = new Actions(driver);
        actions.click(getWebElement(by)).build().perform();

    }

    public void clickByJs(WebElement element) {
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public void waitUntilOverlayDisappear(By by, int duration) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        } catch (Exception e) {

        }

    }


    public String readDataFromPropertiesFile(String filePath, String Key) throws IOException {
        File file = new File(filePath);
        FileInputStream inputStream = new FileInputStream(file);
        Properties prop = new Properties();
        prop.load(inputStream);
        return prop.getProperty(Key);
    }

    public void scrollToSpeceficElement(By by) {
        actions = new Actions(driver);
        actions.moveToElement(getWebElement(by)).perform();
        waitUntilElementVisibility(by, GeneralConstants.minTimeOut);
    }

    public void scrollToBottom(WebDriver driver) {
        actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();
    }

    public void scrollToBottom_2(WebDriver driver) {
        WebElement body = driver.findElement(By.tagName("body"));
        body.sendKeys(Keys.END);
    }

    public String verifyTextContains(By by, String expected) {
        if (getWebElement(by).getText().contains(expected)) {
            Allure.step("actual text is " + getWebElement(by).getText() + "and expected test is " + expected);
            return GeneralConstants.SUCCESS;
        } else
            return GeneralConstants.FAILED;
    }
}
