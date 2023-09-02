package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "li a.songs")
    WebElement allSongsBtn;
    @FindBy (css = "[data-testid='sound-bar-play']")
    WebElement soundBar;
    @FindBy (css = "[data-testid='play-btn']")
    WebElement playBtn;
    @FindBy (css = ".side.player-controls" )
    WebElement controlPanel;

    public HomePage clickAllSongs() {
        wait.until(ExpectedConditions.elementToBeClickable(allSongsBtn)).click();
        return this;
    }

    public HomePage checkSongIsPlaying() {
        wait.until(ExpectedConditions.visibilityOf(soundBar));
        Assert.assertTrue(soundBar.isDisplayed());
        return this;
    }

    public HomePage checkIfPlayBtnIsVisible() {
        wait.until(ExpectedConditions.visibilityOf(playBtn));
        Assert.assertTrue(playBtn.isDisplayed());
        return this;
    }

    public HomePage mouseMoveToPlayBtn() {
        wait.until(ExpectedConditions.visibilityOf(controlPanel));
        actions.moveToElement(controlPanel).click(controlPanel).perform();
        return this;
    }

}
