import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragAndDropTest extends BaseTest{
    @BeforeMethod
    public void navigate(){
        driver.get("http://the-internet.herokuapp.com/drag_and_drop");
    }
    @Test
    public void dragAndDropTest(){
        WebElement from=driver.findElement(By.id("column-a"));
        WebElement to=driver.findElement(By.id("column-b"));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(from,to).build().perform();
    }
}
