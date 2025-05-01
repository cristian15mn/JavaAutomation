package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Frames {

    public WebDriver driver;
    @Test
    public void automationMethod() {
        //deschidem un browser de Chrome
        driver = new ChromeDriver();


        //accesam o pagina web
        driver.get("https://demoqa.com/");

        //facem browser-ul in modul maximize
        driver.manage().window().maximize();

        //facem un scroll pe pagina
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy(0,600)", ""); //o=X si 400=Y, coordonatele X si Y reprez cele 2 valori(0 si 400)

        //declaram un web element
        WebElement alertFrameField = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        alertFrameField.click();

        WebElement frameElement=driver.findElement(By.xpath("//span[text()='Frames']"));
        frameElement.click();

        WebElement frame1Element=driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frame1Element);
        WebElement sampleHeadingFrame1Element=driver.findElement(By.id("sampleHeading"));
        System.out.println("Textul din New Frame este: " + sampleHeadingFrame1Element.getText());
        driver.switchTo().defaultContent();

        WebElement frame2Element=driver.findElement(By.id("frame2"));
        driver.switchTo().frame(frame2Element);
        executor.executeScript("window.scrollBy(200,200)", "");

    }

}
