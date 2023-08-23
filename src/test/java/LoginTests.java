import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    
    @Test
    public void loginInvalidCredentials(String username,String password) throws InterruptedException {
        navigateToPage();
        provideEmail(username);
        providePassword(password);
        clickSubmit();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), url); //https://qa.koel.app/
    }

}