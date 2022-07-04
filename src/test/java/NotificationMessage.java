import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class NotificationMessage extends BaseTest {
    @BeforeMethod
    public void navigate() {
       driver.get("http://the-internet.herokuapp.com/notification_message_rendered");
    }
    @Test
    public void notification() {
            driver.findElement(By.cssSelector(".example a")).click();
            Assert.assertTrue(driver.findElement(By.cssSelector(".flash")).getText().contains("Action successful"),"Action unsuccessful");

        }
    }


