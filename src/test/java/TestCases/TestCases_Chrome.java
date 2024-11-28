package TestCases;

import Base.BaseTest_Chrome;
import Pages.*;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.Test;
public class TestCases_Chrome extends BaseTest_Chrome {
    public void tester() throws InterruptedException {
        loginpage loginPage= new loginpage(driver);
        loginPage.NetmeraLogin();
    }
    public static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(TestCases_Chrome.class);

    @Owner("Meriç Bacak") @Severity(SeverityLevel.NORMAL)
    @Test(priority = 1,groups = "CampaignTextPush")
    @Description("https://preprod.netmera.com/#/login adresine giriş yapılır.")
    public void LoginNetmera() throws InterruptedException {
        logger.info("LoginNetmera testi BAŞLADI.");
        tester();
        logger.info("LoginNetmera testi TAMAMLANDI.");
        Thread.sleep(2000);
    }

}