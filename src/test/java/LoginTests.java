import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    
    @Test(dataProvider = "csvData")
    public void loginInvalidCredentials(String email, String password) throws InterruptedException {
        navigateToPage();
        provideEmail(email);
        providePassword(password);
        clickSubmit();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), url); //https://qa.koel.app/
    }

}