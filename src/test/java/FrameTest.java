import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FrameTest extends BaseTest{
    @BeforeMethod
    public void navigate(){
        driver.get("http://the-internet.herokuapp.com/frames");
    }
    @Test
    public void checkFrameText(){
        driver.findElement(By.xpath("//a[@href='/iframe']")).click();
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame("mce_0_ifr");
        String frameText = driver.findElement(By.cssSelector("#tinymce p")).getText();
        Assert.assertEquals(frameText,"Your content goes here.");
        driver.switchTo().activeElement();
    }
}
