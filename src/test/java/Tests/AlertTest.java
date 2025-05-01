package Tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertTest {
    public WebDriver driver;
    @Test
    public void automationMethod() {
        //deschidem un browser de Chrome
        driver = new ChromeDriver();


        //accesam o pagina web
        driver.get("https://demoqa.com/");

        //Definim un wait implicit pentru un interval maxim de timp
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //facem browser-ul in modul maximize
        driver.manage().window().maximize();

        //facem un scroll pe pagina
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy(0,400)", ""); //o=X si 400=Y, coordonatele X si Y reprez cele 2 valori(0 si 400)

        //declaram un web element
        WebElement alertField=driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        alertField.click();

        WebElement alertsField=driver.findElement(By.xpath("//span[text()='Alerts']"));
        alertsField.click();

        WebElement alertOKElement=driver.findElement(By.id("alertButton"));
        alertOKElement.click();
        //ne mutam cu focusul pe Alerta, este necesar sa avem aceasta linie de cod ca sa putem interactiona cu Alerta
        Alert alertOK=driver.switchTo().alert();
        alertOK.accept();

        WebElement alertDelayOKElement=driver.findElement(By.id("timerAlertButton"));
        alertDelayOKElement.click();
        //Definim un explicit Wait ca sa astepte dupa alerta
        WebDriverWait waitExplicit=new WebDriverWait(driver,Duration.ofSeconds(10));
        waitExplicit.until(ExpectedConditions.alertIsPresent());
        Alert alertDelayOK=driver.switchTo().alert();
        alertDelayOK.accept();
        //Wait implicit cel mai folosit(probabil), asteapta dar nu stie exact ce asteapta
        //Wait explicit, stie pentru ce sa astepte
        //Am declarat sus un ipmplicit Wait

        WebElement alertConfirmationOKElement=driver.findElement(By.id("confirmButton"));
        alertConfirmationOKElement.click();
        Alert alertConfirmationOK=driver.switchTo().alert();
        alertConfirmationOK.dismiss();

        WebElement alertPromtElement=driver.findElement(By.id("promtButton"));
        alertPromtElement.click();
        Alert alertPromt=driver.switchTo().alert();
        alertPromt.sendKeys("AlaBala");
        alertPromt.accept();




    }

}
