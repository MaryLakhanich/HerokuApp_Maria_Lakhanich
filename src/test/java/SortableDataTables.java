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
        List<WebElement> elements = driver.findElements(By.cssSelector(".tablesorter thead tr th"));
        List<WebElement> johnSmith = driver.findElements(By.xpath("//tbody/tr[1]/td"));
        for (WebElement element : johnSmith) {
            Assert.assertEquals(johnSmith.get(0).getText(), "Smith");
            Assert.assertEquals(johnSmith.get(1).getText(), "John");
            Assert.assertEquals(johnSmith.get(2).getText(), "jsmith@gmail.com");
            Assert.assertEquals(johnSmith.get(3).getText(), "$50.00");
            Assert.assertEquals(johnSmith.get(4).getText(), "http://www.jsmith.com");
            Assert.assertEquals(johnSmith.get(5).getText(), "edit delete");
        }
        List<WebElement> bachFrank = driver.findElements(By.xpath("//tbody/tr[2]/td"));
        for (WebElement element : bachFrank) {
            Assert.assertEquals(bachFrank.get(0).getText(), "Bach");
            Assert.assertEquals(bachFrank.get(1).getText(), "Frank");
            Assert.assertEquals(bachFrank.get(2).getText(), "fbach@yahoo.com");
            Assert.assertEquals(bachFrank.get(3).getText(), "$51.00");
            Assert.assertEquals(bachFrank.get(4).getText(), "http://www.frank.com");
            Assert.assertEquals(bachFrank.get(5).getText(), "edit delete");
        }
        List<WebElement> doeJason = driver.findElements(By.xpath("//tbody/tr[3]/td"));
        for (WebElement element : doeJason) {
            Assert.assertEquals(doeJason.get(0).getText(), "Doe");
            Assert.assertEquals(doeJason.get(1).getText(), "Jason");
            Assert.assertEquals(doeJason.get(2).getText(), "jdoe@hotmail.com");
            Assert.assertEquals(doeJason.get(3).getText(), "$100.00");
            Assert.assertEquals(doeJason.get(4).getText(), "http://www.jdoe.com");
            Assert.assertEquals(doeJason.get(5).getText(), "edit delete");
        }
        List<WebElement> timConway = driver.findElements(By.xpath("//tbody/tr[4]/td"));
        for (WebElement element : timConway) {
            Assert.assertEquals(timConway.get(0).getText(), "Conway");
            Assert.assertEquals(timConway.get(1).getText(), "Tim");
            Assert.assertEquals(timConway.get(2).getText(), "tconway@earthlink.net");
            Assert.assertEquals(timConway.get(3).getText(), "$50.00");
            Assert.assertEquals(timConway.get(4).getText(), "http://www.timconway.com");
            Assert.assertEquals(timConway.get(5).getText(), "edit delete");
        }
    }
}

