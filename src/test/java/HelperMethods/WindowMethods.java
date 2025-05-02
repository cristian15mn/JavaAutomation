package HelperMethods;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class WindowMethods {

    WebDriver driver;

    public WindowMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToOpenedTab(){
        //driver.getWindowHandles() -> returneaza toate windows deschise
        List<String> tabList=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabList.get(1));
    }

    public void switchToMainTab(){
        switchToMain();
    }


    private void close(){
        driver.close();
    }

    public void closeTab(){
        close();
    }

    public void closeWindow(){
        close();
    }

    public void switchToMainWindow(){
        switchToMain();
    }

    private void switchToMain(){
        //driver.getWindowsHandles() -> returneaza toate dindows deschise
        List<String> tabList=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabList.get(0));
    }
}
