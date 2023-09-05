package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class InvalidLoginTests extends BaseTest{
    LoginPage loginPage;
    @BeforeMethod
    void setup(){
        loginPage= new LoginPage(getThreadDriver());
        getThreadDriver().get(url);
    }
    @Test
    public void invalidPassword() throws InterruptedException {
        loginPage.provideEmail("incorrectEmail").providePassword("incotrerctPwd").clickSubmit();
        Thread.sleep(3000);
    }
    @Test
    public void emptyPassword(){
        loginPage.provideEmail("demo@class.com").providePassword("").clickSubmit();
    }
    @Test
    public void emptyEmailPassword(){
        loginPage.provideEmail("").providePassword("").clickSubmit();
    }
}
