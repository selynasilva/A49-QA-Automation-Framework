import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ActionsTest extends BaseTest {

    @Test
    void contextClickOnSong() throws InterruptedException {
        loginCorrectCred();
        clickAllSongs();
        contextClickSongByName("Reactor");
        clickPlay();
        checkSongIsPlaying();
    }


    @Test
    void mouseHoverTest() throws InterruptedException {
        loginCorrectCred();
        clickAllSongs();
        mouseMoveToPlayBtn();
        checkIfPlayBtnIsVisible();
    }
    @Test
    void checkPlaylistSongs() throws InterruptedException {
        loginCorrectCred();
        clickOnPlaylist("Play List With Songs");
        checkNumberOfSongsInPlaylist();
    }

    private void checkNumberOfSongsInPlaylist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".song-list-wrap.main-scroll-wrap.playlist td.title")));
        List<WebElement> allSongsInPlaylist =driver.findElements(By.cssSelector(".song-list-wrap.main-scroll-wrap.playlist td.title"));
       //This block is for visibility - printing all the songs
        for (WebElement element: allSongsInPlaylist)
        {
            System.out.println(element.getText());
        }
        Assert.assertEquals(allSongsInPlaylist.size(),3);
    }

    private void checkIfPlayBtnIsVisible() {
      WebElement playBtn =   wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='play-btn']")));
      Assert.assertTrue(playBtn.isDisplayed());
    }

    private void mouseMoveToPlayBtn() throws InterruptedException {
        WebElement playPanel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".side.player-controls")));
        actions.moveToElement(playPanel).perform();
        Thread.sleep(2000);
    }

    private void checkSongIsPlaying() {
        WebElement soundBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='sound-bar-play']")));
        Assert.assertTrue(soundBar.isDisplayed());
    }

    private void clickPlay() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playback"))).click();
    }

    private void contextClickSongByName(String songName) throws InterruptedException {
        WebElement song =wait.until(ExpectedConditions.
                elementToBeClickable(By.xpath("//section[@id='songsWrapper']//td[text()='"+songName+"']")));
        actions.contextClick(song).perform();
    }

    private void clickAllSongs() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li a.songs"))).click();
    }

//    Locators
    //css all songs li a.songs --.menu .songs
    //xpath  //section[@id='songsWrapper']//td[text()='Reactor']
    //css .playback
}