package Tests;

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
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableTest extends ShareData {

    CommonPage commonPage;
    HomePage homePage;

    @Test
    public void automationMethod(){


        commonPage = new CommonPage(getDriver());
        homePage = new HomePage(getDriver());

        //facem un scroll pe pagina
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,400)", ""); //o=X si 400=Y, coordonatele X si Y reprez cele 2 valori(0 si 400)

        //declaram un web element
//        WebElement elementField=driver.findElement(By.xpath("//h5[text()='Elements']"));
//        elementField.click();
        homePage.goToDesiredMenus("Elements");

//        WebElement webTableField=driver.findElement(By.xpath("//span[text()='Web Tables']"));
//        webTableField.click();
        commonPage.goToDesiredSubMenus("Web Tables");

        List<WebElement> tableElements =getDriver().findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Integer actualTableSize=tableElements.size();

        WebElement addField=getDriver().findElement(By.id("addNewRecordButton"));
        addField.click();

        WebElement firstNameField=getDriver().findElement(By.id("firstName"));
        String firstNameValue="firstName";
        firstNameField.sendKeys(firstNameValue);

        WebElement lastNameField=getDriver().findElement(By.id("lastName"));
        String lastNameValue="lastName";
        lastNameField.sendKeys(lastNameValue);

        WebElement emailField=getDriver().findElement(By.id("userEmail"));
        String emailValue="test@test.com";
        emailField.sendKeys(emailValue);

        WebElement ageField=getDriver().findElement(By.id("age"));
        String ageValue="30";
        ageField.sendKeys(ageValue);

        WebElement salaryField=getDriver().findElement(By.id("salary"));
        String salaryValue="2000";
        salaryField.sendKeys(salaryValue);

        WebElement departmentField=getDriver().findElement(By.id("department"));
        String departmentValue="testing";
        departmentField.sendKeys(departmentValue);

        WebElement submitField=getDriver().findElement(By.id("submit"));
        submitField.click();


        List<WebElement> expectedTableElements =getDriver().findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Integer expectedTableSize=actualTableSize+1;
        Assert.assertEquals(expectedTableElements.size(),expectedTableSize);

        String actualTableValue=expectedTableElements.get(3).getText();
        Assert.assertTrue(actualTableValue.contains(firstNameValue));
        Assert.assertTrue(actualTableValue.contains(lastNameValue));
        Assert.assertTrue(actualTableValue.contains(emailValue));
        Assert.assertTrue(actualTableValue.contains(ageValue));
        Assert.assertTrue(actualTableValue.contains(salaryValue));
        Assert.assertTrue(actualTableValue.contains(departmentValue));
    }
}
