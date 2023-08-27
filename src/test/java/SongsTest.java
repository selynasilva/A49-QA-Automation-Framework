import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.print.DocFlavor;

public class SongsTest extends BaseTest {

    @Test()
    public void playSongContextClick() throws InterruptedException {
        loginCorrectCred();
        clickOnAllSongs();
        contextClickOnSongByName("Reactor");
        clickPlayInContextMenu();
        checkIfSongPlaying();
    }
    @Test()
    public void playSongHoverPlay() throws InterruptedException {
        loginCorrectCred();
//        hoverPlay();
        checkPlayBtnVisible();
    }

    private void checkPlayBtnVisible() throws InterruptedException {
        WebElement play = wait.
                until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='play-btn']")));
        Thread.sleep(3000);
        Assert.assertTrue(play.isDisplayed());
    }

    private void hoverPlay()  {
        WebElement playerControlsPanel = wait.
                until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".side.player-controls")));
        actions.moveToElement(playerControlsPanel).perform();
    }

    private void clickOnAllSongs() {
        WebElement allSongsMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs")));
        allSongsMenu.click();
    }

    private void contextClickOnSongByName(String songName) throws InterruptedException {
        WebElement song = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='songsWrapper']//td[text()='" + songName + "']")));
        actions.contextClick(song).perform();
        Thread.sleep(3000);
    }
    private void clickPlayInContextMenu() {
        wait.until(ExpectedConditions.
                        visibilityOfElementLocated(By.cssSelector(".playback")))
                .click();
    }
    private void checkIfSongPlaying() {
        WebElement soundBarVisualizer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid = 'sound-bar-play']")));
        Assert.assertTrue( soundBarVisualizer.isDisplayed());
    }

//    Locators
    //css all songs li a.songs
    //xpath  //section[@id='songsWrapper']//td[text()='Reactor']
    //css .playback
}