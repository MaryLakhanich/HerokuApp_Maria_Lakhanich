import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.List;

public class AddRemoveTest extends BaseTest {
    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
    }
        @Test
    public void addRemoveButtons() {
        WebElement addButton = driver.findElement(By.xpath("//button[text()='Add Element']"));
        List<WebElement> deleteButtons = driver.findElements(By.xpath("//button[text()='Delete']"));
        Assert.assertTrue(deleteButtons.isEmpty(), "Delete button is on page");
        addButton.click();
        addButton.click();
        deleteButtons = driver.findElements(By.xpath("//button[text()='Delete']")); //2
        Assert.assertEquals(deleteButtons.size(),2);
        deleteButtons.get(0).click();
        deleteButtons = driver.findElements(By.xpath("//button[text()='Delete']")); //1
        Assert.assertEquals(deleteButtons.size(),1);

    }
}
