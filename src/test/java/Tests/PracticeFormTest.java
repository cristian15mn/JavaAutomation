package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;

public class PracticeFormTest {

    public WebDriver driver;
    @Test
    public void automationMethod() {
        //deschidem un browser de Chrome
        driver = new ChromeDriver();


        //accesam o pagina web
        driver.get("https://demoqa.com/");

        //facem browser-ul in modul maximize
        driver.manage().window().maximize();

        //facem un scroll pe pagina
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)", ""); //o=X si 400=Y, coordonatele X si Y reprez cele 2 valori(0 si 400)

       //declaram un web element
        WebElement formField=driver.findElement(By.xpath("//h5[text()='Forms']"));
        formField.click();

        WebElement practiceFormField=driver.findElement(By.xpath("//span[text()='Practice Form']"));
        practiceFormField.click();

        WebElement addFirstNamePracticeField=driver.findElement(By.id("firstName"));
        String firstNameValue="FistName";
        addFirstNamePracticeField.sendKeys(firstNameValue);

        WebElement addLastNamePracticeField=driver.findElement(By.id("lastName"));
        String lastNameValue="LastName";
        addLastNamePracticeField.sendKeys(lastNameValue);

        WebElement emailPacticeField=driver.findElement(By.id("userEmail"));
        String emailValue="test@test.com";
        emailPacticeField.sendKeys(emailValue);

        WebElement mobilePracticeField=driver.findElement(By.cssSelector("input[placeholder='Mobile Number']"));
        String phoneNumber="+409090909";
        mobilePracticeField.sendKeys(phoneNumber);

        WebElement uploadPicturePracticeField=driver.findElement(By.id("uploadPicture"));
        File file = new File("src/test/resources/Image1.png");
        uploadPicturePracticeField.sendKeys(file.getAbsolutePath());

    }
}
