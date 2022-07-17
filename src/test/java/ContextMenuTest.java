import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContextMenuTest extends BaseTest{
    @BeforeMethod
    public void navigate(){
        driver.get("http://the-internet.herokuapp.com/context_menu");
    }

    @Test
    public void rightClickTest(){
        WebElement contextMenuField=driver.findElement(By.id("hot-spot"));
        Actions actions=new Actions(driver);
        actions.contextClick(contextMenuField).perform();
        Alert alert=driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "You selected a context menu", "Failed to get alert text");
        alert.accept();
    }

}
