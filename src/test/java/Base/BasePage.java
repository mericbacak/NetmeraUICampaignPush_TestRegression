package Base;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.security.Key;
import java.time.Duration;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class BasePage {
    public WebDriver driver;
    public String homepage ="https://preprod.netmera.com/#/index/netmeratest/campaigns";
    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void SwitchWindows(String TabName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        //Store the ID of the original window
        String originalWindow = driver.getWindowHandle();
        //Wait for the new window or tab
        wait.until(numberOfWindowsToBe(2));
        //Loop through until we find a new window handle
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        //Wait for the new tab to finish loading content
        wait.until(titleIs(TabName));
    }

    public boolean ElementisDisplayed(By by){
        boolean disp;
        try {
            WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement element = waiter.until(ExpectedConditions.elementToBeClickable(by));
            disp =element.isDisplayed();
        }catch (Exception e){
            e.printStackTrace();
            driver.navigate().to(homepage);
            throw e;
        }
        return  disp;
    }
    public void clickBy(By by){
        try {
            WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement element = waiter.until(ExpectedConditions.presenceOfElementLocated(by));
            Actions actions = new Actions(driver);
            actions.moveToElement(element).click().perform();
        }catch (Exception e){
            e.printStackTrace();
            driver.navigate().to(homepage);
            throw e;
        }
    }

    public void SendKeysBy_WithEnter(By by, String text){
        try {
            WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement element = waiter.until(ExpectedConditions.visibilityOfElementLocated(by));
            element.click();
            element.sendKeys(text);
            element.sendKeys(Keys.ENTER);
        }catch (Exception e){
            e.printStackTrace();
            driver.navigate().to(homepage);
            throw e;
        }
    }

    public void SendKeysBy(By by, String text){
        try {
            WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement element = waiter.until(ExpectedConditions.presenceOfElementLocated(by));
            Actions actions = new Actions(driver);
            actions.moveToElement(element).click().perform();
            element.sendKeys(text);
        }catch (Exception e){
            e.printStackTrace();
            driver.navigate().to(homepage);
            throw e;
        }
    }

    public String GetVisibleTextBy(By by){
        try {
            WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(60));
            WebElement element = waiter.until(ExpectedConditions.presenceOfElementLocated(by));
            return element.getText();
        }catch (Exception e){
            e.printStackTrace();
            driver.navigate().to(homepage);
            throw e;
        }
    }

    public void ElementisExistBy(By by, String value){
        try {
            WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(60));
            WebElement element = waiter.until(ExpectedConditions.presenceOfElementLocated(by));
            element.isDisplayed();
            String elementText= element.getText();
            //System.out.println(elementText);
            Assert.assertTrue((elementText.contains(value)));
        }catch (Exception e){
            e.printStackTrace();
            driver.navigate().to(homepage);
            throw e;
        }
    }
    public void SelectByVisibleText(By by, String text){
        try {
            WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(60));
            WebElement element = waiter.until(ExpectedConditions.presenceOfElementLocated(by));
            Select select = new Select(element);
            select.selectByValue(text);
        }catch (Exception e){
            e.printStackTrace();
            driver.navigate().to(homepage);
            throw e;
        }
    }

    public void JSClickAndSendKeys(By by,String text){
        WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement element = waiter.until(ExpectedConditions.presenceOfElementLocated(by));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        element.sendKeys(text);
    }
    public void CustomLogin(String email,String password) throws InterruptedException {
        WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement element = waiter.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='email']")));
        element.sendKeys(Keys.TAB);
        Thread.sleep(2000);
        element.sendKeys(email);
        Thread.sleep(2000);
        element.sendKeys(Keys.TAB);
        Thread.sleep(2000);
        element.sendKeys(password);
        element.sendKeys(Keys.TAB);
        Thread.sleep(2000);
        element.sendKeys(Keys.SPACE);
        Thread.sleep(2000);
        element.sendKeys(Keys.TAB);
        Thread.sleep(2000);
        element.sendKeys(Keys.ENTER);
    }

    public void ScrollUp(String ScrollUPAmount) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        //Vertical scroll down by 600  pixels
        js.executeScript("window.scrollBy(0,"+ScrollUPAmount+")");
        Thread.sleep(1000);
    }
    public void ActionClick(By by){
        try {
            WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(60));
            WebElement element = waiter.until(ExpectedConditions.elementToBeClickable(by));
            Actions actions = new Actions(driver);
            actions.moveToElement(element).click().perform();
        }
        catch (Exception e){
            e.printStackTrace();
            driver.navigate().to(homepage);
            throw e;
        }
    }
}
