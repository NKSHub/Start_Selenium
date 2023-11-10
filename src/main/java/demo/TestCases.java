package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
///
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
       driver.quit();

    }

    
    // public  void testCaseAmazonSearh01() throws InterruptedException{
    //     System.out.println("Start Test case: testCase01");
    //     driver.get("https://www.google.com");
    //     WebElement searchbar= driver.findElement(By.id("APjFqb"));
    //     searchbar.click();
    //    // searchbar.click();
    //    Thread.sleep(1000);

    //     searchbar.sendKeys("Amazon");
    //     Thread.sleep(1000);
    //     searchbar.sendKeys(Keys.ENTER);
    //     Thread.sleep(3000);
    //     WebElement text =driver.findElement(By.xpath("//span[text()='Amazon.in']"));
    //     System.out.println(text.getText());
    //     text.isDisplayed();
    //     //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    //     System.out.println("end Test case: testCase01");
    // }

    public void testCaseHyperlink02() throws InterruptedException
    {
       System.out.println("Start Test case: testCase02");
       driver.navigate().to("https://in.bookmyshow.com/explore/home/chennai");
       Thread.sleep(2000);
      // WebElement hyperlinks = driver.findElement(By.xpath("//body//a"));
       List<WebElement> hyperlinks= driver.findElements(By.xpath("//body//a"));
       System.out.println(hyperlinks.size());
       System.out.println("end Test case: testCase02");
       
    }

    public void testCaseImageUrls() throws InterruptedException
    {
        System.out.println("Start Test case: testCase03");
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        Thread.sleep(5000);
        List<WebElement> imageURLList = driver.findElements(By.xpath("//h2[text()='Recommended Movies']/parent::div/parent::div/parent::div/following-sibling::div//img"));
        int len = imageURLList.size();
        for(int i=0;i<len;i++)
        {
            System.out.println(imageURLList.get(i).getAttribute("src"));
        }
    WebElement titleForSecondIteminPremier = driver.findElement(By.xpath("//h2[text()='Premieres']/parent::div/parent::div/parent::div/following-sibling::div/div/div/a[2]/div/div[3]/div[1]/div"));
    System.out.println(titleForSecondIteminPremier.getText());
    WebElement languageOfSecondIteminPremier = driver.findElement(By.xpath("//h2[text()='Premieres']/parent::div/parent::div/parent::div/following-sibling::div/div/div/a[2]/div/div[3]/div[2]/div"));
    System.out.println(languageOfSecondIteminPremier.getText());
    System.out.println("end Test case: testCase03");
    }


}
