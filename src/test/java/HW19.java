import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HW19 extends BaseTest {
    
    @Test
    public void deletePlaylist() throws InterruptedException {
        loginCorrectCred();
        clickSubmit();
        Thread.sleep(5000);
        clickOnPlaylist();
        Thread.sleep(1000);
        clickOnDeletePlaylistBtn();
        clickOnOk();
        Thread.sleep(1000);
        checkShowSuccess();
    }

    private void clickOnOk() {
        WebElement okBtn = driver.findElement(By.cssSelector(".ok"));
        okBtn.click();
    }

    private void clickOnDeletePlaylistBtn() {
        WebElement deletePlaylistBtn = driver.findElement(By.cssSelector(".del.btn-delete-playlist"));
        deletePlaylistBtn.click();
    }

    private void clickOnPlaylist() {
        WebElement playlist = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        playlist.click();
    }
    private void checkShowSuccess() {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
       Assert.assertTrue(notification.isDisplayed());
    }

}