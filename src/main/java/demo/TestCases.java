package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
///


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

    public void testCaseHyperlink02()
    {
       System.out.println("Start Test case: testCase02");
       driver.get("https://in.bookmyshow.com/explore/home/chennai");
      // WebElement hyperlinks = driver.findElement(By.xpath("//body//a"));
       List<WebElement> hyperlinks= driver.findElements(By.xpath("//body//a"));
       System.out.println(hyperlinks.size());
       System.out.println("end Test case: testCase02");
    }


}
