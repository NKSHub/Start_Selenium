/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package demo;
import java.net.MalformedURLException;


public class App {
    public void getGreeting() throws Exception {
        TestCases tests = new TestCases(); // Initialize your test class

        //TODO: call your test case functions one after other here

       // tests.testCaseAmazonSearh01();
       //tests.testCaseHyperlink02();
       //tests.testCaseImageUrls();
         //tests.testCaseNestedFrame();
        // tests.testCaseImdbRatings();
         tests.testCaseWindowHandles();
        //END Tests


        //tests.endTest(); // End your test by clearning connections and closing browser
    }

    public static void main(String[] args) throws Exception {
        new App().getGreeting();
    }
}
