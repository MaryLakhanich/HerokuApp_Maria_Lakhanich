import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTest extends BaseTest{
    @BeforeMethod
    public void navigate(){
        driver.get("http://the-internet.herokuapp.com/upload");
    }
    @Test
    public void fileUpload(){
        driver.findElement(By.id("file-upload")).sendKeys(System.getProperty("user.dir")+"/src/main/resources/sea.jpg");
        driver.findElement(By.id("file-submit")).click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.textToBe(By.tagName("h3"), "File Uploaded!"));
        Assert.assertEquals(driver.findElement(By.id("uploaded-files")).getText(),"sea.jpg");
    }
}
