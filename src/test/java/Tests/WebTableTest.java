package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableTest {

    public WebDriver driver;
    @Test
    public void automationMethod(){
        //deschidem un browser de Chrome
        driver=new ChromeDriver();

        //accesam o pagina web
        driver.get("https://demoqa.com/");

        //facem browser-ul in modul maximize
        driver.manage().window().maximize();

        //facem un scroll pe pagina
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)", ""); //o=X si 400=Y, coordonatele X si Y reprez cele 2 valori(0 si 400)

        //declaram un web element
        WebElement elementField=driver.findElement(By.xpath("//h5[text()='Elements']"));
        elementField.click();

        WebElement webTableField=driver.findElement(By.xpath("//span[text()='Web Tables']"));
        webTableField.click();

        List<WebElement> tableElements =driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Integer actualTableSize=tableElements.size();

        WebElement addField=driver.findElement(By.id("addNewRecordButton"));
        addField.click();

        WebElement firstNameField=driver.findElement(By.id("firstName"));
        String firstNameValue="Cristian";
        firstNameField.sendKeys(firstNameValue);

        WebElement lastNameField=driver.findElement(By.id("lastName"));
        String lastNameValue="Negrea";
        lastNameField.sendKeys(lastNameValue);

        WebElement emailField=driver.findElement(By.id("userEmail"));
        String emailValue="test@test.com";
        emailField.sendKeys(emailValue);

        WebElement ageField=driver.findElement(By.id("age"));
        String ageValue="30";
        ageField.sendKeys(ageValue);

        WebElement salaryField=driver.findElement(By.id("salary"));
        String salaryValue="2000";
        salaryField.sendKeys(salaryValue);

        WebElement departmentField=driver.findElement(By.id("department"));
        String departmentValue="testing";
        departmentField.sendKeys(departmentValue);

        WebElement submitField=driver.findElement(By.id("submit"));
        submitField.click();


        List<WebElement> expectedTableElements =driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']"));
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
