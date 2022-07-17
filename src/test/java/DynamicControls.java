import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DynamicControls extends BaseTest{
    @BeforeMethod
    public void navigate(){
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
    }
    private By checkBox = new By.ByCssSelector("[type='checkbox']");
    public boolean isCheckBoxPresent() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        boolean isPresent = !driver.findElements(checkBox).isEmpty();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return isPresent;
    }

    @Test
    public void checkBoxAndInputTest(){
        driver.findElement(checkBox).click();// часть по проверке чек-бокса
        driver.findElement(By.cssSelector("[autocomplete='off']")).click();
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p[id=message]")));
        Assert.assertFalse(isCheckBoxPresent(),"There's still a checkbox on page");
        WebElement input = driver.findElement(By.xpath("//input[@type='text']"));// часть по проверке инпута
        Assert.assertFalse(input.isEnabled(), "Input must be disabled, but it's enabled");
        driver.findElement(By.xpath("//button[@onclick='swapInput()']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p[id=message]")));
        Assert.assertTrue(input.isEnabled(),"Input is disabled");

    }
}
