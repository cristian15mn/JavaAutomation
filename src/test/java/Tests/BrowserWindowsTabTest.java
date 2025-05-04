package Tests;

import HelperMethods.AlertMethods;
import HelperMethods.ElementMethods;
import HelperMethods.JavascriptHelpers;
import HelperMethods.WindowMethods;
import Pages.CommonPage;
import Pages.HomePage;
import demoQAWebSite.ShareData.ShareData;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class BrowserWindowsTabTest extends ShareData {


    WindowMethods windowMethods;
    CommonPage commonPage;
    HomePage homePage;

    @Test
    public void automationMethod() {

        windowMethods=new WindowMethods(getDriver());
        commonPage = new CommonPage(getDriver());
        homePage = new HomePage(getDriver());

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


        WebElement browserNewTab=getDriver().findElement(By.id("tabButton"));
        browserNewTab.click();

        //getWindowHandles returneaza toate Windows deschide
        List<String> tabList=new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabList.get(1));
        WebElement sampleHeadingElement=getDriver().findElement(By.id("sampleHeading"));
        System.out.println("Textul din New Tab este: " + sampleHeadingElement.getText());
        getDriver().close();
        getDriver().switchTo().window(tabList.get(0));

        WebElement browserNewWindow=getDriver().findElement(By.id("windowButton"));
        browserNewWindow.click();
        List<String> windowList=new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(windowList.get(1));
        WebElement sampleHeadingNewWindowElement=getDriver().findElement(By.id("sampleHeading"));
        System.out.println("Textul din New Window este: " + sampleHeadingNewWindowElement.getText());
        getDriver().close();
        getDriver().switchTo().window(windowList.get(0));


    }

}
