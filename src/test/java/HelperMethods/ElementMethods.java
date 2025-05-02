package HelperMethods;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class ElementMethods {

    WebDriver driver;
    Actions actions;

    public ElementMethods(WebDriver driver) {
        this.driver = driver;
        this.actions=new Actions(driver);
    }

    public void clickOnElements(WebElement element) {
        element.click();
    }

    public void fillElement(WebElement element, String value) {
        element.sendKeys(value);
    }

    public void addPictures(WebElement element) {
        File file = new File("src/test/resources/Image1.png");
        element.sendKeys(file.getAbsolutePath());
    }

    public void selectElementFromListByText(List<WebElement> elementList, String value) {
        for (int i = 0; i < elementList.size(); i++) {
            if (elementList.get(i).getText().equals(value)) {
                clickOnElements(elementList.get(i));
                break;
            }
        }
    }

    public void displayContentOfElement(WebElement element) {
        System.out.println("Textul din element este: " + element.getText());
    }

//    public void fieldsMenu(List<WebElement> elementList, int index){
//        clickOnElements(elementList.get(index));
//    }

    public void fillWithActions(WebElement element, String value){
        actions.sendKeys(value).perform();
        //merge si cu build.perform
        waitForAnElementToBeVisible(element);
        actions.sendKeys(Keys.ENTER).perform();
    }

    public void waitForAnElementToBeVisible(WebElement element) {
        //Definim un explicit Wait ca sa astepte dupa alerta
        WebDriverWait waitExplicit = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitExplicit.until(ExpectedConditions.visibilityOf(element));
    }

    public void fillWithMultipleValues(WebElement element, List<String> list){
        for(String value:list){
            element.sendKeys(value);
            element.sendKeys(Keys.ENTER);
        }
    }

    public void clickMultipleValues(List<WebElement> elements, List<String> list){
        for(String value:list){
            for (WebElement element:elements){
                if(element.getText().equals(value)){
                    element.click();
                }
            }
        }
    }
}
