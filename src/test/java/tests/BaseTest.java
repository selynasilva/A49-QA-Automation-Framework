package tests;

import com.github.hemanthsridhar.CSVUtils;
import com.github.hemanthsridhar.lib.ExtUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import pages.PlaylistPage;

import java.time.Duration;
import java.util.UUID;

public class BaseTest {
    public WebDriver driver ;
    public static Actions actions ;
    public String url = "https://qa.koel.app/";
    public WebDriverWait wait;
    BasePage basePage;
    LoginPage loginPage;
    HomePage homePage;
    PlaylistPage playlistPage;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    public void launchBrowser() {
        //Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        //instantiate Explicit wait
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        actions = new Actions(driver);
        basePage = new BasePage(driver, wait,actions);
        basePage.navigateToPage(url);
        loginPage = new LoginPage(driver,wait, actions);
        homePage = new HomePage(driver, wait, actions);
        playlistPage = new PlaylistPage(driver,wait,actions);
    }

    @AfterClass
    public void closeBrowser() {
        basePage.quitBrowser();
    }
}
