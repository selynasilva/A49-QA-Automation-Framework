package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ActionsTest extends BaseTest {
    @BeforeClass
    void login(){
        loginPage.loginCorrectCred();
    }
    @Test
    void contextClickOnSong()  {
        homePage.clickAllSongs();
        homePage.contextClickSongByName("Reactor");
        homePage.clickPlay();
        homePage.checkSongIsPlaying();
    }

    @Test
    void mouseHoverTest() {
        homePage.clickAllSongs();
        homePage.mouseMoveToPlayBtn();
        homePage.checkIfPlayBtnIsVisible();
    }
//    COMMENTED OUT AS THAT PLAYLIST NEEDS TO BE CREATED BEFORE THE TEST
//    @Test
//    void checkPlaylistSongs()  {
//        loginPage.loginCorrectCred();
//        homePage.clickOnPlaylist("Play List With Songs");
//        playlistPage.checkNumberOfSongsInPlaylist();
//    }
}