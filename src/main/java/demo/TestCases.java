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
    
    public void testCaseNestedFrame() throws InterruptedException
    {
         System.out.println("Start Test case: testCase04");
         driver.get("https://the-internet.herokuapp.com/nested_frames");
        
         driver.switchTo().frame("frame-top");
         Thread.sleep(3000);
         // Switch to frame "frame-left" Using Locator "Name" "frame-left"
         driver.switchTo().frame("frame-left");
         String lefttext = driver.findElement(By.xpath("//body[contains(text(),'LEFT')]")).getText();
         System.out.println(lefttext);
         // switch to  parent frame
         driver.switchTo().parentFrame();
         // switch to frame "frame-middle" 
         driver.switchTo().frame("frame-middle");
          String text2 = driver.findElement(By.xpath("//div[text()='MIDDLE']")).getText();
         System.out.println(text2);
         // switch to parent frame
         driver.switchTo().parentFrame();
         // switch to frame "frame-right" 
         driver.switchTo().frame("frame-right");
         String text3 = driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]")).getText();
         System.out.println(text3);
         driver.switchTo().defaultContent();
         // switch to frame "frame-right" 
         driver.switchTo().frame("frame-bottom");
         String text4 = driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]")).getText();
         System.out.println(text4);


    }

    public void testCaseImdbRatings() throws InterruptedException
    {
        System.out.println("Start Test case: testCase05");
        driver.get("https://www.imdb.com/chart/top/");
        Thread.sleep(3000); 
         //Select object for the sort dropdown
         Select sortDropdown = new Select(driver.findElement(By.id("sort-by-selector")));

         sortDropdown.selectByVisibleText("IMDb rating");
          // Find the highest rated movie Using Locator "XPath" "sort-by-selector" | Select | byVisbileText("IMDb rating")
        System.out.println(driver.findElement(By.xpath("//li[contains(@class,'ipc-metadata-list-summary-item')][1]//h3[@class='ipc-title__text'] ")).getText());
        Thread.sleep(5000);
        // Count the number of movies included in the table. Using Locator "XPath" //div[contains(@class,'cli-children')]//h3[@class='ipc-title__text'] | size()
        System.out.println(driver.findElements(By.xpath("//div[contains(@class,'cli-children')]//h3[@class='ipc-title__text']")).size());
        // Select "Release date" from the "Sort by" dropdown Using Locator "ID" "sort-by-selector" | Select | byVisbileText("Release date)
        sortDropdown.selectByVisibleText("Release date");
        // Click on the "swap sort order" button Using Locator "ID" "swap-sort-order-button" | click()
        driver.findElement(By.id("swap-sort-order-button")).click();
        // Find the oldest movie Using Locator "XPath" //li[contains(@class,'ipc-metadata-list-summary-item')][1]//[@class='ipc-title__text'] | getText()
        System.out.println(driver.findElement(By.xpath("//li[contains(@class,'ipc-metadata-list-summary-item')][1]//h3[@class='ipc-title__text'] ")).getText());
        // Click on the "swap sort order" button Using Locator "ID" "swap-sort-order-button" | click()
        driver.findElement(By.id("swap-sort-order-button")).click();
        // Find the newest movie Using Locator "XPath" //li[contains(@class,'ipc-metadata-list-summary-item')][1]//[@class='ipc-title__text'] | getText()
        System.out.println(driver.findElement(By.xpath("//li[contains(@class,'ipc-metadata-list-summary-item')][1]//h3[@class='ipc-title__text'] ")).getText());
        // Select "Number of ratings" from the "Sort by" dropdown Using Locator "ID" "sort-by-selector" | Select | byVisbileText("Number of ratings")
        sortDropdown.selectByVisibleText("Number of ratings");
        // Find the movie which has the most user ratings Using Locator "XPath" //li[contains(@class,'ipc-metadata-list-summary-item')][1]//[@class='ipc-title__text'] | getText()
        System.out.println(driver.findElement(By.xpath("//li[contains(@class,'ipc-metadata-list-summary-item')][1]//h3[@class='ipc-title__text'] ")).getText());
        System.out.println("end Test case: testCase05");
    }

}
