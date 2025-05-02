package Tests;

import HelperMethods.AlertMethods;
import HelperMethods.ElementMethods;
import HelperMethods.JavascriptHelpers;
import HelperMethods.WindowMethods;
import Pages.CommonPage;
import Pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class BrowserWindowsTabTest {

    WebDriver driver;
    JavascriptHelpers javascriptHelpers;
    ElementMethods elementMethods;
    WindowMethods windowMethods;
    CommonPage commonPage;
    HomePage homePage;

    @Test
    public void automationMethod() {
        //deschidem un browser de Chrome
        driver = new ChromeDriver();


        //accesam o pagina web
        driver.get("https://demoqa.com/");

        //facem browser-ul in modul maximize
        driver.manage().window().maximize();

        javascriptHelpers=new JavascriptHelpers(driver);
        elementMethods = new ElementMethods(driver);
        windowMethods=new WindowMethods(driver);
        commonPage = new CommonPage(driver);
        homePage = new HomePage(driver);

        //facem un scroll pe pagina
//        JavascriptExecutor executor = (JavascriptExecutor) driver;
//        executor.executeScript("window.scrollBy(0,400)", ""); //o=X si 400=Y, coordonatele X si Y reprez cele 2 valori(0 si 400)

        //declaram un web element
//        WebElement alertWindowField = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
//        alertWindowField.click();
        homePage.goToDesiredMenus("Alerts, Frame & Windows");

//        WebElement browserWindowsElement=driver.findElement(By.xpath("//span[text()='Browser Windows']"));
//        browserWindowsElement.click();
        commonPage.goToDesiredSubMenus("Browser Windows");


        WebElement browserNewTab=driver.findElement(By.id("tabButton"));
        browserNewTab.click();

        //getWindowHandles returneaza toate Windows deschide
        List<String> tabList=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabList.get(1));
        WebElement sampleHeadingElement=driver.findElement(By.id("sampleHeading"));
        System.out.println("Textul din New Tab este: " + sampleHeadingElement.getText());
        driver.close();
        driver.switchTo().window(tabList.get(0));

        WebElement browserNewWindow=driver.findElement(By.id("windowButton"));
        browserNewWindow.click();
        List<String> windowList=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));
        WebElement sampleHeadingNewWindowElement=driver.findElement(By.id("sampleHeading"));
        System.out.println("Textul din New Window este: " + sampleHeadingNewWindowElement.getText());
        driver.close();
        driver.switchTo().window(windowList.get(0));


    }

}
