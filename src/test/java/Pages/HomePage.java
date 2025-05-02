package Pages;

import HelperMethods.ElementMethods;
import HelperMethods.JavascriptHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    WebDriver driver;
    ElementMethods elementMethods;
    JavascriptHelpers javascriptHelpers;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.elementMethods=new ElementMethods(driver);
        this.javascriptHelpers=new JavascriptHelpers(driver);
        PageFactory.initElements(driver,this);
    }

    //Identificam web elementele specifice pt pagina noastra
    @FindBy(xpath = "//h5")
    List<WebElement> elementsField;

    //Facem metode specifice pt pagina noastra
    public void goToDesiredMenus( String menu){
        javascriptHelpers.scrollDown(400);
        elementMethods.selectElementFromListByText(elementsField, menu);
    }

}
