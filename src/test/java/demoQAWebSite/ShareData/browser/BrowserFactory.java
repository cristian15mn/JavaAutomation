package demoQAWebSite.ShareData.browser;

import configFile.ConfigFile;
import configFile.configNode.ConfigurationNode;
import demoQAWebSite.ShareData.browser.service.ChromeBrowserService;
import demoQAWebSite.ShareData.browser.service.EdgeBrowserService;
import org.openqa.selenium.WebDriver;

import java.util.Locale;

public class BrowserFactory {

    public WebDriver getBrowserFactory(){

        String ciCd=System.getProperty("ciCd");
        String browser=System.getProperty("browser".toLowerCase(Locale.ROOT));

        System.out.println("Look here! " + browser);

        ConfigurationNode configurationNode= ConfigFile.createConfigNode(ConfigurationNode.class);

        if (Boolean.parseBoolean(ciCd)) {
            configurationNode.driverConfigNode.headless = "--headless";
        }
        else {
            browser=configurationNode.driverConfigNode.localBrowser;
        }

        switch (browser){
            case BrowserType.BROWSER_CHROME:
                ChromeBrowserService chromeBrowserService=new ChromeBrowserService();
                chromeBrowserService.openBrowser(configurationNode.driverConfigNode);
                return chromeBrowserService.getDriver();
            case BrowserType.BROWSER_EDGE:
                EdgeBrowserService edgeBrowserService=new EdgeBrowserService();
                edgeBrowserService.openBrowser(configurationNode.driverConfigNode);
                return edgeBrowserService.getDriver();
        }

        return null;
    }
}
