package Pages;

import GeneralConstants.GeneralConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends MainPage {
    //private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By userNameField = By.xpath("//input[@id='login_email'] | //input[@id='login_id']");
    private By passwordField = By.xpath("//input[@id='login_password'] | //input[@id='pass']");
    private By loginBtn = By.id("login_btn");
    By overlay = By.xpath("//*[contains(@class,'freeze-message-container')]");

    public HomePage loginWithValidData(String userName, String password) {
        if (tryToGetWebElement(userNameField)==GeneralConstants.SUCCESS)
        {
            waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
            waitUntilElementToBePresent(userNameField, GeneralConstants.minTimeOut);
//        getWebElement(userNameField).click();
            clickByActions(userNameField);
            getWebElement(userNameField).sendKeys(userName);
            getWebElement(passwordField).sendKeys(password);
            getWebElement(loginBtn).click();
        }

        return new HomePage(driver);
    }

    public void switchToDafater_5(String loginPageLink_5) throws InterruptedException {
        waitUntilOverlayDisappear(overlay, GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(userNameField, GeneralConstants.minTimeOut);
        driver.get(loginPageLink_5);


        System.out.println("switch to Dafater 5 ");
    }
}
