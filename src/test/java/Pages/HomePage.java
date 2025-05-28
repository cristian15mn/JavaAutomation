package Pages;

import HelperMethods.ElementMethods;
import HelperMethods.JavascriptHelpers;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends CommonPage{


    //Identificam web elementele specifice pt pagina noastra
    @FindBy(xpath = "//h5")
    List<WebElement> elementsField;

    @FindBy(xpath = "//p[text()='Consent']")
    WebElement consentElement;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Facem metode specifice pt pagina noastra
    public void goToDesiredMenus( String menu) {
        try {
            elementMethods.clickOnElements(consentElement);
        } catch (NoSuchElementException ignored) {

            javascriptHelpers.scrollDown(400);
            elementMethods.selectElementFromListByText(elementsField, menu);
        }
    }

}
