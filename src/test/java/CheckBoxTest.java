import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class CheckBoxTest extends BaseTest {
    @BeforeMethod
    public void navigate() {
        super.setUp();
        driver.get("http://the-internet.herokuapp.com/checkboxes");
    }

    @AfterMethod
    public void quitDriver() {
        super.exit();
    }
    @Test
    public void checkBox () {
        List<WebElement> checkBoxes= driver.findElements(By.cssSelector("[type='checkbox']"));
        Assert.assertFalse(checkBoxes.get(0).isSelected(),"The 1st checkboх is selected");
        checkBoxes.get(0).click();
        Assert.assertTrue(checkBoxes.get(0).isSelected(), "The 1st checkboх isn't selected");
        Assert.assertTrue(checkBoxes.get(1).isSelected(),"The 2nd checkboх isn't selected");
        checkBoxes.get(1).click();
        Assert.assertFalse(checkBoxes.get(1).isSelected(), "The 2nd checkboх is selected");
    }
}

