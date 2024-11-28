package Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest_Edge {
    public WebDriver driver;
    public String homePage ="https://preprod.netmera.com/#/index/netmeratest/campaigns";
    @BeforeClass
    public void SetupEdge() {
        //killChromeProcesses();
        EdgeOptions options = new EdgeOptions();
        //options.setCapability("ie.edgechromium", true); // Chromium tabanlı Edge kullanımı
        //options.setCapability("ie.ensureCleanSession", true); // Her oturumda temiz başlangıç
        options.addArguments("--start-maximized");
        options.addArguments("--inprivate");
        //options.addArguments("--headless");
        driver= new EdgeDriver(options);
        driver.get(homePage);
    }
    public static void killEdgeProcesses() {
        try {
            // This will kill all edge processes
            //Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe /T");
            Runtime.getRuntime().exec("taskkill /F /IM msedge.exe");
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
