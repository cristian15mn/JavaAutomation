package HelperMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.List;

public class ElementMethods {

    WebDriver driver;

    public ElementMethods(WebDriver driver) {
        this.driver = driver;
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
}
