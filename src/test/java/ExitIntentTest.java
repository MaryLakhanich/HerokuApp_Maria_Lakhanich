import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;

public class ExitIntentTest extends BaseTest {
    @BeforeMethod
    public void navigate(){
        driver.get("http://the-internet.herokuapp.com/exit_intent");
    }
    @Test
    public void mouseMoveTest() throws AWTException {
        Robot robot=new Robot();
        robot.mouseMove(1300,10);
        String modalWindow = driver.getWindowHandle();
        driver.switchTo().window(modalWindow);
        Assert.assertEquals(driver.findElement(By.cssSelector(".modal-body p")).getText(),"It's commonly used to encourage a user to take an action (e.g., give their e-mail address to sign up for something).");
        driver.findElement(By.cssSelector(".modal-footer p")).click();
    }
}
