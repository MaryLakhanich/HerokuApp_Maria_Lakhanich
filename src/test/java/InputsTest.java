import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InputsTest extends BaseTest {
    @BeforeMethod
    public void navigate() {
        super.setUp();
        driver.get("http://the-internet.herokuapp.com/inputs");
    }
    @AfterMethod
    public void quitDriver () {super.exit();
    }
    @Test
    public void input () {
        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_UP);
        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_UP);
        Assert.assertEquals(driver.findElement(By.tagName("input")).getAttribute("value"), "2");
        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_DOWN);
        Assert.assertEquals(driver.findElement(By.tagName("input")).getAttribute("value"), "-1");

        //ввод букв с клавиатуры
        driver.navigate().refresh();
        driver.findElement(By.tagName("input")).sendKeys("abc");
        Assert.assertEquals(driver.findElement(By.tagName("input")).getAttribute("value"), "");

        //ввод цифр с клавиатуры
        driver.navigate().refresh();
        driver.findElement(By.tagName("input")).sendKeys("123");
        Assert.assertEquals(driver.findElement(By.tagName("input")).getAttribute("value"), "123");




    }

}
