import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class PlayListTests extends BaseTest {
    String playListName ;
    @BeforeClass
    void login(){
        loginCorrectCred();
        playListName ="NataliasPlaylist"+generateRandomName();
    }
    @Test(priority = 1)
    public void createPlaylist()  {
        clickOnCreatePlaylistBtn();
        clickOnCreateNewPlaylist();
        enterNewPlaylistName(playListName);
        checkShowSuccess();
    }
//    @Test(priority = 2)
//    public void renamePlaylist()  {
//        doubleClickOnPlaylist(playListName);
//        playListName ="Updated"+ playListName;
//        enterNewPlaylistName(playListName);
//        checkMessage();
//    }

    @Test(priority = 3)
    public void deletePlaylist()  {
        clickOnPlaylist(playListName);
        clickOnDeletePlaylistBtn();
        checkShowSuccess();
    }

    private void clickOnCreateNewPlaylist() {
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.cssSelector("[data-testid='playlist-context-menu-create-simple']")))
                .click();
    }

    private void clickOnCreatePlaylistBtn() {
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.cssSelector("[data-testid='sidebar-create-playlist-btn']")))
                .click();
    }

    private void enterNewPlaylistName(String newPlayListName) {
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
//       clear() does not work, element has an attribute of "required"
//       workaround is ctrl A (to select all) then backspace to clear then replace with new playlist name
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL,"A", Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlayListName);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    private void clickOnDeletePlaylistBtn() {
        WebElement deletePlaylistBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".del.btn-delete-playlist")));
        deletePlaylistBtn.click();
    }

    private void clickOnPlaylist() {
        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        playlist.click();
    }

    private void clickOnPlaylist(String playlistName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + playlistName + "')]"))).click();
    }
    private void doubleClickOnPlaylist(String playlistName) {
        WebElement playlistElement =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + playlistName + "')]")));
        actions.doubleClick(playlistElement).perform();
    }

    private void checkMessage() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        Assert.assertEquals("Updated playlist \""+playListName+".\"",notification.getText());
    }

}