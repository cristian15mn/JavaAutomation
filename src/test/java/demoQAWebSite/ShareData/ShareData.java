package demoQAWebSite.ShareData;

import configFile.ConfigFile;
import configFile.configNode.ConfigurationNode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class ShareData {

    private WebDriver driver;

    @BeforeMethod
    public void prepareBrowser(){

        ConfigurationNode configurationNode= ConfigFile.createConfigNode(ConfigurationNode.class);

        //deschidem un browser de Chrome
        driver = new ChromeDriver();

        //facem browser-ul in modul maximize
        driver.manage().window().maximize();
        //accesam o pagina web
        driver.get(configurationNode.driverConfigNode.url);

        //Definim un wait implicit pentru un interval maxim de timp
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void clearBrowser(){
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
