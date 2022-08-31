package Lesson6;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;

public class LoginPage extends AbstractPage {

    @FindBy(xpath = "//*[@class='login']")
    private WebElement loginBtn;

    @FindBy(id = "Login")
    private WebElement login;

    @FindBy(id = "Password")
    private WebElement password;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submitBtn;

    @FindBy(id = "userCabinetBtn")
    private WebElement userCabinetBtn;

    @FindBy(xpath = "//*[@class='dd-menu__Logout']")
    private WebElement logOutBtn;

    @FindBy(xpath = "//div[@id='authInfo']")
    private WebElement authInfo;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginIn(String login, String password) {
        goToLoginPage();
        Actions loginIn = new Actions(getDriver());
        loginIn
                .sendKeys(this.login, login)
                .click(this.password)
                .sendKeys(password)
                .click(this.submitBtn)
                .build()
                .perform();
    }

    public void goToLoginPage() {
        loginBtn.click();
    }

    public void logOut() {
        Actions logOut = new Actions(getDriver());
        logOut
                .click(this.userCabinetBtn)
                .pause(1000L)
                .click(this.logOutBtn)
                .build()
                .perform();
    }

    public WebElement getAuthInfo() {
        return authInfo;
    }
}
