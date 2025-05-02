package Tests;

import HelperMethods.ElementMethods;
import HelperMethods.JavascriptHelpers;
import Pages.CommonPage;
import Pages.HomePage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PracticeFormTest {

     WebDriver driver;
     ElementMethods elementMethods;
     JavascriptHelpers javascriptHelpers;
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

        elementMethods = new ElementMethods(driver);
        javascriptHelpers = new JavascriptHelpers(driver);
        commonPage=new CommonPage(driver);
        homePage=new HomePage(driver);

        //facem un scroll pe pagina
        // JavascriptExecutor executor = (JavascriptExecutor) driver;
        //executor.executeScript("window.scrollBy(0,400)", ""); //o=X si 400=Y, coordonatele X si Y reprez cele 2 valori(0 si 400)

        //declaram un web element
        //List<WebElement> elementsField = driver.findElements(By.xpath("//h5"));
        //formField.click();
        //javascriptHelpers.scrollDown(400);
        //elementMethods.selectElementFromListByText(elementsField, "Forms");
        homePage.goToDesiredMenus("Forms");

        //WebElement practiceFormField=driver.findElement(By.xpath("//span[text()='Practice Form']"));
        //practiceFormField.click();
//        List<WebElement> elementsTable = driver.findElements(By.xpath("//span[@class='text']"));
//        elementMethods.selectElementFromListByText(elementsTable, "Practice Form");
        commonPage.goToDesiredSubMenus("Practice Form");

        WebElement addFirstNamePracticeField = driver.findElement(By.id("firstName"));
//        String firstNameValue="FistName";
//        addFirstNamePracticeField.sendKeys(firstNameValue);
        elementMethods.fillElement(addFirstNamePracticeField, "FirstName");

        WebElement addLastNamePracticeField = driver.findElement(By.id("lastName"));
//        String lastNameValue="LastName";
//        addLastNamePracticeField.sendKeys(lastNameValue);
        elementMethods.fillElement(addLastNamePracticeField, "LastName");


        WebElement emailPacticeField = driver.findElement(By.id("userEmail"));
//        String emailValue="test@test.com";
//        emailPacticeField.sendKeys(emailValue);
        elementMethods.fillElement(emailPacticeField, "test@test.com");

        WebElement mobilePracticeField = driver.findElement(By.cssSelector("input[placeholder='Mobile Number']"));
//        String phoneNumber="0409090909";
//        mobilePracticeField.sendKeys(phoneNumber);
        elementMethods.fillElement(mobilePracticeField, "0409090909");

        WebElement uploadPicturePracticeField = driver.findElement(By.id("uploadPicture"));
//        File file = new File("src/test/resources/Image1.png");
//        uploadPicturePracticeField.sendKeys(file.getAbsolutePath());
        elementMethods.addPictures(uploadPicturePracticeField);

        WebElement maleElement = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        WebElement femaleElement = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
        WebElement otherElement = driver.findElement(By.xpath("//label[@for='gender-radio-3']"));
//        String gender = "Other";
//        if (maleElement.getText().equals(gender)) {
//            maleElement.click();
//        } else if (femaleElement.getText().equals(gender)) {
//            femaleElement.click();
//        } else if (otherElement.getText().equals(gender)) {
//            otherElement.click();
//        }
        List<WebElement> genderElement = new ArrayList<>();
        genderElement.add(maleElement);
        genderElement.add(femaleElement);
        genderElement.add(otherElement);
        elementMethods.selectElementFromListByText(genderElement, "Female");

        WebElement subjectsElement = driver.findElement(By.id("subjectsInput"));
//        executor.executeScript("window.scrollBy(0,400)", "");
//        String subjectsValue="Social Studies";
//        subjectsElement.sendKeys(subjectsValue);
//        subjectsElement.sendKeys(Keys.ENTER);
//
//        WebElement stateElement=driver.findElement(By.id("react-select-3-input"));
//        executor.executeScript("arguments[0].click();", stateElement);
//        stateElement.sendKeys("NCR");
//        stateElement.sendKeys(Keys.ENTER);
//
//        WebElement cityElement=driver.findElement(By.id("react-select-4-input"));
//        executor.executeScript("arguments[0].click();", cityElement);
//        cityElement.sendKeys("Delhi");
//        cityElement.sendKeys(Keys.ENTER);
//
//        WebElement submitElement= driver.findElement(By.id("submit"));
//        executor.executeScript("arguments[0].click();", submitElement);
//
//    }
    }
}
