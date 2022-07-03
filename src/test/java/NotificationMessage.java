import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Objects;

public class NotificationMessage extends BaseTest {
    @BeforeMethod
    public void navigate() {
        super.setUp();
        driver.get("http://the-internet.herokuapp.com/notification_message_rendered");
    }

    @AfterMethod
    public void quitDriver() {
        super.exit();
    }

    @Test
    public void notification() {
        boolean correctMessage = false;
        for (int i = 0; i < 5; i++) {
            driver.findElement(By.cssSelector(".example a")).click();
            String textOfNotification = driver.findElement(By.cssSelector(".flash")).getText();
            if (textOfNotification.contains("Action successful")) {
                correctMessage = true;
                System.out.println("Action successful");
            } else {
                correctMessage = false;
                System.out.println("Action unsuccessful");
                break;
            }
        }
    }
}

