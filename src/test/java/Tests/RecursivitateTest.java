package Tests;

import demoQAWebSite.ShareData.ShareData;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class RecursivitateTest extends ShareData {

    @Test
    public void parcurgereListeForEach() {

        //facem un scroll pe pagina
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("window.scrollBy(0,400)", ""); //o=X si 400=Y, coordonatele X si Y reprez cele 2 valori(0 si 400)

        Actions actions = new Actions(getDriver());
        List<WebElement> list = getDriver().findElements(By.xpath("//div[@id='demo-tabpane-list']//div[@class='list-group-item list-group-item-action']"));
        for (int i = 0; i < list.size() - 1; i++)
        {
            WebElement webElement = list.get(i);
            WebElement nextElement = list.get(i++);
            System.out.println("Numarul elementului este " + webElement.getText());
            actions.clickAndHold(webElement)
               .moveToElement(nextElement)
               .release()
               .build()
               .perform();
   }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
        }


