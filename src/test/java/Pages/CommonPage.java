package Pages;

import HelperMethods.ElementMethods;
import HelperMethods.JavascriptHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CommonPage {

    WebDriver driver;
    ElementMethods elementMethods;
    JavascriptHelpers javascriptHelpers;

    public CommonPage(WebDriver driver) {
        this.driver = driver;
        this.elementMethods=new ElementMethods(driver);
        this.javascriptHelpers=new JavascriptHelpers(driver);
        PageFactory.initElements(driver,this);
    }

    //Identificam web elementele specifice pt Common pagina noastra
    @FindBy(xpath = "//span[@class='text']")
    List<WebElement> elementsField;

    //Facem metode specifice pt Common pagina noastra
    public void goToDesiredSubMenus( String submenu){
        javascriptHelpers.scrollDown(400);
        elementMethods.selectElementFromListByText(elementsField, submenu);
    }
}
