package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class Automate_post_on_linkedin {
    ChromeDriver driver;

    public Automate_post_on_linkedin() {

        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void linkedinPost() throws InterruptedException, AWTException {

        // navigate to url url | https://in.linkedin.com/
        driver.get("https://www.linkedin.com/");

        // enter username or Email Using Locator "XPath" userName |
        // //input[@id='session_key'] | ""
        WebElement username = driver.findElement(By.xpath("//input[@id='session_key']"));
        // enter password Using Locator "XPath" password |
        // //input[@id='session_password'] | "*******"

        username.sendKeys("snakade29@gmail.com");
        WebElement password = driver.findElement(By.xpath("//input[@id='session_password']"));
        // click on login Using Locator "XPath" password |
        password.sendKeys("LeeCopper?123");
        // //input[@id='session_password'] | "*******"

        WebElement signin = driver.findElement(By.xpath(" //button[contains(text(),'Sign in')]        "));
        signin.click();
        Thread.sleep(3000);
        // click on name of user Using Locator "XPath" name | //div[text()='fouqia
        // zeba']
        driver.findElement(By.xpath("//div[text()='shubham Nakade']")).click();

        WebElement view = driver.findElement(By.xpath("//span[text()='0 profile views'][1]"));
        // find element profileviews Using Locator "XPath" profileviews |
        // //*[@id="ember493"]/div[3]/ul/li[1]/div/div[2]/div/a/div/div/div/div/span[1]
        // get text of profileviews profileviews.getText
        String profileviews = view.getText();
        // find searchAppearences and get text Using Locator "XPath" searchAppearence |
        // //*[@id="ember604"]/div[3]/ul/li[3]/div/div[2]/div/a/div/div/div/div/span[1]
        // searchAppearence.getText()
        System.out.println(profileviews);
        // find start post text area and enter a value Using Locator "XPath" startAPost
        // | //span[text()='Start a post']

        Thread.sleep(5000);

        driver.navigate().back();

        // click on post button Using Locator "XPath" post | //span[text()='Post']
        driver.findElement(By.xpath("//button[@aria-label='Add media']")).click();
        Thread.sleep(5000);
        // driver.findElement(By.xpath("//
        // *[@href='#image-medium']/../../../button")).click();

        // find message post successful and verify it is displayed or not Using Locator
        // "XPath" post | //*[text()='Post successful.']

        // post.isDisplayed()

        Robot robot = new Robot();
        StringSelection stringSelection = new StringSelection(
                "D:\\pexels-photo-2893685.webp");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        // Simulate keyboard shortcuts (Ctrl + V) to paste the file path into the file
        // input field
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        // Press Enter to confirm the file selection
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        // Some websites might require a delay after file upload for processing
        // You can adjust this delay based on your needs
        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[text()='Next']")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Post']")).click();
    }
}
