package HelperMethods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertMethods {

    WebDriver driver;

    public AlertMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void interactWithAlertsOK() {
        Alert alertOK = driver.switchTo().alert();
        alertOK.accept();
    }

    public void explicitAlertWait() {
        //Definim un explicit Wait ca sa astepte dupa alerta
        WebDriverWait waitExplicit = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitExplicit.until(ExpectedConditions.alertIsPresent());
    }

    public void interractWithDelayAlert() {
        explicitAlertWait();
        Alert alertDelayOK = driver.switchTo().alert();
        alertDelayOK.accept();
    }
}
