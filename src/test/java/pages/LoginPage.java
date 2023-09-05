package pages;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage extends BasePage {
  WebDriverWait wait;
    public LoginPage(WebDriver driver) {
        super(driver);
       wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    @FindBy (css ="input[type='email']")
    WebElement emailField;
    @FindBy (css ="input[type='password']")
    WebElement passwordField;
    @FindBy (css ="[type='submit']")
    WebElement submitBtn;

    public void loginCorrectCred() {
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
    }


    public LoginPage provideEmail(String email) {
       wait.until(ExpectedConditions.elementToBeClickable(emailField)).clear();
       emailField.sendKeys(email);
       return this;
    }

    public LoginPage providePassword(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(passwordField)).clear();
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
        return this;
    }
}
