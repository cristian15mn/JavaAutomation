package Tests;

import HelperMethods.ElementMethods;
import HelperMethods.FrameMethods;
import HelperMethods.JavascriptHelpers;
import HelperMethods.WindowMethods;
import Pages.CommonPage;
import Pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FramesTest {

    WebDriver driver;
    JavascriptHelpers javascriptHelpers;
    ElementMethods elementMethods;
    FrameMethods frameMethods;
    CommonPage commonPage;
    HomePage homePage;

    @Test
    public void automationMethod() throws InterruptedException {
        //deschidem un browser de Chrome
        driver = new ChromeDriver();

        //accesam o pagina web
        driver.get("https://demoqa.com/");

        //facem browser-ul in modul maximize
        driver.manage().window().maximize();

        javascriptHelpers=new JavascriptHelpers(driver);
        elementMethods = new ElementMethods(driver);
        frameMethods=new FrameMethods(driver);
        commonPage = new CommonPage(driver);
        homePage = new HomePage(driver);

        //facem un scroll pe pagina
        javascriptHelpers.scrollDown(400);

        //declaram un web element
//        WebElement alertFrameField = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
//        elementMethods.clickOnElements(alertFrameField);
        homePage.goToDesiredMenus("Alerts, Frame & Windows");


//        WebElement frameElement = driver.findElement(By.xpath("//span[text()='Frames']"));
//        elementMethods.clickOnElements(frameElement);
        commonPage.goToDesiredSubMenus("Frames");


        javascriptHelpers.scrollDown(400);

        WebElement frame1Element = driver.findElement(By.id("frame1"));
        frameMethods.switchToFrame(frame1Element);
        WebElement sampleHeadingFrame1Element = driver.findElement(By.id("sampleHeading"));
        elementMethods.displayContentOfElement(sampleHeadingFrame1Element);

        //Ne ducem cu focusul inapoi pe pagina principala
        frameMethods.switchToMainContent();

        WebElement frame2Element = driver.findElement(By.id("frame2"));
        frameMethods.switchToFrame(frame2Element);
        WebElement sampleHeadingFrame2Element = driver.findElement(By.id("sampleHeading"));
        elementMethods.displayContentOfElement(sampleHeadingFrame2Element);

        Thread.sleep(2000);
        javascriptHelpers.scroll(50, 50);

        frameMethods.switchToMainContent();

        Thread.sleep(5000);
        driver.quit();
    }

}
