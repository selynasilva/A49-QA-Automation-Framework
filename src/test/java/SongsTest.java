import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SongsTest extends BaseTest {
    
    @Test()
    public void playSong () throws InterruptedException {
        loginCorrectCred();
        clickSubmit();
        clickPlayNextBtn();
        checkSongIsPlaying();
    }

    private void checkSongIsPlaying() {
        WebElement soundBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='sound-bar-play']")));
        Assert.assertTrue(soundBar.isDisplayed());
    }

    private void clickPlayNextBtn() {
       clickOnElement(By.cssSelector("div.side.player-controls"));
       clickOnElement(By.cssSelector("[data-testid='play-next-btn']"));
       clickOnElement(By.cssSelector("[data-testid='play-btn']"));
    }

}