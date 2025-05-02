package HelperMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavascriptHelpers {

    WebDriver driver;
    JavascriptExecutor javascriptExecutor;

    public JavascriptHelpers(WebDriver driver) {
        this.driver = driver;
        this.javascriptExecutor = (JavascriptExecutor) driver;
    }

    public void scroll(int x, int y) {
        //Facem un scroll ca sa fie elemetul vizibil in caz ca nu incape in pagina
        //JavascriptExecutor ajuta atunci cand metodele standard din selenium nu ne ajuta
        javascriptExecutor.executeScript("window.scrollBy(" + x + "," + y + ")");
        //o=X si 400=Y, coordonatele X si Y reprez cele 2 valori(0 si 400)
    }

    public void scrollDown(int y) {
        scroll(0, y);
    }

    public void scrollRight(int x) {
        scroll(x, 0);
    }

    public void forceClick(WebElement element) {
        //Cand nu poti face click pe element (eg: o reclama se suprapune)
        //Javascript Executor iti permite sa faci actiuni extra
        javascriptExecutor.executeScript("arguments[0].click();", element);
    }
}
