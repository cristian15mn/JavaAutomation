package Tests;

import HelperMethods.ElementMethods;
import HelperMethods.FrameMethods;
import HelperMethods.JavascriptHelpers;
import HelperMethods.WindowMethods;
import Pages.CommonPage;
import Pages.HomePage;
import demoQAWebSite.ShareData.ShareData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FramesTest extends ShareData {

    ElementMethods elementMethods;
    FrameMethods frameMethods;
    CommonPage commonPage;
    HomePage homePage;

    @Test
    public void automationMethod() throws InterruptedException {

        elementMethods=new ElementMethods(getDriver());
        frameMethods = new FrameMethods(getDriver());
        commonPage = new CommonPage(getDriver());
        homePage = new HomePage(getDriver());

        //facem un scroll pe pagina
        //javascriptHelpers.scrollDown(400);

        //declaram un web element
//        WebElement alertFrameField = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
//        elementMethods.clickOnElements(alertFrameField);
        homePage.goToDesiredMenus("Alerts, Frame & Windows");


//        WebElement frameElement = driver.findElement(By.xpath("//span[text()='Frames']"));
//        elementMethods.clickOnElements(frameElement);
        commonPage.goToDesiredSubMenus("Frames");


        //javascriptHelpers.scrollDown(400);

        WebElement frame1Element = getDriver().findElement(By.id("frame1"));
        frameMethods.switchToFrame(frame1Element);
        WebElement sampleHeadingFrame1Element = getDriver().findElement(By.id("sampleHeading"));
        elementMethods.displayContentOfElement(sampleHeadingFrame1Element);

        //Ne ducem cu focusul inapoi pe pagina principala
        frameMethods.switchToMainContent();

        WebElement frame2Element = getDriver().findElement(By.id("frame2"));
        frameMethods.switchToFrame(frame2Element);
        WebElement sampleHeadingFrame2Element = getDriver().findElement(By.id("sampleHeading"));
        elementMethods.displayContentOfElement(sampleHeadingFrame2Element);

        //javascriptHelpers.scroll(50, 50);

        frameMethods.switchToMainContent();
    }

}
