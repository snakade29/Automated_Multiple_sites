package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice.Argument;

public class Uploadfile {

    ChromeDriver driver;

    public Uploadfile() {
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

    public void fileupload() throws InterruptedException {
        driver.get("https://html.com/input-type-file/");

        Thread.sleep(4000);
        WebElement ele = driver.findElement(By.xpath(" //input[@id='fileupload']"));

        ele.sendKeys("D:\\pexels-photo-2893685.webp");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", ele);

        System.out.println("Succesfull");

        Thread.sleep(4000);

    }

}
