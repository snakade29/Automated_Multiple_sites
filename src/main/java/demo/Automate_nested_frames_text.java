package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Automate_nested_frames_text {

    ChromeDriver driver;

    public Automate_nested_frames_text() {
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

    public void nested_frames() {
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        driver.switchTo().frame(0);

        driver.switchTo().frame("frame-left");
        WebElement LeftEle = driver.findElement(By.xpath(" //body[contains(text(),'LEFT')]"));
        System.out.println(LeftEle.getText());
        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame-middle");
        WebElement MiddleEle = driver.findElement(By.tagName("body"));
        System.out.println(MiddleEle.getText());
        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame-right");
        WebElement RightEle = driver.findElement(By.tagName("body"));
        System.out.println(RightEle.getText());
        driver.switchTo().parentFrame();

        driver.switchTo().defaultContent();

        driver.switchTo().frame(1);
        WebElement BottomEle = driver.findElement(By.tagName("body"));
        System.out.println(BottomEle.getText());
    }

}
