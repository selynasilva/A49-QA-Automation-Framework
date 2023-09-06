package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;
import pages.BasePage;

import java.net.MalformedURLException;
import java.net.URI;

public class BaseTest {
    public WebDriver driver ;
    public String url = "https://qa.koel.app/";


    @BeforeSuite
    public void setupSuit() throws MalformedURLException {
        String browser = System.getProperty("browser");
        driver=setupBrowser(browser);
    }
    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
    WebDriver setupBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        //To start the grid server run this in command line (go to download locations first)
        //java -jar selenium-server-4.12.0.jar standalone --selenium-manager true
        String gridURL = "http://192.168.1.105:4444";
        switch(browser) {
            case "firefox":
                return setupFirefox();
            case "chrome":
                return setupChrome();
            case "safari":
                return setupSafari();
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            default:
                return setupChrome();
        }
    }
    public WebDriver setupFirefox(){
        WebDriverManager.firefoxdriver().setup();
        driver =new FirefoxDriver();
        return driver;
    }
    public WebDriver setupSafari(){
        WebDriverManager.safaridriver().setup();
        driver =new SafariDriver();
        return driver;
    }
    public WebDriver setupChrome(){
        WebDriverManager.chromedriver().setup();
        //Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        return driver;
    }
}
