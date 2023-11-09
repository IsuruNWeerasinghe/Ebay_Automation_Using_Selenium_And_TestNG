package pom.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    ThreadLocal<WebDriver> threadLocalWebDriver = ThreadLocal.withInitial(()->{
        WebDriver driver;
        String browser = System.getProperty("browser", "chrome");

        switch (browser){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            default:
                throw new RuntimeException("Browser not found. Please check and try another browser.");
        }
        driver.manage().window().maximize();
        return driver;
    });

    private static BrowserFactory browserFactoryInstance;

    private BrowserFactory(){
    }

    public static BrowserFactory getBrowserFactoryInstance(){
        if (browserFactoryInstance == null){
            browserFactoryInstance = new BrowserFactory();
        }
        return browserFactoryInstance;
    }

    public WebDriver getDriver(){
        return threadLocalWebDriver.get();
    }

    public void quitDriver(){
        if (getDriver() != null){
            threadLocalWebDriver.get().quit();
        }
        threadLocalWebDriver.remove();
    }

    public void cleanDriver(){
        if (getDriver() != null){
            threadLocalWebDriver.get().manage().deleteAllCookies();
        }
    }

}
