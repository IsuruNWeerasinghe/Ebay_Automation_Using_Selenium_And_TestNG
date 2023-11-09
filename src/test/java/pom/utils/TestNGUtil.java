package pom.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class TestNGUtil {
    public BrowserFactory browserFactoryInstance = null;
    protected ExtentReports extent = new ExtentReports();
    protected ExtentSparkReporter spark = new ExtentSparkReporter("reports/Ebay_Automation_Using_Selenium_And_TestNG_Project_Report.html");
    public WebDriverWait webDriverWait = null;
    public ExtentTest extentTest = null;


    @BeforeTest
    public void createReport(){
        extent.attachReporter(spark);
    }

    @BeforeClass
    @Parameters({"browser"})
    public void initBrowser(@Optional("chrome") String browser){
        browserFactoryInstance = BrowserFactory.getBrowserFactoryInstance();
        browserFactoryInstance.getDriver();
        webDriverWait = new WebDriverWait(browserFactoryInstance.getDriver(), Duration.ofSeconds(15));
    }

    @AfterClass
    public void quitWebDriver(){
        browserFactoryInstance.quitDriver();
    }

    @AfterTest
    public void flushReport(){
        extent.flush();
    }
}
