package Pages;

import HelperMethods.ElementMethods;
import HelperMethods.JavascriptHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormPage {

    WebDriver driver;
    ElementMethods elementMethods;
    JavascriptHelpers javascriptHelpers;

    public PracticeFormPage(WebDriver driver) {
        this.driver = driver;
        this.elementMethods = new ElementMethods(driver);
        this.javascriptHelpers = new JavascriptHelpers(driver);
        //asta e pt partea de driver.findElement
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "firstName")
    WebElement firstNameElement;
    @FindBy(id = "lastName")
    WebElement lastNameElement;
    @FindBy(id = "userEmail")
    WebElement userEmailElement;

    @FindBy(css = "input[placeholder='Mobile Number']")
    WebElement mobileNumberElement;

    @FindBy(id = "uploadPicture")
    WebElement pictureElement;

    @FindBy(xpath = "//label[@for='gender-radio-1']")
    WebElement maleGenderElement;
    @FindBy(xpath = "//label[@for='gender-radio-2']")
    WebElement femaleGenderElement;
    @FindBy(xpath = "//label[@for='gender-radio-3']")
    WebElement otherGenderElement;

    @FindBy(id = "currentAddress")
    WebElement addressElement;

    @FindBy(id = "react-select-3-input")
    WebElement stateElement;
    @FindBy(id = "react-select-4-input")
    WebElement cityElement;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-1']")
    WebElement sportHobbyElement;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-2']")
    WebElement readyingHobbyElement;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-3']")
    WebElement musicHobbyElement;


//    @FindBy(xpath = "//div[id='subjectsContainer']")
//    WebElement subjectsElement;

    @FindBy(id = "subjectsInput")
    WebElement subjectsElement;


    public void completeFirstRegion(String firstName, String lastName, String email, String address, String mobileNr) {
        elementMethods.fillElement(firstNameElement, firstName);
        elementMethods.fillElement(lastNameElement, lastName);
        elementMethods.fillElement(userEmailElement, email);
        elementMethods.fillElement(addressElement, address);
        elementMethods.fillElement(mobileNumberElement, mobileNr);
    }

    public void completeGender(String gender) {
        switch (gender) {
            case "Male":
                elementMethods.clickOnElements(maleGenderElement);
                break;
            case "Female":
                elementMethods.clickOnElements(femaleGenderElement);
                break;
            case "Other":
                elementMethods.clickOnElements(otherGenderElement);
                break;
        }
    }

    public void completeSubject(String subject) {
        elementMethods.clickOnElements(subjectsElement);
        elementMethods.fillWithActions(subjectsElement, subject);
    }

    public void completeSubjectsWithList(List<String> list) {
        elementMethods.clickOnElements(subjectsElement);
        elementMethods.fillWithMultipleValues(subjectsElement, list);
    }

    public void completeHobies(List<String> hobies) {
        List<WebElement> hobiesElement = new ArrayList<>();
        hobiesElement.add(sportHobbyElement);
        hobiesElement.add(readyingHobbyElement);
        hobiesElement.add(musicHobbyElement);
        elementMethods.clickMultipleValues(hobiesElement, hobies);

    }
}
