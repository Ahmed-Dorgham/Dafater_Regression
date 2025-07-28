package Pages;

import GeneralConstants.GeneralConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends MainPage {
    //private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By userNameField = By.xpath("//input[@id='login_email']");
    private By passwordField = By.id("login_password");
    private By loginBtn = By.id("login_btn");
    By overlay = By.xpath("//*[contains(@class,'freeze-message-container')]");
    public HomePage loginWithValidData(String userName, String password) {
        waitUntilOverlayDisappear(overlay,GeneralConstants.freezeTimeOut);
        waitUntilElementToBePresent(userNameField, GeneralConstants.minTimeOut);
        getWebElement(userNameField).click();
        getWebElement( userNameField).sendKeys(userName);
        getWebElement( passwordField).sendKeys(password);
        getWebElement(loginBtn).click();
        return new HomePage(driver);
    }
}
