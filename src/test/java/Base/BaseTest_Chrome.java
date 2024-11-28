package Base;
import org.testng.annotations.*;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest_Chrome {
    public WebDriver driver;
    public String homePage ="https://preprod.netmera.com/#/index/netmeratest/campaigns";
    @BeforeClass
    public void before() {
        //killChromeProcesses();
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--headless"); // Run in headless mode
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--version");
        chromeOptions.addArguments("--no-sandbox");  // Sandbox modunu devre dışı bırak
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--enable-automation");
        chromeOptions.addArguments("--incognito");
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver= new ChromeDriver(chromeOptions);
        driver.get(homePage);
    }
    public static void killChromeProcesses() {
        try {
            // This will kill all Chrome processes
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
            Runtime.getRuntime().exec("taskkill /F /IM chrome.exe /T");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @AfterClass
    public void after() throws InterruptedException {
        driver.quit();
        Thread.sleep(2000);
        //killChromeProcesses();
    }
}
