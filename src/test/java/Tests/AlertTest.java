package Tests;

import HelperMethods.AlertMethods;
import HelperMethods.ElementMethods;
import Pages.CommonPage;
import Pages.HomePage;
import demoQAWebSite.ShareData.ShareData;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertTest extends ShareData {
    ElementMethods elementMethods;
    AlertMethods alertMethods;
    CommonPage commonPage;
    HomePage homePage;

    @Test
    public void automationMethod() {

        elementMethods=new ElementMethods(getDriver());
        alertMethods = new AlertMethods(getDriver());
        commonPage = new CommonPage(getDriver());
        homePage = new HomePage(getDriver());

        //facem un scroll pe pagina
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("window.scrollBy(0,400)", ""); //o=X si 400=Y, coordonatele X si Y reprez cele 2 valori(0 si 400)

        //declaram un web element
        //WebElement alertField = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        //alertField.click();
        //elementMethods.clickOnElements(alertField);
        homePage.goToDesiredMenus("Alerts, Frame & Windows");

        // WebElement alertsField = driver.findElement(By.xpath("//span[text()='Alerts']"));
        //alertsField.click();
        //elementMethods.clickOnElements(alertsField);
        commonPage.goToDesiredSubMenus("Alerts");


        WebElement alertOKElement = getDriver().findElement(By.id("alertButton"));
        //alertOKElement.click();
        elementMethods.clickOnElements(alertOKElement);
        //ne mutam cu focusul pe Alerta, este necesar sa avem aceasta linie de cod ca sa putem interactiona cu Alerta
//        Alert alertOK=driver.switchTo().alert();
//        alertOK.accept();
        alertMethods.interactWithAlertsOK();

        WebElement alertDelayOKElement = getDriver().findElement(By.id("timerAlertButton"));
//        alertDelayOKElement.click();
        elementMethods.clickOnElements(alertDelayOKElement);

//        //Definim un explicit Wait ca sa astepte dupa alerta
//        WebDriverWait waitExplicit=new WebDriverWait(driver,Duration.ofSeconds(10));
//        waitExplicit.until(ExpectedConditions.alertIsPresent());
//        Alert alertDelayOK=driver.switchTo().alert();
//        alertDelayOK.accept();
        alertMethods.interractWithDelayAlert();

//        //Wait implicit cel mai folosit(probabil), asteapta dar nu stie exact ce asteapta
//        //Wait explicit, stie pentru ce sa astepte
//        //Am declarat sus un ipmplicit Wait
//
//        WebElement alertConfirmationOKElement=driver.findElement(By.id("confirmButton"));
//        alertConfirmationOKElement.click();
//        Alert alertConfirmationOK=driver.switchTo().alert();
//        alertConfirmationOK.dismiss();
//
//        WebElement alertPromtElement=driver.findElement(By.id("promtButton"));
//        alertPromtElement.click();
//        Alert alertPromt=driver.switchTo().alert();
//        alertPromt.sendKeys("AlaBala");
//        alertPromt.accept();


    }

}
