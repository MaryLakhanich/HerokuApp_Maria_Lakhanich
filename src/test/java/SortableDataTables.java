import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SortableDataTables extends BaseTest{
    @BeforeMethod
    public void navigate() {
        super.setUp();
        driver.get("http://the-internet.herokuapp.com/tables");
    }

    @AfterMethod
    public void quitDriver() {super.exit();
    }
    @Test
    public void sortTables () {
        WebElement lastName=driver.findElement(By.xpath("//tbody/tr[1]/td[1]"));
        Assert.assertEquals(lastName.getText(), "Smith");
        WebElement firstName=driver.findElement(By.xpath("//tbody/tr[2]/td[2]"));
        Assert.assertEquals(firstName.getText(), "Frank");
        WebElement email=driver.findElement(By.xpath("//tbody/tr[2]/td[3]"));
        Assert.assertEquals(email.getText(), "fbach@yahoo.com");
        WebElement webSite=driver.findElement(By.xpath("//tbody/tr[3]/td[5]"));
        Assert.assertEquals(webSite.getText(), "http://www.jdoe.com");

    }
}
