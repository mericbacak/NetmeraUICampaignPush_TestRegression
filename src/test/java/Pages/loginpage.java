package Pages;
import Base.BasePage;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginpage extends BasePage{
    public loginpage(WebDriver driver) {
        super(driver);
    }
    public static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(loginpage.class);
    Locators.LoginPage locators=new Locators.LoginPage();
    public void NetmeraLogin(){
        logger.info("https://preprod.netmera.com/#/login page opened");
        SendKeysBy(By.xpath(locators.emailInput),"nagihan.yapici@netmera.com");
        SendKeysBy(By.xpath(locators.passwordInput),"Na12.....");
        clickBy(By.xpath(locators.RememberMeChckbx));
        clickBy(By.xpath(locators.loginbtn));
        ElementisDisplayed(By.xpath(locators.AppText));
        logger.info("Logged in preprodNetmera");
    }
}