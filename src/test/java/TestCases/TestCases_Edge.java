package TestCases;
import Base.BaseTest_Edge;
import Pages.loginpage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.Test;

public class TestCases_Edge extends BaseTest_Edge {
    public void tester() {
        loginpage loginPage= new loginpage(driver);
        loginPage.NetmeraLogin();
    }
    public static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(TestCases_Edge.class);

    @Test(priority = 1,groups = "CampaignTextPush") @Owner("Meriç Bacak") @Severity(SeverityLevel.NORMAL)
    @Description("https://preprod.netmera.com/#/login adresine giriş yapılır. Edge Tarayıcıdan")
    public void LoginNetmera() throws InterruptedException {
        logger.info("LoginNetmera testi BAŞLADI.");
        tester();
        logger.info("LoginNetmera testi TAMAMLANDI.");
        Thread.sleep(2000);
    }

}