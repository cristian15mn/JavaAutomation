package HelperMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameMethods {

    WebDriver driver;

    public FrameMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToFrame(WebElement element){
        //Schimbam focusul pe un frame anume
        driver.switchTo().frame(element);
    }

    public void switchToMainContent(){
        //Ne ducem cu focusul inapoi la pagina principala
        driver.switchTo().defaultContent();
    }
}
