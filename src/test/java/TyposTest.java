import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TyposTest extends BaseTest{
    @BeforeMethod
    public void navigate() {
        super.setUp();
        driver.get("http://the-internet.herokuapp.com/typos");
    }
    @AfterMethod
    public void quitDriver() {super.exit();
    }

    @Test
    public void typos () {
        for (int i=0; i<5; i++) {
            driver.navigate().refresh();
            List<WebElement> text = driver.findElements(By.tagName("p"));
            Assert.assertEquals(text.get(1).getText(), "Sometimes you'll see a typo, other times you won't.", "Error: there's a mistake in the  word 'won,t' ");

            }

        }

    }

